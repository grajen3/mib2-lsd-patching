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
import de.vw.mib.view.ViewCompositor;
import org.osgi.framework.BundleContext;

public final class ServiceManager {
    public static AnimationManager animationManager;
    public static AsiaInput asiaInput;
    public static ConfigurationManager configurationManager;
    public static SkinInformationService skinInformationService;
    public static PerformanceIndicatorService performanceIndicatorService;
    public static DisplayManager displayManager;
    public static ViewEventDispatcher eventDispatcher;
    public static FixFormat fixFormat;
    public static FontManager fontManager;
    public static TextLayoutManager textLayoutManager;
    public static GraphicsManager gfxManager;
    public static ImageManager imageManager;
    public static LogManager logManager;
    public static LoggerFactory loggerFactory;
    public static ProximityInstaller proximityInstaller;
    public static RepaintManager repaintManager;
    public static SoundWaveplayer soundWaveplayer;
    public static SpellerController spellerController;
    public static TimerManager timerManager;
    public static ViewCompositor viewCompositor;
    public static BundleContext bundleContext;

    private ServiceManager() {
    }
}

