public class TravProfDB {

    private int numTravelers; //how many travelers are in DB
    private int openTravelerIndex; //gives position in travelerList of next open spot
    private String fileName; //name of DB
    private TravProf[] travelerList; //array of all profiles in DB
    private int currentTravelerIndex; //used as an iterator

    //constructor
    public TravProfDB(String fileName) {
        this.fileName = fileName;
        this.numTravelers = 0;
        this.travelerList = new TravProf[10];
        this.openTravelerIndex = 0;
        this.currentTravelerIndex = 0;
    }

    //Insert new profile accepts a TravProf as input and inserts it into the travelerList
    private void insertNewProfile(TravProf profile) {
        //make sure the array can fit the new profile
        if (this.travelerList.length <= this.openTravelerIndex) {
            //if we need more space, double the length of the list
            TravProf[] newTravelerList = new TravProf[this.numTravelers * 2];
            //copy old data into bigger list
            for (int i = 0; i < this.travelerList.length; i++) {
                newTravelerList[i] = this.travelerList[i];
            }
            this.travelerList = newTravelerList;
        }
        //now that we have space, insert new profile, and add to the number of travelers
        //also update the index which points to the next "open" spot
        this.travelerList[this.openTravelerIndex] = profile;
        this.openTravelerIndex++;
        this.numTravelers++;
    }

    //delete profile removes a profile from travelerList and tells us if it worked (boolean)
    private boolean deleteProfile(String travID, String lastName) {
        boolean successfulDeletion = false;
        //find a profile with provided information
        for (int i = 0; i < this.openTravelerIndex; i++) {
            TravProf deleteCandidate = this.travelerList[i];
            if (deleteCandidate.gettravAgentID().equals(travID) && deleteCandidate.getLastName().equals(lastName)) {
                for (int j = i; j < this.openTravelerIndex - 1; j++) {
                    travelerList[j] = travelerList[j + 1];
                }
                successfulDeletion = true;
            }
        }
        if(successfulDeletion){this.openTravelerIndex--;}
        return successfulDeletion;
    }

    //findProfile will search for an ID and last name and return a profile
    private TravProf findProfile(String travID, String lastName){
        for(int i=0; i<this.openTravelerIndex;i++){
            TravProf searchCandidate  = this.travelerList[i];
            if(searchCandidate.gettravAgentID().equals(travID) && searchCandidate.getLastName().equals(lastName)){
                return searchCandidate;
                //int j = i
            }
        }
        //this says missing return statement, but a travProf should be returned if it exists in the list?
        //return this.travelerList[j]
    }

    //findFirstProfile
    private TravProf findFirstProfile(){
        //this.currentTravelerIndex = 0;
        return this.travelerList[0];
    }

    //findNextProfile
    private TravProf findNextProfile(){
        TravProf nextProf = this.travelerList[this.currentTravelerIndex];
        currentTravelerIndex++;
        return nextProf;
    }

    private void writeAllTravProf(String fileName){
        //needs to output a file with name fileName that has all traveler profiles
        //in the travelerList
    }

    private void initializeDataBase(String dbName){
        //read in existing traveler profiles placed in file
    }
}
