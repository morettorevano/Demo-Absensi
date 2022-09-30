package indocyber.DemoAbsensi.service.implementation;

import indocyber.DemoAbsensi.dao.AccountRepository;
import indocyber.DemoAbsensi.dao.UserRepository;
import indocyber.DemoAbsensi.dto.user.RegisterUserDTO;
import indocyber.DemoAbsensi.dto.user.UserGridDTO;
import indocyber.DemoAbsensi.entity.Account;
import indocyber.DemoAbsensi.entity.Users;
import indocyber.DemoAbsensi.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users register(RegisterUserDTO dto) {
        String hashPass = passwordEncoder.encode(dto.getPassword());
        Account account = new Account(
                dto.username,
                hashPass,
                "Employee",
                true
        );
        accountRepository.save(account);
        Users users = new Users(
                dto.name,
                dto.departement,
                dto.unitLocation,
                dto.activeStatus
        );
        users.setAccount(account);
        userRepository.save(users);

        return users;
    }

    @Override
    public Page<UserGridDTO> getGrid(String status, Pageable pageable) {
        Page<UserGridDTO>grid = userRepository.getAllUser(status,pageable);

        return grid;
    }

    @Override
    public Users disableUser(Integer userId) {
        Optional<Users> usersOptional = userRepository.findById(userId);
        Users users = null;
        if(usersOptional.isPresent()){
            users = usersOptional.get();
            users.setActiveStatus(false);
            userRepository.save(users);
        }
        String username = users.getAccount().getUsername();

        Optional<Account> accOptional = accountRepository.findById(username);
        Account account = null;
        if(accOptional.isPresent()){
            account = accOptional.get();
            account.setAccStatus(false);
            accountRepository.save(account);
        }

        return users;
    }


}
