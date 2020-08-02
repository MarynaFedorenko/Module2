package nix.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOfNames {

    public static void task(List<String> names){
        Set<String> setOfNames = new HashSet<>();
        List<String> temp = new ArrayList<>();
        for(int i=0; i<names.size(); i++){
            if(setOfNames.add(names.get(i)))
                temp.add(names.get(i));
            else temp.remove(names.get(i));
        }
        System.out.println("First unique name: "+temp.get(0));


    }
}
