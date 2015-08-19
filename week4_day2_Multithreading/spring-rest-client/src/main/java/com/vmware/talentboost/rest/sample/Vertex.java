package com.vmware.talentboost.rest.sample;

import java.util.ArrayList;

public class Vertex {
    private String value = "";
    private boolean isSystemRoot = false;
    private boolean isCollectable = true;
    private ArrayList<Vertex> childrens = null;
    
    public Vertex(String value, boolean isSystemRoot){
        this.value = value;
        this.setSystemRoot(isSystemRoot);
        this.childrens = new ArrayList<Vertex>();
    }

    public String getValue() {
        return value;
    }

    public boolean isSystemRoot() {
        return isSystemRoot;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (!(obj instanceof Vertex)) {
            return false;
        }

        Vertex temp = (Vertex) obj;
        return value.equals(temp.value);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((value == null) ? 0 : value.hashCode());
        return result;
    }
    
    @Override
    public String toString(){
        return this.value + " isRoot"+this.isSystemRoot + " isCollectable:"+this.isCollectable+"\n";
    }

    public boolean isCollectable() {
        return isCollectable;
    }

    public ArrayList<Vertex> getChildrens() {
        return childrens;
    }

    public void setSystemRoot(boolean isSystemRoot) {
        this.isSystemRoot = isSystemRoot;
    }

    public void setCollectable(boolean isCollectable) {
        this.isCollectable = isCollectable;
    }
}
