package indocyber.DemoAbsensi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Account {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Role")
    private String role;

    @Column(name = "AccStatus")
    private Boolean accStatus;

    @OneToMany(mappedBy = "account")
    private List<AttendanceLog> attendanceList;

    public Account(String username, String password, String role, Boolean accStatus) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.accStatus = accStatus;
    }
}
