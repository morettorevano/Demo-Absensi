package indocyber.DemoAbsensi.service.implementation;

import indocyber.DemoAbsensi.dao.LeaveRequestRepository;
import indocyber.DemoAbsensi.dto.LeaveRequest.InsertLeaveRequestDTO;
import indocyber.DemoAbsensi.entity.LeaveRequest;
import indocyber.DemoAbsensi.service.abstraction.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Override
    public LeaveRequest leaveRequest(InsertLeaveRequestDTO dto) {
        LeaveRequest leaveRequest = new LeaveRequest(
                dto.getType(),
                dto.getDuration(),
                dto.getReason(),
                "pending"
        );
        leaveRequestRepository.save(leaveRequest);
        return leaveRequest;
    }
}
