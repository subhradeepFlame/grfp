package com.green.rfp.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	File file;
	FileInputStream fis;
	static Properties pro;

	public ConfigReader() {

		try {
			file = new File(System.getProperty("user.dir") + "/config/config.properties");
			fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getEnv() {
		String env = null;
		env = System.getProperty("env");
		if (env == null || env.isEmpty()) {
			env = pro.getProperty("env");
		}
		return env;
	}

	public String getProtocol() {
		String protocol = pro.getProperty("protocol");
		return protocol;
	}

	public String getUrl() {
		String url = getProtocol() + getEnv() + pro.getProperty("Url");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("Username");
		return username;
	}

	public String getPassword() {
		String pass = pro.getProperty("Password");
		return pass;
	}

	public String getSuperAdminUsername() {
		String superAdminusername = pro.getProperty("superAdminUserName");
		return superAdminusername;

	}

	public String getSuperAdminPassword() {
		String superAdminpass = pro.getProperty("superAdminPassword");
		return superAdminpass;

	}

	public String getBrowser() {
		// TODO Auto-generated method stub
		return (pro.getProperty("browser"));
	}

	public String getconfigdData(String st) {
		// TODO Auto-generated method stub
		return (pro.getProperty(st));
	}

	public int getconfigdDataInt(String st) {
		// TODO Auto-generated method stub
		return Integer.parseInt(pro.getProperty(st));
	}

	public String getKisTemplateName() {
		// TODO Auto-generated method stub
		return pro.getProperty("kisTemplateNmae");
	}

	public String getRfpName() {
		// TODO Auto-generated method stub
		return (pro.getProperty("RfpName"));
	}

	public String getCommonPassword() {
		// TODO Auto-generated method stub
		return pro.getProperty("commonPassword");
	}

	public int getExplicitTime() {
		// TODO Auto-generated method stub
		return Integer.parseInt(pro.getProperty("explicitWaitTime"));
	}

	public String getEvaluatorRfpName(String status) {

		return pro.getProperty(getEnv() + "-" + "evaluaorRfp_" + status);
	};

	public String getReportRFP(String env) {

		return pro.getProperty(env + "reportRfp");

	}

	public void setKeyValue(String key, String value) {
		Properties props = new Properties();
		File f = file;
		try {
			final FileInputStream configStream = new FileInputStream(f);
			props.load(configStream);
			configStream.close();
			props.setProperty(key, value);
			final FileOutputStream output = new FileOutputStream(f);
			props.store(output, "");
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
