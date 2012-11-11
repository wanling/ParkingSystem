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
    @Test
    public void park_have_empty_port(){
        Car a = new Car("bmw");
        String res = parkentity.park(a);
        Assert.assertEquals("true",res);
    }

    @Test
    public void park_hava_a_car(){
        Car b = new Car("N12345");
        parkentity.park(b);
        Car res =  parkentity.getCar("N12345");
        Assert.assertEquals(b,res);
    }

    @Test
    public  void park_with_not_emptyPark(){
        int len = parkentity.getEmptyParingLot();
        for (int i = 0; i < len; i++){
            Car x = new Car("Car"+i);
            parkentity.park(x);
        }
   //     Assert.assertEquals(0,parkentity.getEmptyParingLot()) ;
        Car c = new Car("hello world");
        String res = parkentity.park(c);

        Assert.assertEquals("false",res);
    }

    @Test
    public void park_




}
