package by.htp.car_catalog.web.util;

import java.io.FileNotFoundException;

import by.htp.car_catalog.web.action.UploadedFile;

public class FileValidator {

    private FileValidator() {
    }

    public static void validate(Object uploadedFile) throws FileNotFoundException {

	UploadedFile file = (UploadedFile) uploadedFile;

	if (file.getFile().getSize() == 0) {

	    throw new FileNotFoundException();
	}
    }

}