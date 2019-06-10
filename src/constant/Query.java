package constant;

public class Query {

    public static final String GET_SENSOR_MEASURES = "from Measurementavg where location_id= :location_id and parameter2_id= :param_id order by timestamp";

    public static final String GET_LOCATION_TEST = "from Location where id=1";

    public static final String GET_LOCATION_TO_UPDATE = "from Location where id not in(27,38,39,40)"; // sensori non in teralab PA: 28-40-41-42
//public static final String GET_LOCATION_TO_UPDATE = "from Location where id in (4)"; // sensore di test

    public static final String GET_LAST_MEASURES = "from Measurementavg where location_id= :location_id and timestamp= :timestamp";
}
