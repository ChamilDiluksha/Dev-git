package LinkedList;

public class Link {

	public int iData;
	public Link Next;
	
	public Link(int iData) {
		super();
		this.iData = iData;
		Next = null;
	}
	
	
	public void DisplayList()
	{
		System.out.println("Data : " + this.iData);
	}
	
}

