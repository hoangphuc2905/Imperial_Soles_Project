package iuh.imperial_soles_project.backend.services;

import iuh.imperial_soles_project.backend.connect.DBConnect;
import iuh.imperial_soles_project.backend.models.Product;
import iuh.imperial_soles_project.backend.repositories.BrandRepository;
import iuh.imperial_soles_project.backend.repositories.CategoryRepository;
import iuh.imperial_soles_project.backend.repositories.ProductRepository;
import iuh.imperial_soles_project.backend.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    // getProductLast
//    public Product getProductLast() {
//        Product product = new Product();
//        String sql = "SELECT TOP 1 * FROM Product ORDER BY id DESC";
//        try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                product.setId(rs.getString("id"));
//                product.setName(rs.getString("name"));
//                product.setImage(rs.getString("image"));
//                product.setPrice(rs.getDouble("price"));
//                product.setRetailPrice(rs.getDouble("retailPrice"));
//                product.setDescription(rs.getString("description"));
//                product.setCategoryID(categoryRepository.getCategoryByID(rs.getInt("categoryID")));
//                product.setBrandID(brandRepository.getBrandByID(rs.getInt("brandID")));
//                product.setSupplierID(supplierRepository.getSupplierByID(rs.getInt("supplierID")));
//                product.setGender(rs.getInt("gender"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
}
