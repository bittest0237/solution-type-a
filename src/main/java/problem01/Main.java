package problem01;

public class Main {

	public static void main(String[] args) {
		for( int i = 1; i <= 100; i++ ) {
			int count = countClap(i);

			if( count == 0 ) {
				continue;
			}
			
			System.out.print( i + " " );
			
			for( int j = 0; j < count; j++ ) {
				System.out.print( "짝" );
			}
			
			System.out.println( "" );			
		}
	}
	
	public static int countClap(int number) {
		int res = 0;
		String str = new String();
		str = Integer.toString(number);
		for(int i =0; i<str.length(); i++)
		{
			int a = str.charAt(i) - '0';
			if(a==3||a==6||a==9) res++;
		}
		return res;
	}
}