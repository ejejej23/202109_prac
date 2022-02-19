import java.util.ArrayList;
import java.util.List;

public class exUtil {
	public List<Integer> findPrime(int num){
		int[] prime = new int[num];
		List<Integer> primeArr = new ArrayList<>();

		//소수가 아닌 경우 0으로 표기. 0,1은 소수가 아님
		prime[0] = prime[1] = 0;

		for(int i=0; i<=num; i++) prime[i] = i;

		for(int i=2; i*i<num; i++){
			if(prime[i] == 0) continue;

			for(int j=i*i;j<=num; j+=i) prime[j] = 0;//어떤 수의 배수는 소수가 아니므로 제외
			//각 배수를 지우기 때문에 i의 제곱수부터 배수를 지우면 된다.
			// 그 앞의 수는 지워져있을것
		}

		for(int i=0; i<prime.length; i++){
			if(prime[i] != 0) primeArr.add(prime[i]);
		}
		return primeArr;
	}

	/**
	 * 소수 판별
	 *
	 * @param n : 판별할 숫자
	 * @return
	 */
	private boolean isPrime(int n) {
		int i;
//		int sqrt = (int) Math.sqrt(n);
		// 2는 유일한 짝수 소수
		if (n == 2)
			return true;

		// 짝수와 1은 소수가 아님
		if (n % 2 == 0 || n == 1)
			return false;

		// 제곱근까지만 홀수로 나눠보면 됨
		//Math.sqrt 사용하지 않아도 곱해보면똑같음
		for (i = 3; i*i <= n; i += 2) {
//		for (i = 3; i <= sqrt; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	static boolean next_permutgetion(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
