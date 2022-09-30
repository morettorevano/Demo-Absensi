package indocyber.DemoAbsensi.dao;

import indocyber.DemoAbsensi.dto.AttendanceLog.AttendanceLogGridDTO;
import indocyber.DemoAbsensi.entity.AttendanceLog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LogRepository extends JpaRepository<AttendanceLog,Integer> {

    @Query(nativeQuery = true,value = """
            SELECT  al.logId as logId,
             al.attendance as attendance,
              al.AttendanceTime as attendTime
             FROM AttendanceLog al   
             JOIN Account acc on acc.Username = al.Username
             WHERE acc.username = :username """)
    Page<AttendanceLogGridDTO> getLog(String username, Pageable pageable);
}
