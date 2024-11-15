package iuh.imperial_soles_project.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "product")
public class Product {
    @Id
    @Size(max = 10)
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 500)
    @Column(name = "image", length = 500)
    private String image;

    @Column(name = "price")
    private Float price;

    @Column(name = "retailPrice")
    private Float retailPrice;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryID", nullable = false)
    private Category categoryID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brandID", nullable = false)
    private Brand brandID;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplierID", nullable = false)
    private Supplier supplierID;

    @Column(name = "gender")
    private Integer gender;

    @OneToMany(mappedBy = "productID")
    private Set<Productvariant> productvariants = new LinkedHashSet<>();

}