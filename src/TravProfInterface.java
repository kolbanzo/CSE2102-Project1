import java.io.IOException;
import java.util.Scanner;

public class TravProfInterface { //Should we handle multiple profiles with the same last name and the same trav agent ID?
    String dbName;
    TravProfDB db = new TravProfDB("dbFile"); //Create TravProfDB object for writing/initializing
    private String travAgentID; //trav agent ID stored here after menu selection

    public TravProfInterface(String fileName) {
        dbName = fileName;
    }

    void displayTravProf(TravProf travProf) { //Print all info in a Trav Prof
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
        System.out.println("------------------------------------");
    }

    MedCond createNewMedCond() { //Prompt user to enter information needed for med cond
        Scanner medScanner = new Scanner(System.in);

        System.out.println("Enter Name of MD Contact:");
        String mdContact = medScanner.nextLine();

        System.out.println("Enter Phone Number of MD Contact:");
        String mdPhone = medScanner.nextLine();

        String algType = "";
        int input;
        do { //make sure input is an integer
            System.out.println("Select Allergy: ");
            System.out.println("(1) None");
            System.out.println("(2) Food");
            System.out.println("(3) Medication");
            System.out.println("(4) Other");
            try {
                input = Integer.parseInt(medScanner.nextLine());
                if(input >= 1 && input < 5){
                    break;}
                else{
                    System.out.println("Please enter a valid value.");
                    continue;}
            } catch (Exception e) {
                System.out.println("Please enter a valid value.");
                continue;
            }
        } while (true);

        if (input == 1) {
            algType = "None";
        }
        if (input == 2) {
            algType = "Food";
        }
        if (input == 3) {
            algType = "Medication";
        }
        if (input == 4) {
            algType = "Other";
        }

        int input2;
        do { //make sure input is an integer
            System.out.println("Select Illness: "); //Menu with number selection?
            System.out.println("(1) None");
            System.out.println("(2) Heart");
            System.out.println("(3) Diabetes");
            System.out.println("(4) Asthma");
            System.out.println("(5) Other");
            try {
                input2 = Integer.parseInt(medScanner.nextLine());
                if(input2 >= 1 && input2 < 6){
                    break;}
                else{
                    System.out.println("Please enter a valid value.");
                    continue;}
            } catch (Exception e) {
                System.out.println("Please enter a valid value.");
                continue;
            }
        } while (true);
        String illType = "";
        if (input2 == 1) {
            illType = "None";
        }
        if (input2 == 2) {
            illType = "Heart";
        }
        if (input2 == 3) {
            illType = "Diabetes";
        }
        if (input2 == 4) {
            illType = "Asthma";
        }
        if (input2 == 5) {
            illType = "Other";
        }

        MedCond medCondInfo = new MedCond(mdContact, mdPhone, algType, illType); //Create med cond using user input
        return medCondInfo;
    }

    void createNewTravProf() { //Prompt user to enter information needed for trav prof
        Scanner profScanner = new Scanner(System.in);

        System.out.println("Enter Traveler's First Name:");
        String firstName = profScanner.nextLine();

        System.out.println("Enter Traveler's Last Name:");
        String lastName = profScanner.nextLine();

        System.out.println("Enter Traveler's Address:");
        String address = profScanner.nextLine();

        System.out.println("Enter Traveler's Phone Number:");
        String phone = profScanner.nextLine();

        System.out.println("Enter Cost of Trip:");
        boolean goodCost = false;
        float tripCost = 0;
        while (!(goodCost)){
        try {
            tripCost = Float.parseFloat(profScanner.nextLine());
            goodCost = true;
        }catch(Exception NumberFormatException){
            System.out.println("Please enter a number for the trip cost.");
        }}

        System.out.println("Enter Travel Type:");
        String inputtravelType = profScanner.nextLine();
        while(!(inputtravelType.equals("Business") || inputtravelType.equals("Pleasure"))) {
            System.out.println("Please enter \"Business\" or \"Pleasure\"");
            inputtravelType = profScanner.nextLine();
        }
        String travelType = inputtravelType;


        System.out.println("Enter Payment Type:");
        String inputpaymentType = profScanner.nextLine();
        while (!(inputpaymentType.equals("Credit") || inputpaymentType.equals("Check") || inputpaymentType.equals("Debit") || inputpaymentType.equals("Invoice"))) {
            System.out.println("Please enter \"Credit\", \"Check\", \"Debit\", or \"Invoice\"");
            inputpaymentType = profScanner.nextLine();
        }

        String paymentType = inputpaymentType;

        MedCond medCondInfo;
        medCondInfo =

                createNewMedCond(); //Call create med cond function and store in MedCond object

        System.out.println("------------------------------------");

        TravProf newTravProf = new TravProf(travAgentID, firstName, lastName, address, phone, tripCost, travelType,
                paymentType, medCondInfo);
        db.insertNewProfile(newTravProf); //Create new trav prof and store in arraylist
    }

