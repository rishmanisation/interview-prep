import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HacklandElection {

    public static void main(String[] args) {
        String[] votes = { "victor", "victor", "veronica", "ryan", "dave", "maria", "farah", "farah", "ryan", "veronica" };
        Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (String vote : votes) {
            if (map.containsKey(vote)) {
                map.put(vote, map.get(vote) + 1);
            }
            else {
                map.put(vote, 1);
            }
        }
        
        for(String person : map.keySet()) {
          System.out.println(person + ":" + map.get(person));
        }

        String winner = Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey();
        System.out.println("Winner: " + winner);
    }
}
