package by.iba.entity.sparepart;

import by.iba.entity.AbstractBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vendor_codes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendorCode extends AbstractBaseEntity {

    @Column(name = "item_number", nullable = false)
    private String itemNumber;
}
