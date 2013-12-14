package interview.collections;

public class Entry<T> {
	public T value;
	public Entry<T> next;

	public Entry(T value) {
        this.value = value;
    }
	
	public Entry(T value, Entry<T> next) {
        this.value = value;
        this.next = next;
    }
	
	public Entry<T> next(T value) {
		return this.next = new Entry<>(value);
	}
	
	@Override
	public String toString() {
	    return "[" + value +  " ("+ next + ")]";
	}
	
}