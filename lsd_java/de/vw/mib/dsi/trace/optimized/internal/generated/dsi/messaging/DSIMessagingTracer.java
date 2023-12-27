/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.messaging;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessageListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.messaging.Template;

public final class DSIMessagingTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ATTACHMENTINFORMATION;
    private static final int ID_EXTRACTEDITEM;
    private static final int ID_FOLDERENTRY;
    private static final int ID_LISTCHANGEDINFORMATION;
    private static final int ID_LISTENTRY;
    private static final int ID_MATCHEDADDRESS;
    private static final int ID_MESSAGEDETAILS;
    private static final int ID_MESSAGELISTENTRY;
    private static final int ID_MESSAGINGACCOUNT;
    private static final int ID_RECIPIENTLIST;
    private static final int ID_STATUSINFORMATION;
    private static final int ID_TEMPLATE;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$AttachmentInformation;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$ExtractedItem;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$FolderEntry;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$ListChangedInformation;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$ListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$MatchedAddress;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$MessageDetails;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$MessageListEntry;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$MessagingAccount;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$RecipientList;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$StatusInformation;
    static /* synthetic */ Class class$org$dsi$ifc$messaging$Template;

    public DSIMessagingTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$AttachmentInformation == null ? (class$org$dsi$ifc$messaging$AttachmentInformation = DSIMessagingTracer.class$("org.dsi.ifc.messaging.AttachmentInformation")) : class$org$dsi$ifc$messaging$AttachmentInformation, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$ExtractedItem == null ? (class$org$dsi$ifc$messaging$ExtractedItem = DSIMessagingTracer.class$("org.dsi.ifc.messaging.ExtractedItem")) : class$org$dsi$ifc$messaging$ExtractedItem, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$FolderEntry == null ? (class$org$dsi$ifc$messaging$FolderEntry = DSIMessagingTracer.class$("org.dsi.ifc.messaging.FolderEntry")) : class$org$dsi$ifc$messaging$FolderEntry, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$ListChangedInformation == null ? (class$org$dsi$ifc$messaging$ListChangedInformation = DSIMessagingTracer.class$("org.dsi.ifc.messaging.ListChangedInformation")) : class$org$dsi$ifc$messaging$ListChangedInformation, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$ListEntry == null ? (class$org$dsi$ifc$messaging$ListEntry = DSIMessagingTracer.class$("org.dsi.ifc.messaging.ListEntry")) : class$org$dsi$ifc$messaging$ListEntry, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$MatchedAddress == null ? (class$org$dsi$ifc$messaging$MatchedAddress = DSIMessagingTracer.class$("org.dsi.ifc.messaging.MatchedAddress")) : class$org$dsi$ifc$messaging$MatchedAddress, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$MessageDetails == null ? (class$org$dsi$ifc$messaging$MessageDetails = DSIMessagingTracer.class$("org.dsi.ifc.messaging.MessageDetails")) : class$org$dsi$ifc$messaging$MessageDetails, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$MessageListEntry == null ? (class$org$dsi$ifc$messaging$MessageListEntry = DSIMessagingTracer.class$("org.dsi.ifc.messaging.MessageListEntry")) : class$org$dsi$ifc$messaging$MessageListEntry, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$MessagingAccount == null ? (class$org$dsi$ifc$messaging$MessagingAccount = DSIMessagingTracer.class$("org.dsi.ifc.messaging.MessagingAccount")) : class$org$dsi$ifc$messaging$MessagingAccount, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$RecipientList == null ? (class$org$dsi$ifc$messaging$RecipientList = DSIMessagingTracer.class$("org.dsi.ifc.messaging.RecipientList")) : class$org$dsi$ifc$messaging$RecipientList, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$StatusInformation == null ? (class$org$dsi$ifc$messaging$StatusInformation = DSIMessagingTracer.class$("org.dsi.ifc.messaging.StatusInformation")) : class$org$dsi$ifc$messaging$StatusInformation, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$messaging$Template == null ? (class$org$dsi$ifc$messaging$Template = DSIMessagingTracer.class$("org.dsi.ifc.messaging.Template")) : class$org$dsi$ifc$messaging$Template, 12);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAttachmentInformation(printWriter, (AttachmentInformation)object);
                break;
            }
            case 2: {
                this.traceExtractedItem(printWriter, (ExtractedItem)object);
                break;
            }
            case 3: {
                this.traceFolderEntry(printWriter, (FolderEntry)object);
                break;
            }
            case 4: {
                this.traceListChangedInformation(printWriter, (ListChangedInformation)object);
                break;
            }
            case 5: {
                this.traceListEntry(printWriter, (ListEntry)object);
                break;
            }
            case 6: {
                this.traceMatchedAddress(printWriter, (MatchedAddress)object);
                break;
            }
            case 7: {
                this.traceMessageDetails(printWriter, (MessageDetails)object);
                break;
            }
            case 8: {
                this.traceMessageListEntry(printWriter, (MessageListEntry)object);
                break;
            }
            case 9: {
                this.traceMessagingAccount(printWriter, (MessagingAccount)object);
                break;
            }
            case 10: {
                this.traceRecipientList(printWriter, (RecipientList)object);
                break;
            }
            case 11: {
                this.traceStatusInformation(printWriter, (StatusInformation)object);
                break;
            }
            case 12: {
                this.traceTemplate(printWriter, (Template)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAttachmentInformation(PrintWriter printWriter, AttachmentInformation attachmentInformation) {
        if (attachmentInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(attachmentInformation.attachmentID);
        printWriter.print(attachmentInformation.name);
        printWriter.print(attachmentInformation.mimeType);
        printWriter.print(attachmentInformation.size);
        printWriter.print(attachmentInformation.entryID);
        this.trace(printWriter, attachmentInformation.attachmentPath);
    }

    private void traceExtractedItem(PrintWriter printWriter, ExtractedItem extractedItem) {
        if (extractedItem == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(extractedItem.type);
        printWriter.print(extractedItem.value);
        printWriter.print(extractedItem.offset);
        printWriter.print(extractedItem.length);
    }

    private void traceFolderEntry(PrintWriter printWriter, FolderEntry folderEntry) {
        if (folderEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(folderEntry.folderID);
        printWriter.print(folderEntry.parentFolderID);
        printWriter.print(folderEntry.folderType);
        printWriter.print(folderEntry.folderName);
        printWriter.print(folderEntry.unreadMessageCount);
    }

    private void traceListChangedInformation(PrintWriter printWriter, ListChangedInformation listChangedInformation) {
        if (listChangedInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listChangedInformation.reason);
        printWriter.print(listChangedInformation.listSize);
    }

    private void traceListEntry(PrintWriter printWriter, ListEntry listEntry) {
        if (listEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(listEntry.listEntryId);
        printWriter.print(listEntry.type);
        this.trace(printWriter, listEntry.folderEntry);
        this.trace(printWriter, listEntry.messageListEntry);
    }

    private void traceMatchedAddress(PrintWriter printWriter, MatchedAddress matchedAddress) {
        if (matchedAddress == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(matchedAddress.address);
        printWriter.print(matchedAddress.name);
        printWriter.print(matchedAddress.adbEntryID);
        this.trace(printWriter, matchedAddress.adbPictureID);
    }

    private void traceMessageDetails(PrintWriter printWriter, MessageDetails messageDetails) {
        int n;
        int n2;
        if (messageDetails == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(messageDetails.messagingAccountID);
        printWriter.print(messageDetails.messageID);
        printWriter.print(messageDetails.type);
        this.trace(printWriter, messageDetails.sender);
        if (messageDetails.recipientsTo == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = messageDetails.recipientsTo.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, messageDetails.recipientsTo[n]);
            }
        }
        if (messageDetails.recipientsCc == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = messageDetails.recipientsCc.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, messageDetails.recipientsCc[n]);
            }
        }
        if (messageDetails.recipientsBcc == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = messageDetails.recipientsBcc.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, messageDetails.recipientsBcc[n]);
            }
        }
        printWriter.print(messageDetails.subject);
        printWriter.print(messageDetails.dateTime);
        printWriter.print(messageDetails.messageStatus);
        printWriter.print(messageDetails.replyTo);
        printWriter.print(messageDetails.body);
        if (messageDetails.attachments == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = messageDetails.attachments.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, messageDetails.attachments[n]);
            }
        }
        printWriter.print(messageDetails.priority);
        if (messageDetails.segmentLengths == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = messageDetails.segmentLengths.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(messageDetails.segmentLengths[n]);
            }
        }
        printWriter.print(messageDetails.storageLocation);
        if (messageDetails.extractedItems == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = messageDetails.extractedItems.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, messageDetails.extractedItems[n]);
            }
        }
    }

    private void traceMessageListEntry(PrintWriter printWriter, MessageListEntry messageListEntry) {
        if (messageListEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, messageListEntry.matchedAddress);
        printWriter.print(messageListEntry.messageID);
        printWriter.print(messageListEntry.messagingAccountID);
        printWriter.print(messageListEntry.sender);
        if (messageListEntry.recipients == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = messageListEntry.recipients.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(messageListEntry.recipients[i2]);
            }
        }
        printWriter.print(messageListEntry.dateTime);
        printWriter.print(messageListEntry.messageStatus);
        printWriter.print(messageListEntry.subject);
        printWriter.print(messageListEntry.attachmentSize);
        printWriter.print(messageListEntry.priority);
        printWriter.print(messageListEntry.type);
        printWriter.print(messageListEntry.storageLocation);
    }

    private void traceMessagingAccount(PrintWriter printWriter, MessagingAccount messagingAccount) {
        if (messagingAccount == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(messagingAccount.accountID);
        printWriter.print(messagingAccount.accountName);
        printWriter.print(messagingAccount.accountType);
        printWriter.print(messagingAccount.supportsSMS);
        printWriter.print(messagingAccount.supportsEMail);
        printWriter.print(messagingAccount.offeredFolderTypes);
        printWriter.print(messagingAccount.memoryStatus);
        printWriter.print(messagingAccount.unreadMessageCount);
        printWriter.print(messagingAccount.btDeviceAddress);
        printWriter.print(messagingAccount.btUserFriendlyName);
        printWriter.print(messagingAccount.simCardId);
    }

    private void traceRecipientList(PrintWriter printWriter, RecipientList recipientList) {
        int n;
        int n2;
        if (recipientList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        if (recipientList.to == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = recipientList.to.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(recipientList.to[n]);
            }
        }
        if (recipientList.cc == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = recipientList.cc.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(recipientList.cc[n]);
            }
        }
        if (recipientList.bcc == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = recipientList.bcc.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(recipientList.bcc[n]);
            }
        }
    }

    private void traceStatusInformation(PrintWriter printWriter, StatusInformation statusInformation) {
        if (statusInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(statusInformation.messageId);
        printWriter.print(statusInformation.status);
    }

    private void traceTemplate(PrintWriter printWriter, Template template) {
        if (template == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(template.id);
        printWriter.print(template.body);
        printWriter.print(template.readOnly);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

