import java.util.Scanner;
public class simple{
    public static void main(String[] args){
        int a=5;
        double b;
        Scanner inp=new Scanner(System.in);

        b=inp.nextDouble();
        inp.nextLine();

        System.out.println(a>b);


    }
}