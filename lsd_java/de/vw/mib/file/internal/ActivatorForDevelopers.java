/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.file.internal;

import de.vw.mib.file.FileManager;
import de.vw.mib.file.internal.FileManagerImpl;
import de.vw.mib.file.spi.FileSPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.spi.TimerSPI;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ActivatorForDevelopers
implements BundleActivator {
    static final String FILE_MANAGER_FOR_DEVELOPERS;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$file$spi$FileSPI;
    static /* synthetic */ Class class$de$vw$mib$timer$spi$TimerSPI;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;

    @Override
    public void start(BundleContext bundleContext) {
        LoggerFactory loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ActivatorForDevelopers.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        FileSPI fileSPI = (FileSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$file$spi$FileSPI == null ? (class$de$vw$mib$file$spi$FileSPI = ActivatorForDevelopers.class$("de.vw.mib.file.spi.FileSPI")) : class$de$vw$mib$file$spi$FileSPI).getName()));
        TimerSPI timerSPI = (TimerSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$spi$TimerSPI == null ? (class$de$vw$mib$timer$spi$TimerSPI = ActivatorForDevelopers.class$("de.vw.mib.timer.spi.TimerSPI")) : class$de$vw$mib$timer$spi$TimerSPI).getName()));
        bundleContext.registerService((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = ActivatorForDevelopers.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName(), (Object)this.createFileManager(loggerFactory, fileSPI, timerSPI), null);
    }

    private FileManager createFileManager(LoggerFactory loggerFactory, FileSPI fileSPI, TimerSPI timerSPI) {
        try {
            Class clazz = Class.forName("de.vw.mib.file.internal.FileManagerForDevelopers");
            return (FileManager)clazz.getDeclaredConstructor(new Class[]{class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ActivatorForDevelopers.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory, class$de$vw$mib$file$spi$FileSPI == null ? (class$de$vw$mib$file$spi$FileSPI = ActivatorForDevelopers.class$("de.vw.mib.file.spi.FileSPI")) : class$de$vw$mib$file$spi$FileSPI, class$de$vw$mib$timer$spi$TimerSPI == null ? (class$de$vw$mib$timer$spi$TimerSPI = ActivatorForDevelopers.class$("de.vw.mib.timer.spi.TimerSPI")) : class$de$vw$mib$timer$spi$TimerSPI}).newInstance(new Object[]{loggerFactory, fileSPI, timerSPI});
        }
        catch (Exception exception) {
            return new FileManagerImpl(loggerFactory, fileSPI, timerSPI);
        }
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

