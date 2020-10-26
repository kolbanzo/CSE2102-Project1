import java.util.ArrayList;
import java.util.Scanner;

public class TravProfInterface {
    ArrayList<TravProf> travProfs;
    String dbName = "TravProfDB";
    public TravProfInterface(String fileName){
        travProfs = new ArrayList<TravProf>();
    }

    void createNewTravProf(){
        Scanner profScanner = new Scanner(System.in);

        System.out.println("Enter Travel Agent ID:");
        String travAgentID = profScanner.nextLine();

        System.out.println("Enter Traveler's First Name:");
        String firstName = profScanner.nextLine();

        System.out.println("Enter Traveler's Last Name:");
        String lastName = profScanner.nextLine();

        System.out.println("Enter Traveler's Address:");
        String address = profScanner.nextLine();

        System.out.println("Enter Traveler's Phone Number:");
        String phone = profScanner.nextLine();

        System.out.println("Enter Cost of Trip:");
        float tripCost = Float.parseFloat(profScanner.nextLine());

        System.out.println("Enter Travel Type:");
        String travelType = profScanner.nextLine();

        System.out.println("Enter Payment Type:");
        String paymentType = profScanner.nextLine();

        TravProf newTravProf = new TravProf(travAgentID, firstName, lastName, address, phone, tripCost, travelType, paymentType);
        travProfs.add(newTravProf);
    }

    void displayAllTravelProfiles(){
        for(int i = 0; i < travProfs.size(); i++){
            TravProf tempProf = travProfs.get(i);
            System.out.println("Travel Agent ID: " + tempProf.travAgentID);
            System.out.println("Traveler's First Name: " + tempProf.firstName);
            System.out.println("Traveler's Last Name: " + tempProf.lastName);
            System.out.println("Traveler's Address: " + tempProf.address);
            System.out.println("Traveler's Phone Number: " + tempProf.phone);
            System.out.println("Cost of Trip: " + tempProf.tripCost);
            System.out.println("Travel Type: " + tempProf.travelType);
            System.out.println("Payment Type: " + tempProf.paymentType);
        }
    }

    public boolean getUserChoice(){
        System.out.println("(1) Enter a New TravProf");
        System.out.println("(2) Delete a traveler by Name");
        System.out.println("(3) Find a traveler");
        System.out.println("(4) Modify a travel profile");
        System.out.println("(5) Display all travel profiles");
        System.out.println("(6) Write to database");
        System.out.println("(7) Initialize database");
        System.out.println("(8) Exit");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int int_input = Integer.parseInt(input); //Implement error handling for non-integer inputs.

        if(int_input == 1){
            createNewTravProf();
            return true;
        }
        if(int_input == 2){
            System.out.println("call deleteTravProf here");
            return true;
        }
        if(int_input == 3){
            System.out.println("call findTravProf");
            return false;
        }
        if(int_input == 4){
            System.out.println("call updateTravProf");
            return false;
        }
        if(int_input == 5){
            displayAllTravelProfiles();
            return false;
        }
        if(int_input == 6){
            System.out.println("call writeToDB");
            return false;
        }
        if(int_input == 7){
            System.out.println("call initDB");
            return false;
        }
        if(int_input == 8){
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
