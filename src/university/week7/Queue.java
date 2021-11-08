package university.week7;

public interface Queue {
    boolean isEmpty();
    void enQueue(char item);
    char deQueue();
    void delete();
    char peek();
}