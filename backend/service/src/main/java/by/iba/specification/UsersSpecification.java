package by.iba.specification;

import by.iba.dto.seacrhcriteria.UserSearchCriteria;
import by.iba.entity.customer.Role;
import by.iba.entity.customer.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

public final class UsersSpecification {

    public static Specification<User> getAllUsersByUsername(String username) {
        if (Objects.isNull(username) || username.isEmpty()) {
            return null;
        } else {
            return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), username));
        }
    }

    public static Specification<User> getAllUsersByFirstName(String firstName) {
        if (Objects.isNull(firstName) || firstName.isEmpty()) {
            return null;
        } else {
            return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("firstName"), firstName));
        }
    }

    public static Specification<User> getAllUsersByLastName(String lastName) {
        if (Objects.isNull(lastName) || lastName.isEmpty()) {
            return null;
        } else {
            return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("lastName"), lastName));
        }
    }

    public static Specification<User> getAllUsersByRoles(Set<Role> roles) {
        if (Objects.isNull(roles) || roles.isEmpty()) {
            return null;
        } else {
            return (root, query, builder) -> {
                List<Predicate> predicates = buildPredicates(root, builder, roles);
                return
                        builder.or(predicates.toArray(new Predicate[0]));

            };
        }
    }

    private static List<Predicate> buildPredicates(Root<User> root,
                                                   CriteriaBuilder criteriaBuilder,
                                                   Set<Role> roles) {
        List<Predicate> predicates = new ArrayList<>();
        roles.forEach(role -> predicates.add(
                criteriaBuilder.equal(
                        root.join("roles").get("typeOfRole"), role.getRoleType())));
        return predicates;
    }

    public static Specification<User> getSpecificationByCriteria(UserSearchCriteria searchCriteria, Set<Role> roles) {
        return Specification.where(
                        getAllUsersByUsername(searchCriteria.getUsername()))
                .or(getAllUsersByFirstName(searchCriteria.getFirstName()))
                .or(getAllUsersByLastName(searchCriteria.getLastName()))
                .or(getAllUsersByRoles(roles));
    }
}
