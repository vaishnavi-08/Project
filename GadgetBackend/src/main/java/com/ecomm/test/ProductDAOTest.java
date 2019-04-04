package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest 
{
	static ProductDAO productDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Samsung J7");
		product.setProductDesc("The Mobile with 4G and NFS Features");
		product.setStock(20);
		product.setCategoryId(3);
		product.setPrice(12000);
		product.setSupplierId(1);
		assertTrue("Pproblem in adding the Product",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(1);
		assertTrue("Problem in deleting product",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(2);
		product.setPrice(11000);
		product.setStock(15);
		assertTrue("Problem in updating product",productDAO.updateProduct(product));
	}
	@Test
	public void listCategoriesTest()
	{
		List<Product> listProducts=(List<Product>)productDAO.listProducts();
		assertTrue("Problem in retreiving the product",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.print(product.getProductName()+"  ");
			System.out.print(product.getProductName()+"  ");
			System.out.println(product.getStock()+"  ");
			System.out.println(product.getPrice()+"  ");
		}
	}

}
