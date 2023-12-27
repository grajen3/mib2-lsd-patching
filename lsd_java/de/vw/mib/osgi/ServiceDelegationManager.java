/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi;

import de.vw.mib.osgi.ServiceDelegation;
import de.vw.mib.osgi.ServiceDelegator;
import de.vw.mib.osgi.internal.BundleInfo;
import de.vw.mib.osgi.internal.MultiServiceRegistration;
import de.vw.mib.osgi.internal.ServiceInfo;
import java.util.ArrayList;
import java.util.Dictionary;
import org.osgi.framework.ServiceRegistration;

public final class ServiceDelegationManager {
    private static ServiceDelegationManager INSTANCE = new ServiceDelegationManager();
    private ArrayList delegators = new ArrayList(2);

    ServiceDelegationManager() {
    }

    public static ServiceDelegationManager getInstance() {
        return INSTANCE;
    }

    public ServiceRegistration getServiceInfo(BundleInfo bundleInfo, String[] stringArray, Object object, Dictionary dictionary) {
        if (this.delegators.isEmpty()) {
            return new ServiceInfo(bundleInfo, stringArray, object, dictionary);
        }
        ServiceDelegation serviceDelegation = new ServiceDelegation(stringArray, object, dictionary);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(serviceDelegation);
        for (int i2 = 0; i2 < this.delegators.size(); ++i2) {
            ServiceDelegator serviceDelegator = (ServiceDelegator)this.delegators.get(i2);
            serviceDelegator.registeringServices(arrayList);
        }
        if (arrayList.size() == 1) {
            ServiceDelegation serviceDelegation2 = (ServiceDelegation)arrayList.get(0);
            return new ServiceInfo(bundleInfo, serviceDelegation2.getInterfaces(), serviceDelegation2.getService(), serviceDelegation2.getProperties());
        }
        return new MultiServiceRegistration(bundleInfo, arrayList);
    }

    public void addDelegator(ServiceDelegator serviceDelegator) {
        if (!this.delegators.contains(serviceDelegator)) {
            this.delegators.add(serviceDelegator);
        }
    }

    public void insertDelegator(ServiceDelegator serviceDelegator) {
        if (!this.delegators.contains(serviceDelegator)) {
            this.delegators.add(0, serviceDelegator);
        }
    }

    public void clear() {
        this.delegators.clear();
    }
}

