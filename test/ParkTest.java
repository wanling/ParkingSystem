import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public class ParkTest {
    Parking parkentity;

    @Before
    public void init() {
        parkentity = new Parking(100);
    }
    @Test    //停车场有空车位，停车成功，空车位-1
    public void park_have_empty_port(){
        String car1 = "京A12345";
        Ticket t = new Ticket(car1);
        Car a = new Car();
        String res = parkentity.park(a,t);
        Assert.assertEquals("Park Successful",res);
    }

    @Test     //停车场有一辆车，取车成功，空车位+1
    public void park_hava_a_car(){
        String car2 = "京A23456";
        Ticket t = new Ticket(car2);
        Car b = new Car();
        parkentity.park(b,t);
        Car res =  parkentity.getCar(t);
        Assert.assertEquals(b,res);
    }

    @Test      //停车场没有空车位，停车失败
    public  void park_with_not_emptyPark(){
        int len = parkentity.getEmptyParingLot();
        for (int i = 0; i < len; i++){
            Ticket t = new Ticket("Car"+i);
            Car x = new Car();
            parkentity.park(x,t);
        }
   //     Assert.assertEquals(0,parkentity.getEmptyParingLot()) ;
        String car3 = "京A34567";
        Ticket t = new Ticket(car3);
        Car c =new Car();
        String res = parkentity.park(c,t);

        Assert.assertEquals("Park Failure",res);
    }

    @Test       //一个空的停车场，取车失败
    public void park_is_empty(){
        String car4 = "京A45678";
        Ticket t = new Ticket(car4);
        Car res = parkentity .getCar(t);
        Assert .assertEquals(null,res );
    }

    @Test         //用有效的停车凭证可以取到车，用无效的停车凭证不能取到车
    public  void get_car_with_invalid_permit(){
        String car4 = "京A56789";
        Ticket t = new Ticket(car4) ;
        Car res = parkentity.getCar(t);
        Assert.assertEquals(null,res);
    }

    @Test   //有效的停车凭证不能取两次车
    public void a_valid_permit_can_get_the_car_once(){
        String car5 = "京A67890";
        Ticket t = new Ticket(car5);
        Car e = new Car();
        parkentity.park(e,t);
        Car res1 =  parkentity.getCar(t);
        Assert.assertEquals(e,res1);

        Car res2 =  parkentity.getCar(t);
        Assert.assertEquals(null,res2);
    }

    /**
    *  多个停车场，停车
    */
    @Test
    public void parkBoy_ShouldParkCar(){
        int maxParkingNum = 20;
        Car car = new Car();
        List<Parking> parkList = new ArrayList<Parking>();
        Parking park1 = new Parking(maxParkingNum);
        Parking park2 = new Parking(10);
        parkList.add(park1);
        parkList.add(park2);
        ParkingLots parkboy = new ParkingLots(parkList);
        Ticket ticket = parkboy.parking(car);

        Assert.assertEquals(maxParkingNum-1, park1.getEmptyParingLot());

    }

}
