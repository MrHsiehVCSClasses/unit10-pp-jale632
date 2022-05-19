package u10pp;

class RecursivePalindromeChecker
{
	public static boolean isPalindrome(String s)
	{
		boolean ret = false;
		
		int s_len = s.length();

		if (s_len<=1) // 문자열의 길이가 짝수인 경우 문자열 길이가 0인 경우도 존재
		{
			ret = true;
		}
		else
		{
			if (s.charAt(0)==s.charAt(s_len-1))
			{
				s = s.substring(1, s_len-1);
				ret = isPalindrome(s);
			}
		}
		
		return ret;
	}
}