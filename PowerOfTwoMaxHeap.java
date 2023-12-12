import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Define the PowerOfTwoMaxHeap class
public class PowerOfTwoMaxHeap {
    private int childrenPower; // Number of children each parent node should have
    private List<Integer> heap; // List to represent the heap

    // Constructor to initialize the heap with the specified children power
    public PowerOfTwoMaxHeap(int childrenPower) {
        this.childrenPower = childrenPower;
        this.heap = new ArrayList<>();
    }

    // Method to insert a value into the heap
    public void insert(int value) {
        heap.add(value);
        heapifyUp(); // Ensure the heap property is maintained after insertion
    }

    // Method to remove and return the maximum value from the heap
    public int popMax() {
        if (!heap.isEmpty()) {
            swap(0, heap.size() - 1); // Swap the maximum value with the last element
            int maxValue = heap.remove(heap.size() - 1); // Remove the maximum value
            heapifyDown(); // Ensure the heap property is maintained after removal
            return maxValue;
        }
        throw new IllegalStateException("Heap is empty");
    }

    // Method to perform the heapify operation upwards after insertion
    private void heapifyUp() {
        int currentIndex = heap.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = getParentIndex(currentIndex);

            // If the current element is less than or equal to its parent, break the loop
            if (heap.get(currentIndex) <= heap.get(parentIndex)) {
                break;
            }

            swap(currentIndex, parentIndex); // Swap the current element with its parent
            currentIndex = parentIndex; // Update the current index to the parent index
        }
    }

    // Method to perform the heapify operation downwards after removal
    private void heapifyDown() {
        int currentIndex = 0;

        while (true) {
            int leftChildIndex = getLeftChildIndex(currentIndex);
            int maxIndex = currentIndex;

            // Find the index of the maximum child among the children
            for (int i = 0; i < getChildCount(); i++) {
                int childIndex = leftChildIndex + i;

                if (childIndex < heap.size() && heap.get(childIndex) > heap.get(maxIndex)) {
                    maxIndex = childIndex;
                }
            }

            // If the current element is less than the maximum child, swap them
            if (currentIndex != maxIndex) {
                swap(currentIndex, maxIndex);
                currentIndex = maxIndex;
            } else {
                break; // Break the loop if the heap property is satisfied
            }
        }
    }

    // Method to get the parent index of a given child index
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / (int) Math.pow(2, childrenPower);
    }

    // Method to get the left child index of a given parent index
    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * (int) Math.pow(2, childrenPower) + 1;
    }

    // Method to get the total number of children each parent should have
    private int getChildCount() {
        return (int) Math.pow(2, childrenPower);
    }

    // Method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

// Class for testing the PowerOfTwoMaxHeap class
class HeapTester {
    public static void main(String[] args) {
        // Example usage and testing
        int smallChildrenPower = 2;
        int[] smallValues = {5, 10, 3, 8, 15};
        int[] resultSmall = testPowerOfTwoMaxHeap(smallChildrenPower, smallValues);
        System.out.println("Result with small childrenPower: " + Arrays.toString(resultSmall));

        int largeChildrenPower = 4;
        int[] largeValues = {5, 10, 3, 8, 15};
        int[] resultLarge = testPowerOfTwoMaxHeap(largeChildrenPower, largeValues);
        System.out.println("Result with large childrenPower: " + Arrays.toString(resultLarge));
    }

    // Method to test the PowerOfTwoMaxHeap class with a set of values
    private static int[] testPowerOfTwoMaxHeap(int childrenPower, int[] values) {
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(childrenPower);

        // Insert values into the heap
        for (int value : values) {
            heap.insert(value);
        }

        // Pop max values from the heap
        int[] poppedValues = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            poppedValues[i] = heap.popMax();
        }

        return poppedValues;
    }
}
