//import java.net.UnknownHostException;
import java.time.LocalDateTime;
//import java.net.InetAddress;
import java.time.format.DateTimeFormatter;

public class Request {

    private final String ip;
    private final LocalDateTime dateTime;
    private final String requestType;
    private final int responseCode;

    public Request(String ip, LocalDateTime dateTime, String requestType, int responseCode) {
        this.ip = ip;
        this.dateTime = dateTime;
        this.requestType = requestType;
        this.responseCode = responseCode;
    }

    public String getIp() {
        return ip;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getRequestType() {
        return requestType;
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd' / 'HH:mm");
        return (ip + " - " + requestType + " " + responseCode + " " + dateTime.format(formatter));
    }
}
