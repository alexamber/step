package core.invoker;

import java.util.stream.Stream;

import org.reflections.Reflections;

import core.domain.keyword.Word;

public abstract class KeyWordInvoker<T> {
    protected Reflections ref = new Reflections("zplayground");

    public abstract T invoke(final String keyword);

    protected Class getInvokedClass(final String keyword) {
        return ref.getTypesAnnotatedWith(Word.class).stream()
                .filter(t -> Stream.of(t.getAnnotation(Word.class).value())
                        .anyMatch(v -> v.toLowerCase().equals(keyword.toLowerCase())))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Couldn't find any class annotated with: " + keyword));
    }
}
