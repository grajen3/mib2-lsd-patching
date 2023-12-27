/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.AnimationEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

final class AnimationEventImpl
extends AbstractPooledEvent
implements AnimationEvent {
    private int animationId;

    AnimationEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getAnimationId() {
        return this.animationId;
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.animationManager.consumeEvent(this);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("AnimationEvent - animationId: ").append(this.animationId);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("AnimationEvent - animationId: ").append(this.animationId);
    }

    void setContent(int n) {
        this.animationId = n;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

