import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TravProfDB {

    private int numTravelers; //how many travelers are in DB
    private int openTravelerIndex; //gives position in travelerList of next open spot
    private String fileName; //name of DB
    private ArrayList travelerList; //array of all profiles in DB
    private int currentTravelerIndex; //used as an iterator

    //constructor
    public TravProfDB(String fileName) {
        this.fileName = fileName;
        this.numTravelers = 0;
        this.travelerList = new ArrayList();
        this.openTravelerIndex = 0;
        this.currentTravelerIndex = 0;
    }

    //Insert new profile accepts a TravProf as input and inserts it into the travelerList
    private void insertNewProfile(TravProf profile) {
            this.travelerList.add(profile);
        this.numTravelers++;
    }

    //delete profile removes a profile from travelerList and tells us if it worked (boolean)
    private boolean deleteProfile(String travID, String lastName) {
        boolean successfulDeletion = false;
        //find a profile with provided information
        for (int i = 0; i < this.travelerList.size(); i++) {
            TravProf deleteCandidate = (TravProf) this.travelerList.get(i);
            if (deleteCandidate.gettravAgentID().equals(travID) && deleteCandidate.getLastName().equals(lastName)) {
                this.travelerList.remove(i);
                successfulDeletion = true;
                }
            }
        return successfulDeletion;
    }

    //findProfile will search for an ID and last name and return a profile
    private TravProf findProfile(String travID, String lastName){
        int j = 0;
        for(int i=0; i<this.openTravelerIndex;i++){
            TravProf searchCandidate  = (TravProf) this.travelerList.get(i);
            if(searchCandidate.gettravAgentID().equals(travID) && searchCandidate.getLastName().equals(lastName)){
                j=i;
                break;
            }
        }
        return (TravProf) this.travelerList.get(j);
    }

    //findFirstProfile
    private TravProf findFirstProfile(){
        //this.currentTravelerIndex = 0;
        return (TravProf) this.travelerList.get(0);
    }

    //findNextProfile
    private TravProf findNextProfile(){
        TravProf nextProf = (TravProf) this.travelerList.get(this.currentTravelerIndex);
        currentTravelerIndex++;
        return nextProf;
    }

    private FileWriter writeAllTravProf(String fileName) throws IOException {
        //needs to output a file with name fileName that has all traveler profiles
        //in the travelerList
        FileWriter dbFile = new FileWriter(fileName);
        for (int i = 0; i<this.openTravelerIndex; i++){
            TravProf currentTrav = (TravProf) this.travelerList.get(i);
            dbFile.write("traveler ID: "+ currentTrav.gettravAgentID());
            dbFile.write("traveler Name: "+ currentTrav.getFirstName()+currentTrav.getLastName());
            dbFile.write("traveler Address: "+ currentTrav.getAddress());
            dbFile.write("traveler Phone: "+ currentTrav.getPhone());
            dbFile.write("traveler's Allergies: " + currentTrav.getMedCondInfo().getAlgType());
            dbFile.write("traveler's Illness: " + currentTrav.getMedCondInfo().getIllType());
            dbFile.write("traveler's Medical Contact: " + currentTrav.getMedCondInfo().getMdContact());
            dbFile.write("traveler's Medical Phone: "+ currentTrav.getMedCondInfo().getMdPhone() );
            dbFile.write("travel Type: "+ currentTrav.getTravelType());
            dbFile.write("trip Cost: " + Float.toString(currentTrav.getTripCost()));
            dbFile.write("payment Type: "+ currentTrav.getPaymentType());
            dbFile.write("----------------------------------");
        }
    return dbFile;
    }

    private void initializeDataBase(String dbName){
        //read in existing traveler profiles placed in file
    }
}
