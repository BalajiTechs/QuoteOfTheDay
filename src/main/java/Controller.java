import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@RestController
public class Controller {

    QuoteList quoteList = new QuoteList();

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/todaysQuote")
    public String getQuoteOfTheDay()
    {
        LocalDate currentDate = LocalDate.now();

        int doy = currentDate.getDayOfYear();
//        System.out.println(doy);
        return  quoteList.getQuoteOfDay(doy);
    }
}