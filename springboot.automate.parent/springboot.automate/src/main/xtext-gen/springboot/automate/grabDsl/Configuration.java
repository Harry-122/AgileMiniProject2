/**
 * generated by Xtext 2.32.0
 */
package springboot.automate.grabDsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link springboot.automate.grabDsl.Configuration#getSource <em>Source</em>}</li>
 *   <li>{@link springboot.automate.grabDsl.Configuration#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see springboot.automate.grabDsl.GrabDslPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see springboot.automate.grabDsl.GrabDslPackage#getConfiguration_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link springboot.automate.grabDsl.Configuration#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' attribute.
   * @see #setTarget(String)
   * @see springboot.automate.grabDsl.GrabDslPackage#getConfiguration_Target()
   * @model
   * @generated
   */
  String getTarget();

  /**
   * Sets the value of the '{@link springboot.automate.grabDsl.Configuration#getTarget <em>Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' attribute.
   * @see #getTarget()
   * @generated
   */
  void setTarget(String value);

} // Configuration
