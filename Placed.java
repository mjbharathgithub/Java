
public class Main
{
    static void countDep(String arr[]){
        int eee=0,ece=0,cse=0,ad=0;
        for(String name:arr){
            String temp=name.substring(name.length()-3);
            switch(temp){
                case "EEE":
                    eee++;
                    break;
                case "ECE":
                    ece++;
                    break;
                case "CSE":
                    cse++;
                    break;    
                default:
                    ad++;
                    break;
                    
            }
        }
        System.out.println("EEE : "+eee+"\nECE : "+ece+"\nCSE : "+cse+"\nAD : "+ad);
    }
	public static void main(String[] args) {
	    String[] students = {
           
        };
        countDep(students);
	}
}
