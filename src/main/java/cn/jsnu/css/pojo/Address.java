package cn.jsnu.css.pojo;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/23 14:09
 */
public class Address {
    private String addressId;
    private String userId;
    private String province;
    private String city;
    private String district;
    private String detailAddress;
    private String contact;
    private String phoneNum;

    public Address(){}
    public Address(String addressId,String userId, String province, String city, String district, String detailAddress, String contact, String phoneNum){
        this.addressId=addressId;
        this.userId=userId;
        this.province=province;
        this.city=city;
        this.district=district;
        this.detailAddress=detailAddress;
        this.contact=contact;
        this.phoneNum=phoneNum;
    }
    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", userId='" + userId + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", contact='" + contact + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
