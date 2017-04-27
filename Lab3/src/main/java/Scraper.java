import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created by schiduvasile on 4/27/17.
 */
public class Scraper {

    public static void main(String[] args) throws Exception {
        final Document document = Jsoup.connect("http://www.imdb.com/chart/top").get();

        for(Element row : document.select("table.chart.full-width tr")) {
            final String title = row.select(".titleColumn").text();
            final String rating = row.select(".imdbRating").text();

            System.out.println(title + " " + rating);

        }

    }
}
