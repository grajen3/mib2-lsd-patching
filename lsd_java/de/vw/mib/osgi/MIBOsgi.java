/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi;

import de.vw.mib.extstartup.spi.ExtendedStartupSPI;
import de.vw.mib.extstartup.spi.StartupResumeListener;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.osgi.MIBOsgiMonitor;
import de.vw.mib.osgi.SubRegistry;
import de.vw.mib.osgi.internal.MIBOsgiImpl;
import java.util.Properties;
import org.osgi.framework.Bundle;

public abstract class MIBOsgi
implements StartupResumeListener {
    public static Logger logger;
    public static MIBOsgiMonitor monitor;

    public static MIBOsgi getInstance() {
        return MIBOsgiImpl.getInstance();
    }

    public abstract void addSubRegistry(SubRegistry subRegistry) {
    }

    public abstract void registerMIBOsgiMonitor(MIBOsgiMonitor mIBOsgiMonitor) {
    }

    public abstract int getBundleState(int n) {
    }

    public abstract Bundle[] getLateloadBundles() {
    }

    public abstract Bundle[] getManagedBundles() {
    }

    public abstract Bundle[] getParallelBundles() {
    }

    public abstract int getParallelBundleStartId() {
    }

    public abstract void init(ExtendedStartupSPI extendedStartupSPI, Properties properties) {
    }

    public abstract void init(ExtendedStartupSPI extendedStartupSPI, Properties properties, String string) {
    }

    public abstract void init(ExtendedStartupSPI extendedStartupSPI, Properties properties, String string, String string2) {
    }

    public abstract void startBundle(int n) {
    }

    public abstract void startBundles() {
    }

    public abstract void startAutostartBundles() {
    }

    public abstract void startManagedBundles() {
    }

    public abstract void startLateloadBundles() {
    }

    public abstract void startSPIBundles() {
    }

    public abstract void stopBundle(int n) {
    }

    public abstract void stopBundles() {
    }
}

