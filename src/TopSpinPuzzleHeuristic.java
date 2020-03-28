import java.util.Arrays;

public class TopSpinPuzzleHeuristic
{
	public double getHeuristic
	(
		TopSpinPuzzleState problemState
	) 
	{
		int littleRingStartIdx = 3;
		int littleRingEndIdx = littleRingStartIdx+4;
		int acc = 0;
		for (int i = littleRingStartIdx; i < littleRingEndIdx-1; i++) {
			int curr = problemState._TopSpinPuzzle[i];
			int next = problemState._TopSpinPuzzle[i+1];
			if(curr > next){
				acc+=curr;
				if(i == littleRingEndIdx-2){
					acc+=next;
				}
			}
		}
		return acc;
	}
}
