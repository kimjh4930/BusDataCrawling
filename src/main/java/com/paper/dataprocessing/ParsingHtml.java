package com.paper.dataprocessing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ParsingHtml {
	
	public String DownloadHtml(String strURL) {

		StringBuilder html = new StringBuilder();

		try {
			URL url = new URL(strURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			if (conn != null) {
				// Connection Timeout 5초
				conn.setConnectTimeout(5000);
				conn.setUseCaches(false);

				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "EUC-KR"));

					String line = "";

					while (true) {
						line = br.readLine();

						if (line == null)
							break;

						html.append(line + "\n");
					}

					br.close();
				}
				conn.disconnect();
			}
		} catch (Exception e) {
			DownloadHtml(strURL);
			//e.printStackTrace();
		}

		return html.toString();
	}

}
