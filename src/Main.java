import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @author daniel
	 * @time 2016-4-25 下午12:18:52
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int count = input.nextInt();

		for (int testCount = 0; testCount < count; testCount++) {

			int num = input.nextInt();

			ArrayList<Rectangle2> list = new ArrayList<Rectangle2>();
			boolean isSave = true;
			// 接收数据组输入
			for (int i = 0; i < num; i++) {
				Rectangle2 obj = new Rectangle2();

				obj.setLength(input.nextInt());
				obj.setWidth(input.nextInt());

				/**
				 * 替换长边和宽
				 */
				if (obj.getWidth() > obj.getLength()) {
					int j = obj.getWidth();
					obj.setWidth(obj.getLength());
					obj.setLength(j);
				}

				isSave = true;
				// 判断是否存在
				for (Rectangle2 o : list) {
					if (o.compareTo(obj) == 0) {
						isSave = false;
					}
				}
				// 不存在就保存
				if (isSave) {
					list.add(obj);
				}

			}
			// 排序
			Collections.sort(list);
			int sum = 0;

			int x = list.size();
			boolean isPlus = true;

			for (int i = 0; i < x;) {
				isPlus = true;
				Rectangle2 one = list.get(i);
				for (int j = 1; j < list.size() - i; j++) {
					Rectangle2 two = list.get(i + j);
					if ((two.getLength() > one.getLength()) && two.getWidth() > one.getWidth()) {
						sum++;
						i = i + j;
						isPlus = false;
						break;

					}

				}

				if (isPlus) {
					i++;
				}

			}

			System.out.println(returnAnsNum(list));

		}

	}

	public static int returnAnsNum(ArrayList<Rectangle2> recList) {
		int[] dp = new int[1001];
		int totalCount = 1;
		for (int i = 0; i < recList.size(); i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (recList.get(j).getWidth() < recList.get(i).getWidth() && recList.get(j).getLength() < recList.get(i).getLength() && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			if (dp[i] > totalCount) {
				totalCount = dp[i];
			}
		}
		return totalCount;

	}

}

/**
 * ID,长宽对象
 * 
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-4-15 上午11:47:27
 */
class Rectangle2 implements Comparable<Rectangle2> {

	private int length;
	private int width;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		// return id + " " + length + " " + width ;
		return "Rectangle [ length=" + length + ", width=" + width + "]";
	}

	@Override
	public int compareTo(Rectangle2 o) {

		// 长度排序
		if (this.length > o.length) {
			return 1;
		} else if (this.length < o.length) {
			return -1;
		}

		// 宽度排序
		if (this.width > o.width) {
			return 1;
		} else if (this.width < o.width) {
			return -1;
		}

		// 相同值
		if (this.length == o.length && this.width == o.width) {
			return 0;
		}
		return 404;
	}

}