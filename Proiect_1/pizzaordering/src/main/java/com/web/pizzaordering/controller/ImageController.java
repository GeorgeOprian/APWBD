package com.web.pizzaordering.controller;

import com.web.pizzaordering.domain.Product;
import com.web.pizzaordering.domain.ProductImage;
import com.web.pizzaordering.services.IProductService;
import com.web.pizzaordering.services.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product/getimage/{id}")
    public void downloadImage(@PathVariable String id, HttpServletResponse response) throws IOException {
        Product product = productService.findById(Integer.valueOf(id));
        if (product.getImage() != null) {
            ProductImage image = product.getImage();

            if (product.getImage().getImage() != null) {
                byte[] byteArray = new byte[image.getImage().length];
                int i = 0;
                for (Byte wrappedByte : image.getImage()) {
                    byteArray[i++] = wrappedByte;
                }
                response.setContentType("image/jpeg");
                InputStream is = new ByteArrayInputStream(byteArray);
                try {
                    IOUtils.copy(is, response.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
