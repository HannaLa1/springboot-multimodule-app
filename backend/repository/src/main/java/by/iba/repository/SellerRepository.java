package by.iba.repository;

import by.iba.entity.seller.SellerRating;
import by.iba.entity.sparepart.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<SparePart, Long> {
    @Query(value = "from SellerRating where user.id  = ?1")
    Optional<SellerRating> getSellerRatingById(Long id);
}
