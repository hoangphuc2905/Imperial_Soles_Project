package iuh.imperial_soles_project.backend.services;

import iuh.imperial_soles_project.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;
}
