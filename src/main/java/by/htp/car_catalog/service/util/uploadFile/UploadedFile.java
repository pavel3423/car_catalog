package by.htp.car_catalog.service.util.uploadFile;

import org.springframework.web.multipart.MultipartFile;

public class UploadedFile {

    private MultipartFile file;
    private String path;

    public MultipartFile getFile() {
	return file;
    }

    public void setFile(MultipartFile file) {
	this.file = file;
    }

    public String getPath() {
	return path;
    }

    public void setPath(String path) {
	this.path = path;
    }

    public long length() {
	return this.file.getSize();
    }
}
