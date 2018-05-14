package by.htp.car_catalog.web.util;

public class WebConstantDeclaration {
    // Request command
    public static final String REQUEST_PARAM_ACTION = "action";
    public static final String REQUEST_PARAM_USER = "user";
    public static final String REQUEST_PARAM_ALL_BRANDS = "brands";
    public static final String REQUEST_PARAM_USER_LOGIN = "login";
    public static final String REQUEST_PARAM_USER_PASSWORD = "password";
    public static final String REQUEST_PARAM_USER_EMAIL = "email";
    public static final String REQUEST_PARAM_CAR_BRAND = "brand";
    public static final String REQUEST_PARAM_CAR_MODEL = "model";
    public static final String REQUEST_PARAM_CAR_MODELS = "models";
    public static final String REQUEST_PARAM_CARS = "cars";

    public static final String REQUEST_MSG = "msg";

    // Action command
    public static final String ACTION_NAME_MAIN = "main_action";
    public static final String ACTION_NAME_LOGIN = "login_action";
    public static final String ACTION_NAME_SIGNUP = "signup_action";
    public static final String ACTION_NAME_PROFILE = "profile_action";

    // Page command
    public static final String REDIRECT_TO = "redirect:";

    public static final String PAGE_INDEX = "user/index";
    public static final String PAGE_USER_LOGIN = "user/login";
    public static final String PAGE_USER_SIGNUP = "user/signup";
    public static final String PAGE_USER_PROFILE = "user/profile";
    public static final String PAGE_CAR_MODELS = "car/models";
    public static final String PAGE_CAR_VIEW = "car/carView";

    public static final String PAGE_USER_ERROR = "user/error";

    private WebConstantDeclaration() {
    }
}
