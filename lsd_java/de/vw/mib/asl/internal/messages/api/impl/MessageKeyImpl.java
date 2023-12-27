/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.api.impl;

import de.vw.mib.asl.api.messages.services.detail.MessageKey;

public class MessageKeyImpl
implements MessageKey {
    private final int accountID;
    private final String messageID;

    public MessageKeyImpl(int n, String string) {
        this.accountID = n;
        this.messageID = string;
    }

    @Override
    public int getAccountID() {
        return this.accountID;
    }

    @Override
    public String getMessageID() {
        return this.messageID;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.accountID;
        n2 = 31 * n2 + (this.messageID == null ? 0 : this.messageID.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        MessageKeyImpl messageKeyImpl = (MessageKeyImpl)object;
        if (this.accountID != messageKeyImpl.accountID) {
            return false;
        }
        return !(this.messageID == null ? messageKeyImpl.messageID != null : !this.messageID.equals(messageKeyImpl.messageID));
    }

    public String toString() {
        return new StringBuffer().append("MessageKeyImpl [accountID=").append(this.accountID).append(", messageID=").append(this.messageID).append("]").toString();
    }
}

