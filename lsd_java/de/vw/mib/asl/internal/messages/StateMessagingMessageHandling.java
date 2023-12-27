/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling;
import de.vw.mib.asl.internal.messages.MessageListItem;
import de.vw.mib.asl.internal.messages.RecipientListItem;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactNumbersCollector;
import de.vw.mib.asl.internal.messages.util.MessagingUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.messages.ASLMessagesPropertyManager;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesSelectedMessageCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.ExtractedItem;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DataSet;

public class StateMessagingMessageHandling
extends AbstractHsmState {
    private HsmPhoneSMSHandling target;
    private String extractedSenderNumber = "";
    private boolean replyScenario;
    private MessageDetails openedMessage = null;
    private boolean writeSpellerDiscarded = false;

    public StateMessagingMessageHandling(HsmPhoneSMSHandling hsmPhoneSMSHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneSMSHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742181: {
                if (this.target.getCurrentAccountNewMessageSet() != null) {
                    this.target.getCurrentAccountNewMessageSet().clear();
                }
                AbstractASLHsmTarget.writeIntegerToDatapool(449, ASLMessagingData.newMessagesSetExternal.size() + ASLMessagingData.newMessagesSetInternal.size());
                break;
            }
            case 1073742186: {
                int n = eventGeneric.getInt(0);
                MessageListItem messageListItem = (MessageListItem)ListManager.getGenericASLList(463).getRowItem(n);
                RecipientList recipientList = new RecipientList();
                recipientList.to = new String[MessagingUtil.getRecipientsSize()];
                for (int i2 = 0; i2 < MessagingUtil.getRecipientsSize(); ++i2) {
                    recipientList.to[i2] = MessagingUtil.getRecipient((int)i2).number;
                }
                if ((this.openedMessage == null || this.openedMessage.getBody().equals(this.target.spellerHsmWrite.getSpellerData().getEnteredText()) || this.writeSpellerDiscarded) && this.recipientsEqual(this.openedMessage.getRecipientsTo(), recipientList.to)) break;
                this.target.dsiMessaging.saveAsDraftRequest(messageListItem.listEntry.getMessageListEntry().getMessageID(), messageListItem.listEntry.getMessageListEntry().getType(), recipientList, messageListItem.listEntry.getMessageListEntry().getSubject(), this.target.spellerHsmWrite.getSpellerData().getEnteredText(), messageListItem.listEntry.getMessageListEntry().getMessagingAccountID(), null);
                break;
            }
            case 1073742192: {
                int n = eventGeneric.getInt(0);
                MessageListItem messageListItem = (MessageListItem)ListManager.getGenericASLList(463).getRowItem(n);
                if (messageListItem.listEntry.getType() != 1) break;
                this.target.handleGetSortingFolder(messageListItem.listEntry.getFolderEntry().getFolderType());
                this.target.handleChangeFolder(messageListItem.listEntry.getFolderEntry().getFolderID(), messageListItem.listEntry, false);
                break;
            }
            case 1073742191: {
                int n = eventGeneric.getInt(0);
                int n2 = -1;
                switch (n) {
                    case 0: {
                        n2 = -1;
                        break;
                    }
                    case 5: {
                        n2 = -2;
                        break;
                    }
                    default: {
                        this.target.error("Unhandled parameter for MOVE_FOLDER_LEVEL_UP, going to ROOT: ", n);
                    }
                }
                this.target.handleChangeFolder(n2, null, false);
                break;
            }
            case 1073742184: 
            case 1073742185: {
                int n = eventGeneric.getInt(0);
                MessageListItem messageListItem = (MessageListItem)ListManager.getGenericASLList(463).getRowItem(n);
                this.target.dsiMessaging.deleteMessageRequest(new String[]{messageListItem.listEntry.getMessageListEntry().getMessageID()}, true);
                break;
            }
            case 1073742200: {
                String string = eventGeneric.getString(0);
                RecipientList recipientList = new RecipientList(new String[]{string}, null, null);
                this.target.handleSendMessage(1, recipientList, "", null, null, this.target.smsAccountId);
                break;
            }
            case 1074641839: {
                int n = eventGeneric.getInt(0);
                MessageListItem messageListItem = (MessageListItem)ListManager.getGenericASLList(463).getRowItem(n);
                this.target.dsiMessaging.getMessageContentsRequest(messageListItem.listEntry.getMessageListEntry().getMessagingAccountID(), messageListItem.listEntry.getMessageListEntry().getMessageID(), 2);
                this.trans(this.target.stateResend);
                break;
            }
            case 1073742197: {
                eventGeneric.getInt(0);
                break;
            }
            case 1073742199: {
                this.replyScenario = false;
                this.target.isForwarding = false;
                int n = eventGeneric.getInt(0);
                MessageListItem messageListItem = (MessageListItem)ListManager.getGenericASLList(463).getRowItem(n);
                this.target.dsiMessaging.getMessageContentsRequest(messageListItem.listEntry.getMessageListEntry().getMessagingAccountID(), messageListItem.listEntry.getMessageListEntry().getMessageID(), 2);
                break;
            }
            case 1073742202: {
                boolean bl = eventGeneric.getBoolean(0);
                MessagingUtil.setTemporarySaved(bl);
                break;
            }
            case 1073742201: {
                String string = eventGeneric.getString(0);
                MatchedAddress matchedAddress = null;
                int n = MessagingUtil.getRecipientsSize();
                Object[] objectArray = new MatchedAddress[n];
                for (int i3 = 0; i3 < n; ++i3) {
                    RecipientListItem recipientListItem = MessagingUtil.getRecipient(i3);
                    matchedAddress = new MatchedAddress(recipientListItem.number, recipientListItem.name, recipientListItem.entryId, recipientListItem.picture);
                    objectArray[i3] = matchedAddress;
                }
                this.setMessageContent(new MessageDetails(this.target.smsAccountId, "", 1, null, (MatchedAddress[])(!Util.isNullOrEmpty(objectArray) ? objectArray : new MatchedAddress[]{}), new MatchedAddress[0], new MatchedAddress[0], string, -1L, 2, null, string, new AttachmentInformation[0], 2, new int[0], 0), false, true);
                this.target.spellerHsmWrite.getSpellerData().setEnteredText(string);
                break;
            }
            case 1074641826: {
                this.target.fillModelGetterForNaviTemplates();
                break;
            }
            case 1073742193: {
                this.replyScenario = true;
                this.target.spellerHsmWrite.resetSpellerData();
                Object[] objectArray = (MessagesEditedMessageCollector[])ListManager.getGenericASLList(4037).getDSIObjects();
                objectArray[0].messages_edited_text = "";
                ListManager.getGenericASLList(4037).updateList(objectArray);
                break;
            }
            case 1073742189: {
                this.replyScenario = false;
                this.target.isForwarding = true;
                MessagingUtil.clearMessageRecipients();
                this.setMessageContent(this.openedMessage, true, !this.target.isForwarding);
                break;
            }
            case 1074641840: {
                long l = eventGeneric.getLong(0);
                String string = eventGeneric.getString(1);
                String string2 = eventGeneric.getString(2);
                MessagingUtil.setTemporarySaved(false);
                MessagingUtil.clearMessageRecipients();
                ResourceLocator resourceLocator = ASLPhoneFactory.getPhoneApi().contactPictureFromSelectedContacts(l);
                if (resourceLocator != null) {
                    MessagingUtil.addRecipient(new RecipientListItem(l, 0, string2, string, resourceLocator));
                    break;
                }
                MessagingUtil.addRecipient(new RecipientListItem(l, 0, string2, string, this.contactPictureFromExtractedNumbers(l)));
                break;
            }
            case 1073742183: {
                long l = eventGeneric.getLong(0);
                this.target.dsiAdbVCardExchange.createVCard(0, new long[]{l}, 0);
                break;
            }
            case 1073742194: {
                AbstractASLHsmTarget.writeBooleanToDatapool(-1075704576, true);
                RecipientList recipientList = new RecipientList();
                recipientList.to = new String[MessagingUtil.getRecipientsSize()];
                for (int i4 = 0; i4 < MessagingUtil.getRecipientsSize(); ++i4) {
                    recipientList.to[i4] = MessagingUtil.getRecipient((int)i4).number;
                }
                if (this.target.smsAccountId == -1) break;
                this.target.dsiMessaging.saveAsDraftRequest("", 1, recipientList, "", this.target.spellerHsmWrite.getSpellerData().getEnteredText(), this.target.smsAccountId, null);
                break;
            }
            case 1073742195: {
                MessagesSelectedMessageCollector messagesSelectedMessageCollector = (MessagesSelectedMessageCollector)ListManager.getGenericASLList(465).getRowItem(0);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-496552704);
                eventGeneric2.setString(0, messagesSelectedMessageCollector.messages_selected_embedded_v_card_name);
                this.target.send(eventGeneric2);
                break;
            }
            case 1073742188: {
                int n = eventGeneric.getInt(0);
                MessageListItem messageListItem = (MessageListItem)ListManager.getGenericASLList(463).getRowItem(n);
                if (messageListItem.listEntry.getType() != 2) break;
                this.extractedSenderNumber = messageListItem.listEntry.getMessageListEntry().sender;
                this.target.dsiMessaging.extractInformationRequest(messageListItem.listEntry.getMessageListEntry().getMessageID());
                break;
            }
            case 1073742187: {
                break;
            }
            case 1073744410: {
                break;
            }
            case 1073744411: {
                break;
            }
            case 1073742198: {
                int n = eventGeneric.getInt(0);
                DataSet dataSet = (DataSet)ListManager.getGenericASLList(460).getRowItem(n);
                ListManager.getGenericASLList(459).updateList(new MessagesContactsMessageContactNumbersCollector[0]);
                this.target.send(ASLPhoneFactory.getPhoneApi().createSingleEntryEvent(5279, 814219520, dataSet.entryId));
                break;
            }
            case 100400: {
                if (eventGeneric.getResult() != 0) break;
                AdbEntry adbEntry = (AdbEntry)eventGeneric.getObject(1);
                Object[] objectArray = ASLPhoneFactory.getPhoneApi().ripADBPhoneData(adbEntry.phoneData);
                ListManager.getGenericASLList(459).updateList(objectArray);
                break;
            }
            case 1073742212: {
                super.getClass();
                this.target.activeSpeller = 0;
                break;
            }
            case 1073742214: {
                this.target.spellerHsmNumber.resetSpellerData();
                break;
            }
            case 1073742215: {
                super.getClass();
                this.target.activeSpeller = 1;
                this.target.spellerHsmNumber.resetSpellerData();
                break;
            }
            case 1073742216: {
                String string = this.target.spellerHsmNumber.getSpellerData().getEnteredText();
                MessagingUtil.addRecipient(new RecipientListItem(0L, 0, string, "", null));
                break;
            }
            case 1073742217: {
                AttachmentInformation[] attachmentInformationArray;
                RecipientList recipientList = new RecipientList(new String[]{this.target.spellerHsmNumber.getSpellerData().getEnteredText()}, null, null);
                if (ASLMessagingData.vCard != null) {
                    AttachmentInformation[] attachmentInformationArray2 = new AttachmentInformation[1];
                    attachmentInformationArray = attachmentInformationArray2;
                    attachmentInformationArray2[0] = ASLMessagingData.vCard;
                } else {
                    attachmentInformationArray = null;
                }
                this.target.handleSendMessage(1, recipientList, "", null, attachmentInformationArray, this.target.smsAccountId);
                break;
            }
            case 1073742239: {
                super.getClass();
                this.target.activeSpeller = 0;
                break;
            }
            case 1073742241: {
                this.writeSpellerDiscarded = true;
                this.target.spellerHsmWrite.getSpellerData().setEnteredText("");
                this.target.spellerHsmWrite.resetSpellerData();
                MessagingUtil.setTemporarySaved(false);
                break;
            }
            case 1073742242: {
                this.writeSpellerDiscarded = false;
                super.getClass();
                this.target.activeSpeller = 2;
                String string = eventGeneric.getString(0);
                while (string.indexOf("\r\n") != -1) {
                    string = new StringBuffer().append(string.substring(0, string.indexOf("\r\n"))).append(" ").append(string.substring(string.indexOf("\r\n") + 2)).toString();
                }
                while (string.indexOf("\n") != -1) {
                    string = new StringBuffer().append(string.substring(0, string.indexOf("\n"))).append(" ").append(string.substring(string.indexOf("\n") + 1)).toString();
                }
                this.target.spellerHsmWrite.initSpeller(string);
                MessagingUtil.setTemporarySaved(!Util.isNullOrEmpty(string));
                break;
            }
            case 1074641838: 
            case 1074641846: {
                boolean bl = eventGeneric.getBoolean(0);
                AbstractASLHsmTarget.writeBooleanToDatapool(1127358464, bl);
                break;
            }
            case 1074641837: {
                MessagingUtil.setTemporarySaved(true);
                AbstractASLHsmTarget.writeBooleanToDatapool(-1075704576, false);
                hsmState = this.getParent();
                break;
            }
            case 1073742240: {
                if (this.target.spellerHsmWrite.getSpellerData().getEnteredText().length() == 0) {
                    MessagingUtil.setTemporarySaved(false);
                    AbstractASLHsmTarget.writeBooleanToDatapool(-1075704576, false);
                }
                hsmState = this.getParent();
                break;
            }
            case 1073742243: {
                Object[] objectArray = (MessagesEditedMessageCollector[])ListManager.getGenericASLList(4037).getDSIObjects();
                objectArray[0].messages_edited_text = this.target.spellerHsmWrite.getSpellerData().getEnteredText();
                objectArray[0].messages_edited_number_of_signs = this.target.spellerHsmWrite.getSpellerData().getEnteredText().length();
                objectArray[0].messages_edited_number_of_messages = this.target.spellerHsmWrite.getSpellerData().getEnteredText().length() / 160;
                objectArray[0].messages_edited_embedded_v_card = false;
                objectArray[0].messages_edited_embedded_v_card_name = "";
                ASLMessagingData.vCard = null;
                ListManager.getGenericASLList(4037).updateList(objectArray);
                AbstractASLHsmTarget.writeBooleanToDatapool(3611, true);
                AbstractASLHsmTarget.writeBooleanToDatapool(4036, true);
                break;
            }
            case 1074641847: {
                int n = eventGeneric.getInt(0);
                if (n == 0) {
                    this.target.dsiMessaging.deleteSimCardMessagesRequest(this.target.smsAccountId, 4);
                    break;
                }
                if (n == 1) {
                    this.target.dsiMessaging.deleteSimCardMessagesRequest(this.target.smsAccountId, 5);
                    break;
                }
                if (n == 2) {
                    this.target.dsiMessaging.deleteSimCardMessagesRequest(this.target.smsAccountId, 3);
                    break;
                }
                if (n != 3) break;
                this.target.dsiMessaging.deleteSimCardMessagesRequest(this.target.smsAccountId, 2);
                break;
            }
            case 1074641841: {
                int n = eventGeneric.getInt(0);
                AddressData addressData = (AddressData)ListManager.getGenericASLList(461).getDSIObjects()[n];
                NavAddress navAddress = new NavAddress();
                navAddress.setCity(addressData.getLocality());
                navAddress.setCountry(addressData.getCountry());
                navAddress.setStreet(addressData.getStreet());
                navAddress.setZip(addressData.getPostalCode());
                navAddress.setState(addressData.getRegion());
                ASLNavigationFactory.getNavigationApi().getASLNavigationServices(null).startGuidance(new NavAddress[]{navAddress}, true, 4);
                break;
            }
            case 3100001: {
                int n = eventGeneric.getInt(0);
                RecipientList recipientList = (RecipientList)eventGeneric.getObject(1);
                String string = eventGeneric.getString(2);
                AttachmentInformation[] attachmentInformationArray = (AttachmentInformation[])eventGeneric.getObject(3);
                this.target.handleSendMessage(n, recipientList, string, null, attachmentInformationArray, this.target.smsAccountId);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private ResourceLocator contactPictureFromExtractedNumbers(long l) {
        DataSet dataSet;
        if (ListManager.getGenericASLList(460).isValidItem(ListManager.getGenericASLList(460).getListItemByIdCacheOnly(l)) && (dataSet = (DataSet)ListManager.getGenericASLList(460).getListItemByIdCacheOnly(l)) != null) {
            return dataSet.getContactPicture();
        }
        return null;
    }

    private boolean recipientsEqual(MatchedAddress[] matchedAddressArray, String[] stringArray) {
        boolean bl;
        ArrayList arrayList = new ArrayList();
        for (bl = false; bl < matchedAddressArray.length; bl += 1) {
            if (Util.isNullOrEmpty(matchedAddressArray[bl].getAddress())) continue;
            arrayList.add(matchedAddressArray[bl]);
        }
        matchedAddressArray = (MatchedAddress[])arrayList.toArray(new MatchedAddress[arrayList.size()]);
        boolean bl2 = bl = matchedAddressArray.length == stringArray.length;
        if (bl) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < matchedAddressArray.length; ++i2) {
                hashSet.add(matchedAddressArray[i2].getAddress());
            }
            HashSet hashSet2 = new HashSet();
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                hashSet2.add(stringArray[i3]);
            }
            if (!hashSet.containsAll(hashSet2)) {
                bl = false;
            }
        }
        return bl;
    }

    public void dsiMessagingIndicateNewMessage(boolean bl, String string, int n, int n2) {
        if (bl && (n2 == 1 || n2 == 3 || n2 == 5) && !this.target.getAccountNewMessageSet(n).contains(string)) {
            this.target.getAccountNewMessageSet(n).add(string);
            if (this.target.smsAccountId == n && this.target.currentlyOpenedMessage.equals(string)) {
                this.target.dsiMessaging.getMessageContentsRequest(n, string, 2);
            }
            AbstractASLHsmTarget.writeIntegerToDatapool(449, ASLMessagingData.newMessagesSetExternal.size() + ASLMessagingData.newMessagesSetInternal.size());
        }
    }

    public void dsiMessagingGetMessageContentsResponse(int n, MessageDetails messageDetails) {
        if (n == 0) {
            this.openedMessage = messageDetails;
            this.target.currentlyOpenedMessage = messageDetails.getMessageID();
            this.setMessageContent(messageDetails, true, !this.target.isForwarding);
        } else {
            MessagesSelectedMessageCollector messagesSelectedMessageCollector = new MessagesSelectedMessageCollector();
            MessagesEditedMessageCollector messagesEditedMessageCollector = new MessagesEditedMessageCollector();
            ListManager.getGenericASLList(465).updateList(new MessagesSelectedMessageCollector[]{messagesSelectedMessageCollector});
            ListManager.getGenericASLList(4037).updateList(new MessagesEditedMessageCollector[]{messagesEditedMessageCollector});
            AbstractASLHsmTarget.writeBooleanToDatapool(3611, true);
            AbstractASLHsmTarget.writeBooleanToDatapool(4036, true);
        }
        this.replyScenario = false;
    }

    private void setMessageContent(MessageDetails messageDetails, boolean bl, boolean bl2) {
        MessagesSelectedMessageCollector messagesSelectedMessageCollector = new MessagesSelectedMessageCollector();
        MessagesEditedMessageCollector messagesEditedMessageCollector = new MessagesEditedMessageCollector();
        String string = messageDetails.getBody();
        if (string.trim().length() == 0) {
            string = "";
        }
        if (!this.replyScenario) {
            this.target.spellerHsmWrite.getSpellerData().setEnteredText(string);
        }
        messagesSelectedMessageCollector.messages_selected_number_of_messages = string.length() / 160 + 1;
        messagesSelectedMessageCollector.messages_selected_number_of_signs = string.length();
        messagesSelectedMessageCollector.messages_selected_text = string;
        messagesSelectedMessageCollector.messages_selected_phone_numbers_available = true;
        messagesSelectedMessageCollector.messages_selected_number = "";
        messagesSelectedMessageCollector.messages_selected_name = "";
        messagesSelectedMessageCollector.messages_selected_picture = ASLMessagesPropertyManager.SELECTED_MESSAGE__SELECTED_PICTURE__DEFAULT_VALUE;
        messagesEditedMessageCollector.messages_edited_number_of_messages = string.length() / 160 + 1;
        messagesEditedMessageCollector.messages_edited_number_of_signs = string.length();
        messagesEditedMessageCollector.messages_edited_text = string;
        messagesEditedMessageCollector.messages_edited_number = "";
        messagesEditedMessageCollector.messages_edited_name = "";
        messagesEditedMessageCollector.messages_edited_picture = ASLMessagesPropertyManager.EDITED_MESSAGE__EDITED_PICTURE__DEFAULT_VALUE;
        messagesEditedMessageCollector.messages_edited_embedded_v_card_name = ((MessagesEditedMessageCollector)ListManager.getGenericASLList((int)4037).getRowItem((int)0)).messages_edited_embedded_v_card_name;
        messagesSelectedMessageCollector.messages_selected_embedded_v_card_name = ((MessagesSelectedMessageCollector)ListManager.getGenericASLList((int)465).getRowItem((int)0)).messages_selected_embedded_v_card_name;
        String string2 = "";
        if (messageDetails.getSender() != null) {
            string2 = Util.isNullOrEmpty(messageDetails.getSender().getName()) ? messageDetails.getSender().getAddress() : messageDetails.getSender().getName();
        }
        String string3 = "";
        if (!Util.isNullOrEmpty(messageDetails.recipientsTo) && !Util.isNullOrEmpty(messageDetails.getRecipientsTo()[0].getAddress())) {
            String string4 = string3 = Util.isNullOrEmpty(messageDetails.getRecipientsTo()[0].getName()) ? messageDetails.getRecipientsTo()[0].getAddress() : messageDetails.getRecipientsTo()[0].getName();
        }
        if (this.target.mandatoryFolderType == 0) {
            if (messageDetails.getSender() != null) {
                messagesSelectedMessageCollector.messages_selected_number = messageDetails.getSender().getAddress();
                messagesSelectedMessageCollector.messages_selected_name = string2;
                messagesSelectedMessageCollector.messages_selected_picture = messageDetails.getSender().getAdbPictureID();
                if (bl2) {
                    messagesEditedMessageCollector.messages_edited_number = messageDetails.getSender().getAddress();
                    messagesEditedMessageCollector.messages_edited_name = string2;
                    messagesEditedMessageCollector.messages_edited_picture = messageDetails.getSender().getAdbPictureID();
                }
            }
        } else if (this.target.mandatoryFolderType == 1 || this.target.mandatoryFolderType == 3 || this.target.mandatoryFolderType == 2) {
            if (!Util.isNullOrEmpty(messageDetails.recipientsTo) && !Util.isNullOrEmpty(messageDetails.getRecipientsTo()[0].getAddress())) {
                messagesSelectedMessageCollector.messages_selected_number = messageDetails.getRecipientsTo()[0].getAddress();
                messagesSelectedMessageCollector.messages_selected_name = string3;
                messagesSelectedMessageCollector.messages_selected_picture = messageDetails.getRecipientsTo()[0].adbPictureID;
                boolean bl3 = messagesSelectedMessageCollector.messages_selected_multiple_numbers_available = messageDetails.recipientsTo.length > 1;
                if (bl2) {
                    messagesEditedMessageCollector.messages_edited_number = messageDetails.getRecipientsTo()[0].getAddress();
                    messagesEditedMessageCollector.messages_edited_name = string3;
                    messagesEditedMessageCollector.messages_edited_picture = messageDetails.getRecipientsTo()[0].adbPictureID;
                    messagesEditedMessageCollector.messages_edited_multiple_numbers_available = messageDetails.recipientsTo.length > 1;
                }
            }
        } else if (messageDetails.getSender() != null) {
            messagesSelectedMessageCollector.messages_selected_number = messageDetails.getSender().getAddress();
            messagesSelectedMessageCollector.messages_selected_name = string2;
            messagesSelectedMessageCollector.messages_selected_picture = messageDetails.getSender().getAdbPictureID();
            if (bl2) {
                messagesEditedMessageCollector.messages_edited_number = messageDetails.getSender().getAddress();
                messagesEditedMessageCollector.messages_edited_name = string2;
                messagesEditedMessageCollector.messages_edited_picture = messageDetails.getSender().getAdbPictureID();
            }
        } else if (!Util.isNullOrEmpty(messageDetails.recipientsTo) && !Util.isNullOrEmpty(messageDetails.getRecipientsTo()[0].getAddress())) {
            messagesSelectedMessageCollector.messages_selected_number = messageDetails.getRecipientsTo()[0].getAddress();
            messagesSelectedMessageCollector.messages_selected_name = string3;
            messagesSelectedMessageCollector.messages_selected_picture = messageDetails.getRecipientsTo()[0].adbPictureID;
            boolean bl4 = messagesSelectedMessageCollector.messages_selected_multiple_numbers_available = messageDetails.recipientsTo.length > 1;
            if (bl2) {
                messagesEditedMessageCollector.messages_edited_number = messageDetails.getRecipientsTo()[0].getAddress();
                messagesEditedMessageCollector.messages_edited_name = string3;
                messagesEditedMessageCollector.messages_edited_picture = messageDetails.getRecipientsTo()[0].adbPictureID;
                boolean bl5 = messagesEditedMessageCollector.messages_edited_multiple_numbers_available = messageDetails.recipientsTo.length > 1;
            }
        }
        if (bl) {
            ListManager.getGenericASLList(465).updateList(new MessagesSelectedMessageCollector[]{messagesSelectedMessageCollector});
        }
        ListManager.getGenericASLList(4037).updateList(new MessagesEditedMessageCollector[]{messagesEditedMessageCollector});
        if (!Util.isNullOrEmpty(messageDetails.getAttachments()) && messageDetails.getAttachments()[0] != null) {
            ASLMessagingData.vCard = messageDetails.getAttachments()[0];
        }
        if (messageDetails.getMessageStatus() == 7 || messageDetails.getMessageStatus() == 4) {
            this.target.dsiMessaging.setMessageReadStatusRequest(messageDetails.getMessageID(), true);
        }
        if (bl2) {
            MessagingUtil.clearMessageRecipients();
            if (messageDetails != null && !Util.isNullOrEmpty(messageDetails.getRecipientsTo())) {
                for (int i2 = 0; i2 < messageDetails.getRecipientsTo().length; ++i2) {
                    MessagingUtil.addRecipient(new RecipientListItem(messageDetails.getRecipientsTo()[i2].getAdbEntryID(), 0, messageDetails.getRecipientsTo()[i2].getAddress(), messageDetails.getRecipientsTo()[i2].getName(), messageDetails.getRecipientsTo()[i2].getAdbPictureID()));
                }
            }
        }
        if (!Util.isNullOrEmpty(messageDetails.attachments)) {
            messagesSelectedMessageCollector.messages_selected_embedded_v_card = true;
            messagesEditedMessageCollector.messages_edited_embedded_v_card = true;
            this.target.dsiAdbVCardExchange.parseVCard(messageDetails.getAttachments()[0].getAttachmentPath().getUrl());
        } else {
            messagesSelectedMessageCollector.messages_selected_embedded_v_card = false;
            messagesEditedMessageCollector.messages_edited_embedded_v_card = false;
            AbstractASLHsmTarget.writeBooleanToDatapool(3611, true);
            AbstractASLHsmTarget.writeBooleanToDatapool(4036, true);
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(-1075704576, messagesEditedMessageCollector.messages_edited_embedded_v_card);
    }

    public void dsiAdbVCardExchangeParseVCardResult(int n, AdbEntry[] adbEntryArray) {
        if (n == 0 && !Util.isNullOrEmpty(adbEntryArray)) {
            Object[] objectArray;
            Object[] objectArray2 = ASLPhoneFactory.getPhoneApi().ripADBAddressData(adbEntryArray[0].getAddressData());
            ListManager.getGenericASLList(461).updateList(objectArray2);
            Object[] objectArray3 = ASLPhoneFactory.getPhoneApi().ripADBPhoneData(adbEntryArray[0].getPhoneData());
            ListManager.getGenericASLList(459).updateList(objectArray3);
            DataSet[] dataSetArray = new DataSet[objectArray3.length];
            for (int i2 = 0; i2 < objectArray3.length; ++i2) {
                objectArray = objectArray3[i2];
                dataSetArray[i2] = new DataSet(-1L, -1, -1, adbEntryArray[0].getCombinedName(), new StringBuffer().append("").append(objectArray.getNumber()).toString(), -1, 1, 0, 0, 0, null, 0, 0, objectArray.getNumberType(), null);
            }
            if (!Util.isNullOrEmpty(adbEntryArray[0].getEmailData())) {
                ListManager.getGenericASLList(3612).updateList(new String[]{adbEntryArray[0].getEmailData()[0].getEmailAddr()});
            }
            Object[] objectArray4 = (MessagesSelectedMessageCollector[])ListManager.getGenericASLList(465).getDSIObjects();
            objectArray = (MessagesEditedMessageCollector[])ListManager.getGenericASLList(4037).getDSIObjects();
            objectArray4[0].messages_selected_embedded_v_card_name = adbEntryArray[0].getCombinedName();
            objectArray[0].messages_edited_embedded_v_card_name = adbEntryArray[0].getCombinedName();
            ListManager.getGenericASLList(465).updateList(objectArray4);
            ListManager.getGenericASLList(4037).updateList(objectArray);
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(3611, true);
        AbstractASLHsmTarget.writeBooleanToDatapool(4036, true);
    }

    public void dsiAdbVCardExchangeCreateVCardResult(int n, long[] lArray, int n2, String string) {
        MessageDetails messageDetails = new MessageDetails();
        AttachmentInformation attachmentInformation = new AttachmentInformation();
        attachmentInformation.mimeType = "text/x-vcard";
        attachmentInformation.attachmentPath = new ResourceLocator(string);
        ASLMessagingData.vCard = attachmentInformation;
        messageDetails.attachments = new AttachmentInformation[]{attachmentInformation};
        messageDetails.type = 3;
        this.setMessageContent(messageDetails, true, true);
    }

    public void dsiMessagingListEntriesResponse(int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        if (n2 == 0 && !this.target.isChangeFolderPending) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                arrayList.add(new MessageListItem(listEntryArray[i2], this.target.mandatoryFolderType));
            }
            ListManager.getGenericASLList(463).updateListItems(n5, arrayList.toArray());
        }
        this.target.setListToLoading(false);
    }

    public void dsiMessagingDeleteMessageResponse(int n, int n2, int n3) {
        if (n == 0) {
            this.target.sendHMIEvent(61);
        } else {
            this.target.sendHMIEvent(60);
        }
    }

    public HsmState dsiMessagingAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1004: {
                this.replyScenario = false;
                break;
            }
            default: {
                return this.getParent();
            }
        }
        return null;
    }

    public void dsiMessagingExtractInformationResponse(int n, ExtractedItem[] extractedItemArray) {
        if (n == 0) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            if (!Util.isNullOrEmpty(extractedItemArray)) {
                block4: for (int i2 = 0; i2 < extractedItemArray.length; ++i2) {
                    if (extractedItemArray[i2] == null || Util.isNullOrEmpty(extractedItemArray[i2].getValue())) continue;
                    switch (extractedItemArray[i2].getType()) {
                        case 1: {
                            linkedHashSet.add(extractedItemArray[i2].getValue());
                            continue block4;
                        }
                        case 2: {
                            linkedHashSet2.add(extractedItemArray[i2].getValue());
                            continue block4;
                        }
                    }
                }
            }
            linkedHashSet.add(this.extractedSenderNumber);
            if (!linkedHashSet.isEmpty()) {
                this.target.dsiAdbDataResolution.resolvePhoneNumbers((String[])linkedHashSet.toArray(new String[linkedHashSet.size()]));
            } else {
                ListManager.getGenericASLList(460).updateList(new DataSet[0]);
            }
            if (!linkedHashSet2.isEmpty()) {
                ListManager.getGenericASLList(3612).updateList(linkedHashSet2.toArray(new String[linkedHashSet2.size()]));
            } else {
                ListManager.getGenericASLList(3612).updateList(new String[0]);
            }
        }
    }

    public void dsiAdbDataResolutionResolvePhoneNumbersResult(int n, DataSet[] dataSetArray) {
        if (n == 0) {
            ArrayList arrayList = new ArrayList();
            boolean bl = false;
            for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
                DataSet dataSet = dataSetArray[i2];
                if (dataSet.getEntryId() <= 0L) {
                    arrayList.add(dataSet);
                    continue;
                }
                bl = false;
                for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                    if (dataSet.entryId != ((DataSet)arrayList.get((int)i3)).entryId) continue;
                    bl = true;
                    break;
                }
                if (bl) continue;
                arrayList.add(dataSet);
            }
            ListManager.getGenericASLList(460).updateList(arrayList.toArray());
        }
    }
}

