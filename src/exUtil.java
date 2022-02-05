import java.util.ArrayList;
import java.util.List;

public class exUtil {
	public List<Integer> findPrime(int num){
		int[] prime = new int[num];
		List<Integer> primeArr = new ArrayList<>();

		//소수가 아닌 경우 0으로 표기. 0,1은 소수가 아님
		prime[0] = prime[1] = 0;

		for(int i=0; i<=num; i++) prime[i] = i;

		for(int i=2; i<num; i++){
			if(prime[i] == 0) continue;

			for(int j=2*i;j<=num; j+=i) prime[j] = 0;//어떤 수의 배수는 소수가 아니므로 제외
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
		int sqrt = (int) Math.sqrt(n);

		// 2는 유일한 짝수 소수
		if (n == 2)
			return true;

		// 짝수와 1은 소수가 아님
		if (n % 2 == 0 || n == 1)
			return false;

		// 제곱근까지만 홀수로 나눠보면 됨
		for (i = 3; i <= sqrt; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
