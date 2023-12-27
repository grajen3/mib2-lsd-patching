/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car;

import de.vw.mib.asl.api.system.SystemDateUtil;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import java.util.GregorianCalendar;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carlight.TimeState;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;

public final class ASLCarUtil {
    private static TimeState myTimeState = new TimeState();
    private static int duration;
    private static GregorianCalendar myTime;
    private static final int MAX_COUNT_OF_DAYS;
    private static GregorianCalendar[] dates;
    private static ClockDate myClockDate;
    private static int counter;
    private static int[] placeHolder;
    private static boolean isPrimaryEngineCombustion;
    private static boolean isPrimaryEngineElectric;
    private static boolean isSecondaryEngineCombustion;
    private static boolean isSecondaryEngineElectric;

    private ASLCarUtil() {
    }

    public static boolean checkDurationOnOff(int n) {
        return n > 0;
    }

    public static int durationTimeMinMaxValue(boolean bl, int n, int n2, int n3, int n4) {
        duration = bl ? n + n2 : n - n2;
        if (duration >= n3 && duration <= n4) {
            return duration;
        }
        return -1;
    }

    public static int incDecValueInStepSize(boolean bl, int n, int n2) {
        if (bl) {
            return n + n2;
        }
        return n - n2;
    }

    public static int[] double2IntArray(float f2, int n) {
        int n2 = 1;
        for (int i2 = n; i2 > 0; --i2) {
            n2 *= 10;
        }
        ASLCarUtil.placeHolder[0] = (int)f2;
        ASLCarUtil.placeHolder[1] = (int)Math.abs(f2 * (float)n2 % (float)n2);
        return placeHolder;
    }

    public static int checkRequiredPressure(int n, int n2) {
        int n3 = 0;
        n3 = n == n2 ? n : (n > n2 ? n : n2);
        return n3;
    }

    public static TimeState createTimeState(int n) {
        ASLCarUtil.myTimeState.state = ASLCarUtil.checkDurationOnOff(n);
        ASLCarUtil.myTimeState.time = n;
        return myTimeState;
    }

    public static int calculateAmPm(int n) {
        if (n < 12) {
            return n += 12;
        }
        return n -= 12;
    }

