public class Quote {

    private String message;
    private String author;

    public Quote(String message, String author)
    {
        this.author = author;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}
