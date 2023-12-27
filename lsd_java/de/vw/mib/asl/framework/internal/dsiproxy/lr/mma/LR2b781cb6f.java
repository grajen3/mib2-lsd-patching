/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.albumbrowser.AlbumEntryInfo;
import org.dsi.ifc.albumbrowser.DSIAlbumBrowserListener;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.DSIAndroidAutoListener;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2b781cb6f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2091754089: {
                if (bl) {
                    if (n2 != -1797146216) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1817560945: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
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
            case -1452453257: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1024892169: {
                if (bl) {
                    if (n2 != 1125460870) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -989177285: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -982786206: {
                if (bl) {
                    if (n2 != -751561115) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -95488990: {
                if (bl) {
                    if (n2 != -1924501671) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -63251488: {
                if (bl) {
                    if (n2 != -752819116) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 148365439: {
                if (bl) {
                    if (n2 != -1010989258) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 945646070: {
                if (bl) {
                    if (n2 != 1427760290) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1984785306: {
                if (bl) {
                    if (n2 != 1045778532) break;
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
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1383268792: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1217604050: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -648558311: {
                if (bl) {
                    if (n2 != -1803110358) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 187504968: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 769985575: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 860084677: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1531286619: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
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
            case -1326928541: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1395954221: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAndroidAutoListener)object).setMode((Resource[])objectArray[0], (AppState[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSIAndroidAutoListener)object).requestModeChange((ResourceRequest[])objectArray[0], (AppStateRequest[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 2: {
                ((DSIAndroidAutoListener)object).updateCallState((CallState[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIAndroidAutoListener)object).updateTelephonyState((TelephonyState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIAndroidAutoListener)object).updateNowPlayingData((TrackData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIAndroidAutoListener)object).updatePlaybackState((PlaybackInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIAndroidAutoListener)object).updatePlayposition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIAndroidAutoListener)object).updateCoverArtUrl((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIAndroidAutoListener)object).updateNavigationNextTurnEvent((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 9: {
                ((DSIAndroidAutoListener)object).updateNavigationNextTurnDistance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIAndroidAutoListener)object).setExternalDestination(((Number)objectArray[0]).doubleValue(), ((Number)objectArray[1]).doubleValue(), (String)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 11: {
                ((DSIAndroidAutoListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIAlbumBrowserListener)object).selectAlbum(((Number)objectArray[0]).longValue());
                return null;
            }
            case 13: {
                ((DSIAlbumBrowserListener)object).albumIdxForFID(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 14: {
                ((DSIAlbumBrowserListener)object).updateBrowserState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIAlbumBrowserListener)object).updateFocusedEntry((AlbumEntryInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIAlbumBrowserListener)object).updateListPosition(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIAlbumBrowserListener)object).updateNumEntries(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIAlbumBrowserListener)object).updateScrollMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIAlbumBrowserListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

