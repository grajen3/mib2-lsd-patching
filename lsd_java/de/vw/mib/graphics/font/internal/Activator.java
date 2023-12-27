/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.graphics.font.internal.Activator$TextLayoutManagerChooser;
import de.vw.mib.graphics.font.internal.CachingFontManager;
import de.vw.mib.graphics.font.internal.CachingTextLayoutManager;
import de.vw.mib.graphics.font.internal.DefaultFontPropertiesLoader;
import de.vw.mib.graphics.font.internal.FontPropertiesLoader;
import de.vw.mib.graphics.font.internal.ServiceManager;
import de.vw.mib.graphics.font.spi.FontSPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.lsctng.LscController;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.util.StringBuilder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator {
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$spi$FontSPI;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$internal$FontPropertiesLoader;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$FontManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$TextLayoutManager;
    static /* synthetic */ Class class$de$vw$mib$lsctng$LscController;

    @Override
    public void start(BundleContext bundleContext) {
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceManager.fontSPI = (FontSPI)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$font$spi$FontSPI == null ? (class$de$vw$mib$graphics$font$spi$FontSPI = Activator.class$("de.vw.mib.graphics.font.spi.FontSPI")) : class$de$vw$mib$graphics$font$spi$FontSPI).getName()));
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$graphics$font$internal$FontPropertiesLoader == null ? (class$de$vw$mib$graphics$font$internal$FontPropertiesLoader = Activator.class$("de.vw.mib.graphics.font.internal.FontPropertiesLoader")) : class$de$vw$mib$graphics$font$internal$FontPropertiesLoader).getName());
        ServiceManager.fontPropertiesLoader = serviceReference != null ? (FontPropertiesLoader)bundleContext.getService(serviceReference) : new DefaultFontPropertiesLoader();
        bundleContext.registerService((class$de$vw$mib$graphics$font$FontManager == null ? (class$de$vw$mib$graphics$font$FontManager = Activator.class$("de.vw.mib.graphics.font.FontManager")) : class$de$vw$mib$graphics$font$FontManager).getName(), (Object)new CachingFontManager(ServiceManager.loggerFactory), null);
        CachingTextLayoutManager cachingTextLayoutManager = new CachingTextLayoutManager(ServiceManager.loggerFactory);
        ServiceManager.textLayoutManager = cachingTextLayoutManager;
        bundleContext.registerService((class$de$vw$mib$graphics$font$TextLayoutManager == null ? (class$de$vw$mib$graphics$font$TextLayoutManager = Activator.class$("de.vw.mib.graphics.font.TextLayoutManager")) : class$de$vw$mib$graphics$font$TextLayoutManager).getName(), (Object)ServiceManager.textLayoutManager, null);
        ServiceReference serviceReference2 = bundleContext.getServiceReference((class$de$vw$mib$lsctng$LscController == null ? (class$de$vw$mib$lsctng$LscController = Activator.class$("de.vw.mib.lsctng.LscController")) : class$de$vw$mib$lsctng$LscController).getName());
        Activator$TextLayoutManagerChooser activator$TextLayoutManagerChooser = new Activator$TextLayoutManagerChooser(bundleContext, cachingTextLayoutManager);
        if (serviceReference2 != null) {
            activator$TextLayoutManagerChooser.registerLscListener((LscController)bundleContext.getService(serviceReference2));
        } else {
            Activator.registerServiceListener(activator$TextLayoutManagerChooser, bundleContext, (class$de$vw$mib$lsctng$LscController == null ? (class$de$vw$mib$lsctng$LscController = Activator.class$("de.vw.mib.lsctng.LscController")) : class$de$vw$mib$lsctng$LscController).getName());
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private static void registerServiceListener(ServiceListener serviceListener, BundleContext bundleContext, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(").append("objectClass").append("=").append(string).append(")");
        bundleContext.addServiceListener(serviceListener, stringBuilder.toString());
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

