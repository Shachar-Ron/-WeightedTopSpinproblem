import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	private Queue<ASearchNode> open;
	private HashMap<Integer, ASearchNode> inOpen;
	private HashMap<Integer, ASearchNode> closed;
	
	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		TopSpinPuzzleState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		open = new LinkedList<>();
		inOpen = new HashMap<>();
		closed = new HashMap<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		return inOpen.get(node.hashCode());
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	)
	{
		return getOpen(node)!=null;
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		return null!=closed.get(node.hashCode());
	}

	

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		if(!isOpen(node)){
			open.add(node);
			inOpen.put(node.hashCode(), node);
		}
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		if(!isClosed(node)){
			closed.put(node.hashCode(),node);
		}

	}

	@Override
	public int openSize() 
	{
		return open.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		ASearchNode best = open.remove();
		inOpen.remove(best.hashCode());
		return best;
	}

}