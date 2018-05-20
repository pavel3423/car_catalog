package by.htp.car_catalog.web.action;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

@Controller
public class ImageViewAction {
    @RequestMapping("image/{param:.+}")
    @ResponseBody
    public HttpEntity<byte[]> getCarPhoto(@PathVariable("param") String param, HttpServletRequest req) {

	byte[] image = read(param);

	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.IMAGE_PNG);
	headers.setContentLength(image.length);
	return new HttpEntity<byte[]>(image, headers);
    }

    public byte[] read(String param) {

	String[] params = param.split("&");
	StringBuilder path = new StringBuilder(IMAGE_ROOT);

	for (String string : params) {
	    path.append("\\").append(string);
	}

	File fi = new File(path.toString());
	byte[] fileContent;
	try {
	    fileContent = Files.readAllBytes(fi.toPath());
	    return fileContent;
	} catch (IOException e) {

	    return null;
	}

    }
}
