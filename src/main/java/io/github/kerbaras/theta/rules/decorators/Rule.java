package io.github.kerbaras.theta.rules.decorators;

import io.github.kerbaras.theta.rules.RuleCategorie;

public @interface Rule {
	/**
	 * Describes the rule
	 * @return
	 */
	public String description();

	public RuleCategorie category();
}
