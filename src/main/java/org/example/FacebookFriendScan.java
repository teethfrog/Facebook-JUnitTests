package org.example;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FacebookFriendScan {
    public static String[] getFriends(String facebookLink) {
        if (facebookLink == null || facebookLink.isEmpty()) {
            return new String[0];
        }

        List<String> names = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(facebookLink))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim().replace("'", "").replace(",", "");
                if (!line.isEmpty()) {
                    names.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + facebookLink);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] namesArray = names.toArray(new String[0]);

        for (String name : namesArray) {
            System.out.println(name);
        }

        return namesArray;
    }
}
