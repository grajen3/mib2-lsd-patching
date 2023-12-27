/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.file.FileManager;
import de.vw.mib.graphics.image.spi.ImageSPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.TimerManager;

final class ServiceManager {
    static ConfigurationManager configurationManager;
    static LoggerFactory loggerFactory;
    static FileManager fileManager;
    static ImageSPI imageSPI;
    static MIBThreadManager threadManager;
    static TimerManager timerManager;

    private ServiceManager() {
    }
}

