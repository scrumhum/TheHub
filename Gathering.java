import javax.xml.stream.Location;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

//TODO Fix this so that it will work with DB
public class Gathering {
    // This is meant to be a temporary event object and should be changed in the future
    public Gathering(String gatheringName, Time gatheringTime, Date gatheringDate, Location gatheringLocation) {
        this.gatheringName = gatheringName;
        this.gatheringTime = gatheringTime;
        this.gatheringDate = gatheringDate;
        this.gatheringLocation = gatheringLocation;
    }
    String gatheringName;

    Time gatheringTime;

    Date gatheringDate;

    //User<User> volunteers = new ArrayList<User>();

    Location gatheringLocation = new Location() {
        @Override
        public int getLineNumber() {
            return 0;
        }

        @Override
        public int getColumnNumber() {
            return 0;
        }

        @Override
        public int getCharacterOffset() {
            return 0;
        }

        @Override
        public String getPublicId() {
            return null;
        }

        @Override
        public String getSystemId() {
            return null;
        }
    };
}
