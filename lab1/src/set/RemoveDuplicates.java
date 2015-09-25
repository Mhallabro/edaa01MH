package set;
import java.util.*;

public class RemoveDuplicates {
	public static int[] uniqueElements(int[] ints){
		Arrays.sort(ints);
		MaxSet<Integer> a = new MaxSet<Integer>();
		for(int i=0; i<ints.length; i++){
			a.add(ints[i]);
		}
		int [] b = new int[a.size()];
		int counter=0;
		for(int i: a){
			b[counter]=i;
			counter++;
		}
		return b;
	}
	public static void main(String[] args){
		int [] c = new int[7];
		c[0]=7;
		c[1]=5;
		c[2]=3;
		c[3]=5;
		c[4]=2;
		c[5]=2;
		c[6]=7;
		int [] d = uniqueElements(c);
		System.out.println(d.length);
		System.out.println(d[0]);
		System.out.println(d[1]);
		System.out.println(d[2]);
		System.out.println(d[3]);
	}
}
