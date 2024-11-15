package iuh.imperial_soles_project.backend.resources;

import iuh.imperial_soles_project.backend.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/vi/products")
public class ProductResources {
    @Autowired
    private ProductServices services;
}
