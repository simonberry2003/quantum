package quantum;

/**
 * Provides a problem to be solved.
 */
public interface ProblemProvider {
	/**
	 * @return a problem to be solved
	 */
	Problem get();
}
