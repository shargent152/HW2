package c322spring2024homework2.Guitar.repository;

import c322spring2024homework2.Guitar.Model.Guitar;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class Invertory {
    static List<Guitar> guitars = new ArrayList<>();
    public boolean addGuitar(Guitar guitar) throws IOException {
        FileWriter file = new FileWriter("guitars_database.txt", true);
        BufferedWriter write = new BufferedWriter(file);
        PrintWriter p = new PrintWriter(write);
        String guitarsString = guitar.getSerialNumber() + " " + guitar.getPrice() + " " +guitar.getBuilder() + " "
                + guitar.getModel() + " " +guitar.getType() + " " + guitar.getBackWood() + " " + guitar.getTopWood();
        p.println(guitarsString);
        guitars.add(guitar);
        p.close();
        write.close();
        file.close();
        return true;
    }
    public Guitar getGuitar(String serialNumber) throws IOException {
        FileReader file = new FileReader("guitars_database.txt");
        Scanner read = new Scanner(file);
        String line = "";
        String price = "";
        String builder = "";
        String model = "";
        String type = "";
        String backWood = "";
        String topWood = "";
        int j = 0;
        while (read.hasNext()){
            line = read.next();
            if (j == 0){
                j++;
                continue;
            } else if (j == 1){
                price = line;
                j++;

                continue;
            } else if (j == 2) {
                builder = line;

                j++;
                continue;
            } else if (j == 3) {
                model = line;

                j++;
                continue;
            }else if (j == 4){
                type = line;

                j++;
                continue;
            } else if (j == 5) {
                backWood = line;

                j++;
                continue;
            }else {
                topWood = line;
                System.out.println(line);
                Guitar guitar4 = new Guitar();
                guitar4.setModel(model);
                guitar4.setType(type);
                guitar4.setBuilder(builder);
                guitar4.setSerialNumber(serialNumber);
                guitar4.setTopWood(topWood);
                guitar4.setBackWood(backWood);
                guitar4.setPrice(Double.parseDouble(price));
                if (!guitars.contains(guitar4)){
                    guitars.add(guitar4);
                }
                j = 0;
                continue;
            }
        }
        read.close();
        for (int i = 0; i < guitars.size(); i++) {
            Guitar guitar = guitars.get(i);
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }
    public List<Guitar> searchGuitar(Guitar guitar) throws IOException {
        Path file = Path.of("guitars_database.txt");
        List<String> data = Files.readAllLines(file);
        List<Guitar>searchedGuitars = new ArrayList<>();

        for (String line :data){
            if (line.contains(guitar.getSerialNumber())||line.contains(Double.toString(guitar.getPrice()))||line.contains(guitar.getModel())||
                    line.contains(guitar.getBuilder())||line.contains(guitar.getType())||
                    line.contains(guitar.getTopWood())||line.contains(guitar.getBackWood())){
                String[] guitarParts = line.split(" ");
                Guitar guitar1 = new Guitar();
                guitar1.setSerialNumber(guitarParts[0]);
                guitar1.setPrice(Double.parseDouble(guitarParts[1]));
                guitar1.setModel(guitarParts[3]);
                guitar1.setType(guitarParts[4]);
                guitar1.setBuilder(guitarParts[2]);
                guitar1.setBackWood(guitarParts[5]);
                guitar1.setTopWood(guitarParts[6]);
                searchedGuitars.add(guitar1);
            }
        }
        return searchedGuitars;
    }
}