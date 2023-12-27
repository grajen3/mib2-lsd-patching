/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.AnimationEvent;
import de.vw.mib.event.ContextChangeEvent;
import de.vw.mib.event.DatapoolUpdateEvent;
import de.vw.mib.event.DisplayEvent;
import de.vw.mib.event.DynamicStateEvent;
import de.vw.mib.event.Event;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.LSChangeEvent;
import de.vw.mib.event.ListReadoutEvent;
import de.vw.mib.event.PopupStackChangeEvent;
import de.vw.mib.event.PopupViewEvent;
import de.vw.mib.event.PowerStateEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.ReadoutListSelectionEvent;
import de.vw.mib.event.RepaintEvent;
import de.vw.mib.event.RestoreFactorySettingsEvent;
import de.vw.mib.event.SpeechEvent;
import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.SystemEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.ViewChangeEvent;
import de.vw.mib.event.consumer.ASLStartupManagerEventConsumer;
import de.vw.mib.event.consumer.AnimationEventConsumer;
import de.vw.mib.event.consumer.AppStartupManagerEventConsumer;
import de.vw.mib.event.consumer.BAPSystemEventConsumer;
import de.vw.mib.event.consumer.DatapoolEventConsumer;
import de.vw.mib.event.consumer.GestureEventConsumer;
import de.vw.mib.event.consumer.LSChangeEventConsumer;
import de.vw.mib.event.consumer.PopupStackChangeEventConsumer;
import de.vw.mib.event.consumer.PopupStackManagerEventConsumer;
import de.vw.mib.event.consumer.PowerStateEventConsumer;
import de.vw.mib.event.consumer.RepaintEventConsumer;
import de.vw.mib.event.consumer.RestoreFactorySettingsEventConsumer;
import de.vw.mib.event.consumer.StartupManagerEventConsumer;
import de.vw.mib.event.consumer.StatemachineManagerEventConsumer;
import de.vw.mib.event.consumer.ViewManagerEventConsumer;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

final class NullConsumer
implements AnimationEventConsumer,
AppStartupManagerEventConsumer,
ASLStartupManagerEventConsumer,
DatapoolEventConsumer,
LSChangeEventConsumer,
PopupStackChangeEventConsumer,
PopupStackManagerEventConsumer,
PowerStateEventConsumer,
RepaintEventConsumer,
RestoreFactorySettingsEventConsumer,
StartupManagerEventConsumer,
StatemachineManagerEventConsumer,
ViewManagerEventConsumer,
BAPSystemEventConsumer,
GestureEventConsumer {
    static final int SPEECH_STATE_NOT_SET;
    private Logger logger;
    private final String logMessage;
    int lastSpeechState = -1;

    NullConsumer(String string) {
        this.logMessage = new StringBuffer().append("No ").append(string).append(" service registered yet! The following event can't be dispatched: ").toString();
    }

    @Override
    public void consumeEvent(AnimationEvent animationEvent) {
        this.warn(animationEvent);
    }

    @Override
    public void consumeEvent(ContextChangeEvent contextChangeEvent) {
        this.warn(contextChangeEvent);
    }

    @Override
    public void consumeEvent(DatapoolUpdateEvent datapoolUpdateEvent) {
        this.warn(datapoolUpdateEvent);
    }

    @Override
    public void consumeEvent(DisplayEvent displayEvent) {
        this.warn(displayEvent);
    }

    @Override
    public void consumeEvent(DynamicStateEvent dynamicStateEvent) {
        this.warn(dynamicStateEvent);
    }

    @Override
    public boolean consumeEvent(HMIEvent hMIEvent) {
        return false;
    }

    @Override
    public void consumeEvent(LSChangeEvent lSChangeEvent) {
        this.warn(lSChangeEvent);
    }

    @Override
    public void consumeEvent(PopupStackChangeEvent popupStackChangeEvent) {
        this.warn(popupStackChangeEvent);
    }

    @Override
    public void consumeEvent(PopupViewEvent popupViewEvent) {
        this.warn(popupViewEvent);
    }

    @Override
    public void consumeEvent(PowerStateEvent powerStateEvent) {
        this.warn(powerStateEvent);
    }

    @Override
    public void consumeEvent(RepaintEvent repaintEvent) {
        this.warn(repaintEvent);
    }

    @Override
    public void consumeEvent(RestoreFactorySettingsEvent restoreFactorySettingsEvent) {
        this.warn(restoreFactorySettingsEvent);
    }

    @Override
    public void consumeEvent(StartupEvent startupEvent) {
        this.warn(startupEvent);
    }

    @Override
    public boolean consumeEvent(SystemEvent systemEvent) {
        return false;
    }

    @Override
    public void consumeEvent(TouchEvent touchEvent) {
        this.warn(touchEvent);
    }

    @Override
    public void consumeEvent(ViewChangeEvent viewChangeEvent) {
        this.warn(viewChangeEvent);
    }

    @Override
    public void consumeEvent(ProximityEvent proximityEvent) {
        this.warn(proximityEvent);
    }

    @Override
    public void cycleBreakOut() {
    }

    @Override
    public void cycleDetected(Event event) {
    }

    private void warn(Event event) {
        if (this.logger == null) {
            if (ServiceManager.loggerFactory != null) {
                this.logger = ServiceManager.loggerFactory.getLogger(64);
                if (this.logger.isTraceEnabled(1)) {
                    LogMessage logMessage = this.logger.trace(1);
                    logMessage.append(this.logMessage).append(event).log();
                }
            }
            return;
        }
        if (this.logger.isTraceEnabled(1)) {
            LogMessage logMessage = this.logger.trace(1);
            logMessage.append(this.logMessage).append(event).log();
        }
    }

    public void consumeEvent(ListReadoutEvent listReadoutEvent) {
    }

    public void consumeEvent(ReadoutListSelectionEvent readoutListSelectionEvent) {
    }

    public void consumeEvent(SpeechEvent speechEvent) {
    }
}

