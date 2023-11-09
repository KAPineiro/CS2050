public class Album {
    private static final String Default_Title = "Renaissance";
    private static final String Default_Performer = "Beyonce";
    private static final int Default_num_of_songs = 10;
    private static final String Default_Genre = "easy listening";

    private String title;
    private String performer;
    private String genre;
    private int numSongs;

    public Album() {
        this.title = Default_Title;
        this.performer = Default_Performer;
        this.genre = Default_Genre;
        this.numSongs = Default_num_of_songs;
    }

    public Album(String title, String performer, String genre, int numSongs) {
        this.title = title;
        this.performer = performer;
        setGenre(genre);
        setNumSongs(numSongs);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String Title)
    {
        this.title = title;
    }

    public String getPerformer()
    {
        return performer;
    }

    public void setPerformer(String Performer)
    {
        this.performer = performer;
    }

    public String getGenre()
    {
        return genre;
    }

    private boolean isValidGenre(String genre) {
        String[] validGenres = {"hip-hop", "easy listening", "orchestral", "your parents", "theatre"};
        for (String validGenre : validGenres) {
            if (validGenre.equalsIgnoreCase(genre)) {
                return true;
            }
        }
        return false;
    }

    public void setGenre(String genre) {
        if (isValidGenre(genre)) {
            this.genre = genre;
        } else {
            this.genre = Default_Genre;
        }
    }


    public int getNumSongs()
    {
        return numSongs;
    }

    public boolean isLong()
    {
        return numSongs > 50;
    }

    public void setNumSongs(int numSongs) {
        if (numSongs < 10) {
            this.numSongs = 10;
        } else {
            this.numSongs = numSongs;
        }
    }
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", performer='" + performer + '\'' +
                ", genre='" + genre + '\'' +
                ", numSongs=" + numSongs +
                '}';
    }
}

