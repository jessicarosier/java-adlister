import models.Album;
import models.Author;
import models.Quote;

import java.util.ArrayList;

public class BeansTest {

    public static void main(String[] args) {

        ArrayList<Quote> quotes = new ArrayList<>();

        Album maroon5Album = new Album();

        maroon5Album.setAlbumName("Songs About Jane");
        maroon5Album.setArtistName("Maroon 5");
        maroon5Album.setGenre("Pop");
        maroon5Album.setReleaseDate("2002-06-25");
        maroon5Album.setSales(10000000);

        Author Ghandi = new Author();
        Ghandi.setFirstName("Mohandas");
        Ghandi.setLastName("Ghandi");

        Author Goggins = new Author();
        Goggins.setFirstName("David");
        Goggins.setLastName("Goggins");

        Author Jobs = new Author();
        Jobs.setFirstName("Steve");
        Jobs.setLastName("Jobs");


        Quote firstQuote = new Quote();
        firstQuote.setContent("You must be the change you wish to see in the world.");
        firstQuote.setAuthor(Ghandi);

        Quote secondQuote = new Quote();
        secondQuote.setContent("You have to build calluses on your brain just like how you build calluses on your hands. Callus your mind through pain and suffering.");
        secondQuote.setAuthor(Goggins);

        Quote thirdQuote = new Quote();
        thirdQuote.setAuthor(Jobs);
        thirdQuote.setContent("Your time is limited, so don't waste it living someone else's life. Don't be trapped by dogma – which is living with the results of other people's thinking.");

        quotes.add(firstQuote);
        quotes.add(secondQuote);
        quotes.add(thirdQuote);

      quotes.forEach((quote -> {
          System.out.println(quote.getContent());
      }));

        System.out.println(Jobs.getFirstName());


    }
}
