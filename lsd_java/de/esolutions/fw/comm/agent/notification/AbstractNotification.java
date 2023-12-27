/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.INotification;
import de.esolutions.fw.comm.agent.notification.INotificationCallback;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;

public class AbstractNotification
implements INotification {
    private INotificationCallback callback;

    public void setCallback(INotificationCallback iNotificationCallback) {
        this.callback = iNotificationCallback;
    }

    @Override
    public void performNotification() {
        this.triggerCallback();
    }

    public INotificationCallback getCallback() {
        return this.callback;
    }

    @Override
    public void triggerCallback() {
        if (this.callback != null) {
            CommAgentTracing.NOTIFICATION.log((short)1, " + Trigger Callback %1", this.callback);
            this.callback.doneNotification(this);
            CommAgentTracing.NOTIFICATION.log((short)1, " - Trigger Callback %1", this.callback);
        }
    }
}

