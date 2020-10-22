import java.util.Scanner;

public class TravProfInterface {
    public static void main(String[] args){
        boolean state = true;
        while(state){
            System.out.println("(1) Enter a New TravProf");
            System.out.println("(2) Delete a traveler by Name");
            System.out.println("(3) Exit");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            int int_input = Integer.parseInt(input);

            if(int_input == 1){
                System.out.println("call createNewTravProf here");
            }
            if(int_input == 2){
                System.out.println("call deleteTravProf here");
            }
            if(int_input == 3){
                System.out.println("Exiting");
                state = false;
            }
        }
    }
}
