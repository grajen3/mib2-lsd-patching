/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerFactory;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.format.FixFormat4Asl;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.sound.SoundWaveplayer;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public interface Services {
    default public ASLAPISpellerFactory getASLAPISpellerFactory() {
    }

    default public AsyncServiceFactory getASLAsyncServiceFactory() {
    }

    default public ASLComponentRegistry getASLComponentRegistry() {
    }

    default public ASLDeviceRegistry getASLDeviceRegistry() {
    }

    default public ASLListManager getASLListManager() {
    }

    default public ASLPropertyManager getASLPropertyManager() {
    }

    default public ThreadSwitchingTarget getASLThreadSwitch() {
    }

    default public BundleContext getBundleContext() {
    }

    default public ConfigurationManagerDiag getConfigurationManagerDiag() {
    }

    default public ErrorHandler getErrorHandler() {
    }

    default public EventFactory getEventFactory() {
    }

    default public FixFormat4Asl getFixFormat4Asl() {
    }

    default public Framework4U getFramework4U() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public ImageManager getImageManager() {
    }

    default public PerfService getPerfService() {
    }

    default public SoundWaveplayer getSoundWaveplayer() {
    }

    default public SystemEventDispatcher getSystemEventDispatcher() {
    }

    default public TimerManager getTimerManager() {
    }
}

