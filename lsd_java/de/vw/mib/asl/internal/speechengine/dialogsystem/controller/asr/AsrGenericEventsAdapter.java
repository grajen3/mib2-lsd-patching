/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr;

import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.GenericEventsAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrAdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrEvents;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class AsrGenericEventsAdapter
extends AbstractTarget
implements GenericEventsAdapter {
    private static final String TRACE_PREFIX;
    private static final int TRACE_CLASSIFIER;

    public AsrGenericEventsAdapter(Logger logger, GenericEvents genericEvents, String string, AsrAdapterHandlerRegistry asrAdapterHandlerRegistry) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 378607616;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        this.traceEventName(eventGeneric);
        switch (eventGeneric.getReceiverEventId()) {
            default: 
        }
    }

    private void traceEventName(EventGeneric eventGeneric) {
        if (this.getTextLogger().isTraceEnabled(512)) {
            StringBuffer stringBuffer = new StringBuffer("[AsrGenericEventsAdapter]: ");
            stringBuffer.append(" gotEvent( ");
            stringBuffer.append(AsrEvents.getEventName(eventGeneric));
            stringBuffer.append(" )");
            this.getTextLogger().trace(512, stringBuffer.toString());
        }
    }

    @Override
    public void registerEvents() {
        this.getTextLogger().trace(512, "[AsrGenericEventsAdapter]: registerEvents");
        AsrEvents.register(this);
    }

    @Override
    public void sendEvent(int n, int n2) {
        this.sendSafe(this.getEventFactory().newEvent(this.getDefaultTargetId(), n2, n));
    }

    @Override
    public int getAdapterTargetId() {
        return this.getTargetId();
    }
}

