/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.internal.generated.SpeechConfiguration;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public interface FrameworkServices {
    default public Logger getSpeechLogger() {
    }

    default public AsyncServiceFactory getAsyncServiceFactory() {
    }

    default public TimerManager getTimerManager() {
    }

    default public ThreadSwitchingTarget getThreadSwitchingTarget() {
    }

    default public ConfigurationManager getConfigurationManager() {
    }

    default public SystemEventDispatcher getSystemEventDispatcher() {
    }

    default public Framework4U getFramework4u() {
    }

    default public FrameworkEventDispatcher getFrameworkEventDispatcher() {
    }

    default public BundleContext getBundleContext() {
    }

    default public SpeechConfiguration getSpeechConfiguration() {
    }
}

