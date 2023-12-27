/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.esolutions.fw.comm.core.IService;
import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.ASIServiceProvider;
import de.vw.mib.asi.impl.ASIInstanceHandler;
import de.vw.mib.asi.impl.ASIServiceFactory;
import de.vw.mib.asi.instance.ASIInstanceResponse;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.log4mib.ClassifiedLogger;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

class ASIServiceInstanceHandler
implements ASIInstanceHandler {
    private final BundleContext context;
    private final ClassifiedLogger clogger;
    private final ASIServiceFactory factory;
    private final Class serviceClass;
    private final String asiId;
    private final Map requests = Collections.synchronizedMap(new HashMap());
    private final ObjectIntMap deviceInstances = ObjectIntOptHashMap.createWithNeutralValue(3, 63, 63, -1).synchronize();
    private final IntObjectMap serviceRegs = new IntObjectOptHashMap().synchronize();
    private ASIServiceProvider serviceProvider;
    static /* synthetic */ Class class$de$esolutions$fw$comm$core$IService;

    ASIServiceInstanceHandler(BundleContext bundleContext, ClassifiedLogger classifiedLogger, ASIServiceFactory aSIServiceFactory, Class clazz, String string) {
        this.context = bundleContext;
        this.clogger = classifiedLogger;
        this.factory = aSIServiceFactory;
        this.serviceClass = clazz;
        this.asiId = string;
    }

    void fireServiceRegistered(String string, int n) {
        if ("*".equals(string)) {
            Iterator iterator = this.requests.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                string = (String)map$Entry.getKey();
                ASIInstanceResponse aSIInstanceResponse = (ASIInstanceResponse)map$Entry.getValue();
                aSIInstanceResponse.responseInstanceId(this.asiId, string, n, 0);
            }
            this.requests.clear();
        } else {
            ASIInstanceResponse aSIInstanceResponse = (ASIInstanceResponse)this.requests.remove(string);
            if (null != aSIInstanceResponse) {
                aSIInstanceResponse.responseInstanceId(this.asiId, string, n, 0);
            }
        }
    }

    @Override
    public void requestInstanceId(String string, ASIInstanceResponse aSIInstanceResponse) {
        int n = this.getInstanceId(string);
        if (-1 != n) {
            aSIInstanceResponse.responseInstanceId(this.asiId, string, n, 0);
        } else if (null != this.serviceProvider) {
            this.requests.put(string, aSIInstanceResponse);
            this.serviceProvider.createInstance(string);
        } else {
            aSIInstanceResponse.responseInstanceId(this.asiId, string, -1, 2);
        }
    }

    private int getInstanceId(String string) {
        int n = this.deviceInstances.get(string);
        if (-1 == n) {
            n = this.deviceInstances.get("*");
        }
        return n;
    }

    private void setInstanceId(String string, int n) {
        this.deviceInstances.put(string, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerService(int n, String string, ASIService aSIService, ASIProperties aSIProperties) {
        if (0 > n) {
            throw new IllegalArgumentException("instanceId < 0");
        }
        if (null == string) {
            throw new NullPointerException("deviceId");
        }
        if (null == aSIService) {
            throw new NullPointerException("service");
        }
        if (null == aSIProperties) {
            throw new NullPointerException("props");
        }
        IntObjectMap intObjectMap = this.serviceRegs;
        synchronized (intObjectMap) {
            ServiceRegistration serviceRegistration = (ServiceRegistration)this.serviceRegs.get(n);
            if (null == serviceRegistration) {
                IService iService = this.factory.createService(this.serviceClass, n, aSIService, aSIProperties);
                serviceRegistration = this.registerService(iService);
                this.serviceRegs.put(n, serviceRegistration);
            }
        }
        this.setInstanceId(string, n);
        this.fireServiceRegistered(string, n);
    }

    @Override
    public void setServiceProvider(ASIServiceProvider aSIServiceProvider) {
        this.serviceProvider = aSIServiceProvider;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterService(int n) {
        Object object;
        Object object2 = this.deviceInstances;
        synchronized (object2) {
            if (!this.deviceInstances.isEmpty()) {
                object = this.deviceInstances.keyIterator();
                while (object.hasNext()) {
                    String string = (String)object.next();
                    if (n != this.deviceInstances.get(string)) continue;
                    object.remove();
                }
            }
        }
        object2 = this.serviceRegs;
        synchronized (object2) {
            object = (ServiceRegistration)this.serviceRegs.remove(n);
            if (null != object) {
                object.unregister();
            }
        }
    }

    private ServiceRegistration registerService(IService iService) {
        return this.context.registerService((class$de$esolutions$fw$comm$core$IService == null ? (class$de$esolutions$fw$comm$core$IService = ASIServiceInstanceHandler.class$("de.esolutions.fw.comm.core.IService")) : class$de$esolutions$fw$comm$core$IService).getName(), (Object)iService, (Dictionary)null);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

