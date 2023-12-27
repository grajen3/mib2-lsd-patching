/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debug.common.probes.configuration.DebugProbeConfiguration;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.internal.ProbeSystemServiceImpl$1;
import de.vw.mib.debugmanager.probes.DebugProbeFactory;
import de.vw.mib.debugmanager.probes.ProbeSystemServiceListener;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.timer.TimerManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

final class ProbeSystemServiceImpl
implements ProbeSystemServices,
ServiceListener {
    private final TimerManager timerManager;
    private final BinaryLogger binaryLogger;
    private final BundleContext bundleContext;
    private final LoggerFactory loggerFactory;
    final Logger logger;
    final DebugProbeFactory debugProbeFactory;
    final DebugProbeConfiguration probeConfiguration;
    Map serviceListenerMap;
    private HashMap registeredServices = new HashMap();
    final ObjectPool codecPool = new ProbeSystemServiceImpl$1(this, 10);

    public ProbeSystemServiceImpl(LoggerFactory loggerFactory, BinaryLogger binaryLogger, TimerManager timerManager, BundleContext bundleContext, DebugProbeFactory debugProbeFactory) {
        this.bundleContext = bundleContext;
        this.binaryLogger = binaryLogger;
        this.logger = loggerFactory.getLogger(64);
        this.loggerFactory = loggerFactory;
        this.debugProbeFactory = debugProbeFactory;
        this.timerManager = timerManager;
        this.probeConfiguration = debugProbeFactory.createProbeConfiguration();
    }

    @Override
    public AbstractProbeCodec borrowCodec() {
        return (AbstractProbeCodec)this.codecPool.borrowObject();
    }

    @Override
    public void releaseCodec(AbstractProbeCodec abstractProbeCodec) {
        this.codecPool.releaseObject(abstractProbeCodec);
    }

    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public Object getService(String string) {
        ServiceReference serviceReference = this.bundleContext.getServiceReference(string);
        if (serviceReference == null) {
            return null;
        }
        return this.bundleContext.getService(serviceReference);
    }

    @Override
    public void registerServiceListener(String string, ProbeSystemServiceListener probeSystemServiceListener) {
        this.addServiceListenerToRegistryMap(string, probeSystemServiceListener);
        String string2 = new StringBuffer().append("(objectClass=").append(string).append(")").toString();
        try {
            this.bundleContext.addServiceListener(this, string2);
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(string, null);
            for (int i2 = serviceReferenceArray.length - 1; i2 >= 0; --i2) {
                this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            // empty catch block
        }
    }

    @Override
    public void unregisterServiceListener(String string, ProbeSystemServiceListener probeSystemServiceListener) {
        Set set = (Set)this.serviceListenerMap.get(string);
        set.remove(probeSystemServiceListener);
        if (set.isEmpty()) {
            this.serviceListenerMap.remove(string);
        }
        if (this.serviceListenerMap.isEmpty()) {
            this.bundleContext.removeServiceListener(this);
        }
    }

    private void addServiceListenerToRegistryMap(String string, ProbeSystemServiceListener probeSystemServiceListener) {
        Set set;
        if (this.serviceListenerMap == null) {
            this.serviceListenerMap = new HashMap();
        }
        if ((set = (Set)this.serviceListenerMap.get(string)) == null) {
            set = new HashSet();
            this.serviceListenerMap.put(string, set);
        }
        set.add(probeSystemServiceListener);
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block3: {
            String[] stringArray;
            Object object;
            block2: {
                object = this.bundleContext.getService(serviceEvent.getServiceReference());
                stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                if (serviceEvent.getType() != 1) break block2;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.handleServiceRegistered(stringArray[i2], object, serviceEvent.getServiceReference());
                }
                break block3;
            }
            if (serviceEvent.getType() != 4) break block3;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.handleServiceUnregistering(stringArray[i3], object, serviceEvent.getServiceReference());
            }
        }
    }

    private void handleServiceRegistered(String string, Object object, ServiceReference serviceReference) {
        if (this.serviceListenerMap == null) {
            return;
        }
        Set set = (Set)this.serviceListenerMap.get(string);
        if (set == null) {
            return;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            ProbeSystemServiceListener probeSystemServiceListener = (ProbeSystemServiceListener)iterator.next();
            probeSystemServiceListener.serviceRegistered(string, object);
        }
    }

    private void handleServiceUnregistering(String string, Object object, ServiceReference serviceReference) {
        if (this.serviceListenerMap == null) {
            return;
        }
        Set set = (Set)this.serviceListenerMap.get(string);
        if (set == null) {
            return;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            ProbeSystemServiceListener probeSystemServiceListener = (ProbeSystemServiceListener)iterator.next();
            probeSystemServiceListener.serviceUnregistered(string, object);
        }
    }

    @Override
    public void registerService(String string, Object object) {
        this.registeredServices.put(object, this.bundleContext.registerService(string, object, null));
    }

    @Override
    public void unregisterService(String string, Object object) {
        ServiceRegistration serviceRegistration = (ServiceRegistration)this.registeredServices.get(object);
        if (serviceRegistration != null) {
            serviceRegistration.unregister();
        }
    }

    @Override
    public long getTimestamp() {
        return this.timerManager.getSystemTimeMillis();
    }

    @Override
    public Logger getLogger(int n) {
        return this.loggerFactory.getLogger(n);
    }

    @Override
    public BinaryMessage createMessage() {
        return this.binaryLogger.getBinaryMessage(this.debugProbeFactory.getMessageType());
    }

    @Override
    public BinaryMessage createConfigurationMessage() {
        return this.binaryLogger.getBinaryMessage(this.debugProbeFactory.getConfigurationMessageType());
    }

    @Override
    public DebugProbeConfiguration getConfiguration() {
        return this.probeConfiguration;
    }
}

