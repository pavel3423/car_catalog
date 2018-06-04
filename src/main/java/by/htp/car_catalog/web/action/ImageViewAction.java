package by.htp.car_catalog.web.action;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
public class ImageViewAction {
    @RequestMapping("image/{image:.+}")
    @ResponseBody
    public HttpEntity<byte[]> getCarPhoto(@PathVariable("image") String image, HttpServletRequest req) {

	byte[] imageByte = read(image);

	HttpHeaders headers = new HttpHeaders();
	headers.setContentLength(imageByte.length);
	return new HttpEntity<>(imageByte, headers);
    }

    public byte[] read(String image) {

	File fi = new File(IMAGE_ROOT + image);
	byte[] fileContent;
	try {
	    fileContent = Files.readAllBytes(fi.toPath());
	    return fileContent;
	} catch (IOException e) {
	    fileContent = noImage();
	    return fileContent;
	}
    }

    private byte[] noImage() {
	try {
	    return Files.readAllBytes(new File(NO_IMAGE).toPath());
	} catch (IOException e) {
	    LogManager.getLogger().error("Class ImageViewAction", e);
	    return new byte[0];
	}
    }
}
