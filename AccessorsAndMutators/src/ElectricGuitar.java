public class ElectricGuitar {
	String brand;
	int numOfPickups;
	boolean rockStarUsesIt;
	
	String getBrand() {
		return brand;
	}
	
	void setBrand(String aBrand) {
		brand = aBrand;
	}
	
	int getNumOfPickups() {
		return numOfPickups;
	}
	
	void setNumOfPickups(int num) {
		if (num > 3) {	// Здесь показана инкапсуляция. Я установил какое-то минимальное значение (3), чтобы никто не мог его изменить на меньшее, уснанавливая значение в переменную numOfPickups.			
			numOfPickups = num;
		}
	}
	
	boolean getRockStarUsesIt() {
		return rockStarUsesIt;
	}
	
	void setRockStarUsesIt(boolean yesOrNo) {
		rockStarUsesIt = yesOrNo;
	}
}
