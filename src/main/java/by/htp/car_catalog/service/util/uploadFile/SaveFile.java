package by.htp.car_catalog.service.util.uploadFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class SaveFile {

    public static String saveFile(UploadedFile uploadedFile, String name) throws IOException {

	MultipartFile file = uploadedFile.getFile();

	FileValidator.validate(uploadedFile);

	byte[] bytes = file.getBytes();

	String fileName = name + getFileExtension(file.getOriginalFilename());

	File dir = new File(uploadedFile.getPath());

	if (!dir.exists()) {
	    dir.mkdirs();
	}

	File loadFile = new File(dir.getAbsolutePath() + File.separator + fileName);
	try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile))) {
	    stream.write(bytes);
	    stream.flush();
	}

	return fileName;
    }

    private static String getFileExtension(String str) {
	int index = str.indexOf('.');
	return index == -1 ? null : str.substring(index);
    }

}
