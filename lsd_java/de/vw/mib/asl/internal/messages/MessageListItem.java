/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import org.dsi.ifc.messaging.ListEntry;

public class MessageListItem {
    public ListEntry listEntry;
    public int listType;

    public MessageListItem(ListEntry listEntry, int n) {
        this.listEntry = listEntry;
        this.listType = n;
    }
}

