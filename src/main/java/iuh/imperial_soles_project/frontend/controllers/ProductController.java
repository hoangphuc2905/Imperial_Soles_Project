package iuh.imperial_soles_project.frontend.controllers;

import iuh.imperial_soles_project.backend.repositories.ProductRepository;
import iuh.imperial_soles_project.backend.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductServices services;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products/list";
    }
}
