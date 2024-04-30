import cache.ExpirableCache;
import cache.MemoizeKt;
import cache.PerpetualCache;

public class Compatibility {

    public String capitalize(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static void main(String[] args) {
        String text = "Kotlin/Java Compatibility Test";
        System.out.println(text + " Dashed: " + ExtensionsKt.toDashedCase(text));

        ExpirableCache<String, String> cache = new ExpirableCache<>(new PerpetualCache<>(), 10000L);
        Compatibility compatibility = new Compatibility();
        System.out.println(MemoizeKt.memoize(s -> compatibility.capitalize(s), cache, "test").invoke(text));
        System.out.println(MemoizeKt.memoize(s -> compatibility.capitalize(s), cache, "test").invoke(text));
    }
}
