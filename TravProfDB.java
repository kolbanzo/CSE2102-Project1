public class TravProfDB {

    private int numTravelers; //how many travelers are in DB
    private int currentTravelerIndex; //gives position in travelerList of next open spot
    private String fileName; //name of DB
    private TravProf[] travelerList; //array of all profiles in DB

    //initializer
    public TravProfDB(String fileName){
        this.fileName = fileName;
        this.numTravelers = 0;
        this. travelerList = new TravProf[10];
        this.currentTravelerIndex= 0;
    }
    //Insert new profile accepts a TravProf as input and inserts it into the travelerList
    private void insertNewProfile(TravProf profile){
        //make sure the array can fit the new profile
        if (this.travelerList.length <= this.currentTravelerIndex){
            //if we need more space, double the length of the list
            TravProf[] newTravelerList = new TravProf[this.numTravelers * 2];
            //copy old data into bigger list
            for(int i = 0; i < this.travelerList.length; i++){
                newTravelerList[i] = this.travelerList[i];
            }
            this.travelerList = newTravelerList;
        }
        //now that we have space, insert new profile, and add to the number of travelers
        //also update the index which points to the next "open" spot
        this.travelerList[this.currentTravelerIndex] = profile;
        this.currentTravelerIndex++;
        this.numTravelers++;
    }
    //delete profile removes a profile from travelerList and tells us if it worked (boolean)
    private boolean deleteProfile(String travID, String lastName){
        boolean successfulDeletion = false;
        //find a profile with provided information
        for (int i = 0; i< this.currentTravelerIndex; i++){
            TravProf deleteCandidate = this.travelerList[i];
            if((deleteCandidate.gettravAgentID() == travID) && (deleteCandidate.getLastName() == lastName) ){
                for(int j = i; j<this.currentTravelerIndex; j++){


                }
            }

        }

    }


}
