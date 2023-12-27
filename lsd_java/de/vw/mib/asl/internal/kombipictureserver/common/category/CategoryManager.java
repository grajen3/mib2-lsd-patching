/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.category;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.kombipictureserver.common.category.Category;
import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryManagerDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.services.AslServiceRegistry;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public abstract class CategoryManager
implements CategoryDelegate {
    private final CategoryManagerDelegate _delegate;
    private ObjectObjectOptHashMap _registeredServices;
    private IntObjectOptHashMap _categoryMap;
    private boolean _initialized;

    public CategoryManager(CategoryManagerDelegate categoryManagerDelegate) {
        this._delegate = categoryManagerDelegate;
    }

    private CategoryManagerDelegate getDelegate() {
        return this._delegate;
    }

    private ObjectObjectOptHashMap getRegisteredServices() {
        if (this._registeredServices == null) {
            this._registeredServices = new ObjectObjectOptHashMap();
        }
        return this._registeredServices;
    }

    protected AslServiceRegistry createService(Class clazz) {
        return null;
    }

    private AslServiceRegistry getServiceRegistry(Class clazz) {
        AslServiceRegistry aslServiceRegistry = (AslServiceRegistry)this.getRegisteredServices().get(clazz);
        if (aslServiceRegistry == null) {
            aslServiceRegistry = this.createService(clazz);
            this.getRegisteredServices().put(clazz, aslServiceRegistry);
        }
        return aslServiceRegistry;
    }

    private IntObjectOptHashMap getCategoryMap() {
        if (this._categoryMap == null) {
            this._categoryMap = new IntObjectOptHashMap();
        }
        return this._categoryMap;
    }

    public Category findCategory(int n) {
        return (Category)this.getCategoryMap().get(n);
    }

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
    }

    private void _addCategories(Category[] categoryArray) {
        IntObjectOptHashMap intObjectOptHashMap = this.getCategoryMap();
        for (Category category : categoryArray) {
            category.setDelegate(this);
            intObjectOptHashMap.put(category.getIdentifier(), category);
        }
    }

    protected abstract Category[] createCategories() {
    }

    public void initialize() {
        if (!this.isInitialized()) {
            this._addCategories(this.createCategories());
            Iterator iterator = this.getCategoryMap().values().iterator();
            while (iterator.hasNext()) {
                Category category = (Category)iterator.next();
                category.initialize();
            }
            this.setInitialized(true);
        }
    }

    @Override
    public Category getCategory(Category category, int n) {
        Category category2 = this.findCategory(n);
        if (category2 == null) {
            category2 = this.getDelegate().findCategory(n);
        }
        return category2;
    }

    @Override
    public Logger getLogger() {
        return this.getDelegate().getLogger();
    }

    @Override
    public int getSubClassifier() {
        return this.getDelegate().getSubClassifier();
    }

    @Override
    public Object getService(Object object, Class clazz) {
        return this.getServiceRegistry(clazz);
    }

    @Override
    public void registerServiceListener(Object object, Class clazz, int[] nArray) {
        AslServiceRegistry aslServiceRegistry = this.getServiceRegistry(clazz);
        if (aslServiceRegistry != null) {
            aslServiceRegistry.registerServiceListener(object, nArray);
        } else {
            this.getDelegate().getLogger().error(this.getDelegate().getSubClassifier()).append("Error can't register service ").append(clazz.toString()).log();
        }
    }

    @Override
    public void removeServiceListener(Object object, Class clazz, int[] nArray) {
        AslServiceRegistry aslServiceRegistry = this.getServiceRegistry(clazz);
        if (aslServiceRegistry != null) {
            aslServiceRegistry.removeServiceListener(object, nArray);
        } else {
            this.getDelegate().getLogger().error(this.getDelegate().getSubClassifier()).append("Error can't remove registered service ").append(clazz.toString()).log();
        }
    }

    @Override
    public void updateAllServiceListeners(Class clazz) {
        AslServiceRegistry aslServiceRegistry = this.getServiceRegistry(clazz);
        if (aslServiceRegistry != null) {
            aslServiceRegistry.updateAllServiceListeners();
        } else {
            this.getDelegate().getLogger().error(this.getDelegate().getSubClassifier()).append("Error can't update all service listeners ").append(clazz.toString()).log();
        }
    }

    public void removeServiceResponder(Category category, Class clazz, Object object, int[] nArray) {
        if (object != null) {
            Target target = (Target)((Object)category);
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(target, clazz, (DSIListener)object);
        }
    }

    @Override
    public DSIBase getDsiService(Target target, Class clazz) {
        return DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getService(target, clazz);
    }

    @Override
    public DSIBase getDsiService(Hsm hsm, Class clazz) {
        return DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getService(this.getDelegate().getTarget(), clazz);
    }

    @Override
    public DSIListener addDsiServiceResponder(Target target, DSIBase dSIBase, Class clazz, int[] nArray) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(target, clazz);
        dSIProxy.addResponseListener(target, clazz, dSIListener);
        if (nArray != null) {
            dSIBase.setNotification(nArray, dSIListener);
        }
        return dSIListener;
    }

    @Override
    public DSIListener addDsiServiceResponder(Hsm hsm, DSIBase dSIBase, Class clazz, int[] nArray) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(hsm, clazz);
        dSIProxy.addResponseListener(this.getDelegate().getTarget(), clazz, dSIListener);
        if (nArray != null) {
            dSIBase.setNotification(nArray, dSIListener);
        }
        return dSIListener;
    }

    @Override
    public void removeDsiServiceResponder(Target target, Class clazz, DSIListener dSIListener, int[] nArray, DSIBase dSIBase) {
        if (dSIListener != null) {
            if (nArray != null && dSIBase != null) {
                dSIBase.clearNotification(dSIListener);
            }
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(target, clazz, dSIListener);
        }
    }

    @Override
    public void removeDsiServiceResponder(Hsm hsm, Class clazz, DSIListener dSIListener, int[] nArray, DSIBase dSIBase) {
        if (dSIListener != null) {
            if (nArray != null && dSIBase != null) {
                dSIBase.clearNotification(dSIListener);
            }
            DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this.getDelegate().getTarget(), clazz, dSIListener);
        }
    }
}

