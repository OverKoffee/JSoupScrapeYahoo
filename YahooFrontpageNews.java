/**
 * Created by Redmal on 1/27/2019.
 * grabs the headlines off Yahoo front page
 * that contain the word/topic a user enters
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;


public class YahooFrontpageNews {

    public static void main(String[] args) throws IOException {
        String url = "https://www.yahoo.com/";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a news topic keyword: ");
        String getUserTopic = scanner.nextLine();

        System.out.println("-----Yahoo Front Page Headlines for " + getUserTopic + "-----\n\n");

        Document document = Jsoup.connect(url).get();
        Elements headers = document.getElementsByTag("span");

        int numOfTitle = 0;

        //get number of headers
        for (Element spanVar : headers) {
            if (spanVar.text().toLowerCase().contains(getUserTopic.toLowerCase())) {
                System.out.println((numOfTitle + 1) + ": " + spanVar.text());
                numOfTitle += 1;
            }
        }
    }
}
