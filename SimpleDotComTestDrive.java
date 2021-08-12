public class SimpleDotComTestDrive {
	public static void main(String[] args) {
		SimpleDotCom dot = new SimpleDotCom();
		int[] locs = {2,3,4};
		dot.setLocationCells(locs);
		String userGuess = "2";
		String result = dot.checkYourSelf(userGuess);
	}
}