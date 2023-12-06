package assetmanagement.backend.repository;

import assetmanagement.backend.model.Portfolio;
import assetmanagement.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}
