import java.io.*;
import java.util.*;

public class EventScheduler {
    static class Event {
        String name;
        int startTime;
        int endTime;

        Event(String name, int startTime, int endTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return name + ": " + startTime + "-" + endTime;
        }
    }

    public static void main(String[] args) {
        String filePath = "eventsfile.txt";
        List<Event> events = new ArrayList<>();

        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int startTime = Integer.parseInt(parts[1]);
                int endTime = Integer.parseInt(parts[2]);
                events.add(new Event(name, startTime, endTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        events.sort(Comparator.comparingInt(e -> e.startTime));

        
        int lastEndTime = -1;
        for (Event event : events) {
            if (event.startTime >= lastEndTime) {
                System.out.println(event);
                lastEndTime = event.endTime;
            }
        }
    }
}
