class Solution {
 public boolean isThere(List<String> ing, List<String> supp, List<String> op) {
        for (String item : ing) {
            if (!(supp.contains(item) || op.contains(item))) {
                return false; 
            }
        }
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        ArrayList<String> supp=new ArrayList<>(Arrays.asList(supplies));

        List<String> op=new ArrayList<>();

        for(int i=0;i<recipes.length;i++){
                if(isThere(ingredients.get(i),supp,op)){

                op.add(recipes[i]);
                supp.add(recipes[i]);
                }
            }

        return op;
        }
    }




import java.util.*;

class Solution {
    public boolean isThere(List<String> ing, List<String> supp, List<String> op) {
        Set<String> combined = new HashSet<>(supp);
        combined.addAll(op);

        for (String item : ing) {
            if (!combined.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        ArrayList<String> supp = new ArrayList<>(Arrays.asList(supplies));
        List<String> op = new ArrayList<>();
        Set<String> crafted = new HashSet<>();

        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < recipes.length; i++) {
                if (!crafted.contains(recipes[i]) && isThere(ingredients.get(i), supp, op)) {
                    op.add(recipes[i]);
                    supp.add(recipes[i]);
                    crafted.add(recipes[i]);
                    updated = true;
                }
            }
        } while (updated);

        return op;
    }
}


