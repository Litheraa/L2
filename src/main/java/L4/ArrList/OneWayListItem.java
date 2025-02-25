package L4.ArrList;

public class OneWayListItem<T> implements Cloneable {
    private T data;
    private OneWayListItem<T> next;

    public OneWayListItem(T data) {
        this.data = data;
    }

    public OneWayListItem(T data, OneWayListItem<T> next) {
        this(data);
        this.next = next;
    }

    public void setNext(OneWayListItem<T> next) {
        this.next = next;
    }

    public OneWayListItem<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    @Override
    public OneWayListItem<T> clone() {
        try {
	        return (OneWayListItem<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    @Override
    public String toString() {
        return this.getData().toString();
    }
}
