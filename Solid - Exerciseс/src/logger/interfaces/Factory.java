package logger.interfaces;

public interface Factory<T> {
    T produce(String produceData);
}
