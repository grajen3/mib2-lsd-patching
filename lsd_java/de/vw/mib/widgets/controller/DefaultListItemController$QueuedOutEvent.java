/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

final class DefaultListItemController$QueuedOutEvent {
    public final String eventName;
    public final int actionIndex;
    public final int absoluteIndex;
    public final int destinationIndex;
    public final int dropDownIndex;
    public final String eventSender;
    public final long objectID;

    public DefaultListItemController$QueuedOutEvent(String string, int n, int n2, int n3, int n4, String string2, long l) {
        this.eventName = string;
        this.absoluteIndex = n;
        this.actionIndex = n2;
        this.destinationIndex = n3;
        this.dropDownIndex = n4;
        this.eventSender = string2;
        this.objectID = l;
    }
}

