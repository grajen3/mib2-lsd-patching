/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.io.InputStream;
import java.net.URL;
import java.util.Dictionary;
import org.osgi.framework.ServiceReference;

public interface Bundle {
    public static final int UNINSTALLED;
    public static final int INSTALLED;
    public static final int RESOLVED;
    public static final int STARTING;
    public static final int STOPPING;
    public static final int ACTIVE;

    default public int getState() {
    }

    default public void start() {
    }

    default public void stop() {
    }

    default public void update() {
    }

    default public void update(InputStream inputStream) {
    }

    default public void uninstall() {
    }

    default public Dictionary getHeaders() {
    }

    default public long getBundleId() {
    }

    default public String getLocation() {
    }

    default public ServiceReference[] getRegisteredServices() {
    }

    default public ServiceReference[] getServicesInUse() {
    }

    default public boolean hasPermission(Object object) {
    }

    default public URL getResource(String string) {
    }
}

