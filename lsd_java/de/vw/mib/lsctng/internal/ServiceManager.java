/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.configuration.ConfigurationManagerValueSetter;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.EventDispatcherManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.file.FileManager;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.i18n.I18nGuiUpdater;
import de.vw.mib.i18n.I18nTableDecoder;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.lsctng.AslLscBullhorn;
import de.vw.mib.skin.SkinAnimationUpdater;
import de.vw.mib.skin.SkinImagePoolUpdater;
import de.vw.mib.skin.ViewLanguageSkinChanger;
import de.vw.mib.threads.MIBThreadManager;

final class ServiceManager {
    private static final int CLASSIFIER;
    static ErrorHandler errorHandler;
    static AslLscBullhorn lscBullhorn;
    static LoggerFactory loggerFactory;
    static ConfigurationManagerValueSetter configValueSetter;
    static FileManager fileManager;
    static Framework4U fw4u;
    static FrameworkEventDispatcher eventDispatcher;
    static EventDispatcherManager eventDispatcherManager;
    static SkinImagePoolUpdater sipUpdater;
    static SkinAnimationUpdater saUpdater;
    static I18nGuiUpdater i18nGuiUpdater;
    static I18nTableDecoder i18nTableDecoder;
    static StartupEventDispatcher startupEventDispatcher;
    static MIBThreadManager threadManager;
    static ViewLanguageSkinChanger viewLanguageSkinChanger;

    private ServiceManager() {
    }

    public static Logger createLogger() {
        return loggerFactory.getLogger(1024);
    }

    public static void setLoggerFactory(LoggerFactory loggerFactory) {
        ServiceManager.loggerFactory = loggerFactory;
    }

    public static void setConfigValueSetter(ConfigurationManagerValueSetter configurationManagerValueSetter) {
        configValueSetter = configurationManagerValueSetter;
    }

    public static void setErrorHandler(ErrorHandler errorHandler) {
        ServiceManager.errorHandler = errorHandler;
    }

    public static void setFileManager(FileManager fileManager) {
        ServiceManager.fileManager = fileManager;
    }

    public static void setEventDispatcher(FrameworkEventDispatcher frameworkEventDispatcher) {
        eventDispatcher = frameworkEventDispatcher;
    }

    public static void setEventDispatcherManager(EventDispatcherManager eventDispatcherManager) {
        ServiceManager.eventDispatcherManager = eventDispatcherManager;
    }

    public static void setStartupEventDispatcher(StartupEventDispatcher startupEventDispatcher) {
        ServiceManager.startupEventDispatcher = startupEventDispatcher;
    }

    public static void setThreadManager(MIBThreadManager mIBThreadManager) {
        threadManager = mIBThreadManager;
    }

    public static void setLscBullhorn(AslLscBullhorn aslLscBullhorn) {
        lscBullhorn = aslLscBullhorn;
    }

    public static void setFw4u(Framework4U framework4U) {
        fw4u = framework4U;
    }

    public static void setSkinImagePoolUpdater(SkinImagePoolUpdater skinImagePoolUpdater) {
        sipUpdater = skinImagePoolUpdater;
    }

    public static void setSkinAnimationUpdater(SkinAnimationUpdater skinAnimationUpdater) {
        saUpdater = skinAnimationUpdater;
    }

    public static void setI18nGuiUpdater(I18nGuiUpdater i18nGuiUpdater) {
        ServiceManager.i18nGuiUpdater = i18nGuiUpdater;
    }

    public static void setI18nTableDecoder(I18nTableDecoder i18nTableDecoder) {
        ServiceManager.i18nTableDecoder = i18nTableDecoder;
    }

    public static void setViewLanguageSkinChanger(ViewLanguageSkinChanger viewLanguageSkinChanger) {
        ServiceManager.viewLanguageSkinChanger = viewLanguageSkinChanger;
    }
}

