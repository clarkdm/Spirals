package DD;

public class spiral {

	public int[][] spiralNum;
	public int target;
	int target2;

	public spiral(int target) {
		this.target = target;
		target2 = 0;
		target2 = target + target2;
		spiralNum = new int[target][target];
	}

	public void calculate() {
		int counter = 1;

		int xMax = target - 1;
		int yMax = target - 1;
		int xMin = 0;
		int yMin = 0;
		boolean direction = true;

		for (int x = xMin; x <= xMax; x++) {
			spiralNum[x][0] = counter;
			counter++;
		}
		yMin++;
		while (target > 1) {
			if (direction) {

				for (int y = yMin; y < yMax; y++) {
					spiralNum[xMax][y] = counter;
					counter++;
				}
				for (int x = xMax; x >= xMin; x--) {
					spiralNum[x][yMax] = counter;
					counter++;
				}
				xMax = xMax - 1;
				yMax = yMax - 1;
			} else {

				for (int y = yMax; y > yMin; y--) {
					spiralNum[xMin][y] = counter;
					counter++;
				}
				for (int x = xMin; x <= xMax; x++) {
					spiralNum[x][yMin] = counter;
					counter++;
				}

				xMin = xMin + 1;
				yMin = yMin + 1;
			}
			target--;
			direction = !direction;
		}
		return;
	}

	public String toString() {

		String result = "";
		for (int y = 0; y < target2; y++) {
			for (int x = 0; x < target2; x++) {
				result = result + spiralNum[x][y] + '\t';

			}
			result = result + '\n';
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		spiral s = new spiral(20);
		s.calculate();
		System.out.println(s.toString());

	}

}
