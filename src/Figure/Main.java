package Figure;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

import static java.time.LocalTime.now;

public class Main extends Thread{


	private static final ExecutorService s = Executors.newCachedThreadPool();


	public static void main(String[] args) {


		FillTheFile writeFiles = new FillTheFile();


		CreateFigures readCircles = new CreateFigures();
		CreateFigures readRectangles = new CreateFigures();
		CreateFigures readTriangles = new CreateFigures();

		Thread threadCircles = new Thread(writeFiles);


		Thread threadReadCircles = new Thread(readCircles);
		Thread threadReadRectangles = new Thread(readRectangles);
		Thread threadReadTriangles = new Thread(readTriangles);


		try{
			LocalTime time = now();
			s.execute(threadCircles);

			s.execute(threadReadCircles);
			s.execute(threadReadRectangles);
			s.execute(threadReadTriangles);
		}catch (RejectedExecutionException | NullPointerException ex) {
			System.err.println("Something went wrong. Interrupted 1!");
		}

		s.shutdown();
	}
}



