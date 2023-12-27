/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.asl.ASLTimeAndDateServiceTarget;
import de.vw.mib.log4mib.LogHeartbeatInformationProvider;
import de.vw.mib.util.StringBuilder;
import java.util.GregorianCalendar;
import java.util.TimeZone;

final class CarTimeProvider
implements LogHeartbeatInformationProvider {
    private final ASLTimeAndDateServiceTarget timeService;
    private final GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));

    CarTimeProvider(ASLTimeAndDateServiceTarget aSLTimeAndDateServiceTarget) {
        this.timeService = aSLTimeAndDateServiceTarget;
    }

    @Override
    public String getInformation(String string) {
        int[] nArray = this.timeService.getCurrentDateAndTimeAsIntArray();
        int n = nArray[0];
        int n2 = nArray[1];
        int n3 = nArray[2];
        int n4 = nArray[3];
        int n5 = nArray[4];
        int n6 = nArray[5];
        if ("car.time".equals(string)) {
            this.calendar.set(n, n2 - 1, n3, n4, n5, n6);
            return Long.toString(this.calendar.getTimeInMillis());
        }
        if ("time".equals(string)) {
            StringBuilder stringBuilder = new StringBuilder(10);
            stringBuilder.append(n).append("-");
            if (n2 < 10) {
                stringBuilder.append(0);
            }
            stringBuilder.append(n2).append("-");
            if (n3 < 10) {
                stringBuilder.append(0);
            }
            stringBuilder.append(n3);
            stringBuilder.append(" ");
            stringBuilder.append(n4).append(":");
            if (n5 < 10) {
                stringBuilder.append(0);
            }
            stringBuilder.append(n5).append(":");
            if (n6 < 10) {
                stringBuilder.append(0);
            }
            stringBuilder.append(n6);
            return stringBuilder.toString();
        }
        return "unknown";
    }
}

