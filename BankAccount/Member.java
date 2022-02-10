public class Member {
    private static int memberCount = 0;
    private static double totalMoney = 0;
    public static void setCount(){
        memberCount++;
        System.out.println("total members: " + memberCount);
    }
    public static void setTotal(double account1, double account2){
        totalMoney += account1 + account2;
        System.out.println("total amount $" + totalMoney);
    }
}
