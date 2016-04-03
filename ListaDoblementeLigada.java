package estructuras.lineales;

import java.util.*;
import java.util.NoSuchElementException;
import java.util.Iterator;
import estructuras.*;

public class ListaDoblementeLigada<T> extends ColeccionAbstracta<T> implements List<T>{
	
	private static class NodoDL<T> {
		private NodoDL<T> anterior;
		private NodoDL<T> siguiente;
		private T dato;

		public NodoDL(T d) {
			dato = d;
		}

		public NodoDL(T d, NodoDL<T> a, NodoDL<T> s) {
			dato = d;
			anterior = a;
			siguiente = s;
		}
	}
	
	private NodoDL<T> head;
	private NodoDL<T> tail;
	private int tam = 0;

	public ListaDoblementeLigada() {}
	
	public boolean isEmpty(){
		return tam == 0;
	}

	public void add(int index,T element) {
		if(index < 0 || index > tam) throw new IllegalArgumentException();
		if(index == 0) addIni(element);
		if(index == tam) add(element);
		else {
			NodoDL<T> n = new NodoDL<T>(element);
			NodoDL<T> x = getNodo(index);
			x.anterior.siguiente = n;
			n.anterior = x.anterior;
			n.siguiente = x;
			x.anterior = n;
			tam++;
		}
	}
	
	/**
	 * Agrega un elemento a la lista. 
	 * @param elemt elemento a agregar.
	 * @return true si es que modificó la lista.
	 */
	public boolean add(T element){
		if(element == null) throw new IllegalArgumentException();
		NodoDL<T> n = new NodoDL<T>(element);
		if(isEmpty()){
			head = tail = n;
		}else {
			tail.siguiente = n;
			n.anterior = tail;
			tail = n;
		}
		tam++;
		return element != null;
	}

	private void addIni(T element) {
        if(element == null)
            throw new IllegalArgumentException();
        NodoDL<T> n = new NodoDL<T>(element);
        if(head != null){
            head.anterior = n;
            n.siguiente = head;
            head = n;
        }
        else head = tail = n;
        tam++;
    }

	/**
	 * Indica el numero de elementos de la lista.
	 * @return tamaño de la lista.
	 */
	public int size(){
		return tam;
	}

	/**
	 * Regresa el dato que almacena el Nodo en el indice que se pasa por parametro.
	 * @param index indice del elemento.
	 * @return el dato del nodo en el indice indicado.
	 */
	public T get(int index){
		if(index < 0 || index > tam) throw new IllegalArgumentException();
		NodoDL<T> tmp = head;
		return get(tmp, 0, index);
	}

	private T get(NodoDL<T> n, int i, int j) {
		return (i == j) ? n.dato : get(n.siguiente, i + 1, j);
	}

	private NodoDL<T> getNodo(int index) {
		if(index < 0 || index > tam) throw new IllegalArgumentException();
		NodoDL<T> tmp = head;
		return getNodo(tmp, 0, index);
	}

	private NodoDL<T> getNodo(NodoDL<T> n, int i, int j) {
		return (i == j) ? n : getNodo(n.siguiente, i + 1, j);
	}

	public List<T> subList(int fromIndex, int toIndex){
		return  null;
	}

	public ListIterator<T> listIterator(int index){
		return null;
	}

	public ListIterator<T> listIterator(){
		return null;
	}

	public int lastIndexOf(Object o){
		return 0;
	}

	public int indexOf(Object o){
		return 0;
	}

	public T remove(int index){
		return null;
	}


	public T set(int index,T element){
		T dat = get(index);
		//get(index) = element;
		return dat;
	}


	public boolean addAll(int index,Collection<? extends T> c){
		return false;
	}


	public Iterator<T> iterator(){
		return null;
	}
}