    public static int parkheatingTimer1Day(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
        }
        return -1;
    }

    public static int parkheatingTimer2Day(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
        }
        return -1;
    }

    public static int parkheatingTimer3Day(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
        }
        return -1;
    }

    public static void calculateNextRange(ClockDate clockDate) {
        myTime = new GregorianCalendar(clockDate.getYear() + 2000, clockDate.getMonth() - 1, clockDate.getDay());
        for (int i2 = 0; i2 < 8; ++i2) {
            if (i2 == 0) {
                ASLCarUtil.dates[0] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
            } else {
                switch (myTime.get(7)) {
                    case 2: {
                        ASLCarUtil.dates[1] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
                        break;
                    }
                    case 3: {
                        ASLCarUtil.dates[2] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
                        break;
                    }
                    case 4: {
                        ASLCarUtil.dates[3] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
                        break;
                    }
                    case 5: {
                        ASLCarUtil.dates[4] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
                        break;
                    }
                    case 6: {
                        ASLCarUtil.dates[5] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
                        break;
                    }
                    case 7: {
                        ASLCarUtil.dates[6] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
                        break;
                    }
                    case 1: {
                        ASLCarUtil.dates[7] = new GregorianCalendar(myTime.get(1), myTime.get(2), myTime.get(5));
                        break;
                    }
                }
            }
            myTime.add(5, 1);
        }
        myTime.add(5, -1);
        ASLCarContainer.getInstance().setLastDayInWeek(myTime.get(5));
    }

    public static int getPosition(int n) {
        switch (n) {
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
            case 1: {
                return 7;
            }
        }
        return -1;
    }

    public static GregorianCalendar getDate(int n) {
        return dates[n];
    }

    public static int getDatesLength() {
        return dates.length;
    }

    public static boolean isInRange(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        if (auxHeaterCoolerTimer.getDateMode() == 3) {
            return true;
        }
        for (int i2 = 0; i2 < dates.length; ++i2) {
            if (auxHeaterCoolerTimer.getDay() != dates[i2].get(5) || auxHeaterCoolerTimer.getMonth() - 1 != dates[i2].get(2) || auxHeaterCoolerTimer.getYear() != dates[i2].get(1)) continue;
            return true;
        }
        return false;
    }

    public static boolean isBatteryControlInRange(int n, int n2, int n3) {
        for (int i2 = 0; i2 < dates.length; ++i2) {
            if (n != dates[i2].get(5) || n2 - 1 != dates[i2].get(2) || n3 + 2000 != dates[i2].get(1)) continue;
            return true;
        }
        return false;
    }

    public static boolean isCurrentDay(ClockDate clockDate, AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        return clockDate.getDay() == auxHeaterCoolerTimer.getDay() && clockDate.getMonth() == auxHeaterCoolerTimer.getMonth() && clockDate.getYear() + 2000 == auxHeaterCoolerTimer.getYear();
    }

    public static int informHMIParkHeater1Day(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        switch (ASLCarUtil.getCurrentSystemDayOfWeek(auxHeaterCoolerTimer)) {
            case 1: {
                return 7;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
        }
        return -1;
    }

    public static int informHMIParkHeater2Day(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        switch (ASLCarUtil.getCurrentSystemDayOfWeek(auxHeaterCoolerTimer)) {
            case 1: {
                return 7;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
        }
        return -1;
    }

    public static int informHMIParkHeater3Day(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        switch (ASLCarUtil.getCurrentSystemDayOfWeek(auxHeaterCoolerTimer)) {
            case 1: {
                return 7;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
        }
        return -1;
    }

    public static boolean evaluateMinuteParkheater(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        return ASLCarUtil.double2IntArray((float)((double)auxHeaterCoolerTimer.getMinute() / 10.0), 1)[1] == 5 || ASLCarUtil.double2IntArray((float)((double)auxHeaterCoolerTimer.getMinute() / 10.0), 1)[1] == 0;
    }

    public static int evaluateMinute(int n) {
        int n2 = n % 10;
        switch (n2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return n - n2;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return n + (5 - n2);
            }
        }
        if (n == 60) {
            return 55;
        }
        return n;
    }

    private static int getCurrentSystemDayOfWeek(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        ASLCarUtil.myClockDate.year = auxHeaterCoolerTimer.getYear();
        ASLCarUtil.myClockDate.month = (byte)auxHeaterCoolerTimer.getMonth();
        ASLCarUtil.myClockDate.day = (byte)auxHeaterCoolerTimer.getDay();
        return SystemDateUtil.getDayOfWeek(myClockDate);
    }

    private static int getCurrentSystemDayOfWeek(int n, int n2, int n3) {
        ASLCarUtil.myClockDate.year = (short)n;
        ASLCarUtil.myClockDate.month = (byte)n2;
        ASLCarUtil.myClockDate.day = (byte)n3;
        return SystemDateUtil.getDayOfWeek(myClockDate);
    }

    public static AuxHeaterCoolerTimer checkingTimeDayInRange(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        if (ASLCarContainer.getInstance().getLastDayInWeek() == auxHeaterCoolerTimer.getDay()) {
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() > auxHeaterCoolerTimer.getHour()) {
                return auxHeaterCoolerTimer;
            }
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() == auxHeaterCoolerTimer.getHour() && ASLCarContainer.getInstance().getMainUnitTime().getMinutes() >= auxHeaterCoolerTimer.getMinute()) {
                return auxHeaterCoolerTimer;
            }
            auxHeaterCoolerTimer.year = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 2255 : (short)dates[0].get(1));
            auxHeaterCoolerTimer.month = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 255 : (short)(dates[0].get(2) + 1));
            auxHeaterCoolerTimer.day = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 255 : (short)dates[0].get(5));
            return auxHeaterCoolerTimer;
        }
        if (ASLCarContainer.getInstance().getMainUnitDate().getDay() == auxHeaterCoolerTimer.getDay()) {
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() > auxHeaterCoolerTimer.getHour()) {
                auxHeaterCoolerTimer.year = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 2255 : (short)ASLCarUtil.getDate(n).get(1));
                auxHeaterCoolerTimer.month = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 255 : (short)(ASLCarUtil.getDate(n).get(2) + 1));
                auxHeaterCoolerTimer.day = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 255 : (short)ASLCarUtil.getDate(n).get(5));
                return auxHeaterCoolerTimer;
            }
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() == auxHeaterCoolerTimer.getHour() && ASLCarContainer.getInstance().getMainUnitTime().getMinutes() > auxHeaterCoolerTimer.getMinute()) {
                auxHeaterCoolerTimer.year = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 2255 : (short)ASLCarUtil.getDate(n).get(1));
                auxHeaterCoolerTimer.month = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 255 : (short)(ASLCarUtil.getDate(n).get(2) + 1));
                auxHeaterCoolerTimer.day = (short)(auxHeaterCoolerTimer.getDateMode() == 3 ? 255 : (short)ASLCarUtil.getDate(n).get(5));
                return auxHeaterCoolerTimer;
            }
            return auxHeaterCoolerTimer;
        }
        return auxHeaterCoolerTimer;
    }

    public static boolean checkingTimerIsInRange(int n, int n2, int n3) {
        if (dates[0].get(7) == ASLCarUtil.getDate(n3).get(7)) {
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() < n) {
                return false;
            }
            return ASLCarContainer.getInstance().getMainUnitTime().getHours() != n || ASLCarContainer.getInstance().getMainUnitTime().getMinutes() >= n2;
        }
        return true;
    }

    public static BatteryControlTimer checkingTimerIsInRangeBatteryControl(BatteryControlTimer batteryControlTimer, int n) {
        long l;
        long l2 = new GregorianCalendar(ASLCarContainer.getInstance().getMainUnitDate().getYear() + 2000, ASLCarContainer.getInstance().getMainUnitDate().getMonth() - 1, ASLCarContainer.getInstance().getMainUnitDate().getDay()).getTimeInMillis();
        if (l2 == (l = new GregorianCalendar(batteryControlTimer.getYear(), batteryControlTimer.getMonth() - 1, batteryControlTimer.getDay()).getTimeInMillis())) {
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() < batteryControlTimer.getHour()) {
                int n2 = ASLCarUtil.getPosition(ASLCarContainer.getInstance().getLastDayInWeek());
                batteryControlTimer.year = ASLCarUtil.getDate(n2).get(1) - 2000;
                batteryControlTimer.month = ASLCarUtil.getDate(n2).get(2) + 1;
                batteryControlTimer.day = ASLCarUtil.getDate(n2).get(5);
                return batteryControlTimer;
            }
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() == batteryControlTimer.getHour() && ASLCarContainer.getInstance().getMainUnitTime().getMinutes() <= batteryControlTimer.getMinute()) {
                int n3 = ASLCarUtil.getPosition(ASLCarContainer.getInstance().getLastDayInWeek());
                batteryControlTimer.year = ASLCarUtil.getDate(n).get(1) - 2000;
                batteryControlTimer.month = ASLCarUtil.getDate(n).get(2) + 1;
                batteryControlTimer.day = ASLCarUtil.getDate(n).get(5);
                return batteryControlTimer;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(batteryControlTimer.getYear(), batteryControlTimer.getMonth() - 1, batteryControlTimer.getDay());
            gregorianCalendar.add(5, 7);
            batteryControlTimer.day = gregorianCalendar.get(5);
            batteryControlTimer.month = gregorianCalendar.get(2) + 1;
            batteryControlTimer.year = gregorianCalendar.get(1) - 2000;
            return batteryControlTimer;
        }
        batteryControlTimer.year = ASLCarUtil.getDate(n).get(1) - 2000;
        batteryControlTimer.month = ASLCarUtil.getDate(n).get(2) + 1;
        batteryControlTimer.day = ASLCarUtil.getDate(n).get(5);
        if (!ASLCarUtil.checkingTimerIsInRange(batteryControlTimer.getHour(), batteryControlTimer.getMinute(), n)) {
            batteryControlTimer.year = ASLCarUtil.getDate(0).get(1) - 2000;
            batteryControlTimer.month = ASLCarUtil.getDate(0).get(2) + 1;
            batteryControlTimer.day = ASLCarUtil.getDate(0).get(5);
            return batteryControlTimer;
        }
        return batteryControlTimer;
    }

    public static boolean isSelectedTimerInSystemTimeRange(BatteryControlTimer batteryControlTimer) {
        boolean bl = false;
        long l = new GregorianCalendar(ASLCarContainer.getInstance().getMainUnitDate().getYear() + 2000, ASLCarContainer.getInstance().getMainUnitDate().getMonth() - 1, ASLCarContainer.getInstance().getMainUnitDate().getDay(), ASLCarContainer.getInstance().getMainUnitTime().getHours(), ASLCarContainer.getInstance().getMainUnitTime().getMinutes()).getTimeInMillis();
        long l2 = new GregorianCalendar(batteryControlTimer.getYear(), batteryControlTimer.getMonth() - 1, batteryControlTimer.getDay(), batteryControlTimer.getHour(), batteryControlTimer.getMinute()).getTimeInMillis();
        bl = l2 > l;
        return bl;
    }

    public static int getBatteryControlWeekday(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 6;
            }
            case 6: {
                return 7;
            }
        }
        return -1;
    }

    public static int startStopState(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 12: {
                return 12;
            }
        }
        return -1;
    }

    public static int restartStopReasons(int n) {
        switch (n) {
            case 42: {
                return 1;
            }
            case 43: {
                return 2;
            }
            case 44: {
                return 3;
            }
            case 45: {
                return 4;
            }
            case 46: {
                return 5;
            }
            case 47: {
                return 6;
            }
            case 48: {
                return 7;
            }
            case 49: {
                return 8;
            }
            case 50: {
                return 9;
            }
            case 51: {
                return 10;
            }
            case 52: {
                return 11;
            }
            case 53: {
                return 12;
            }
            case 54: {
                return 13;
            }
            case 55: {
                return 14;
            }
            case 56: {
                return 15;
            }
            case 57: {
                return 16;
            }
            case 58: {
                return 17;
            }
            case 59: {
                return 18;
            }
            case 61: {
                return 19;
            }
            case 62: {
                return 20;
            }
            case 63: {
                return 21;
            }
            case 64: {
                return 22;
            }
            case 65: {
                return 23;
            }
            case 75: {
                return 24;
            }
            case 76: {
                return 25;
            }
        }
        return 0;
    }

    public static int startStopReasons(int n) {
        switch (n) {
            case 0: {
                return 10;
            }
            case 1: {
                return 11;
            }
            case 2: {
                return 12;
            }
            case 3: {
                return 13;
            }
            case 4: {
                return 14;
            }
            case 5: {
                return 15;
            }
            case 6: {
                return 16;
            }
            case 7: {
                return 17;
            }
            case 8: {
                return 18;
            }
            case 9: {
                return 19;
            }
            case 10: {
                return 20;
            }
            case 11: {
                return 21;
            }
            case 12: {
                return 22;
            }
            case 13: {
                return 23;
            }
            case 14: {
                return 24;
            }
            case 15: {
                return 25;
            }
            case 16: {
                return 26;
            }
            case 17: {
                return 27;
            }
            case 18: {
                return 28;
            }
            case 19: {
                return 29;
            }
            case 20: {
                return 30;
            }
            case 21: {
                return 31;
            }
            case 22: {
                return 32;
            }
            case 23: {
                return 33;
            }
            case 24: {
                return 34;
            }
            case 25: {
                return 35;
            }
            case 26: {
                return 36;
            }
            case 27: {
                return 37;
            }
            case 28: {
                return 38;
            }
            case 29: {
                return 39;
            }
            case 30: {
                return 40;
            }
            case 31: {
                return 41;
            }
            case 32: {
                return 42;
            }
            case 33: {
                return 43;
            }
            case 34: {
                return 1;
            }
            case 35: {
                return 2;
            }
            case 36: {
                return 3;
            }
            case 37: {
                return 4;
            }
            case 38: {
                return 5;
            }
            case 39: {
                return 6;
            }
            case 40: {
                return 7;
            }
            case 41: {
                return 8;
            }
            case 60: {
                return 9;
            }
            case 74: {
                return 47;
            }
            case 66: {
                return 44;
            }
            case 67: {
                return 45;
            }
            case 68: {
                return 46;
            }
            case 69: {
                return 48;
            }
            case 70: {
                return 49;
            }
            case 71: {
                return 50;
            }
            case 72: {
                return 51;
            }
            case 73: {
                return 52;
            }
        }
        return 0;
    }

    public static boolean isStartStopNoticeReason(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: 
            case 38: 
            case 39: 
            case 40: 
            case 41: 
            case 48: 
            case 50: 
            case 51: 
            case 52: 
            case 54: 
            case 56: 
            case 57: 
            case 58: 
            case 59: 
            case 60: 
            case 69: 
            case 70: 
            case 71: 
            case 72: 
            case 73: 
            case 74: {
                return true;
            }
        }
        return false;
    }

    public static int toIncrease(int n) {
        if (++n == ASLCarUtil.getDatesLength()) {
            n = 0;
        }
        return n;
    }

    public static int increaseWeekDay(int n) {
        if (++n == ASLCarUtil.getDatesLength()) {
            n = 1;
        }
        return n;
    }

    public static int increaseTimer(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        if (n == ASLCarContainer.STEP_HOUR) {
            int n6 = n3 = bl2 && bl && n == ASLCarContainer.STEP_HOUR ? 11 : n3;
            if (n2 < n3) {
                n5 = n2;
                if ((n5 += n) == ASLCarContainer.HOUR_IN_MINUTES) {
                    n5 = n4;
                }
            } else {
                n5 = bl ? (bl2 ? 0 : 12) : n4;
            }
        } else {
            n5 = n2;
            if ((n5 += n) == ASLCarContainer.HOUR_IN_MINUTES) {
                n5 = n4;
            }
        }
        return n5;
    }

    public static int toDecrease(int n) {
        if (--n < 0) {
            n = ASLCarUtil.getDatesLength() - 1;
        }
        return n;
    }

    public static int decreaseWeekDay(int n) {
        if (--n < 1) {
            n = ASLCarUtil.getDatesLength() - 1;
        }
        return n;
    }

    public static int decreaseTimer(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        if (n2 > n4) {
            n5 = n2;
            n5 = !bl2 && bl && n == ASLCarContainer.STEP_HOUR && n5 == 11 ? 23 : (n5 -= n);
        } else {
            n5 = n == ASLCarContainer.STEP_HOUR ? (bl2 && bl && n == ASLCarContainer.STEP_HOUR ? 11 : n3) : 55;
        }
        return n5;
    }

    public static boolean validListValues(int[] nArray) {
        counter = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != 0) continue;
            ++counter;
        }
        return counter == nArray.length;
    }

    public static void perfomanceTrigger(int n) {
        if (ServiceManager.perfService != null) {
            ServiceManager.perfService.performanceLogMsgByID(n);
        }
    }

    public static boolean[] hexToBooleanArray(int n) {
        boolean[] blArray = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        int n2 = 0;
        if (n < 0) {
            n = 256 - n * -1;
        }
        int n3 = 0;
        int n4 = 0;
        while (n > 0) {
            n2 = n % 2;
            n /= 2;
            if (n3 != 0) {
                blArray[n4] = n2 == 1;
                ++n4;
            }
            ++n3;
        }
        return blArray;
    }

    public static int rounding(double d2) {
        int n = (int)(d2 % 10.0);
        switch (n) {
            case 1: 
            case 2: {
                return (int)(d2 - (double)n);
            }
            case 3: 
            case 4: 
            case 6: 
            case 7: {
                return (int)(d2 + (double)(5 - n));
            }
            case 8: 
            case 9: {
                return (int)(d2 + (double)(10 - n));
            }
        }
        return (int)d2;
    }

    public static double bus2hmi(int n, int n2) {
        switch (n) {
            case 0: {
                return n2 + 10;
            }
            case 1: {
                return n2 / 4 + 50;
            }
        }
        return -1.0;
    }

    public static int temperatureRangeRoundoffForHMI(int n, int n2) {
        int n3 = -1;
        switch (n) {
            case 0: {
                n3 = n2 + 100;
                if (n3 % 5 <= 0) break;
                n3 -= n3 % 5;
                break;
            }
            case 1: {
                n3 = (n2 / 4 + 50) * 10;
                break;
            }
            default: {
                n3 = -1;
            }
        }
        return n3;
    }

    public static int roundingFahrenheit(double d2) {
        if (d2 * 10.0 % 10.0 == 2.5 || d2 * 10.0 % 10.0 == 0.0) {
            if (d2 * 10.0 % 10.0 == 2.5) {
                return (int)(d2 - 0.25) * 10;
            }
            return (int)d2 * 10;
        }
        return (int)(d2 + d2 * 10.0 % 10.0 / 10.0) * 10;
    }

    public static int bringValuesIntoRange(int n, int n2, int n3) {
        int n4 = 0;
        n4 = n < n3 ? n3 : (n > n2 ? n2 : n);
        return n4;
    }

    public static int getNextActiveDay(boolean[] blArray) {
        int n;
        int n2 = dates[0].get(7);
        int n3 = n = ASLCarUtil.getHMIWeekday(n2);
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            if (n3 == blArray.length) {
                n3 = 0;
            }
            if (blArray[n3]) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public static int getHMIWeekday(int n) {
        switch (n) {
            case 1: {
                return 6;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 4;
            }
            case 7: {
                return 5;
            }
        }
        return -1;
    }

    public static int informHMIBatteryControl(int n, int n2, int n3) {
        switch (ASLCarUtil.getCurrentSystemDayOfWeek(n, n2, n3)) {
            case 1: {
                return 6;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 4;
            }
            case 7: {
                return 5;
            }
        }
        return -1;
    }

    public static void evaluatePrimaryEngineType(int n) {
        switch (n) {
            case 0: 
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 0);
                isPrimaryEngineCombustion = true;
                isPrimaryEngineElectric = false;
                break;
            }
            case 1: 
            case 6: 
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 1);
                isPrimaryEngineCombustion = true;
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 5);
                break;
            }
            case 2: 
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 4);
                isPrimaryEngineElectric = true;
                break;
            }
            default: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 0);
                isPrimaryEngineCombustion = false;
                isPrimaryEngineElectric = false;
            }
        }
    }

    public static void evaluateSecondaryEngineType(int n) {
        switch (n) {
            case 0: 
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 0);
                isSecondaryEngineCombustion = false;
                isSecondaryEngineElectric = false;
                break;
            }
            case 1: 
            case 6: 
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 1);
                isSecondaryEngineCombustion = true;
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 5);
                break;
            }
            case 2: 
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 4);
                isSecondaryEngineElectric = true;
                break;
            }
            default: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 0);
                isSecondaryEngineCombustion = false;
                isSecondaryEngineElectric = false;
            }
        }
    }

    public static boolean isHybridElectricCombustion() {
        return isPrimaryEngineElectric && isSecondaryEngineCombustion;
    }

    public static boolean isHybridCombustionElectric() {
        return isPrimaryEngineCombustion && isSecondaryEngineElectric;
    }

    public static int roundedValue(int n, int n2, boolean bl) {
        int n3 = n % 10;
        switch (n3) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (n2 == 1) {
                    return bl ? n + (bl ? 5 - n3 : n3) : n - (bl ? 5 - n3 : n3);
                }
                return bl ? n + (bl ? 10 - n3 : n3) : n - (bl ? 10 - n3 : n3);
            }
            case 5: {
                if (n2 == 1) {
                    return n;
                }
                if (n2 == 0) {
                    return bl ? n + 5 : n - 5;
                }
                return n;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                if (n2 == 1) {
                    return bl ? n + (bl ? 10 - n3 : n3 - 5) : n - (bl ? 10 - n3 : n3 - 5);
                }
                return bl ? n + (bl ? 10 - n3 : n3) : n - (bl ? 10 - n3 : n3);
            }
        }
        return n;
    }

    static {
        dates = new GregorianCalendar[8];
        myClockDate = new ClockDate();
        placeHolder = new int[2];
    }
}

