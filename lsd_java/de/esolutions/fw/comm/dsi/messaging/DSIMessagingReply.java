/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;
import org.dsi.ifc.messaging.Template;

public interface DSIMessagingReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void indicateMessageStatus(StatusInformation statusInformation) {
    }

    default public void indicateFolderInformation(FolderEntry folderEntry) {
    }

    default public void indicateListChanged(ListChangedInformation listChangedInformation) {
    }

    default public void updateSynchInProgress(boolean bl, int n) {
    }

    default public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
    }

    default public void indicateNewMessage(boolean bl, String string, int n, int n2) {
    }

    default public void listEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
    }

    default public void getPositionOfMessageResponse(int n, int n2) {
    }

    default public void getPositionOfFolderResponse(int n, int n2) {
    }

    default public void changeFolderResponse(FolderEntry folderEntry, int n) {
    }

    default public void deleteMessageResponse(int n, int n2, int n3) {
    }

    default public void sendMessageResponse(int n, int n2) {
    }

    default public void getMessageContentsResponse(int n, MessageDetails messageDetails) {
    }

    default public void setMessageReadStatusResponse(int n) {
    }

    default public void parseVCardResponse(int n, String string) {
    }

    default public void saveAsDraftResponse(int n, String string) {
    }

    default public void extractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
    }

    default public void changeTemplateResponse(int n, int n2) {
    }

    default public void getTemplateResponse(int n, Template template) {
    }

    default public void getTemplatesResponse(int n, Template[] templateArray) {
    }

    default public void deleteTemplateResponse(int n) {
    }

    default public void indicatePushMessageFailed(int n, int n2, int n3, String string) {
    }

    default public void indicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
    }

    default public void deleteSimCardMessagesResponse(int n) {
    }

    default public void decodeAttachmentResponse(int n, ResourceLocator resourceLocator) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

