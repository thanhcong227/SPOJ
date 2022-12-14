/* COMBAT - Air Combat
An air combat is on the way, you are asked to command this war. Now planes of enemy are full of the sky. A plane is described with three-dimensional coordinate (x, y, z) (1000 < x, y, z < 1200), and all coordinates are integers. As is shown below:
You have created a missile which can destroy all the planes in a cube whose center is at (x, y, z), and the cube can be as large as (x-r, y-r, z-r) (x+r, y+r, z+r). This missile is so fierce that it will destroy not only enemies in that space, but also friends. And after that a position is occupied by a plane belonging to the opposite side before the explosion, that is to say an enemy plane will be replaced by a friend, a friend will be replaced by an enemy.

You want to reduce our loss, so you need to know which side a plane belongs to in a position.
Input
The first line contains the number of scenarios.

For each scenario you are given a line containing x1 y1 z1 x2 y2 z2, defining the two corners A (x1, y1, z1), B (x2, y2, z2) (1000 <= x1 < x2, y1 < y2, z1 < z2 <= 1200) of the sky. The combat is so fierce that every point in the cube is occupied by an enemy plane at first.

Next line is a number of operation q. (0 < q < 10000). Next q lines:

A character 'U':  followed by 4 integers, a center point M (xi, yi, zi), the range is ri.

A character 'Q':  followed by 3 integers, a position N (xi, yi, zi), if a plane belongs to us, print ” Friend” else print ” Enemy”.

Points M and N are all in cube given above.

Output
Print a line for every 'Q' operation. If a plane belongs to us, print ” Friend” else print ” Enemy”.
 */

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AirCombat {

    static int[][][] space;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        int scenarios = Integer.parseInt(br.readLine());
        while (scenarios-- > 0) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int z1 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]);
            int y2 = Integer.parseInt(line[4]);
            int z2 = Integer.parseInt(line[5]);
            int q = Integer.parseInt(br.readLine());
            space = new int[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
            for (int i = 0; i < q; i++) {
                line = br.readLine().split(" ");
                if (line[0].equals("U")) {
                    int x = Integer.parseInt(line[1]);
                    int y = Integer.parseInt(line[2]);
                    int z = Integer.parseInt(line[3]);
                    int r = Integer.parseInt(line[4]);
                    update(x - x1, y - y1, z - z1, r);
                } else {
                    int x = Integer.parseInt(line[1]);
                    int y = Integer.parseInt(line[2]);
                    int z = Integer.parseInt(line[3]);
                    if (space[x - x1][y - y1][z - z1] == 1)
                        bos.write("Friend\n".getBytes());
                    else
                        bos.write("Enemy\n".getBytes());
                }
                bos.flush();
            }
        }
    }

    public static void update(int x, int y, int z, int r) {
        int x1 = Math.max(0, x - r);
        int x2 = Math.min(space.length - 1, x + r);
        int y1 = Math.max(0, y - r);
        int y2 = Math.min(space[0].length - 1, y + r);
        int z1 = Math.max(0, z - r);
        int z2 = Math.min(space[0][0].length - 1, z + r);
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    space[i][j][k] = 1 - space[i][j][k];
                }
            }
        }
    }
}

