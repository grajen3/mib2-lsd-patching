/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.uota.DSIUotAListener;
import org.dsi.ifc.uota.PackageInfo;
import org.dsi.ifc.upnp.DSIUPNPBrowserListener;
import org.dsi.ifc.upnp.ListEntry;

public final class LR2fe1f0bd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2079175651: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -464074378: {
                if (bl) {
                    if (n2 != -1785378338) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1438986996: {
                if (bl) {
                    if (n2 != -1785378338) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1610756507: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -2123909908: {
                if (bl) {
                    if (n2 != -785441950) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -2108778365: {
                if (bl) {
                    if (n2 != -1008715669) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1555128024: {
                if (bl) {
                    if (n2 != -2051937305) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1460794344: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1206864845: {
                if (bl) {
                    if (n2 != -428838847) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1059128242: {
                if (bl) {
                    if (n2 != -1008715669) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -127445235: {
                if (bl) {
                    if (n2 != 1160087040) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -31823595: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 830218829: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1105453716: {
                if (bl) {
                    if (n2 != 270115921) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1173628168: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1225735319: {
                if (bl) {
                    if (n2 != 270115921) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1328998465: {
                if (bl) {
                    if (n2 != 270115921) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1554936191: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 2050437005: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
            case -2144932507: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -1327789431: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIUPNPBrowserListener)object).updateBrowseFolder((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIUPNPBrowserListener)object).updateListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIUPNPBrowserListener)object).responseList((ListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIUPNPBrowserListener)object).invalidBrowsePath();
                return null;
            }
            case 4: {
                ((DSIUPNPBrowserListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIUotAListener)object).toggleSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (int[])objectArray[2]);
                return null;
            }
            case 6: {
                ((DSIUotAListener)object).startDownload(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIUotAListener)object).getServerList(((Number)objectArray[0]).intValue(), (String[])objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIUotAListener)object).getUpdatePackages(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (PackageInfo[])objectArray[2], (int[])objectArray[3]);
                return null;
            }
            case 9: {
                ((DSIUotAListener)object).abortDownload(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIUotAListener)object).triggerAction(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 11: {
                ((DSIUotAListener)object).customerDownloadFinished(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIUotAListener)object).getUpdatePackagesForDestinations(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (PackageInfo[])objectArray[2], (int[])objectArray[3]);
                return null;
            }
            case 13: {
                ((DSIUotAListener)object).updateDownloadState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIUotAListener)object).updateDownloadProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 15: {
                ((DSIUotAListener)object).updatePackagesAvailable(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIUotAListener)object).featureResult((String)objectArray[0], ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 17: {
                ((DSIUotAListener)object).attributeResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 18: {
                ((DSIUotAListener)object).updateServcieReady(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSIUotAListener)object).getUpdatePackagesViaApp(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (PackageInfo[])objectArray[2], (int[])objectArray[3]);
                return null;
            }
            case 20: {
                ((DSIUotAListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

