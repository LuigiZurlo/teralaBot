package constant;

public class EndPoint {
//String request = "https://thingspeak.com/channels/538119/feed.csv?api_key=ANSQ94MPFWB6LIRN&offset=0&average=0&round=2&start=21-09-2018&end=23-09-2018";

public static String GET_DEVICES ="https://thingspeak.com/channels/%s/feed.json?api_key=%s&offset=0&average=0&round=2&start=%s&end=%s";
	
public static String GET_AVG ="https://thingspeak.com/channels/%s/feed.json?api_key=%s&offset=0&average=10&round=2&start=%s&end=%s";
}
