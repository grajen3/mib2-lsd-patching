/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.transformer;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import generated.de.vw.mib.asl.internal.messages.transformer.AbstractMessagesExtractedContactNumbersTransformer;
import org.dsi.ifc.organizer.PhoneData;

public class MessagesExtractedContactNumbersTransformer
extends AbstractMessagesExtractedContactNumbersTransformer {
    @Override
    public String getString(int n, Object object) {
        PhoneData phoneData = (PhoneData)object;
        switch (n) {
            case 1: {
                return phoneData.getNumber();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneData phoneData = (PhoneData)object;
        switch (n) {
            case 2: {
                return ASLPhoneFactory.getPhoneApi().convertPhoneTypeDSI2ASLCombined(phoneData.getNumberType());
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

