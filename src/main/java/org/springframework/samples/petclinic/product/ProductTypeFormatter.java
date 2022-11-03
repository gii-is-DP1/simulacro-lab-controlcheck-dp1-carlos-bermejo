package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	@Autowired
	private final ProductService pService;
	
	@Autowired
	public ProductTypeFormatter(ProductService ptService) {
		this.pService = ptService;
	}
	
    @Override
    public String print(ProductType pType, Locale locale) {
        return pType.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType pt = this.pService.getProductType(text);
        if(pt!=null) return pt;
        else throw new ParseException("type not found: "+ text, 0);
    }
    


}
