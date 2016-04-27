import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

	private static char arr[] = new char[10001];
	private static int maxlen[] = new int[10001];

	public static void lis() {
 	Array.setInt(maxlen, maxlen.length - 1, 0);
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			maxlen[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (maxlen[i] < 1 + maxlen[j]) {
						maxlen[i] = 1 + maxlen[j];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0, len;
		int n = sc.nextInt();
		while (n-- > 0) {
			max = 0;
			String str = sc.next();
			arr = str.toCharArray();
 			lis();
 			len = arr.length;
			for (int i = 0; i < len; i++) {
				if (max < maxlen[i]) {
					max = maxlen[i];
 				}
			}
			System.out.println(max);
		}
		sc.close();
	}
}