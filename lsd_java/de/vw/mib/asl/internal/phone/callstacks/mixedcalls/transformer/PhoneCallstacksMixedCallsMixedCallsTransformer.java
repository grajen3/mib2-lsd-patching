/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.callstacks.mixedcalls.transformer;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.callstacks.mixedcalls.transformer.AbstractPhoneCallstacksMixedCallsMixedCallsTransformer;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallStackEntry;

public class PhoneCallstacksMixedCallsMixedCallsTransformer
extends AbstractPhoneCallstacksMixedCallsMixedCallsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 14: {
                return callStackEntry.clHour + callStackEntry.clMinute + callStackEntry.clSecond + callStackEntry.clDay + callStackEntry.clMonth + callStackEntry.clYear > 0;
            }
            case 13: {
                return callStackEntry.adbEntryID != 0L;
            }
            case 16: {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(376) && ASLSystemFactory.getSystemApi().isTimeDateValid()) {
                    ClockDate clockDate = ASLSystemFactory.getSystemApi().getCurrentDate();
                    byte by = clockDate.getDay();
                    byte by2 = clockDate.getMonth();
                    short s = clockDate.getYear();
                    return by == callStackEntry.clDay && by2 == callStackEntry.clMonth && s == callStackEntry.clYear;
                }
                return false;
            }
            case 15: {
                return callStackEntry.getClEntryOrigin() == 1;
            }
            case 17: {
                return callStackEntry.adbPhoneDataCount > 1;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 1: {
                return phoneCallstacksCallstacksCollector.callType;
            }
            case 18: {
                return PhoneUtil.convertPhoneTypeDSI2ASLCombined(callStackEntry.getAdbNumberType());
            }
            case 19: {
                return callStackEntry.getAdbNumberType();
            }
            case 3: {
                return callStackEntry.getClDay();
            }
            case 6: {
                return callStackEntry.getClHour();
            }
            case 7: {
                return callStackEntry.getClMinute();
            }
            case 8: {
                return callStackEntry.getClMonth();
            }
            case 12: {
                return callStackEntry.getClYear();
            }
            case 5: {
                return phoneCallstacksCallstacksCollector.entryType;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public long getLong(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 4: {
                return callStackEntry.getAdbEntryID();
            }
            case 0: {
                return callStackEntry.getClEntryID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 11: {
                return callStackEntry.adbPictureID;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
        CallStackEntry callStackEntry = phoneCallstacksCallstacksCollector.callListEntry;
        switch (n) {
            case 9: {
                return !Util.isNullOrEmpty(callStackEntry.getClName()) ? callStackEntry.getClName() : (!Util.isNullOrEmpty(callStackEntry.getClNumber()) ? callStackEntry.getClNumber() : "");
            }
            case 10: {
                return !Util.isNullOrEmpty(callStackEntry.getClNumber()) ? callStackEntry.getClNumber() : "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

