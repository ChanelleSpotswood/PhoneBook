package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        if (phonebook.containsKey(name)){
            phonebook.get(name).add(phoneNumber);
        }
        else {
            phonebook.put(name, new ArrayList<>());
            phonebook.get(name).add(phoneNumber);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String n : phoneNumbers) {
            add(name, n);
        }
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (String key : phonebook.keySet()){
            if (phonebook.get(key).contains(phoneNumber)){
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> contacts = new ArrayList<>();

        for (String key : phonebook.keySet()){
            contacts.add(key);
        }

        return contacts;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
