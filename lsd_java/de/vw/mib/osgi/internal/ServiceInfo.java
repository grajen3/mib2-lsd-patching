/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi.internal;

import de.vw.mib.osgi.internal.BundleInfo;
import de.vw.mib.osgi.internal.ServiceRegistry;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public final class ServiceInfo
implements ServiceReference,
ServiceRegistration {
    private static final int INITIAL_STRINGBUFFER_SIZE;
    private static long highestServiceID;
    private BundleInfo bundleInfo;
    private boolean registered = false;
    private long serviceID;
    private String[] serviceInterfaces;
    private Object serviceObject;
    private Dictionary serviceProperties;

    public ServiceInfo(BundleInfo bundleInfo, String string, Object object, Dictionary dictionary) {
        this(bundleInfo, new String[]{string}, object, dictionary);
    }

    public ServiceInfo(BundleInfo bundleInfo, String[] stringArray, Object object, Dictionary dictionary) {
        this.bundleInfo = bundleInfo;
        this.serviceID = ++highestServiceID;
        this.serviceInterfaces = stringArray;
        this.serviceProperties = dictionary;
        if (this.serviceProperties == null) {
            this.serviceProperties = new Hashtable(2);
        }
        this.serviceObject = object;
        this.serviceProperties.put("service.id", new Long(this.serviceID));
        this.serviceProperties.put("objectClass", this.serviceInterfaces);
        if (this.bundleInfo != null) {
            this.bundleInfo.addService(this);
        }
        ServiceRegistry.getInstance().registerService(this);
        this.registered = true;
    }

    @Override
    public Bundle getBundle() {
        return this.bundleInfo;
    }

    public Dictionary getProperties() {
        return this.serviceProperties;
    }

    @Override
    public Object getProperty(String string) {
        return this.serviceProperties.get(string);
    }

    @Override
    public String[] getPropertyKeys() {
        int n = this.serviceProperties.size();
        if (n == 0) {
            return new String[0];
        }
        String[] stringArray = new String[n];
        Enumeration enumeration = this.serviceProperties.keys();
        int n2 = 0;
        while (enumeration.hasMoreElements()) {
            stringArray[n2] = (String)enumeration.nextElement();
            ++n2;
        }
        return stringArray;
    }

    @Override
    public ServiceReference getReference() {
        return this;
    }

    Object getService() {
        return this.serviceObject;
    }

    public long getServiceID() {
        return this.serviceID;
    }

    public String[] getServiceInterfaces() {
        return this.serviceInterfaces;
    }

    @Override
    public Bundle[] getUsingBundles() {
        throw new UnsupportedOperationException("ServiceReference.getUsingBundles is not supported");
    }

    @Override
    public void setProperties(Dictionary dictionary) {
        throw new UnsupportedOperationException("ServiceRegistration.setProperties is not supported");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("[").append(this.serviceID).append("] ");
        stringBuffer.append(this.serviceInterfaces[0]);
        for (int i2 = 1; i2 < this.serviceInterfaces.length; ++i2) {
            stringBuffer.append(", ");
            stringBuffer.append(this.serviceInterfaces[i2]);
        }
        stringBuffer.append(" ( ");
        if (this.serviceProperties.size() > 0) {
            Enumeration enumeration = this.serviceProperties.keys();
            String string = (String)enumeration.nextElement();
            stringBuffer.append(string).append("=").append(this.serviceProperties.get(string));
            while (enumeration.hasMoreElements()) {
                string = (String)enumeration.nextElement();
                stringBuffer.append(" | ");
                stringBuffer.append(string).append("=").append(this.serviceProperties.get(string));
            }
        }
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }

    @Override
    public void unregister() {
        if (!this.registered) {
            throw new IllegalStateException("service already unregistered");
        }
        if (this.bundleInfo != null) {
            this.bundleInfo.removeService(this);
        }
        ServiceRegistry.getInstance().unregisterService(this);
        this.registered = false;
        this.serviceObject = null;
    }

    static {
        highestServiceID = -1L;
    }
}

