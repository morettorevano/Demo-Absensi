package indocyber.DemoAbsensi.dto.AttendanceLog;

import java.time.LocalDateTime;

public interface AttendanceLogGridDTO {
    public Integer logId();
    public String attendance();
    public LocalDateTime attendTime();

}
