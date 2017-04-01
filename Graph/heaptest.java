import java.util.*;
 
class heaptest {
 
   private static int[] a;
   private static int n;
   private static int left;
   private static int right;
   private static int largest;
   
   public static void heapify(int[] a, int i) { 
      left = 2*i;
      right = 2*i+1;
 
      if(left <= n && a[left] > a[i]){
         largest=left;
      } else {
         largest=i;
      }
 
      if(right <= n && a[right] > a[largest]) {
         largest=right;
      }
      if(largest!=i) {
         swap(i, largest);
         heapify(a, largest);
      }
   }
 
   public static void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t; 
   }
 
 
   public static void buildheap(int []a) {
      n = a.length-1;
      for(int i=n/2; i>=0; i--){
         heapify(a,i);
      }
   }
 
   
 
   public static void sort(int[] myarray) {
      a = myarray;
      buildheap(a);
      for(int i=n; i>0; i--) {
         swap(0, i);
         n=n-1;
         heapify(a, 0);
      }
   }
 
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
      int numbers[]=new int[n];
	  for(int i=0;i<n;i++)
		  numbers[i]=sc.nextInt();
      sort(numbers);
	  for(int i=0;i<n;i++)
      System.out.print(numbers[i]+" ");
   }
}