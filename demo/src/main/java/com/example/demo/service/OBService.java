package com.example.demo.service;

import com.example.demo.models.OB;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OBService {
    private static List<OB> bootcampers = new ArrayList<>();

    public static List<OB> getAll() {

        return bootcampers;
    }
    public void add(OB ob){
        bootcampers.add(ob);
    }
    public static OB getOne(String name){
        for(OB ob : bootcampers){
            if(ob.getName().equalsIgnoreCase(name))
                return ob;
        }
        return null;
    }

    public static void delete(String name){
        for(OB ob : bootcampers){
            if(ob.getName().equalsIgnoreCase(name))
                bootcampers.remove(ob);
        }
    }

    public static void deleteAll(){
        bootcampers.clear();
        }
    }

