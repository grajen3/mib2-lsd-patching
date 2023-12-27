/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.vw.mib.asi.impl.ASIServiceRegistryImpl;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

class ASIServiceRegistryImpl$ASIServiceProviderListener
implements ServiceListener {
    private final /* synthetic */ ASIServiceRegistryImpl this$0;

    ASIServiceRegistryImpl$ASIServiceProviderListener(ASIServiceRegistryImpl aSIServiceRegistryImpl) {
        this.this$0 = aSIServiceRegistryImpl;
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        ServiceReference serviceReference = serviceEvent.getServiceReference();
        Object object = serviceReference.getProperty("SERVICE_CLASS");
        if (object instanceof String) {
            try {
                object = Class.forName((String)object);
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.this$0.getLogger().error().append("Could not bind ASI service provider.").attachThrowable(classNotFoundException).log();
                object = null;
            }
        }
        if (object instanceof Class) {
            Class clazz = (Class)object;
            switch (serviceEvent.getType()) {
                case 1: 
                case 2: {
                    this.this$0.providerRegistered(clazz, serviceReference);
                    break;
                }
                case 4: {
                    this.this$0.providerUnregistering(clazz, serviceReference);
                    break;
                }
            }
        }
    }
}

