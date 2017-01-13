package quantum;

import javax.inject.Singleton;

@Singleton
public class DefaultProblemProvider implements ProblemProvider {

	@Override
	public Problem get() {
		return new SimpleProblem();
	}
}
