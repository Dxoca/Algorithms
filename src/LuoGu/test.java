package LuoGu;

public class test {
    static int add=0,asm=1;
    public static void main(String[] args) {
        for (int i = 1; i <=9; i++) {
            add+=i;
            asm*=i;


        }
        System.out.println(add+","+asm);
    }
}
