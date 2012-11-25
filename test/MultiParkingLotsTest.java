import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午3:17
 * To change this template use File | Settings | File Templates.
 */
public class MultiParkingLotsTest {
    ParkingLots parkingLots;
    @Before
    public void init(){
        List<Parking> parkList = new ArrayList<Parking>();
        Parking park1 = new Parking(20);
        Parking park2 = new Parking(10);
        parkList.add(park1);
        parkList.add(park2);
        parkingLots = new ParkingLots(parkList);
    }

    /**
     * 两个空的停车场，来一辆车，顺利停车。
     */
    @Test
    public void twoEmptyParklotsParkCar(){
        Car car = new Car();
        Ticket t = parkingLots.parking(car);

        Assert.assertEquals(29,parkingLots.getAvaiable());
    }

    /**
     * 有一个合法的ticket，取车，顺利取车
     */
    @Test
    public void getCarByValidTicket(){
        Car car = new Car();
        Ticket t = parkingLots.parking(car);
        Car resCar = parkingLots.getCar(t);

        Assert.assertEquals(car,resCar);
    }

    /**
     * 一辆从未停过的车，取车，显示失败
     */
    @Test
    public void getCarNeverParking(){
        Ticket t = new Ticket();
        Car resCar = parkingLots.getCar(t);

        Assert.assertEquals(null, resCar);
    }

    /**
     * 两个满的停车场， 停车， 失败
     */
    @Test
    public void twoEmptyParkinglotsParkCar(){
        int emptyCount = parkingLots.getAvaiable();
        for (int i = 0; i < emptyCount; i++){
            Car x = new Car();
            Ticket tx = parkingLots.parking(x);
        }
        Assert.assertEquals(0,parkingLots.getAvaiable());
        Car car = new Car();
        Ticket t = parkingLots.parking(car);
        Assert.assertEquals(null, t);

    }

    @Test
    public void find_better_parking()
    {
        int curEmpty = parkingLots.getAvaiable();
        Car car = new Car();
        Ticket t = parkingLots.parkingSmart(car);

        Assert.assertEquals(curEmpty-1,parkingLots.getAvaiable());
    }

}
