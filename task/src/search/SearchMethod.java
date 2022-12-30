package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

interface SearchMethod {

    static List<String> scanSearchData(Scanner scanner) {
        System.out.println("Enter a name or email to search all suitable people.");
        return List.of(scanner.nextLine().toLowerCase().trim().split(" "));
    }

    void search(ArrayList<String> list, HashMap<String, ArrayList<Integer>> invertedIndex);
}
