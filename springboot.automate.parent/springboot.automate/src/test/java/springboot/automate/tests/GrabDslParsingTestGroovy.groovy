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
	void testEmptyPackage() {
		def result = parseHelper.parse('''
            package com.project {
            }
        ''')
		Assertions.assertNotNull(result, "Empty package should be parsed unsuccessfully.")
		Assertions.assertFalse(result.eResource().errors.isEmpty(), "errors expected for an empty package.")
	}

	@Test
	void testValidParsePomXml() {
		def result = parseHelper.parse('''
            package com.project {
                pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Model should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertTrue(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}
	
	@Test
	void testPomXmlWithMissingBlocks() {
		def result = parseHelper.parse('''
            package com.project {
                pomXml {
                    groupId = "com.project"
                    artifactId = "springboot-application"
                    version = "1.0.0"
                }
            }
        ''')
		Assertions.assertNotNull(result, "pomXml block should be parsed unsuccessfully.")
		Assertions.assertFalse(result.eResource().errors.isEmpty(), "errors expected for minimal pomXml block.")
	}
	
	@Test
	void testInValidParsePomXml() {
		def result = parseHelper.parse('''
            package com.project {
                pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Model should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertFalse(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}
	
	
	@Test
	void testParseDtoClassWithoutPom() {
		def result = parseHelper.parse('''
            package com.project {
                package dto {
                    @Data
			        @NoArgsConstructor
			        @AllArgsConstructor
			        class UsersDto {
			       
			            private id: UUID
			            private emailId: String
			        }
                }
            }
        ''')
		Assertions.assertNotNull(result, "DTO class should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertFalse(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}

	@Test
	void testParseMultipleDToClassWithinPackage() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package dto {
                    @Data
			        @NoArgsConstructor
			        @AllArgsConstructor
			        class UsersDto {
			       
			            private id: UUID
			            private emailId: String
			        }

					@Data
			        @NoArgsConstructor
			        @AllArgsConstructor
			        class UsersDto1 {
			       
			            private id: UUID
			            private emailId: String
			        }
                }
            }
        ''')
		Assertions.assertNotNull(result, "DTO class should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertTrue(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}
	
	@Test
	void testParseMultiplePackage() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package dto {
                    @Data
			        @NoArgsConstructor
			        @AllArgsConstructor
			        class UsersDto {
			       
			            private id: UUID
			            private emailId: String
			        }
                }
				package controller {
                    class UsersController {
	                	private iUsersService: IUsersService
	                }
	            }
            }
        ''')
		Assertions.assertNotNull(result, "DTO class should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertTrue(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}
	
	@Test
	void testInvalidDependencyInPomXml() {
		def result = parseHelper.parse('''
            package com.project {
                pomXml {
                    dependencies {
                        dependency {
                            groupId = "org.springframework.boot"
                            // Missing artifactId
                            version = "2.5.6"
                        }
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "pomXml with invalid dependency should still parse.")
		Assertions.assertFalse(result.eResource().errors.isEmpty(), "Errors expected for missing artifactId in dependency.")
	}

	@Test
	void testParseEntityClassWithoutPom() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package entity {
                    class UsersEntity {
                        private id: UUID
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Entity class should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertTrue(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}

	@Test
	void testParseServiceInterfaceWithoutImportedDto() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package serviceInterface {
                    interface IUsersService {
                        public getAllUsers(): List<UsersDto>
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Service interface should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertFalse(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}
	
	@Test
	void testParseServiceInterfaceWithImportedDto() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
				package dto {
                    @Data
			        @NoArgsConstructor
			        @AllArgsConstructor
			        class UsersDto {
			       
			            private id: UUID
			            private emailId: String
			        }
                }
                package serviceInterface {
                    interface IUsersService {
                        public getAllUsers(): List<UsersDto>
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Service interface should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertFalse(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}
	
	@Test
	void testDtoWithAnnotations() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package dto {
                    @Data
                    @NoArgsConstructor
                    @AllArgsConstructor
                    class AnnotatedDto {
                        private id: UUID
                        private name: String
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Annotated DTO should be parsed successfully.")
		Assertions.assertTrue(result.eResource().errors.isEmpty(), "No errors expected for DTO with annotations.")
	}
	
	@Test
	void testEntityWithRelationships() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package entity {
                    class ParentEntity {
                        private children: List<ChildEntity>
                    }
                    class ChildEntity {
                        private parent: ParentEntity
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Entity with relationships should be parsed successfully.")
		Assertions.assertTrue(result.eResource().errors.isEmpty(), "No errors expected for entities with relationships.")
	}

	@Test
	void testParseControllerClass() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package controller {
                    class UsersController {
                        private iUsersService: IUsersService
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Controller class should be parsed successfully.")
		def errors = result.eResource().errors
		Assertions.assertTrue(errors.isEmpty(), "Unexpected errors: ${errors.join(", ")}")
	}
	
	@Test
	void testCompleteController() {
		def result = parseHelper.parse('''
            package com.project {
				pomXml {
                    groupId = "com.project"
			        artifactId = "springboot-application"
			        version = "1.0.0"
			        packaging = "jar"
			
			        properties {
			            javaVersion = "1.8"
			            springBootVersion = "2.7.5"
			        }
					
					dependencies {
				        dependency {
				            groupId = "org.springframework.boot"
				            artifactId = "spring-boot-starter-web"
				            version = "2.5.6"
				            scope = "compile"
				        }
					}

					build {
			            plugins {
			                plugin {
			                    groupId = "org.apache.maven.plugins"
			                    artifactId = "maven-compiler-plugin"
			                    version = "3.8.1"
			                    configuration {
			                        source = "${java.version}"
			                        target = "${java.version}"
			                    }
			                }
			            }
			        }
                }
                package dto {
                    class IncompleteDto {
                        private id: UUID
                        private // Missing field type and name
                    }
                }
            }
        ''')
		Assertions.assertNotNull(result, "Incomplete DTO should still parse.")
        Assertions.assertFalse(result.eResource().errors.isEmpty(), "Errors expected for incomplete DTO.")
	}
}




