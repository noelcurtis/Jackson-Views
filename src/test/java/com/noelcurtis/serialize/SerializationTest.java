package com.noelcurtis.serialize;

import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * User: noelcurtis
 * Date: 3/5/12
 * Time: 4:09 PM
 */
public class SerializationTest {

    @Test
    public void testSerializePoJos(){

        try{
            MyPoJoImpl myPoJo = new MyPoJoImpl();
            System.out.println(myPoJo.toJson());
        }catch (Exception ex){
            fail(ex.toString());
        }

    }

    @Test
    public void testSerializableLists(){

        try{
            ArrayList<MyPoJoImpl> listOfPojos = new ArrayList<MyPoJoImpl>();
            listOfPojos.add(new MyPoJoImpl());
            listOfPojos.add(new MyPoJoImpl());
            listOfPojos.add(new MyPoJoImpl());
            System.out.println(MyPoJoImpl.listToJson(listOfPojos));

        }catch(Exception ex){
            fail(ex.toString());
        }
    }

}
