/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts.transformer;

import de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactNumberCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.AbstractPhoneContactsSelectedContactNumbersTransformer;

public class PhoneContactsSelectedContactNumbersTransformer
extends AbstractPhoneContactsSelectedContactNumbersTransformer {
    @Override
    public int getInt(int n, Object object) {
        PhoneContactsSelectedContactNumberCollector phoneContactsSelectedContactNumberCollector = (PhoneContactsSelectedContactNumberCollector)object;
        switch (n) {
            case 2: {
                return PhoneUtil.convertPhoneTypeDSI2ASLCombined(phoneContactsSelectedContactNumberCollector.phoneData.numberType);
            }
            case 5: {
                return phoneContactsSelectedContactNumberCollector.phoneData.numberType;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneContactsSelectedContactNumberCollector phoneContactsSelectedContactNumberCollector = (PhoneContactsSelectedContactNumberCollector)object;
        switch (n) {
            case 1: {
                return phoneContactsSelectedContactNumberCollector.phoneData.number;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneContactsSelectedContactNumberCollector phoneContactsSelectedContactNumberCollector = (PhoneContactsSelectedContactNumberCollector)object;
        switch (n) {
            case 3: {
                return phoneContactsSelectedContactNumberCollector.isNumberLocationUnique;
            }
            case 4: {
                return phoneContactsSelectedContactNumberCollector.isNumberTypeUnique;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

