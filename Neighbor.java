// Neighbor class contains a links between the graph of trajectories.

import java.lang.Math;

public class Neighbor {
	Trajectory traj_a; // current trajectory
	Trajectory traj_b; // adjacent trajectory
	int trajID_a;  // IDs of the specific trajectories
	int trajID_b;
	int trajDir_a;  // Directions of the specific trajectories
	int trajDir_b;
	float trajDistance;  // Distance between the two trajectories
	float angle_a;  // Angle between positive x axis and the angle of the trajectory
	float angle_b;
	float detectIn_a;  // Beginning detection angle for trajectories
	float detectIn_b;
	float transitionIn_a;  // Beginning transition angle for trajectories
	float transitionIn_b;
	float transitionOut_a;  // Ending point for transitions, opposite of the transitionin angle
	float transitionOut_b;
  // Rework specific values held, these are just placeholder for now
  
	Neighbor(Trajectory a, Trajectory b) {
		traj_a = a;
		traj_b = b;
    
		trajID_a = a.getID();
		trajID_b = b.getID();
    
		trajDir_a = a.getDir();
		trajDir_b = b.getDir();
    
		// Calculating the distance between the two trajectories
		float xRange = Math.abs(a.getX() - b.getX());  // defining variables containing x and y distances between the trajectories
		float yRange = Math.abs(a.getY() - b.getY());
		float distance = (float)Math.sqrt((double)(xRange*xRange + yRange*yRange));
		trajDistance = distance;
    
		// math for determining both angles a and b
		if(a.getX()<=b.getX()) {  // Testing to see if a is to the left of b, ensuring that the angle_a falls between +/- pi/2
			float xDist = b.getX()-a.getX();
			float yDist = b.getY()-a.getY();
			angle_a = (float)Math.atan((double)(yDist/xDist));
			angle_b = (float)(angle_a+Math.PI);
		} else {    // If a is to the right of b, use b as the reference point and measure angles from b
			float xDist = a.getX()-b.getX();
			float yDist = a.getY()-b.getY();
			angle_b = (float)Math.atan((double)(yDist/xDist));
			angle_a = (float)(angle_b+Math.PI);
		}
		// Placing angles within desired range
		angle_a = Constants.normalizeAngle(angle_a);  
		angle_b = Constants.normalizeAngle(angle_b);
		
		// math for determining the detectIn angle for both a and b
		float baseDetect;    // Base angle, essentially calculating the angle between the detect range and angle_a/angle_b
		baseDetect = (float)Math.acos((double)((distance - Constants.wifiRange)/(2*Constants.trajRadius)));
		if (trajDir_a == 1) {
			detectIn_a = angle_a - baseDetect;
			detectIn_b = angle_b + baseDetect;
		} else if (trajDir_a == -1) {
			detectIn_a = angle_a + baseDetect;
			detectIn_b = angle_b - baseDetect;
		}
		//placing angles within desired range
		detectIn_a = Constants.normalizeAngle(detectIn_a);
		detectIn_b = Constants.normalizeAngle(detectIn_b);  
		
		// math for determining the transitionIn and transitionOut angles for both trajectories.
		float baseTransition;
		baseTransition = (float)Math.acos((double)(2*Constants.trajRadius/distance));
		if (trajDir_a == 1) {
			transitionIn_a = Constants.normalizeAngle(angle_a - baseTransition);
			transitionOut_a = Constants.normalizeAngle(angle_a + baseTransition);
			transitionIn_b = Constants.normalizeAngle(angle_b + baseTransition);
			transitionOut_b = Constants.normalizeAngle(angle_b - baseTransition);
		} else if (trajDir_a == -1) {
			transitionIn_a = Constants.normalizeAngle(angle_a + baseTransition);
			transitionOut_a = Constants.normalizeAngle(angle_a - baseTransition);
			transitionIn_b = Constants.normalizeAngle(angle_b - baseTransition);
			transitionOut_b = Constants.normalizeAngle(angle_b + baseTransition);
		}
		
	}
	int getFirstTrajId()
	{
		return trajID_a;
	}
	int getSecondTrajId()
	{
		return trajID_b;
	}
	Trajectory getFirstTraj(){
		return traj_a;
	}
	Trajectory getSecondTraj(){
		return traj_b;
	}
}