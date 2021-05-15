package streams.task1;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};

        System.out.print("Массив до: ");
        printArray(array);

        int[] arrayPos = filterPos(array);
        int[] arrayEvenPos = filterEven(arrayPos);
        sortBubble(arrayEvenPos);

        System.out.print("\nМассив после: ");
        printArray(arrayEvenPos);
    }

    private static int[] filterPos(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i > 0) {
                count++;
            }
        }

        int[] newArray = new int[count];
        count = 0;
        for (int i : array) {
            if (i > 0) {
                newArray[count++] = i;
            }
        }

        return newArray;
    }

    private static int[] filterEven(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                count++;
            }
        }

        int[] newArray = new int[count];
        count = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                newArray[count++] = i;
            }
        }

        return newArray;
    }

    private static void sortBubble(int[] array) {
        int temp = 0;
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
