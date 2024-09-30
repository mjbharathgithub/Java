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

	// for(int i=len-1;i>0;i--){
 //            max=i;
 //            //System.out.println(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
 //            for(int j=i-1;j>=0;j--){
 //            if(arr[max]<arr[j]){
 //                max=j;
 //            }
            
 //            }
 //            temp=arr[i];
 //            arr[i]=arr[max];
 //            arr[max]=temp;
            
 //            // arr[i]=arr[i]+arr[max];
 //            // arr[max]=arr[i]-arr[max];
 //            // arr[i]=arr[i]-arr[max];
 //        }     
    }
	static void bubbleSort(int arr[]){
            int len=arr.length;
            for(int i=0;i<len;i++){
                for(int j=0;j<len-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        arr[j]=arr[j]+arr[j+1];
                        arr[j+1]=arr[j]-arr[j+1];
                        arr[j]=arr[j]-arr[j+1];
                    }
                }
                System.out.println(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
		
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
