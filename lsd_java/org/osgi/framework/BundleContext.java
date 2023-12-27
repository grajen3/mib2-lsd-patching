/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.io.File;
import java.io.InputStream;
import java.util.Dictionary;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public interface BundleContext {
    default public String getProperty(String string) {
    }

    default public Bundle getBundle() {
    }

    default public Bundle installBundle(String string) {
    }

    default public Bundle installBundle(String string, InputStream inputStream) {
    }

    default public Bundle getBundle(long l) {
    }

    default public Bundle[] getBundles() {
    }

    default public void addServiceListener(ServiceListener serviceListener, String string) {
    }

    default public void addServiceListener(ServiceListener serviceListener) {
    }

    default public void removeServiceListener(ServiceListener serviceListener) {
    }

    default public void addBundleListener(BundleListener bundleListener) {
    }

    default public void removeBundleListener(BundleListener bundleListener) {
    }

    default public void addFrameworkListener(FrameworkListener frameworkListener) {
    }

    default public void removeFrameworkListener(FrameworkListener frameworkListener) {
    }

    default public ServiceRegistration registerService(String[] stringArray, Object object, Dictionary dictionary) {
    }

    default public ServiceRegistration registerService(String string, Object object, Dictionary dictionary) {
    }

    default public ServiceReference[] getServiceReferences(String string, String string2) {
    }

    default public ServiceReference getServiceReference(String string) {
    }

    default public Object getService(ServiceReference serviceReference) {
    }

    default public boolean ungetService(ServiceReference serviceReference) {
    }

    default public File getDataFile(String string) {
    }

    default public Filter createFilter(String string) {
    }
}

