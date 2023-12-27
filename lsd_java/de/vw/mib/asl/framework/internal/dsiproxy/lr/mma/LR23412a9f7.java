/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowser;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.DSIAndroidAuto;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;
import org.dsi.ifc.base.DSIListener;

public final class LR23412a9f7
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 7;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 8;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 9;
                    break;
                }
                n3 = 7;
                break;
            }
            case -948729267: {
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
            case -643729347: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 20833921: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1048150480: {
                if (bl) {
                    if (n2 != 931194510) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1305053385: {
                if (bl) {
                    if (n2 != 1661976155) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1777707422: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1849707112: {
                if (bl) {
                    if (n2 != -1399607841) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1984785306: {
                if (bl) {
                    if (n2 != 1661976155) break;
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
            case -1876433473: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 27;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 28;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 29;
                    break;
                }
                n3 = 27;
                break;
            }
            case -452630661: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -347652724: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 3541623: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 120248301: {
                if (bl) {
                    if (n2 != 739712016) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 187504968: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 542469767: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1045227004: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1531286619: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1897848957: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 2054964766: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
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
            case -1571517095: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1109770609: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAndroidAuto)object).startService((ServiceConfiguration)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIAndroidAuto)object).postButtonEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIAndroidAuto)object).postTouchEvent(((Number)objectArray[0]).intValue(), (TouchEvent[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 3: {
                ((DSIAndroidAuto)object).postRotaryEvent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIAndroidAuto)object).setMode((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIAndroidAuto)object).responseModeChange((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIAndroidAuto)object).requestNightMode((Boolean)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIAndroidAuto)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIAndroidAuto)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIAndroidAuto)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIAndroidAuto)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIAndroidAuto)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIAndroidAuto)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIAlbumBrowser)object).stop();
                return null;
            }
            case 14: {
                ((DSIAlbumBrowser)object).initializeBrowser(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIAlbumBrowser)object).deinitializeBrowser();
                return null;
            }
            case 16: {
                ((DSIAlbumBrowser)object).startSingle();
                return null;
            }
            case 17: {
                ((DSIAlbumBrowser)object).startPreview();
                return null;
            }
            case 18: {
                ((DSIAlbumBrowser)object).startActive();
                return null;
            }
            case 19: {
                ((DSIAlbumBrowser)object).setScrollMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIAlbumBrowser)object).scrollTicks(((Number)objectArray[0]).longValue());
                return null;
            }
            case 21: {
                ((DSIAlbumBrowser)object).selectAlbum(((Number)objectArray[0]).longValue());
                return null;
            }
            case 22: {
                ((DSIAlbumBrowser)object).moveFocus(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIAlbumBrowser)object).albumIdxForFID(((Number)objectArray[0]).longValue());
                return null;
            }
            case 24: {
                ((DSIAlbumBrowser)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIAlbumBrowser)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIAlbumBrowser)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIAlbumBrowser)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIAlbumBrowser)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIAlbumBrowser)object).clearNotification((DSIListener)objectArray[0]);
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

