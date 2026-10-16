import java.util.Scanner;
import java.util.ArrayList;

class member{
    double contribution=0;
    String name;
    double owes=0;
    boolean paid=false;

    member( String name, double contribution){
        this.contribution = contribution;
        this.name = name;
        owes();
    }
    
    void owes(){
        if(this.contribution < 50){
            owes = 50 - this.contribution;
        }
    }

    void contribute(double contibution){
        this.contribution = contribution;
        owes();
    }


}

class management{
      double sum=0;
      int week=0;
      String name;
      double contribution;
      
      ArrayList<member> members = new ArrayList<>();
      Scanner in = new Scanner(System.in);
      
      void add(){
        char ch='y';
        
        while(ch == 'y'){
            System.out.print("Enter Name:");
            name = in.next();
            System.out.print("Enter Contribution:");
            contribution = in.nextDouble();
            members.add(new member(name, contribution));
            
            System.out.println("Do you want to add another member [y/n]");
            ch = in.next().charAt(0);
            }
            }
      
      void close(){
        for(member contri: members){
            sum =sum + contri.contribution;
            }
            
            
        if((members.size() * 50) <= sum){
            week++;
            System.out.println("We have all members of "+members.size());
            for(member contri: members){
                 if(contri.paid == false) {
                    contri.paid=true;
                    System.out.println("\nWeek ended, We paid "+contri.name);
                    break;
                    }
                    }
                    }else{
                        System.out.println("There are still some one who owe us.\n");
                        }
                        
                }

      void report(){
        System.out.println("Stored Details are:\n Current week="+week);
        for(member a: members){
        System.out.println("Name: "+a.name+" Contribution: "+a.contribution+" Owes:"+a.owes+" Contributed in this week: "+a.paid);
      }
      }

}

public class susu{
    public static void main(String[] args){
        int option;
        char choice='y';

        management m = new management();
        Scanner in = new Scanner(System.in);

      
        while(choice == 'y'){
              System.out.print("\n\nSelect option of Susu management: \n1. Adding member \n2. Closing week \n3. Show report\n4. Exit\nEnter Choice:");
               option = in.nextInt();
        switch(option){
           case 1 :
            m.add();
            break;
           case 2 :
            m.close();
            break;
           case 3 :
            m.report();
            break;
            case 4 :
                choice = 'n';
                break;
           default :
            System.out.println("Invalid choice!");
            choice = 'y';
            break;
        }
        }
    }
}