package me.sumithpuri.github.hochiminh.rest.persistence;


import java.util.ArrayList;
import java.util.List;

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
public class HoChiMinhPersistenceManager {

	private List<Product> productDatabase = new ArrayList<Product>();
	private static HoChiMinhPersistenceManager persistenceManager;
	private static int id=0;
	
	private HoChiMinhPersistenceManager() {
		
	}
	
	public Product getProduct(long productId) {
		
		System.out.println("Database: Retrieving Product " + productId);
		Product product = null;
		boolean found = false;
		for(int i=0;i<productDatabase.size();i++) {
			
			product = productDatabase.get(i);
			if(product.getId()==productId) {
				found = true;
				break;
			}
		}
		if(!found) product=null;
		return product;
	}
	
	public void add(Product product) {
		
		System.out.println("Database: Added One Product");
		
		// atomic id creation
		id++;
		product.setId(id);
		productDatabase.add(product);
	}
	
	public List<Product> get() {
		System.out.println("Database: Retrieved All Products");
		return productDatabase;
	}
	
	public void update(long productId, String productName) {
		System.out.println("Database: Modified One Product");
		
		for(int i=0;i<productDatabase.size();i++) {
			
			Product product = productDatabase.get(i);
			if(product.getId()==productId) {
				product.setName(productName);
				productDatabase.remove(i);
				productDatabase.add(i,product);
			}
		}
		return;
	}
	
	public void delete(long productId) {
		System.out.println("Database: Deleted One Product");
		
		for(int i=0;i<productDatabase.size();i++) {
			
			Product product = productDatabase.get(i);
			if(product.getId()==productId) productDatabase.remove(i);
		}
		return;
	}
	
	public static HoChiMinhPersistenceManager getInstance() {
		
		if(persistenceManager==null) {
			synchronized(HoChiMinhPersistenceManager.class) {
				if(persistenceManager==null) {
					persistenceManager = new HoChiMinhPersistenceManager();
				}
			}
		}
		return persistenceManager;
	}
}
