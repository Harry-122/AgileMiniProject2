/**
 * generated by Xtext 2.32.0
 */
package springboot.automate.grabDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import springboot.automate.grabDsl.Build;
import springboot.automate.grabDsl.GrabDslPackage;
import springboot.automate.grabDsl.Plugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Build</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link springboot.automate.grabDsl.impl.BuildImpl#getPlugins <em>Plugins</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BuildImpl extends MinimalEObjectImpl.Container implements Build
{
  /**
   * The cached value of the '{@link #getPlugins() <em>Plugins</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPlugins()
   * @generated
   * @ordered
   */
  protected EList<Plugin> plugins;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BuildImpl()
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
    return GrabDslPackage.Literals.BUILD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Plugin> getPlugins()
  {
    if (plugins == null)
    {
      plugins = new EObjectContainmentEList<Plugin>(Plugin.class, this, GrabDslPackage.BUILD__PLUGINS);
    }
    return plugins;
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
      case GrabDslPackage.BUILD__PLUGINS:
        return ((InternalEList<?>)getPlugins()).basicRemove(otherEnd, msgs);
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
      case GrabDslPackage.BUILD__PLUGINS:
        return getPlugins();
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
      case GrabDslPackage.BUILD__PLUGINS:
        getPlugins().clear();
        getPlugins().addAll((Collection<? extends Plugin>)newValue);
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
      case GrabDslPackage.BUILD__PLUGINS:
        getPlugins().clear();
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
      case GrabDslPackage.BUILD__PLUGINS:
        return plugins != null && !plugins.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //BuildImpl
