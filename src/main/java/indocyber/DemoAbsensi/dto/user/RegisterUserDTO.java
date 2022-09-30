package indocyber.DemoAbsensi.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
public class RegisterUserDTO {

    public String username;
    public String password;
    public String passwordConfirmation;
    public String name;
    public String departement;
    public String unitLocation;
    public Boolean activeStatus;

}
