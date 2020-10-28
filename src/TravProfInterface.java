import java.util.ArrayList;
import java.util.Scanner;

public class TravProfInterface { //Should we handle multiple profiles with the same last name and the same trav agent ID?
    ArrayList<TravProf> travProfs; //Ex: for findTravProf(), which profile should we display for family
    String dbName;
    public TravProfInterface(String fileName){
        travProfs = new ArrayList<TravProf>();
        dbName = fileName;
    }

    void displayTravProf(TravProf travProf){
        System.out.println("Travel Agent ID: " + travProf.gettravAgentID());
        System.out.println("Traveler's First Name: " + travProf.getFirstName());
        System.out.println("Traveler's Last Name: " + travProf.getLastName());
        System.out.println("Traveler's Address: " + travProf.getAddress());
        System.out.println("Traveler's Phone Number: " + travProf.getPhone());
        System.out.println("Cost of Trip: " + travProf.getTripCost());
        System.out.println("Travel Type: " + travProf.getTravelType());
        System.out.println("Payment Type: " + travProf.getPaymentType());
        System.out.println("Medical Condition Info: " + travProf.getMedCondInfo());
        System.out.println();
    }

    MedCond createNewMedCond(){
        Scanner medScanner = new Scanner(System.in);

        System.out.println("Enter Name of MD Contact:");
        String mdContact = medScanner.nextLine();

        System.out.println("Enter Phone Number of MD Contact:");
        String mdPhone = medScanner.nextLine();

        String algType = "";
        System.out.println("Select Allergy: "); //Menu with number selection?
        System.out.println("(1) None");
        System.out.println("(2) Food");
        System.out.println("(3) Medication");
        System.out.println("(4) Other");
        String algTypeScan = medScanner.nextLine();
        int int_input = Integer.parseInt(algTypeScan);
        if(int_input == 1){
            algType = "None";
        }
        if(int_input == 2){
            algType = "Food";
        }
        if(int_input == 3){
            algType = "Medication";
        }
        if(int_input == 4){
            algType = "Other";
        }

        String illType = "";
        System.out.println("Select Allergy: "); //Menu with number selection?
        System.out.println("(1) None");
        System.out.println("(2) Heart");
        System.out.println("(3) Diabetes");
        System.out.println("(4) Asthma");
        System.out.println("(5) Other");
        String illTypeScan = medScanner.nextLine();
        int int_input2 = Integer.parseInt(illTypeScan);
        if(int_input2 == 1){
            illType = "None";
        }
        if(int_input2 == 2){
            illType = "Heart";
        }
        if(int_input2 == 3){
            illType = "Diabetes";
        }
        if(int_input2 == 4){
            illType = "Asthma";
        }
        if(int_input2 == 5){
            illType = "Other";
        }

        MedCond medCondInfo = new MedCond(mdContact, mdPhone, algType, illType);
        return medCondInfo;
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

        MedCond medCondInfo;
        medCondInfo = createNewMedCond();

        TravProf newTravProf = new TravProf(travAgentID, firstName, lastName, address, phone, tripCost, travelType, paymentType, medCondInfo);
        travProfs.add(newTravProf);
    }

    void deleteTravProf(){ //What if no profile on record with provided last name?
        Scanner deleteScanner = new Scanner(System.in);

        System.out.println("Enter last name of profile");
        String lastName = deleteScanner.nextLine();

        System.out.println("Enter Travel Agent ID:");
        String travAgentID = deleteScanner.nextLine();

        for(int i = 0; i < travProfs.size(); i++){
            TravProf tempProf = travProfs.get(i);
            if(tempProf.getLastName().equals(lastName) && tempProf.gettravAgentID().equals(travAgentID)){
                travProfs.remove(tempProf);
            }
        }

    }

    void findTravProf(){
        Scanner findScanner = new Scanner(System.in);

        System.out.println("Enter last name of profile");
        String lastName = findScanner.nextLine();

        System.out.println("Enter Travel Agent ID:");
        String travAgentID = findScanner.nextLine();

        for(int i = 0; i < travProfs.size(); i++){
            TravProf tempProf = travProfs.get(i);
            if(tempProf.getLastName().equals(lastName) && tempProf.gettravAgentID().equals(travAgentID)){
                displayTravProf(tempProf);
            }
        }
    }

    void updateTravProf(){ //How do we determine which profile they want to modify? By last name?
        Scanner updateScanner = new Scanner(System.in);
        TravProf modifyProf = new TravProf(null, null, null, null, null,
                0, null, null, null);

        System.out.println("Enter last name of profile");
        String lastName = updateScanner.nextLine();

        for(int i = 0; i < travProfs.size(); i++){
            TravProf tempProf = travProfs.get(i);
            if(tempProf.getLastName().equals(lastName)){
                modifyProf = tempProf;
            }
        }

        System.out.println("Select which attribute you would like to modify: "); //Menu with number selection?
        System.out.println("(1) Address");
        System.out.println("(2) Phone");
        System.out.println("(3) Travel Type");
        System.out.println("(4) Trip Cost");
        System.out.println("(5) Payment Type");
        System.out.println("(6) MD Contact");
        System.out.println("(7) MD Phone");
        System.out.println("(8) Illness Type");
        System.out.println("(9) Allergy Type");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int int_input = Integer.parseInt(input); //Implement error handling for non-integer inputs?

        System.out.println("Enter updated value");
        String updatedValue = updateScanner.nextLine();

        if(int_input == 1){
            modifyProf.updateAddress(updatedValue);
        }
    }

    void displayAllTravelProfiles(){
        for(int i = 0; i < travProfs.size(); i++){
            TravProf tempProf = travProfs.get(i);
            displayTravProf(tempProf);
        }
    }

    public boolean getUserChoice(){
        System.out.println("(1) Create a new travel profile");
        System.out.println("(2) Delete a travel profile");
        System.out.println("(3) Find a travel profile");
        System.out.println("(4) Modify a travel profile");
        System.out.println("(5) Display all travel profiles");
        System.out.println("(6) Write to database");
        System.out.println("(7) Initialize database");
        System.out.println("(8) Exit");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int int_input = Integer.parseInt(input); //Implement error handling for non-integer inputs?

        if(int_input == 1){
            createNewTravProf();
            return true;
        }
        if(int_input == 2){
            deleteTravProf();
            return true;
        }
        if(int_input == 3){
            findTravProf();
            return true;
        }
        if(int_input == 4){
            updateTravProf();
            return true;
        }
        if(int_input == 5){
            displayAllTravelProfiles();
            return true;
        }
        if(int_input == 6){
            System.out.println("call writeToDB");
            return true;
        }
        if(int_input == 7){
            System.out.println("call initDB");
            return true;
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
