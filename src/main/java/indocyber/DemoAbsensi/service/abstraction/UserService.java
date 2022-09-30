package indocyber.DemoAbsensi.service.abstraction;

import indocyber.DemoAbsensi.dto.user.RegisterUserDTO;
import indocyber.DemoAbsensi.dto.user.UserGridDTO;
import indocyber.DemoAbsensi.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Users register(RegisterUserDTO dto);

    Page<UserGridDTO> getGrid(String status, Pageable pageable);

    Users disableUser(Integer userId);


//    Users disableUser(Integer userId);
}
