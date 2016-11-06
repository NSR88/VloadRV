package com.vload.ex;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 02/11/2016.
 */

public class RoyListItems implements Serializable{
    public List<RoyList> getItems() {
        return items;
    }

    public void setItems(List<RoyList> items) {
        this.items = items;
    }
    @Expose
    List<RoyList> items;
}
