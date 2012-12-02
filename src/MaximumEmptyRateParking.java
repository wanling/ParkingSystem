import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午4:47
 * To change this template use File | Settings | File Templates.
 */
public class MaximumEmptyRateParking implements  ParkingStrategy{
    public int  getParking(Map<Integer, Parking> parkingList){
        int res = -1;
        double maxer = 0.0;
        double er;
        for (int key : parkingList.keySet()) {
             int capacity = parkingList.get(key).getCapacity();
             if (capacity > 0){
                 er = (double)parkingList.get(key).getEmptyParingLot()/capacity;
                 if (er > maxer){
                     maxer = er;
                     res = key;
                 }
             }
        }
        return res;
    }
}
