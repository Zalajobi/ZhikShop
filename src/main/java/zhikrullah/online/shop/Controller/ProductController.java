package zhikrullah.online.shop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import zhikrullah.online.shop.Model.Product;
import zhikrullah.online.shop.Service.ProductService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    private String productImageUpload = new File("ProductImageUpload").getAbsolutePath();


    //run method on project start-up and create directory to store product Images
    @EventListener(ApplicationReadyEvent.class)
    private void createImageDirectory()
    {
        new File(productImageUpload).mkdir();
    }

    @RequestMapping(value = "addproduct", method = RequestMethod.GET)
    public String addProduct(Model model)
    {
        model.addAttribute("addProduct", new Product());
        return "addproduct";
    }


    //Save product
    @RequestMapping(value = "addproduct", method = RequestMethod.POST)
    public String addProduct(@Valid Product product, Errors errors, @RequestParam("files") MultipartFile[] multipartFiles)
    {
        StringBuilder imageNames = new StringBuilder();
        StringBuilder image = new StringBuilder();
        if (errors.hasErrors())
        {
            return "addproduct";
        } else {
            for (MultipartFile imageFile : multipartFiles)
            {
                Path fileNameAndPath = Paths.get(productImageUpload, imageFile.getOriginalFilename());
                imageNames.append(imageFile.getOriginalFilename());
                //set images to be send to the database
                image.append(imageFile.getOriginalFilename() + " @ ");
                try {
                    Files.write(fileNameAndPath, imageFile.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            product.setImage(image.toString());
            productService.addProduct(product);
            return "success";
        }
    }
}