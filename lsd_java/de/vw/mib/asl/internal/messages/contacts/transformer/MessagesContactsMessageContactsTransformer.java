/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts.transformer;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactsCollector;
import generated.de.vw.mib.asl.internal.messages.contacts.transformer.AbstractMessagesContactsMessageContactsTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class MessagesContactsMessageContactsTransformer
extends AbstractMessagesContactsMessageContactsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
        switch (n) {
            case 4: {
                return messagesContactsMessageContactsCollector.dataSet.phoneCount > 1;
            }
            case 5: {
                return messagesContactsMessageContactsCollector.isSelected;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
        switch (n) {
            case 1: {
                return messagesContactsMessageContactsCollector.dataSet.generalDescription2;
            }
            case 2: {
                return messagesContactsMessageContactsCollector.dataSet.generalDescription1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
        switch (n) {
            case 0: {
                return (int)messagesContactsMessageContactsCollector.dataSet.entryId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
        switch (n) {
            case 3: {
                return messagesContactsMessageContactsCollector.dataSet.contactPicture;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
        switch (n) {
            case 6: {
                return ASLPhoneFactory.getPhoneApi().convertPhoneTypeDSI2ASLCombined(messagesContactsMessageContactsCollector.dataSet.getNumberType());
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

