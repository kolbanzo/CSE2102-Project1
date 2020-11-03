import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TravProfDB implements Serializable{

    public int numTravelers; //how many travelers are in DB
    public String fileName; //name of DB
    public ArrayList<TravProf> travelerList; //array of all profiles in DB
    public int currentTravelerIndex; //used as an iterator

    //constructor
    public TravProfDB(String fileName) {
        this.fileName = fileName;
        this.numTravelers = 0;
        this.travelerList = new ArrayList<TravProf>();
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
                break;
            }
        }
        return successfulDeletion;
    }

    //findProfile will search for an ID and last name and return a profile
    public TravProf findProfile(String travID, String lastName){
        int j = -1;
        for(int i=0; i<this.travelerList.size();i++){
            TravProf searchCandidate  = this.travelerList.get(i);
            if(searchCandidate.gettravAgentID().equals(travID) && searchCandidate.getLastName().equals(lastName)){
                j=i;
                break;
            }
        }
        if(j == -1){return null;}
        return this.travelerList.get(j);
    }

    //findFirstProfile
    public TravProf findFirstProfile(){
        //this.currentTravelerIndex = 0;
        return this.travelerList.get(0);
    }

    //findNextProfile
    public TravProf findNextProfile(){
        TravProf nextProf = this.travelerList.get(this.currentTravelerIndex);
        currentTravelerIndex++;
        return nextProf;
    }

    /*public FileWriter writeAllTravProf(String fileName) throws IOException {
        //needs to output a file with name fileName that has all traveler profiles
        //in the travelerList
        FileWriter dbFile.txt = new FileWriter(fileName);
        for (int i = 0; i<this.openTravelerIndex; i++){
            TravProf currentTrav = (TravProf) this.travelerList.get(i);
            dbFile.txt.write("traveler ID: "+ currentTrav.gettravAgentID());
            dbFile.txt.write("traveler Name: "+ currentTrav.getFirstName()+currentTrav.getLastName());
            dbFile.txt.write("traveler Address: "+ currentTrav.getAddress());
            dbFile.txt.write("traveler Phone: "+ currentTrav.getPhone());
            dbFile.txt.write("traveler's Allergies: " + currentTrav.getMedCondInfo().getAlgType());
            dbFile.txt.write("traveler's Illness: " + currentTrav.getMedCondInfo().getIllType());
            dbFile.txt.write("traveler's Medical Contact: " + currentTrav.getMedCondInfo().getMdContact());
            dbFile.txt.write("traveler's Medical Phone: "+ currentTrav.getMedCondInfo().getMdPhone() );
            dbFile.txt.write("travel Type: "+ currentTrav.getTravelType());
            dbFile.txt.write("trip Cost: " + Float.toString(currentTrav.getTripCost()));
            dbFile.txt.write("payment Type: "+ currentTrav.getPaymentType());
            dbFile.txt.write("----------------------------------");
        }
    return dbFile.txt;
    }*/

    public void writeAllTravProf(String fileName) throws IOException{
        FileOutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(travelerList);
        objectOutputStream.close();
    }

    public void initializeDataBase(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        this.travelerList = (ArrayList<TravProf>)objectInputStream.readObject();
    }
}
