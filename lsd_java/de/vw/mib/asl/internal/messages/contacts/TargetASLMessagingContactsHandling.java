/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.AbstractASLMessagesTarget;
import de.vw.mib.asl.internal.messages.MessageListItem;
import de.vw.mib.asl.internal.messages.RecipientListItem;
import de.vw.mib.asl.internal.messages.contacts.MessagingSearchFetcher;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactNumbersCollector;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactsCollector;
import de.vw.mib.asl.internal.messages.util.MessagingUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.messages.ASLMessagesPropertyManager;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageCollector;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.AttachmentInformation;
import org.dsi.ifc.messaging.RecipientList;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.PhoneData;

public class TargetASLMessagingContactsHandling
extends AbstractASLMessagesTarget {
    public static final int HANDLE_NOT_INITIALIZED;
    private static final int EV_ASL_INT_RESP_GET_ENTRY_RESULT;
    DSIAdbList dsiAdbList;
    DSIListener dsiAdbListListener;
    int selectedContactIndex;
    boolean singleNumberSelectedContact;
    boolean isMultipleReceivermode = false;
    protected static final int WINDOW_SIZE;
    MessageListItem selectedMessage = null;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;

    public TargetASLMessagingContactsHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5279;
    }

    protected void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLMessagingContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 1);
            this.dsiAdbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLMessagingContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLMessagingContactsHandling.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 1, this.dsiAdbListListener);
            this.addObserver(2080440384);
            this.addObserver(2113994816);
            this.addObserver(2130772032);
            this.addObserver(-502661056);
            this.addObserver(-519438272);
            this.addObserver(-2147418048);
            this.addObserver(-1531245248);
            this.addObserver(1895891008);
            this.addObserver(1828782144);
            this.addObserver(1996554304);
            GenericASLList genericASLList = ListManager.getGenericASLList(469);
            genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), new MessagingSearchFetcher(this), 10, 0);
            genericASLList.setColumn4ObjectId(0);
            genericASLList.setFetchTimeout(0);
        }
        this.alreadyRegistered = true;
    }

    private void setNotification() {
        this.dsiAdbList.setNotification(1, this.dsiAdbListListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.setNotification();
                break;
            }
            case 1073744610: {
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) break;
                MessagingUtil.clearMessageRecipients();
                break;
            }
            case 1073744609: {
                boolean bl = eventGeneric.getBoolean(0);
                if (bl) break;
                MessagingUtil.clearMessageRecipients();
                break;
            }
            case 1073742199: {
                int n = eventGeneric.getInt(0);
                this.selectedMessage = (MessageListItem)ListManager.getGenericASLList(463).getRowItem(n);
                break;
            }
            case 1073742193: {
                if (this.selectedMessage == null) break;
                MessagingUtil.clearMessageRecipients();
                MessagingUtil.addRecipient(new RecipientListItem(this.selectedMessage.listEntry.getMessageListEntry().getMatchedAddress().getAdbEntryID(), 0, this.selectedMessage.listEntry.getMessageListEntry().getMatchedAddress().getAddress(), this.selectedMessage.listEntry.getMessageListEntry().getMatchedAddress().getName(), this.selectedMessage.listEntry.getMessageListEntry().getMatchedAddress().getAdbPictureID()));
                break;
            }
            case 1073742189: {
                MessagingUtil.clearMessageRecipients();
                MessagesEditedMessageCollector messagesEditedMessageCollector = ((MessagesEditedMessageCollector[])ListManager.getGenericASLList(4037).getDSIObjects())[0];
                messagesEditedMessageCollector.messages_edited_number = "";
                messagesEditedMessageCollector.messages_edited_name = "";
                messagesEditedMessageCollector.messages_edited_picture = ASLMessagesPropertyManager.EDITED_MESSAGE__EDITED_PICTURE__DEFAULT_VALUE;
                ListManager.getGenericASLList(4037).updateList(new MessagesEditedMessageCollector[]{messagesEditedMessageCollector});
                break;
            }
            case 1073742204: {
                this.selectedContactIndex = eventGeneric.getInt(0);
                MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)ListManager.getGenericASLList(469).getRowItem(this.selectedContactIndex);
                this.singleNumberSelectedContact = !ListManager.getGenericASLList(469).getListTransformer().getBoolean(4, ListManager.getGenericASLList(469).getRowItem(this.selectedContactIndex));
                ASLMessagingData.selectedContactEntryId = messagesContactsMessageContactsCollector.dataSet.getEntryId();
                if (!this.singleNumberSelectedContact) {
                    ListManager.getGenericASLList(468).updateList(new MessagesContactsMessageContactNumbersCollector[0]);
                    this.send(ASLPhoneFactory.getPhoneApi().createSingleEntryEvent(5279, 814219520, messagesContactsMessageContactsCollector.dataSet.entryId));
                    break;
                }
                if (!messagesContactsMessageContactsCollector.isSelected) {
                    MessagingUtil.addRecipient(new RecipientListItem(messagesContactsMessageContactsCollector.dataSet.getEntryId(), messagesContactsMessageContactsCollector.dataSet.getNumberType(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription2(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription1(), messagesContactsMessageContactsCollector.dataSet.getContactPicture()));
                    break;
                }
                if (!this.isMultipleReceivermode) break;
                MessagingUtil.removeRecipient(new RecipientListItem(messagesContactsMessageContactsCollector.dataSet.getEntryId(), messagesContactsMessageContactsCollector.dataSet.getNumberType(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription2(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription1(), messagesContactsMessageContactsCollector.dataSet.getContactPicture()));
                break;
            }
            case 1073742206: {
                int n = eventGeneric.getInt(0);
                PhoneData phoneData = ((MessagesContactsMessageContactNumbersCollector)ListManager.getGenericASLList((int)468).getRowItem((int)n)).phoneData;
                MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)ListManager.getGenericASLList(469).getRowItem(this.selectedContactIndex);
                if (this.isMultipleReceivermode) {
                    if (!MessagingUtil.hasRecipient(new RecipientListItem(ASLMessagingData.selectedContactEntryId, phoneData.getNumberType(), phoneData.getNumber(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription1(), messagesContactsMessageContactsCollector.dataSet.getContactPicture()))) {
                        MessagingUtil.addRecipient(new RecipientListItem(ASLMessagingData.selectedContactEntryId, phoneData.getNumberType(), phoneData.getNumber(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription1(), messagesContactsMessageContactsCollector.dataSet.getContactPicture()));
                        ListManager.getGenericASLList(468).updateListItem(n, new MessagesContactsMessageContactNumbersCollector(phoneData, true));
                    } else {
                        MessagingUtil.removeRecipient(new RecipientListItem(ASLMessagingData.selectedContactEntryId, phoneData.getNumberType(), phoneData.getNumber(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription1(), messagesContactsMessageContactsCollector.dataSet.getContactPicture()));
                        ListManager.getGenericASLList(468).updateListItem(n, new MessagesContactsMessageContactNumbersCollector(phoneData, false));
                    }
                } else {
                    MessagingUtil.addRecipient(new RecipientListItem(ASLMessagingData.selectedContactEntryId, phoneData.getNumberType(), phoneData.getNumber(), messagesContactsMessageContactsCollector.dataSet.getGeneralDescription1(), messagesContactsMessageContactsCollector.dataSet.getContactPicture()));
                }
                MessagesContactsMessageContactNumbersCollector[] messagesContactsMessageContactNumbersCollectorArray = (MessagesContactsMessageContactNumbersCollector[])ListManager.getGenericASLList(468).getDSIObjects();
                boolean bl = false;
                for (int i2 = 0; i2 < messagesContactsMessageContactNumbersCollectorArray.length; ++i2) {
                    if (!messagesContactsMessageContactNumbersCollectorArray[i2].isSelected) continue;
                    bl = true;
                    break;
                }
                ((MessagesContactsMessageContactsCollector)ListManager.getGenericASLList((int)469).getListItemByIdCacheOnly((long)ASLMessagingData.selectedContactEntryId)).isSelected = bl;
                break;
            }
            case 1073742207: {
                AttachmentInformation[] attachmentInformationArray;
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < MessagingUtil.getRecipientsSize(); ++i3) {
                    if (MessagingUtil.getRecipient(i3) == null) continue;
                    arrayList.add(MessagingUtil.getRecipient((int)i3).number);
                }
                Object[] objectArray = arrayList.toArray();
                String[] stringArray = new String[objectArray.length];
                for (int i4 = 0; i4 < objectArray.length; ++i4) {
                    stringArray[i4] = (String)objectArray[i4];
                }
                RecipientList recipientList = new RecipientList(stringArray, null, null);
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(5279, 5273, 1632448256);
                eventGeneric2.setInt(0, 1);
                eventGeneric2.setObject(1, recipientList);
                eventGeneric2.setString(2, "");
                MessagesEditedMessageCollector messagesEditedMessageCollector = ((MessagesEditedMessageCollector[])ListManager.getGenericASLList(4037).getDSIObjects())[0];
                if (ASLMessagingData.vCard != null && messagesEditedMessageCollector.messages_edited_embedded_v_card) {
                    AttachmentInformation[] attachmentInformationArray2 = new AttachmentInformation[1];
                    attachmentInformationArray = attachmentInformationArray2;
                    attachmentInformationArray2[0] = ASLMessagingData.vCard;
                } else {
                    attachmentInformationArray = null;
                }
                eventGeneric2.setObject(3, attachmentInformationArray);
                this.send(eventGeneric2);
                break;
            }
            case 1073742208: {
                this.isMultipleReceivermode = eventGeneric.getBoolean(0);
                AbstractASLHsmTarget.writeBooleanToDatapool(467, this.isMultipleReceivermode);
                break;
            }
            case 100400: {
                if (eventGeneric.getResult() != 0) break;
                AdbEntry adbEntry = (AdbEntry)eventGeneric.getObject(1);
                PhoneData[] phoneDataArray = ASLPhoneFactory.getPhoneApi().ripADBPhoneData(adbEntry.phoneData);
                Object[] objectArray = new MessagesContactsMessageContactNumbersCollector[phoneDataArray.length];
                for (int i5 = phoneDataArray.length - 1; i5 >= 0; --i5) {
                    objectArray[i5] = new MessagesContactsMessageContactNumbersCollector(phoneDataArray[i5], MessagingUtil.hasRecipient(new RecipientListItem(adbEntry.getEntryId(), phoneDataArray[i5].getNumberType(), phoneDataArray[i5].getNumber(), adbEntry.getCombinedName(), adbEntry.getPersonalData().getContactPicture())));
                }
                ListManager.getGenericASLList(468).updateList(objectArray);
                break;
            }
            case 1074641828: {
                int n = eventGeneric.getInt(0);
                RecipientListItem recipientListItem = MessagingUtil.getRecipient(n);
                if (recipientListItem.entryId != 0L) {
                    MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)ListManager.getGenericASLList(469).getListItemByIdCacheOnly(recipientListItem.entryId);
                    if (ListManager.getGenericASLList(469).isValidItem(messagesContactsMessageContactsCollector)) {
                        messagesContactsMessageContactsCollector.isSelected = false;
                    }
                }
                MessagingUtil.removeRecipient(n);
                break;
            }
        }
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (n == 0) {
            MessagingUtil.updateAddressbookSize(n2);
            Object[] objectArray = new MessagesContactsMessageContactsCollector[dataSetArray.length];
            for (int i2 = dataSetArray.length - 1; i2 >= 0; --i2) {
                boolean bl = MessagingUtil.hasRecipient(new RecipientListItem(dataSetArray[i2].getEntryId(), dataSetArray[i2].getNumberType(), dataSetArray[i2].getGeneralDescription2(), dataSetArray[i2].getGeneralDescription1(), dataSetArray[i2].getContactPicture()));
                objectArray[i2] = new MessagesContactsMessageContactsCollector(dataSetArray[i2], bl);
            }
            if (!Util.isNullOrEmpty(dataSetArray)) {
                ListManager.getGenericASLList(469).updateListItems(dataSetArray[0].entryPosition, objectArray);
            } else {
                ListManager.getGenericASLList(469).setSize(0);
            }
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
        if (this.isTraceEnabled()) {
            this.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by getSpellerViewWindowResult").log();
        }
    }

    public void dsiAdbListGetSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        if (n == 0) {
            MessagingUtil.updateAddressbookSize(n3);
            Object[] objectArray = new MessagesContactsMessageContactsCollector[dataSetArray.length];
            for (int i2 = dataSetArray.length - 1; i2 >= 0; --i2) {
                boolean bl = MessagingUtil.hasRecipient(new RecipientListItem(dataSetArray[i2].getEntryId(), dataSetArray[i2].getNumberType(), dataSetArray[i2].getGeneralDescription2(), dataSetArray[i2].getGeneralDescription1(), dataSetArray[i2].getContactPicture()));
                objectArray[i2] = new MessagesContactsMessageContactsCollector(dataSetArray[i2], bl);
            }
            if (!Util.isNullOrEmpty(dataSetArray)) {
                ListManager.getGenericASLList(469).updateListItems(dataSetArray[0].entryPosition, objectArray);
            } else {
                ListManager.getGenericASLList(469).setSize(0);
            }
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(3230, false);
        AbstractASLHsmTarget.writeBooleanToDatapool(-1260253952, false);
        if (this.isTraceEnabled()) {
            this.trace().append("PHONE_CONTACTS_IS_CONTACT_LIST_LOADING set to false by getSpellerViewWindowResult").log();
        }
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        if (adbViewSize != null) {
            MessagingUtil.updateAddressbookSize(adbViewSize.phone);
            ASLMessagingData.viewSizeContacts = adbViewSize;
        }
    }

    public void dsiAdbListInvalidData(int n) {
        if (ASLMessagingData.viewSizeContacts != null) {
            MessagingUtil.updateAddressbookSize(0);
            MessagingUtil.updateAddressbookSize(ASLMessagingData.viewSizeContacts.phone);
        }
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

