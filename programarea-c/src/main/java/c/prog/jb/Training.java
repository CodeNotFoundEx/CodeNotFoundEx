package c.prog.jb;

public class Training {
    static void main() {
        System.out.println(solution(17));
    }

    //find a binary gap within a positive
    // integer N is any maximal sequence of consecutive zeros that is
    // sourranded by ones at both ends in the binary representation of N.
    public static int solution(int N){
        System.out.println(N);
        String binary = intToBinary(N);

            return 0;
    }
    
    public static int countMaxSubsequence(String num){
        num = num.replaceAll("0+$", "");
        int count =0;
        int max = 0;
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '0'){
                count++;
                if(max<count) max = count;
            }
            else {

                count = 0;
            }
        }
        return max;
    }

    public static String intToBinary(int n){
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%2);
            n /= 2;
        }
        return sb.reverse().toString();
    }


}
