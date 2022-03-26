package tmpTestFiles;

class TmpTest0316{
    int x;
    int y;

    TmpTest0316(){
    }
    TmpTest0316(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class TmpTest0316_1 extends TmpTest0316{
    int z;

    TmpTest0316_1(){
    }
}
public class T_0316_1 {
    public static void main(String[] args) {
        TmpTest0316_1 t1 = new TmpTest0316_1();

        TmpTest0316 t2 = new TmpTest0316();
        TmpTest0316 t3 = new TmpTest0316();

        t2 = (TmpTest0316)t1;
        t3 = (TmpTest0316)t1;
        t2.x = 4;

        System.out.println(t2.x);
        System.out.println(t3.x);
    }
}
