import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        while (true) {

            List<Request> logs = Log.generateLogs(10); 

            LogProcessor.processLogsConcurrently(logs);
            System.out.println("------------------------------------------------");

            analyzeLogs(logs);

            try {
                TimeUnit.SECONDS.sleep(10);

            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public static Request createRequest() throws UnknownHostException {
        int randomNumber = (int) (Math.random() * 100);
        int secondRandomNumber = (int) (Math.random() * 100);

        String ip = InetAddress.getLocalHost().getHostAddress();

        String requestType = (randomNumber % 2 == 0) ? "GET" : "POST";
        int responseCode = (secondRandomNumber % 2 == 0) ? 200 : 400;
        LocalDateTime dateTime = LocalDateTime.now();
        Request request = new Request(ip, dateTime, requestType, responseCode);
        return request;
    }

    public static void analyzeLogs(List<Request> logs){
        List<Request> filteredLogs = filterLogs(logs);
        Map<String, Long> requestsCount = countRequestType(logs);

        System.out.println("Los logs con código de respuesta 400 son:");
        filteredLogs.forEach((log) -> System.out.println(log));
        System.out.println("----------------------------");
        System.out.println("Los logs contados por tipo de petición son:");

        for (Map.Entry<String, Long> entry : requestsCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
    }
    
    //filtrar logs con codigo de error 400
    public static List<Request> filterLogs(List<Request> logs){
        List<Request> filteredLogs = logs.stream()
                .filter(log -> log.getResponseCode() == 400)
                .collect(Collectors.toList());
        return filteredLogs;
    } 

    // Cuenta el número de logs por tipo de solicitud
    public static Map<String, Long> countRequestType(List<Request> logs){
        return logs.stream()
        .collect(Collectors.groupingBy(Request::getRequestType, Collectors.counting()));
    }
    


}
