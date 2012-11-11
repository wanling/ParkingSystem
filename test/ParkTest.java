import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.StyledEditorKit;

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
        parkentity = new Parking(10);
    }
    @Test    //停车场有空车位，停车成功，空车位-1
    public void park_have_empty_port(){
        Ticket t = new Ticket("bmw");
        Car a = new Car(t);
        String res = parkentity.park(a);
        Assert.assertEquals("true",res);
    }

    @Test     //停车场有一辆车，取车成功，空车位+1
    public void park_hava_a_car(){
        Ticket t = new Ticket("N12345");
        Car b = new Car(t);
        parkentity.park(b);
        Car res =  parkentity.getCar(t);
        Assert.assertEquals(b,res);
    }

    @Test      //停车场没有空车位，停车失败
    public  void park_with_not_emptyPark(){
        int len = parkentity.getEmptyParingLot();
        for (int i = 0; i < len; i++){
            Ticket t = new Ticket("Car"+i);
            Car x = new Car(t);
            parkentity.park(x);
        }
   //     Assert.assertEquals(0,parkentity.getEmptyParingLot()) ;
        Ticket t = new Ticket("world");
        Car c =new Car(t);
        String res = parkentity.park(c);

        Assert.assertEquals("false",res);
    }

    @Test       //一个空的停车场，取车失败
    public void park_is_empty(){
        Car d = null;
        Ticket t = new Ticket("M67890");
        Car res = parkentity .getCar(t);
        Assert .assertEquals(d,res );
    }

    @Test         //用有效的停车凭证可以取到车，用无效的停车凭证不能取到车
    public  void get_car_with_invalid_permit(){
        String id = "XN12345";
        String resId = null;
        String equal = "false";
        Ticket t = new Ticket("XN12345") ;
        Car res = parkentity.getCar(t);
        if (res != null)
            resId = res.getId();
        if (id.equals(resId))
            equal = "true";
        Assert.assertEquals("false",equal );
    }

    @Test   //有效的停车凭证不能取两次车
    public void a_valid_permit_can_get_the_car_once(){
        String id = "XN12345";
        Ticket t = new Ticket(id);
        Car e = new Car(t);
        parkentity.park(e);
        Car res =  parkentity.getCar(t);
        Assert.assertEquals(e,res);

        String resStr = "NotNull";
        Car secres =  parkentity.getCar(t);
        if  (secres == null)
             resStr = "null";
        Assert.assertEquals("null",resStr);
    }





}
