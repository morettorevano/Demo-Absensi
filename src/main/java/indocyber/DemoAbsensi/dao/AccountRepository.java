package indocyber.DemoAbsensi.dao;

import indocyber.DemoAbsensi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
