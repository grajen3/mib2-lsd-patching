/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.osgi.MIBOsgi;
import de.vw.mib.osgi.ServiceDelegationManager;
import de.vw.mib.osgi.internal.BundleInfo$ServiceListenerEntry;
import de.vw.mib.osgi.internal.BundleRegistry;
import de.vw.mib.osgi.internal.ServiceFilter;
import de.vw.mib.osgi.internal.ServiceInfo;
import de.vw.mib.osgi.internal.ServiceRegistry;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public final class BundleInfo
implements Bundle,
BundleContext {
    private static final int PRIME;
    private final String activatorClass;
    private BundleActivator bundleActivator;
    private Dictionary headers;
    private final int id;
    private final String locationStr;
    private final String name;
    private final ArrayList registeredServices = new ArrayList();
    private final ArrayList servicesInUse = new ArrayList();
    private int state = 4;

    public BundleInfo(int n, String string, String string2) {
        this.id = n;
        this.activatorClass = string2;
        this.name = string;
        StringBuffer stringBuffer = new StringBuffer(32);
        stringBuffer.append(this.id).append("-").append(string);
        this.locationStr = stringBuffer.toString();
    }

    @Override
    public void addBundleListener(BundleListener bundleListener) {
        BundleRegistry.getInstance().addBundleListener(bundleListener);
    }

    @Override
    public void addFrameworkListener(FrameworkListener frameworkListener) {
        throw new UnsupportedOperationException("BundleContext#addFrameworkListener(FrameworkListener) not supported!");
    }

    @Override
    public void addServiceListener(ServiceListener serviceListener) {
        if (MIBOsgi.logger.isTraceEnabled(2)) {
            LogMessage logMessage = MIBOsgi.logger.trace(2);
            this.bundleInfoToLogMessage(logMessage);
            logMessage.append(" add service listener '").append(serviceListener).append("'");
            logMessage.log();
        }
        ServiceRegistry.getInstance().addServiceListener(new BundleInfo$ServiceListenerEntry(serviceListener));
    }

    @Override
    public void addServiceListener(ServiceListener serviceListener, String string) {
        if (MIBOsgi.logger.isTraceEnabled(2)) {
            LogMessage logMessage = MIBOsgi.logger.trace(2);
            this.bundleInfoToLogMessage(logMessage);
            logMessage.append(" add service listener '").append(serviceListener);
            logMessage.append("' with filter '").append(string).append("'");
            logMessage.log();
        }
        ServiceRegistry.getInstance().addServiceListener(new BundleInfo$ServiceListenerEntry(serviceListener, string));
    }

    @Override
    public Filter createFilter(String string) {
        return new ServiceFilter(string);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        return this.id == ((BundleInfo)object).id;
    }

    @Override
    public Bundle getBundle() {
        return this;
    }

    @Override
    public Bundle getBundle(long l) {
        if (l < 0) {
            return BundleRegistry.getInstance().getBundle((int)l);
        }
        return null;
    }

    @Override
    public long getBundleId() {
        return this.id;
    }

    @Override
    public Bundle[] getBundles() {
        return BundleRegistry.getInstance().getBundles();
    }

    @Override
    public File getDataFile(String string) {
        return null;
    }

    @Override
    public Dictionary getHeaders() {
        if (this.headers == null) {
            this.initHeader();
        }
        return this.headers;
    }

    @Override
    public String getLocation() {
        return this.locationStr;
    }

    @Override
    public String getProperty(String string) {
        if (this.headers == null) {
            this.initHeader();
        }
        return (String)this.headers.get(string);
    }

    @Override
    public ServiceReference[] getRegisteredServices() {
        Object[] objectArray = new ServiceReference[this.registeredServices.size()];
        this.registeredServices.toArray(objectArray);
        return objectArray;
    }

    @Override
    public URL getResource(String string) {
        return ClassLoader.getSystemResource(string);
    }

    @Override
    public synchronized Object getService(ServiceReference serviceReference) {
        this.servicesInUse.add(serviceReference);
        return ServiceRegistry.getInstance().getService((ServiceInfo)serviceReference);
    }

    @Override
    public ServiceReference getServiceReference(String string) {
        return ServiceRegistry.getInstance().getServiceInfo(string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public ServiceReference[] getServiceReferences(String string, String string2) {
        Collection collection;
        Object[] objectArray;
        if (string == null) {
            return this.getServiceReferences("*", string2);
        }
        if (string2 != null) {
            objectArray = new ServiceFilter(string2);
            collection = ServiceRegistry.getInstance().getServiceInfos(string);
            if (collection.isEmpty()) return new ServiceInfo[0];
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (objectArray.match((ServiceInfo)iterator.next())) continue;
                iterator.remove();
            }
        } else {
            collection = ServiceRegistry.getInstance().getServiceInfos(string);
        }
        objectArray = new ServiceInfo[collection.size()];
        if (collection.isEmpty()) return objectArray;
        collection.toArray(objectArray);
        return objectArray;
    }

    @Override
    public synchronized ServiceReference[] getServicesInUse() {
        Object[] objectArray = new ServiceReference[this.servicesInUse.size()];
        if (!this.servicesInUse.isEmpty()) {
            this.servicesInUse.toArray(objectArray);
        }
        return objectArray;
    }

    @Override
    public int getState() {
        return this.state;
    }

    public int hashCode() {
        return 31 * this.id;
    }

    @Override
    public boolean hasPermission(Object object) {
        return true;
    }

    @Override
    public Bundle installBundle(String string) {
        throw new UnsupportedOperationException("BundleContext#installBundle(String) not supported!");
    }

    @Override
    public Bundle installBundle(String string, InputStream inputStream) {
        throw new UnsupportedOperationException("BundleContext#installBundle(String, InputStream) not supported!");
    }

    @Override
    public ServiceRegistration registerService(String string, Object object, Dictionary dictionary) {
        if (MIBOsgi.logger.isTraceEnabled(2)) {
            LogMessage logMessage = MIBOsgi.logger.trace(2);
            this.bundleInfoToLogMessage(logMessage);
            logMessage.append(" register service '").append(object).append("' as '").append(string).append("'");
            logMessage.log();
        }
        return ServiceDelegationManager.getInstance().getServiceInfo(this, new String[]{string}, object, dictionary);
    }

    @Override
    public ServiceRegistration registerService(String[] stringArray, Object object, Dictionary dictionary) {
        if (MIBOsgi.logger.isTraceEnabled(2)) {
            LogMessage logMessage = MIBOsgi.logger.trace(2);
            this.bundleInfoToLogMessage(logMessage);
            logMessage.append(" register service '").append(object).append("' as ");
            this.arrayToLogMessage(stringArray, logMessage);
            logMessage.log();
        }
        return ServiceDelegationManager.getInstance().getServiceInfo(this, stringArray, object, dictionary);
    }

    @Override
    public void removeBundleListener(BundleListener bundleListener) {
        BundleRegistry.getInstance().removeBundleListener(bundleListener);
    }

    @Override
    public void removeFrameworkListener(FrameworkListener frameworkListener) {
        throw new UnsupportedOperationException("BundleContext#removeFrameworkListener(FrameworkListener) not supported!");
    }

    @Override
    public void removeServiceListener(ServiceListener serviceListener) {
        if (MIBOsgi.logger.isTraceEnabled(2)) {
            LogMessage logMessage = MIBOsgi.logger.trace(2);
            this.bundleInfoToLogMessage(logMessage);
            logMessage.append(" remove service listener '").append(serviceListener).append("'");
            logMessage.log();
        }
        ServiceRegistry.getInstance().removeServiceListener(serviceListener);
    }

    @Override
    public void start() {
        this.state = 8;
        MIBOsgi.monitor.bundleStateChanged(this.state, this);
        if (this.bundleActivator == null) {
            this.bundleActivator = this.loadBundleActivator(this.activatorClass);
        }
        try {
            this.bundleActivator.start(this);
        }
        catch (Exception exception) {
            this.bundleActivator = null;
            this.state = 4;
            throw new BundleException(new StringBuffer().append("error while starting bundle ").append(this.getLocation()).toString(), exception);
        }
        this.state = 32;
        MIBOsgi.monitor.bundleStateChanged(this.state, this);
        BundleRegistry.getInstance().notifyBundleListeners(new BundleEvent(2, this));
    }

    @Override
    public void stop() {
        if (this.bundleActivator == null) {
            this.state = 4;
            return;
        }
        this.state = 16;
        try {
            this.bundleActivator.stop(this);
            for (int i2 = this.registeredServices.size() - 1; i2 >= 0; --i2) {
                ((ServiceInfo)this.registeredServices.get(i2)).unregister();
            }
        }
        catch (Exception exception) {
            throw new BundleException(new StringBuffer().append("error while stopping bundle ").append(this.getLocation()).toString(), exception);
        }
        finally {
            this.bundleActivator = null;
            this.state = 4;
            BundleRegistry.getInstance().notifyBundleListeners(new BundleEvent(4, this));
        }
    }

    public String toString() {
        int n;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[").append(this.id).append("] ");
        stringBuffer.append(this.name);
        switch (this.state) {
            case 1: {
                stringBuffer.append(" (UNINSTALLED)");
                break;
            }
            case 2: {
                stringBuffer.append(" (INSTALLED)");
                break;
            }
            case 4: {
                stringBuffer.append(" (RESOLVED)");
                break;
            }
            case 8: {
                stringBuffer.append(" (STARTING)");
                break;
            }
            case 16: {
                stringBuffer.append(" (STOPPING)");
                break;
            }
            case 32: {
                stringBuffer.append(" (ACTIVE)");
                break;
            }
            default: {
                stringBuffer.append(" (Unknown state :").append(this.state).append(")");
            }
        }
        stringBuffer.append(" (").append(this.activatorClass).append(")");
        int n2 = this.registeredServices.size();
        stringBuffer.append("\n     Registered Services (").append(n2).append("):");
        if (n2 == 0) {
            stringBuffer.append(" NONE");
        } else {
            for (n = 0; n < n2; ++n) {
                stringBuffer.append('\n');
                stringBuffer.append("          -> ");
                stringBuffer.append(this.registeredServices.get(n));
            }
        }
        n = this.servicesInUse.size();
        stringBuffer.append("\n     Services in use (").append(n).append("):");
        if (n == 0) {
            stringBuffer.append(" NONE");
        } else {
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\n');
                stringBuffer.append("          -> ");
                stringBuffer.append(this.servicesInUse.get(i2));
            }
        }
        stringBuffer.append('\n');
        return stringBuffer.toString();
    }

    @Override
    public synchronized boolean ungetService(ServiceReference serviceReference) {
        return this.servicesInUse.remove(serviceReference);
    }

    @Override
    public void uninstall() {
        throw new UnsupportedOperationException("Bundle#uninstall() not supported!");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Bundle#update() not supported!");
    }

    @Override
    public void update(InputStream inputStream) {
        throw new UnsupportedOperationException("Bundle#update(InputStream) not supported!");
    }

    private void arrayToLogMessage(String[] stringArray, LogMessage logMessage) {
        if (stringArray == null) {
            logMessage.append("null");
        } else if (stringArray.length == 0) {
            logMessage.append("[]");
        } else {
            logMessage.append('[');
            for (int i2 = 0; i2 < stringArray.length - 1; ++i2) {
                logMessage.append(stringArray[i2]);
                logMessage.append(", ");
            }
            logMessage.append(stringArray[stringArray.length - 1]);
            logMessage.append(']');
        }
    }

    private void bundleInfoToLogMessage(LogMessage logMessage) {
        logMessage.append("[");
        logMessage.append(this.id);
        logMessage.append("-");
        logMessage.append(this.name);
        logMessage.append("]");
    }

    private void initHeader() {
        this.headers = new Hashtable(5);
        this.headers.put("Bundle-Name", this.name);
        this.headers.put("Bundle-Activator", this.activatorClass);
    }

    private BundleActivator loadBundleActivator(String string) {
        try {
            Class clazz = Class.forName(string);
            return (BundleActivator)clazz.newInstance();
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new BundleException(new StringBuffer().append("[").append(this.getLocation()).append(", activator = ").append(string).append("] activator not found").toString(), classNotFoundException);
        }
        catch (InstantiationException instantiationException) {
            throw new BundleException(new StringBuffer().append("[").append(this.getLocation()).append("] activator invalid").toString(), instantiationException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new BundleException(new StringBuffer().append("[").append(this.getLocation()).append("] activator invalid").toString(), illegalAccessException);
        }
    }

    void addService(ServiceInfo serviceInfo) {
        this.registeredServices.add(serviceInfo);
    }

    String getActivatorClass() {
        return this.activatorClass;
    }

    void preload() {
        this.bundleActivator = this.loadBundleActivator(this.activatorClass);
        if (!(this.bundleActivator instanceof BundleActivatorExtension)) {
            throw new BundleException(new StringBuffer().append("activator of bundle ").append(this.getLocation()).append(" doesn't support preloading").toString());
        }
        try {
            ((BundleActivatorExtension)this.bundleActivator).preload(this);
        }
        catch (Exception exception) {
            this.bundleActivator = null;
            this.state = 4;
            throw new BundleException(new StringBuffer().append("error while preloading bundle ").append(this.getLocation()).toString(), exception);
        }
        this.state = 8;
    }

    void removeService(ServiceInfo serviceInfo) {
        this.registeredServices.remove(serviceInfo);
    }
}

