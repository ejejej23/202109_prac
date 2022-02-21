package prg;

public class prg_0221_2 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int dfs(int prev, int index, int[] numbers, int target){
        int ans = 0;

        if(index == numbers.length){
            if(target == prev) return 1;
            else return 0;
        }

        int c1 = prev + numbers[index];
        int c2 = prev - numbers[index];

        ans += dfs(c1, index+1, numbers, target);
        ans += dfs(c2, index+1, numbers, target);
        return ans;
    }

    public static int solution(int[] numbers, int target) {
        //타겟넘버 dfs
        int answer = 0;
        int cur = numbers[0];
        answer += dfs(cur,1, numbers,target);
        answer += dfs(-cur,1, numbers,target);

        return answer;
    }
}
