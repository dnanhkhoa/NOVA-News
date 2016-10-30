import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.json.*;


public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println(getNewsContentNYT("http://www.nytimes.com/reuters/2016/10/28/world/americas/28reuters-latinamerica-summit-venezuela.html"));
		//getCatInfoNYT("https://query.nytimes.com/svc/cse/v2/sitesearch.json?vertical=business&sort_order=d&page=1");
		//String[] info = getNewsInfoNYT("http://www.nytimes.com/aponline/2016/10/28/business/ap-us-earns-hershey.html");
		//System.out.println(info[0]);
		//System.out.println(info[1]);
		//System.out.println(info[2]);
		
		//getNewsNYT();
		getNewsVNE();
	}
	
	public static void getNewsNYT() {
		
		
		try {
			String queryLink = "https://query.nytimes.com/svc/cse/v2/sitesearch.json?vertical=%1s&sort_order=d";
			List<String> keywords = new ArrayList<String>();
			keywords.add("business");
			keywords.add("health");
			keywords.add("world");
			keywords.add("arts");
			keywords.add("Sports");
			keywords.add("technology");
			
			int numberPageCrawler = 5;

			
			new File("/dataNYT").mkdir();
			for (String keyword : keywords) {
				
				String link = String.format(queryLink, keyword);
				appendFile("/dataNYT/info.txt", MD5(keyword) + " " + keyword);
				
				List<String> a = getCatLink(link, numberPageCrawler);
				for (String e : a) {
					//System.out.println(e);
					String[] newsInfo = getNewsInfoNYT(e);
					String filePath = "/dataNYT/" + MD5(keyword) + "/" + MD5(newsInfo[2]);
					new File(filePath).mkdirs();
					
					writeFile(filePath + "/title.txt", newsInfo[0]);
					writeFile(filePath + "/content.txt", newsInfo[1]);
					writeFile(filePath + "/description.txt", newsInfo[3]);
					writeFile(filePath + "/link.txt", e);
					
					appendFile("/dataNYT/" + MD5(keyword) + "/info.txt", MD5(newsInfo[2]) + " " + newsInfo[2]);
					
					System.out.println(e);
				}
				
			}
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}		
	}
	
	public static List<String> getCatLink(String link, int page) {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < page; ++i) {
			ret.addAll(getCatLinkSingle(link + "&page=" + (i + 1)));
		}
		return ret;
	}
	
	public static List<String> getCatLinkSingle(String link) {
		List<String> ret = new ArrayList<String>();
		
		try {
			String html = getUrlSource(link);
			JSONObject obj = new JSONObject(html);
			JSONArray array = obj.getJSONObject("results").getJSONArray("results");
			
			for (int i = 0; i < array.length(); ++i) {
				JSONObject news = ((JSONObject)array.get(i));
				ret.add(news.getString("url"));
			}			
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ret;
	}
	
	public static String getUrlSource(String url) throws IOException {
        URL yahoo = new URL(url);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder a = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            a.append(inputLine);
        in.close();

        return a.toString();
    }
	
	public static String[] getNewsInfoNYT(String link) {
		String cssQueryNewsContent = "div.story-body > p";
		String[] ret = new String[4];
		try {
			Document doc = Jsoup.connect(link).get();
			Elements newsContent = doc.select(cssQueryNewsContent);
			Elements newsTitle = doc.select("h1#headline");
			ret[1] = newsContent.text();
			ret[0] = newsTitle.text();
			
			if (link.endsWith("/")) {
				link = link.substring(0, link.length() - 1);
				ret[2] = link.substring(link.lastIndexOf("/") + 1);
			} else {
				ret[2] = link.substring(link.lastIndexOf("/") + 1, link.length() - ".html".length());
			}
			
			ret[3] = doc.select("meta[name=description]").attr("content");
			
			return ret;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void getNewsVNE() throws IOException {
		String catUrlPrefix = "http://vnexpress.net/tin-tuc";
		
		List<String> newsPrefix = new ArrayList<String>();
		//newsPrefix.add("/the-gioi/");
		//newsPrefix.add("/thoi-su/");
		//newsPrefix.add("/phap-luat/");
		//newsPrefix.add("/giao-duc/");
		//newsPrefix.add("/khoa-hoc/");
		
		//newsPrefix.add("/giao-duc/");
		newsPrefix.add("/oto-xe-may/");
		newsPrefix.add("/cong-dong/");
		newsPrefix.add("/cong-dong/");
		
		
		int numberPageCrawler = 5;

		for (String e : newsPrefix) {
			appendFile("/dataVNE/info.txt", MD5(e) + " " + e);
			
			List<NovaNews> list = getNewsCatInfoVNE(catUrlPrefix, e, numberPageCrawler);
			System.out.println("number list: " + list.size());
			for (NovaNews news : list) {
				String filePath = "/dataVNE/" + MD5(e) + "/" + MD5(news.titleNews); 
				File file = new File(filePath);
				file.mkdirs();
				
				appendFile("/dataVNE/" + MD5(e) + "/info.txt", MD5(news.titleNews) + " " + news.titleNews);
				
				String [] newsInfo = getNewsContentVNE(news.newsUrl);
				if (newsInfo != null) {
					writeFile(filePath + "/title.txt", newsInfo[0]);
					writeFile(filePath + "/content.txt", newsInfo[1]);
					writeFile(filePath + "/description.txt", newsInfo[2]);
					writeFile(filePath + "/link.txt", news.newsUrl);
						
					System.out.println(newsInfo[0]);
				}
			}
		}
	}
	
	public static String[] getNewsContentVNE(String vneUrl) throws IOException {
		String cssQueryNewsTitle = "div.title_news > h1";
		String cssQueryNewsContent = "div.fck_detail > p.Normal";
		String cssQueryNewsDescription = "h3.short_intro";
		String cssQuerySignature ="text-align:right;";
		
		try {
			Document doc = Jsoup.connect(vneUrl).get();
			Elements newsHeadlines = doc.select(cssQueryNewsTitle);
			Elements newsContent = doc.select(cssQueryNewsContent);
			Elements newsDescription = doc.select(cssQueryNewsDescription);
			
			String content = "";
			
			for(int i = 0; i < newsContent.size(); ++i) {
				if (!newsContent.get(i).attr("style").equals(cssQuerySignature)) { 
					String text = newsContent.get(i).text();
					if (!text.startsWith("Xem thêm:") && !text.startsWith(">>Xem thêm:")) {
						content += (newsContent.get(i).text() + " ");
					}
				}
			}
			
			String[] ret = new String[3];
			ret[0] = newsHeadlines.text().trim(); //news title
			ret[1] = content; // news content
			ret[2] = newsDescription.text(); // news description
			return ret;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<NovaNews> getNewsCatInfoVNE(String catUrlPrefix, String catUrlPostfix) throws IOException {
		List<NovaNews> ret = new ArrayList<NovaNews>();
		
		Document catDoc = Jsoup.connect(catUrlPrefix + catUrlPostfix).get();
		Elements titleNewsElements = catDoc.select("h3.title_news > a");
		for (int i = 0; i < titleNewsElements.size(); ++i) {
			String newsUrl = titleNewsElements.get(i).attr("href");
			String[] newsUrlEle = newsUrl.split("/");
			
			NovaNews tmp = new NovaNews();
			//tmp.categoryName = catUrlPostfix;
			tmp.titleNews = newsUrlEle[newsUrlEle.length - 1].replace(".html", "");
			tmp.newsUrl = newsUrl;
			
			ret.add(tmp);
		}
		
		return ret;
	}
	
	public static List<NovaNews> getNewsCatInfoVNE(String catUrlPrefix, String catUrlPostfix, int numberPage) throws IOException {
		List<NovaNews> ret = new ArrayList<NovaNews>();
		
		for (int i = 0; i < numberPage; ++i) {
			//System.out.println(catUrlPrefix + catUrlPostfix + String.format("page/%1$d.html", i + 1));
			ret.addAll(getNewsCatInfoVNE(catUrlPrefix, catUrlPostfix + String.format("page/%1$d.html", i + 1)));
		}
		
		return ret;
	}
	
	public static void writeFile(String fileName, String content) {
		try{
		    PrintWriter writer = new PrintWriter(fileName, "UTF-8");
		    writer.print(content);
		    writer.close();
		} catch (Exception e) {
		   System.out.println(e.getMessage());
		}
	}
	
	public static void appendFile(String fileName, String content) {
		try {
			if(!content.endsWith("\n")) {
				content += "\n";
			}
			
			File f = new File(fileName);
			if(f.exists() && !f.isDirectory()) { 
			    // do something
				Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.APPEND);
			} else {
				writeFile(fileName, content);
			}
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
			System.out.println(e.getMessage());
		}
	}
	
	public static String MD5(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return "";
		}
}
