/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.util;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.RecipientListItem;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactNumbersCollector;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactsCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.messages.ASLMessagesPropertyManager;
import generated.de.vw.mib.asl.internal.messages.transformer.MessagesEditedMessageCollector;
import java.util.LinkedList;

public final class MessagingUtil {
    private static LinkedList recipients = new LinkedList();

    private MessagingUtil() {
    }

    public static void addRecipient(RecipientListItem recipientListItem) {
        if (!recipientListItem.number.equals("")) {
            recipients.add(recipientListItem);
        }
        MessagingUtil.recipientsUpdated();
    }

    public static void removeRecipient(RecipientListItem recipientListItem) {
        recipients.remove(recipientListItem);
        MessagingUtil.recipientsUpdated();
    }

    public static void removeRecipient(int n) {
        recipients.remove(n);
        MessagingUtil.recipientsUpdated();
    }

    public static boolean hasRecipient(RecipientListItem recipientListItem) {
        return recipients.contains(recipientListItem);
    }

    public static int getRecipientsSize() {
        return recipients.size();
    }

    public static RecipientListItem getRecipient(int n) {
        return (RecipientListItem)recipients.get(n);
    }

    public static boolean updateAddressbookSize(int n) {
        if (n != ASLMessagingData.addressbookSize) {
            ListManager.getGenericASLList(469).setSize(0);
            ListManager.getGenericASLList(469).setSize(n);
            ASLMessagingData.addressbookSize = n;
            return true;
        }
        return false;
    }

    private static void recipientsUpdated() {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector;
        Object object;
        int n;
        MessagesEditedMessageCollector messagesEditedMessageCollector = ((MessagesEditedMessageCollector[])ListManager.getGenericASLList(4037).getDSIObjects())[0];
        if (recipients.size() == 0) {
            messagesEditedMessageCollector.messages_edited_name = "";
            messagesEditedMessageCollector.messages_edited_number = "";
            messagesEditedMessageCollector.messages_edited_picture = ASLMessagesPropertyManager.EDITED_MESSAGE__EDITED_PICTURE__DEFAULT_VALUE;
        } else {
            messagesEditedMessageCollector.messages_edited_name = ((RecipientListItem)MessagingUtil.recipients.get((int)0)).name;
            messagesEditedMessageCollector.messages_edited_number = ((RecipientListItem)MessagingUtil.recipients.get((int)0)).number;
            messagesEditedMessageCollector.messages_edited_picture = ((RecipientListItem)MessagingUtil.recipients.get((int)0)).picture;
        }
        messagesEditedMessageCollector.messages_edited_multiple_numbers_available = recipients.size() > 1;
        ListManager.getGenericASLList(4037).updateList(new MessagesEditedMessageCollector[]{messagesEditedMessageCollector});
        ListManager.getGenericASLList(-1193145088).updateList(recipients.toArray());
        AbstractASLHsmTarget.writeBooleanToDatapool(466, recipients.size() > 0);
        for (n = 0; n < ListManager.getGenericASLList(469).getItemCount(); ++n) {
            object = ListManager.getGenericASLList(469).getRowItemCacheOnly(n);
            if (!ListManager.getGenericASLList(469).isValidItem(object)) continue;
            messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
            messagesContactsMessageContactsCollector.isSelected = false;
            ListManager.getGenericASLList(469).updateListItem(messagesContactsMessageContactsCollector.dataSet.getEntryPosition(), messagesContactsMessageContactsCollector);
        }
        for (n = 0; n < ListManager.getGenericASLList(468).getItemCount(); ++n) {
            object = (MessagesContactsMessageContactNumbersCollector)ListManager.getGenericASLList(468).getRowItem(n);
            ((MessagesContactsMessageContactNumbersCollector)object).isSelected = false;
            ListManager.getGenericASLList(468).updateListItem(n, object);
        }
        for (n = 0; n < recipients.size(); ++n) {
            object = (RecipientListItem)recipients.get(n);
            if (((RecipientListItem)object).entryId == 0L) continue;
            messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)ListManager.getGenericASLList(469).getListItemByIdCacheOnly(((RecipientListItem)object).entryId);
            if (!ListManager.getGenericASLList(469).isValidItem(messagesContactsMessageContactsCollector)) continue;
            messagesContactsMessageContactsCollector.isSelected = true;
            if (messagesContactsMessageContactsCollector.dataSet.getEntryId() != ASLMessagingData.selectedContactEntryId) continue;
            for (int i2 = 0; i2 < ListManager.getGenericASLList(468).getItemCount(); ++i2) {
                MessagesContactsMessageContactNumbersCollector messagesContactsMessageContactNumbersCollector = (MessagesContactsMessageContactNumbersCollector)ListManager.getGenericASLList(468).getRowItem(i2);
                if (!messagesContactsMessageContactNumbersCollector.phoneData.number.equals(((RecipientListItem)object).number) || messagesContactsMessageContactNumbersCollector.phoneData.numberType != ((RecipientListItem)object).numberType) continue;
                messagesContactsMessageContactNumbersCollector.isSelected = true;
            }
        }
    }

    public static void clearMessageRecipients() {
        recipients.clear();
        MessagingUtil.recipientsUpdated();
    }

    public static void setTemporarySaved(boolean bl) {
        AbstractASLHsmTarget.writeBooleanToDatapool(457, bl);
        ASLMessagingData.setTemporarySavedMessage(bl);
    }
}

