/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public final class LR24dc552fd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1766596939: {
                if (bl) {
                    if (n2 != 1075837853) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1401507968: {
                if (bl) {
                    if (n2 != 721347137) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 12;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 13;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 14;
                    break;
                }
                n3 = 12;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 15;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 16;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 17;
                    break;
                }
                n3 = 15;
                break;
            }
            case -385438207: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -323190118: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -261554117: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 482100946: {
                if (bl) {
                    if (n2 != -1554131600) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 928091224: {
                if (bl) {
                    if (n2 != 686300067) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1234720722: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1338529931: {
                if (bl) {
                    if (n2 != -517043040) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1346066796: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1762196499: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 2127540074: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1973323360: {
                if (bl) {
                    if (n2 != -517043040) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1320118704: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 30;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 31;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 32;
                    break;
                }
                n3 = 30;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 33;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 34;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 35;
                    break;
                }
                n3 = 33;
                break;
            }
            case -459998457: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -167625074: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -37539387: {
                if (bl) {
                    if (n2 != 1940681915) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 21970070: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 128314317: {
                if (bl) {
                    if (n2 != 1075837853) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 505998741: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 672845923: {
                if (bl) {
                    if (n2 != 1940681915) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1055083828: {
                if (bl) {
                    if (n2 != 1940681915) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1449437595: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 2131609590: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
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
            case 196104782: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 842525524: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIFastListScrollingTelephone)object).pushFunctionAvailabilityTelephone(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIFastListScrollingTelephone)object).pushMOSTOperationStateTelephone((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIFastListScrollingTelephone)object).responsePhonebook(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).intValue(), ((Number)objectArray[11]).intValue(), ((Number)objectArray[12]).intValue());
                return null;
            }
            case 3: {
                ((DSIFastListScrollingTelephone)object).responsePhonebookArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataPhonebook[])objectArray[2]);
                return null;
            }
            case 4: {
                ((DSIFastListScrollingTelephone)object).responseGetInitialsTelephone(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (DataInitials[])objectArray[4]);
                return null;
            }
            case 5: {
                ((DSIFastListScrollingTelephone)object).pushupdateFavoriteList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataFavoriteList[])objectArray[2]);
                return null;
            }
            case 6: {
                ((DSIFastListScrollingTelephone)object).pushCombinedNumbers(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataCombinedNumbers[])objectArray[2]);
                return null;
            }
            case 7: {
                ((DSIFastListScrollingTelephone)object).pushCurrentListSizeTelephone(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIFastListScrollingTelephone)object).responsePhonebookJobs(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIFastListScrollingTelephone)object).responseNotifyCombinedNumbersPush((Boolean)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIFastListScrollingTelephone)object).responseNotifyCurrentListSizes((Boolean)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIFastListScrollingTelephone)object).responseNotifyFavoriteListPush((Boolean)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIFastListScrollingTelephone)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIFastListScrollingTelephone)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIFastListScrollingTelephone)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIFastListScrollingTelephone)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIFastListScrollingTelephone)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIFastListScrollingTelephone)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIFastListScrollingNavigation)object).pushFunctionAvailabilityNavigation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIFastListScrollingNavigation)object).pushMOSTOperationStateNavigation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIFastListScrollingNavigation)object).responseNavBook(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).longValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).intValue(), ((Number)objectArray[11]).intValue(), ((Number)objectArray[12]).intValue());
                return null;
            }
            case 21: {
                ((DSIFastListScrollingNavigation)object).responseNavBookArray(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataAddress[])objectArray[2]);
                return null;
            }
            case 22: {
                ((DSIFastListScrollingNavigation)object).responseGetInitialsNavigation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (DataInitials[])objectArray[4]);
                return null;
            }
            case 23: {
                ((DSIFastListScrollingNavigation)object).pushLastDestList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataAddress[])objectArray[2]);
                return null;
            }
            case 24: {
                ((DSIFastListScrollingNavigation)object).pushUpdateFavoriteDestList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DataAddress[])objectArray[2]);
                return null;
            }
            case 25: {
                ((DSIFastListScrollingNavigation)object).pushCurrentListSizeNavigation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 26: {
                ((DSIFastListScrollingNavigation)object).responseNavBookJobs(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 27: {
                ((DSIFastListScrollingNavigation)object).responseNotifyCurrentListSizesNavigation((Boolean)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIFastListScrollingNavigation)object).responseNotifyFavoriteDestList((Boolean)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSIFastListScrollingNavigation)object).responseNotifyLastDestList((Boolean)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSIFastListScrollingNavigation)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSIFastListScrollingNavigation)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIFastListScrollingNavigation)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSIFastListScrollingNavigation)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSIFastListScrollingNavigation)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSIFastListScrollingNavigation)object).clearNotification((DSIListener)objectArray[0]);
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

