package by.iba.repository;

import by.iba.entity.customer.User;
import by.iba.entity.seller.Seller;
import by.iba.entity.sparepart.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long>, JpaSpecificationExecutor<Seller> {

}
