/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.INotification;
import de.esolutions.fw.comm.agent.notification.NotificationCenter;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.commons.timeout.ITimeOutHandler;

public class NotificationCenter$NotifyTimeOutHandler
implements ITimeOutHandler {
    private INotification notification;
    private final /* synthetic */ NotificationCenter this$0;

    public NotificationCenter$NotifyTimeOutHandler(NotificationCenter notificationCenter, INotification iNotification) {
        this.this$0 = notificationCenter;
        this.notification = iNotification;
    }

    @Override
    public void timeoutOccurred(Thread thread) {
        CommAgentTracing.NOTIFICATION.log((short)4, "notification timeout detected:\n  notification=%1\n  thread=%2 timeout=%3 ms", this.notification, (Object)thread, (Object)new Integer(this.this$0.notifyTimeout));
    }
}

