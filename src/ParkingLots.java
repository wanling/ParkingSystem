import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLots {
    private Map<Integer, Parking> parkMap;
    private int emptyCount;

    public ParkingLots(List<Parking> parkList) {
        parkMap = new HashMap<Integer, Parking>();
        for (int i = 0; i < parkList.size(); i++){
            parkMap.put(i, parkList.get(i));
            emptyCount += parkList.get(i).getEmptyParingLot();
        }
    }

    public Ticket parking(Car car) {
        for (Integer id : parkMap.keySet()){
            Parking parking = parkMap.get(id);
            if (parking.getEmptyParingLot() > 0){
                 Ticket t = new Ticket(id);
                 parking.park(car, t);
                emptyCount --;
                return t;
            }
        }
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public int getAvaiable() {
        return emptyCount;
    }

    public Car getCar(Ticket t) {
        if (t.getParkingLotNO() == null)
            return  null;
        Parking p = parkMap.get(t.getParkingLotNO());
        Car car = p.getCar(t);
        if (car != null)
            emptyCount++;
        return  car;
       // return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
