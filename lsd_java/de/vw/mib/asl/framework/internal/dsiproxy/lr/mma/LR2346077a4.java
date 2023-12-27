/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;
import org.dsi.ifc.calendar.DSICalendarExchangeListener;
import org.dsi.ifc.calendar.DSICalendarListener;

public final class LR2346077a4
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1845726020: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1403906640: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1357218098: {
                if (bl) {
                    if (n2 != -785441950) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1234802616: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -730833080: {
                if (bl) {
                    if (n2 != 1794856231) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -658260595: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -569296094: {
                if (bl) {
                    if (n2 != -1800890052) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 591124560: {
                if (bl) {
                    if (n2 != 1257932268) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1321438804: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1454636898: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1732013582: {
                if (bl) {
                    if (n2 != -785441950) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -201652117: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 73964714: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1210030151: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1602408345: {
                if (bl) {
                    if (n2 != -1550975126) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
        }
        return n3;
    }

    @Override
    public int getIndex(String string, String string2, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        int n4 = RuntimeUtil.buildKey(string2);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case -1708542953: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -394394278: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICalendarListener)object).getCalendarSummariesResult(((Number)objectArray[0]).intValue(), (CalendarSummary[])objectArray[1]);
                return null;
            }
            case 1: {
                ((DSICalendarListener)object).getCalendarEntryResult(((Number)objectArray[0]).intValue(), (CalendarEntry)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSICalendarListener)object).indicateAlarm(((Number)objectArray[0]).longValue());
                return null;
            }
            case 3: {
                ((DSICalendarListener)object).setCalendarConfigResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSICalendarListener)object).getCalendarConfigResult(((Number)objectArray[0]).intValue(), (CalendarConfig)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSICalendarListener)object).setAlarmRepeatResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSICalendarListener)object).getAlarmRepeatResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 7: {
                ((DSICalendarListener)object).getEmailAddressesResult(((Number)objectArray[0]).intValue(), (String[])objectArray[1]);
                return null;
            }
            case 8: {
                ((DSICalendarListener)object).getTelephoneNumbersResult(((Number)objectArray[0]).intValue(), (String[])objectArray[1]);
                return null;
            }
            case 9: {
                ((DSICalendarListener)object).insertProfileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSICalendarListener)object).deleteProfileResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSICalendarListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSICalendarExchangeListener)object).parseICalResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSICalendarExchangeListener)object).parseICalDirectoryResult((int[])objectArray[0]);
                return null;
            }
            case 14: {
                ((DSICalendarExchangeListener)object).exportICalResult(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSICalendarExchangeListener)object).finishExportResult(((Number)objectArray[0]).intValue(), (long[])objectArray[1], ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 16: {
                ((DSICalendarExchangeListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

