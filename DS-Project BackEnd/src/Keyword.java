
public class Keyword {
	private String name;
	private double count;
	private double weight;
	  
	  public Keyword(String name, double count, double weight) {
	   this.name= name;
	   this.count = count;
	   this.weight = weight;
	  }

	  @Override
	  public String toString() {
	   return "["+name+","+count+"]";
	  }
}
