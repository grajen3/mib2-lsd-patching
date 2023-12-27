/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging;

import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

public interface DSIMessagingC {
    default public void changeFolderRequest(int n, int n2, int n3, int n4, int n5) {
    }

    default public void listEntriesRequest(int n, int n2, int n3) {
    }

    default public void getPositionOfMessageRequest(String string) {
    }

    default public void getPositionOfFolderRequest(int n) {
    }

    default public void deleteMessageRequest(String[] stringArray, boolean bl) {
    }

    default public void sendMessageRequest(int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
    }

    default public void getMessageContentsRequest(int n, String string, int n2) {
    }

    default public void setMessageReadStatusRequest(String string, boolean bl) {
    }

    default public void saveAsDraftRequest(String string, int n, RecipientList recipientList, String string2, String string3, int n2, AttachmentInformation[] attachmentInformationArray) {
    }

    default public void extractInformationRequest(String string) {
    }

    default public void changeTemplateRequest(int n, String string) {
    }

    default public void getTemplateRequest(int n) {
    }

    default public void getTemplatesRequest() {
    }

    default public void deleteTemplateRequest(int[] nArray) {
    }

    default public void deleteSimCardMessagesRequest(int n, int n2) {
    }

    default public void decodeAttachmentRequest(AttachmentInformation attachmentInformation) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

