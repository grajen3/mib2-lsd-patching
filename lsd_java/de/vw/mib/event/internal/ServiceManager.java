/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.coreapi.asl.SystemEventSender;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.SystemEventIdMap;
import de.vw.mib.event.consumer.ASLStartupManagerEventConsumer;
import de.vw.mib.event.consumer.AnimationEventConsumer;
import de.vw.mib.event.consumer.AppStartupManagerEventConsumer;
import de.vw.mib.event.consumer.BAPSystemEventConsumer;
import de.vw.mib.event.consumer.DatapoolEventConsumer;
import de.vw.mib.event.consumer.GestureEventConsumer;
import de.vw.mib.event.consumer.InfotainmentRecoderEventConsumer;
import de.vw.mib.event.consumer.LSChangeEventConsumer;
import de.vw.mib.event.consumer.PopupStackChangeEventConsumer;
import de.vw.mib.event.consumer.PopupStackManagerEventConsumer;
import de.vw.mib.event.consumer.PowerStateEventConsumer;
import de.vw.mib.event.consumer.ReadOutManagerEventConsumer;
import de.vw.mib.event.consumer.RepaintEventConsumer;
import de.vw.mib.event.consumer.RestoreFactorySettingsEventConsumer;
import de.vw.mib.event.consumer.SpeechStateEventConsumer;
import de.vw.mib.event.consumer.StartupManagerEventConsumer;
import de.vw.mib.event.consumer.StatemachineManagerEventConsumer;
import de.vw.mib.event.consumer.ViewManagerEventConsumer;
import de.vw.mib.event.internal.NullConsumer;
import de.vw.mib.event.internal.ServiceManager$1;
import de.vw.mib.event.internal.diag.EventTracer;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.TimerManager;

public final class ServiceManager {
    public static ErrorHandler errorHandler;
    public static LoggerFactory loggerFactory;
    public static StatemachineManagerEventConsumer statemachineManager;
    public static SystemEventIdMap systemEventIdMap;
    public static SystemEventSender systemEventSender;
    public static MIBThreadManager threadManager;
    public static TimerManager timerManager;
    static AnimationEventConsumer animationManager;
    static AppStartupManagerEventConsumer appStartupManager;
    static ASLStartupManagerEventConsumer aslStartupManager;
    static BAPSystemEventConsumer bapSystemEventConsumer;
    static GestureEventConsumer gestureEventConsumer;
    static DatapoolEventConsumer datapool;
    static EventTracer eventTracer;
    static InfotainmentRecoderEventConsumer infotainmentRecoder;
    static LSChangeEventConsumer lsChanger;
    static PopupStackChangeEventConsumer popupStackChangeEventConsumer;
    static PopupStackManagerEventConsumer popupStackManager;
    static PowerStateEventConsumer powerStateEventConsumer;
    static ReadOutManagerEventConsumer readoutManager;
    static RepaintEventConsumer repaintManager;
    static RestoreFactorySettingsEventConsumer restoreFactorySettingsEventConsumer;
    static SpeechStateEventConsumer speechStateEventConsumer;
    static StartupManagerEventConsumer startupManager;
    static ViewManagerEventConsumer viewManager;

    private ServiceManager() {
    }

    static {
        statemachineManager = new NullConsumer("StatemachineManager");
        systemEventIdMap = new ServiceManager$1();
        animationManager = new NullConsumer("AnimationManager");
        appStartupManager = new NullConsumer("AppStartupManager");
        aslStartupManager = new NullConsumer("ASLStartupManager");
        bapSystemEventConsumer = new NullConsumer("BAPSystemEventConsumer");
        gestureEventConsumer = new NullConsumer("GestureEventConsumer");
        datapool = new NullConsumer("Datapool");
        eventTracer = EventTracer.EMPTY_EVENT_TRACER;
        infotainmentRecoder = null;
        lsChanger = new NullConsumer("LSChanger");
        popupStackChangeEventConsumer = new NullConsumer("PopupStackChangeEventConsumer");
        popupStackManager = new NullConsumer("PopupStackManager");
        powerStateEventConsumer = new NullConsumer("PowerStateEventConsumer");
        readoutManager = null;
        repaintManager = new NullConsumer("RepaintManager");
        restoreFactorySettingsEventConsumer = new NullConsumer("RestoreFactorySettingsEventCosumer");
        speechStateEventConsumer = null;
        startupManager = new NullConsumer("StartupManager");
        viewManager = new NullConsumer("ViewManager");
    }
}

