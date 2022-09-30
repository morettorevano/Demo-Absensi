package indocyber.DemoAbsensi.dto.LeaveRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InsertLeaveRequestDTO {

    private String type;
    private String duration;
    private String reason;
}
