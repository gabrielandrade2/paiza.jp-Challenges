// B034:ロボットの歩行実験
// Robot walking experiment
// Author: Gabriel Andrade
import java.util.Scanner;
import java.util.stream.Stream;

public class B034 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] initialPostion = Stream.of(s.nextLine().split(" "))
                .mapToInt(token -> Integer.parseInt(token))
                .toArray();
		Robot r = new Robot(initialPostion);
		int[] stepSizes = Stream.of(s.nextLine().split(" "))
                .mapToInt(token -> Integer.parseInt(token))
                .toArray();
		r.setStepSize(stepSizes);
		int numberOfCommands = Integer.valueOf(s.nextLine());
		for(int count = 0; count < numberOfCommands; count++){
			String command = s.nextLine();	
			switch (command) {
			case "m F":
				r.moveForward();
				break;
			case "m R":
				r.moveRight();
				break;
			case "m B":
				r.moveBackwards();
				break;
			case "m L":
				r.moveLeft();
				break;
			case "t R":
				r.turnRight();
				break;
			case "t L":
				r.turnLeft();
				break;
			case "t B":
				r.turnBackwards();
				break;
			default:
				break;
			}
		}
		
		s.close();
		System.out.println(r.getCurrentPosition());
	}
}

class Robot {
	
	private int pos_x;
	private int pos_y;
	private int direction_x = 0;
	private int direction_y = 1;
	private int[] step_size = {1,1,1,1};
	
	public Robot(int[] initialPosition){
		this.pos_x = initialPosition[0];
		this.pos_y = initialPosition[1];
	}
	
	protected void setStepSize(int[] step_size){
		this.step_size = step_size;
	}
	
	protected void moveForward(){
		pos_x = pos_x + (direction_x * step_size[0]);
		pos_y = pos_y + (direction_y * step_size[0]);
	}
	
	protected void moveRight(){
		pos_y = pos_y -(direction_x * step_size[1]);
		pos_x = pos_x + (direction_y * step_size[1]);
	}
	
	protected void moveBackwards(){
		pos_x = pos_x + (direction_x * -step_size[2]);
		pos_y = pos_y + (direction_y * -step_size[2]);
	}
	
	protected void moveLeft(){
		pos_y = pos_y + (direction_x * step_size[3]);
		pos_x = pos_x - (direction_y * step_size[3]);
	}
	
	protected void turnRight(){
		if(direction_x == 0){
			direction_x = direction_y;
			direction_y = 0;
		} else{
			direction_y = direction_x * -1;
			direction_x = 0;
		}
	}
	
	protected void turnLeft(){
		if(direction_x == 0){
			direction_x = direction_y * -1;
			direction_y = 0;
		} else{
			direction_y = direction_x;
			direction_x = 0;
		}
	}

	protected void turnBackwards(){
		if(direction_x == 0){
			direction_y *= -1;
		} else{
			direction_x *= -1;
		}
	}
	
	public String getCurrentPosition(){
		return new String(pos_x + " " + pos_y);
	}
	
}
