import java.util.ArrayList;
import java.util.List;

public class Log {
    public static List<Request> generateLogs(int numberOfLogs){
        List<Request> logs = new ArrayList<>();

        for (int i= 0; i< numberOfLogs; i++){
            try {
                Request request = Main.createRequest();
                logs.add(request);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return logs;
        
    }
}