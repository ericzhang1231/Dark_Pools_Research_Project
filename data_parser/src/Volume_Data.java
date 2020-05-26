package Research_Project;
import java.sql.Time;
import java.util.*;

public class Volume_Data {
	private int date;
	private double volume; 
	public Volume_Data(int date,  double volume) {
		this.date = date;
		this.volume = volume;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
}
