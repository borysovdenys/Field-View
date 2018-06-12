package borysov.database.transaction;

/**
 * Represents the result of the performed transaction.
 */
public interface PerformableResult<E> {
	public E get();
}
