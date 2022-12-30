package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        File file = new File(System.getProperty("user.dir") +
                File.separator + "names.txt");

        ArrayList<String> list = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> invertedIndex = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: names.txt");
        }


        for (int i = 0; i < list.size(); i++) {
            for (String word : list.get(i).split(" ")) {

                if (invertedIndex.containsKey(word.toLowerCase())) {
                    invertedIndex.get(word.toLowerCase()).add(i);
                } else {
                    invertedIndex.put(word.toLowerCase(), new ArrayList<>());
                    invertedIndex.get(word.toLowerCase()).add(i);
                }
            }
        }

        printMenu();
        String command = sc.nextLine();

        while(true) {

            switch (command) {
                case "1":
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    final String type = sc.nextLine();

                    Searcher searcher = null;

                    switch (type) {
                        case "ALL":
                            searcher = new Searcher();
                            searcher.setSearchMethod(new SearchAll());
                            searcher.search(list, invertedIndex);
                            break;
                        case "ANY":
                            searcher = new Searcher();
                            searcher.setSearchMethod(new SearchAny());
                            searcher.search(list, invertedIndex);
                            break;
                        case "NONE":
                            searcher = new Searcher();
                            searcher.setSearchMethod(new SearchNone());
                            searcher.search(list, invertedIndex);
                            break;
                        default:
                            break;
                    }

                    if (searcher == null) {
                        throw new RuntimeException(
                                "Unknown strategy type passed.");
                    }

                    break;
                case "2":
                    printAllPeople(list);
                    break;
                case "0":
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }

            printMenu();
            command = sc.nextLine();
        }
    }

    public static void printAllPeople(ArrayList<String> list) {
        System.out.println("\n=== List of people ===");
        for (String row : list) {
            System.out.println(row);
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");

    }
}

