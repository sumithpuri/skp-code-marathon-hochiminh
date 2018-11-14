package me.sumithpuri.github.hochiminh.client;

import javax.ws.rs.core.MediaType;

import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

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
public class HoChiMinhRestClient {

	static String REST_WEB_SERVICE = "http://localhost:8080/hochiminh/rest/hochiminh";
	static ClientConfig clientConfig = new ClientConfig();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		try {

			HoChiMinhRestClient restClient = new HoChiMinhRestClient();

			System.out.println("Copyright (c) 2018-19,	Sumith Kumar Puri");
			System.out.println();
			System.out.println("Project Codename      HoChiMinh (REST Web Service Client)");
			System.out.println("Project Description   REST Using Apache Wink (XML/JSON) Demo Code");
			System.out.println("Technical Blog        http://www.techilashots.com");
			System.out.println("Technical Blog Post   https://goo.gl/fSmu7c");
			System.out.println("[Developer Notes]     [01] Use Java Version 9.0+ Compiler");
			System.out.println();

			restClient.configureClient();
			System.out.println();

			restClient.invokeGET();
			System.out.println();

			String product = "Sumith Puri" + (int) (Math.random() * 9999);
			restClient.invokePOST(product);

			System.out.println();
			product = "Sumith Puri" + (int) (Math.random() * 9999);
			restClient.invokePOST(product);

			System.out.println();
			product = "Sumith Puri" + (int) (Math.random() * 9999);
			restClient.invokePOST(product);

			System.out.println();
			product = "Sumith Puri" + (int) (Math.random() * 9999);
			restClient.invokePOST(product);

			System.out.println();
			restClient.invokeGET();

			System.out.println();
			restClient.invokeDELETE(2L);

			System.out.println();
			restClient.invokeGET();

			System.out.println();
			product = "Sumith Puri" + (int) (Math.random() * 9999);
			restClient.invokePOST(product);

			System.out.println();
			product = "Sumith Puri" + (int) (Math.random() * 9999);
			restClient.invokePOST(product);

			System.out.println();
			restClient.invokeDELETE(4L);

			System.out.println();
			restClient.invokeGET();

			System.out.println();
			restClient.invokePUT(3L, "Sumith Puri");

			System.out.println();
			restClient.invokeGET();
			
			System.out.println();
			restClient.invokeJSONGET(3);

			System.out.println();
			restClient.invokeJSONGET(2);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void configureClient() {

	}

	public void invokeGET() {

		System.out.println("Testing GET command....");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE);
		String response = resource.accept("text/plain").get(String.class);
		System.out.printf(response);
		System.out.println("...GET command is successful");
	}

	public void invokePOST(String product) {

		System.out.println("Testing POST command...");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE);
		resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).post(String.class, product);
		System.out.println("...POST command is successful");
	}

	public void invokePUT(Long id, String productName) {

		System.out.println("Testing PUT command...");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE + "/" + id);
		resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).put(String.class, productName);
		System.out.println("...PUT command is successful");
	}

	public void invokeDELETE(Long id) {

		System.out.println("Testing DELETE command...");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE + "/" + id);
		resource.contentType(MediaType.TEXT_PLAIN).accept(MediaType.TEXT_PLAIN).delete();
		System.out.println("...DELETE command is successful");
	}

	public void invokeJSONGET(long id) {
		System.out.println("Testing JSON GET command....");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE + "/json/" + id);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get();
		System.out.println("...JSON GET command is successful");
	}

	public void invokeJAXBGET(long id) {
		System.out.println("Testing JAXB GET command....");
		RestClient restClient = new RestClient(clientConfig);
		Resource resource = restClient.resource(REST_WEB_SERVICE + "/" + id);
		ClientResponse response = resource.accept(MediaType.APPLICATION_XML).get();
		System.out.println("...JAXB GET command is successful");
	}
}
