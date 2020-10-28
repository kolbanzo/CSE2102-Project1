import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TravProfDB {

    public int numTravelers; //how many travelers are in DB
    public int openTravelerIndex; //gives position in travelerList of next open spot
    public String fileName; //name of DB
    public ArrayList<TravProf> travelerList; //array of all profiles in DB
    public int currentTravelerIndex; //used as an iterator

    //constructor
    public TravProfDB(String fileName) {
        this.fileName = fileName;
        this.numTravelers = 0;
        this.travelerList = new ArrayList<TravProf>();
        this.openTravelerIndex = 0;
        this.currentTravelerIndex = 0;
    }

    //Insert new profile accepts a TravProf as input and inserts it into the travelerList
    public void insertNewProfile(TravProf profile) {
            this.travelerList.add(profile);
        this.numTravelers++;
    }

    //delete profile removes a profile from travelerList and tells us if it worked (boolean)
    public boolean deleteProfile(String travID, String lastName) {
        boolean successfulDeletion = false;
        //find a profile with provided information
        for (int i = 0; i < this.travelerList.size(); i++) {
            TravProf deleteCandidate = this.travelerList.get(i);
            if (deleteCandidate.gettravAgentID().equals(travID) && deleteCandidate.getLastName().equals(lastName)) {
                this.travelerList.remove(i);
                successfulDeletion = true;
                }
            }
        return successfulDeletion;
    }

    //findProfile will search for an ID and last name and return a profile
    public TravProf findProfile(String travID, String lastName){
        int j = 0;
        for(int i=0; i<this.openTravelerIndex;i++){
            TravProf searchCandidate  = this.travelerList.get(i);
            if(searchCandidate.gettravAgentID().equals(travID) && searchCandidate.getLastName().equals(lastName)){
                j=i;
                break;
            }
        }
        return (TravProf) this.travelerList.get(j);
    }

    //findFirstProfile
    public TravProf findFirstProfile(){
        //this.currentTravelerIndex = 0;
        return (TravProf) this.travelerList.get(0);
    }

    //findNextProfile
    public TravProf findNextProfile(){
        TravProf nextProf = (TravProf) this.travelerList.get(this.currentTravelerIndex);
        currentTravelerIndex++;
        return nextProf;
    }

    public FileWriter writeAllTravProf(String fileName) throws IOException {
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

    public void initializeDataBase(String dbName){
        //read in existing traveler profiles placed in file
    }
}
