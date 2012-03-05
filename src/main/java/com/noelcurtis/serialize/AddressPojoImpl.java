package com.noelcurtis.serialize;

/**
 * User: noelcurtis
 * Date: 3/5/12
 * Time: 3:41 PM
 */
public class AddressPojoImpl implements Serializable{

    private String street;
    private String apartment;
    private String zipCode;

    public AddressPojoImpl(){
        this.street = "Street Name";
        this.apartment = "Apartment Number";
        this.zipCode = "123098";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toJson()throws Exception{
        return ObjectMapper.sharedInstance.getObjectMapper().writeValueAsString(this);
    }
}
