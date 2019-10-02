import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SurgicalStrike {
	// input parameters
    int n;
	int m;
	int t;
	int base_x[], base_y[], baseId[];
	int target_x[], target_y[], targetId[];
	int baseX, baseY;
	
	// output parameters
	int maxTarget;	
	
	int distSourceToTarget[][];
	int distTargetToBase[];
	int distTotal[][];
	
	public SurgicalStrike(int n, int m, int t) {
		this.n = n;
		this.m = m;
		this.t = t;
		
		base_x = new int[n];
		base_y = new int[n];
		baseId = new int[n];
		
		target_x = new int[m];
		target_y = new int[m];
		targetId = new int[m];
		
		maxTarget = 0;
		
		distSourceToTarget = new int[n][m];
		distTargetToBase = new int[m];
		distTotal = new int[n][m];
			
	}
	
	void getData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0; i<n; i++) {
			String s = br.readLine();
			String[] temp = s.split(" ");
						
			base_x[i] = Integer.parseInt(temp[0]);
			base_y[i] = Integer.parseInt(temp[1]);
			baseId[i] = Integer.parseInt(temp[2]);			
		}
		

		for(int i=0; i<m; i++) {			
			String s = br.readLine();
			String[] temp = s.split(" ");
			
			target_x[i] = Integer.parseInt(temp[0]);
			target_y[i] = Integer.parseInt(temp[1]);
			targetId[i] = Integer.parseInt(temp[2]);
			
		}
	
		String s = br.readLine();
		String[] temp = s.split("\\s+");

		baseX = Integer.parseInt(temp[0]);
		baseY = Integer.parseInt(temp[1]);	
			
	}
	
	int getManhatanDist(int x1, int y1, int x2, int y2) {
		return (x1-x2)+(y1-y2);
	}
	
	int getPrimeFactor(int dist, int id) {		
		if(dist%2 == 0) {
			if(id<2)
				return 2;
		}
			
		for(int i=3; i <= Math.sqrt(dist); i += 2) {
			if(dist%i == 0) {
				if(id<i)
					return i;
			}
		}
		
		return id;
	}
	
	void calcSourceToTarget() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				int dist = getManhatanDist(base_x[i], base_y[j], target_x[j], target_y[j]);
				distSourceToTarget[i][j] = getPrimeFactor(dist, baseId[i]);
			}
		}
	}
	
	void calcTargetToBase() {
		for(int i=0; i<m; i++) 
				distTargetToBase[i] = getManhatanDist(target_x[i], target_y[i], baseX, baseY);
	}
	
	void calcTotalDist() {
		calcSourceToTarget();
		calcTargetToBase();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				distTotal[i][j] = distSourceToTarget[i][j] + distTargetToBase[j];
			}
		}
	}
	
	int getMaxTarget() {
		calcTotalDist();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(distTotal[i][j]<t) {
					//System.out.println(distTotal[i][j]);
					maxTarget = maxTarget+1;
					
				}
			}
		}
		
		return maxTarget/2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("\\s+");
		int n = 0, m = 0, t = 0;
		
		if(arr.length==3) {
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);
			t = Integer.parseInt(arr[2]);
		}
		
			
		SurgicalStrike obj = new SurgicalStrike(n, m ,t);
		obj.getData();
		System.out.println(obj.getMaxTarget());		
	}
}
