package main.java.com.aviatickets.model;


import java.util.Map;

public class Aircraft {
    private String type;
    private Map<CabinType, Integer> cabinTypeSeatsMap;

    public Aircraft(String type, Map<CabinType, Integer> cabinTypeSeatsMap) {
        this.type = type;
        this.cabinTypeSeatsMap = cabinTypeSeatsMap;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<CabinType, Integer> getCabinTypeSeatsMap() {
        return cabinTypeSeatsMap;
    }

    public void setCabinTypeSeatsMap(Map<CabinType, Integer> cabinTypeSeatsMap) {
        this.cabinTypeSeatsMap = cabinTypeSeatsMap;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "type='" + type + '\'' +
                ", cabinTypeSeatsMap=" + cabinTypeSeatsMap +
                '}';
    }
}
