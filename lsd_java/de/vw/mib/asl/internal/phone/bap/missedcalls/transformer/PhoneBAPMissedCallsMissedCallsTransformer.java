/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bap.missedcalls.transformer;

import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;
import generated.de.vw.mib.asl.internal.phone.bap.missedcalls.transformer.AbstractPhoneBAPMissedCallsMissedCallsTransformer;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class PhoneBAPMissedCallsMissedCallsTransformer
extends AbstractPhoneBAPMissedCallsMissedCallsTransformer {
    @Override
    public int getInt(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 7: {
                return callStackEntry.getAdbNumberType();
            }
            case 4: {
                return callStackEntry.getClDay();
            }
            case 5: {
                return callStackEntry.getClMonth();
            }
            case 9: {
                return callStackEntry.getClYear();
            }
            case 2: {
                return callStackEntry.getClHour();
            }
            case 3: {
                return callStackEntry.getClMinute();
            }
            case 8: {
                return callStackEntry.getClSecond();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 0: {
                return callStackEntry.getClName() == null ? "" : callStackEntry.getClName();
            }
            case 6: {
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
            case 1: {
                return callStackEntry.getClEntryID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

