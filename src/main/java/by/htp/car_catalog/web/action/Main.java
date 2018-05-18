package by.htp.car_catalog.web.action;

public class Main {

    public static void main(String[] args) {

	String str = "BMW&X5";
	String[] param = str.split("&");
	for (String string : param) {
	    System.out.println(string);
	}

    }

}
