package by.htp.car_catalog.service.util.uploadFile;

import java.io.IOException;

public interface FileEditor {
    String saveFile(UploadedFile uploadedFile) throws IOException;

    boolean deleteFile(String image);
}
