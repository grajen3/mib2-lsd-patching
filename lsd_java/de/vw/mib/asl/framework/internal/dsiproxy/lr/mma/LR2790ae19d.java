/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigationListener;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephoneListener;

public final class LR2790ae19d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -428390518: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -278484208: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -264150638: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 324383932: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 663303323: {
                if (bl) {
                    if (n2 != -1575918000) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1199193125: {
                if (bl) {
                    if (n2 != -1021381169) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1814282514: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 494975663: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 700091856: {
                if (bl) {
                    if (n2 != -1021381169) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1149221862: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1268784208: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1755494598: {
                if (bl) {
                    if (n2 != -1575918000) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
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
            case -1954298584: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 2081067554: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIFastListScrollingNavigationListener)object).indicationNavBook(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).intValue());
                return null;
            }
            case 1: {
                ((DSIFastListScrollingNavigationListener)object).indicationGetInitialsNavigation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 2: {
                ((DSIFastListScrollingNavigationListener)object).indicationNotifyLastDestListPUSH((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIFastListScrollingNavigationListener)object).indicationNotifyFavoriteDestListPUSH((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIFastListScrollingNavigationListener)object).indicationNotifyCurrentListSizeNavigation((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIFastListScrollingNavigationListener)object).indicationNavBookJobs(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (ArrayHeader[])objectArray[3]);
                return null;
            }
            case 6: {
                ((DSIFastListScrollingNavigationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIFastListScrollingTelephoneListener)object).indicationPhonebook(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue(), ((Number)objectArray[10]).intValue());
                return null;
            }
            case 8: {
                ((DSIFastListScrollingTelephoneListener)object).indicationGetInitialsTelephone(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 9: {
                ((DSIFastListScrollingTelephoneListener)object).indicationNotifyFavoriteListPush((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIFastListScrollingTelephoneListener)object).indicationNotifyCombinedNumbersPush((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIFastListScrollingTelephoneListener)object).indicationNotifyCurrentListSizeTelephone((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIFastListScrollingTelephoneListener)object).indicationPhonebookJobs(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (ArrayHeader[])objectArray[3]);
                return null;
            }
            case 13: {
                ((DSIFastListScrollingTelephoneListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

