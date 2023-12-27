/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.ServiceDelegation;
import de.vw.mib.osgi.internal.BundleInfo;
import de.vw.mib.osgi.internal.ServiceInfo;
import java.util.ArrayList;
import java.util.Dictionary;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public final class MultiServiceRegistration
implements ServiceRegistration {
    private final ServiceRegistration[] registrations;

    public MultiServiceRegistration(BundleInfo bundleInfo, ArrayList arrayList) {
        this.registrations = new ServiceRegistration[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); ++i2) {
            ServiceDelegation serviceDelegation = (ServiceDelegation)arrayList.get(i2);
            ServiceInfo serviceInfo = new ServiceInfo(bundleInfo, serviceDelegation.getInterfaces(), serviceDelegation.getService(), serviceDelegation.getProperties());
            this.registrations[i2] = serviceInfo;
        }
    }

    @Override
    public ServiceReference getReference() {
        throw new UnsupportedOperationException();
    }

    public ServiceRegistration[] getManagedRegistrations() {
        return this.registrations;
    }

    @Override
    public void setProperties(Dictionary dictionary) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void unregister() {
        for (int i2 = 0; i2 < this.registrations.length; ++i2) {
            this.registrations[i2].unregister();
        }
    }
}

