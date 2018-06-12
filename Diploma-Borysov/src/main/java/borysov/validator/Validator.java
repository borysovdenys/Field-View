package borysov.validator;

public interface Validator<T,E> {
    T validate (E e);
}
