/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingReply;
import de.esolutions.fw.comm.dsi.messaging.impl.AttachmentInformationSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.ExtractedItemSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.FolderEntrySerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.ListChangedInformationSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.ListEntrySerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.MessageDetailsSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.MessagingAccountSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.RecipientListSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.StatusInformationSerializer;
import de.esolutions.fw.comm.dsi.messaging.impl.TemplateSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
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

public class DSIMessagingReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.messaging.DSIMessaging");
    private static int dynamicHandle = 0;
    private DSIMessagingReply p_DSIMessagingReply;

    public DSIMessagingReplyService(DSIMessagingReply dSIMessagingReply) {
        super(new ServiceInstanceID("de638f1a-b4f1-53c5-ae36-09e21251513b", DSIMessagingReplyService.nextDynamicHandle(), "7feed9a5-c7e8-572a-b6fd-2d260b6f2aa6", "dsi.messaging.DSIMessaging"));
        this.p_DSIMessagingReply = dSIMessagingReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 67: {
                    StatusInformation statusInformation = StatusInformationSerializer.getOptionalStatusInformation(iDeserializer);
                    this.p_DSIMessagingReply.indicateMessageStatus(statusInformation);
                    break;
                }
                case 66: {
                    FolderEntry folderEntry = FolderEntrySerializer.getOptionalFolderEntry(iDeserializer);
                    this.p_DSIMessagingReply.indicateFolderInformation(folderEntry);
                    break;
                }
                case 46: {
                    ListChangedInformation listChangedInformation = ListChangedInformationSerializer.getOptionalListChangedInformation(iDeserializer);
                    this.p_DSIMessagingReply.indicateListChanged(listChangedInformation);
                    break;
                }
                case 40: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.updateSynchInProgress(bl, n);
                    break;
                }
                case 81: {
                    MessagingAccount[] messagingAccountArray = MessagingAccountSerializer.getOptionalMessagingAccountVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.updateMessagingAccounts(messagingAccountArray, n);
                    break;
                }
                case 68: {
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.indicateNewMessage(bl, string, n, n2);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    ListEntry[] listEntryArray = ListEntrySerializer.getOptionalListEntryVarArray(iDeserializer);
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.listEntriesResponse(n, n3, listEntryArray, n4, n5, n6);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.getPositionOfMessageResponse(n, n7);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.getPositionOfFolderResponse(n, n8);
                    break;
                }
                case 56: {
                    FolderEntry folderEntry = FolderEntrySerializer.getOptionalFolderEntry(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.changeFolderResponse(folderEntry, n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.deleteMessageResponse(n, n9, n10);
                    break;
                }
                case 76: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.sendMessageResponse(n, n11);
                    break;
                }
                case 82: {
                    int n = iDeserializer.getInt32();
                    MessageDetails messageDetails = MessageDetailsSerializer.getOptionalMessageDetails(iDeserializer);
                    this.p_DSIMessagingReply.getMessageContentsResponse(n, messageDetails);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.setMessageReadStatusResponse(n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIMessagingReply.parseVCardResponse(n, string);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIMessagingReply.saveAsDraftResponse(n, string);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    ExtractedItem[] extractedItemArray = ExtractedItemSerializer.getOptionalExtractedItemVarArray(iDeserializer);
                    this.p_DSIMessagingReply.extractInformationResponse(n, extractedItemArray);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.changeTemplateResponse(n, n12);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    Template template = TemplateSerializer.getOptionalTemplate(iDeserializer);
                    this.p_DSIMessagingReply.getTemplateResponse(n, template);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    Template[] templateArray = TemplateSerializer.getOptionalTemplateVarArray(iDeserializer);
                    this.p_DSIMessagingReply.getTemplatesResponse(n, templateArray);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.deleteTemplateResponse(n);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIMessagingReply.indicatePushMessageFailed(n, n13, n14, string);
                    break;
                }
                case 70: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    RecipientList recipientList = RecipientListSerializer.getOptionalRecipientList(iDeserializer);
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    AttachmentInformation[] attachmentInformationArray = AttachmentInformationSerializer.getOptionalAttachmentInformationVarArray(iDeserializer);
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.indicateSendMessage(nArray, n, n15, recipientList, string, string2, attachmentInformationArray, n16);
                    break;
                }
                case 59: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.deleteSimCardMessagesResponse(n);
                    break;
                }
                case 80: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_DSIMessagingReply.decodeAttachmentResponse(n, resourceLocator);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIMessagingReply.asyncException(n, string, n17);
                    break;
                }
                case 41: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIMessagingReply.yyIndication(string, string3);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

