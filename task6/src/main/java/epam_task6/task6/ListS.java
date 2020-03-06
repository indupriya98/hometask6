package epam_task6.task6;

import java.util.Arrays;
public class ListS<T> 
{
	int n=0;
	Object l[];
	public ListS() {
		l=new Object[10];
	}
	public void add(int x) {
		if(n==l.length) {
			increaseCapacity();
		}
		else {
			l[n++]=x;
		}
	}
	
	public T fetch(int y) {
		if(y<0 ||y>n) {
			throw new IndexOutOfBoundsException();
		}
		@SuppressWarnings("unchecked")
		T res=(T)l[y];
		return res;
		
	}
	public T remove(int y) {
		if(y<0 ||y>n) {
			throw new IndexOutOfBoundsException();
		}
		Object ans=l[y];
		int newsize=l.length-(y+1);
		System.arraycopy(l, y+1,l,y, newsize);
		n--;
		@SuppressWarnings("unchecked")
		T res=(T) ans;
		return res;
		
	}
	public int size() {
        return n;
    }
     
    public void display() 
    {
        if(n>0) {
        	System.out.printf("[");
        	for(int i=0;i<(n-1);i++) {
        		System.out.printf("%d",l[i]);
        		System.out.printf(",");
        	}
        	System.out.printf("%d]\n",l[n-1]);
        }
        else {
        	System.out.println("List is empty");
        }
    }
	
	public void increaseCapacity() {
		int updated_n = l.length * 2;
        l = Arrays.copyOf(l, updated_n);	
	}
}
