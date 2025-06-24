package springboot.automate.generator

import org.apache.groovy.parser.antlr4.GroovyParser.IfElseStatementContext
import org.checkerframework.checker.units.qual.Prefix
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.XtextResourceSet
import com.google.inject.Injector

import groovy.json.StringEscapeUtils
import groovy.transform.Field
import java.lang.reflect.Method
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import springboot.automate.GrabDslStandaloneSetup
import springboot.automate.grabDsl.Model
import springboot.automate.grabDsl.PackageDefinition
import springboot.automate.grabDsl.PomXml
import springboot.automate.grabDsl.Annotation
import springboot.automate.grabDsl.ClassDefinition
import springboot.automate.grabDsl.InterfaceDefinition
import springboot.automate.grabDsl.MemberDefinition
import springboot.automate.grabDsl.MethodDefinition
import springboot.automate.grabDsl.PropertyDefinition

class GrabDslGeneratorGroovy {
	static void main(String[] args) {
		// Initialize the Xtext injector and resource set
		def injector = new GrabDslStandaloneSetup().createInjectorAndDoEMFRegistration()
		def resourceSet = injector.getInstance(XtextResourceSet)

		// Load the DSL model from a file
		def resource = resourceSet.getResource(URI.createFileURI("src/main/resources/spring.dmodel"), true)
		def model = resource.getContents().get(0) as Model

		// Define the base path for Java files
		def basePath = "src/main/java"

		// Extract the base package from the model
		def basePackage = model.packageName.toString()

		// Base directory for the generated Spring Boot project
		def projectBase = new File("Generated_Springboot_Project")
		projectBase.mkdirs()

		// Generate project structure
		generateProjectStructure(model, projectBase, basePath, basePackage)
		//		println "Spring Boot project generated at: ${projectBase.absolutePath}"
	}

	static void generateProjectStructure(Model model, File projectBase, String basePath, String basePackage) {
		// Create standard Spring Boot folders
		def mainJavaDir = new File(projectBase, "src/main/java")
		def mainResourcesDir = new File(projectBase, "src/main/resources")
		def testJavaDir = new File(projectBase, "src/test/java")

		mainJavaDir.mkdirs()
		mainResourcesDir.mkdirs()
		testJavaDir.mkdirs()

		if (model.pomXml) {
			generatePomXml(model.pomXml, projectBase)
		}

		// Generate the Spring Boot main application file
		generateSpringBootApplication(model.packageName, mainJavaDir)

		// Process the packages in the model
		model.packages.each { pkg ->
			generatePackage(pkg, mainJavaDir, model.packageName.toString(), basePath, basePackage)
		}

		// Write application.properties file
		new File(mainResourcesDir, "application.properties").text = "# Spring Boot Application Properties\n"
	}

	static void generateSpringBootApplication(String packageName, File mainJavaDir) {
		def appPackageDir = new File(mainJavaDir, packageName.replace('.', '/'))
		appPackageDir.mkdirs()

		def appFile = new File(appPackageDir, "Main.java")
		def content = new StringBuilder()

		// Add package declaration
		content.append("package ${packageName};\n\n")

		// Add imports
		content.append("""
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
""")

		// Add @SpringBootApplication annotation
		content.append("""
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
""")

		// Write to the file
		appFile.text = content.toString()
		println "SpringBootApplication.java file generated at: ${appFile.absolutePath}"
	}

