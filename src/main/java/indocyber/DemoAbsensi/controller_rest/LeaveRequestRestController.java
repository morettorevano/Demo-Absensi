package indocyber.DemoAbsensi.controller_rest;

import indocyber.DemoAbsensi.dao.LeaveRequestRepository;
import indocyber.DemoAbsensi.dto.LeaveRequest.InsertLeaveRequestDTO;
import indocyber.DemoAbsensi.entity.LeaveRequest;
import indocyber.DemoAbsensi.service.abstraction.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request")
public class LeaveRequestRestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/izin")
    public ResponseEntity<LeaveRequest>izin(@RequestBody InsertLeaveRequestDTO dto){

        LeaveRequest leaveRequest = leaveRequestService.leaveRequest(dto);
        return new ResponseEntity<>(leaveRequest, HttpStatus.CREATED);
    }

//    @PutMapping("pendingPermit")
}
