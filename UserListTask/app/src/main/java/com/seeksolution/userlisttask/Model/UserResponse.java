package com.seeksolution.userlisttask.Model;

import java.util.ArrayList;

public class UserResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<User> data;

    public UserResponse(int page, int per_page, int total, int total_pages, ArrayList<User> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public ArrayList<User> getData() {
        return data;
    }
}