	static void generatePomXml(PomXml pomXml, File projectBase) {
		println "Generating pom.xml"

		def pomFile = new File(projectBase, "pom.xml")
		def content = new StringBuilder()

		// Add the XML declaration and root element
		content.append("""<?xml version="1.0" encoding="UTF-8"?>
	<project xmlns="http://maven.apache.org/POM/4.0.0"
	         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	    <modelVersion>4.0.0</modelVersion>
	
	    <groupId>${pomXml.groupId}</groupId>
	    <artifactId>${pomXml.artifactId}</artifactId>
	    <version>${pomXml.version}</version>
	    <packaging>${pomXml.packaging}</packaging>
	
	    <properties>
	        <java.version>${pomXml.properties?.javaVersion ?: "1.8"}</java.version>
	        <spring.boot.version>${pomXml.properties?.springBootVersion ?: "2.7.5"}</spring.boot.version>
	    </properties>
	
	    <dependencies>
	""")

		// Add dependencies
		pomXml.dependencies.dependencies.each { dependency ->
			content.append("""
	        <dependency>
	            <groupId>${dependency.groupId}</groupId>
	            <artifactId>${dependency.artifactId}</artifactId>
	            <version>${dependency.version}</version>
	            ${dependency.scope ? "<scope>${dependency.scope}</scope>" : ""
				}
	        </dependency>
	""")
	}

	content.append("""
	    </dependencies>
	""")

	// Add build plugins if specified
	if (pomXml.build?.plugins) {
		content.append("""
	    <build>
	        <plugins>
	""")
		pomXml.build.plugins.each { plugin ->
			content.append("""
	            <plugin>
	                <groupId>${plugin.groupId}</groupId>
	                <artifactId>${plugin.artifactId}</artifactId>
	                <version>${plugin.version}</version>
	                <configuration>
						<source>${plugin.configuration.source}</source>
						<target>${plugin.configuration.target}</target>
	                </configuration>
	            </plugin>
	""")
		}
		content.append("""
	        </plugins>
	    </build>
	""")
	}

	// Close the root element
	content.append("</project>")

	// Write content to the pom.xml file
	pomFile.text = content.toString()
	println "pom.xml file written: ${pomFile.absolutePath}"
}

static void generatePackage(PackageDefinition pkg, File baseDir, String parentPackageName, String basePath, String basePackage) {
	def packageName = pkg.packageName?.toString()
	//	println "Processing package: $packageName"

	if (parentPackageName) {
		packageName = "${parentPackageName}.${packageName}"
	}
	//	println "Processing package: $packageName"

	if (!packageName) {
		//		println "Package name is null or empty. Skipping package generation."
		return
	}

	def packageDir = new File(baseDir, packageName.replace('.', '/'))
	if (packageDir.mkdirs()) {
		println "Package directory created at: ${packageDir.absolutePath}"
	} else {
		println "Package directory already exists or could not be created: ${packageDir.absolutePath}"
	}

	pkg.classes?.eachWithIndex { cls, idx ->
		// Merge package-level annotations with class-level annotations
		cls.annotations = (cls.annotations ?: []) + (pkg.annotations ?: [])
		cls.annotations = cls.annotations.unique { it.name }
		//		println "Found class: ${cls.name}"
		//		println "Class ${idx + 1}: ${cls.name} | Annotations: ${cls.annotations?.collect { it.name }}"
		generateClass(cls, packageDir, basePath, basePackage)
	}

	pkg.interfaces?.eachWithIndex { interfacedef, idx ->

		if (!interfacedef.annotations.empty || !pkg.annotations.empty) {
			// Merge package-level annotations with interface-level annotations
			interfacedef.annotations = (interfacedef.annotations ?: []) + (pkg.annotations ?: [])
			interfacedef.annotations = interfacedef.annotations.unique { it.name }
		}
		generateInterface(interfacedef, packageDir, basePath, basePackage) // Correct method for interfaces
	}
}

static void generateClass(ClassDefinition cls, File packageDir, String basePath, String basePackage) {
	if (!cls?.name) {
		println "Class name is null or empty. Skipping class generation."
		return
	}

	def classFile = new File(packageDir, "${cls.name}.java")
	def content = new StringBuilder()

	def packageName = resolvePackageName(packageDir)
	content.append("package $packageName;\n\n")

	def imports = collectImports(cls, packageName, basePackage)
	imports.each { content.append("import $it;\n") }
	content.append("\n")

	appendClassAnnotations(cls, content)
	appendClassDeclaration(cls, content)
	//appendAutowiredFields(cls, content)
	appendMembers(cls, content)

	content.append("}")
	classFile.text = content.toString()
	println "Class file written: ${classFile.absolutePath}"
}

static String resolvePackageName(File packageDir) {
	packageDir.absolutePath.replaceAll('^.*src/main/java/', '').replace('/', '.')
}

static Set<String> collectImports(ClassDefinition cls, String packageName, String basePackage) {
	def imports = new HashSet<String>()

	collectStandardImports(cls, imports, basePackage)
	collectCustomImports(cls, packageName, imports)
	if(Objects.nonNull(cls.getInterface()) && !cls.getInterface().isBlank()) {
		imports.add( basePackage + ".serviceInterface." + cls.getInterface() )
    }
	return imports
}

static void collectStandardImports(ClassDefinition cls, Set<String> imports, String basePackage) {
	cls.members.each { member ->
		collectMethodImports(member, imports, basePackage)
		if (member.property) {
			def type = member.property.type?.toString()
			addCommonImports(imports, type, basePackage)
		}
	}
}

static void collectCustomImports(ClassDefinition cls, String packageName, Set<String> imports) {
	if (packageName.contains("controller")) {
		imports.addAll([
			"org.springframework.web.bind.annotation.RequestParam",
			"org.springframework.web.bind.annotation.RestController",
			"org.springframework.web.bind.annotation.RequestMapping",
			"org.springframework.web.bind.annotation.RequestMethod",
			"org.springframework.beans.factory.annotation.Autowired",
			"org.springframework.http.ResponseEntity"
		])
	} else if (packageName.contains("service")) {
		imports.addAll(["org.springframework.stereotype.Service",
						"org.springframework.beans.factory.annotation.Autowired"])
	} else if (packageName.contains("entity")) {
		imports.add("javax.persistence.*")
	} else if (packageName.contains("dto")) {
		imports.addAll([
			"lombok.AllArgsConstructor",
			"lombok.Data",
			"lombok.NoArgsConstructor"
		])
	} else if (packageName.contains("mapper")) {
		imports.addAll([
			"org.springframework.beans.factory.annotation.Autowired",
			"org.springframework.stereotype.Component"
		])
	}
}

static void collectMethodImports(MemberDefinition member, Set<String> imports, String basePackage) {
	if (member.method) {
		member.method.parameters.each { param ->
			def type = param.type?.toString()
			if (type) {
				addCommonImports(imports, type, basePackage)
			}
		}

		if (member.method.returnType?.toString()) {
			def returnType =member.method.returnType?.toString()
			addCommonImports(imports, returnType, basePackage)
		}
	}
}

private static addCommonImports(Set imports, String importType, String basePackage) {
	if (importType) {
		if (importType.contains("UUID")) imports.add("java.util.UUID")
		if (importType.contains("List")) imports.add("java.util.List")
		if (importType.contains("Optional"))	imports.add("java.util.Optional")
		if (importType?.contains("Timestamp")) imports.add("java.sql.Timestamp")
		if (importType?.contains("Date")) imports.add("java.util.Date")
		if (importType?.contains("HttpStatus")) imports.add("org.springframework.http.HttpStatus")
			

		importType = getTypeWhenGeneric(importType)
		if (importType.contains("Dto")) imports.add(basePackage + ".dto."+ importType)
		if (importType.contains("Entity") && !importType.contains("ResponseEntity")) imports.add(basePackage + ".entity."+ importType)
		if (importType.contains("Controller")) imports.add(basePackage + ".controller."+ importType)
		if (!importType.startsWith("I") && importType.contains("Service")) imports.add(basePackage + ".service."+ importType)
		if (importType.startsWith("I") && importType.contains("Service")) imports.add(basePackage + ".serviceInterface."+ importType)
		if (importType.contains("Repository")) imports.add(basePackage + ".repository."+ importType)
	}
}

