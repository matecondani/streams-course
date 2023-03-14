package lectures;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture11 {

    @Test
    public void joiningStrings() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        String nameString = "";
        for (String name : names) {
            nameString += name + ", ";
        }
        System.out.println(nameString.substring(0, nameString.length() - 2));
    }

    @Test
    public void joiningStringsWithStream() throws Exception {
        List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
        String collect = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println(collect);
    }
}
