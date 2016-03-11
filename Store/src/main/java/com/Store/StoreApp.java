package com.Store;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Store.dao.FindDao;
import com.Store.pojo.Producto;

public class StoreApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring_config.xml");

		FindDao findDao = (FindDao) applicationContext.getBean("findDao");
		
		List<Producto> marca = findDao.Marca();
		
		System.out.println(marca.get(0));
		
		
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

}
