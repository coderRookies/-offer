package meettooffer.chapter6;

public class CountK {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 4, 4, 4, 4, 5, 6, 7};
        int times = countK(arrays, 5);
        System.out.println(times);
    }

    private static int countK(int[] arrays, int k) {
        int leftIndex = getLeftK(arrays, k, 0, arrays.length - 1);
        int rightIndex = getRightK(arrays, k, 0, arrays.length - 1);

        return rightIndex - leftIndex + 1;
    }

    private static int getLeftK(int[] arrays, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) >>> 1;
        int middleData = arrays[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && arrays[middleIndex - 1] != k) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex + 1;
        } else {
            start = middleIndex + 1;
        }
        return getLeftK(arrays, k, start, end);
    }

    private static int getRightK(int[] arrays, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) >>> 1;
        int middleData = arrays[middleIndex];
        if (middleData == k) {
            if ((middleIndex > 0 && arrays[middleIndex + 1] != k) || middleIndex == arrays.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData < k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return getRightK(arrays, k, start, end);
    }

}
