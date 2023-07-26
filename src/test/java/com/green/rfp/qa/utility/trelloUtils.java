package com.green.rfp.qa.utility;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.json.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class trelloUtils {
	String boardId = "5bcdabe041b8462656bc9791";
	String ListID = "5c519b324dc9de079074ae11";
	String APIKey = "dd5cac6e478a844effb357bf36bbb3bd";
	String APIToken = "0b8b331968321020bcb1dd275786a0d81076fd573eef05cfcb6d36b18e2825bf";
	String automationLabelId = "624702b3c435586ef105a3a8";

	public static void main(String[] args) throws UnirestException, MalformedURLException, IOException {
		trelloUtils tu = new trelloUtils();
		String imgpath = "D://SeleniumAutomation//GRFP-Automation//Report//TestingReport-dashboard-20092022-11-08//screenshots//1.png";
	}

	public String addcard(String title, String desc) {
		com.mashape.unirest.http.HttpResponse<JsonNode> response;
		try {
			response = Unirest.post("https://api.trello.com/1/cards").header("Accept", "application/json")
					.queryString("idList", ListID).queryString("key", APIKey).queryString("token", APIToken)
					.queryString("pos", "top").queryString("name", title).queryString("desc", desc)
					.queryString("idLabels", automationLabelId).asJson();
			System.out.println("response : " + response.getBody());
			String cardId = new JSONObject(response.getBody()).getString("id");
			System.out.println(cardId);

			return new JSONObject(response.getBody()).getString("shortUrl");
		} catch (UnirestException e) {
			return null;
		}

	}

	public void addimage(String cardID, String img) {
		com.mashape.unirest.http.HttpResponse<JsonNode> response;
		try {
			response = Unirest.post("https://api.trello.com/1/cards/" + cardID + "/attachments/")
					.header("Accept", "application/json").queryString("key", APIKey).queryString("token", APIToken)
					.queryString("file", img).queryString("mimeType", "image/png").queryString("name", "testimg")
					.asJson();
			System.out.println("response : " + response.getBody());
		} catch (UnirestException e) {
		}
	}

	public void search() throws UnirestException {
		HttpResponse<String> board = Unirest.get("https://api.trello.com/1/cards/{5c6e814774b9471fa27ba08b}/board")
				.queryString("key", APIKey).queryString("token", APIToken).asString();

		System.out.println(board.getBody());

		HttpResponse<String> response = Unirest
				.get("https://api.trello.com/1/boards/{5c6e810ab77b0c20cee6e1cb}/cards/all").queryString("key", APIKey)
				.queryString("token", APIToken).asString();

		System.out.println(response.getBody());
	}

	public void getCardsOnAList() {
		HttpResponse<String> response = null;
		try {
			response = Unirest.get("https://api.trello.com/1/boards/" + boardId + "/lists")
					.header("Accept", "application/json").queryString("key", APIKey).queryString("token", APIToken)
					.asString();
			System.out.println(response.getBody());
		} catch (UnirestException e) {
			e.printStackTrace();
		}

		System.out.println(response.getBody());
	}

	public static String compressImg(String img) throws IOException {
		File input = new File(img);
		BufferedImage image = ImageIO.read(input);

		File compressedImageFile = new File(img);
		OutputStream os = new FileOutputStream(compressedImageFile);

		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
		ImageWriter writer = (ImageWriter) writers.next();

		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(0.05f); // Change the quality value you prefer
		writer.write(null, new IIOImage(image, null, null), param);

		os.close();
		ios.close();
		writer.dispose();
		return img;

	}

	public static String imgtobinary(String img) throws IOException {
		BufferedImage image = ImageIO.read(new File(img));

		ByteArrayOutputStream b = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", b);
		byte[] jpgByteArray = b.toByteArray();
		StringBuilder sb = new StringBuilder();
		for (byte by : jpgByteArray)
			sb.append(Integer.toBinaryString(by & 0xFF));

		return sb.toString();
	}

	public static String processImage(String infile) throws IOException {
		infile = infile.toLowerCase();
		Image image = Toolkit.getDefaultToolkit().getImage(infile);
		String str = "";

		try {

			String outfile = infile.replace(".jpg", ".txt");
			PrintWriter out = new PrintWriter(outfile);
			PixelGrabber grabber = new PixelGrabber(image, 0, 0, -1, -1, false);

			if (grabber.grabPixels()) {
				int width = grabber.getWidth();
				int heigth = grabber.getHeight();

				int[] data = (int[]) grabber.getPixels();
				int loopstatus = 1;
				String output;
				int threshold = 12500000;
				System.out.println(width);
				System.out.println(heigth);
				System.out.println(width * heigth);
				out.print("-");
				for (int i = 0; i < width * heigth; i++) {
					// white
					if (data[i] == 16777215) {
						output = "1";

					}
					// black
					else if (data[i] == 0) {
						output = "0";
					}
					// value that are not white/black.
					else if (data[i] < threshold) {
						output = "0";
					} else {
						output = "1";
					}
					out.print(output);
					if (width == (i + 1) / loopstatus) {
						out.println();
						loopstatus++;

					}

				}
				out.print("-");
			}
			out.print("-");

			out.close();

			str = readUsingScanner(outfile);
			System.out.println(str);
			System.out.println(str.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	private static String readUsingScanner(String fileName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
			// we can use Delimiter regex as "\\A", "\\Z" or "\\z"
			String data = scanner.useDelimiter("\\A").next();
			return data;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (scanner != null)
				scanner.close();
		}

	}
}
