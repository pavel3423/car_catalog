package by.htp.car_catalog.service.util.uploadFile;

import java.io.FileNotFoundException;

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