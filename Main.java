import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    // Specify your path of workload file here
    private static final String INPUT_DATA_PATH = "./workloads/W1/workload.dat";
    private static final String POINT_QUERIES_PATH = "./workloads/W1/point_queries.txt";
    private static final String RANGE_QUERIES_PATH = "./workloads/W1/range_queries.txt";
    private static final int RUNS = 3;

    public static void main(String[] args) {
        // Read data
        List<Integer> data = loadData(INPUT_DATA_PATH);

        // Initialize ZoneMap and build
        ZoneMap<Integer> zones = new ZoneMap<>(data, data.size() / 100);

        // Point queries
        List<Integer> pointQueries = loadPointQueries(POINT_QUERIES_PATH);
        long pointQueryTime = performPointQueries(zones, pointQueries);

        System.out.println("Time taken to perform point queries from zonemap = " + pointQueryTime * 1.0 / RUNS + " microseconds");

        // Range queries
        long rangeQueryTime = 0; // Implement range query logic here
        // Your code for range queries here...

        System.out.println("Time taken to perform range query from zonemap = " + rangeQueryTime * 1.0 / RUNS + " microseconds");
    }

    private static List<Integer> loadData(String filePath) {
        List<Integer> data = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                data.add(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static List<Integer> loadPointQueries(String filePath) {
        List<Integer> queries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                queries.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(queries);
        return queries;
    }

    private static long performPointQueries(ZoneMap<Integer> zones, List<Integer> queries) {
        long startTime = System.nanoTime();
        for (int r = 0; r < RUNS; r++) {
            for (int pq : queries) {
                zones.query(pq);
            }
            Collections.shuffle(queries);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000;
    }
}
