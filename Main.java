package assn05;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i<4; i++){
            System.out.println(compareRuntimes()[i]);
        }
        /*
        Part 3

        MaxBinHeapER transfer = new MaxBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }*/
    }

    public static void fillER(MaxBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }
    
    public static double[] compareRuntimes() {
    	// Array which you will populate as part of Part 4
    	double[] results = new double[4];
    	
        SimpleEmergencyRoom simplePQ = new SimpleEmergencyRoom();
        fillER(simplePQ);

        // Code for (1) Here
        double before = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            simplePQ.dequeue();
        }
        results[0] = System.nanoTime() - before;
        results[1] = results[0]/100000;

        MaxBinHeapER binHeap = new MaxBinHeapER();
        fillER(binHeap);

        // Code for (2) Here
        double before2 = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            binHeap.dequeue();
        }
        results[2] = System.nanoTime() - before2;
        results[3] = results[2]/100000;

        return results;
    }



}