    void deleteTravProf() { //Delete a trav prof using last name and stored trav agent id
        Scanner deleteScanner = new Scanner(System.in);

        System.out.println("Enter last name of profile");
        String lastName = deleteScanner.nextLine();

        boolean deleted = db.deleteProfile(travAgentID, lastName);
        if(deleted){System.out.println("Successful profile deletion!");}else{
            System.out.println("No such profile could be found");
        }
        System.out.println("------------------------------------");
    }

    void findTravProf() { //Find a trav prof by last name
        Scanner findScanner = new Scanner(System.in);

        System.out.println("Enter last name of profile");
        String lastName = findScanner.nextLine();
        if(db.findProfile(travAgentID, lastName) == null){
            System.out.println("No such profile could be found");}else{
        this.displayTravProf(db.findProfile(travAgentID, lastName));}
        System.out.println("------------------------------------");
    }

    void updateTravProf() { //Find a trav prof by last name and prompt user to choose which value to update
        Scanner updateScanner = new Scanner(System.in);
        TravProf modifyProf = null;

        System.out.println("Enter last name of the profile you want to modify");
        String lastName = updateScanner.nextLine();

        for (int i = 0; i < db.travelerList.size(); i++) {
            TravProf tempProf = db.travelerList.get(i);
            if (tempProf.getLastName().equals(lastName) && tempProf.gettravAgentID().equals(travAgentID)) {
                modifyProf = tempProf;
                break;
            }
        }
        if(modifyProf == null){
            System.out.println("No such profile was found.");
            return;
        }
        int input;
        System.out.println("Select which attribute you would like to modify: ");
        do {
            System.out.println("(1) Address");
            System.out.println("(2) Phone");
            System.out.println("(3) Travel Type");
            System.out.println("(4) Trip Cost");
            System.out.println("(5) Payment Type");
            System.out.println("(6) MD Contact");
            System.out.println("(7) MD Phone");
            System.out.println("(8) Illness Type");
            System.out.println("(9) Allergy Type");
            try {
                input = Integer.parseInt(updateScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a valid value.");
                continue;
            }
        } while (true);

        //System.out.println("Enter updated value");
        //String updatedValue = updateScanner.nextLine();

        if (input == 1) {
            System.out.println("Enter updated address");
            String updatedValue = updateScanner.nextLine();
            modifyProf.updateAddress(updatedValue);
        }
        if (input == 2) {
            System.out.println("Enter updated phone");
            String updatedValue = updateScanner.nextLine();
            modifyProf.updatePhone(updatedValue);
        }
        if (input == 3) {
            System.out.println("Enter updated travel type");
            String updatedValue = updateScanner.nextLine();
            while (!(updatedValue.equals("Business") || updatedValue.equals("Pleasure"))) {
                System.out.println("Please enter \"Business\" or \"Pleasure\"");
                updatedValue = updateScanner.nextLine();
            }
            modifyProf.updateTravelType(updatedValue);
        }
        if (input == 4) {
            System.out.println("Enter updated trip cost");
            String updatedValue = updateScanner.nextLine();
            boolean goodUpdate = false;
            float updatedValueFloat = 0;
            while (!(goodUpdate)){
                try {
                    updatedValueFloat = Float.parseFloat(updatedValue);
                    goodUpdate = true;
                }catch(Exception NumberFormatException){
                    System.out.println("Please enter a number for the trip cost.");
                    updatedValue = updateScanner.nextLine();
                }}
            modifyProf.updateTripCost(updatedValueFloat);
        }
        if (input == 5) {
            System.out.println("Enter updated payment type");
            String updatedValue = updateScanner.nextLine();
            while (!(updatedValue.equals("Credit") || updatedValue.equals("Check") || updatedValue.equals("Debit") || updatedValue.equals("Invoice"))) {
                System.out.println("Please enter \"Credit\", \"Check\", \"Debit\", or \"Invoice\"");
                updatedValue = updateScanner.nextLine();
            }
            modifyProf.updatePaymentType(updatedValue);
        }
        if (input == 6) {
            System.out.println("Enter updated MD Contact");
            String updatedValue = updateScanner.nextLine();
            modifyProf.getMedCondInfo().updateMdContact(updatedValue);
        }
        if (input == 7) {
            System.out.println("Enter MD Phone");
            String updatedValue = updateScanner.nextLine();
            modifyProf.getMedCondInfo().updateMdPhone(updatedValue);
        }
        if (input == 8) {
            String updatedIll = "";
            int updateIllInput;
            do { //make sure input is an integer
                System.out.println("Select Illness:");
                System.out.println("(1) None");
                System.out.println("(2) Heart");
                System.out.println("(3) Diabetes");
                System.out.println("(4) Asthma");
                System.out.println("(5) Other");
                try {
                    updateIllInput = Integer.parseInt(updateScanner.nextLine());
                    if(updateIllInput >= 1 && updateIllInput < 6){
                    break;}
                    else{
                        System.out.println("Please enter a valid value.");
                        continue;}
                } catch (Exception e) {
                    System.out.println("Please enter a valid value.");
                    continue;
                }
            } while (true);

            if (updateIllInput == 1) {
                updatedIll = "None";
            }
            if (updateIllInput == 2) {
                updatedIll = "Heart";
            }
            if (updateIllInput == 3) {
                updatedIll = "Diabetes";
            }
            if (updateIllInput == 4) {
                updatedIll = "Asthma";
            }
            if(updateIllInput == 5){
                updatedIll = "Other";
            }
            modifyProf.getMedCondInfo().updateAlgType(updatedIll);
        }

        if (input == 9) {
            String updatedAlg = "";
            int updateAlgInput;
            do { //make sure input is an integer
                System.out.println("Select Allergy: ");
                System.out.println("(1) None");
                System.out.println("(2) Food");
                System.out.println("(3) Medication");
                System.out.println("(4) Other");
                try {
                    updateAlgInput = Integer.parseInt(updateScanner.nextLine());
                    if(updateAlgInput >= 1 && updateAlgInput < 5){
                        break;}
                    else{
                        System.out.println("Please enter a valid value.");
                        continue;}
                } catch (Exception e) {
                    System.out.println("Please enter a valid value.");
                    continue;
                }
            } while (true);

            if (updateAlgInput == 1) {
                updatedAlg = "None";
            }
            if (updateAlgInput == 2) {
                updatedAlg = "Food";
            }
            if (updateAlgInput == 3) {
                updatedAlg = "Medication";
            }
            if (updateAlgInput == 4) {
                updatedAlg = "Other";
            }
            modifyProf.getMedCondInfo().updateAlgType(updatedAlg);
        }
    }

    void displayAllTravelProfiles() { //Loop through array list and display each profile
        for (int i = 0; i < db.travelerList.size(); i++) {
            TravProf tempProf = db.travelerList.get(i);
            if(tempProf.gettravAgentID().equals(travAgentID)){this.displayTravProf(tempProf);}
        }
    }

    void writeToDB() throws IOException {
        db.writeAllTravProf(db.fileName); //Write all profiles in arraylist to db file
        db.travelerList.removeAll(db.travelerList);
    }

    void initDB() throws IOException, ClassNotFoundException { //Retrieve all trav profs stored in DB file to arraylist
        db.initializeDataBase(db.fileName);
    }

    //boolean returned to signal main when to stop looping.
    public boolean getUserChoice() throws IOException, ClassNotFoundException { //prompt user to enter menu choice
        System.out.println("Select a menu option:");
        Scanner scan = new Scanner(System.in);
        int input;
        do { //make sure input is integer and matches is a valid menu option
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
        System.out.println("------------------------------------");
        if (input == 8) { //If exit, do so before asking for travel agent id
            System.out.println("Exiting");
            return false;
        }
        System.out.println("Enter Travel Agent ID:"); //travel agent id required after every menu selection
        travAgentID = scan.nextLine();
        if (input == 1) {
            createNewTravProf();
            return true;
        }
        if (input == 2) {
            deleteTravProf();
            return true;
        }
        if (input == 3) {
            findTravProf();
            return true;
        }
        if (input == 4) {
            updateTravProf();
            return true;
        }
        if (input == 5) {
            displayAllTravelProfiles();
            return true;
        }
        if (input == 6) {
            writeToDB();
            return true;
        }
        if (input == 7) {
            initDB();
            return true;
        }
        //if control reaches here, entered value is not valid. Print this and return true to loop again.
        System.out.println("The option you selected was invalid, please choose from the following list:");
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean state = true;
        TravProfInterface db = new TravProfInterface("test");
        while (state) { //While getUserChoice() returns true, loop
            state = db.getUserChoice();
        }
    }
}
