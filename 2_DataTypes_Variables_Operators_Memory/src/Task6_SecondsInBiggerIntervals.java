
public class Task6_SecondsInBiggerIntervals
{
	public static void main(String args[])
	{
		int seconds = 1234567;
		int days = seconds / 86400;
		int hours = (seconds - (86400 * days)) / 3600;
		int minutes = (seconds - ((3600 * hours) + (86400 * days))) / 60;
		seconds = (seconds - ((3600 * hours) + (86400 * days) + (60 * minutes)));
		System.out.printf("%d days, %d hours, %d minutes, %d seconds", days, hours, minutes, seconds);
	}
}
