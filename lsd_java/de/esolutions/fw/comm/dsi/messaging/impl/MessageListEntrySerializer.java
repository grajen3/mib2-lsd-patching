/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.dsi.messaging.impl.MatchedAddressSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageListEntry;

public class MessageListEntrySerializer {
    public static void putOptionalMessageListEntry(ISerializer iSerializer, MessageListEntry messageListEntry) {
        boolean bl = messageListEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            MatchedAddress matchedAddress = messageListEntry.getMatchedAddress();
            MatchedAddressSerializer.putOptionalMatchedAddress(iSerializer, matchedAddress);
            String string = messageListEntry.getMessageID();
            iSerializer.putOptionalString(string);
            int n = messageListEntry.getMessagingAccountID();
            iSerializer.putInt32(n);
            String string2 = messageListEntry.getSender();
            iSerializer.putOptionalString(string2);
            String[] stringArray = messageListEntry.getRecipients();
            iSerializer.putOptionalStringVarArray(stringArray);
            long l = messageListEntry.getDateTime();
            iSerializer.putInt64(l);
            int n2 = messageListEntry.getMessageStatus();
            iSerializer.putInt32(n2);
            String string3 = messageListEntry.getSubject();
            iSerializer.putOptionalString(string3);
            int n3 = messageListEntry.getAttachmentSize();
            iSerializer.putInt32(n3);
            int n4 = messageListEntry.getPriority();
            iSerializer.putInt32(n4);
            int n5 = messageListEntry.getType();
            iSerializer.putInt32(n5);
            int n6 = messageListEntry.getStorageLocation();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalMessageListEntryVarArray(ISerializer iSerializer, MessageListEntry[] messageListEntryArray) {
        boolean bl = messageListEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(messageListEntryArray.length);
            for (int i2 = 0; i2 < messageListEntryArray.length; ++i2) {
                MessageListEntrySerializer.putOptionalMessageListEntry(iSerializer, messageListEntryArray[i2]);
            }
        }
    }

    public static MessageListEntry getOptionalMessageListEntry(IDeserializer iDeserializer) {
        MessageListEntry messageListEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            String string;
            int n5;
            long l;
            String string2;
            int n6;
            String string3;
            MatchedAddress matchedAddress;
            messageListEntry = new MessageListEntry();
            messageListEntry.matchedAddress = matchedAddress = MatchedAddressSerializer.getOptionalMatchedAddress(iDeserializer);
            messageListEntry.messageID = string3 = iDeserializer.getOptionalString();
            messageListEntry.messagingAccountID = n6 = iDeserializer.getInt32();
            messageListEntry.sender = string2 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            messageListEntry.recipients = stringArray;
            messageListEntry.dateTime = l = iDeserializer.getInt64();
            messageListEntry.messageStatus = n5 = iDeserializer.getInt32();
            messageListEntry.subject = string = iDeserializer.getOptionalString();
            messageListEntry.attachmentSize = n4 = iDeserializer.getInt32();
            messageListEntry.priority = n3 = iDeserializer.getInt32();
            messageListEntry.type = n2 = iDeserializer.getInt32();
            messageListEntry.storageLocation = n = iDeserializer.getInt32();
        }
        return messageListEntry;
    }

    public static MessageListEntry[] getOptionalMessageListEntryVarArray(IDeserializer iDeserializer) {
        MessageListEntry[] messageListEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            messageListEntryArray = new MessageListEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                messageListEntryArray[i2] = MessageListEntrySerializer.getOptionalMessageListEntry(iDeserializer);
            }
        }
        return messageListEntryArray;
    }
}

