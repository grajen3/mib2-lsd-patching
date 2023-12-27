/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.util;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;
import java.util.Comparator;

final class PhoneUtil$CallStackComparator
implements Comparator {
    static final PhoneUtil$CallStackComparator INSTANCE = new PhoneUtil$CallStackComparator();

    @Override
    public int compare(Object object, Object object2) {
        int n = 0;
        try {
            PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector;
            PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector2;
            if (ASLPhoneData.getInstance().isCallstacksInverted) {
                phoneCallstacksCallstacksCollector2 = (PhoneCallstacksCallstacksCollector)object;
                phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object2;
            } else {
                phoneCallstacksCallstacksCollector2 = (PhoneCallstacksCallstacksCollector)object2;
                phoneCallstacksCallstacksCollector = (PhoneCallstacksCallstacksCollector)object;
            }
            if (phoneCallstacksCallstacksCollector2.callListEntry.getClYear() > phoneCallstacksCallstacksCollector.callListEntry.getClYear()) {
                n = 1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClYear() < phoneCallstacksCallstacksCollector.callListEntry.getClYear()) {
                n = -1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClMonth() > phoneCallstacksCallstacksCollector.callListEntry.getClMonth()) {
                n = 1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClMonth() < phoneCallstacksCallstacksCollector.callListEntry.getClMonth()) {
                n = -1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClDay() > phoneCallstacksCallstacksCollector.callListEntry.getClDay()) {
                n = 1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClDay() < phoneCallstacksCallstacksCollector.callListEntry.getClDay()) {
                n = -1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClHour() > phoneCallstacksCallstacksCollector.callListEntry.getClHour()) {
                n = 1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClHour() < phoneCallstacksCallstacksCollector.callListEntry.getClHour()) {
                n = -1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClMinute() > phoneCallstacksCallstacksCollector.callListEntry.getClMinute()) {
                n = 1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClMinute() < phoneCallstacksCallstacksCollector.callListEntry.getClMinute()) {
                n = -1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClSecond() > phoneCallstacksCallstacksCollector.callListEntry.getClSecond()) {
                n = 1;
            } else if (phoneCallstacksCallstacksCollector2.callListEntry.getClSecond() < phoneCallstacksCallstacksCollector.callListEntry.getClSecond()) {
                n = -1;
            }
        }
        catch (ClassCastException classCastException) {
            // empty catch block
        }
        return n;
    }
}

