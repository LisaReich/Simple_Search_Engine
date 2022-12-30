package search;

import java.util.ArrayList;
import java.util.HashMap;

class Searcher {

    private SearchMethod searchMethod;

    public void setSearchMethod(SearchMethod searchMethod) {
        this.searchMethod = searchMethod;
    }

    public void search(ArrayList<String> list, HashMap<String, ArrayList<Integer>> invertedIndex) {
        this.searchMethod.search(list, invertedIndex);
    }
}
