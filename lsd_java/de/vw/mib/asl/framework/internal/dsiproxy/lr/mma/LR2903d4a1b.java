/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.DSINavServicesAPIListener;
import org.dsi.ifc.navservicesapi.TunerData;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

public final class LR2903d4a1b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1541466129: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1525231247: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1501038497: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1417867696: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1141470539: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -360840897: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -175969671: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 486228096: {
                if (bl) {
                    if (n2 != -1182249309) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 674480537: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 835593907: {
                if (bl) {
                    if (n2 != 1157101275) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 863654707: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 901076607: {
                if (bl) {
                    if (n2 != -1325784054) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1782565147: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1964692948: {
                if (bl) {
                    if (n2 != -1017859126) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 2116536790: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -1894235616: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1886259242: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1885961275: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1171993035: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1162075729: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -743417418: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -700968187: {
                if (bl) {
                    if (n2 != -1284742046) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -490662834: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -444297447: {
                if (bl) {
                    if (n2 != -1455132039) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -309925842: {
                if (bl) {
                    if (n2 != 1824159717) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 106102926: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 312833438: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 392312432: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 406304075: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1459667441: {
                if (bl) {
                    if (n2 != -266440678) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1983654236: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1992011081: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 2022419045: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 2034300897: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 2044200127: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 2124842294: {
                if (bl) {
                    if (n2 != -1600866162) break;
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
            case -1384652275: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 2112463023: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIDataConfigurationListener)object).restoreFactorySettingsResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIDataConfigurationListener)object).updateAvailableProfiles((CDataProfile[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIDataConfigurationListener)object).updateActiveProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIDataConfigurationListener)object).updateRoamingState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIDataConfigurationListener)object).updateConnectionMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIDataConfigurationListener)object).updateDataRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIDataConfigurationListener)object).updateRequestSetting(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIDataConfigurationListener)object).setDataProfileResponse((CDataProfile)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIDataConfigurationListener)object).automaticProfileResponse(((Number)objectArray[0]).intValue(), (CDataProfile)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIDataConfigurationListener)object).setRoamingStateResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSIDataConfigurationListener)object).setConnectionModeResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIDataConfigurationListener)object).setRequestSettingResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIDataConfigurationListener)object).acceptDataRequestResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIDataConfigurationListener)object).resetPacketCounterResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIDataConfigurationListener)object).updatePacketCounter((CPacketCounter)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIDataConfigurationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSINavServicesAPIListener)object).createExportFile(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSINavServicesAPIListener)object).importFile(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSINavServicesAPIListener)object).resetToFactorySettingsResult();
                return null;
            }
            case 19: {
                ((DSINavServicesAPIListener)object).updateReceivableStations((TunerData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSINavServicesAPIListener)object).updateAvailableLanguages((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSINavServicesAPIListener)object).updateLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSINavServicesAPIListener)object).updateNavigationState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSINavServicesAPIListener)object).initiatePhoneCallToADBEntry((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSINavServicesAPIListener)object).updateIconDirectory((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSINavServicesAPIListener)object).phoneDialNumber((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSINavServicesAPIListener)object).audioRequest((Boolean)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSINavServicesAPIListener)object).deleteCustomerDataResult();
                return null;
            }
            case 28: {
                ((DSINavServicesAPIListener)object).setBrowserURL((String)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSINavServicesAPIListener)object).prepareAndPlayTTS2Announcement((String)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSINavServicesAPIListener)object).abortTTS2Announcement();
                return null;
            }
            case 31: {
                ((DSINavServicesAPIListener)object).updateCurrentPosition(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).floatValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSINavServicesAPIListener)object).efiLinkSelectedResult((Boolean)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSINavServicesAPIListener)object).selectRemoteSearchLocationResult((AddressData[])objectArray[0]);
                return null;
            }
            case 34: {
                ((DSINavServicesAPIListener)object).checkLicense(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSINavServicesAPIListener)object).checkDataConnection();
                return null;
            }
            case 36: {
                ((DSINavServicesAPIListener)object).requestRrdForLocationDataResult(((Number)objectArray[0]).intValue(), (String[])objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 37: {
                ((DSINavServicesAPIListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

