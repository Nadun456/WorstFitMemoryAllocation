import java.util.Scanner;

public class WorstFit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of memory blocks
        System.out.println("Enter the number of memory blocks: ");
        int numBlocks = scanner.nextInt();
        int[] memoryBlocks = new int[numBlocks]; 

        System.out.println("Enter the sizes of memory blocks:");
        for (int i = 0; i < numBlocks; i++) {
            memoryBlocks[i] = scanner.nextInt();
        }
        System.out.println();

        //Input the size of processes
        System.out.println("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();
        int[] processes = new int[numProcesses];

        System.out.println("Enter the sizes of processes:");
        for (int i = 0; i < numProcesses; i++) {
            processes[i] = scanner.nextInt();
        }

        System.out.println("---------------------------");

        //Allocate memory to processes using the Worst-Fit algorithm
        for (int i = 0; i < numProcesses; i++) {
            int largestBlockIndex = -1;
            int largestBlockSize = -1;

            // Find the largest block that can fit the current process
            for (int j = 0; j < numBlocks; j++) {
                if (memoryBlocks[j] >= processes[i] && memoryBlocks[j] > largestBlockSize) {
                    largestBlockSize = memoryBlocks[j];
                    largestBlockIndex = j;
                }
            }

            //Allocate memory or mark as unallocated
            if (largestBlockIndex != -1) {
                // Allocate the process to the largest block
                System.out.println("Process " + (i + 1) + " of size " + processes[i] +
                        " is allocated to memory block " + (largestBlockIndex + 1));
                memoryBlocks[largestBlockIndex] -= processes[i]; // Update the block size
            } else {
                // No suitable block found
                System.out.println("Process " + (i + 1) + " of size " + processes[i] +
                        " cannot be allocated (Memory unallocated)");
            }

            //Display the current status of all memory blocks
            System.out.println("Current status of memory blocks:");
            for (int j = 0; j < numBlocks; j++) {
                System.out.println("Block " + (j + 1) + ": " + memoryBlocks[j] + " units remaining");
            }
            System.out.println("---------------------------");
        }

        // Close scanner
        scanner.close();
    }
}
