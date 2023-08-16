package week04;

class pgs_숫자문자열과영단어 {
    public int solution(String s) {
        
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<word.length; i++){
            if(s.contains(word[i])){
                s = s.replace(word[i], Integer.toString(i));
            }
        }
        
        return Integer.parseInt(s);
    }
}