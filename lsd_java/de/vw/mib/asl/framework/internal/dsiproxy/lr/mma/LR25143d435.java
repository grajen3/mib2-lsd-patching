/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.uota.DSIUotA;
import org.dsi.ifc.upnp.DSIUPNPBrowser;
import org.dsi.ifc.upnp.ListEntry;

public final class LR25143d435
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2123909908: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -2108778365: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 16;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 17;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 18;
                    break;
                }
                n3 = 16;
                break;
            }
            case -948729267: {
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
            case -176577089: {
                if (bl) {
                    if (n2 != 513082112) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -127445235: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 3481179: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 27576471: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 57653557: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 529728850: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 830218829: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 976422941: {
                if (bl) {
                    if (n2 != -750236959) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1225735319: {
                if (bl) {
                    if (n2 != -1289786057) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1328998465: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1554936191: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1994458793: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2050437005: {
                if (bl) {
                    if (n2 != 252948384) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
            case -469263693: {
                if (bl) {
                    if (n2 != -1773728034) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1149844034: {
                if (bl) {
                    if (n2 != 1541746573) break;
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
            case 1494327441: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1907859893: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIUotA)object).getAttribute(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIUotA)object).setFeature((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSIUotA)object).getFeature((String)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIUotA)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIUotA)object).setSelection(((Number)objectArray[0]).intValue(), (int[])objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIUotA)object).toggleSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIUotA)object).startDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSIUotA)object).getServerList();
                return null;
            }
            case 8: {
                ((DSIUotA)object).getUpdatePackages(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 9: {
                ((DSIUotA)object).abortDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSIUotA)object).triggerAction(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 11: {
                ((DSIUotA)object).customerDownloadFinished(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 12: {
                ((DSIUotA)object).getUpdatePackagesForDestinations(((Number)objectArray[0]).intValue(), (NavLocationWgs84[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIUotA)object).appAvailable(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).longValue());
                return null;
            }
            case 14: {
                ((DSIUotA)object).startDownloadViaApp(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIUotA)object).transferDataFromApp(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIUotA)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIUotA)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIUotA)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSIUotA)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIUotA)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIUotA)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIUPNPBrowser)object).requestList((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 23: {
                ((DSIUPNPBrowser)object).changeFolder((ListEntry[])objectArray[0]);
                return null;
            }
            case 24: {
                ((DSIUPNPBrowser)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIUPNPBrowser)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIUPNPBrowser)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIUPNPBrowser)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIUPNPBrowser)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIUPNPBrowser)object).clearNotification((DSIListener)objectArray[0]);
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

