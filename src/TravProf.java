import java.io.Serializable;

public class TravProf implements Serializable {
    //declare all attributes
    private String travAgentID, firstName, lastName, address, phone, travelType, paymentType;
    private float tripCost;
    private MedCond medCondInfo;
    //constructor
    public TravProf(String travAgentID, String firstName, String lastName, String address, String phone,
                    float tripCost, String travelType, String paymentType, MedCond medCondInfo){
        this.travAgentID = travAgentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.tripCost = tripCost;
        this.travelType = travelType;
        this.paymentType = paymentType;
        this.medCondInfo = medCondInfo;
    }
    //all functions in this class are simple updates or attribute retrievals.
    //note that updateFirstName and updateLastName are private because the interface cannot modify these attributes (in specification)
    public String gettravAgentID() { return travAgentID; }
    public String getFirstName() {
        return firstName;
    }
    private void updateFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    private void updateLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void updateAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void updatePhone(String phone) {
        this.phone = phone;
    }
    public String getTravelType() {
        return travelType;
    }
    public void updateTravelType(String travelType) {
        this.travelType = travelType;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public void updatePaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public float getTripCost() {
        return tripCost;
    }
    public void updateTripCost(float tripCost) {
        this.tripCost = tripCost;
    }
    public MedCond getMedCondInfo() { return medCondInfo; }
    public void updateMedCondInfo(MedCond medCondInfo) { this.medCondInfo = medCondInfo; }
}
