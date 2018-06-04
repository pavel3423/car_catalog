package by.htp.car_catalog.service.util.uploadFile;

import static by.htp.car_catalog.web.util.WebConstantDeclaration.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component(value = "fileEditor")
public class FileEditorImpl implements FileEditor {

    private FileEditorImpl() {
    }

    @Override
    public String saveFile(UploadedFile uploadedFile) throws IOException {

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

    @Override
    public boolean deleteFile(String image) {

	File file = new File(IMAGE_ROOT + image);
	if (file.exists()) {
	    return file.delete();
	}
	return false;
    }

    private String getFileExtension(String str) {
	String[] values = str.split("\\.");
	return "." + values[values.length - 1];
    }

    private long getGeneratedLong() {
	return Double.doubleToLongBits(Math.random());
    }
}
