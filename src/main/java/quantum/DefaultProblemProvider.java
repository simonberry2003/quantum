package quantum;

import javax.inject.Singleton;

import quantum.problems.HarderProblem2;

@Singleton
public class DefaultProblemProvider implements ProblemProvider {

	@Override
	public Problem get() {
		//return new SimpleProblem();
		//return new HarderProblem();
		return new HarderProblem2();
	}
}
