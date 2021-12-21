package abstractClasses;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Symbol {
    default int getPayout(int countOfSymbols) {
        if (countOfSymbols == 0) return 0;
        return getPayouts()[countOfSymbols - 1];
    }

    int getId();

    String getName();

    void setName(String name);

    int[] getPayouts();

    static Symbol getById(int id, Symbol[] symbols) {
        return Arrays.stream(symbols)
                .filter(symbol -> symbol.getId() == id)
                .findAny().orElse(null);
    }

    static Collection<Integer> getIds(Symbol[] symbols) {
        return Arrays.stream(symbols)
                .map(Symbol::getId)
                .sorted()
                .collect(Collectors.toList());
    }
}