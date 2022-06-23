package by.iba.entity.sparepart;

import by.iba.entity.FullAbstractEntity;
import by.iba.entity.customer.User;
import by.iba.entity.car.CarBrand;
import by.iba.entity.location.Location;
import by.iba.entity.price.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spare_parts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SparePart extends FullAbstractEntity {

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CarBrand> carBrands = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    private VendorCode vendorCode;

    @Column(name = "year_of_issue", nullable = false)
    private LocalDate yearOfIssue;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<SparePartCategory> sparePartCategories = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private Price price;

    @OneToOne(fetch = FetchType.LAZY)
    private Location location;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "spare_parts_deliveries",
            joinColumns = {
                    @JoinColumn(
                            name = "spare_part_id",
                            referencedColumnName = "id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "delivery_id",
                            referencedColumnName = "id")
            })
    private Set<Delivery> deliveries = new HashSet<>();

    @Column(name = "count_available", nullable = false)
    private Integer countAvailable;

    @OneToOne(fetch = FetchType.LAZY)
    private Image image;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();
}
