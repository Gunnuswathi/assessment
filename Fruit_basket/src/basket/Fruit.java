package basket;

public class Fruit {
	
	private String name;
	private int size;
	private String color;
	private String shape;
	private int days;
	// default constructor
	public Fruit()
	{
		super();
	}
	// created constructor to set the private attributes
	public Fruit(String name, int size, String color, String shape, int days)
	{
		super();
		this.name = name;
		this.size = size;
		this.color = color;
		this.shape = shape;
		this.days = days;
	}
	

    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    
    public int getSize() {
		return this.size;
	}
    
    public void setSize(int size) {
		// TODO Auto-generated method stub
    	this.size = size;
	}


    
    
    
    

}
