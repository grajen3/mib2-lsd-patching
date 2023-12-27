/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts.transformer;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactNumbersCollector;
import generated.de.vw.mib.asl.internal.messages.contacts.transformer.AbstractMessagesContactsMessageContactNumbersTransformer;

public class MessagesContactsMessageContactNumbersTransformer
extends AbstractMessagesContactsMessageContactNumbersTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        MessagesContactsMessageContactNumbersCollector messagesContactsMessageContactNumbersCollector = (MessagesContactsMessageContactNumbersCollector)object;
        switch (n) {
            case 2: {
                return messagesContactsMessageContactNumbersCollector.isSelected;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        MessagesContactsMessageContactNumbersCollector messagesContactsMessageContactNumbersCollector = (MessagesContactsMessageContactNumbersCollector)object;
        switch (n) {
            case 3: {
                return ASLPhoneFactory.getPhoneApi().convertPhoneTypeDSI2ASLCombined(messagesContactsMessageContactNumbersCollector.phoneData.numberType);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        MessagesContactsMessageContactNumbersCollector messagesContactsMessageContactNumbersCollector = (MessagesContactsMessageContactNumbersCollector)object;
        switch (n) {
            case 1: {
                return messagesContactsMessageContactNumbersCollector.phoneData.number;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

