/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;
import org.dsi.ifc.carstopwatch.DSICarStopWatch;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public final class LR2bed69dcf
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 6;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 7;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 8;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1065546062: {
                if (bl) {
                    if (n2 != -786116603) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 9;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 10;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 11;
                    break;
                }
                n3 = 9;
                break;
            }
            case 70956595: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 579721982: {
                if (bl) {
                    if (n2 != 1090440731) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 719929890: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2052711011: {
                if (bl) {
                    if (n2 != 1090440731) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 2138335655: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1952027256: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1905619241: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1787048759: {
                if (bl) {
                    if (n2 != 1497247981) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1353459243: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1303940816: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 45;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 46;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 47;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1015049488: {
                if (bl) {
                    if (n2 != -1222954748) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1000406973: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -978506886: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 48;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 49;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 50;
                    break;
                }
                n3 = 48;
                break;
            }
            case -871462519: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -811596221: {
                if (bl) {
                    if (n2 != 1524843596) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -588801702: {
                if (bl) {
                    if (n2 != 1524843596) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -462075235: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -315866124: {
                if (bl) {
                    if (n2 != 25685098) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -264807663: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -115207419: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -106637015: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -65909631: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 503641527: {
                if (bl) {
                    if (n2 != 37335402) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 581842567: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 696193285: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 793669640: {
                if (bl) {
                    if (n2 != -1222954748) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 994861956: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1176830367: {
                if (bl) {
                    if (n2 != 773523142) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1299026894: {
                if (bl) {
                    if (n2 != -262034083) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1299100553: {
                if (bl) {
                    if (n2 != -2015438104) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1306286984: {
                if (bl) {
                    if (n2 != -262034083) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1438723217: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1448493609: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1747555350: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1815876098: {
                if (bl) {
                    if (n2 != -2015438104) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1847343740: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1943806289: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 2078952130: {
                if (bl) {
                    if (n2 != 761872838) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
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
            case -1620607825: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1260283143: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarStopWatch)object).setStopWatchFastestLapTime((StopWatchTime)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICarStopWatch)object).setStopWatchLapRating(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSICarStopWatch)object).setStopWatchLapProgress(((Number)objectArray[0]).floatValue());
                return null;
            }
            case 3: {
                ((DSICarStopWatch)object).setStopWatchLapGPSTrigger();
                return null;
            }
            case 4: {
                ((DSICarStopWatch)object).setStopWatchControl(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSICarStopWatch)object).setStopWatchSlowestLapTime((StopWatchTime)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSICarStopWatch)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSICarStopWatch)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSICarStopWatch)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSICarStopWatch)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSICarStopWatch)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSICarStopWatch)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSICarSeat)object).setSeatRadioKeyAutomatic((Boolean)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSICarSeat)object).setSeatCodriverSettingsFromRear((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSICarSeat)object).setSeatCodriverSettingsFromDriver((Boolean)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSICarSeat)object).setSeatEasyEntryFrontLeft((Boolean)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSICarSeat)object).setSeatEasyEntryFrontRight((Boolean)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSICarSeat)object).setSeatEasyEntryRearLeft((Boolean)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSICarSeat)object).setSeatEasyEntryRearRight((Boolean)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSICarSeat)object).setSeatSpecialPosition((SeatSpecialPosition)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSICarSeat)object).setSeatSpecialPositionRearCoDriver((SeatSpecialPosition)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSICarSeat)object).showSeatPopup((SeatContent)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSICarSeat)object).cancelSeatPopup((SeatContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarSeat)object).setSeatHMIIsReady((Boolean)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSICarSeat)object).setSeatPneumaticCodriverSettingsFromDriver((Boolean)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSICarSeat)object).showSeatPneumaticPopup((SeatPneumaticContent)objectArray[0]);
                return null;
            }
            case 26: {
                ((DSICarSeat)object).cancelSeatPneumaticPopup((SeatPneumaticContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarSeat)object).setSeatSetFactoryDefault();
                return null;
            }
            case 28: {
                ((DSICarSeat)object).setSeatPneumaticSetFactoryDefault();
                return null;
            }
            case 29: {
                ((DSICarSeat)object).startSeatMoveRearSeatDisplay();
                return null;
            }
            case 30: {
                ((DSICarSeat)object).abortSeatMoveRearSeatDisplay();
                return null;
            }
            case 31: {
                ((DSICarSeat)object).setSeatMassageData(((Number)objectArray[0]).intValue(), (MassageData)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarSeat)object).setSeatSwitcherDataUp(((Number)objectArray[0]).intValue(), (SwitcherDataUpDown)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSICarSeat)object).setSeatSwitcherDataDown(((Number)objectArray[0]).intValue(), (SwitcherDataUpDown)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSICarSeat)object).setSeatSwitcherDataForward(((Number)objectArray[0]).intValue(), (SwitcherDataBackForward)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSICarSeat)object).setSeatSwitcherDataBack(((Number)objectArray[0]).intValue(), (SwitcherDataBackForward)objectArray[1]);
                return null;
            }
            case 36: {
                ((DSICarSeat)object).setSeatAdjustment(((Number)objectArray[0]).intValue(), (SeatAdjustment)objectArray[1]);
                return null;
            }
            case 37: {
                ((DSICarSeat)object).startSeatDeleteSpecialPosition((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSICarSeat)object).setSeatCoDriverSettingsFromRearActivation((Boolean)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSICarSeat)object).setSeatFoldHeadRestRearDriver((Boolean)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSICarSeat)object).setSeatFoldHeadRestRearCoDriver((Boolean)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSICarSeat)object).setSeatStopButton(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 42: {
                ((DSICarSeat)object).setSeatPremiumMassageData(((Number)objectArray[0]).intValue(), (MassageData)objectArray[1]);
                return null;
            }
            case 43: {
                ((DSICarSeat)object).setSeatPremiumMassageSwitcher(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 44: {
                ((DSICarSeat)object).setSeatMassageSwitcher(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 45: {
                ((DSICarSeat)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 46: {
                ((DSICarSeat)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 47: {
                ((DSICarSeat)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSICarSeat)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 49: {
                ((DSICarSeat)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 50: {
                ((DSICarSeat)object).clearNotification((DSIListener)objectArray[0]);
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
                case 1: {
                    return this.f1(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

