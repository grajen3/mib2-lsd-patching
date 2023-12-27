/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.DSIDABTunerListener;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public final class LR257b0bbb5
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2034949598: {
                if (bl) {
                    if (n2 != 74293957) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1993251590: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1891955194: {
                if (bl) {
                    if (n2 != 505129260) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1699853255: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1695174621: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1682665386: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
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
            case -1274214995: {
                if (bl) {
                    if (n2 != -2057261434) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1005003296: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -896496156: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -859744951: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -844734869: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -697898668: {
                if (bl) {
                    if (n2 != -2088897351) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -679122603: {
                if (bl) {
                    if (n2 != -1599988199) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -342501656: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
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
            case -187159786: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
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
            case -5209492: {
                if (bl) {
                    if (n2 != 1525206959) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 42328579: {
                if (bl) {
                    if (n2 != 872936230) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 235279220: {
                if (bl) {
                    if (n2 != 1880443989) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
            case 263594838: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 305914443: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 546730163: {
                if (bl) {
                    if (n2 != 1502183526) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 681530342: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 781902918: {
                if (bl) {
                    if (n2 != 264929374) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 818914955: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 884871676: {
                if (bl) {
                    if (n2 != -121224653) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1026015033: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1047653157: {
                if (bl) {
                    if (n2 != -1366246895) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1145171088: {
                if (bl) {
                    if (n2 != 1471383326) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
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
            case 1226625759: {
                if (bl) {
                    if (n2 != -704460289) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1251570259: {
                if (bl) {
                    if (n2 != -171652701) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1305187912: {
                if (bl) {
                    if (n2 != -1001296408) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1653588839: {
                if (bl) {
                    if (n2 != 248457129) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1690055772: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1690869070: {
                if (bl) {
                    if (n2 != -1505778758) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1837502695: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 2124838929: {
                if (bl) {
                    if (n2 != 1927289583) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2080990568: {
                if (bl) {
                    if (n2 != 694476754) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1968341586: {
                if (bl) {
                    if (n2 != 199863146) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1863758446: {
                if (bl) {
                    if (n2 != -1055523096) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -1722892954: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -1695174621: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1518738836: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1478276987: {
                if (bl) {
                    if (n2 != -808826396) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1399664246: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1338733945: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1271035555: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -1082052471: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -859744951: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -834995589: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -680097495: {
                if (bl) {
                    if (n2 != -977708484) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -680097464: {
                if (bl) {
                    if (n2 != -977708484) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -187159786: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 102086110: {
                if (bl) {
                    if (n2 != -977708484) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 175217313: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 235279220: {
                if (bl) {
                    if (n2 != -1868348557) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 428440226: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 644152607: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 752659747: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 1009388929: {
                if (bl) {
                    if (n2 != -1441735444) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1026015033: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 1280455151: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1319582279: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 1734581628: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1998304965: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
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
            case 1492538703: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 2081843647: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIDABTunerListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIDABTunerListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIDABTunerListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIDABTunerListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIDABTunerListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIDABTunerListener)object).updateRadioText((DABRadioText)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIDABTunerListener)object).updateSyncStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIDABTunerListener)object).updateServiceList((ServiceInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIDABTunerListener)object).updateSelectedEnsemble((EnsembleInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIDABTunerListener)object).updateSelectedService((ServiceInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIDABTunerListener)object).updateSelectedComponent((ComponentInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIDABTunerListener)object).updateSelectedFrequency((FrequencyInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIDABTunerListener)object).updateEnsembleList((EnsembleInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIDABTunerListener)object).updateComponentList((ComponentInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIDABTunerListener)object).updateDataServiceList((DataServiceInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIDABTunerListener)object).updateFrequencyList((FrequencyInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIDABTunerListener)object).updateQuality((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIDABTunerListener)object).updateDRCSwitchStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIDABTunerListener)object).updateLinkingSwitchStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIDABTunerListener)object).updateFrequencyTableSwitchStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIDABTunerListener)object).updateLinkingStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIDABTunerListener)object).updateLinkingUsageStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIDABTunerListener)object).updateAudioStatus((AudioStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIDABTunerListener)object).updateDetectedDevice(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIDABTunerListener)object).updateQualityInfo((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIDABTunerListener)object).selectServiceStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSIDABTunerListener)object).seekServiceStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSIDABTunerListener)object).tuneEnsembleStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIDABTunerListener)object).selectDataServiceStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSIDABTunerListener)object).updateRadioTextPlusInfo((DABRadioTextPlusInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIDABTunerListener)object).updateDecodedDataService((DataServiceInfo)objectArray[0], (Boolean)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 31: {
                ((DSIDABTunerListener)object).forceLMUpdateStatus(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIDABTunerListener)object).prepareTuningStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSIDABTunerListener)object).updateEpgLogo((int[])objectArray[0], (ResourceLocator[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 34: {
                ((DSIDABTunerListener)object).updateEpgLogoList((EPGLogo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSIDABTunerListener)object).updateSlideShowInfo((DABSlideShowInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSIDABTunerListener)object).updateAvailability(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSIDABTunerListener)object).updateIntellitext((IntellitextMenu[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIDABTunerListener)object).updateEPGMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSIDABTunerListener)object).updateEPGListData((EPGShortInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSIDABTunerListener)object).updateEPGDetailData((EPGFullInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSIDABTunerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 42: {
                ((DSIAMFMTunerListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSIAMFMTunerListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSIAMFMTunerListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 45: {
                ((DSIAMFMTunerListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSIAMFMTunerListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 47: {
                ((DSIAMFMTunerListener)object).updateRadioText((AMFMRadioText)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSIAMFMTunerListener)object).updateLinkingUsageStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSIAMFMTunerListener)object).updateDetectedDevice(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSIAMFMTunerListener)object).prepareTuningStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 51: {
                ((DSIAMFMTunerListener)object).updateAvailability(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSIAMFMTunerListener)object).updateStationList((Station[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSIAMFMTunerListener)object).updateStationListMW((Station[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSIAMFMTunerListener)object).updateStationListLW((Station[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSIAMFMTunerListener)object).updateWavebandInfoList((WavebandInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSIAMFMTunerListener)object).updateAFSwitchStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSIAMFMTunerListener)object).updateREGSwitchStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSIAMFMTunerListener)object).tuneFrequencyStepsStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 59: {
                ((DSIAMFMTunerListener)object).selectStationStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 60: {
                ((DSIAMFMTunerListener)object).seekStationStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 61: {
                ((DSIAMFMTunerListener)object).updateRadioTextPlus((int[])objectArray[0], (String[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 62: {
                ((DSIAMFMTunerListener)object).updateSelectedStation((Station)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSIAMFMTunerListener)object).updateSelectedStationHD((Station)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSIAMFMTunerListener)object).selectFrequencyStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 65: {
                ((DSIAMFMTunerListener)object).setAMBandRangeStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 66: {
                ((DSIAMFMTunerListener)object).forceFMUpdateStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 67: {
                ((DSIAMFMTunerListener)object).updatePiIgnoreSwitchStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSIAMFMTunerListener)object).forceAMUpdateStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 69: {
                ((DSIAMFMTunerListener)object).updateRDSIgnoreSwitchStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 70: {
                ((DSIAMFMTunerListener)object).updateMESwitchStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSIAMFMTunerListener)object).updateHdStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSIAMFMTunerListener)object).updateHdMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSIAMFMTunerListener)object).updateHdStationInfo((HdStationInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSIAMFMTunerListener)object).updateElectronicSerialCode((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSIAMFMTunerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
                case 2: {
                    return this.f2(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

