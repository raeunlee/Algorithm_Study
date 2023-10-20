import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 단어의 개수
        int m = Integer.parseInt(st.nextToken()); // 단어의 길이

        HashMap<String, Integer> wordMap = new HashMap<>();
        for (int t = 0; t < n; t++) {
            String word = br.readLine();
            if (word.length() < m) continue; // 길이가 m 이하면 패스
            int cnt = wordMap.getOrDefault(word, 0); // 빈도수 누적, 처음엔 0
            wordMap.put(word, cnt + 1);
        }

        List<String> wordList = wordMap.keySet().stream().collect(Collectors.toList()); // map에서 key값(영단어)만 뽑아서 리스트로 만듦
        wordList.sort((o1, o2) -> {
            int c1 = wordMap.get(o1); // 빈도수
            int c2 = wordMap.get(o2); // 빈도수

            if (c1 == c2) { // 빈도수 같을 때
                if(o1.length() == o2.length()) { // 단어 길이 같을 때
                    return o1.compareTo(o2); // 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치
                }
                return o2.length() - o1.length(); // 2. 단어의 길이가 길수록 앞에 배치
            }
            return c2 - c1; // 1. 자주 나오는 단어일수록 앞에 배치
        });

        StringBuilder sb = new StringBuilder();
        for(String s : wordList){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}