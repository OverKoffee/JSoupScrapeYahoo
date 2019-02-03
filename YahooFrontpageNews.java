/**
 * Created by Redmal on 2/2/2019.
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a news topic keyword: ");
        String getUserTopic = scanner.nextLine();


        System.out.println("-----Yahoo Front Page Headlines for " + getUserTopic + "-----\n\n");


        Document document = Jsoup.connect("https://www.yahoo.com/").get();
        Elements headers = document.select("a[href]");

        int numOfTitle = 0;

        //get number of headers
        for (Element newsHeadline : headers) {
            if (newsHeadline.text().toLowerCase().contains(getUserTopic.toLowerCase())) {
                System.out.println((numOfTitle + 1) + ": " + newsHeadline.text());
                numOfTitle += 1;
            }
            else if (newsHeadline.text().contains(getUserTopic)){ //testing if somehow it grabs headlines somehow if conversion fails
                System.out.println((numOfTitle + 1) + "_Case: " + newsHeadline.text());
                numOfTitle += 1;
            }
        }
    }
}
