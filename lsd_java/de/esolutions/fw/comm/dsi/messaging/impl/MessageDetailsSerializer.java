/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.dsi.messaging.impl.AttachmentInformationSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.ExtractedItemSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.MatchedAddressSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;

public class MessageDetailsSerializer {
    public static void putOptionalMessageDetails(ISerializer iSerializer, MessageDetails messageDetails) {
        boolean bl = messageDetails == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = messageDetails.getMessagingAccountID();
            iSerializer.putInt32(n);
            String string = messageDetails.getMessageID();
            iSerializer.putOptionalString(string);
            int n2 = messageDetails.getType();
            iSerializer.putInt32(n2);
            MatchedAddress matchedAddress = messageDetails.getSender();
            MatchedAddressSerializer.putOptionalMatchedAddress(iSerializer, matchedAddress);
            MatchedAddress[] matchedAddressArray = messageDetails.getRecipientsTo();
            MatchedAddressSerializer.putOptionalMatchedAddressVarArray(iSerializer, matchedAddressArray);
            MatchedAddress[] matchedAddressArray2 = messageDetails.getRecipientsCc();
            MatchedAddressSerializer.putOptionalMatchedAddressVarArray(iSerializer, matchedAddressArray2);
            MatchedAddress[] matchedAddressArray3 = messageDetails.getRecipientsBcc();
            MatchedAddressSerializer.putOptionalMatchedAddressVarArray(iSerializer, matchedAddressArray3);
            String string2 = messageDetails.getSubject();
            iSerializer.putOptionalString(string2);
            long l = messageDetails.getDateTime();
            iSerializer.putInt64(l);
            int n3 = messageDetails.getMessageStatus();
            iSerializer.putInt32(n3);
            String string3 = messageDetails.getReplyTo();
            iSerializer.putOptionalString(string3);
            String string4 = messageDetails.getBody();
            iSerializer.putOptionalString(string4);
            AttachmentInformation[] attachmentInformationArray = messageDetails.getAttachments();
            AttachmentInformationSerializer.putOptionalAttachmentInformationVarArray(iSerializer, attachmentInformationArray);
            int n4 = messageDetails.getPriority();
            iSerializer.putInt32(n4);
            int[] nArray = messageDetails.getSegmentLengths();
            iSerializer.putOptionalInt32VarArray(nArray);
            int n5 = messageDetails.getStorageLocation();
            iSerializer.putInt32(n5);
            ExtractedItem[] extractedItemArray = messageDetails.getExtractedItems();
            ExtractedItemSerializer.putOptionalExtractedItemVarArray(iSerializer, extractedItemArray);
        }
    }

    public static void putOptionalMessageDetailsVarArray(ISerializer iSerializer, MessageDetails[] messageDetailsArray) {
        boolean bl = messageDetailsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(messageDetailsArray.length);
            for (int i2 = 0; i2 < messageDetailsArray.length; ++i2) {
                MessageDetailsSerializer.putOptionalMessageDetails(iSerializer, messageDetailsArray[i2]);
            }
        }
    }

    public static MessageDetails getOptionalMessageDetails(IDeserializer iDeserializer) {
        MessageDetails messageDetails = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            String string2;
            int n3;
            long l;
            String string3;
            MatchedAddress matchedAddress;
            int n4;
            String string4;
            int n5;
            messageDetails = new MessageDetails();
            messageDetails.messagingAccountID = n5 = iDeserializer.getInt32();
            messageDetails.messageID = string4 = iDeserializer.getOptionalString();
            messageDetails.type = n4 = iDeserializer.getInt32();
            messageDetails.sender = matchedAddress = MatchedAddressSerializer.getOptionalMatchedAddress(iDeserializer);
            MatchedAddress[] matchedAddressArray = MatchedAddressSerializer.getOptionalMatchedAddressVarArray(iDeserializer);
            messageDetails.recipientsTo = matchedAddressArray;
            MatchedAddress[] matchedAddressArray2 = MatchedAddressSerializer.getOptionalMatchedAddressVarArray(iDeserializer);
            messageDetails.recipientsCc = matchedAddressArray2;
            MatchedAddress[] matchedAddressArray3 = MatchedAddressSerializer.getOptionalMatchedAddressVarArray(iDeserializer);
            messageDetails.recipientsBcc = matchedAddressArray3;
            messageDetails.subject = string3 = iDeserializer.getOptionalString();
            messageDetails.dateTime = l = iDeserializer.getInt64();
            messageDetails.messageStatus = n3 = iDeserializer.getInt32();
            messageDetails.replyTo = string2 = iDeserializer.getOptionalString();
            messageDetails.body = string = iDeserializer.getOptionalString();
            AttachmentInformation[] attachmentInformationArray = AttachmentInformationSerializer.getOptionalAttachmentInformationVarArray(iDeserializer);
            messageDetails.attachments = attachmentInformationArray;
            messageDetails.priority = n2 = iDeserializer.getInt32();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            messageDetails.segmentLengths = nArray;
            messageDetails.storageLocation = n = iDeserializer.getInt32();
            ExtractedItem[] extractedItemArray = ExtractedItemSerializer.getOptionalExtractedItemVarArray(iDeserializer);
            messageDetails.extractedItems = extractedItemArray;
        }
        return messageDetails;
    }

    public static MessageDetails[] getOptionalMessageDetailsVarArray(IDeserializer iDeserializer) {
        MessageDetails[] messageDetailsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            messageDetailsArray = new MessageDetails[n];
            for (int i2 = 0; i2 < n; ++i2) {
                messageDetailsArray[i2] = MessageDetailsSerializer.getOptionalMessageDetails(iDeserializer);
            }
        }
        return messageDetailsArray;
    }
}

