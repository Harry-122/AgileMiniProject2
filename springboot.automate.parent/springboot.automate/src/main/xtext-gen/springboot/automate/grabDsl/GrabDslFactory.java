/**
 * generated by Xtext 2.32.0
 */
package springboot.automate.grabDsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see springboot.automate.grabDsl.GrabDslPackage
 * @generated
 */
public interface GrabDslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GrabDslFactory eINSTANCE = springboot.automate.grabDsl.impl.GrabDslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Package Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Definition</em>'.
   * @generated
   */
  PackageDefinition createPackageDefinition();

  /**
   * Returns a new object of class '<em>Class Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Definition</em>'.
   * @generated
   */
  ClassDefinition createClassDefinition();

  /**
   * Returns a new object of class '<em>Member Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Member Definition</em>'.
   * @generated
   */
  MemberDefinition createMemberDefinition();

  /**
   * Returns a new object of class '<em>Method Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Definition</em>'.
   * @generated
   */
  MethodDefinition createMethodDefinition();

  /**
   * Returns a new object of class '<em>Property Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Definition</em>'.
   * @generated
   */
  PropertyDefinition createPropertyDefinition();

  /**
   * Returns a new object of class '<em>Parameter Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Definition</em>'.
   * @generated
   */
  ParameterDefinition createParameterDefinition();

  /**
   * Returns a new object of class '<em>Annotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation</em>'.
   * @generated
   */
  Annotation createAnnotation();

  /**
   * Returns a new object of class '<em>Annotation Argument</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Annotation Argument</em>'.
   * @generated
   */
  AnnotationArgument createAnnotationArgument();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GrabDslPackage getGrabDslPackage();

} //GrabDslFactory
