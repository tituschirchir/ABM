package dataaccess.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dataaccess.helpers.DbObject;

public class Sector implements DbObject {
    private String sectorName;
    private int isParent;
    private int parent;

    public Sector() {
    }

    @JsonIgnore
    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }

    @JsonIgnore
    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
