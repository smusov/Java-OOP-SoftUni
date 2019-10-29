package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public abstract class File {

    private String name;
    private int length;
    private int sent;

    public File(String name, int length, int sent) {
        this.name = name;
        this.length = length;
        this.sent = sent;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSent() {
        return this.sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }
}
