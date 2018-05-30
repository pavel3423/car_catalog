package by.htp.car_catalog.dao.hbn;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import by.htp.car_catalog.domain.BrandCar;
import by.htp.car_catalog.domain.Car;
import by.htp.car_catalog.domain.Favorite;
import by.htp.car_catalog.domain.ModelCar;
import by.htp.car_catalog.domain.Role;
import by.htp.car_catalog.domain.User;

public class SessionFactoryManager {

    private static SessionFactory sessionFactory;

    private SessionFactoryManager() {
    }

    private static SessionFactory buildSessionFactory() {

	Configuration configuration = new Configuration();

	configuration.addAnnotatedClass(User.class);
	configuration.addAnnotatedClass(Role.class);
	configuration.addAnnotatedClass(ModelCar.class);
	configuration.addAnnotatedClass(Favorite.class);
	configuration.addAnnotatedClass(Car.class);
	configuration.addAnnotatedClass(BrandCar.class);

	configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
	configuration.setProperty("hibernate.connection.url",
		"jdbc:mysql://localhost:3306/car_catalog?serverTimezone=UTC");
	configuration.setProperty("hibernate.connection.username", "root");
	configuration.setProperty("hibernate.connection.password", "root");
	configuration.setProperty("hibernate.show_sql", "true");
	configuration.setProperty("hibernate.enable_lazy_load_no_trans", "true");
	configuration.setProperty("current_session_context_class", "thread");
	configuration.setProperty("hibernate.jdbc.serverTimezone", "UTC");
	configuration.setProperty("hibernate.connection.useSSL", "false");

	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		.applySettings(configuration.getProperties());

	return configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
	if (sessionFactory == null) {
	    sessionFactory = buildSessionFactory();
	}
	return sessionFactory;
    }

}
