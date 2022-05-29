package by.iba.repository.specification;

import by.iba.entity.customer.Role;
import by.iba.entity.customer.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class UserSpecification {

    public static Specification<User> hasUsername(String username) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get("username"), username);
    }

    public static Specification<User> hasEmail(String email) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get("email"), email);
    }

    public static Specification<User> hasFirstName(String firstName) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get("firstName"), firstName);
    }

    public static Specification<User> hasLastName(String lastName) {
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb)
                -> cb.equal(root.get("lastName"), lastName);
    }

    public static Specification<User> hasRoles(Set<Role> roles) {
        return (root, query, builder) -> {
            List<Predicate> predicates = buildPredicates(root, builder, roles);
            return
                    builder.or(predicates.toArray(new Predicate[0]));

        };
    }

    private static List<Predicate> buildPredicates(Root<User> root,
                                                   CriteriaBuilder criteriaBuilder,
                                                   Set<Role> roles) {
        List<Predicate> predicates = new ArrayList<>();
        roles.forEach(role -> predicates.add(
                criteriaBuilder.equal(
                        root.join("roles").get("typeOfRole"), role.getTypeOfRole())));
        return predicates;
    }
}
