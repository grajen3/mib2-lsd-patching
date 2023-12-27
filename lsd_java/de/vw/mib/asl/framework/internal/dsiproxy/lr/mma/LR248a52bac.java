/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.connectedradio.DSIHybridRadioListener;
import org.dsi.ifc.connectedradio.DSIOnlineRadioListener;
import org.dsi.ifc.connectedradio.RadioStation;

public final class LR248a52bac
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1717729643: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1482653941: {
                if (bl) {
                    if (n2 != -1095261647) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -501956189: {
                if (bl) {
                    if (n2 != -1095261647) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 723252396: {
                if (bl) {
                    if (n2 != 1708181102) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1158474159: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -817757233: {
                if (bl) {
                    if (n2 != -1019722137) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 119707550: {
                if (bl) {
                    if (n2 != -1095261647) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 153155752: {
                if (bl) {
                    if (n2 != -1095261647) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 235279220: {
                if (bl) {
                    if (n2 != -1097252031) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 409965530: {
                if (bl) {
                    if (n2 != -1097252031) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 723252396: {
                if (bl) {
                    if (n2 != -1019722137) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 779460511: {
                if (bl) {
                    if (n2 != 471867946) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1113162578: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1246994430: {
                if (bl) {
                    if (n2 != -1095261647) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
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
            case -2006380348: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1854553651: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIOnlineRadioListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIOnlineRadioListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIOnlineRadioListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIOnlineRadioListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIOnlineRadioListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIOnlineRadioListener)object).getRadioStationLogoResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 6: {
                ((DSIOnlineRadioListener)object).getStreamUrlResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation)objectArray[2]);
                return null;
            }
            case 7: {
                ((DSIOnlineRadioListener)object).getMetaInformationResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation)objectArray[2]);
                return null;
            }
            case 8: {
                ((DSIOnlineRadioListener)object).downloadDatabaseResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIOnlineRadioListener)object).cancelDownloadDatabaseResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIOnlineRadioListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSIHybridRadioListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIHybridRadioListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIHybridRadioListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSIHybridRadioListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIHybridRadioListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIHybridRadioListener)object).getRadioStationLogoResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 17: {
                ((DSIHybridRadioListener)object).getOnlineRadioAvailabilityResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation[])objectArray[2]);
                return null;
            }
            case 18: {
                ((DSIHybridRadioListener)object).indicateRadioStationLogoResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 19: {
                ((DSIHybridRadioListener)object).getStreamResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation)objectArray[2]);
                return null;
            }
            case 20: {
                ((DSIHybridRadioListener)object).startSlideshowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation)objectArray[2]);
                return null;
            }
            case 21: {
                ((DSIHybridRadioListener)object).stopSlideshowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (RadioStation)objectArray[2]);
                return null;
            }
            case 22: {
                ((DSIHybridRadioListener)object).updateSlideshow(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((DSIHybridRadioListener)object).updateRadioText(((Number)objectArray[0]).intValue(), (RadioStation)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 24: {
                ((DSIHybridRadioListener)object).cancelGetRadioStationLogoResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIHybridRadioListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

