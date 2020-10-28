package com.epam.run;

import com.epam.stone.Color;
import com.epam.type.PreciousStoneType;
import com.epam.type.SemipreciousStoneType;
import com.epam.stone.Transparency;
import com.epam.stone.Stone;
import com.epam.feature.Decoration;
import com.epam.feature.Jewelry;
import com.epam.type.PreciousStone;
import com.epam.type.SemipreciousStone;

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
		jewelry.printSortedStonesOfPrice();
		System.out.println("List of precious stones:\n" + jewelry.getPreciousStones());
		System.out.println("--------------------");
		System.out.println("List of semiprecious stones:\n" + jewelry.getSemipreciousStones());
		System.out.println("Sorted stones with weight");
		jewelry.printSortedStonesOfWeight();
		System.out.println("********************");
		Decoration decoration = new Decoration(stoneList);
		decoration.welcomeToTheStore();
	}
}