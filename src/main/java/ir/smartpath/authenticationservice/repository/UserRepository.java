package ir.smartpath.authenticationservice.repository;

import java.util.Optional;

import ir.smartpath.authenticationservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findById(long id);

    @Query(value = "SELECT * FROM users  WHERE number = ?1", nativeQuery = true)
    User findByNumber(String number);

    @Modifying
    @Transactional
    @Query(value = "UPDATE  users set otp = ?1  WHERE id = ?2", nativeQuery = true)
    void updateOtp(long id, int otp);



//    void updateOtp(int otp);
}
