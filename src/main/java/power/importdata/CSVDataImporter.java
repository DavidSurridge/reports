package power.importdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVDataImporter {

    public static List<Map<String, String>> sourceData(String location) throws IOException {
        List<Map<String, String>> allRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(location)))) {
            List<String> fieldKeys = Arrays.asList(br.readLine().split(","));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                HashMap<String, String> map = new HashMap<>();
                for (int i = 0; i < fieldKeys.size(); i++) {
                    String key = fieldKeys.get(i);
                    String value = values[i];
                    map.put(key, value);
                }
                allRecords.add(map);
            }
        }
        return allRecords;
    }
}
