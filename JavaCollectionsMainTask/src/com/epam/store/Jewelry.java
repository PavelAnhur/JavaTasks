package com.epam.store;

import com.epam.stones.Stone;
import com.epam.types.PreciousStone;
import com.epam.types.SemipreciousStone;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Jewelry {
	private final List<Stone> stoneList;

	public Jewelry(List<Stone> stoneList) {
		this.stoneList = stoneList;
	}

	private double getPriceOfStone(Stone stone) {
		return Stone.getPriceOfStone(stone);
	}

	public void printSortedStonesWithPrice() {
		stoneList.stream()
				.sorted(Comparator.comparingDouble(this::getPriceOfStone))
				.forEach(stone -> System.out.println(stone + " with price " + getPriceOfStone(stone)));
	}

	public void printSortedStonesWithWeight() {
		stoneList.stream()
				.sorted(Comparator.comparingDouble(Stone::getWeightOfStoneInCarat))
				.forEach(stone -> System.out.println(stone + " with weight " + stone.getWeightOfStoneInCarat()));
	}

	public List<PreciousStone> getPreciousStones() {
		List<PreciousStone> preciousStoneList = new ArrayList<>();
		for (Stone stone : stoneList) {
			if (stone instanceof PreciousStone) {
				preciousStoneList.add((PreciousStone) stone);
			}
		}
		return preciousStoneList;
	}

	public List<SemipreciousStone> getSemipreciousStones() {
		List<SemipreciousStone> semipreciousStoneList = new ArrayList<>();
		for (Stone stone : stoneList) {
			if (stone instanceof SemipreciousStone) {
				semipreciousStoneList.add((SemipreciousStone) stone);
			}
		}
		return semipreciousStoneList;
	}


	@Override
	public String toString() {
		return "Jewelry{" +
				"stoneList = " + stoneList +
				'}';
	}
}