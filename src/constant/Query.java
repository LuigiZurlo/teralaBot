package constant;

public class Query {

    public final static String GET_SENSOR = "from Sensor s";
    public final static String GET_LOCATION = "from Location s where s.sensor_id= :sensor_id";

    public final static String GET_PARAMETER = "from Parameter";
    public final static String GET_LAST_PARAMETER = "from Parameter where name='Channel B'";
    public final static String GET_FIRST_PARAMETER = "from Parameter where name='Channel A'";

    public final static String GET_FIRST_MEASURE = "select min (timestamp)from Measurement where location_id= :location_id";

    public final static String GET_FIRST_MEASUREJ = "select min (m.timestamp)from Measurement m inner join location l inner join sensor s where s.id = 1"; // non funziona
    public final static String GET_ALL_LOCATIONS = "FROM Location";

    public static final String GET_PARAMETER_ELAB = "from Parameter2";
    public final static String GET_FIRST_MEASURE_AVG = "select min (timestamp) from Measurementavg where location_id= :location_id";

    public static final String GET_SENSOR_MEASURES = "from Measurementavg where location_id= :location_id and parameter2_id= :param_id";

    public static final String GET_LOCATION_TEST = "from Location where id=1";

    public static final String GET_LOCATION_TO_UPDATE = "from Location where id not in(27,38,39,40)"; // sensori non in teralab PA: 28-40-41-42
    
    public static final String GET_LAST_SENSOR_MEASURE = "from Measurementavg where location_id= :location_id and timestamp=(select max(timestamp)from Measurementavg where location_id= :location_id)";
     
    public static final String GET_LAST_MEASURES = "from Measurementavg where location_id= :location_id and timestamp= :timestamp";
}
