package indocyber.DemoAbsensi.service.implementation;

import indocyber.DemoAbsensi.ApplicationUserDetails;
import indocyber.DemoAbsensi.dao.AccountRepository;
import indocyber.DemoAbsensi.dto.account.RegisterAdminDTO;
import indocyber.DemoAbsensi.entity.Account;
import indocyber.DemoAbsensi.service.abstraction.AcccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AcccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOpt = accountRepository.findById(username);
        Account account =accountOpt.get();
        return new ApplicationUserDetails(account);
    }

    @Override
    public void delete(String username) {
        accountRepository.deleteById(username);
    }

    @Override
    public String getAccountRole(String username) {
        Optional<Account> theAccount =accountRepository.findById(username);
        Account account = theAccount.get();
        return account.getRole();
    }

    @Override
    public Account registerAdmin(RegisterAdminDTO dto) {
        String hashPass = passwordEncoder.encode(dto.getPassword());
        Account account = new Account(
                dto.getUsername(),
                hashPass,
                "Admin",
                true);
        accountRepository.save(account);
        return account;
    }
}
