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
    public static final String REQUEST_ERROR = "error";

    // Action command
    public static final String ACTION_NAME_MAIN = "main_action";
    public static final String ACTION_NAME_LOGIN = "login_action";
    public static final String ACTION_NAME_SIGNUP = "signup_action";
    public static final String ACTION_NAME_PROFILE = "profile_action";

    public static final String REDIRECT_TO = "redirect:";

    // Page user
    public static final String PAGE_USER_LOGIN = "user/login";
    public static final String PAGE_USER_SIGNUP = "user/signup";
    public static final String PAGE_USER_PROFILE = "user/profile";

    // Page car
    public static final String PAGE_CAR_BRANDS = "car/brands";
    public static final String PAGE_CAR_MODELS = "car/models";
    public static final String PAGE_CAR_VIEW = "car/car_view";

    // Page editor
    public static final String PAGE_CAR_EDITOR = "car_editor/editor";
    public static final String PAGE_CAR_MODEL_EDITOR = "car_editor/models_editor";
    public static final String PAGE_CARS_EDITOR = "car_editor/car_editor";

    public static final String PAGE_ERROR = "error";

    // Root path
    public static final String ROOT = "C:\\car_catalog";
    public static final String IMAGE_ROOT = "C:\\car_catalog\\image";
    public static final String NO_IMAGE = "C:\\car_catalog\\image\\default-no-image.png";

    private WebConstantDeclaration() {
    }
}
