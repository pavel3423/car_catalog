package by.htp.car_catalog.service.util.uploadFile;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileEditor {

    private FileEditor() {
    }

    public static String saveFile(UploadedFile uploadedFile) throws IOException {

	MultipartFile file = uploadedFile.getFile();
	FileValidator.validate(uploadedFile);
	byte[] bytes = file.getBytes();
	String fileName = getGeneratedLong() + getFileExtension(file.getOriginalFilename());
	File loadFile = new File(IMAGE_ROOT + fileName);

	if (!loadFile.exists()) {

	    try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile))) {
		stream.write(bytes);
		stream.flush();
	    }
	    return fileName;
	} else {
	    return saveFile(uploadedFile);
	}
    }

    public static boolean deleteFile(String image) {

	File file = new File(IMAGE_ROOT + image);
	if (file.exists()) {
	    return file.delete();
	}
	return false;
    }

    private static String getFileExtension(String str) {
	int index = str.indexOf('.');
	return index == -1 ? null : str.substring(index);
    }

    private static long getGeneratedLong() {
	return Double.doubleToLongBits(Math.random());
    }

}
