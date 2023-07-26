package com.green.rfp.qa.verifybrokenlink;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.green.rfp.qa.base.BaseClass;

public class VerifyLinks extends BaseClass {
	String regex = "https://" + env + ".thegreenrfp.com(.*)";

	@Test()
	public void verifyBrokenLinks() throws InterruptedException {

		loginValid();

		System.out.println("All Links Verification");
		Thread.sleep(5000);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());
		String link[] = new String[links.size()];
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			link[i] = element.getAttribute("href");
			verifyLink(link[i]);
		}
	}

	public void verifyLink(String urlLink) {

		if (urlLink.matches(regex)) {
			try {

				URL link = new URL(urlLink);
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.setConnectTimeout(2000);
				httpConn.connect();
				if (httpConn.getResponseCode() == 200) {
					testPassLog(urlLink + " - " + httpConn.getResponseMessage());
				} else {
					testFatalLog(urlLink + " - " + httpConn.getResponseMessage());
				}
			} catch (Exception e) {
			}
		}
	}

}
