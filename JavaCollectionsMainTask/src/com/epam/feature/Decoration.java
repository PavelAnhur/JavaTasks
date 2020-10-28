package com.epam.feature;

import com.epam.stone.Stone;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Decoration {

	private static final Scanner scanner = new Scanner(System.in);
	private final List<Stone> stoneList;
	private List<Stone> listOfStonesForDecoration;
	private double priceOfDecoration;
	private double inputValue;

	public Decoration(List<Stone> stoneList) {
		this.stoneList = stoneList;
	}

	public void welcomeToTheStore() {
		System.out.println("Welcome to jewelry store");
		do {
			int selection = menuWithChoice();
			if (selection == 1) {
				withLimitPrice();
				return;
			} else if (selection == 2) {
				noLimitPrice();
				return;
			} else if (selection == 0) {
				System.out.println("See you next time!");
				return;
			} else {
				System.out.println("Wrong choice! try one more time");
			}
		} while (true);
	}

	public void printStonesAvailableForDecoration() {
		List<Stone> stones = getListOfStonesWithFixPriceOfDecoration();
		stones.forEach(stone -> System.out.println(stone.getNameOfStone() + " with price " +
				getPriceOfStone(stone) + " $"));
	}

	public void enterPriceOfDecoration() {
		System.out.println("Enter total price of stones for decoration you want:");
		do {
			if (isInputValueADouble()) {
				if (inputValue > 0) {
					priceOfDecoration = inputValue;
					return;
				} else {
					System.out.println("Your price is less than zero");
				}
			}
		} while (true);
	}

	public void printOutTotalPriceOfStonesForDecoration(double totalPrice) {
		System.out.println("Total price of stones for decoration = "
				+ totalPrice + "$");
	}

	public void printOutTotalWeightOfStonesForDecoration(double totalWeight) {
		System.out.println("Total weight of stones for decoration = "
				+ totalWeight + " carat");
	}

	public void printOutStoneWithTransparency(double refractiveIndex) {
		listOfStonesForDecoration.stream()
				.filter(stone -> (stone.getTransparencyOfStone().getRefractiveIndex() == refractiveIndex))
				.forEach(stone -> System.out.println(stone.getNameOfStone() + " stone with transparency "
						+ stone.getTransparencyOfStone()));
	}

	private void createAvailableDecorationFromStoneList(List<Stone> stoneList) {
		double totalPriceStone = 0;
		List<Stone> stoneListForDecoration = new ArrayList<>();
		for (Stone stone : stoneList) {
			if ((totalPriceStone + getPriceOfStone(stone)) <= priceOfDecoration) {
				System.out.println("Do you want to add " + stone.getNameOfStone() + " with price "
						+ Stone.getPriceOfStone(stone) + "$ to decoration");
				if (doYouWantToAddStone()) {
					totalPriceStone += getPriceOfStone(stone);
					stoneListForDecoration.add(stone);
				}
			} else {
				System.out.println("You can't add " + stone.getNameOfStone() + " stone in your decoration coz of limit");
			}
		}
		listOfStonesForDecoration = stoneListForDecoration;
	}


	private int menuWithChoice() {
		do {
			System.out.println("Do we have a limit for stone's price?");
			System.out.println("-------------------------");
			System.out.println("1 - yes");
			System.out.println("2 - no");
			System.out.println("0 - quit");
			if (isInputValueADouble()) {
				if (inputValue >= 0) {
					return (int) inputValue;
				} else {
					System.out.println("Invalid value, try one more time please");
				}
			}
		} while (true);
	}

	private boolean isInputValueADouble() {
		do {
			try {
				inputValue = Double.parseDouble(scanner.next());
				return true;
			} catch (Exception e) {
				System.out.println("It isn't a number, try one more time please");
			}
		} while (true);
	}

	private void withLimitPrice() {
		enterPriceOfDecoration();
		printStonesAvailableForDecoration();
		createAvailableDecorationFromStoneList(getListOfStonesWithFixPriceOfDecoration());
		printOutTotalPriceOfStonesForDecoration(getTotalPriceOfStonesForDecoration(listOfStonesForDecoration));
		printOutTotalWeightOfStonesForDecoration(getTotalWeightOfStonesForDecoration(listOfStonesForDecoration));
		printOutStoneWithTransparency(2.4);
	}

	private void noLimitPrice() {
		getStonesForDecoration();
		printOutTotalPriceOfStonesForDecoration(getTotalPriceOfStonesForDecoration(listOfStonesForDecoration));
		printOutTotalWeightOfStonesForDecoration(getTotalWeightOfStonesForDecoration(listOfStonesForDecoration));
		printOutStoneWithTransparency(1.55);
	}

	private double getPriceOfStone(Stone stone) {
		return stone.getPriceOfStonePerCarat() * stone.getWeightOfStoneInCarat();
	}

	private List<Stone> getListOfStonesWithFixPriceOfDecoration() {
		return stoneList.stream()
				.filter(stone -> (getPriceOfStone(stone) <= priceOfDecoration))
				.collect(Collectors.toList());
	}

	private void getStonesForDecoration() {
		listOfStonesForDecoration = new ArrayList<>();
		for (Stone stone : this.stoneList) {
			System.out.println("Do you want to add " + stone.getNameOfStone() + " with price "
					+ Stone.getPriceOfStone(stone) + "$ to decoration");
			if (doYouWantToAddStone()) {
				listOfStonesForDecoration.add(stone);
			}
		}
	}

	private double getTotalPriceOfStonesForDecoration(List<Stone> stones) {
		double totalPriceOfStones = 0;
		for (Stone stone : stones) {
			totalPriceOfStones += getPriceOfStone(stone);
		}
		return totalPriceOfStones;
	}

	private double getTotalWeightOfStonesForDecoration(List<Stone> stoneList) {
		double totalWeightOfStones = 0;
		for (Stone stone : stoneList) {
			totalWeightOfStones += stone.getWeightOfStoneInCarat();
		}
		return totalWeightOfStones;
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