package SynchronizationPra;

public class HDFCBank {
    // without Synchrinized method

    double Balance;

    void WithdrawAmount(double withdraw){
        if(Balance>withdraw){
            Balance=Balance-withdraw;
           // System.out.println("After withdraw Balance :"+Balance);
        }
        else{
            System.out.println("Insufficient Funds");
        }

    }

    void DepositAmount(double Deposit){
        Balance=Balance+Deposit;
      //  System.out.println("After Deposit Money: "+Balance);
    }


    
}
class ATMThread extends Thread{

    HDFCBank ob;
    ATMThread(HDFCBank ob, String str){
        this.ob=ob;
       // System.out.println("atmthread object adress "+ob);
    }

    public void run(){
        // we have to call withdraw method from bank
        // by creating a object . method , but if we create a object here (two objects wiil be different Depositamount)
        ob.WithdrawAmount(5000);
        System.out.println("After withdraw Balance :"+ob.Balance);
        
    



    }
}
class GpayThread extends Thread{
    HDFCBank ob;

    GpayThread(HDFCBank ob, String str){
        this.ob=ob;
       // System.out.println("Gpaythread object adress "+ob);

    }

    public void run(){
        ob.DepositAmount(10000);
        System.out.println("After Deposit Money: "+ob.Balance);

    }
}
class MainClass{
    public static void main(String[] args) {
        HDFCBank KarthikAcc=new HDFCBank();
        System.out.println("Karthik acc object "+KarthikAcc);
        KarthikAcc.Balance=7000;
        ATMThread Atm=new ATMThread(KarthikAcc, "ATM");

        GpayThread Gpay=new GpayThread(KarthikAcc, "Gpay");
       
        //7,000 -- D10000, -- w5000    outcomes are " 2000,17000,12000"
        Atm.start();
       // System.out.println("After withdraw Money1: "+KarthikAcc.Balance);
        
        
        Gpay.start();
       // System.out.println("After Deposit Money1: "+KarthikAcc.Balance);

    }
}
// try {
        //     Atm.join();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }