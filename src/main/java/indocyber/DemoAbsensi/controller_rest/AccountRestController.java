package indocyber.DemoAbsensi.controller_rest;

import indocyber.DemoAbsensi.dto.account.RegisterAdminDTO;
import indocyber.DemoAbsensi.dto.account.RequestTokenDTO;
import indocyber.DemoAbsensi.dto.account.ResponseTokenDTO;
import indocyber.DemoAbsensi.entity.Account;
import indocyber.DemoAbsensi.service.abstraction.AcccountService;
import indocyber.DemoAbsensi.utility.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    @Autowired
    private AcccountService acccountService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseTokenDTO post(@RequestBody RequestTokenDTO dto){

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword());

            Authentication authentication = authenticationManager.authenticate(token);
            System.out.println("Is authenticate: " + authentication.isAuthenticated());
            System.out.println("Principal: " + authentication.getPrincipal());
            System.out.println("Credential: " + authentication.getCredentials());
        }catch (Exception exception){
            System.out.println("Can not authenticate!");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can not authenticate", exception);
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
        System.out.println("userDetails: " + userDetails.getUsername() + ", " + userDetails.getPassword());

        String role = acccountService.getAccountRole(dto.getUsername());
        String token = jwtToken.generateToken(dto.getSubject(),dto.getUsername(), dto.getSecretKey(), role, dto.getAudience());
        ResponseTokenDTO response = new ResponseTokenDTO(dto.getUsername(), role, token);

        return response;
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<Object> registerAdmin(@RequestBody RegisterAdminDTO dto){
        Account account = acccountService.registerAdmin(dto);
        return new ResponseEntity<>(account,HttpStatus.CREATED);
    }

}
