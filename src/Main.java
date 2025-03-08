import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
    }

    public static Request createRequest() throws UnknownHostException {
        int randomNumber = (int) (Math.random() * 100);
        int secondRandomNumber = (int) (Math.random() * 100);

        String ip = InetAddress.getLocalHost().getHostAddress();

        String requestType = (randomNumber % 2 == 0) ? "GET" : "POST";
        String responseCode = (secondRandomNumber % 2 == 0) ? "200" : "400";
        LocalDateTime dateTime = LocalDateTime.now();
        Request request = new Request(ip, dateTime, requestType, responseCode);
        return request;
    }

}
