
public class Time {
	private int hour;
	private int minute;
	private double second;
	
	
	
	public Time(int hour, int minute, double second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public double getSecond() {
		return second;
	}


	@Override
	public String toString() {
		return "Time [hour=" + hour + ", minute=" + minute + ", second=" + second + "]";
	}
	
	

}
