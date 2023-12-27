/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.internal;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.speller.SpellerController;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public final class ServiceManager {
    public static AsiaInput asiaInput;
    public static ConfigurationManager configurationManager;
    public static LogManager logManager;
    public static LoggerFactory loggerFactory;
    public static SpellerController spellerController;
    public static TimerManager timerManager;
    public static BundleContext bundleContext;

    private ServiceManager() {
    }
}

