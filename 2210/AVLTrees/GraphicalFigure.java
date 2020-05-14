//Author David George
// Student ID: 251004930


public class GraphicalFigure implements GraphicalFigureADT {

	private int id; 
	private int width; 
	private int height;

	private String type;

	private Location pos;

	private BinarySearchTree Binary_Search_Tree;

	public GraphicalFigure(int id, int width, int height, String type, Location pos) {

		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
		this.Binary_Search_Tree = new BinarySearchTree();
	}
	
	// Following are getter setter methods 

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getType() {
		return type;
	}

	public int getId() {
		return id;
	}

	public Location getOffset() {
		return pos;
	}

	public void setOffset(Location value) {
		this.pos = value;
	}

	public void setType(String t) {
		this.type = t;
	}

	
	// Adds pixel to tree
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		try {
			this.Binary_Search_Tree.put(Binary_Search_Tree.getRoot(), pix);
		} catch (DuplicatedKeyException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean intersects(GraphicalFigure fig) {

		Location pixel_figure;

		Pixel Pixel = null;
		try {
			Pixel = fig.Binary_Search_Tree.smallest(fig.Binary_Search_Tree.getRoot());
		} catch (EmptyTreeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Check for overlap based on x and y cordinates, and private method 
		if (Intersection_Helper(pos, this.width, this.height, fig)) {
			return false;
		}

		// figures most overlap if greater than deifined size of 500 
		if (height + pos.yCoord()  >= 500) {
			return true;

		}
		// figures most overlap if greater than deifined size of 500 
		if ( width + pos.xCoord()>= 500) {
			return true;
		}

	//Check if null before looping 
		if (Pixel  != null) {
			while (Pixel  != null) {
				
				
				if (find_Pixel_helper(new Location(Pixel.getLocation().xCoord() + fig.getOffset().xCoord() - pos.xCoord(),
					
						Pixel.getLocation().yCoord() + fig.getOffset().yCoord() - pos.yCoord()))) {
			
					return true;
				}

				Pixel  = fig.Binary_Search_Tree.successor(fig.Binary_Search_Tree.getRoot(), Pixel.getLocation());
			}

		}
		return false;
	}

	// If pixel with exact values is found rreturn truem otehrwise false
	private boolean find_Pixel_helper(Location cord) {
		if (this.Binary_Search_Tree.get(this.Binary_Search_Tree.getRoot(), cord) == null) {
			return false;
		}

		return true;
	}

	// given the locaiton of this figure and anotehr figure, check for overlap using rectangle overlap method
	private boolean Intersection_Helper(Location pos, int width, int height, GraphicalFigure fig) {



		if (fig.getOffset().xCoord() + fig.getWidth() < pos.xCoord()) {
			return false;
		}

		if (fig.getOffset().xCoord() > pos.xCoord() + width) {
			return false;
		}

		if (pos.yCoord() < fig.getOffset().yCoord() + fig.getHeight())
			return false;

		if (fig.getOffset().yCoord() < pos.yCoord() + height)
			return false;

		return true;
	}

}