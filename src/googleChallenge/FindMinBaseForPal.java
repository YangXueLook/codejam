package googleChallenge;

import java.util.ArrayList;

public class FindMinBaseForPal {

	public static void transform(int num, int n) {
		// 参数num为输入的十进制数，参数n为要转换的进制
		int array[] = new int[100];
		int location = 0;
		while (num != 0) {// 当输入的数不为0时循环执行求余和赋值
			int remainder = num % n;
			num = num / n;
			array[location] = remainder;// 将结果加入到数组中去
			location++;
		}
		show(array, location - 1);

	}

	private static void show(int[] arr, int n) {
		for (int i = n; i >= 0; i--) {
			if (arr[i] > 9) {
				System.out.print((char) (arr[i] + 55));
			} else
				System.out.print(arr[i] + "");
		}
	}

	public static void main(String[] args) {
		// 测试用例

		System.out.println(answer(3));
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		list.add(2);
//		list.add(2);
//		System.out.print(isPal(list));

	}

	public static int answer(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int base = 2; base <= n; base++)
		{
			list.clear();
			int val = n;
			while (val != 0) {
				int remainder = val % base;
				val = val / base;
				list.add(remainder);
			}
			
//			System.out.println(list);
			
			if(isPal(list))
				return base;
		}
		

		return -1;

	}

	private static boolean isPal(ArrayList<Integer> list) {
		for(int i = 0; i < list.size()/2; i++)
		{
			if(list.get(i) != list.get(list.size() - i - 1))
				return false;
		}

		
		return true;
	}

}
