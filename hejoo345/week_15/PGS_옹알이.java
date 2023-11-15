class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            String word = babbling[i];
            for (int j = 0; j < 4; j++) {
                if (babbling[i].contains(words[j])) {
                    word = word.replaceFirst(words[j], "");
                }
            }
            if (word.equals("")) answer++;
        }
        return answer;
    }
}