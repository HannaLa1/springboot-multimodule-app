package by.iba.entity.sparepart;

import by.iba.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spare_part_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SparePartCategory extends AbstractBaseEntity {

    @Column(name = "category", nullable = false)
    private String category;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private SparePartCategory parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private Set<SparePartCategory> children = new HashSet<>();
}
