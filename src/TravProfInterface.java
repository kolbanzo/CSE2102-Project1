import java.util.ArrayList;
import java.util.Scanner;

public class TravProfInterface {
    ArrayList<TravProf> travProfs;
    String dbName = "TravProfDB";
    public TravProfInterface(String fileName){
        travProfs = new ArrayList<TravProf>();
    }

    public boolean getUserChoice(){
        System.out.println("(1) Enter a New TravProf");
        System.out.println("(2) Delete a traveler by Name");
        System.out.println("(3) Exit");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int int_input = Integer.parseInt(input); //Implement error handling for non-integer inputs.

        if(int_input == 1){
            System.out.println("call createNewTravProf here");
            return true;
        }
        if(int_input == 2){
            System.out.println("call deleteTravProf here");
            return true;
        }
        if(int_input == 3){
            System.out.println("Exiting");
            return false;
        }
        System.out.println("The option you selected was invalid, please choose from the following list:");
        return true;
    }

    public static void main(String[] args){
        boolean state = true;
        TravProfInterface db = new TravProfInterface("test");
        while(state){
            state = db.getUserChoice();
        }
    }
}
