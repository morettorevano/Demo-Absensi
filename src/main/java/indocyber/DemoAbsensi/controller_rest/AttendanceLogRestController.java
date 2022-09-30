package indocyber.DemoAbsensi.controller_rest;

import indocyber.DemoAbsensi.dto.AttendanceLog.AttendanceLogGridDTO;
import indocyber.DemoAbsensi.entity.AttendanceLog;
import indocyber.DemoAbsensi.service.abstraction.LogService;
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
@RequestMapping("/api/attendanceLog")
public class AttendanceLogRestController {

    @Autowired
    private LogService logService;

    @PostMapping("/attendance")
    public ResponseEntity<Object> loginEmployee(Authentication authentication){

        String username = authentication.getName();
        AttendanceLog loginEmployee = logService.loginEmployee(username);
        String message = ("Login anda berhasil");
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

//    @PutMapping("/logout")
//    public ResponseEntity<Object>logoutEmployee(Authentication authentication){
//
//        String username = authentication.getName();
//        LoginLog logoutEmployee = loginLogService.logoutEmployee(username);
//        String message =
//    }

    @GetMapping("/log")
    public ResponseEntity<Page<AttendanceLogGridDTO>>logList(Authentication authentication,
                                                             @RequestParam(defaultValue = "1")Integer page){

        String username = authentication.getName();
        Pageable pageable = PageRequest.of(page-1,5, Sort.by("logId"));
        Page<AttendanceLogGridDTO> grid = logService.getLog(username,pageable);
        return new ResponseEntity<>(grid,HttpStatus.OK);
    }

}
