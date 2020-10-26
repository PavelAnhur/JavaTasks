package com.epam;

import com.epam.enums.Color;
import com.epam.enums.PreciousStoneType;
import com.epam.enums.SemipreciousStoneType;
import com.epam.enums.Transparency;
import com.epam.stones.Stone;
import com.epam.store.Decoration;
import com.epam.store.Jewelry;
import com.epam.types.PreciousStone;
import com.epam.types.SemipreciousStone;

import java.util.Arrays;
import java.util.List;

public class Main {
	static List<Stone> stoneList = Arrays.asList(
			new PreciousStone("Diamond", 2.5, Transparency.TRANSPARENT, 600.0,
					Color.WHITE, PreciousStoneType.DIAMOND),
			new SemipreciousStone("Jasper", 1.5, Transparency.TRANSLUCENT, 80.0,
					Color.RED, SemipreciousStoneType.JASPER),
			new PreciousStone("Ruby", 1.3, Transparency.TRANSPARENT, 10_000.0,
					Color.RED, PreciousStoneType.RUBY),
			new SemipreciousStone("Malachite", 2.2, Transparency.OPAQUE, 1.05,
					Color.GREEN, SemipreciousStoneType.MALACHITE),
			new SemipreciousStone("Lapis lazuli", 2.4, Transparency.OPAQUE, 1.01,
					Color.BLUE, SemipreciousStoneType.LAZULI),
			new PreciousStone("Aquamarine", 3.1, Transparency.TRANSLUCENT, 18.0,
					Color.BLUE, PreciousStoneType.AQUAMARINE),
			new PreciousStone("Emerald", 2.23, Transparency.TRANSPARENT, 971.78,
					Color.GREEN, PreciousStoneType.EMERALD),
			new PreciousStone("Yellow Topaz", 12.73, Transparency.TRANSLUCENT, 7.32,
					Color.PINK, PreciousStoneType.TOPAZ),
			new SemipreciousStone("White Pearl", 12.0, Transparency.OPAQUE, 10.1,
					Color.WHITE, SemipreciousStoneType.PEARL),
			new SemipreciousStone("Quartz", 25.4, Transparency.TRANSLUCENT, 2.02,
					Color.PINK, SemipreciousStoneType.QUARTZ));

	public static void main(String[] args) {

		Jewelry jewelry = new Jewelry(stoneList);
		System.out.println("Sorted stones with price");
		jewelry.printSortedStonesWithPrice();
		System.out.println("List of precious stones:\n" + jewelry.getPreciousStones());
		System.out.println("--------------------");
		System.out.println("List of semiprecious stones:\n" + jewelry.getSemipreciousStones());
		System.out.println("Sorted stones with weight");
		jewelry.printSortedStonesWithWeight();
		System.out.println("********************");
		Decoration decoration = new Decoration(stoneList);
		decoration.askForLimitPriceAndReturnAvailableStonesForDecoration();
	}
}