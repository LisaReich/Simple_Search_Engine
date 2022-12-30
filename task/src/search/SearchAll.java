package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class SearchAll implements SearchMethod {

    @Override
    public void search(ArrayList<String> list, HashMap<String, ArrayList<Integer>> invertedIndex) {

        List<String> searchData = SearchMethod.scanSearchData(new Scanner(System.in));
        ArrayList<Integer> tempListOfIndexes;
        ArrayList<Integer> resultListOfIndexes = new ArrayList<>();
        boolean emptyRes = false;

        for (int i = 0; i < list.size(); i++) {
            resultListOfIndexes.add(i);
        }

        for (String key : searchData) {
            try {
                tempListOfIndexes = invertedIndex.get(key);
                resultListOfIndexes.retainAll(tempListOfIndexes);
            } catch (NullPointerException e){
                emptyRes = true;
            }
        }

        if (!emptyRes && !resultListOfIndexes.isEmpty()) {
            for (Integer index : resultListOfIndexes) {
                System.out.println(list.get(index));
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
}

