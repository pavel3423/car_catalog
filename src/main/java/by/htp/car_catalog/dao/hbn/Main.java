//package by.htp.car_catalog.dao.hbn;
//
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import by.htp.car_catalog.dao.BrandCarDao;
//import by.htp.car_catalog.dao.UserDao;
//import by.htp.car_catalog.domain.User;
//
//public class Main {
//
//	public static void main(String[] args) {
//
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/webapp-config.xml");
//		BrandCarDao dao = (BrandCarDao) applicationContext.getBean("brandDao");
//
//		List<User> users = dao.readAll();
//
//		for (User user : users) {
//			System.out.println(user);
//		}
//
//		User user = new User(0, "login", "email", "password", 2);
//		dao.create(user);
//		System.out.println(dao.read(3));
//		user.setLogin("newlogin");
//		dao.update(user);
//		System.out.println(dao.readAll());
//		dao.delete(4);
//		dao.delete(5);
//		System.out.println(dao.read(3));
//	}
//
//}
