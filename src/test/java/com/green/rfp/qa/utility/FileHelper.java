/*
 * package com.green.rfp.qa.utility; import java.io.BufferedInputStream; import
 * java.io.File; import java.io.FileInputStream; import
 * java.io.FileNotFoundException; import java.io.IOException; import
 * java.util.zip.ZipEntry; import java.util.zip.ZipOutputStream;
 * 
 * public class FileHelper { ConfigReader con =new ConfigReader();
 * 
 * // public static long PAGE_LOAD_TIMEOUT =
 * Integer.parseInt(con.getconfigdData("PAGE_LOAD_TIMEOUT"));
 * 
 * public static void zipDirectory(File folder, String parentFolder,
 * ZipOutputStream zos) throws FileNotFoundException, IOException { int
 * BUFFER_SIZE = 4096;
 * 
 * for (File file : folder.listFiles()) { if (file.isDirectory()) {
 * zipDirectory(file, parentFolder + "/" + file.getName(), zos); continue; }
 * zos.putNextEntry(new ZipEntry(parentFolder + "/" + file.getName()));
 * BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
 * long bytesRead = 0; byte[] bytesIn = new byte[BUFFER_SIZE]; int read = 0;
 * while ((read = bis.read(bytesIn)) != -1) { zos.write(bytesIn, 0, read);
 * bytesRead += read; } zos.closeEntry(); } }
 * 
 * 
 * }
 */

package com.green.rfp.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileHelper {

	static List<String> filesListInDir = new ArrayList<String>();

	public static void zipDirectory(File dir, String zipDirName) {
		try {
			populateFilesList(dir);

			FileOutputStream fos = new FileOutputStream(zipDirName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			for (String filePath : filesListInDir) {
				System.out.println("Zipping " + filePath);

				ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length() + 1, filePath.length()));
				zos.putNextEntry(ze);
				FileInputStream fis = new FileInputStream(filePath);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("test pass");
	}

	/**
	 * This method populates all the files in a directory to a List
	 * 
	 * @param dir
	 * @throws IOException
	 */
	private static void populateFilesList(File dir) throws IOException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isFile())
				filesListInDir.add(file.getAbsolutePath());
			else
				populateFilesList(file);
		}
	}

}