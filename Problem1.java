import java.util.*;

public class Problem1 {

    public static int maximumCyclicSubstringSum(String s) {
        int n = s.length();

        String doubled = s + s;

        Set<Character> set = new HashSet<>();

        int left = 0;
        int currSum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {

            char ch = doubled.charAt(right);

            while (set.contains(ch)) {
                char leftChar = doubled.charAt(left);
                currSum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            while (right - left + 1 > n) {
                char leftChar = doubled.charAt(left);
                currSum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            set.add(ch);
            currSum += (ch - 'a' + 1);

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(maximumCyclicSubstringSum(s));   

    }
}
