/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.media.DSIMediaBrowser;
import org.dsi.ifc.media.DSIMediaOnline;
import org.dsi.ifc.media.ListEntry;

public final class LR2529019f8
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2003252931: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1853865888: {
                if (bl) {
                    if (n2 != -281258669) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1637391408: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1544618126: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1544226212: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1418676066: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1418221233: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1181079698: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 19;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 20;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 21;
                    break;
                }
                n3 = 19;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 22;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 23;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 24;
                    break;
                }
                n3 = 22;
                break;
            }
            case -469263693: {
                if (bl) {
                    if (n2 != 2113417289) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 311756740: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 553492682: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 636883588: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 702372353: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 831746951: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 943402358: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 995652865: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1074207789: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1149844034: {
                if (bl) {
                    if (n2 != 1920279622) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1849362051: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 25;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 26;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 27;
                    break;
                }
                n3 = 25;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 28;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 29;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 30;
                    break;
                }
                n3 = 28;
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
            case -1517045342: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1681278979: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMediaBrowser)object).addSelection((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4]);
                return null;
            }
            case 1: {
                ((DSIMediaBrowser)object).requestList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 2: {
                ((DSIMediaBrowser)object).changeFolder((ListEntry[])objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIMediaBrowser)object).setContentFilter(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIMediaBrowser)object).setBrowseMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIMediaBrowser)object).setBrowseMedia(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 6: {
                ((DSIMediaBrowser)object).requestPickList((long[])objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIMediaBrowser)object).enableRecurseSubdirectories((Boolean)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIMediaBrowser)object).undoLastSelection();
                return null;
            }
            case 9: {
                ((DSIMediaBrowser)object).resetSelection();
                return null;
            }
            case 10: {
                ((DSIMediaBrowser)object).setSearchString((String)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIMediaBrowser)object).setSearchCriteria(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIMediaBrowser)object).activateSearchSpeller();
                return null;
            }
            case 13: {
                ((DSIMediaBrowser)object).deactivateSearchSpeller();
                return null;
            }
            case 14: {
                ((DSIMediaBrowser)object).selectSearchResult(((Number)objectArray[0]).longValue());
                return null;
            }
            case 15: {
                ((DSIMediaBrowser)object).requestSearchList(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIMediaBrowser)object).resetSearchString();
                return null;
            }
            case 17: {
                ((DSIMediaBrowser)object).requestSearchListExt(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIMediaBrowser)object).requestFullyQualifiedName(((Number)objectArray[0]).longValue());
                return null;
            }
            case 19: {
                ((DSIMediaBrowser)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIMediaBrowser)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIMediaBrowser)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIMediaBrowser)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIMediaBrowser)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIMediaBrowser)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSIMediaOnline)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIMediaOnline)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIMediaOnline)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIMediaOnline)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIMediaOnline)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIMediaOnline)object).clearNotification((DSIListener)objectArray[0]);
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

