package by.htp.car_catalog.web.action.car_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
@RequestMapping("/panel")
public class CarPanelControlAction {

    @RequestMapping(method = RequestMethod.GET)
    public String carPanel() {

	return PAGE_CAR_PANEL;
    }

}
