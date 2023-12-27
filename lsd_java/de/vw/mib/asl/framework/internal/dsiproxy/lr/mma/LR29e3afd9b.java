/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.DSISDARSSeekListener;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public final class LR29e3afd9b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2036267370: {
                if (bl) {
                    if (n2 != -2042065314) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
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
            case -1478276987: {
                if (bl) {
                    if (n2 != -1821948036) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1273043613: {
                if (bl) {
                    if (n2 != -2003753845) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1271501398: {
                if (bl) {
                    if (n2 != 1126364086) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1160921258: {
                if (bl) {
                    if (n2 != 1800982930) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -834995589: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -722964949: {
                if (bl) {
                    if (n2 != -55773823) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -545530726: {
                if (bl) {
                    if (n2 != -810426608) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -539305658: {
                if (bl) {
                    if (n2 != -211758354) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -520083147: {
                if (bl) {
                    if (n2 != 1800982930) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
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
            case -230173279: {
                if (bl) {
                    if (n2 != 1800982930) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -187159786: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -161868175: {
                if (bl) {
                    if (n2 != -1703653079) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
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
            case 102086110: {
                if (bl) {
                    if (n2 != 21361827) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
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
            case 322044001: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 346276493: {
                if (bl) {
                    if (n2 != 647673748) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 488077910: {
                if (bl) {
                    if (n2 != 2021106533) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 534202438: {
                if (bl) {
                    if (n2 != 1313422749) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 644152607: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1026015033: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
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
            case 1416559358: {
                if (bl) {
                    if (n2 != 1800982930) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1439225123: {
                if (bl) {
                    if (n2 != -710074599) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1653772065: {
                if (bl) {
                    if (n2 != 1800982930) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
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
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1278855285: {
                if (bl) {
                    if (n2 != -1609965898) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1216837009: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -825906895: {
                if (bl) {
                    if (n2 != 1330010385) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -165589101: {
                if (bl) {
                    if (n2 != 1201785706) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 50460313: {
                if (bl) {
                    if (n2 != -1581538634) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 494807687: {
                if (bl) {
                    if (n2 != 753230955) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 1560244928: {
                if (bl) {
                    if (n2 != 1318360081) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1866186132: {
                if (bl) {
                    if (n2 != 694158163) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 2007093616: {
                if (bl) {
                    if (n2 != -1786763117) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 2083645923: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
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
            case -787903045: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1742308361: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISDARSTunerListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSISDARSTunerListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSISDARSTunerListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSISDARSTunerListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSISDARSTunerListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSISDARSTunerListener)object).updateDetectedDevice(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSISDARSTunerListener)object).updateAvailability(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSISDARSTunerListener)object).updateStationList((StationInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSISDARSTunerListener)object).selectStationStatus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSISDARSTunerListener)object).updateSelectedStation((StationInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSISDARSTunerListener)object).updateElectronicSerialCode((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSISDARSTunerListener)object).updateServiceStatus3((ServiceStatus3)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSISDARSTunerListener)object).updateSignalQuality((SignalQuality)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSISDARSTunerListener)object).updateCategoryList((CategoryInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSISDARSTunerListener)object).informationRadioText((RadioText)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSISDARSTunerListener)object).informationRadioText2((RadioText[])objectArray[0]);
                return null;
            }
            case 16: {
                ((DSISDARSTunerListener)object).updateStaticTaggingInfo((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 17: {
                ((DSISDARSTunerListener)object).responseTime((DateTime)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSISDARSTunerListener)object).responseEPG24Hour((EPGShortInfo)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSISDARSTunerListener)object).responseEPGDescription((EPGDescription)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSISDARSTunerListener)object).updateStationDescription((StationDescription[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSISDARSTunerListener)object).updateSubscriptionStatus((SubscriptionStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSISDARSTunerListener)object).informationEPGChannelList((EPGShortInfo[])objectArray[0]);
                return null;
            }
            case 23: {
                ((DSISDARSTunerListener)object).informationChannelArt((ImageInformation[])objectArray[0]);
                return null;
            }
            case 24: {
                ((DSISDARSTunerListener)object).informationBackgroundArt((ImageInformation[])objectArray[0]);
                return null;
            }
            case 25: {
                ((DSISDARSTunerListener)object).informationAlbumArt((ImageInformation[])objectArray[0]);
                return null;
            }
            case 26: {
                ((DSISDARSTunerListener)object).informationGenreArt((ImageInformation[])objectArray[0]);
                return null;
            }
            case 27: {
                ((DSISDARSTunerListener)object).informationStudioArt((ImageInformation[])objectArray[0]);
                return null;
            }
            case 28: {
                ((DSISDARSTunerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 29: {
                ((DSISDARSSeekListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSISDARSSeekListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSISDARSSeekListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISDARSSeekListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSISDARSSeekListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 34: {
                ((DSISDARSSeekListener)object).updateSeekPossibility((SeekPossibility)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSISDARSSeekListener)object).updateSeekList((SeekEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSISDARSSeekListener)object).updateLeagueList((LeagueEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSISDARSSeekListener)object).updateTrafficWeatherList((TrafficWxEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSISDARSSeekListener)object).updateSeekAlert((SeekAlert)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSISDARSSeekListener)object).setSeekCommandResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 40: {
                ((DSISDARSSeekListener)object).manageSeekResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 41: {
                ((DSISDARSSeekListener)object).teamsOfLeague((TeamEntry[])objectArray[0]);
                return null;
            }
            case 42: {
                ((DSISDARSSeekListener)object).leagues((LeagueEntry[])objectArray[0]);
                return null;
            }
            case 43: {
                ((DSISDARSSeekListener)object).updateRegisteredTeams((TeamEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSISDARSSeekListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

