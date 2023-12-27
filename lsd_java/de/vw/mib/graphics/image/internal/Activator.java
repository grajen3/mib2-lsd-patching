/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import de.vw.mib.graphics.image.internal.CachingImageManager;
import de.vw.mib.graphics.image.internal.ResetFactorySettingsCacheFlusher;
import de.vw.mib.graphics.image.internal.ServiceManager;
import de.vw.mib.graphics.image.spi.ImageSPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public final class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$spi$ImageSPI;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$ImageManager;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer;

    @Override
    public void start(BundleContext bundleContext) {
        ServiceManager.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.fileManager = (FileManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = Activator.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName()));
        ServiceManager.imageSPI = (ImageSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$image$spi$ImageSPI == null ? (class$de$vw$mib$graphics$image$spi$ImageSPI = Activator.class$("de.vw.mib.graphics.image.spi.ImageSPI")) : class$de$vw$mib$graphics$image$spi$ImageSPI).getName()));
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.threadManager = (MIBThreadManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager).getName()));
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        CachingImageManager cachingImageManager = new CachingImageManager(ServiceManager.loggerFactory);
        bundleContext.registerService((class$de$vw$mib$graphics$image$ImageManager == null ? (class$de$vw$mib$graphics$image$ImageManager = Activator.class$("de.vw.mib.graphics.image.ImageManager")) : class$de$vw$mib$graphics$image$ImageManager).getName(), (Object)cachingImageManager, null);
        bundleContext.registerService((class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer == null ? (class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer = Activator.class$("de.vw.mib.event.consumer.RestoreFactorySettingsEventConsumer")) : class$de$vw$mib$event$consumer$RestoreFactorySettingsEventConsumer).getName(), (Object)new ResetFactorySettingsCacheFlusher(cachingImageManager), null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

