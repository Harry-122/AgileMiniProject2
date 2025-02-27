/*
 * generated by Xtext 2.32.0
 */
package springboot.automate.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import springboot.automate.GrabDslRuntimeModule;
import springboot.automate.GrabDslStandaloneSetup;
import springboot.automate.ide.GrabDslIdeModule;

/**
 * Initialization support for running Xtext languages in web applications.
 */
public class GrabDslWebSetup extends GrabDslStandaloneSetup {
	
	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new GrabDslRuntimeModule(), new GrabDslIdeModule(), new GrabDslWebModule()));
	}
	
}
