import java.util.Scanner;
import java.util.ArrayList;


//class that will store generar structure of required details for single person
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
        if((this.contribution + contribution) <= 50){
        this.contribution += contribution;
        owes();
        }else{
            System.out.println("Unable to set contribution, please try to enter "+owes+"units or below!\n");
        }
    }


}


//class for storing and managing members of susu savings group
class management{
      double sum=0;
      int week=0;
      String name;
      double contribution;
      
      // creating array list for storing multiple values of members without limited length of members
      ArrayList<member> members = new ArrayList<>();
      Scanner in = new Scanner(System.in);
      
      void add(){

        //using variable 'ch' with initial value of yes[y] to support in accepting user inputs for adding new member or not
        char ch='y';
        
        while(ch == 'y'){
            System.out.print("Enter Name:");
            name = in.nextLine();

            System.out.print("Enter Contribution:");
            contribution = in.nextDouble();
            members.add(new member(name, contribution));
            
            System.out.println("Do you want to add another member [y/n]");
            ch = in.next().charAt(0);
            in.nextLine();// cleaner of buffers to allow next inputs
            }
            }


            void contribute(){
                int index;
                System.out.print("Enter member id:");
                index=in.nextInt();
                in.nextLine(); //clean integer reading buffers

                if(members.get(index) != null){
                    System.out.println("Add Contribution for "+members.get(index).name+" has contribution of "+members.get(index).contribution);
                    double temp=in.nextDouble();
                    in.nextLine();
                    members.get(index).contribute(temp);//changing value of contribution
                }
            }
      
      void close(){
        for(member contri: members){
            sum =sum + contri.contribution;
            }
            
            //evaluating the required money to be considered if all members had been contributed by taking money per week multiply by all members
        if((members.size() * 50) <= sum){
            week++;
            System.out.println("We have "+members.size()+"In our saving group.");
            for(member contri: members){
                 if(contri.paid == false) {
                    contri.paid=true;
                    System.out.println("\nWeek ended, We paid "+contri.name);
                    break;
                    }
                    }
                    }else{
                        System.out.println("There are still some one else who owe us.\n");
                        }
                        
                }
                // function to display report by using array list of object members
      void report(){
        System.out.println("Stored Details for week "+week+" are:\n");
        for(member a: members){
        System.out.println("Name: "+a.name+" Contribution: "+a.contribution+" Owes:"+a.owes+" paid in this week: "+a.paid);
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
              System.out.print("\n\nSelect option of Susu management: \n1. Adding member \n2.Add your\n3. Closing week \n4. Show report\n5. Exit\nEnter Choice:");
               option = in.nextInt();
        switch(option){
           case 1 :
            m.add();
            break;
            case 2 :
                m.contribute();
           case 3 :
            m.close();
            break;
           case 4 :
            m.report();
            break;
            case 5 :
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