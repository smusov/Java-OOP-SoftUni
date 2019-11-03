package interfaces;

public interface File {
    boolean write();

    int getSize();

    void append(String text);
}
