package Book;

import Author.Author;

public  class book{
    private String BName;
    private int price;
    private String AName;

    public book(String BName, int price, String AName) {
        this.BName=BName;
        this.price = price;
        this.AName = AName;

    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getAName() {
        return AName;
    }

    public void setAName(String AName) {
        this.AName = AName;
    }

    @Override
    public String toString() {
        return "book{" +
                "BName='" + BName + '\'' +
                ", price=" + price +
                ", AName='" + AName + '\'' +
                '}';
    }
}