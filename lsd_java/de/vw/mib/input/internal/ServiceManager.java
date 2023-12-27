/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.GestureEventDispatcher;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

public class ServiceManager {
    public static LoggerFactory loggerFactory;
    public static GestureEventDispatcher gestureEventDispatcher;
    public static ViewEventDispatcher viewEventDispatcher;
    public static ConfigurationManager configurationManager;
    public static TimerManager timerManager;
}

