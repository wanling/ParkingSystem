import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-2
 * Time: 下午3:39
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingStrategy {
    public int getParking(Map<Integer, Parking> parkingList);
}
