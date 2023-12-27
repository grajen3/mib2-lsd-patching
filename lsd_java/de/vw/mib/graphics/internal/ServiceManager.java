/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

public final class ServiceManager {
    public static ConfigurationManager configurationManager;
    public static FileManager fileManager;
    public static LoggerFactory loggerFactory;
    public static TimerManager timerManager;

    private ServiceManager() {
    }
}

