/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.GenericEventsAdapter;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class TtsGenericEventsAdapter
extends AbstractTarget
implements GenericEventsAdapter {
    private static final String TRACE_PREFIX;

    public TtsGenericEventsAdapter(Logger logger, GenericEvents genericEvents, String string, int n) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        this.getTextLogger().trace(1024, new StringBuffer().append("[SpeechTtsTarget]: gotEvent ID=").append(n).toString());
        switch (n) {
            default: 
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 0;
    }

    @Override
    public void sendEvent(int n, int n2) {
        EventGeneric eventGeneric = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getEventFactory().newEvent(this.getDefaultTargetId(), n2, n);
        super.sendSafe(eventGeneric);
    }

    @Override
    public void registerEvents() {
    }

    @Override
    public int getAdapterTargetId() {
        return this.getTargetId();
    }
}

