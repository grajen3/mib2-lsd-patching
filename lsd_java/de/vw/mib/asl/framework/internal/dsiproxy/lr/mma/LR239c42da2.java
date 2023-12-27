/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBoardbook;
import org.dsi.ifc.browser.DSIBrowserBookmark;
import org.dsi.ifc.browser.PathInfo;

public final class LR239c42da2
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1513817523: {
                if (bl) {
                    if (n2 != 2088206435) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 10;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 11;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 12;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1137023890: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 13;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 14;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 15;
                    break;
                }
                n3 = 13;
                break;
            }
            case -397780031: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -220267746: {
                if (bl) {
                    if (n2 != -1806543052) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -47597962: {
                if (bl) {
                    if (n2 != 1465208930) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 250597333: {
                if (bl) {
                    if (n2 != 1974004887) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 270273919: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1031099244: {
                if (bl) {
                    if (n2 != 1465208930) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1158807295: {
                if (bl) {
                    if (n2 != 1465208930) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1275479412: {
                if (bl) {
                    if (n2 != -633848249) break;
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
            case -1960152318: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 20;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 21;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 22;
                    break;
                }
                n3 = 20;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 23;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 24;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 25;
                    break;
                }
                n3 = 23;
                break;
            }
            case -906336227: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -504771986: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
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
            case 1601809322: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1831755909: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIBrowserBookmark)object).listBookmarks((String)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIBrowserBookmark)object).addBookmark((Bookmark)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIBrowserBookmark)object).editBookmark((Bookmark)objectArray[0], (Bookmark)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIBrowserBookmark)object).deleteBookmark((Bookmark)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIBrowserBookmark)object).createFolder((Bookmark)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIBrowserBookmark)object).deleteFolder((String)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIBrowserBookmark)object).renameFolder((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIBrowserBookmark)object).exportBookmarks((PathInfo)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIBrowserBookmark)object).importBookmarks((PathInfo)objectArray[0], (Boolean)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 9: {
                ((DSIBrowserBookmark)object).getQuotaInformation();
                return null;
            }
            case 10: {
                ((DSIBrowserBookmark)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIBrowserBookmark)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIBrowserBookmark)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIBrowserBookmark)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIBrowserBookmark)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIBrowserBookmark)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIBrowserBoardbook)object).search((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIBrowserBoardbook)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIBrowserBoardbook)object).startBoardbook(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIBrowserBoardbook)object).openPage(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIBrowserBoardbook)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIBrowserBoardbook)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIBrowserBoardbook)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSIBrowserBoardbook)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIBrowserBoardbook)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIBrowserBoardbook)object).clearNotification((DSIListener)objectArray[0]);
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

