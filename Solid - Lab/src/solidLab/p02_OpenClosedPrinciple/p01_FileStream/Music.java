package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Music extends File{

    private String Artist;

    private String Album;

    public Music(String name, int length, int sent , String artist,String album) {
        super(name, length, sent);
        this.Artist = artist;
        this.Album = album;
    }

    public String getArtist() {
        return Artist;
    }

    public String getAlbum() {
        return this.Album;
    }


}
