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
public class Users {
    @Id
    @Column(name = "UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Departement")
    private String departement;

    @Column(name = "UnitLocation")
    private String unitLocation;

    @Column(name = "ActiveStatus")
    private Boolean activeStatus;

    @OneToOne //(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "AccountUsername")
    private Account account;

    public Users(String name, String departement, String unitLocation, Boolean activeStatus) {
        this.name = name;
        this.departement = departement;
        this.unitLocation = unitLocation;
        this.activeStatus = activeStatus;
    }
}