	private static String getTypeWhenGeneric(String type) {
		def match = (type =~ /<(.+)>/)
		if (match) {
			def extracted = match[0][1]
			//println "Extracted: $extracted"  // Output: TweetEntity
			return extracted
		} else {
			//println "No match found"
		}
		return type
	}

static void appendClassAnnotations(ClassDefinition cls, StringBuilder content) {
	cls.annotations?.each { annotation ->
		content.append(generateAnnotation(annotation)).append("\n")
	}
}

static void appendClassDeclaration(ClassDefinition cls, StringBuilder content) {
	content.append("public class ${cls.name}")
	if (cls.interface) {
		content.append(" implements ${cls.interface}")
	}
	content.append(" {\n\n")
}

static void appendAutowiredFields(ClassDefinition cls, StringBuilder content) {
	if(isSkipAutowire(cls.name)) {
		return
	}
	cls.members?.findAll { it.property }?.each { property ->
		def typeName = property.property.type?.toString()
		if (typeName && !isPrimitiveOrJavaLangType(typeName)) {
			def fieldName = property.property.name
			content.append("    @Autowired\n    private ${typeName} ${fieldName};\n")
		}
	}
}

static void appendMembers(ClassDefinition cls, StringBuilder content) {
	cls.members?.each { member ->
		if (member.method) {
			content.append("    ${generateMethod(member.method, false)}\n")
		} else if (member.property) {
			content.append("    ${generateProperty(member.property)}\n")
		}
	}
}

static boolean isSkipAutowire(String className) {
	def skipNames = [
		"entity",
		"dto",
		"repository",
		"serviceInterface"
	]
	for (name in skipNames) {
		if(className.containsIgnoreCase(name)) {
			return true;
		}
	}
}

static boolean isPrimitiveOrJavaLangType(String typeName) {
	return [
		"int",
		"double",
		"float",
		"long",
		"short",
		"byte",
		"char",
		"boolean",
		"void",
		"String",
		"UUID",
		"Date",
		"Timestamp"
	].contains(typeName)
}


static void generateInterface(InterfaceDefinition interfacedef, File packageDir, String basePath, String basePackage) {
    if (!interfacedef?.name) {
        println "Interface name is null or empty. Skipping interface generation."
        return
    }

    def interfaceFile = new File(packageDir, "${interfacedef.name}.java")
    def content = new StringBuilder()

    def packageName = resolvePackageName(packageDir)
    content.append("package $packageName;\n\n")

    def imports = collectImportsForInterface(interfacedef, packageName, basePath, basePackage)
    imports.each { content.append("import $it;\n") }
    content.append("\n")

    appendInterfaceAnnotations(interfacedef, content)
    appendInterfaceDeclaration(interfacedef, packageName, content)
    appendMembers(interfacedef, content, true)

    content.append("}")
    interfaceFile.text = content.toString()
    println "Interface file written: ${interfaceFile.absolutePath}"
}

static void appendInterfaceAnnotations(InterfaceDefinition interf, StringBuilder content) {
	interf.annotations?.each { annotation ->
		content.append(generateAnnotation(annotation)).append("\n")
	}
}

static Set<String> collectImportsForInterface(InterfaceDefinition interfacedef, String packageName, String basePath, String basePackage) {
    def imports = new HashSet<String>()

    if (packageName.contains("repository")) {
        imports.addAll(["org.springframework.data.jpa.repository.JpaRepository", 
                        "org.springframework.data.jpa.repository.Query", 
                        "org.springframework.stereotype.Repository"])
    }

    interfacedef.members.each { member ->
        collectMethodImports(member, imports, basePackage)
		if (member.property) {
			def type = member.property.type?.toString()
			addCommonImports(imports, type, basePackage)
		}
    }

    if (packageName.contains("repository") && interfacedef.interface) {
		imports.add("${basePackage}.entity.${interfacedef.interface.entity}")
        if (interfacedef.interface.key == "UUID") {
            imports.add("java.util.UUID")
        }
    }

    return imports
}

static void appendInterfaceDeclaration(InterfaceDefinition interfacedef, String packageName, StringBuilder content) {
    if (packageName.contains("repository")) {
        content.append("public interface ${interfacedef.name}")
        if (interfacedef.interface) {
            content.append(" extends JpaRepository<${interfacedef.interface.entity}, ${interfacedef.interface.key}>")
        }
        content.append(" {\n\n")
    } else {
        content.append("public interface ${interfacedef.name} {\n\n")
    }
}

static void appendMembers(InterfaceDefinition interfacedef, StringBuilder content, boolean isInterface) {
    interfacedef.members?.each { member ->
        if (member.method) {
            content.append("    ${generateMethod(member.method, isInterface)}\n")
        } else if (member.property) {
            content.append("    ${generateProperty(member.property)}\n")
        }
    }
}

static String resolveFullType(String type, String completeBasePath, String basePackage) {
    def possiblePackages = ["controller", "dto", "entity", "repository", "service", "serviceInterface"]
    for (pkg in possiblePackages) {
        def fullPath = Paths.get(completeBasePath, pkg, "${type}.java").toString()
        if (Files.exists(Paths.get(fullPath))) {
            return "${basePackage}.${pkg}.${type}"
        }
    }
    return "${basePackage}.${type}"
}

static Boolean checkTypeExists(String fullPackage) {
    def filePath = Paths.get(fullPackage.replace('.', File.separator) + ".java")
    return Files.exists(filePath)
}

static String generateProperty(PropertyDefinition property) {
	//	println "Processing property: ${property.name}"

	// Safely handle visibility
	def visibility = property.visibility?.toString()?.toLowerCase() ?: "private"

	// Handle type, name, and default value
	def typeName = (property.type instanceof String) ? property.type : property.type?.name ?: "Object"
	def propertyName = property.name ?: "property"
	def defaultValue = property.defaultValue ? " = ${property.defaultValue}" : ""

	// Add annotations if available
	def annotations = property.annotations?.collect { generateAnnotation(it) }?.join("\n    ") ?: ""

	if (annotations.isEmpty()) {
		return "$visibility $typeName $propertyName${defaultValue};\n"
	}
	return "\n\n	${annotations}\n    $visibility $typeName $propertyName${defaultValue};"
}



static String generateMethod(MethodDefinition method, boolean isInterface) {
	//	println "Processing method: ${method.name}"

	// Safely handle visibility
	def visibility = method.visibility?.toString()?.toLowerCase() ?: "public"

	// Handle parameters
	def parameters = method.parameters?.collect { param ->
		def typeName = (param.type instanceof String) ? param.type.split("\\.").last() : param.type?.name ?: "Object"
		def paramName = param.name ?: "param"
		return "$typeName $paramName"
	}?.join(", ") ?: ""

	// Handle return type
	def returnType = (method.returnType instanceof String) ? method.returnType.split("\\.").last() : method.returnType?.name ?: "void"

	def annotations = method.annotations?.collect { annotation ->
		if (annotation.name == "RequestMapping") {
			def methodArg = annotation.arguments.find { it.name == "method" }?.value?.toUpperCase() ?: "GET"
			return "@RequestMapping(method = RequestMethod.${methodArg})"
		}
		generateAnnotation(annotation)
	}?.join("\n    ") ?: ""
	def methodReturn = Objects.nonNull(returnType) && returnType.equals("void") ? "" : "	return null;"
	if (!isInterface)
		return "\n	${annotations}\n    $visibility $returnType ${method.name}($parameters) {\n        // TODO: Implement method\n	$methodReturn  		\n	}"
	else
		return "\n${annotations}\n    $visibility $returnType ${method.name}($parameters);"
}

static String generateAnnotation(Annotation annotation) {
	def annotationText = "@${annotation.name}"
	if (annotation.arguments) {
		def arguments = annotation.arguments.collect {
			def value = (it.value instanceof String) ? "\"${it.value}\"" : it.value
			"${it.name}=${value}"
		}.join(", ")
		annotationText += "($arguments)"
	}
	return annotationText
}
}
