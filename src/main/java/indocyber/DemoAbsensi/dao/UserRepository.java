package indocyber.DemoAbsensi.dao;

import indocyber.DemoAbsensi.dto.user.UserGridDTO;
import indocyber.DemoAbsensi.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(nativeQuery = true,value = """
            SELECT usr.name as name,
                usr.departement as  departement,
                usr.unitLocation as unitLocation,
                usr.activeStatus as activeStatus
            FROM Users usr
            WHERE usr.activeStatus LIKE %:status%
            
            """)
    Page<UserGridDTO> getAllUser(String status, Pageable pageable);
}
