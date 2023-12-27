/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.INotification;

public interface INotificationCallback {
    default public void doneNotification(INotification iNotification) {
    }
}

