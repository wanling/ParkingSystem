/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午4:50
 * To change this template use File | Settings | File Templates.
 */
public class Ticket {
    private Integer parkingLotNO;
    private  String id;

    public Ticket(String id, Integer parkingLotNO) {
        this.id = id;
        this.parkingLotNO = parkingLotNO;
    }

    public Ticket(Integer id) {
        parkingLotNO = id;
        //To change body of created methods use File | Settings | File Templates.
    }

    public Ticket() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public Integer getParkingLotNO() {
        return parkingLotNO;
    }

    public String getId() {
        return id;
    }

    public Ticket(String id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Ticket)) return false;
//
//        Ticket ticket = (Ticket) o;
//
//        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
}
