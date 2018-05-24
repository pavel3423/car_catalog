package by.htp.car_catalog.service.util.uploadFile;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
	try {
	    FileEditor.deletePackage("Tesla");
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
