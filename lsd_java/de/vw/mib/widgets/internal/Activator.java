/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.internal;

import de.vw.mib.animation.control.AnimationManager;
import de.vw.mib.asia.AsiaInput;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.SkinInformationService;
import de.vw.mib.debugmanager.performance.PerformanceIndicatorService;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.format.FixFormat;
import de.vw.mib.graphics.GraphicsManager;
import de.vw.mib.graphics.display.DisplayManager;
import de.vw.mib.graphics.font.FontManager;
import de.vw.mib.graphics.font.TextLayoutManager;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.proximation.ProximityInstaller;
import de.vw.mib.repaint.RepaintManager;
import de.vw.mib.sound.SoundWaveplayer;
import de.vw.mib.speller.SpellerController;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.view.internal.ViewCompositorImpl;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.internal.WidgetManagerImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator,
ServiceListener {
    private BundleContext context;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$configuration$SkinInformationService;
    static /* synthetic */ Class class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService;
    static /* synthetic */ Class class$de$vw$mib$animation$control$AnimationManager;
    static /* synthetic */ Class class$de$vw$mib$asia$AsiaInput;
    static /* synthetic */ Class class$de$vw$mib$graphics$display$DisplayManager;
    static /* synthetic */ Class class$de$vw$mib$format$FixFormat;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$FontManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$font$TextLayoutManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$GraphicsManager;
    static /* synthetic */ Class class$de$vw$mib$graphics$image$ImageManager;
    static /* synthetic */ Class class$de$vw$mib$proximation$ProximityInstaller;
    static /* synthetic */ Class class$de$vw$mib$repaint$RepaintManager;
    static /* synthetic */ Class class$de$vw$mib$sound$SoundWaveplayer;
    static /* synthetic */ Class class$de$vw$mib$speller$SpellerController;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$ViewEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$view$ViewCompositor;
    static /* synthetic */ Class class$de$vw$mib$widgets$WidgetManager;

    @Override
    public void start(BundleContext bundleContext) {
        ServiceReference serviceReference;
        this.context = bundleContext;
        ServiceManager.logManager = (LogManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName()));
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        ServiceReference serviceReference2 = bundleContext.getServiceReference((class$de$vw$mib$configuration$SkinInformationService == null ? (class$de$vw$mib$configuration$SkinInformationService = Activator.class$("de.vw.mib.configuration.SkinInformationService")) : class$de$vw$mib$configuration$SkinInformationService).getName());
        if (serviceReference2 != null) {
            ServiceManager.skinInformationService = (SkinInformationService)bundleContext.getService(serviceReference2);
        }
        if ((serviceReference = bundleContext.getServiceReference((class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService == null ? (class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService = Activator.class$("de.vw.mib.debugmanager.performance.PerformanceIndicatorService")) : class$de$vw$mib$debugmanager$performance$PerformanceIndicatorService).getName())) != null) {
            ServiceManager.performanceIndicatorService = (PerformanceIndicatorService)bundleContext.getService(serviceReference);
        }
        ServiceManager.animationManager = (AnimationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$animation$control$AnimationManager == null ? (class$de$vw$mib$animation$control$AnimationManager = Activator.class$("de.vw.mib.animation.control.AnimationManager")) : class$de$vw$mib$animation$control$AnimationManager).getName()));
        ServiceManager.animationManager.start();
        ServiceReference serviceReference3 = bundleContext.getServiceReference((class$de$vw$mib$asia$AsiaInput == null ? (class$de$vw$mib$asia$AsiaInput = Activator.class$("de.vw.mib.asia.AsiaInput")) : class$de$vw$mib$asia$AsiaInput).getName());
        if (serviceReference3 != null) {
            ServiceManager.asiaInput = (AsiaInput)bundleContext.getService(serviceReference3);
        } else {
            this.registerServiceListener(bundleContext, (class$de$vw$mib$asia$AsiaInput == null ? (class$de$vw$mib$asia$AsiaInput = Activator.class$("de.vw.mib.asia.AsiaInput")) : class$de$vw$mib$asia$AsiaInput).getName());
        }
        ServiceManager.displayManager = (DisplayManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$display$DisplayManager == null ? (class$de$vw$mib$graphics$display$DisplayManager = Activator.class$("de.vw.mib.graphics.display.DisplayManager")) : class$de$vw$mib$graphics$display$DisplayManager).getName()));
        ServiceManager.fixFormat = (FixFormat)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$format$FixFormat == null ? (class$de$vw$mib$format$FixFormat = Activator.class$("de.vw.mib.format.FixFormat")) : class$de$vw$mib$format$FixFormat).getName()));
        ServiceManager.fontManager = (FontManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$font$FontManager == null ? (class$de$vw$mib$graphics$font$FontManager = Activator.class$("de.vw.mib.graphics.font.FontManager")) : class$de$vw$mib$graphics$font$FontManager).getName()));
        ServiceManager.textLayoutManager = (TextLayoutManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$font$TextLayoutManager == null ? (class$de$vw$mib$graphics$font$TextLayoutManager = Activator.class$("de.vw.mib.graphics.font.TextLayoutManager")) : class$de$vw$mib$graphics$font$TextLayoutManager).getName()));
        ServiceManager.gfxManager = (GraphicsManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$GraphicsManager == null ? (class$de$vw$mib$graphics$GraphicsManager = Activator.class$("de.vw.mib.graphics.GraphicsManager")) : class$de$vw$mib$graphics$GraphicsManager).getName()));
        ServiceManager.imageManager = (ImageManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$graphics$image$ImageManager == null ? (class$de$vw$mib$graphics$image$ImageManager = Activator.class$("de.vw.mib.graphics.image.ImageManager")) : class$de$vw$mib$graphics$image$ImageManager).getName()));
        ServiceReference serviceReference4 = bundleContext.getServiceReference((class$de$vw$mib$proximation$ProximityInstaller == null ? (class$de$vw$mib$proximation$ProximityInstaller = Activator.class$("de.vw.mib.proximation.ProximityInstaller")) : class$de$vw$mib$proximation$ProximityInstaller).getName());
        if (serviceReference4 != null) {
            ServiceManager.proximityInstaller = (ProximityInstaller)bundleContext.getService(serviceReference4);
        } else {
            this.registerServiceListener(bundleContext, (class$de$vw$mib$proximation$ProximityInstaller == null ? (class$de$vw$mib$proximation$ProximityInstaller = Activator.class$("de.vw.mib.proximation.ProximityInstaller")) : class$de$vw$mib$proximation$ProximityInstaller).getName());
        }
        ServiceManager.repaintManager = (RepaintManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$repaint$RepaintManager == null ? (class$de$vw$mib$repaint$RepaintManager = Activator.class$("de.vw.mib.repaint.RepaintManager")) : class$de$vw$mib$repaint$RepaintManager).getName()));
        ServiceReference serviceReference5 = bundleContext.getServiceReference((class$de$vw$mib$sound$SoundWaveplayer == null ? (class$de$vw$mib$sound$SoundWaveplayer = Activator.class$("de.vw.mib.sound.SoundWaveplayer")) : class$de$vw$mib$sound$SoundWaveplayer).getName());
        if (serviceReference5 != null) {
            ServiceManager.soundWaveplayer = (SoundWaveplayer)bundleContext.getService(serviceReference5);
        } else {
            this.registerServiceListener(bundleContext, (class$de$vw$mib$sound$SoundWaveplayer == null ? (class$de$vw$mib$sound$SoundWaveplayer = Activator.class$("de.vw.mib.sound.SoundWaveplayer")) : class$de$vw$mib$sound$SoundWaveplayer).getName());
        }
        ServiceReference serviceReference6 = bundleContext.getServiceReference((class$de$vw$mib$speller$SpellerController == null ? (class$de$vw$mib$speller$SpellerController = Activator.class$("de.vw.mib.speller.SpellerController")) : class$de$vw$mib$speller$SpellerController).getName());
        if (serviceReference6 != null) {
            ServiceManager.spellerController = (SpellerController)bundleContext.getService(serviceReference6);
        } else {
            this.registerServiceListener(bundleContext, (class$de$vw$mib$speller$SpellerController == null ? (class$de$vw$mib$speller$SpellerController = Activator.class$("de.vw.mib.speller.SpellerController")) : class$de$vw$mib$speller$SpellerController).getName());
        }
        ServiceManager.timerManager = (TimerManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = Activator.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager).getName()));
        ServiceManager.eventDispatcher = (ViewEventDispatcher)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$ViewEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$ViewEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.ViewEventDispatcher")) : class$de$vw$mib$event$dispatcher$ViewEventDispatcher).getName()));
        ServiceManager.bundleContext = bundleContext;
        ViewCompositorImpl viewCompositorImpl = new ViewCompositorImpl();
        ServiceManager.viewCompositor = viewCompositorImpl;
        bundleContext.registerService((class$de$vw$mib$view$ViewCompositor == null ? (class$de$vw$mib$view$ViewCompositor = Activator.class$("de.vw.mib.view.ViewCompositor")) : class$de$vw$mib$view$ViewCompositor).getName(), (Object)viewCompositorImpl, null);
        WidgetManagerImpl widgetManagerImpl = new WidgetManagerImpl();
        bundleContext.registerService((class$de$vw$mib$widgets$WidgetManager == null ? (class$de$vw$mib$widgets$WidgetManager = Activator.class$("de.vw.mib.widgets.WidgetManager")) : class$de$vw$mib$widgets$WidgetManager).getName(), (Object)widgetManagerImpl, null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void registerServiceListener(BundleContext bundleContext, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(").append("objectClass").append("=").append(string).append(")");
        bundleContext.addServiceListener(this, stringBuilder.toString());
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        switch (serviceEvent.getType()) {
            case 1: {
                Object object = this.context.getService(serviceEvent.getServiceReference());
                if (object instanceof SoundWaveplayer) {
                    ServiceManager.soundWaveplayer = (SoundWaveplayer)object;
                    break;
                }
                if (object instanceof AsiaInput) {
                    ServiceManager.asiaInput = (AsiaInput)object;
                    break;
                }
                if (object instanceof SpellerController) {
                    ServiceManager.spellerController = (SpellerController)object;
                    break;
                }
                if (!(object instanceof ProximityInstaller)) break;
                ServiceManager.proximityInstaller = (ProximityInstaller)object;
                break;
            }
        }
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

