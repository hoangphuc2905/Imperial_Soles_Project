package iuh.imperial_soles_project.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountID")
    private Account accountID;

    @Column(name = "date")
    private Instant date;

    @Column(name = "totalPrice")
    private Float totalPrice;

    @Size(max = 50)
    @Column(name = "customerName", length = 50)
    private String customerName;

    @Size(max = 10)
    @Column(name = "phoneNumber", length = 10)
    private String phoneNumber;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "invoiceID")
    private Set<Invoicedetail> invoicedetails = new LinkedHashSet<>();

}