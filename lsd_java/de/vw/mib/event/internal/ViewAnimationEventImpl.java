/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ViewAnimationEvent;
import de.vw.mib.event.consumer.ViewAnimationEventConsumer;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class ViewAnimationEventImpl
extends AbstractPooledEvent
implements ViewAnimationEvent {
    private int animationType;
    private ViewAnimationEventConsumer consumer;

    ViewAnimationEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        this.consumer.consumeEvent(this);
    }

    @Override
    public int getAnimationType() {
        return this.animationType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ViewAnimationEvent - animation type: ");
        switch (this.animationType) {
            case 1: {
                stringBuffer.append("ANIMATION_STARTED");
                break;
            }
            case 2: {
                stringBuffer.append("ANIMATION_RUNNING");
                break;
            }
            case 4: {
                stringBuffer.append("ANIMATION_STOPPED");
                break;
            }
        }
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ViewAnimationEvent - animation type: ");
        switch (this.animationType) {
            case 1: {
                logMessage.append("ANIMATION_STARTED");
                break;
            }
            case 2: {
                logMessage.append("ANIMATION_RUNNING");
                break;
            }
            case 4: {
                logMessage.append("ANIMATION_STOPPED");
                break;
            }
        }
    }

    void setContent(ViewAnimationEventConsumer viewAnimationEventConsumer, int n) {
        this.animationType = n;
        this.consumer = viewAnimationEventConsumer;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

