/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DSIObexAuthenticationListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public final class LR2af6ee595
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -100821332: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1495628972: {
                if (bl) {
                    if (n2 != -2126547318) break;
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
            case -2079601745: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1746799429: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1429566644: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1396041267: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -798379172: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -587778629: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -561652989: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -298624524: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -145872337: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 57198177: {
                if (bl) {
                    if (n2 != -1835867533) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 119291551: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 132433793: {
                if (bl) {
                    if (n2 != -1940116817) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 136532103: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 139922165: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 165748945: {
                if (bl) {
                    if (n2 != -1940116817) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 419327876: {
                if (bl) {
                    if (n2 != -654191265) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 430371351: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 722569761: {
                if (bl) {
                    if (n2 != -1731158612) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 786287510: {
                if (bl) {
                    if (n2 != 1938659861) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 793281887: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 984301599: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1259905263: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1290381679: {
                if (bl) {
                    if (n2 != 2063346321) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1453097598: {
                if (bl) {
                    if (n2 != 2060355064) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1556811890: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1720022701: {
                if (bl) {
                    if (n2 != -1261696176) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1877490501: {
                if (bl) {
                    if (n2 != -2048300200) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1882512502: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1889269469: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1919443272: {
                if (bl) {
                    if (n2 != 1775039192) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 2032984670: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 2065118443: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 2078849411: {
                if (bl) {
                    if (n2 != 447167116) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
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
            case -1815116861: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1383128283: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIObexAuthenticationListener)object).authenticationRequired(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 1: {
                ((DSIObexAuthenticationListener)object).indAuthentication((Boolean)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIObexAuthenticationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIBluetoothListener)object).responseAbortConnectService(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIBluetoothListener)object).responseAbortInquiry(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIBluetoothListener)object).responseAcceptIncomingServiceRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIBluetoothListener)object).responseConnectService((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 7: {
                ((DSIBluetoothListener)object).responseConnectServiceToInstance((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 8: {
                ((DSIBluetoothListener)object).responseDisconnectService((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIBluetoothListener)object).responseGetServices((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 10: {
                ((DSIBluetoothListener)object).responseInquiry(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIBluetoothListener)object).responsePasskeyResponse((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSIBluetoothListener)object).responseRemoveAuthentication((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSIBluetoothListener)object).responseRestoreFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIBluetoothListener)object).responseSetA2DPUserSetting(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIBluetoothListener)object).responseSetAccessibleMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIBluetoothListener)object).responseSwitchBTState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIBluetoothListener)object).removeAuthenticationNoSupport((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIBluetoothListener)object).updateAccessibleMode(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSIBluetoothListener)object).updateBTState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIBluetoothListener)object).updateDiscoveredDevices((DiscoveredDevice)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIBluetoothListener)object).updateHUCandBTHSState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIBluetoothListener)object).updateIncomingServiceRequest((RequestIncomingService)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIBluetoothListener)object).updateMasterRoleRequestError((MasterRoleRequestStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIBluetoothListener)object).updatePasskeyState((PasskeyStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIBluetoothListener)object).updateReconnectIndicator((ReconnectInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIBluetoothListener)object).updateServiceRequestState((ServiceRequestStateStruct)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIBluetoothListener)object).updateSupportedBTProfiles(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIBluetoothListener)object).updateTrustedDevices((TrustedDevice[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIBluetoothListener)object).updateUserFriendlyName((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIBluetoothListener)object).updateA2DPUserSetting((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSIBluetoothListener)object).updatePriorizedDeviceReconnect((Boolean)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIBluetoothListener)object).deviceDisonnectionInfo((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 33: {
                ((DSIBluetoothListener)object).serviceRejectNoSupport((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSIBluetoothListener)object).responseReconnectSuspend(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSIBluetoothListener)object).responseSetPriorizedDeviceReconnect(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSIBluetoothListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

