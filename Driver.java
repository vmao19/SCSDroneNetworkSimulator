
public class Driver {
	public static void main(String args[]){
		Window w = new Window();
		if (Constants.running) {
			run();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			w.repaint();
		}
		
	}
	
	public static void run(){
		for(Robot r: Robot.robots) {
    		r.move();
	    }
	    
	    for(Robot r: Robot.robots) {
    		r.logic();
	    }
	}
}
