package com.web.pizzaordering.services;

import com.web.pizzaordering.Exceptions.EntityNotFoundException;
import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.domain.ProductImage;
import com.web.pizzaordering.domain.types.ProductTypes;
import com.web.pizzaordering.repository.ProductImageRepository;
import com.web.pizzaordering.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public Product findById(Integer id) {
        Optional<Product> productOpt = productRepository.findById(id);

        if (!productOpt.isPresent()) {
            throw new EntityNotFoundException("Product not found");
        }
        return productOpt.get();
    }

    @Override
    public List<Product> loadAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> loadPizzas() {
        return productRepository.findByType(ProductTypes.PIZZA);
    }

    @Override
    public List<Product> loadDrinks() {
        return productRepository.findByType(ProductTypes.DRINK);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void saveImage(Integer productId, MultipartFile file) {
        try {
            Product product = productRepository.findById(productId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0; for (byte b : file.getBytes()){
                byteObjects[i++] = b; }

            ProductImage image = product.getImage();
            if (image == null) {
                image = new ProductImage();
            }

            image.setImage(byteObjects);
            product.setImage(image);
            image.setProduct(product);
            productRepository.save(product); }
        catch (IOException e) {
        }
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }
}
