
public class PalindromeInterger {
	public boolean isPalindrome(int x) {
        String str = x+"";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        System.out.println(sb);
        if(str.equals(sb)){
            return true;
        }
        else{
            return false;
        }
    }
	
	public static void main(String[] args) {
		PalindromeInterger pi =  new PalindromeInterger();
		System.out.println(pi.isPalindrome(121));
	}
}
