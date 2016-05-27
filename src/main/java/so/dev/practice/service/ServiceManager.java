package so.dev.practice.service;

import so.dev.practice.model.Service;
import so.dev.practice.model.ServiceModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by melvin on 2016. 5. 27..
 */
public class ServiceManager {
    public static final Queue SERVICE_QUEUE = new LinkedList<>();

    public String queueIndicator(){

        ArrayList<Service> serviceArrayList = new ArrayList<>();
        while(true){
            if(!(SERVICE_QUEUE.isEmpty())){
                if(SERVICE_QUEUE.poll() instanceof ServiceModel){

                }
                if(SERVICE_QUEUE.poll() instanceof Service){

                }
            }
        }
    }



}
