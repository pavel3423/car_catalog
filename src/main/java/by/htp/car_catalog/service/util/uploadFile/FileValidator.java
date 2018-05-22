package by.htp.car_catalog.service.util.uploadFile;

import java.io.FileNotFoundException;

public class FileValidator {

    private FileValidator() {
    }

    public static void validate(UploadedFile uploadedFile) throws FileNotFoundException {

	if (uploadedFile.getFile().getSize() == 0) {

	    throw new FileNotFoundException();
	}
    }

}