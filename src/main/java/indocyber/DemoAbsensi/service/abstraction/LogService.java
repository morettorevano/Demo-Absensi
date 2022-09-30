package indocyber.DemoAbsensi.service.abstraction;

import indocyber.DemoAbsensi.dto.AttendanceLog.AttendanceLogGridDTO;
import indocyber.DemoAbsensi.entity.AttendanceLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LogService {
    AttendanceLog loginEmployee(String username);

    Page<AttendanceLogGridDTO> getLog(String username, Pageable pageable);

//    LoginLog logoutEmployee(String username);
}
