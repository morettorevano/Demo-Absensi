package indocyber.DemoAbsensi.service.implementation;

import indocyber.DemoAbsensi.dao.AccountRepository;
import indocyber.DemoAbsensi.dao.LogRepository;
import indocyber.DemoAbsensi.dto.AttendanceLog.AttendanceLogGridDTO;
import indocyber.DemoAbsensi.entity.Account;
import indocyber.DemoAbsensi.entity.AttendanceLog;

import indocyber.DemoAbsensi.service.abstraction.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AttendanceLog loginEmployee(String username) {
        Optional<Account> theAcc = accountRepository.findById(username);
        Account account = theAcc.get();

        AttendanceLog newLog = new AttendanceLog(
                "Login",
                LocalDateTime.now(),
                account
        );

        logRepository.save(newLog);
        return newLog;
    }

    @Override
    public Page<AttendanceLogGridDTO> getLog(String username, Pageable pageable) {
        Page<AttendanceLogGridDTO> gridDTOS =logRepository.getLog(username,pageable);
        return gridDTOS;
    }

//    @Override
//    public LoginLog logoutEmployee(String username) {
//        Optional<Account> theAcc = accountRepository.findById(username);
//        Account account = theAcc.get();
//        Optional<LoginLog> latestLog = loginLogRepository.latestLog(username);
//        LoginLog newLogout = latestLog.get();
//        newLogout.setLogout("LogOut");
//        newLogout.setLogoutTime(LocalDateTime.now());
//        newLogout.setStatus("Completed");
//
//        loginLogRepository.save(newLogout);
//        return newLogout;
//    }
}
