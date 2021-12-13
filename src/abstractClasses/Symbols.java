package abstractClasses;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public interface Symbols {
    default int getPayout(int countOfSymbols){
        return getPayouts()[countOfSymbols-1];
    }

    int getId();

    String getName();

    int[] getPayouts();

    static Symbols getById(int id, Symbols[] symbols) {
        return Arrays.stream(symbols)
                .filter(x -> x.getId() == id)
                .findFirst().orElse(null);
    }

    static Set<Integer> getIds(Symbols[] symbols) {
        return Arrays.stream(symbols)
                .map(Symbols::getId)
                .collect(Collectors.toSet());
    }


}