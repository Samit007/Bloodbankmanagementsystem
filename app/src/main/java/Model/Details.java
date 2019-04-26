package Model;

public class Details {
    private String name;
    private String phoneNo;
    private String emailId;
    private String address;
    private String gender;
    private int imageId;
    private String blood;

    public Details(int imageId, String name, String phoneNo, String emailId, String address, String gender,  String blood) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
        this.gender = gender;
        this.imageId = imageId;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
