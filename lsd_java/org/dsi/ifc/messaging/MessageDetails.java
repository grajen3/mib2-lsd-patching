/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.MatchedAddress;

public class MessageDetails {
    public int messagingAccountID;
    public String messageID;
    public int type;
    public MatchedAddress sender;
    public MatchedAddress[] recipientsTo;
    public MatchedAddress[] recipientsCc;
    public MatchedAddress[] recipientsBcc;
    public String subject;
    public long dateTime;
    public int messageStatus;
    public String replyTo;
    public String body;
    public AttachmentInformation[] attachments;
    public int priority;
    public int[] segmentLengths;
    public int storageLocation;
    public ExtractedItem[] extractedItems;

    public MessageDetails() {
        this.messagingAccountID = -1;
        this.messageID = "";
        this.type = -1;
        this.subject = "";
        this.dateTime = 0L;
        this.messageStatus = -1;
        this.replyTo = "";
        this.body = "";
        this.priority = 0;
        this.storageLocation = -1;
        this.extractedItems = null;
    }

    public MessageDetails(int n, String string, int n2, MatchedAddress matchedAddress, MatchedAddress[] matchedAddressArray, MatchedAddress[] matchedAddressArray2, MatchedAddress[] matchedAddressArray3, String string2, long l, int n3, String string3, String string4, AttachmentInformation[] attachmentInformationArray, int n4, int[] nArray, int n5) {
        this.messagingAccountID = n;
        this.messageID = string;
        this.type = n2;
        this.sender = matchedAddress;
        this.recipientsTo = matchedAddressArray;
        this.recipientsCc = matchedAddressArray2;
        this.recipientsBcc = matchedAddressArray3;
        this.subject = string2;
        this.dateTime = l;
        this.messageStatus = n3;
        this.replyTo = string3;
        this.body = string4;
        this.attachments = attachmentInformationArray;
        this.priority = n4;
        this.segmentLengths = nArray;
        this.storageLocation = n5;
        this.extractedItems = null;
    }

    public MessageDetails(int n, String string, int n2, MatchedAddress matchedAddress, MatchedAddress[] matchedAddressArray, MatchedAddress[] matchedAddressArray2, MatchedAddress[] matchedAddressArray3, String string2, long l, int n3, String string3, String string4, AttachmentInformation[] attachmentInformationArray, int n4, int[] nArray, int n5, ExtractedItem[] extractedItemArray) {
        this.messagingAccountID = n;
        this.messageID = string;
        this.type = n2;
        this.sender = matchedAddress;
        this.recipientsTo = matchedAddressArray;
        this.recipientsCc = matchedAddressArray2;
        this.recipientsBcc = matchedAddressArray3;
        this.subject = string2;
        this.dateTime = l;
        this.messageStatus = n3;
        this.replyTo = string3;
        this.body = string4;
        this.attachments = attachmentInformationArray;
        this.priority = n4;
        this.segmentLengths = nArray;
        this.storageLocation = n5;
        this.extractedItems = extractedItemArray;
    }

    public int getMessagingAccountID() {
        return this.messagingAccountID;
    }

    public String getMessageID() {
        return this.messageID;
    }

    public int getType() {
        return this.type;
    }

    public MatchedAddress getSender() {
        return this.sender;
    }

    public MatchedAddress[] getRecipientsTo() {
        return this.recipientsTo;
    }

    public MatchedAddress[] getRecipientsCc() {
        return this.recipientsCc;
    }

    public MatchedAddress[] getRecipientsBcc() {
        return this.recipientsBcc;
    }

    public String getSubject() {
        return this.subject;
    }

    public long getDateTime() {
        return this.dateTime;
    }

    public int getMessageStatus() {
        return this.messageStatus;
    }

    public String getReplyTo() {
        return this.replyTo;
    }

    public String getBody() {
        return this.body;
    }

    public AttachmentInformation[] getAttachments() {
        return this.attachments;
    }

    public int getPriority() {
        return this.priority;
    }

    public int[] getSegmentLengths() {
        return this.segmentLengths;
    }

    public int getStorageLocation() {
        return this.storageLocation;
    }

    public ExtractedItem[] getExtractedItems() {
        return this.extractedItems;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(2000);
        stringBuffer.append("MessageDetails");
        stringBuffer.append('(');
        stringBuffer.append("messagingAccountID");
        stringBuffer.append('=');
        stringBuffer.append(this.messagingAccountID);
        stringBuffer.append(',');
        stringBuffer.append("messageID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.messageID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("sender");
        stringBuffer.append('=');
        stringBuffer.append(this.sender);
        stringBuffer.append(',');
        stringBuffer.append("recipientsTo");
        stringBuffer.append('[');
        if (this.recipientsTo != null) {
            stringBuffer.append(this.recipientsTo.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.recipientsTo != null) {
            n3 = this.recipientsTo.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.recipientsTo[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.recipientsTo);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("recipientsCc");
        stringBuffer.append('[');
        if (this.recipientsCc != null) {
            stringBuffer.append(this.recipientsCc.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.recipientsCc != null) {
            n3 = this.recipientsCc.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.recipientsCc[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.recipientsCc);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("recipientsBcc");
        stringBuffer.append('[');
        if (this.recipientsBcc != null) {
            stringBuffer.append(this.recipientsBcc.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.recipientsBcc != null) {
            n3 = this.recipientsBcc.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.recipientsBcc[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.recipientsBcc);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("subject");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.subject);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("dateTime");
        stringBuffer.append('=');
        stringBuffer.append(this.dateTime);
        stringBuffer.append(',');
        stringBuffer.append("messageStatus");
        stringBuffer.append('=');
        stringBuffer.append(this.messageStatus);
        stringBuffer.append(',');
        stringBuffer.append("replyTo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.replyTo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("body");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.body);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("attachments");
        stringBuffer.append('[');
        if (this.attachments != null) {
            stringBuffer.append(this.attachments.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.attachments != null) {
            n3 = this.attachments.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.attachments[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.attachments);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("priority");
        stringBuffer.append('=');
        stringBuffer.append(this.priority);
        stringBuffer.append(',');
        stringBuffer.append("segmentLengths");
        stringBuffer.append('[');
        if (this.segmentLengths != null) {
            stringBuffer.append(this.segmentLengths.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.segmentLengths != null) {
            n3 = this.segmentLengths.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.segmentLengths[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.segmentLengths);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("storageLocation");
        stringBuffer.append('=');
        stringBuffer.append(this.storageLocation);
        stringBuffer.append(',');
        stringBuffer.append("extractedItems");
        stringBuffer.append('[');
        if (this.extractedItems != null) {
            stringBuffer.append(this.extractedItems.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.extractedItems != null) {
            n3 = this.extractedItems.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.extractedItems[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.extractedItems);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

