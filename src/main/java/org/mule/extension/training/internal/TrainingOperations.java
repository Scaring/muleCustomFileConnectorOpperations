package org.mule.extension.training.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.File;

import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Example;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class TrainingOperations {
	
    @Parameter
    @Example("C:\\Users\\")
    @DisplayName("Local Path")
	private String LocalPath;
    
    @Parameter
    @Example("randomFile.txt")
    @DisplayName("File Name")
	private String fileName;
	
	@MediaType(value = ANY, strict = false)
	@Alias("FileExist")
	public boolean fileExist() {
		boolean res = false;

		try {
			File tempFile = new File(LocalPath + fileName);
			res = tempFile.exists();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
}
