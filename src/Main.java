public class Main {
    public static void main(String[] args) {
        PrimaryGenerator pg = PrimaryGenerator.getInstance();
        String s = pg.generaterNextNumber("111111111189");
        System.out.println(s);

    }
}
