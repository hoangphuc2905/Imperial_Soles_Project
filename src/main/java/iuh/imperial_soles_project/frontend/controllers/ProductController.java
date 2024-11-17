package iuh.imperial_soles_project.frontend.controllers;

import iuh.imperial_soles_project.backend.models.Product;
import iuh.imperial_soles_project.backend.models.Productvariant;
import iuh.imperial_soles_project.backend.repositories.ProductRepository;
import iuh.imperial_soles_project.backend.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductServices services;

    @Autowired
    private ProductRepository productRepository;

    // all products
    @GetMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products/list";
    }

    // add product
    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("image") String image,
                             @RequestParam("price") String priceStr,
                             @RequestParam("retailPrice") String retailPriceStr,
                             @RequestParam("description") String description,
                             @RequestParam("gender") String genderStr,
                             @RequestParam("brandID") String brandIDStr,
                             @RequestParam("categoryID") String categoryIDStr,
                             @RequestParam("supplierID") String supplierIDStr,
                             @RequestParam(value = "colors", required = false) String[] colors,
                             Model model) {

        if (colors == null || colors.length == 0) {
            model.addAttribute("error", "Please choose at least one color!");
            return "manager";
        }

        if (name.isEmpty() || image.isEmpty() || priceStr.isEmpty() || retailPriceStr.isEmpty() || genderStr.isEmpty()
                || brandIDStr.isEmpty() || categoryIDStr.isEmpty() || supplierIDStr.isEmpty()) {
            model.addAttribute("error", "Please fill all fields!");
            return "manager";
        }

        try {
            double price = Double.parseDouble(priceStr);
            double retailPrice = Double.parseDouble(retailPriceStr);
            int gender = Integer.parseInt(genderStr);
            int brandID = Integer.parseInt(brandIDStr);
            int categoryID = Integer.parseInt(categoryIDStr);
            int supplierID = Integer.parseInt(supplierIDStr);

            if (price <= 0 || retailPrice <= 0) {
                model.addAttribute("error", "Price must be greater than 0!");
                return "manager";
            }

            if (price > retailPrice) {
                model.addAttribute("error", "Price must be less than retail price!");
                return "manager";
            }

            String productID = "SP0001";
            Product productLast = services.getProductLast();
            if (productLast != null) {
                productID = "SP" + String.format("%04d", Integer.parseInt(productLast.getId().substring(2)) + 1);
            }

            services.addProduct(productID, name, image, price, retailPrice, description, categoryID, brandID, supplierID, gender);

            List<Productvariant> variants = new ArrayList<>();
            for (String color : colors) {
                String sizes = request.getParameter("size_" + color);
                if (sizes == null || sizes.isEmpty()) {
                    model.addAttribute("error", "Please fill all fields!");
                    return "manager";
                } else {
                    String[] sizeArray = sizes.split(",\\s*");
                    for (String size : sizeArray) {
                        String quantityStr = request.getParameter("quantity_" + color);
                        String image1 = request.getParameter("image1_" + color);
                        String image2 = request.getParameter("image2_" + color);
                        String image3 = request.getParameter("image3_" + color);
                        String image4 = request.getParameter("image4_" + color);

                        if (quantityStr == null || quantityStr.isEmpty() || image1 == null || image1.isEmpty() || image2 == null || image2.isEmpty() || image3 == null || image3.isEmpty() || image4 == null || image4.isEmpty()) {
                            model.addAttribute("error", "Please fill all fields!");
                            return "manager";
                        } else {
                            try {
                                int quantity = Integer.parseInt(quantityStr);
                                int sizeInt = Integer.parseInt(size);
                                if (quantity <= 0) {
                                    model.addAttribute("error", "Quantity must be greater than 0!");
                                    return "manager";
                                }
                                if (sizeInt <= 0) {
                                    model.addAttribute("error", "Size must be greater than 0!");
                                    return "manager";
                                }
                                Productvariant variant = new Productvariant();
                                variant.setProductID(services.getProductByID(productID));
                                variant.setColor(color);
                                variant.setSize(sizeInt);
                                variant.setQuantity(quantity);
                                variant.setImage1(image1);
                                variant.setImage2(image2);
                                variant.setImage3(image3);
                                variant.setImage4(image4);
                                variants.add(variant);

                                services.addProductVariant(variant);

                            } catch (Exception e) {
                                model.addAttribute("error", "Sai định dạng!");
                                return "manager";
                            }
                        }
                    }
                }
            }

            model.addAttribute("mess", "Product Added!");
            return "manager";

        } catch (Exception e) {
            model.addAttribute("error", "Sai định dạng!");
            return "manager";
        }
    }
}

