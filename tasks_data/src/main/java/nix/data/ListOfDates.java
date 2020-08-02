package nix.data;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListOfDates {

    public static void task(List<String> dates){
        Pattern regex1 = Pattern.compile("/\\d{2}/");
        Pattern regex2 = Pattern.compile("-\\d{2}-");
        List<String> result = dates.stream()
                .filter(c->{
                    String r = c.replaceAll(regex1.toString(), "");
                    String m = c.replaceAll(regex2.toString(), "");
                    return !r.equals(c) || !m.equals(c);
                })
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
