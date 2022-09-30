package indocyber.DemoAbsensi.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AttendanceLog {

    @Id
    @Column(name = "LogId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;

    @Column(name = "Attendance")
    private String attendance;
    @Column(name = "AttendanceTime")
    private LocalDateTime attendTime;

//    @Column(name = "Logout")
//    private String logout;
//    @Column(name = "LogoutTime")
//    private LocalDateTime logoutTime;
//
//    @Column(name = "Status")
//    private String status;

    @ManyToOne
    @JoinColumn(name = "Username")
    private Account account;

    public AttendanceLog(String attendance, LocalDateTime attendTime, Account account) {
        this.attendance = attendance;
        this.attendTime = attendTime;
        this.account = account;
    }
}
