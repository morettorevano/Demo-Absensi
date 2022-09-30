package indocyber.DemoAbsensi.dao;

import indocyber.DemoAbsensi.dto.LeaveRequest.InsertLeaveRequestDTO;
import indocyber.DemoAbsensi.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Integer> {
}
