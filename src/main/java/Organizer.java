public class Organizer {
  private String mAlbum;
  private String mArtist;
  private String mGenre;

  public Organizer(String album, String artist, String genre) {
    mAlbum = album;
    mArtist = artist;
    mGenre = genre;
  }

  public String getAlbum(){
    return mAlbum;
  }

  public String getArtist(){
    return mArtist;
  }

  public String getGenre(){
    return mGenre;
  }
}
