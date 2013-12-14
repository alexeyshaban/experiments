package interview;

public class Entry<T> {
	T value;
	Entry<T> next;
	public Entry(T value, Entry<T> next) {
        this.value = value;
        this.next = next;
    }
	@Override
	public String toString() {
	    return "[" + value +  " ("+ next + ")]";
	}
	
}