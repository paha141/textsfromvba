import abstractClasses.Spin;
import stayfrosty.StayFrostySpin;
import takesantasshop.TakeSantaSpin;

public class Main {
    public static void main(String[] args) {
        Spin spin = new StayFrostySpin(173, 4.00, 25, "7,6,6,6|0,0,0,0|4,0,0,0|7,7,7,8|8,8,8,10");
        spin.showMessage();
    }
}
