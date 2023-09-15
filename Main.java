import java.util.Random;

class Main {
    public static void main(String[] args) {
        //variaveis de tempo
        long startTime, endTime;
        // array
        int arraySize = 10;
        int[] randomArray = generateRandomArray(arraySize);

        System.out.println("ARRAY ORIGINAL:");
        printArray(randomArray);
        
        System.out.println("\n#######################\n");
        System.out.println("ARRAY ORGANIZADO:\n");
        
        System.out.println("Bubble sort:");
        startTime = System.nanoTime();
        printArray(bubbleSort(randomArray));
        endTime = System.nanoTime();
        System.out.println("Tempo de execucao: " + (endTime-startTime) + " ms\n");

        System.out.println("Selection sort:");
        startTime = System.nanoTime();
        printArray(selectionSort(randomArray));
        endTime = System.nanoTime();
        System.out.println("Tempo de execucao: " + (endTime-startTime) + " ms\n");

        System.out.println("Insertion sort:");
        startTime = System.nanoTime();
        printArray(insertionSort(randomArray));
        endTime = System.nanoTime();
        System.out.println("Tempo de execucao: " + (endTime-startTime) + " ms\n");

        System.out.println("Merge sort:");
        startTime = System.nanoTime();
        printArray(mergeSort(randomArray));
        endTime = System.nanoTime();
        System.out.println("Tempo de execucao: " + (endTime-startTime) + " ms\n");
        
        System.out.println("\n#######################\n");
        System.out.println("PROVA DE QUE O ARRAY ORIGINAL NAO FOI MODIFICADO:");
        printArray(randomArray);
        
        
    }

    // GERA UM ARRAY ALEATORIO
    public static int[] generateRandomArray(int size) {
        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt();
        }

        return randomArray;
    }

    // METODO QUE PRINT AUM ARRAY
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // METODO DE SELECTIONSORT
    public static int[] selectionSort(int[] arr) {
        int[] sortedArray = arr.clone(); // Create a copy of the original array
        int n = sortedArray.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the remaining unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedArray[j] < sortedArray[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = sortedArray[minIndex];
            sortedArray[minIndex] = sortedArray[i];
            sortedArray[i] = temp;
        }

        return sortedArray; // Return the sorted array
    }

    // METODO BUBBLESORT
    public static int[] bubbleSort(int[] arr) {
        int[] sortedArray = arr.clone(); // Create a copy of the original array
        int n = sortedArray.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    // Swap sortedArray[j] and sortedArray[j + 1]
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, the array is already
            // sorted
            if (!swapped) {
                break;
            }
        }

        return sortedArray; // Return the sorted array
    }

    //METODO INSERTIONSORT
    public static int[] insertionSort(int[] arr) {
        int[] sortedArray = arr.clone(); // Create a copy of the original array
        int n = sortedArray.length;

        for (int i = 1; i < n; i++) {
            int key = sortedArray[i];
            int j = i - 1;

            // Move elements of sortedArray[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && sortedArray[j] > key) {
                sortedArray[j + 1] = sortedArray[j];
                j--;
            }
            sortedArray[j + 1] = key;
        }

        return sortedArray; // Return the sorted array
    }

    //METODO MERGESORT
        public static int[] mergeSort(int[] arr) {
        int[] sortedArray = arr.clone(); // Create a copy of the original array
        int n = sortedArray.length;

        if (n > 1) {
            int mid = n / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[n - mid];

            // Populate left and right subarrays
            for (int i = 0; i < mid; i++) {
                leftArray[i] = sortedArray[i];
            }
            for (int i = mid; i < n; i++) {
                rightArray[i - mid] = sortedArray[i];
            }

            // Recursively sort left and right subarrays
            leftArray = mergeSort(leftArray);
            rightArray = mergeSort(rightArray);

            // Merge the sorted subarrays
            sortedArray = merge(leftArray, rightArray);
        }

        return sortedArray; // Return the sorted array
    }
    public static int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] mergedArray = new int[leftLength + rightLength];
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                mergedArray[k] = left[i];
                i++;
            } else {
                mergedArray[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            mergedArray[k] = left[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            mergedArray[k] = right[j];
            j++;
            k++;
        }

        return mergedArray;
    }

}// ULTIMO
