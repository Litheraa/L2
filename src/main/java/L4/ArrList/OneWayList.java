package L4.ArrList;

public class OneWayList<T> implements Cloneable {

    private int length;
    private OneWayListItem<T> head;

    public OneWayList(T data) {
        head = new OneWayListItem<>(data);
        head.setNext(null);
        ++length;
    }

    private OneWayListItem<T> get(int index) {
        OneWayListItem<T> element = head;
        for (int i = 0; i < index; ++i) {
            element = element.getNext();
        }
        return element;
    }

    public int getLength() {
        return length;
    }

    public OneWayListItem<T> getHead() {
        return head;
    }

    public void setHead(OneWayListItem<T> head) {
        if (head == null) {
            throw new NullPointerException();
        }
        this.head = head;
    }

    public void setHead(T data) {
        if (data == null) {
            throw new NullPointerException();
        }
        head = new OneWayListItem<>(data, head.getNext());
    }

    public T getData() {
        return head.getData();
    }

    public T getData(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        OneWayListItem<T> element = head;
        for (int i = 0; i < index; ++i) {
            element = element.getNext();
        }
        return element.getData();
    }

    public T setData(T data, int index) {
        if (index >= getLength() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        OneWayListItem<T> element = get(index);
        T storage = element.getData();
        element.setData(data);
        return storage;
    }

    public void add(OneWayListItem<T> element) {
        if (element == null) {
            throw new NullPointerException();
        }
        element.setNext(head);
        head = element;
        ++length;
    }

    public void add(T data) {
        if (data == null) {
            throw new NullPointerException();
        }
        head = new OneWayListItem<>(data, head);
        ++length;
    }

    public void add(OneWayList<T> list) {
        get(length - 1).setNext(list.head);
        length += list.length;
    }

    public void add(OneWayListItem<T> element, int index) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (index > getLength() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        element.setNext(get(index));
        if (index == 0) {
            head = element;
        } else get(index - 1).setNext(element);
        ++length;
    }

    public void add(T data, int index) {
        if (data == null) {
            throw new NullPointerException();
        }
        if (index > getLength() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        OneWayListItem<T> element = new OneWayListItem<>(data, get(index));
        if (index == 0) {
            head = element;
        } else get(index - 1).setNext(element);
        ++length;
    }

    public T delete() {
        OneWayListItem<T> storage = head;
        head = head.getNext();
        --length;
        return storage.getData();
    }

    public boolean delete(T data) {
        if (head == null) {
            throw new NullPointerException();
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            --length;
            return true;
        }
        for (OneWayListItem<T> element = head; element.getNext() != null; element = element.getNext()) {
            if (element.getNext().getData().equals(data)) {
                element.setNext(element.getNext().getNext());
                --length;
                return true;
            }
        }
        return false;
    }

    public T delete(int index) {
        if (index > getLength() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        OneWayListItem<T> element = get(index);
        T storage = element.getData();
        if (index == 0) {
            head = element.getNext();
        } else {
            get(index - 1).setNext(element.getNext());
        }
        --length;
        return storage;
    }

    @Override
    public String toString() {
        if (head == null) {
            throw new NullPointerException();
        }
        OneWayListItem<T> element = head;
        StringBuilder toPrint = new StringBuilder(String.valueOf(element.getData()));
        while (element.getNext() != null) {
            element = element.getNext();
            toPrint.append(" ").append(element);
        }
        return toPrint.toString();
    }

    @Override
    public OneWayList<T> clone() {
        try {
            return (OneWayList<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void checker() {
        System.out.println("Length: " + getLength());
    }
}
