package iuh.imperial_soles_project.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "invoicedetail")
public class Invoicedetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productVariantID")
    private Productvariant productVariantID;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "totalPrice")
    private Float totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceID")
    private Invoice invoiceID;

}