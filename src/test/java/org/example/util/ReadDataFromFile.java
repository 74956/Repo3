package org.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadDataFromFile {

    public static List<String> getDataFromProperties(String path, String key) {
        BufferedReader reader;
        List<String> productValuesList = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            Properties properties = new Properties();
            properties.load(reader);
            String productValuesLine = properties.getProperty(key);
            productValuesList = Stream.of(productValuesLine.split(";")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productValuesList;
    }
}
