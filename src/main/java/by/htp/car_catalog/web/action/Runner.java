package by.htp.car_catalog.web.action;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Runner {

    public static void main(String[] args) {
	BCryptPasswordEncoder coder = new BCryptPasswordEncoder();
	String code = coder.encode("moderator");
	System.out.println(code);

    }

}
