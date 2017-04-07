package me.jakir.checkboxwithlistview;


public class ShoppingList {
    String title;
    boolean status;

    public ShoppingList(String title, boolean status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
