package com.example.adi.edcpay.model;

import java.util.ArrayList;

public class HistoryHeader {
    String header;
    ArrayList<HistoryChildren> listHistoryChildren;

    public ArrayList<HistoryChildren> getListHistoryChildren() {
        return listHistoryChildren;
    }

    public void setListHistoryChildren(ArrayList<HistoryChildren> listHistoryChildren) {
        this.listHistoryChildren = listHistoryChildren;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}
