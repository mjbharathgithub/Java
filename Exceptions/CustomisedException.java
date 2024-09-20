
import java.util.*;

class balanceException extends Exception{
    balanceException(String message){
        super(message);
    }
}

class ageException extends RuntimeException{
    ageException(String message){
        super(message);
    }
}
public class VoteSystem
{
    
    int balance,age;
    
    void setBalance(int balance) throws balanceException{
        if(balance>=0){
            this.balance=balance;
            System.out.println("Balance is set successfully");
        }else{
            throw  new balanceException("Joseph balance should'nt be negative");
        }
    }
    void setAge(int age){
        if(age>=18){
            this.age=age;
            System.out.println("age is set successfully");
        }else{
            throw  new ageException("Joseph age should'nt be less than 18");
        }
    }
	
	public static void main(String[] args) {
	    VoteSystem canditate= new VoteSystem();
	    try{
	    canditate.setBalance(-234);
	    }
	    catch(balanceException e)
	    {e.printStackTrace();}
	    
	    try{
	    canditate.setAge(-20);
	    }
	    catch(ageException e) {
	        e.printStackTrace();
	        
	    }
	    
	    
	    finally{
	        System.out.println("Customized Exception is implemented successfully");
	    }

	
	}
}
