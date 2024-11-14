package iuh.imperial_soles_project.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "productvariant")
public class Productvariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productID", nullable = false)
    private Product productID;

    @Column(name = "size")
    private Integer size;

    @Size(max = 50)
    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "quantity")
    private Integer quantity;

    @ColumnDefault("0")
    @Column(name = "soldQuantity")
    private Integer soldQuantity;

    @Size(max = 500)
    @Column(name = "image1", length = 500)
    private String image1;

    @Size(max = 500)
    @Column(name = "image2", length = 500)
    private String image2;

    @Size(max = 500)
    @Column(name = "image3", length = 500)
    private String image3;

    @Size(max = 500)
    @Column(name = "image4", length = 500)
    private String image4;

    @OneToMany(mappedBy = "productVariantID")
    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "productVariantID")
    private Set<Invoicedetail> invoicedetails = new LinkedHashSet<>();

}