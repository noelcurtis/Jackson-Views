package com.noelcurtis.serialize;

import org.codehaus.jackson.map.SerializationConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: noelcurtis
 * Date: 3/5/12
 * Time: 3:40 PM
 */
public class MyPoJoImpl implements Serializable{

    private String first_name;
    private String last_name;
    private AddressPojoImpl addressImpl;

    public MyPoJoImpl(){
        this.first_name = "foo";
        this.last_name = "bar";
        this.addressImpl = new AddressPojoImpl();
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public AddressPojoImpl getAddressImpl() {
        return addressImpl;
    }

    public void setAddressImpl(AddressPojoImpl addressImpl) {
        this.addressImpl = addressImpl;
    }

    public String toJson()throws Exception{
        return ObjectMapper.getSharedInstance().getObjectMapper().writeValueAsString(this);
    }

    /**
     * A Method used to render list of MyPojo  objects as JSON with Custom Root Node.
     * @param listOfPojos
     * @return
     * @throws Exception
     */
    public static String listToJson(List<MyPoJoImpl> listOfPojos)throws Exception{
        // Reset the shared object mapper to not wrap objects
        ObjectMapper.getSharedInstance().getObjectMapper().configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false);
        // Create a Map with Key as your custom root and value as the list
        Map<String, Object> listOfPojosWithRoot = new HashMap<String, Object>();
        listOfPojosWithRoot.put("MyPoJos", listOfPojos);
        // Render the Map as JSON
        String jsonString = ObjectMapper.getSharedInstance().getObjectMapper().writeValueAsString(listOfPojosWithRoot);
        // Reset the share object mapper to wrap again
        ObjectMapper.getSharedInstance().getObjectMapper().configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
        return jsonString;
    }
}
