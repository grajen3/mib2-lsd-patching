/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.internal;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.DynamicListItemControlManager;
import de.vw.mib.datapool.GlobalExpressionEvaluator;
import de.vw.mib.datapool.I18nDatapool;
import de.vw.mib.datapool.ModelDatapool;
import de.vw.mib.datapool.ScaledI18nDatapool;
import de.vw.mib.event.dispatcher.DatapoolEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.file.FileManager;
import de.vw.mib.format.FixFormat;
import de.vw.mib.i18n.I18nTableDecoder;
import de.vw.mib.list.DynamicListManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinAnimationPool;
import de.vw.mib.skin.SkinImagePool;
import de.vw.mib.startup.StartupManagerService;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.TimerManager;

public final class ServiceManagerCommon {
    public static LoggerFactory loggerFactory;
    public static StartupManagerService startupManagerService;
    public static StatemachineEventDispatcher statemachineEventDispatcher;
    public static ConfigurationManager configurationManager;
    public static FileManager fileManager;
    public static FixFormat fixFormat;
    public static DatapoolEventDispatcher datapoolEventDispatcher;
    public static TimerManager timerManager;
    public static DynamicListManager dynamicListManager;
    public static I18nTableDecoder i18nTableDecoder;
    public static I18nDatapool i18nDatapool;
    public static ScaledI18nDatapool scaledI18nDatapool;
    public static ModelDatapool modelDatapool;
    public static DynamicListItemControlManager dynamicListItemControlManager;
    public static SkinAnimationPool skinAnimationPool;
    public static SkinImagePool skinImagePool;
    public static GlobalExpressionEvaluator globalExpressionEvaluator;
    public static MIBInvoker hmiThreadInvoker;
    public static PerfService perfService;
    public static int hmiChecksum;

    private ServiceManagerCommon() {
    }

    static {
        hmiChecksum = -1;
    }
}

