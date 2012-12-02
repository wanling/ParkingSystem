import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
public class SmartParking implements ParkingStrategy {
    public int getParking(Map<Integer, Parking> parkingList){
        int maxEmpty = 0;
        int res = -1;
        for (int key : parkingList.keySet()){
            if (maxEmpty < parkingList.get(key).getEmptyParingLot()) {
                maxEmpty = parkingList.get(key).getEmptyParingLot();
                res = key;
            }
        }
        return res;
    }
}
