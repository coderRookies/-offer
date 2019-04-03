package meettooffer.chapter2;

public class FindDight {
    public static boolean find(int[][] array, int dight) {
        if (array.length < 1) {
            return false;
        }
        int x = array[0].length - 1;
        int y = 0;
        while (!(x < 0 || y > array.length -1)) {
            if (array[y][x] == dight) {
                return true;
            }
            if (array[y][x] > dight) {
                x --;
                continue;
            }
            if (array[y][x] < dight) {
                y ++;
                continue;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(array, 3));
        System.out.println(find(array, 4));
        System.out.println(find(array, 5));
        System.out.println(find(array, 6));
        System.out.println(find(array, 7));
    }
}
