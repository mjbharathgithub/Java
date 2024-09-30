import java.util.*;
public class Main
{
    
    static void insertionSort(int arr[]){
        
        
        for(int i=1;i<arr.length;i++){
            int presentElement=arr[i];
            int prevIndex=i-1;
            System.out.println(presentElement+" "+prevIndex+" "+ Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer []::new)));
            
            while(prevIndex>=0 && arr[prevIndex]>presentElement){
                arr[prevIndex+1]=arr[prevIndex];
                prevIndex--;
            }
            arr[prevIndex+1]=presentElement;
        }
    }
    
    static void selectionSort(int arr[]){
        int len= arr.length, min,temp;
        for(int i=0;i<len-1;i++){
            min=i;
            for(int j=i+1;j<len;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            // arr[min]=arr[min]+arr[i];
            // arr[i]=arr[min]-arr[i];
            // arr[min]=arr[min]-arr[i];
            
            temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
            
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int arr[]={5,4,3,2,1};
		System.out.println(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer []::new)));
	//	insertionSort(arr);
	    selectionSort(arr);
	    System.out.println(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer []::new)));
		
		
	}
}
