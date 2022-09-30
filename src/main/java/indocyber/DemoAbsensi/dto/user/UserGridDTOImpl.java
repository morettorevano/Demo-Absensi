package indocyber.DemoAbsensi.dto.user;

public class UserGridDTOImpl implements UserGridDTO{

    public String name;
    public String departement;
    public String unitLocation;
    public Boolean activeStatus;

    @Override
    public String name() {
        return name;
    }

    @Override
    public String departement() {
        return departement;
    }

    @Override
    public String unitLocation() {
        return unitLocation;
    }

    @Override
    public Boolean activeStatus() {
        return activeStatus;
    }
}
