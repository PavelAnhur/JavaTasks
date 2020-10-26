package com.epam.store;

import com.epam.stones.Stone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Decoration {

	private static final Scanner scanner = new Scanner(System.in);
	private final List<Stone> stoneList;
	private double priceOfDecoration;
	private double inputValue;

	public Decoration(List<Stone> stoneList) {
		this.stoneList = stoneList;
	}

	public void askForLimitPriceAndReturnAvailableStonesForDecoration() {
		System.out.println("Welcome to jewelry store");
		do {
			int selection = menuWithChoice();
			if (selection == 1) {
				methodsForChoiceOne();
				break;
			} else if (selection == 2) {
				methodsForChoiceTwo();
				break;
			} else if (selection == 0) {
				System.out.println("See you next time!");
				break;
			} else {
				System.out.println("Wrong choice! try one more time");
			}
		} while (true);
	}

	private int menuWithChoice() {
		do {
			System.out.println("Do we have a limit for stone's price?");
			System.out.println("-------------------------");
			System.out.println("1 - yes");
			System.out.println("2 - no");
			System.out.println("0 - quit");
			if (isInputADouble()) {
				if (inputValue >= 0) {
					return (int) inputValue;
				} else {
					System.out.println("Invalid value, try one more time please");
				}
			}
		} while (true);
	}

	private boolean isInputADouble() {
		do {
			try {
				inputValue = Double.parseDouble(scanner.next());
				return true;
			} catch (Exception e) {
				System.out.println("It isn't a number, try one more time please");
			}
		} while (true);
	}

	private void methodsForChoiceOne() {
		enterPriceOfDecoration();
		printStonesAvailableForDecoration();
		getStoneListWithFixPriceOfDecoration();
	}

	private void methodsForChoiceTwo() {
		printOutTotalPriceOfStonesForDecoration();
	}

	public double enterPriceOfDecoration() {
		System.out.println("Enter total price of stones for decoration you want:");
		do {
			if (isInputADouble()) {
				priceOfDecoration = inputValue;
				if (priceOfDecoration > 0) {
					return priceOfDecoration;
				} else {
					System.out.println("Your price is less than zero");
				}
			}
		} while (true);
	}


	private double getPriceOfStone(Stone stone) {
		return stone.getPriceOfStonePerCarat() * stone.getWeightOfStoneInCarat();
	}

	private List<Stone> getStoneListWithFixPriceOfDecoration() {
		return stoneList.stream()
				.filter(stone -> (getPriceOfStone(stone) <= priceOfDecoration))
				.collect(Collectors.toList());
	}

	public void printStonesAvailableForDecoration() {
		List<Stone> stones = getStoneListWithFixPriceOfDecoration();
		stones.forEach(stone -> System.out.println(stone.getNameOfStone() + " with price " +
				getPriceOfStone(stone) + " $"));
	}

	private List<Stone> getStonesForDecoration() {
		List<Stone> stonesForDecoration = new ArrayList<>();
		for (Stone stone : this.stoneList) {
			System.out.println("Do you want to add " + stone.getNameOfStone() + " with price "
					+ Stone.getPriceOfStone(stone) + "$ to decoration");
			if (doYouWantToAddStone()) {
				stonesForDecoration.add(stone);
			}
		}
		return stonesForDecoration;
	}

	private double getTotalPriceOfStonesForDecoration() {
		List<Stone> stones = getStonesForDecoration();
		double totalPriceOfStones = 0;
		for (Stone stone : stones) {
			totalPriceOfStones += getPriceOfStone(stone);
		}
		return totalPriceOfStones;
	}

	public void printOutTotalPriceOfStonesForDecoration() {
		System.out.println("Total price of stones for decoration = " + getTotalPriceOfStonesForDecoration() + "$");
	}

	private boolean doYouWantToAddStone() {

		do {
			System.out.println("y/n");
			String choice = scanner.next();
			if (choice.equals("y")) {
				return true;
			} else if (choice.equals("n")) {
				return false;
			} else {
				System.out.println("Invalid input value, try one more time");
			}
		} while (true);
	}
}