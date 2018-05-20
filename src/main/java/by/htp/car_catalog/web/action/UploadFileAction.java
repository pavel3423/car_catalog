package by.htp.car_catalog.web.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import by.htp.car_catalog.service.util.uploadFile.FileValidator;
import by.htp.car_catalog.service.util.uploadFile.UploadedFile;

@Controller
@SessionAttributes("filename")
public class UploadFileAction {

    private static final String ROOT_PATH = UploadFileAction.class.getProtectionDomain().getCodeSource().getLocation()
	    .getPath() + "\\resources\\image\\";

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView uploadFile(@ModelAttribute("uploadedFile") UploadedFile uploadedFile) {

	MultipartFile file = uploadedFile.getFile();

	try {
	    FileValidator.validate(uploadedFile);

	    byte[] bytes = file.getBytes();

	    String fileName = file.getOriginalFilename();

	    File dir = new File(ROOT_PATH + File.separator + "loadFiles");

	    if (!dir.exists()) {
		dir.mkdirs();
	    }

	    File loadFile = new File(dir.getAbsolutePath() + File.separator + fileName);

	    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
	    stream.write(bytes);
	    stream.flush();
	    stream.close();

	    RedirectView redirectView = new RedirectView("profile");
	    redirectView.setStatusCode(HttpStatus.FOUND);

	    return new ModelAndView(redirectView, "filename", fileName);
	} catch (IOException e) {
	    e.printStackTrace();
	    return new ModelAndView("error");
	}
    }

    @RequestMapping(value = "/fileuploaded", method = RequestMethod.GET)
    public String fileUploaded() {
	return "profile";
    }

}