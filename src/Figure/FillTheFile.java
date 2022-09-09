package Figure;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class FillTheFile implements Runnable{

    private static LocalTime time = LocalTime.now();

    public int timeELapsed ;



    public synchronized void fileForCircles() throws IOException {

        try (FileOutputStream outStrm = new FileOutputStream("src/InputFiles/Circles_in.dat");
             OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
             BufferedWriter bfw = new BufferedWriter(bfo)) {
            for(int i = 0; i < 30000; i++){
                bfw.write(ThreadLocalRandom.current().nextDouble(0, 200) + "-");
                timeELapsed = LocalTime.now().getNano() - time.getNano();
            }
        }
    }

    public synchronized void fileForTriangles() throws IOException {

        try (FileOutputStream outStrm = new FileOutputStream("src/InputFiles/Triangles_in.dat");
             OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
             BufferedWriter bfw = new BufferedWriter(bfo)) {

            for(int i = 0; i < 30000; i++){
                bfw.write(ThreadLocalRandom.current().nextDouble(0, 200) +
                        "-" + ThreadLocalRandom.current().nextDouble(0, 200) +
                        "-" + ThreadLocalRandom.current().nextDouble(0, 200) + "\n");
                timeELapsed = LocalTime.now().getNano() - time.getNano();
            }
        }
    }
    public synchronized void fileForRectangles() throws IOException {
        try (FileOutputStream outStrm = new FileOutputStream("src/InputFiles/Rectangles_in.dat");
             OutputStreamWriter bfo = new OutputStreamWriter(outStrm);
             BufferedWriter bfw = new BufferedWriter(bfo)) {
            for(int i = 0; i < 30000; i++){
                bfw.write(ThreadLocalRandom.current().nextDouble(0, 200) +
                        "-" + ThreadLocalRandom.current().nextDouble(0, 200) + "\n");
                timeELapsed = LocalTime.now().getNano() - time.getNano();
            }
        }
    }
    @Override
    public void run() {
        try {

            fileForCircles();
            fileForTriangles();
            fileForRectangles();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
