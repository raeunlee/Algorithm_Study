package week04;

class pgs_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for(int h=3;;h++){
            if((sum%h)==0){
                int w = sum/h;
                
                if((h-2)*(w-2)==yellow){
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}