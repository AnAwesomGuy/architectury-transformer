package dev.architectury.transformer.util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ObjectUtils {
    @Contract("null,null->fail")
    public static <T> T firstNonNull(@Nullable T first, @Nullable T second) {
        if (first != null)
            return first;
        if (second != null)
            return second;
        throw new NullPointerException("Both first and second are null");
    }

    public static <T> T nonNullElse(@Nullable T first, @NotNull Supplier<@NotNull T> secondSupplier) {
        if (first != null)
            return first;
        T secondResult = secondSupplier.get();
        if (secondResult != null)
            return secondResult;
        throw new NullPointerException("Both first and the supplied value are null");
    }
}
