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
    private Map<Ticket,Car> ticketCarMap;

//    private Map<Ticket,Car> ticket_car_map;

    public Parking(int i) {
        emptyParingLot = i;
        ticketCarMap = new HashMap<Ticket, Car>();
    }

    public int getEmptyParingLot() {
        return emptyParingLot;
    }

    public  String park(Car a, Ticket b){
        if (emptyParingLot == 0){
            return "false";
        }
        ticketCarMap.put(b,a);
        emptyParingLot--;
        return "true";
    }

    public Car getCar(Ticket ticket) {
        Car res = this.ticketCarMap.get(ticket);
        if (res != null){
            ticketCarMap.remove(ticket);
            emptyParingLot ++;
        }
        return res;  //To change body of created methods use File | Settings | File Templates.
    }
}
