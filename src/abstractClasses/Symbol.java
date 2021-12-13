package abstractClasses;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public interface Symbol {
    default int getPayout(int countOfSymbols){
        return getPayouts()[countOfSymbols-1];
    }

    int getId();

    String getName();

    int[] getPayouts();

    static Symbol getById(int id, Symbol[] symbols) {
        return Arrays.stream(symbols)
                .filter(symbol -> symbol.getId() == id)
                .findFirst().orElse(null);
    }

    static Set<Integer> getIds(Symbol[] symbols) {
        return Arrays.stream(symbols)
                .map(Symbol::getId)
                .collect(Collectors.toSet());
    }
}