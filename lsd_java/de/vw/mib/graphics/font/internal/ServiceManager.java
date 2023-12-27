/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.graphics.font.TextLayoutManager;
import de.vw.mib.graphics.font.internal.FontPropertiesLoader;
import de.vw.mib.graphics.font.spi.FontSPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

final class ServiceManager {
    static ConfigurationManager configurationManager;
    static LoggerFactory loggerFactory;
    static FontSPI fontSPI;
    static TimerManager timerManager;
    static FontPropertiesLoader fontPropertiesLoader;
    static TextLayoutManager textLayoutManager;

    private ServiceManager() {
    }
}

