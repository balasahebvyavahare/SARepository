package org.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Triangle t = new Triangle();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		//BeanFactory factory = new XmlBeanFactory ( new FileSystemResource("Spring.xml"));
		Triangle t = (Triangle) context.getBean("triangle");
		
		t.draw();
		
		
	}

}
