/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts.transformer;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.internal.messages.RecipientListItem;
import generated.de.vw.mib.asl.internal.messages.contacts.transformer.AbstractMessagesContactsMessageReceiverContactsTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class MessagesContactsMessageReceiverContactsTransformer
extends AbstractMessagesContactsMessageReceiverContactsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        RecipientListItem recipientListItem = (RecipientListItem)object;
        switch (n) {
            case 5: {
                return recipientListItem.entryId != 0L;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        RecipientListItem recipientListItem = (RecipientListItem)object;
        switch (n) {
            case 2: {
                return ASLPhoneFactory.getPhoneApi().convertPhoneTypeDSI2ASLCombined(recipientListItem.numberType);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        RecipientListItem recipientListItem = (RecipientListItem)object;
        switch (n) {
            case 0: {
                return recipientListItem.entryId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        RecipientListItem recipientListItem = (RecipientListItem)object;
        switch (n) {
            case 4: {
                return recipientListItem.picture;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        RecipientListItem recipientListItem = (RecipientListItem)object;
        switch (n) {
            case 3: {
                return recipientListItem.name;
            }
            case 1: {
                return recipientListItem.number;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

