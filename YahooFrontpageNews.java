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

        System.out.println("-----Yahoo Front Page Headlines for " + getUserTopic + "-----\n");

        //filter headers that contain getUserTopic
        int numOfTitle = 0;
        GrabHeadersLoop: for (Element h3s : headers){
            if (h3s.text().toLowerCase().contains(getUserTopic.toLowerCase())) {
                System.out.println((numOfTitle + 1) + ": " + h3s.text());
                numOfTitle += 1;
            }

            titleCount += 1;
            if (titleCount == h3count){
                break GrabHeadersLoop;
            }
        }
        System.out.println("\n");



        //get newest 5 tweets from Trump
        String twitterUrl = "https://twitter.com/realDonaldTrump";

        Document twitterDoc = Jsoup.connect(twitterUrl).get();

        Elements tweetTitles = twitterDoc.getElementsByClass("TweetTextSize");

        System.out.println("-----Most recent 5 tweets by President Trump-----\n");

        //filter headers that contain getUserTopic
        numOfTitle = 0;
        GrabTweetsLoop: for (Element tweet : tweetTitles){
            System.out.println((numOfTitle + 1) + ": " + tweet.text());

            numOfTitle += 1;
            if (numOfTitle == 5){
                break GrabTweetsLoop;
            }
        }


    }
}
