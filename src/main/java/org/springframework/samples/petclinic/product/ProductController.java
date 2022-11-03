package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";

    private ProductService productService;
    
    @Autowired
    public ProductController(ProductService pService) {
    	this.productService = pService;
    }
    
	@GetMapping("/create")
	public String initCreationForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		model.put("productTypes", productService.findAllProductTypes());
		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.productService.save(product);
			return "redirect:/products/" + product.getId();
		}
	}
}
