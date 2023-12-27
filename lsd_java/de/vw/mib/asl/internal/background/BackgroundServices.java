/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.background;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;

public interface BackgroundServices {
    default public ASLPropertyManager getAslPropertyManager() {
    }

    default public BundleContext getBundleContext() {
    }

    default public ConfigurationManagerDiag getConfigurationManager() {
    }

    default public AsyncServiceFactory getAsyncServiceFactory() {
    }
}

