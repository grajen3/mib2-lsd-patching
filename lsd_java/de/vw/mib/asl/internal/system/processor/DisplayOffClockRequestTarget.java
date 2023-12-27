/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.processor.DisplayOffClockContentProcessor;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.Logger;

public class DisplayOffClockRequestTarget
implements Target {
    private final Logger logger;
    private final GenericEvents genericEvents;
    private final DisplayOffClockContentProcessor contentProcessor;

    public DisplayOffClockRequestTarget(SystemServices systemServices, DisplayOffClockContentProcessor displayOffClockContentProcessor) {
        Preconditions.checkArgumentNotNull(systemServices, "The given system services must not be null.");
        Preconditions.checkArgumentNotNull(displayOffClockContentProcessor, "The given content processor must not be null.");
        this.genericEvents = systemServices.getGenericEvents();
        this.contentProcessor = displayOffClockContentProcessor;
        this.logger = systemServices.getAsl1Logger();
    }

    @Override
    public GenericEvents getMainObject() {
        return this.genericEvents;
    }

    @Override
    public int getTargetId() {
        return -89516800;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.logger.trace(2048, "DisplayOffClockRequestTarget gotEvent some event");
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 4300092: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(1781669888, false);
                this.processRequestContent("HMI_USER_PERCEIVED_CLOCK");
                break;
            }
            case 4300093: {
                this.processRequestContent("NO_CONTENT");
                break;
            }
        }
    }

    @Override
    public void setTargetId(int n) {
    }

    private void processPowerOn() {
        if (this.isTraceEnabled()) {
            this.logger.trace(2048, "DisplayOffClockRequestTarget processPowerOn");
        }
        this.genericEvents.getServiceRegister().addObserver(1016938752, this.getTargetId());
        this.genericEvents.getServiceRegister().addObserver(1033715968, this.getTargetId());
    }

    private void processRequestContent(String string) {
        this.contentProcessor.requestContent(string);
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(2048);
    }
}

