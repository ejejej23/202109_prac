package prg;

public class prg_1107_2 {
    public static void main(String[] args) {
        System.out.println(chk(300));
    }

    public static int chk(int num){
        return fibo(num)%1234567;
    }

    public static int fibo(int num){
        if(num <= 1) return num;
        else return (fibo(num -2) + fibo(num-1));
    }
}

