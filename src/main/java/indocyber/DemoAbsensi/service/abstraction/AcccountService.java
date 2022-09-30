package indocyber.DemoAbsensi.service.abstraction;

import indocyber.DemoAbsensi.dto.account.RegisterAdminDTO;
import indocyber.DemoAbsensi.entity.Account;

public interface AcccountService {
    void delete(String username);

    String getAccountRole(String username);

    Account registerAdmin(RegisterAdminDTO dto);
}
