import java.util.*;

public class DotComBust {
	// Объявляем и инициализируем переменные, которые нам понадобятся.
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame() {
		// Создадим несколько сайтов и присвоим им имена.
		// Создаем три объекта DotCom, даём им имена и помещаем в ArrayList с названием dotComList.
		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		// Выводим краткие инструкции для пользователя
		System.out.println("Ваша цель - потопить три сайта: ");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Попытайтесь потопить их за минимальное количество ходов.");
		
		for (DotCom dotComToSet : dotComList) {	// Повторяем с каждым объектом DotCom в списке.
			ArrayList<String> newLocation = helper.placeDotCom(3);	//Запрашиваем у вспомогательного объекта адрес "сайта".
			dotComToSet.setLocationCells(newLocation);	// Вызываем сеттер из объекта DotCom, чтобы передать ему местоположение, которое только что получили из вспомогательного объекта.
		}
	}
	
	private void startPlaying() {
		while (!dotComList.isEmpty()) { // До тех пор, пока список объектов DotCom не станет пустым.
			String userGuess = helper.getUserInput("Сделайте ход"); // Получаем пользовательский ввод.
			checkUserGuess(userGuess); // Вызываем наш метод chekUserGuess
		}
		finishGame(); // Вызываем наш метод finishGame
	}
	
	private void checkUserGuess(String userGuess) {
		numOfGuesses++; // Инкрементриуем количество попыток, которые сделал пользователь.
		String result = "Мимо"; // Подразумеваем промах, пока не выяснилось обратного.
		
		for (Dotcom dotComToTest : dotComList) { // Говорим главному объекту начать главный цикл (продолжаем запрашивать пользовательский ввод и проверять полученные данные).
			result = dotComToTest.checkYourself(userGuess); // Просим DotCom проверить ход пользователя, ищем попадание (или потопление).
			if (result.equals("Попал")) {
				break; // Выходим из цикла раньше времени, нет смысле проверять другие "сайты".
			}
			if (result.equals("Потопил")) {
				dotComList.remove(dotComToTest); // Ему пришел конец, так что удаляем его из списка "сайтов" и выходим из цикла.
				break;
			}
		}
		System.out.println(result); // Выводим для пользователя результат
	}
	
	private void finishGame() {
		// Выводим сообщение о том, как пользователь прошёл игру
		System.out.println("Все сайты ушли ко дну! Ваши акции теперь ничего не стоят.");
		if (numOfGuesses <= 18) {
			System.out.println("Это заняло у вас всего" + numOfGuesses + "попыток.");
			System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
		} else {
			System.out.println("Это заняло у вас довольно много времени." + numOfGuesses + "попыток.");
			System.out.println("Рыбыо водят хороводы вокруг ваших вложений");
		}
	}
	
	public static void main(String[] args) {
		DotComBust game = new DotComBust(); // Создаём игровой объект
		game.setUpGame();	// Говорим игровому объекту подготовить игру
		game.startPlaying();	// Говорим главному объекту начать главный цикл (продолжаем запрашивать пользовательский ввод и проверять полученные данные).
	}
}





























