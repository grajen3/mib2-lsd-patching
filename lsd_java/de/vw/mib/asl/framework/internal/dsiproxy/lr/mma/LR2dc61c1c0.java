/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.DSICalendar;
import org.dsi.ifc.calendar.DSICalendarExchange;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2dc61c1c0
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1833450899: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 5;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 6;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 7;
                    break;
                }
                n3 = 5;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 8;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 9;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 10;
                    break;
                }
                n3 = 8;
                break;
            }
            case -275250823: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 208818926: {
                if (bl) {
                    if (n2 != 1162062397) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1002895306: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2124894815: {
                if (bl) {
                    if (n2 != -591118422) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2064213275: {
                if (bl) {
                    if (n2 != 701215674) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1309951081: {
                if (bl) {
                    if (n2 != 523438510) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 21;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 22;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 23;
                    break;
                }
                n3 = 21;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 24;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 25;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 26;
                    break;
                }
                n3 = 24;
                break;
            }
            case -820932827: {
                if (bl) {
                    if (n2 != 572016507) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -514197517: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -369798261: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 410455953: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 821179027: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1334669009: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1387609476: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1948721936: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
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
            case -1064927866: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 244791619: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICalendarExchange)object).parseICal((String)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICalendarExchange)object).parseICalDirectory((String)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSICalendarExchange)object).exportICal(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (long[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 3: {
                ((DSICalendarExchange)object).importICal((ResourceLocator[])objectArray[0]);
                return null;
            }
            case 4: {
                ((DSICalendarExchange)object).abortExport();
                return null;
            }
            case 5: {
                ((DSICalendarExchange)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSICalendarExchange)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSICalendarExchange)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSICalendarExchange)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSICalendarExchange)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSICalendarExchange)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSICalendar)object).getCalendarSummaries((DateTime)objectArray[0], (DateTime)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSICalendar)object).getCalendarEntry(((Number)objectArray[0]).longValue());
                return null;
            }
            case 13: {
                ((DSICalendar)object).setCalendarConfig((CalendarConfig)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSICalendar)object).getCalendarConfig(((Number)objectArray[0]).longValue());
                return null;
            }
            case 15: {
                ((DSICalendar)object).setAlarm(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 16: {
                ((DSICalendar)object).getAlarm(((Number)objectArray[0]).longValue());
                return null;
            }
            case 17: {
                ((DSICalendar)object).getEmailAddresses(((Number)objectArray[0]).longValue());
                return null;
            }
            case 18: {
                ((DSICalendar)object).getTelephoneNumbers(((Number)objectArray[0]).longValue());
                return null;
            }
            case 19: {
                ((DSICalendar)object).insertProfile((ProfileInfo)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSICalendar)object).deleteProfile(((Number)objectArray[0]).longValue());
                return null;
            }
            case 21: {
                ((DSICalendar)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSICalendar)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSICalendar)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSICalendar)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSICalendar)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSICalendar)object).clearNotification((DSIListener)objectArray[0]);
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

