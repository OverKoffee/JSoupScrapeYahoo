/**
 * Created by Redmal on 1/21/2019.
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
        int spanCount = 0;
        int titleCount = 0;

        Document document = Jsoup.connect(url).get();

        Elements headers = document.select("*");

        //get number of headers
        for (Element ele : headers){
            spanCount += 1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a topic: ");
        String getUserTopic = scanner.nextLine();

        System.out.println("-----Yahoo Front Page Headlines for " + getUserTopic + "-----\n\n");

        //filter headers that contain getUserTopic
        int numOfTitle = 0;
        GrabHeadersLoop: for (Element span : headers){
            if (span.text().toLowerCase().contains(getUserTopic.toLowerCase())) {
                System.out.println((numOfTitle + 1) + ": " + span.text());
                numOfTitle += 1;
            }

            titleCount += 1;
            if (titleCount == spanCount){
                break GrabHeadersLoop;
            }
        }
    }
}
