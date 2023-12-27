/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling;
import de.vw.mib.asl.internal.messages.MessageListItem;
import de.vw.mib.asl.internal.messages.util.MessagingUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageDisplayedFolderCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesMessageSendErrorCollector;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesSelectedMessageCollector;
import java.util.ArrayList;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.FolderEntry;
import org.dsi.ifc.messaging.ListChangedInformation;
import org.dsi.ifc.messaging.ListEntry;
import org.dsi.ifc.messaging.MessagingAccount;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.messaging.StatusInformation;

public class StateMessagingInit
extends AbstractHsmState {
    private final HsmPhoneSMSHandling target;

    public StateMessagingInit(HsmPhoneSMSHandling hsmPhoneSMSHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneSMSHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                this.target.init();
                this.target.setNotification();
                ASLMessagingData.setDefaultAccount(ASLPhoneFactory.getPhoneApi().getPersistence().getDefaultMessagingAccount());
                AbstractASLHsmTarget.writeIntegerToDatapool(-1243476736, ASLMessagingData.getDefaultAccount());
                ListManager.getGenericASLList(458).updateList(new ListEntry[0]);
                this.trans(this.target.stateMessageHandling);
                break;
            }
            case 1073742203: {
                this.resetMessageCollector((MessagesSelectedMessageCollector)ListManager.getGenericASLList(465).getDSIObjects()[0]);
                this.resetMessageCollector((MessagesEditedMessageCollector)ListManager.getGenericASLList(4037).getDSIObjects()[0]);
                MessagingUtil.clearMessageRecipients();
                break;
            }
            case 1074641845: {
                if (ASLMessagingData.isTemporarySavedMessage()) break;
                this.setUsedAccount(false);
                break;
            }
            case 3600042: {
                this.target.pimMacAddress = eventGeneric.getString(0);
                this.dsiMessagingUpdateMessagingAccounts(ASLMessagingData.messagingAccountsDSI, 1);
                break;
            }
            case 3600041: {
                this.target.associatedMacAddress = eventGeneric.getString(0);
                this.dsiMessagingUpdateMessagingAccounts(ASLMessagingData.messagingAccountsDSI, 1);
                break;
            }
            case 3600043: {
                this.target.associatedSimId = eventGeneric.getString(0);
                this.dsiMessagingUpdateMessagingAccounts(ASLMessagingData.messagingAccountsDSI, 1);
                break;
            }
            case 3600025: {
                this.target.isSameDeviceConnectedViaRSAPAndMAP = eventGeneric.getBoolean(0);
                break;
            }
            case 1073742221: {
                int n = eventGeneric.getInt(0);
                this.setMessagingActive(ASLMessagingData.getMessagingAccounts()[n]);
                AbstractASLHsmTarget.writeIntegerToDatapool(-1209922304, n);
                break;
            }
            case 1074641825: {
                ASLMessagingData.setDefaultAccount(eventGeneric.getInt(0));
                ASLPhoneFactory.getPhoneApi().getPersistence().setDefaultMessagingAccount(ASLMessagingData.getDefaultAccount());
                AbstractASLHsmTarget.writeIntegerToDatapool(-1243476736, ASLMessagingData.getDefaultAccount());
                this.setUsedAccount(false);
                this.checkFullMemory();
                break;
            }
            case 1073742240: 
            case 1073742245: 
            case 1074641837: {
                this.target.spellerHsmWrite.handleEvent(eventGeneric);
                break;
            }
            case 1073742213: 
            case 1073742218: 
            case 1073742219: {
                this.target.spellerHsmNumber.handleEvent(eventGeneric);
                break;
            }
            case 107: {
                this.dsiMessagingUpdateMessagingAccounts(new MessagingAccount[0], 1);
                hsmState = this.myParent;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void resetMessageCollector(MessagesSelectedMessageCollector messagesSelectedMessageCollector) {
        messagesSelectedMessageCollector.messages_selected_embedded_v_card = false;
        messagesSelectedMessageCollector.messages_selected_embedded_v_card_name = "";
        messagesSelectedMessageCollector.messages_selected_multiple_numbers_available = false;
        messagesSelectedMessageCollector.messages_selected_name = "";
        messagesSelectedMessageCollector.messages_selected_number = "";
        messagesSelectedMessageCollector.messages_selected_number_of_messages = 0;
        messagesSelectedMessageCollector.messages_selected_number_of_signs = 0;
        messagesSelectedMessageCollector.messages_selected_phone_numbers_available = false;
        messagesSelectedMessageCollector.messages_selected_picture = null;
        messagesSelectedMessageCollector.messages_selected_text = "";
    }

    private void resetMessageCollector(MessagesEditedMessageCollector messagesEditedMessageCollector) {
        messagesEditedMessageCollector.messages_edited_embedded_v_card = false;
        messagesEditedMessageCollector.messages_edited_embedded_v_card_name = "";
        messagesEditedMessageCollector.messages_edited_multiple_numbers_available = false;
        messagesEditedMessageCollector.messages_edited_name = "";
        messagesEditedMessageCollector.messages_edited_number = "";
        messagesEditedMessageCollector.messages_edited_number_of_messages = 0;
        messagesEditedMessageCollector.messages_edited_number_of_signs = 0;
        messagesEditedMessageCollector.messages_edited_picture = null;
        messagesEditedMessageCollector.messages_edited_text = "";
    }

    private void setMessagingActive(MessagingAccount messagingAccount) {
        int n = 0;
        switch (messagingAccount.getAccountType()) {
            case 2: {
                n = 1;
                break;
            }
            case 1: {
                n = 2;
                break;
            }
            case 3: {
                n = 3;
                break;
            }
            default: {
                this.target.error("unknown accountType!");
            }
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(3974, n);
        ListManager.getGenericASLList(463).setSize(0);
        this.target.isSMSAvailable = true;
        this.target.dsiMessagingServiceConfiguration.changeFolderViewModeRequest(1);
        this.target.smsAccountId = messagingAccount.getAccountID();
        this.target.currentlyOpenedMessage = "";
        super.getClass();
        this.target.currentFolder = -3;
        super.getClass();
        this.target.currentFolderSwitching = -3;
        this.target.folderLevel = 0;
        this.target.folders = new String[]{"ROOT", "", "", "", ""};
        this.trans(this.target.stateWaitForSynch);
        boolean bl = Util.isBitSet(8, messagingAccount.getOfferedFolderTypes());
        AbstractASLHsmTarget.writeBooleanToDatapool(454, bl);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.IsOutgoingAvailable", bl);
        AbstractASLHsmTarget.writeBooleanToDatapool(451, Util.isBitSet(2, messagingAccount.getOfferedFolderTypes()));
        AbstractASLHsmTarget.writeBooleanToDatapool(453, Util.isBitSet(4, messagingAccount.getOfferedFolderTypes()));
        AbstractASLHsmTarget.writeBooleanToDatapool(455, Util.isBitSet(16, messagingAccount.getOfferedFolderTypes()));
        AbstractASLHsmTarget.writeBooleanToDatapool(452, Util.isBitSet(32, messagingAccount.getOfferedFolderTypes()));
        AbstractASLHsmTarget.writeIntegerToDatapool(449, ASLMessagingData.newMessagesSetExternal.size() + ASLMessagingData.newMessagesSetInternal.size());
        MessagingUtil.setTemporarySaved(false);
    }

    private MessagingAccount[] filterSMSAccounts(MessagingAccount[] messagingAccountArray) {
        ArrayList arrayList = new ArrayList();
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(" target.associatedMacAddress: ").append(this.target.associatedMacAddress).append(", target.associatedSimId: ").append(this.target.associatedSimId).append(" target.pimMacAddress: ").append(this.target.pimMacAddress).log();
        }
        for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
            this.target.info().append(" accounts[i].getBtDeviceAddress(): ").append(messagingAccountArray[i2].getBtDeviceAddress()).append(", accounts[i].getSimCardId() ").append(messagingAccountArray[i2].getSimCardId()).log();
            if (messagingAccountArray[i2].getSupportsSMS() == 0 || !Util.isNullOrEmpty(messagingAccountArray[i2].getBtDeviceAddress()) && !Util.isNullOrEmpty(this.target.associatedMacAddress) && messagingAccountArray[i2].getBtDeviceAddress().equalsIgnoreCase(this.target.associatedMacAddress) || !Util.isNullOrEmpty(messagingAccountArray[i2].getSimCardId()) && !Util.isNullOrEmpty(this.target.associatedSimId) && messagingAccountArray[i2].getSimCardId().equalsIgnoreCase(this.target.associatedSimId) || !Util.isNullOrEmpty(messagingAccountArray[i2].getBtDeviceAddress()) && !Util.isNullOrEmpty(this.target.associatedSimId) && !Util.isNullOrEmpty(this.target.pimMacAddress) && messagingAccountArray[i2].getBtDeviceAddress().equalsIgnoreCase(this.target.pimMacAddress)) continue;
            arrayList.add(messagingAccountArray[i2]);
        }
        return (MessagingAccount[])arrayList.toArray(new MessagingAccount[arrayList.size()]);
    }

    public void dsiMessagingUpdateSynchInProgress(boolean bl, int n) {
        if (bl) {
            // empty if block
        }
    }

    public void dsiMessagingUpdateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        ASLMessagingData.messagingAccountsDSI = messagingAccountArray;
        MessagingAccount[] messagingAccountArray2 = this.filterSMSAccounts(messagingAccountArray);
        boolean bl = false;
        if (messagingAccountArray2.length != ASLMessagingData.getMessagingAccounts().length) {
            bl = true;
            if (messagingAccountArray2.length < ASLMessagingData.getMessagingAccounts().length) {
                block0 : switch (messagingAccountArray2.length) {
                    case 0: {
                        ASLMessagingData.newMessagesSetInternal.clear();
                        ASLMessagingData.newMessagesSetExternal.clear();
                        AbstractASLHsmTarget.writeBooleanToDatapool(-1042150144, false);
                        break;
                    }
                    case 1: {
                        switch (messagingAccountArray2[0].getAccountType()) {
                            case 2: {
                                ASLMessagingData.newMessagesSetInternal.clear();
                                break block0;
                            }
                            case 1: {
                                ASLMessagingData.newMessagesSetExternal.clear();
                                break block0;
                            }
                            case 3: {
                                ASLMessagingData.newMessagesSetInternal.clear();
                                break block0;
                            }
                        }
                        this.target.error("invalid account type - it could not be detected, which messageSet is to be cleared.");
                        break;
                    }
                    default: {
                        this.target.error("account size has been reduced to something different than 0 or 1. This is not expected.");
                        break;
                    }
                }
            }
        } else {
            MessagingAccount[] messagingAccountArray3 = ASLMessagingData.getMessagingAccounts();
            for (int i2 = 0; i2 < messagingAccountArray2.length; ++i2) {
                if (messagingAccountArray2[i2].getAccountID() == messagingAccountArray3[i2].getAccountID() && messagingAccountArray2[i2].getAccountName().equals(messagingAccountArray3[i2].getAccountName()) && messagingAccountArray2[i2].getAccountType() == messagingAccountArray3[i2].getAccountType() && messagingAccountArray2[i2].getOfferedFolderTypes() == messagingAccountArray3[i2].getOfferedFolderTypes()) continue;
                bl = true;
            }
        }
        ASLMessagingData.setMessagingAccounts(messagingAccountArray2);
        if (bl) {
            AbstractASLHsmTarget.writeBooleanToDatapool(-991818496, false);
            this.target.messagesAvailable.onAvailableChanged(false);
            this.setUsedAccount(true);
            ASLMessagingData.newMessagesSetInternal.clear();
            ASLMessagingData.newMessagesSetExternal.clear();
            AbstractASLHsmTarget.writeIntegerToDatapool(449, ASLMessagingData.newMessagesSetInternal.size() + ASLMessagingData.newMessagesSetExternal.size());
        }
        this.checkFullMemory();
    }

    private void checkFullMemory() {
        int n;
        boolean bl = false;
        boolean bl2 = false;
        MessagingAccount[] messagingAccountArray = ASLMessagingData.getMessagingAccounts();
        block10: for (n = 0; n < messagingAccountArray.length; ++n) {
            if (messagingAccountArray[n].getMemoryStatus() == 0) continue;
            switch (messagingAccountArray[n].getAccountType()) {
                case 2: {
                    bl = true;
                    continue block10;
                }
                case 1: {
                    bl2 = true;
                    continue block10;
                }
                case 3: {
                    switch (messagingAccountArray[n].getMemoryStatus()) {
                        case 2: {
                            bl2 = true;
                            continue block10;
                        }
                        case 3: {
                            bl = true;
                            continue block10;
                        }
                        case 1: {
                            bl2 = true;
                            bl = true;
                            continue block10;
                        }
                    }
                    this.target.error("unexpected memory status for full memory");
                    continue block10;
                }
                default: {
                    this.target.error("unexpected account type for full memory");
                }
            }
        }
        n = 0;
        if (bl && bl2) {
            n = 3;
        } else if (bl) {
            n = 2;
        } else if (bl2) {
            n = 1;
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1092481792, n);
        if (bl || bl2) {
            this.target.sendHMIEvent(63);
            AbstractASLHsmTarget.writeBooleanToDatapool(456, true);
        } else {
            this.target.sendHMIEvent(565);
            AbstractASLHsmTarget.writeBooleanToDatapool(456, false);
        }
    }

    private void setUsedAccount(boolean bl) {
        if (ASLMessagingData.getMessagingAccounts().length == 1 && ASLMessagingData.getMessagingAccounts()[0].getSupportsSMS() != 0) {
            AbstractASLHsmTarget.writeIntegerToDatapool(-1209922304, 0);
            this.setMessagingActive(ASLMessagingData.getMessagingAccounts()[0]);
            AbstractASLHsmTarget.writeBooleanToDatapool(-1008595712, ASLMessagingData.getMessagingAccounts()[0].getAccountType() != 2);
        } else if (ASLMessagingData.getMessagingAccounts().length == 2) {
            int n = -1;
            int n2 = -1;
            MessagingAccount[] messagingAccountArray = ASLMessagingData.getMessagingAccounts();
            block4: for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                switch (messagingAccountArray[i2].getAccountType()) {
                    case 1: {
                        n = i2;
                        continue block4;
                    }
                    case 2: {
                        n2 = i2;
                        continue block4;
                    }
                    default: {
                        this.target.error(new StringBuffer().append("Unknown accountType '").append(messagingAccountArray[i2].getAccountType()).append("' for account '").append(messagingAccountArray[i2].getAccountName()).append("'").toString());
                    }
                }
            }
            AbstractASLHsmTarget.writeBooleanToDatapool(-1008595712, n != -1);
            if (n2 != -1 && n != -1) {
                if (this.target.isSameDeviceConnectedViaRSAPAndMAP) {
                    this.setMessagingActive(messagingAccountArray[n]);
                } else if (ASLMessagingData.getDefaultAccount() == 0) {
                    AbstractASLHsmTarget.writeBooleanToDatapool(-991818496, true);
                    this.target.messagesAvailable.onAvailableChanged(true);
                    this.target.isSMSAvailable = true;
                    if (bl && !this.target.pimMacAddress.equalsIgnoreCase(ASLMessagingData.getMessagingAccounts()[n2].getBtDeviceAddress())) {
                        ASLMessagingData.setDefaultAccount(2);
                        AbstractASLHsmTarget.writeIntegerToDatapool(-1243476736, 2);
                        this.setMessagingActive(ASLMessagingData.getMessagingAccounts()[n2]);
                    }
                } else if (ASLMessagingData.getDefaultAccount() == 1) {
                    this.setMessagingActive(messagingAccountArray[n]);
                    AbstractASLHsmTarget.writeIntegerToDatapool(-1209922304, n);
                } else if (ASLMessagingData.getDefaultAccount() == 2) {
                    this.setMessagingActive(messagingAccountArray[n2]);
                    AbstractASLHsmTarget.writeIntegerToDatapool(-1209922304, n2);
                } else {
                    this.target.error("invalid default account set!");
                }
            } else {
                if (n2 != -1) {
                    this.setMessagingActive(messagingAccountArray[n2]);
                } else {
                    this.target.error("Eventhough two accounts are available, no MAP account available.");
                }
                if (n != -1) {
                    this.setMessagingActive(messagingAccountArray[n]);
                } else {
                    this.target.error("Eventhough two accounts are available, no NAD account available.");
                }
            }
        } else {
            if (ASLMessagingData.getMessagingAccounts().length > 2) {
                this.target.error("More than two messaging accounts detected. Unknown State and therefore not handled");
            }
            this.target.isSMSAvailable = false;
            this.target.smsAccountId = -1;
            AbstractASLHsmTarget.writeBooleanToDatapool(-991818496, false);
            this.target.messagesAvailable.onAvailableChanged(false);
            AbstractASLHsmTarget.writeBooleanToDatapool(454, false);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.IsOutgoingAvailable", false);
            AbstractASLHsmTarget.writeBooleanToDatapool(451, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(453, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(455, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(452, false);
            AbstractASLHsmTarget.writeBooleanToDatapool(-1008595712, false);
        }
        ListManager.getGenericASLList(478).updateList(ASLMessagingData.getMessagingAccounts());
    }

    public void dsiMessagingIndicateListChanged(ListChangedInformation listChangedInformation) {
        this.target.isChangeFolderPending = false;
        switch (listChangedInformation.getReason()) {
            case 1: {
                ListManager.getGenericASLList(463).refetch(0, ListManager.getGenericASLList(463).getSize());
                return;
            }
            case 7: {
                break;
            }
            case 6: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 3: {
                break;
            }
            case 2: {
                return;
            }
            case 8: {
                return;
            }
        }
        this.target.setListToLoading(listChangedInformation.listSize > 0);
        if (this.target.folderLevel == 0 && listChangedInformation.getListSize() == 0) {
            this.target.error("no list elements for ROOT, ignoring!");
        } else {
            ListManager.getGenericASLList(463).setSize(0);
            ListManager.getGenericASLList(463).setSize(listChangedInformation.listSize);
        }
    }

    public void dsiMessagingIndicateMessageStatus(StatusInformation statusInformation) {
        for (int i2 = 0; i2 < ListManager.getGenericASLList(463).getSize(); ++i2) {
            Object object = ListManager.getGenericASLList(463).getRowItemCacheOnly(i2);
            if (!ListManager.getGenericASLList(463).isValidItem(object)) continue;
            MessageListItem messageListItem = (MessageListItem)object;
            if (messageListItem.listEntry.type != 2 || !messageListItem.listEntry.getMessageListEntry().getMessageID().equals(statusInformation.getMessageId())) continue;
            messageListItem.listEntry.getMessageListEntry().messageStatus = statusInformation.getStatus();
            ListManager.getGenericASLList(463).updateListItem(i2, object);
            break;
        }
    }

    public void dsiMessagingIndicateFolderInformation(FolderEntry folderEntry) {
    }

    public void dsiMessagingChangeFolderResponse(FolderEntry folderEntry, int n) {
        if (n == 0) {
            Object[] objectArray = (MessagesMessageDisplayedFolderCollector[])ListManager.getGenericASLList(462).getDSIObjects();
            objectArray[0].messages_displayed_folder_level = this.target.folderLevel;
            objectArray[0].messages_displayed_folder_name = this.target.folders[this.target.folderLevel];
            objectArray[0].messages_displayed_folder_type__1 = this.target.folderLevel == 1 ? this.target.mandatoryFolderType : 5;
            objectArray[0].messages_displayed_folder_updated = false;
            ListManager.getGenericASLList(462).updateList(objectArray);
            this.target.currentFolder = this.target.currentFolderSwitching;
        } else {
            this.handleFailedChangeFolderRequest();
        }
    }

    private void handleFailedChangeFolderRequest() {
        if (ASLMessagingData.getMessagingAccounts().length > 0) {
            this.target.folderLevel = this.target.previousFolderLevel;
            Object[] objectArray = (MessagesMessageDisplayedFolderCollector[])ListManager.getGenericASLList(462).getDSIObjects();
            objectArray[0].messages_displayed_folder_level = this.target.folderLevel;
            objectArray[0].messages_displayed_folder_name = this.target.folders[this.target.folderLevel];
            objectArray[0].messages_displayed_folder_type__1 = this.target.folderLevel == 1 ? this.target.mandatoryFolderType : 5;
            objectArray[0].messages_displayed_folder_updated = true;
            ListManager.getGenericASLList(462).updateList(objectArray);
            this.target.isChangeFolderPending = false;
            this.target.handleChangeFolder(-1, null, true);
            this.target.handleGetSortingFolder(5);
        }
        this.trans(this.target.stateMessageHandling);
    }

    public void dsiMessagingAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 1003: {
                this.target.sendHMIEvent(64);
                AbstractASLHsmTarget.writeBooleanToDatapool(-1042150144, false);
                break;
            }
            case 1002: {
                this.target.sendHMIEvent(60);
                break;
            }
            case 1015: {
                this.target.sendHMIEvent(-1293808384);
                break;
            }
            case 1000: {
                this.handleFailedChangeFolderRequest();
                break;
            }
        }
    }

    public void dsiMessagingDeleteSimCardMessagesResponse(int n) {
        if (n == 0) {
            this.target.sendHMIEvent(-1277031168);
        } else {
            this.target.sendHMIEvent(-1293808384);
        }
    }

    public void dsiMessagingSaveAsDraftResponse(int n, String string) {
        if (n == 0) {
            this.target.sendHMIEvent(-1193145088);
        } else {
            this.target.sendHMIEvent(-1260253952);
        }
    }

    public void dsiMessagingIndicateSendMessage(int[] nArray, int n, int n2, RecipientList recipientList, String string, String string2, AttachmentInformation[] attachmentInformationArray, int n3) {
        int n4 = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 0 || nArray[i2] == 12 || nArray[i2] == 9 || nArray[i2] == 8) continue;
            ++n4;
        }
        if (n4 == 0) {
            this.target.sendHMIEvent(65);
        } else {
            Object[] objectArray = (MessagesMessageSendErrorCollector[])ListManager.getGenericASLList(-1126036224).getDSIObjects();
            objectArray[0].messages_send_error_amount_of_messages = nArray.length;
            objectArray[0].messages_send_error_number_of_messages_with_error = n4;
            ListManager.getGenericASLList(-1126036224).updateList(objectArray);
            this.target.sendHMIEvent(64);
        }
    }

    public void dsiMessagingSendMessageResponse(int n, int n2) {
        AbstractASLHsmTarget.writeBooleanToDatapool(-1042150144, false);
        if (n != 0 && n != 12) {
            Object[] objectArray = (MessagesMessageSendErrorCollector[])ListManager.getGenericASLList(-1126036224).getDSIObjects();
            objectArray[0].messages_send_error_amount_of_messages = this.target.sentMessageCount;
            objectArray[0].messages_send_error_number_of_messages_with_error = this.target.sentMessageCount;
            ListManager.getGenericASLList(-1126036224).updateList(objectArray);
            this.target.sendHMIEvent(64);
        }
    }
}

