import java.util.Scanner;
import java.util.ArrayList;


//class that will store generar structure of required details for single person
class member{
    private double contribution=0;
    private String name;
    private double owes=0;
    private boolean paid=false;

    member( String name, double contribution){
        this.contribution = contribution;
        this.name = name;
        owes();
    }
    double getContribution(){
        return contribution;
    }
    String getName(){
        return name;
    }
    double getOwes(){
        return owes;
    }
    boolean getPaid(){
        return paid;
    }

    void setPaid(boolean isPaid){
        paid = isPaid;
    }
    void setContribution(double contribution){
        this.contribution = contribution;
    }
    
  

    void contribute(double contribution){
        if((this.contribution + contribution) <= 50){
        this.contribution += contribution;
        System.out.println("Contribution added successfully!");
        owes();
        }else{
            System.out.println("Unable to set contribution, please try to enter "+(50 - contribution)+" units or below!\n");
        }
    }
      public void owes(){
        if(this.contribution <= 50){
            this.owes = 50 - this.contribution;
        }
    }


}


//class for storing and managing members of susu savings group
class management{
      int week=1;
      String name;
      double contribution;
      
      // creating array list for storing multiple values of members without limited length of members
      ArrayList<member> members = new ArrayList<>();
      Scanner in = new Scanner(System.in);
      
      void add(){

        //using variable 'ch' with initial value of yes[y] to support in accepting user inputs for adding new member or not
        char ch='y';
        
        while(ch == 'y' || ch == 'Y'){
            System.out.print("\nEnter Name:");
            name = in.nextLine();

            System.out.print("Enter Contribution:");
            contribution = in.nextDouble();
            members.add(new member(name, contribution));
            
            System.out.print("Do you want to add another member [y/n] : ");
            ch = in.next().charAt(0);
            in.nextLine();// cleaner of buffers to allow next inputs
            }
            }
    void add(String name, double contribution){

            members.add(new member(name, contribution));
        System.out.println("Finished adding initial Members in the susu group as given\n");
            
            }

           void contribute(int index, double contribution){

            index -=100; // resetting default value of Id to match with indexes of list
             try{

                    members.get(index).contribute(contribution);//changing value of contribution
                    
                }catch(IndexOutOfBoundsException e){
                    System.out.println("Please Enter valid member Id Please check on report.");
                }
           }

            void contribute(){
                int index;
                System.out.print("Enter member id:");
                index=in.nextInt();
                index -= 100; // removing 100 from Displayed ID to match with index


                in.nextLine(); //clean integer reading buffers
                try{

                    if(members.get(index).getContribution() < 50){
                    System.out.print("\nAdd Contribution for "+members.get(index).getName()+" has contribution of "+members.get(index).getContribution()+": ");
                    double temp=in.nextDouble();
                    in.nextLine();
                    members.get(index).contribute(temp);//changing value of contribution
                    }else{
                       System.out.print("\nMember "+members.get(index).getName()+" has contribution of "+members.get(index).getContribution()+" Which is enough.");
                     
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println("Please Enter valid member Id Please check on report.");
                }
            }
      
      void close(){
      double sum=0;
        for(member contri: members){
            sum =sum + contri.getContribution();
            }
            
            //evaluating the required money to be considered if all members had been contributed by taking money per week multiply by all members
        if((members.size() * 50) <= sum){
            week++;
            System.out.println("\nWe have "+members.size()+" people In our saving group.");
            for(member contri: members){
                 if(contri.getPaid() == false) {
                    contri.setPaid(true);

                  // resetting contributed people after all others get paid in next week
                    
                    if(members.get(members.size() - 1).getPaid() == true){
                        for(member resetPaid: members) resetPaid.setPaid(false); 
                    }


                    for(member reset: members) {
                        reset.setContribution(0);
                        reset.owes();
                    }
                    System.out.println("Week ended, We paid "+contri.getName()+".");
                    break;
                    }
                    }
                    }else{
                        System.out.println("There are still some one else who owe us, closing week could not be completed. Try again later!\n");
                        }
                        
                }
                // function to display report by using array list of object members
      void report(){
        System.out.println("_____________________________________________________________________________________");
        System.out.println("Stored Details for week "+week+" are:\n");

        int temporaryIndex=100; //starting with 100 as Id of every member registered and add to index of the list
        for(member a: members){
        System.out.println("Member Id:"+temporaryIndex + " Name: "+a.getName()+" Contribution Balance: "+a.getContribution()+" Owes:"+a.getOwes()+" paid: "+a.getPaid());
            temporaryIndex++;
      }
      System.out.println("_____________________________________________________________________________________");
        
      }
      }


public class susu{
    public static void main(String[] args){
        int option;
        char choice='y';

        management m = new management();
        Scanner in = new Scanner(System.in);
// adding initial members as given below
/*
 members (Ama, Kofi, Esi), weekly amount 50.00. Week 1: Ama and Kofi pay 50. Esi pays 30. Closing week 1 pays nothing and reports “Esi owes 20.00”. Esi pays 20, week 1 closes, and Ama receives 150.00. Week 2 begins, and Kofi is next.
*/
m.add("Ama", 50);
m.add("Kofi", 50);
m.add("Esi", 30);
m.close();
m.report();
m.contribute(102, 20);
      
        while(choice == 'y'){
              System.out.print("\nSelect option of Susu management: \n1. Adding member \n2. Add contribution\n3. Closing week \n4. Show report\n5. Exit\nEnter Choice:");
               option = in.nextInt();
        switch(option){
           case 1 :
            m.add();
            break;
            case 2 :
                m.contribute();
                break;
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