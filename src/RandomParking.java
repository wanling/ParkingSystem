import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:51
 * To change this template use File | Settings | File Templates.
 */
public class RandomParking implements  ParkingStrategy {
    public int getParking(Map<Integer, Parking> parkingList) {
        int res = -1;
        for (int key : parkingList.keySet()){
            if (parkingList.get(key).getEmptyParingLot() > 0){
                return  key;
            }
        }
        return  res;
    }
}
