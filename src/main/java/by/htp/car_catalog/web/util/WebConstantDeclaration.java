package by.htp.car_catalog.web.util;

public class WebConstantDeclaration {
	// Request command
	public static final String REQUEST_PARAM_ACTION = "action";

	// Action command
	public static final String REQUEST_PARAM_USER_LOGIN = "login";
	public static final String REQUEST_PARAM_USER_PASSWORD = "password";

	// Page command
	public static final String PAGE_USER_MAIN = "/WEB-INF/page/user/main.jsp";
	public static final String PAGE_USER_LOGIN = "/WEB-INF/page/user/login.jsp";
	public static final String PAGE_USER_SIGNUP = "/WEB-INF/page/user/signup.jsp";
	public static final String PAGE_USER_PROFILE = "/WEB-INF/page/user/profile.jsp";
	public static final String PAGE_USER_ERROR = "/WEB-INF/page/user/error.jsp";

	private WebConstantDeclaration() {
	}
}
