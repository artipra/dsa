package stream;

public class DVDInfo {
    String title;
    String genre;
    String leadAction;

    public DVDInfo(String title, String genre, String leadAction) {
        this.title = title;
        this.genre = genre;
        this.leadAction = leadAction;
    }

    @Override
    public String toString() {
        return "DVDInfo{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", leadAction='" + leadAction + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLeadAction() {
        return leadAction;
    }

    public void setLeadAction(String leadAction) {
        this.leadAction = leadAction;
    }
}
