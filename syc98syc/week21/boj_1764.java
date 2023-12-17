import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class boj1764_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashSet<String> noHearSet = new HashSet<>();
        ArrayList<String> noHearNoSee = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            noHearSet.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (noHearSet.contains(name)) {
                noHearNoSee.add(name);
            }
        }

        System.out.println(noHearNoSee.size());
        Collections.sort(noHearNoSee);
        for (String name : noHearNoSee) {
            System.out.println(name);
        }
    }
}
