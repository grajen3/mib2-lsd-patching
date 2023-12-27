/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.messaging;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;

public interface DSIMessaging
extends DSIBase {
    public static final String VERSION;
    public static final int RT_CHANGEFOLDERREQUEST;
    public static final int RT_LISTENTRIESREQUEST;
    public static final int RT_DELETEMESSAGEREQUEST;
    public static final int RT_SENDMESSAGEREQUEST;
    public static final int RT_GETMESSAGECONTENTSREQUEST;
    public static final int RT_SETMESSAGEREADSTATUSREQUEST;
    public static final int RT_SAVEASDRAFTREQUEST;
    public static final int RT_EXTRACTINFORMATIONREQUEST;
    public static final int RT_DELETETEMPLATEREQUEST;
    public static final int RT_GETTEMPLATESREQUEST;
    public static final int RT_GETTEMPLATEREQUEST;
    public static final int RT_CHANGETEMPLATEREQUEST;
    public static final int RT_GETPOSITIONOFMESSAGEREQUEST;
    public static final int RT_GETPOSITIONOFFOLDERREQUEST;
    public static final int RT_DELETESIMCARDMESSAGESREQUEST;
    public static final int RT_DECODEATTACHMENTREQUEST;
    public static final int ATTR_SYNCHINPROGRESS;
    public static final int ATTR_MESSAGINGACCOUNTS;
    public static final int IN_INDICATENEWMESSAGE;
    public static final int IN_INDICATELISTCHANGED;
    public static final int IN_INDICATEMESSAGESTATUS;
    public static final int IN_INDICATEPUSHMESSAGEFAILED;
    public static final int IN_INDICATESENDMESSAGE;
    public static final int IN_INDICATEFOLDERINFORMATION;
    public static final int RP_LISTENTRIESRESPONSE;
    public static final int RP_CHANGEFOLDERRESPONSE;
    public static final int RP_DELETEMESSAGERESPONSE;
    public static final int RP_SENDMESSAGERESPONSE;
    public static final int RP_GETMESSAGECONTENTSRESPONSE;
    public static final int RP_SETMESSAGEREADSTATUSRESPONSE;
    public static final int RP_PARSEVCARDRESPONSE;
    public static final int RP_SAVEASDRAFTRESPONSE;
    public static final int RP_EXTRACTINFORMATIONRESPONSE;
    public static final int RP_DELETETEMPLATERESPONSE;
    public static final int RP_GETTEMPLATESRESPONSE;
    public static final int RP_GETTEMPLATERESPONSE;
    public static final int RP_CHANGETEMPLATERESPONSE;
    public static final int RP_GETPOSITIONOFMESSAGERESPONSE;
    public static final int RP_GETPOSITIONOFFOLDERRESPONSE;
    public static final int RP_DELETESIMCARDMESSAGESRESPONSE;
    public static final int RP_DECODEATTACHMENTRESPONSE;

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
}

