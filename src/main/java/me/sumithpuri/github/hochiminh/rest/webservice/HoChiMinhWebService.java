package me.sumithpuri.github.hochiminh.rest.webservice;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.sumithpuri.github.hochiminh.rest.persistence.HoChiMinhPersistenceManager;
import me.sumithpuri.github.hochiminh.rest.vo.Product;

/**
 * MIT License
 *
 * Copyright (c) 2018-19,	Sumith Kumar Puri

 * GitHub URL 			https://github.com/sumithpuri
 * Blog Post URL		http://www.techilashots.com/2015/03/rest-using-apache-wink-xmljson.html
 * Blog Short URL		https://goo.gl/fSmu7c
 * Package Prefix 		me.sumithpuri.github.hochiminh
 * Project Codename		hochiminh
 * Contact E-Mail		code@sumithpuri.me
 * Contact WhatsApp		+91 9591497974
 *
 *
 * Permission is hereby  granted,  free  of  charge, to  any person  obtaining a  copy of  this  software and associated 
 * documentation files (the "Software"), to deal in the  Software without  restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sub-license and/or sell copies of the Software and to permit 
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in  all copies or substantial portions of the 
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES  OR  OTHER  LIABILITY, WHETHER IN AN ACTION  OF  CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
@Path("hochiminh")
public class HoChiMinhWebService {

	HoChiMinhPersistenceManager persistenceManager = HoChiMinhPersistenceManager.getInstance();
	
	static {
		
		System.out.println("Copyright (c) 2018-19,	Sumith Kumar Puri");
		System.out.println();
		System.out.println("Project Codename      HoChiMinh (REST Web Service)");
		System.out.println("Project Description   REST Using Apache Wink (XML/JSON) Demo Code");
		System.out.println("Technical Blog        http://www.techilashots.com");
		System.out.println("Technical Blog Post   https://goo.gl/fSmu7c");
		System.out.println("[Developer Notes]     [01] Use Java Version 9.0+ Compiler");
		System.out.println();
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProducts() {
		
		List<Product> products = persistenceManager.get();
		String productList = new String();
		
		for(Product producti: products) {
			productList+=producti.toString() + "\n";
		}
		
		// return as plain text - other types include xml, json
		return productList;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Product getProductById(@PathParam(value="id") long id) {
		Product product = persistenceManager.getProduct(id);
		return product;
	}
	
	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductJsonById(@PathParam(value="id") long id) {
		Product product = persistenceManager.getProduct(id);
		return product;
	}

	
	@POST
	public String addProducts(String productStr) {
		
		Product product = new Product();
		product.setName(productStr);
		persistenceManager.add(product);
		
		return productStr;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteProduct(@PathParam(value="id") long id) {
		
		persistenceManager.delete(id);
		return;
	}
	
	@PUT
	@Path("/{id}")
	public void modifyProduct(@PathParam(value="id") long id, String productName) {
		
		persistenceManager.update(id, productName);
		return;
	}
}
