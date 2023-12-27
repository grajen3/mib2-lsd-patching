/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call.dial.transformer;

import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.call.dial.transformer.AbstractPhoneCallDialShortDialMatchingNumbersTransformer;
import org.dsi.ifc.organizer.PhoneData;

public class PhoneCallDialShortDialMatchingNumbersTransformer
extends AbstractPhoneCallDialShortDialMatchingNumbersTransformer {
    @Override
    public String getString(int n, Object object) {
        PhoneData phoneData = (PhoneData)object;
        switch (n) {
            case 1: {
                return phoneData.number;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneData phoneData = (PhoneData)object;
        switch (n) {
            case 2: {
                return PhoneUtil.convertPhoneTypeDSI2ASLCombined(phoneData.getNumberType());
            }
            case 3: {
                return phoneData.getNumberType();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

