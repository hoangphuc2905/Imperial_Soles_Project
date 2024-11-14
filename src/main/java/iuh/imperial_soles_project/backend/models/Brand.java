package iuh.imperial_soles_project.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bID", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "bName", length = 50)
    private String bName;

    @OneToMany(mappedBy = "brandID")
    private Set<Product> products = new LinkedHashSet<>();

}