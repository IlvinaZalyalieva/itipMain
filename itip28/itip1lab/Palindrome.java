public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            boolean isPalindrome = isPalindrome(s);
            System.out.println(s + " является палиндромом: " + isPalindrome);
        }}
    public static String reverseString(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;}
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("\s", "").toLowerCase();
        String reversed = "";
        reversed = reverseString(s);
        return s.equals(reversed);}
}