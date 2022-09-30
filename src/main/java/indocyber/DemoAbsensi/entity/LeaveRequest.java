package indocyber.DemoAbsensi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class LeaveRequest {

    @Id
    @Column(name = "RequestId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestId;
    @Column(name = "Type")
    private String type;
    @Column(name= "duration")
    private String duration;
    @Column(name="Reason")
    private String reason;
    @Column(name = "Status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users users;

    public LeaveRequest(String type, String duration, String reason, String status) {
        this.type = type;
        this.duration = duration;
        this.reason = reason;
        this.status = status;
    }
}
