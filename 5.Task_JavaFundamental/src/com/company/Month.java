package com.company;

public class Month {
	private String month;
	private int numberOfMonth;

	public Month(int numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	public int getNumberOfMonth() {
		return numberOfMonth;
	}

	public String getMonth(int monthNumber) {
		switch (monthNumber) {
			case 1:
				month = "January";
				break;
			case 2:
				month = "February";
				break;
			case 3:
				month = "March";
				break;
			case 4:
				month = "April";
				break;
			case 5:
				month = "May";
				break;
			case 6:
				month = "June";
				break;
			case 7:
				month = "July";
				break;
			case 8:
				month = "August";
				break;
			case 9:
				month = "September";
				break;
			case 10:
				month = "October";
				break;
			case 11:
				month = "November";
				break;
			default:
				month = "December";
				break;

		}
		return month;
	}
}
