/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.messages.services.detail;

import de.vw.mib.asl.api.messages.services.detail.MessageKey;

public interface Message
extends MessageKey {
    public static final int MESSAGETYPE_SMS;
    public static final int MESSAGETYPE_EMAIL;
    public static final int MESSAGETYPE_BINARY;
    public static final int MESSAGETYPE_UNKNOWN;
    public static final int MESSAGETYPE_MMS;

    default public String getBody() {
    }

    default public long getUnixTime() {
    }

    default public String getContactName() {
    }

    default public String getPhoneNumber() {
    }

    default public long getAdbEntryId() {
    }

    default public int getMessageType() {
    }

    default public boolean isVcard() {
    }

    default public String getVCardContactName() {
    }

    default public boolean hasAttachments() {
    }
}

