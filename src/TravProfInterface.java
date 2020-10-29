import java.util.ArrayList;
import java.util.Scanner;

public class TravProfInterface { //Should we handle multiple profiles with the same last name and the same trav agent ID?
    String dbName;
    TravProfDB db = new TravProfDB("file");
    public TravProfInterface(String fileName){
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
        System.out.println("Medical Condition Info: ");
        System.out.println("MD Contact: " + travProf.getMedCondInfo().getMdContact());
        System.out.println("MD Phone: " + travProf.getMedCondInfo().getMdPhone());
        System.out.println("Allergy Type: " + travProf.getMedCondInfo().getAlgType());
        System.out.println("Illness Type: " + travProf.getMedCondInfo().getIllType());
        System.out.println();
    }

    MedCond createNewMedCond(){
        Scanner medScanner = new Scanner(System.in);

        System.out.println("Enter Name of MD Contact:");
        String mdContact = medScanner.nextLine();

        System.out.println("Enter Phone Number of MD Contact:");
        String mdPhone = medScanner.nextLine();

        String algType = "";
        int input;
        do {
            System.out.println("Select Allergy: "); //Menu with number selection?
            System.out.println("(1) None");
            System.out.println("(2) Food");
            System.out.println("(3) Medication");
            System.out.println("(4) Other");
            try {
                input = Integer.parseInt(medScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid value.");
                continue;
            }
        } while (true);

        if(input == 1){
            algType = "None";
        }
        if(input == 2){
            algType = "Food";
        }
        if(input == 3){
            algType = "Medication";
        }
        if(input == 4){
            algType = "Other";
        }

        int input2;
        do {
            System.out.println("Select Illness: "); //Menu with number selection?
            System.out.println("(1) None");
            System.out.println("(2) Heart");
            System.out.println("(3) Diabetes");
            System.out.println("(4) Asthma");
            System.out.println("(5) Other");
            try {
                input2 = Integer.parseInt(medScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid value.");
                continue;
            }
        } while (true);
        String illType = "";
        if(input2 == 1){
            illType = "None";
        }
        if(input2 == 2){
            illType = "Heart";
        }
        if(input2 == 3){
            illType = "Diabetes";
        }
        if(input2 == 4){
            illType = "Asthma";
        }
        if(input2 == 5){
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
        db.insertNewProfile(newTravProf);
    }

    void deleteTravProf(){ //What if no profile on record with provided last name?
        Scanner deleteScanner = new Scanner(System.in);

        System.out.println("Enter last name of profile");
        String lastName = deleteScanner.nextLine();

        System.out.println("Enter Travel Agent ID:");
        String travAgentID = deleteScanner.nextLine();

        db.deleteProfile(lastName, travAgentID);

    }

    void findTravProf(){
        Scanner findScanner = new Scanner(System.in);

        System.out.println("Enter last name of profile");
        String lastName = findScanner.nextLine();

        System.out.println("Enter Travel Agent ID:");
        String travAgentID = findScanner.nextLine();

        db.findProfile(travAgentID, lastName);
    }

    void updateTravProf(){ //How do we determine which profile they want to modify? By last name?
        Scanner updateScanner = new Scanner(System.in);
        TravProf modifyProf = new TravProf(null, null, null, null, null,
                0, null, null, null);

        System.out.println("Enter last name of profile");
        String lastName = updateScanner.nextLine();

        for(int i = 0; i < db.travelerList.size(); i++){
            TravProf tempProf = db.travelerList.get(i);
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
        int input = 0;
        if(scan.hasNextInt()) {
            input = scan.nextInt();
        }
        System.out.println("Enter updated value");
        String updatedValue = updateScanner.nextLine();

        if(input == 1){
            modifyProf.updateAddress(updatedValue);
        }
    }

    void displayAllTravelProfiles(){
        for(int i = 0; i < db.travelerList.size(); i++){
            TravProf tempProf = db.travelerList.get(i);
            displayTravProf(tempProf);
        }
    }

    public boolean getUserChoice(){
        Scanner scan = new Scanner(System.in);
        int input;
        do {
            System.out.println("(1) Create a new travel profile");
            System.out.println("(2) Delete a travel profile");
            System.out.println("(3) Find a travel profile");
            System.out.println("(4) Modify a travel profile");
            System.out.println("(5) Display all travel profiles");
            System.out.println("(6) Write to database");
            System.out.println("(7) Initialize database");
            System.out.println("(8) Exit");
            try {
                input = Integer.parseInt(scan.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid value.");
                continue;
            }
        } while (true);
        if(input == 1){
            createNewTravProf();
            return true;
        }
        if(input == 2){
            deleteTravProf();
            return true;
        }
        if(input == 3){
            findTravProf();
            return true;
        }
        if(input == 4){
            updateTravProf();
            return true;
        }
        if(input == 5){
            displayAllTravelProfiles();
            return true;
        }
        if(input == 6){
            System.out.println("call writeToDB");
            return true;
        }
        if(input == 7){
            System.out.println("call initDB");
            return true;
        }
        if(input == 8){
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
