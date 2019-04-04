
package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.DAO.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest {
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(645);
		category.setCategoryName("Motorolla Mobile");
		category.setCategoryDesc("All smart mobile of Motorolla brand");
		assertTrue("Problem in adding Category",categoryDAO.addCategory(category));
	}
}
	