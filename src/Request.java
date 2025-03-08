import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.net.InetAddress;

public class Request {

    private final String ip;
    private final LocalDateTime dateTime;
    private final String requestType;
    private final String responseCode;

    public Request(String ip, LocalDateTime dateTime, String requestType, String responseCode) {
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

    public String getResponseCode() {
        return responseCode;
    }



    @Override
    public String toString(){
        return String.format("%p - %t %r %d ",ip,requestType, responseCode, dateTime);
    }
}
