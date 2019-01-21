/**
 * Created by Redmal on 1/21/2019.
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
        int h3count = 0;
        int titleCount = 0;

        Document document = Jsoup.connect(url).get();

        Elements headers = document.select("h3");

        //get number of headers
        for (Element ele : headers){
            h3count += 1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a topic: ");
        String getUserTopic = scanner.nextLine();

        //filter headers that contain getUserTopic
        int numOfTitle = 0;
        GrabHeadersLoop: for (Element h3s : headers){
            if (h3s.text().contains(getUserTopic)) {
                System.out.println((numOfTitle + 1) + ": " + h3s.text());
                numOfTitle += 1;
            }

            titleCount += 1;
            if (titleCount == h3count){
                break GrabHeadersLoop;
            }
        }

    }
}
