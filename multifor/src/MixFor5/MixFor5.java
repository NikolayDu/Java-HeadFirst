package MixFor5;
class MixFor5 {
	public static void main(String [] args) {
		int x = 0;
		int y = 30;
		for (int outer = 0; outer < 3; outer++) {
			for (int inner = 0; inner < 3; inner++) {
				x = x + 0;
				y = y - 2;
				if (x == 6) {
					break;
				}
				x = x + 3;
			}
			y = y - 2;
		}
		System.out.println(x + " " + y);
	}
}
