package indocyber.DemoAbsensi.dto.AttendanceLog;

import java.time.LocalDateTime;

public class AttendanceLogGridDTOImpl implements AttendanceLogGridDTO{

    private Integer logId;
    private String attendance;
    private LocalDateTime attendTime;

    @Override
    public Integer logId() {
        return logId;
    }

    @Override
    public String attendance() {
        return attendance;
    }

    @Override
    public LocalDateTime attendTime() {
        return attendTime;
    }
}
