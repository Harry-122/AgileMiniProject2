package springboot.automate.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import springboot.automate.grabDsl.Model
import com.google.inject.Inject

@ExtendWith(InjectionExtension)
@InjectWith(GrabDslInjectorProvider)
class GrabDslParsingTestGroovy {

	@Inject
	ParseHelper<Model> parseHelper
	
	@Test
	void testPackge() {
		def result = parseHelper.parse("""
Hello BB!
		""")
		Assertions.assertNotNull(result)
		def errors = result.eResource().errors
		Assertions.assertTrue(errors.isEmpty(), """Unexpected errors: ${errors.join(", ")}""")
	}

}




