/**
 * generated by Xtext 2.32.0
 */
package springboot.automate.grabDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import springboot.automate.grabDsl.Annotation;
import springboot.automate.grabDsl.GrabDslPackage;
import springboot.automate.grabDsl.MemberDefinition;
import springboot.automate.grabDsl.MethodDefinition;
import springboot.automate.grabDsl.PropertyDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link springboot.automate.grabDsl.impl.MemberDefinitionImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link springboot.automate.grabDsl.impl.MemberDefinitionImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link springboot.automate.grabDsl.impl.MemberDefinitionImpl#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemberDefinitionImpl extends MinimalEObjectImpl.Container implements MemberDefinition
{
  /**
   * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnnotations()
   * @generated
   * @ordered
   */
  protected EList<Annotation> annotations;

  /**
   * The cached value of the '{@link #getMethod() <em>Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethod()
   * @generated
   * @ordered
   */
  protected MethodDefinition method;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected PropertyDefinition property;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MemberDefinitionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GrabDslPackage.Literals.MEMBER_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Annotation> getAnnotations()
  {
    if (annotations == null)
    {
      annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, GrabDslPackage.MEMBER_DEFINITION__ANNOTATIONS);
    }
    return annotations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MethodDefinition getMethod()
  {
    return method;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMethod(MethodDefinition newMethod, NotificationChain msgs)
  {
    MethodDefinition oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GrabDslPackage.MEMBER_DEFINITION__METHOD, oldMethod, newMethod);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMethod(MethodDefinition newMethod)
  {
    if (newMethod != method)
    {
      NotificationChain msgs = null;
      if (method != null)
        msgs = ((InternalEObject)method).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GrabDslPackage.MEMBER_DEFINITION__METHOD, null, msgs);
      if (newMethod != null)
        msgs = ((InternalEObject)newMethod).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GrabDslPackage.MEMBER_DEFINITION__METHOD, null, msgs);
      msgs = basicSetMethod(newMethod, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GrabDslPackage.MEMBER_DEFINITION__METHOD, newMethod, newMethod));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyDefinition getProperty()
  {
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProperty(PropertyDefinition newProperty, NotificationChain msgs)
  {
    PropertyDefinition oldProperty = property;
    property = newProperty;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GrabDslPackage.MEMBER_DEFINITION__PROPERTY, oldProperty, newProperty);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setProperty(PropertyDefinition newProperty)
  {
    if (newProperty != property)
    {
      NotificationChain msgs = null;
      if (property != null)
        msgs = ((InternalEObject)property).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GrabDslPackage.MEMBER_DEFINITION__PROPERTY, null, msgs);
      if (newProperty != null)
        msgs = ((InternalEObject)newProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GrabDslPackage.MEMBER_DEFINITION__PROPERTY, null, msgs);
      msgs = basicSetProperty(newProperty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GrabDslPackage.MEMBER_DEFINITION__PROPERTY, newProperty, newProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GrabDslPackage.MEMBER_DEFINITION__ANNOTATIONS:
        return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
      case GrabDslPackage.MEMBER_DEFINITION__METHOD:
        return basicSetMethod(null, msgs);
      case GrabDslPackage.MEMBER_DEFINITION__PROPERTY:
        return basicSetProperty(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GrabDslPackage.MEMBER_DEFINITION__ANNOTATIONS:
        return getAnnotations();
      case GrabDslPackage.MEMBER_DEFINITION__METHOD:
        return getMethod();
      case GrabDslPackage.MEMBER_DEFINITION__PROPERTY:
        return getProperty();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GrabDslPackage.MEMBER_DEFINITION__ANNOTATIONS:
        getAnnotations().clear();
        getAnnotations().addAll((Collection<? extends Annotation>)newValue);
        return;
      case GrabDslPackage.MEMBER_DEFINITION__METHOD:
        setMethod((MethodDefinition)newValue);
        return;
      case GrabDslPackage.MEMBER_DEFINITION__PROPERTY:
        setProperty((PropertyDefinition)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GrabDslPackage.MEMBER_DEFINITION__ANNOTATIONS:
        getAnnotations().clear();
        return;
      case GrabDslPackage.MEMBER_DEFINITION__METHOD:
        setMethod((MethodDefinition)null);
        return;
      case GrabDslPackage.MEMBER_DEFINITION__PROPERTY:
        setProperty((PropertyDefinition)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GrabDslPackage.MEMBER_DEFINITION__ANNOTATIONS:
        return annotations != null && !annotations.isEmpty();
      case GrabDslPackage.MEMBER_DEFINITION__METHOD:
        return method != null;
      case GrabDslPackage.MEMBER_DEFINITION__PROPERTY:
        return property != null;
    }
    return super.eIsSet(featureID);
  }

} //MemberDefinitionImpl
