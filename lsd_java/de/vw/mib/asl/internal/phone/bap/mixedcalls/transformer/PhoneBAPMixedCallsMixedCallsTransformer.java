/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bap.mixedcalls.transformer;

import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.bap.mixedcalls.transformer.AbstractPhoneBAPMixedCallsMixedCallsTransformer;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class PhoneBAPMixedCallsMixedCallsTransformer
extends AbstractPhoneBAPMixedCallsMixedCallsTransformer {
    private static final int BIT_SIZE_OF_ENTRY_TYPE;

    @Override
    public int getInt(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 8: {
                return callStackEntry.getAdbNumberType();
            }
            case 2: {
                return callStackEntry.getClDay();
            }
            case 6: {
                return callStackEntry.getClMonth();
            }
            case 10: {
                return callStackEntry.getClYear();
            }
            case 4: {
                return callStackEntry.getClHour();
            }
            case 5: {
                return callStackEntry.getClMinute();
            }
            case 9: {
                return callStackEntry.getClSecond();
            }
            case 0: {
                return PhoneUtil.convertEntryTypeDSI2ASLCallTypeBAP(callStackEntry.getClEntryType());
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 1: {
                return callStackEntry.getClName() == null ? "" : callStackEntry.getClName();
            }
            case 7: {
                return callStackEntry.getClNumber();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 3: {
                long l = callStackEntry.getClEntryType();
                return l << 32 | (long)callStackEntry.getClEntryID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

