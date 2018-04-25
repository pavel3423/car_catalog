package by.htp.car_catalog.web.action;

import org.springframework.web.context.WebApplicationContext;

public class ActionManagerContext {
	private ActionManagerContext() {
	}

	public static BaseAction getAction(String action, WebApplicationContext webApplicationContext) {
		return (BaseAction) webApplicationContext.getBean(action);
	}
}
