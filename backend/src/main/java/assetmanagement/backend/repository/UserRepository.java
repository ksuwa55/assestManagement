package assetmanagement.backend.repository;

import assetmanagement.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository {
    Optional<User> findByUsername(String username);
}
