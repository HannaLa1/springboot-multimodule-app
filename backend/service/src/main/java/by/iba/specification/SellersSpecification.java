package by.iba.specification;

import by.iba.dto.seacrhcriteria.SellerSearchCriteria;
import by.iba.entity.seller.Seller;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class SellersSpecification {

    public static Specification<Seller> getAllSellersByFirstName(String firstName) {
        if (Objects.isNull(firstName) || firstName.isEmpty()) {
            return null;
        } else {
            return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), firstName));
        }
    }

    public static Specification<Seller> getAllSellersByLastName(String lastName) {
        if (Objects.isNull(lastName) || lastName.isEmpty()) {
            return null;
        } else {
            return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("lastName"), lastName));
        }
    }

    public static Specification<Seller> getAllSellersByRating(Double rating) {
        if (Objects.isNull(rating) || rating.toString().isEmpty()) {
            return null;
        } else {
            return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("rating"), rating));
        }
    }

    public static Specification<Seller> getSpecificationByCriteria(SellerSearchCriteria searchCriteria) {
        return Specification.where(
                        getAllSellersByFirstName(searchCriteria.getFirstName()))
                .or(getAllSellersByLastName(searchCriteria.getLastName()))
                .or(getAllSellersByRating(searchCriteria.getRating()));
    }
}
