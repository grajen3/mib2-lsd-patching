/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.file.internal;

import de.vw.mib.file.internal.FileManagerImpl;
import de.vw.mib.file.spi.FileSPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.spi.TimerSPI;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$file$spi$FileSPI;
    static /* synthetic */ Class class$de$vw$mib$timer$spi$TimerSPI;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;

    @Override
    public void start(BundleContext bundleContext) {
        LoggerFactory loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        FileSPI fileSPI = (FileSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$file$spi$FileSPI == null ? (class$de$vw$mib$file$spi$FileSPI = Activator.class$("de.vw.mib.file.spi.FileSPI")) : class$de$vw$mib$file$spi$FileSPI).getName()));
        TimerSPI timerSPI = (TimerSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$spi$TimerSPI == null ? (class$de$vw$mib$timer$spi$TimerSPI = Activator.class$("de.vw.mib.timer.spi.TimerSPI")) : class$de$vw$mib$timer$spi$TimerSPI).getName()));
        bundleContext.registerService((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = Activator.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName(), (Object)new FileManagerImpl(loggerFactory, fileSPI, timerSPI), null);
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

