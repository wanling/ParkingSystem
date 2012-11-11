import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class Parking {
    private  int  emptyParingLot;
    private List<Car> carList;
//    private Map<Ticket,Car> ticket_car_map;

    public Parking(int i) {
        emptyParingLot = i;
        carList = new ArrayList<Car>();
//        ticket_car_map = new HashMap<Ticket, Car>();
    }

    public int getEmptyParingLot() {
        return emptyParingLot;
    }

    public String park(Car a) {
        if (emptyParingLot == 0){
            return "false";
        }
        carList.add(a);
        emptyParingLot --;
        return "true";
//       return  false;

    }

    public Car getCar(Ticket carName) {
        Car res = null;
        for (Car car : carList)
           if (car.getTicket().equals(carName)) {
//            if (carName.equals(car.getId()))  {
                res = car;
                break;
            }
        if (res != null){
            carList.remove(res);
            emptyParingLot ++;
        }
        return res;  //To change body of created methods use File | Settings | File Templates.
    }
}
