package indocyber.DemoAbsensi.service.abstraction;

import indocyber.DemoAbsensi.dto.LeaveRequest.InsertLeaveRequestDTO;
import indocyber.DemoAbsensi.entity.LeaveRequest;

public interface LeaveRequestService {
    LeaveRequest leaveRequest(InsertLeaveRequestDTO dto);
}
