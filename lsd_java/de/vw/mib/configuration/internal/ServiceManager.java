/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.dynamicresourcedata.DynamicResourceDataFactory;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.file.FileManager;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.lsctng.LscController;

public final class ServiceManager {
    public static DynamicResourceDataFactory dynamicResourceDataFactory;
    public static FileManager fileManager;
    public static LoggerFactory loggerFactory;
    public static LogManager logManager;
    public static LscController lscController;
    public static FrameworkEventDispatcher eventDispatcher;

    private ServiceManager() {
    }
}

