package programs.hackerank;

public class NewYearChaosProblem {

    // Complete the minimumBribes function below.
    // Solution got from discussion board on the
    // hackerank question page.
    private static void minimumBribes(int[] q) {
        int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) { // 4- (7+1)
                System.out.println("Too Chaotic");
                return;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (q[j] > q[i]) ans++;
        }
        System.out.println(ans);
    }


    public static void main(String[] args) {
        int[] q = {5, 1, 2, 3 ,7 ,8 ,6 ,4};
        minimumBribes(q);
    }
}