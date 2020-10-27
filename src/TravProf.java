import java.io.Serializable;

public class TravProf implements Serializable {
    private String travAgentID, firstName, lastName, address, phone, travelType, paymentType;
    float tripCost;
    //MedCond medCondInfo;
    public TravProf(String travAgentID, String firstName, String lastName, String address, String phone,
                    float tripCost, String travelType, String paymentType){
        this.travAgentID = travAgentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.tripCost = tripCost;
        this.travelType = travelType;
        this.paymentType = paymentType;
    }

    public String gettravAgentID() {
        return travAgentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void updateLastName(String lastName) {
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

/*    public MedCond getMedCondInfo() {
        return medCond;
    }

    public void updateMedCondInfo(MedCond medCondInfo) {
        this.medCondInfo = medCondInfo;
    }*/
}
