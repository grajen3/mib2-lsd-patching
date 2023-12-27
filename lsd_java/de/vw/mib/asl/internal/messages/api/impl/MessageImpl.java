/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.api.impl;

import de.vw.mib.asl.api.messages.services.detail.Message;
import de.vw.mib.asl.internal.messages.api.impl.MessageKeyImpl;

public class MessageImpl
extends MessageKeyImpl
implements Message {
    private final String body;
    private final long dateTime;
    private final String contactName;
    private final String phoneNumber;
    private final long adbEntryId;
    private final int messageType;
    private final String vCardContactName;
    private final boolean attachments;
    private final boolean isVcard;

    public MessageImpl(int n, String string, String string2, long l, String string3, String string4, long l2, int n2, String string5, boolean bl, boolean bl2) {
        super(n, string);
        this.body = string2;
        this.dateTime = l;
        this.contactName = string3;
        this.phoneNumber = string4;
        this.adbEntryId = l2;
        this.messageType = n2;
        this.vCardContactName = string5;
        this.attachments = bl;
        this.isVcard = bl2;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public long getUnixTime() {
        return this.dateTime;
    }

    @Override
    public String getContactName() {
        return this.contactName;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public long getAdbEntryId() {
        return this.adbEntryId;
    }

    @Override
    public int getMessageType() {
        return this.messageType;
    }

    @Override
    public String getVCardContactName() {
        return this.vCardContactName;
    }

    @Override
    public boolean hasAttachments() {
        return this.attachments;
    }

    @Override
    public boolean isVcard() {
        return this.isVcard;
    }
}

