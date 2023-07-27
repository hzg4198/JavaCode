package MyArrayList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<E> implements MyList,Iterable{
	private int size;
	final int DEFAULT_CAPACITY = 10;
	private Object[] elementdata;

	public MyArrayList() {
		this.size = DEFAULT_CAPACITY;
		elementdata = new Object[size];
	}

	public MyArrayList(int capacity){
		this.size = capacity;
		elementdata = new Object[size];
	}

	public void EnSureSize(int size){

	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(Object object) {
		elementdata[size] = object;
		size++;
		return true;
	}

	@Override
	public Object get(int index) {
		return elementdata[index];
	}

	@Override
	public boolean remove(int index) {
		return false;
	}

	@Override
	public void forEach() {

	}

	@Override
	public Iterator iterator() {
		return null;
	}

	@Override
	public void forEach(Consumer action) {
		Iterable.super.forEach(action);
	}

	@Override
	public Spliterator spliterator() {
		return Iterable.super.spliterator();
	}
}
