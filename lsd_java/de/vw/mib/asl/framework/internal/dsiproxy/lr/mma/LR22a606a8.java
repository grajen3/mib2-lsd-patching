/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIUnifiedTunerListener;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.DSIRadioDataListener;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class LR22a606a8
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1623845056: {
                if (bl) {
                    if (n2 != -2035976393) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
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
            case -1451000933: {
                if (bl) {
                    if (n2 != -1966782441) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1394425854: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1389577139: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1126286119: {
                if (bl) {
                    if (n2 != 1802113643) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1091053153: {
                if (bl) {
                    if (n2 != 538024646) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -849602104: {
                if (bl) {
                    if (n2 != -2035976393) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -547356893: {
                if (bl) {
                    if (n2 != -1966782441) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -330579513: {
                if (bl) {
                    if (n2 != -17690485) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
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
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1280496840: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1373583656: {
                if (bl) {
                    if (n2 != -1689535898) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1611543484: {
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

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1968341586: {
                if (bl) {
                    if (n2 != -1116760129) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1945786007: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1478276987: {
                if (bl) {
                    if (n2 != -1344521301) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -785646178: {
                if (bl) {
                    if (n2 != -2087877585) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -697898668: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -284089515: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -187159786: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 102086110: {
                if (bl) {
                    if (n2 != -1548827031) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 235279220: {
                if (bl) {
                    if (n2 != -2087877585) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 387859160: {
                if (bl) {
                    if (n2 != -1116760129) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 644152607: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 829681288: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1141355893: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1305187912: {
                if (bl) {
                    if (n2 != -1001296408) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1345446358: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
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
            case 1355185234: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1442189635: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIRadioDataListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIRadioDataListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIRadioDataListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIRadioDataListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIRadioDataListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIRadioDataListener)object).responseRadioStationData((RadioStationDataResponse[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIRadioDataListener)object).responseRadioStationLogos((RadioStationLogoResponse[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIRadioDataListener)object).responseDynamicDatabaseAlteration(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIRadioDataListener)object).responseCountryList((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIRadioDataListener)object).responseDatabaseVersionInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3], ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue());
                return null;
            }
            case 10: {
                ((DSIRadioDataListener)object).updateDatabaseState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIRadioDataListener)object).responsePersistStationLogos(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIRadioDataListener)object).updateRadioStationLogos((RadioStationLogoResponse[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIRadioDataListener)object).responseCountryRegionData((CountryRegionData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIRadioDataListener)object).responseCountryRegionTranslationData((CountryRegionTranslationData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIRadioDataListener)object).responsePersistStationLogosWithChangedUrls((RadioStationData[])objectArray[0], (ResourceLocator[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 16: {
                ((DSIRadioDataListener)object).updatePersistStationLogosWithChangedUrls((RadioStationData[])objectArray[0], (ResourceLocator[])objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 17: {
                ((DSIRadioDataListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIUnifiedTunerListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIUnifiedTunerListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIUnifiedTunerListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 21: {
                ((DSIUnifiedTunerListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIUnifiedTunerListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((DSIUnifiedTunerListener)object).updateRadioText((UnifiedRadioText)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIUnifiedTunerListener)object).updateAudioStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIUnifiedTunerListener)object).updateDetectedDevice(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIUnifiedTunerListener)object).updateSlideShowInfo((DABSlideShowInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIUnifiedTunerListener)object).updateStationList((UnifiedStation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIUnifiedTunerListener)object).selectStationStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSIUnifiedTunerListener)object).updateRadioTextPlus((UnifiedRadioTextPlus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIUnifiedTunerListener)object).updateSelectedStation((UnifiedStation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSIUnifiedTunerListener)object).updateEnhancedRadioText((UnifiedRadioText)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIUnifiedTunerListener)object).updateEnhancedRadioTextPlus((UnifiedRadioTextPlus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSIUnifiedTunerListener)object).listMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 34: {
                ((DSIUnifiedTunerListener)object).stationFollowingMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSIUnifiedTunerListener)object).updateSoftLinkSwitchStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSIUnifiedTunerListener)object).updateRegModeStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSIUnifiedTunerListener)object).updateDeviceUsageStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIUnifiedTunerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

