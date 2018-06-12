package borysov.database.transaction;


import borysov.exception.TransactionException;


/**
 * Responsible for coordinating transactions across one or more resources.
 */
public interface TransactionManager {
	


	<E> PerformableResult<E> perform(Performable<E> performable) throws TransactionException;
}
