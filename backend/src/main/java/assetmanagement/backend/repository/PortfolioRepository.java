package assetmanagement.backend.repository;

import assetmanagement.backend.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    @Query("SELECT p.stockSymbol FROM Portfolio p WHERE p.userId = :userId")
    List<String> findStockSymbolsByUserId(@Param("userId") Long userId);

}
