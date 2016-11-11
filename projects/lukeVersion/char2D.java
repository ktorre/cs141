public class char2D {
	public static char[][] canvas;
	public char2D(int height,int width) {
		canvas = new char[height][width];
	}
	public void plot(int x, int y) {
		canvas[x][y] = '*';
	}

	public String toString() {
		String answer = "";
		for (int x = 0; x < canvas.length; x++) {
			for (int y = 0; y < canvas[x].length; y++) {
				if (canvas[x][y] == '*') {
					answer += canvas[x][y];
				} else {
					answer += " ";
				}
			}
			answer += "\n";
		}
		return answer;
	}

	public void grow(int height, int width) {
		char[][] temp = new char[canvas.length + height][canvas[0].length + width];
		for (int x = 0; x < canvas.length; x++) {
			for (int y = 0; y < canvas.length; y++) {
				temp[x][y] = canvas[x][y];
			}
		}
		canvas = temp;
	}
}
