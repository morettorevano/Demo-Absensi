package indocyber.DemoAbsensi.controller_rest;

import indocyber.DemoAbsensi.dto.user.RegisterUserDTO;
import indocyber.DemoAbsensi.dto.user.UserGridDTO;
import indocyber.DemoAbsensi.entity.Users;
import indocyber.DemoAbsensi.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerEmployee(@RequestBody RegisterUserDTO dto){
        Users user = userService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/index")
    public ResponseEntity<Page<UserGridDTO>>userGrid(@RequestParam(defaultValue = "1")Integer page,
                                           @RequestParam(defaultValue = "Active")String status){

        Pageable pageable = PageRequest.of(page-1,5, Sort.by("userId"));
        Page<UserGridDTO> grid = userService.getGrid(status,pageable);

        return new ResponseEntity<>(grid,HttpStatus.OK);
    }

    @PutMapping("/disableUser/{userId}")
    public ResponseEntity<Object>disableUser(@PathVariable Integer userId){

        Users user = userService.disableUser(userId);
        String message = String.format("user dengan ID %d berhasil di non-aktifkan", userId);
        return new  ResponseEntity<>(message,HttpStatus.OK);
    }
}
