package Task1_DateDifference.src;

public class SwiftDate {
	private int year;
	private int month;
	private int day;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public boolean isLeapYear() {
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}
	public int getCentury() {
		return year / 100 + 1;
	}
	public int getDaysDifference(SwiftDate other) {
		int years = 0;
		for (int i = this.getYear(); i <= other.getYear(); i++) {
			if ((i % 400 == 0) || ((i % 4 == 0) && (i % 100 != 0))) {
				years += 365;
			} else {
				years += 364;
			}
		}
		int fMonth = 0;
		int sMonth = 0;
		if (this.getMonth() == 1 || this.getMonth() == 3 || this.getMonth() == 7
				|| this.getMonth() == 8 || this.getMonth() == 10
				|| this.getMonth() == 12) {
			fMonth = 31;
		} else if (this.getMonth() == 4 || this.getMonth() == 6
				|| this.getMonth() == 9 || this.getMonth() == 11) {
			fMonth = 30;
		} else if (this.isLeapYear() == true && this.getMonth() == 2) {
			fMonth = 29;
		} else {
			fMonth = 28;
		}
		if (other.getMonth() == 1 || other.getMonth() == 3
				|| other.getMonth() == 7 || other.getMonth() == 8
				|| other.getMonth() == 10 || other.getMonth() == 12) {
			sMonth = 31;
		} else if (other.getMonth() == 4 || other.getMonth() == 6
				|| other.getMonth() == 9 || other.getMonth() == 11) {
			sMonth = 30;
		} else if (other.isLeapYear() == true && other.getMonth() == 2) {
			sMonth = 29;
		} else {
			sMonth = 28;
		}
		return years + fMonth + sMonth + this.getDay() + other.getDay();
	}
	public void printInfo() {
		if (this.isLeapYear() == true) {
			System.out.printf("%d %d %d %d century.It's leap year%n",
					this.getYear(), this.getMonth(), this.getDay(),
					this.getCentury());
		} else {
			System.out.printf("%d %d %d %d century.%n", this.getYear(),
					this.getMonth(), this.getDay(), this.getCentury());
		}
	}

}
