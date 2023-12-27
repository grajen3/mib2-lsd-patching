/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.api.impl;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
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

class ServicesImpl
implements Services {
    ServicesImpl() {
    }

    @Override
    public ASLAPISpellerFactory getASLAPISpellerFactory() {
        return ServiceManager.spellerFactory;
    }

    @Override
    public AsyncServiceFactory getASLAsyncServiceFactory() {
        return ServiceManager.aslAsyncServiceFactory;
    }

    @Override
    public ASLComponentRegistry getASLComponentRegistry() {
        return ServiceManager.componentRegistry;
    }

    @Override
    public ASLDeviceRegistry getASLDeviceRegistry() {
        return ServiceManager.deviceRegistry;
    }

    @Override
    public ASLListManager getASLListManager() {
        return ServiceManager.listManager;
    }

    @Override
    public ASLPropertyManager getASLPropertyManager() {
        return ServiceManager.aslPropertyManager;
    }

    @Override
    public ThreadSwitchingTarget getASLThreadSwitch() {
        return ServiceManager.aslThreadSwitch;
    }

    @Override
    public BundleContext getBundleContext() {
        return ServiceManager.bundleContext;
    }

    @Override
    public ConfigurationManagerDiag getConfigurationManagerDiag() {
        return ServiceManager.configManagerDiag;
    }

    @Override
    public ErrorHandler getErrorHandler() {
        return ServiceManager.errorHandler;
    }

    @Override
    public EventFactory getEventFactory() {
        return ServiceManager.mGenericEventFactory;
    }

    @Override
    public FixFormat4Asl getFixFormat4Asl() {
        return ServiceManager.fixFormat4Asl;
    }

    @Override
    public Framework4U getFramework4U() {
        return ServiceManager.framework4U;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return ServiceManager.eventMain;
    }

    @Override
    public ImageManager getImageManager() {
        return ServiceManager.imageManager;
    }

    @Override
    public PerfService getPerfService() {
        return ServiceManager.perfService;
    }

    @Override
    public SoundWaveplayer getSoundWaveplayer() {
        return ServiceManager.soundWaveplayer;
    }

    @Override
    public SystemEventDispatcher getSystemEventDispatcher() {
        return ServiceManager.eventDispatcher;
    }

    @Override
    public TimerManager getTimerManager() {
        return ServiceManager.timerManager;
    }
}

