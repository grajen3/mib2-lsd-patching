/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.messaging.MatchedAddress;

public class MessageListEntry {
    public MatchedAddress matchedAddress;
    public String messageID;
    public int messagingAccountID;
    public String sender;
    public String[] recipients;
    public long dateTime;
    public int messageStatus;
    public String subject;
    public int attachmentSize;
    public int priority;
    public int type;
    public int storageLocation;

    public MessageListEntry() {
        this.messageID = "";
        this.messageStatus = -1;
        this.subject = "";
        this.messagingAccountID = -1;
        this.attachmentSize = -1;
        this.priority = 0;
        this.type = -1;
        this.storageLocation = -1;
    }

    public MessageListEntry(MatchedAddress matchedAddress, String string, int n, String string2, String[] stringArray, long l, int n2, String string3, int n3, int n4, int n5, int n6) {
        this.matchedAddress = matchedAddress;
        this.messageID = string;
        this.messagingAccountID = n;
        this.sender = string2;
        this.recipients = stringArray;
        this.dateTime = l;
        this.messageStatus = n2;
        this.subject = string3;
        this.attachmentSize = n3;
        this.priority = n4;
        this.type = n5;
        this.storageLocation = n6;
    }

    public MatchedAddress getMatchedAddress() {
        return this.matchedAddress;
    }

    public String getMessageID() {
        return this.messageID;
    }

    public int getMessagingAccountID() {
        return this.messagingAccountID;
    }

    public String getSender() {
        return this.sender;
    }

    public String[] getRecipients() {
        return this.recipients;
    }

    public long getDateTime() {
        return this.dateTime;
    }

    public int getMessageStatus() {
        return this.messageStatus;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getAttachmentSize() {
        return this.attachmentSize;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getType() {
        return this.type;
    }

    public int getStorageLocation() {
        return this.storageLocation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1750);
        stringBuffer.append("MessageListEntry");
        stringBuffer.append('(');
        stringBuffer.append("matchedAddress");
        stringBuffer.append('=');
        stringBuffer.append(this.matchedAddress);
        stringBuffer.append(',');
        stringBuffer.append("messageID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.messageID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("messagingAccountID");
        stringBuffer.append('=');
        stringBuffer.append(this.messagingAccountID);
        stringBuffer.append(',');
        stringBuffer.append("sender");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.sender);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("recipients");
        stringBuffer.append('[');
        if (this.recipients != null) {
            stringBuffer.append(this.recipients.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.recipients != null) {
            int n = this.recipients.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.recipients[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.recipients);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("dateTime");
        stringBuffer.append('=');
        stringBuffer.append(this.dateTime);
        stringBuffer.append(',');
        stringBuffer.append("messageStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.messageStatus);
        stringBuffer.append(',');
        stringBuffer.append("subject");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.subject);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("attachmentSize");
        stringBuffer.append('=');
        stringBuffer.append(this.attachmentSize);
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("storageLocation");
        stringBuffer.append('=');
        stringBuffer.append(this.storageLocation);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

