package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Main {
    public static void main(String[] args) {
        Music music = new Music("Music",3,99,"Dim4ou & ATS","Pileto vuv furnata");
        Progress progress = new Progress(music);
        progress.getCurrentPercent();
    }
}

