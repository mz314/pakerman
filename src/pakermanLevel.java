/*
 * Wszystkie obiekty mają być tego samego rozmiaru, nieważne czy mała czy duża kulka, przeszkoda, duszek = 32x32
 * Jeśli coś jest faktycznie mniejsze to ma być wyśrodkowane na przeźroczystym tle.
 * Ściany mają być kwadratowe i jednego typu. Wyeliminować offsety.
 * zrobić górne dolne i zakręty
 * 
 * 
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.io.IOException;

enum entity_type {

    empty, dot, bigdot, teleport, wall
};

public class pakermanLevel {

    protected entity_type[] data; // despite of textual always to byte array
    // enemies as part of a game logic not here
    // setting deltas for each enemy/player moe away from game logic
    protected List<pakermanEntity> obstacles = new ArrayList<pakermanEntity>();
    protected List<pakermanObstacle> walls = new ArrayList<pakermanObstacle>();
    protected List<pakermanDot> dots = new ArrayList<pakermanDot>();
    protected int width, height;

    public List<pakermanObstacle> getWalls() {
        return walls;
    }

    public List<pakermanEntity> getObjects() {
        return obstacles;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected void addWall(pakermanObstacle e) {

        walls.add(e);
    }

    protected void addDot(pakermanDot e) {

        dots.add(e);
    }

    protected void loadFile(String fn) {
        // data=File.readAllBytes(fn);
    }

    public boolean loadImages(int winw, int winh) { // will be moved
        // int cnt=winw*winh;
        int spacing = 1, rows = obstacles.size() / this.width, cols = obstacles.size()
                / this.height, ow = 18,
                oh = 18, ox = ow / 2 - 1, oy = 30;

        System.out.println("Size: " + obstacles.size());
        System.out.println("WIN: " + winw + "," + winh);
        System.out.println("DOT: " + ow + "," + oh + "-" + ox + ":" + oy);
        for (int i = 1; i <= obstacles.size(); i++) {
            //obstacles.get(i - 1).square = true;
            obstacles.get(i - 1).loadImg(ox, oy, ow, oh);
            //if (i % (rows+1) == 0) 
            ox += ow + spacing;
            if ((i) % 32 == 0) {
                //System.out.println("---");
                oy += oh + spacing;
                ox = ow / 2 - 1;
            }

        }
        return true;
    }

    pakermanLevel(int w, int h) { // for testing
        this.width = w;
        this.height = h;
        int cnt = w * h;
        data = new entity_type[cnt];
        for (int i = 0; i < cnt; i++) {
            if (i % 2 == 0) {
                data[i] = entity_type.dot; // 0 = empty space 1 = normal dot 2 = big
            } else {
                data[i] = entity_type.empty;
            }
        }				// dot 3 = teleport 4 = wall
        for (int i = 0; i < cnt; i++) {
            obstacles.add(new pakermanDot(dotType.normal));

        }
        //System.out.println(cnt);
    }

    protected void bytesToLevel(byte[] bs) {
        this.width = 32;
        this.height = 32;
        int cnt = 32 * 32;
        data = new entity_type[cnt];
        pakermanEntity tmp;

        for (int i = 0; i < bs.length; i++) {

            if (bs[i] == 10 || bs[i] == 13) {
                continue;
            }

            switch (bs[i]) {
                case '4': {
                    tmp = new pakermanDot(dotType.normal);
                    addDot((pakermanDot) tmp);
                    break;
                }
                default: {
                    tmp = new obstacleNone();
                    break;
                }
                case '3': {

                    tmp = new pakermanDot(dotType.big);
                    addDot((pakermanDot) tmp);
                    //data[i]=entity_type.dot;
                    //addDot(new pakermanDot(dotType.big));
                    //System.out.print('x');
                    break;
                }

                case '5':
                    tmp = new pakermanObstacle(obstacleType.h);
                    addWall((pakermanObstacle) tmp);
                    break;
                case '6':
                    tmp = new pakermanObstacle(obstacleType.vdl);
                    addWall((pakermanObstacle) tmp);
                    //addWall(new  pakermanObstacle(obstacleType.vdl));
                    break;
                case '7':
                    tmp = new pakermanObstacle(obstacleType.vdr);
                    addWall((pakermanObstacle) tmp);
                    //addWall(new  pakermanObstacle(obstacleType.vdr));
                    break;
                case '8':
                    tmp = new pakermanObstacle(obstacleType.vul);
                    addWall((pakermanObstacle) tmp);
                    //addWall(new  pakermanObstacle(obstacleType.vul));
                    break;

                case '2':
                    tmp = new pakermanObstacle(obstacleType.vur);
                    addWall((pakermanObstacle) tmp);
                    //addWall(new  pakermanObstacle(obstacleType.vur));
                    break;

                case '1': {
                    tmp = new pakermanObstacle(obstacleType.v);
                    addWall((pakermanObstacle) tmp);
                    //  addWall(new pakermanObstacle(obstacleType.v));
                    break;
                }

            }
            obstacles.add(tmp);
        }

    }

    pakermanLevel(String fn) {
        Path p = FileSystems.getDefault().getPath("./", fn);
        byte[] bs = new byte[4048];
        try {
            bs = Files.readAllBytes(p); //źle bo tu czyta entery

        } catch (IOException e) {
            System.exit(666);
        }

        System.out.println("length: " + bs);

        bytesToLevel(bs);
        System.out.println("length: " + obstacles.size());
    }
}
