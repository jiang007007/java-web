package clone;

public class Address  {
    public int provinceNo;
    public int cityNo;
    public int StreetNo;
    public Address(){

    }

    public Address(int provinceNo, int cityNo, int streetNo) {
        this.provinceNo = provinceNo;
        this.cityNo = cityNo;
        this.StreetNo = streetNo;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address(1, 2, 3);
        Object clone = address.clone();
        System.out.println(address == clone);
    }
}
