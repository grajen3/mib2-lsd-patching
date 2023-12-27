/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.online.DSIOnlineServiceRegistrationListener;
import org.dsi.ifc.online.DSIOnlineTourImportListener;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceListEntry;
import org.dsi.ifc.online.OSRServiceRegistration;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public final class LR2b2ae0824
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -143601578: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 225282428: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1166876256: {
                if (bl) {
                    if (n2 != -107814524) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2070711361: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -2063635023: {
                if (bl) {
                    if (n2 != -892169136) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -2045585732: {
                if (bl) {
                    if (n2 != -789921790) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1862686434: {
                if (bl) {
                    if (n2 != -47799197) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1843975144: {
                if (bl) {
                    if (n2 != -564372616) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1842682057: {
                if (bl) {
                    if (n2 != -1185929098) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1824586404: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1760400572: {
                if (bl) {
                    if (n2 != -1813711490) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1626157754: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -1608568045: {
                if (bl) {
                    if (n2 != 962051051) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1383873406: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1268125377: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1158531454: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1015184487: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1009009255: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -977323170: {
                if (bl) {
                    if (n2 != 1865490124) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -839466700: {
                if (bl) {
                    if (n2 != -892169136) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -751774313: {
                if (bl) {
                    if (n2 != 1590952076) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -622550854: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -595591199: {
                if (bl) {
                    if (n2 != -1597567792) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -563642630: {
                if (bl) {
                    if (n2 != -1187482232) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -432603089: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -245311357: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -211890152: {
                if (bl) {
                    if (n2 != -1539323744) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -124310944: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 122361177: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 162682889: {
                if (bl) {
                    if (n2 != -1898581697) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 187021811: {
                if (bl) {
                    if (n2 != 34843543) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 267558941: {
                if (bl) {
                    if (n2 != 748367570) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 309734473: {
                if (bl) {
                    if (n2 != -47799197) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 334819440: {
                if (bl) {
                    if (n2 != -1750220564) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 420900479: {
                if (bl) {
                    if (n2 != -1992762834) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 427415544: {
                if (bl) {
                    if (n2 != -1895266515) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 520301171: {
                if (bl) {
                    if (n2 != -671105604) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 539518560: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 966872728: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 993096862: {
                if (bl) {
                    if (n2 != 879382636) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1147344147: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1162689832: {
                if (bl) {
                    if (n2 != -68790916) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1226625759: {
                if (bl) {
                    if (n2 != 117412439) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1263217499: {
                if (bl) {
                    if (n2 != -361269682) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1387152726: {
                if (bl) {
                    if (n2 != 375633124) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1490895482: {
                if (bl) {
                    if (n2 != 1775039192) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1524830789: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1634847630: {
                if (bl) {
                    if (n2 != -1232668240) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1765289124: {
                if (bl) {
                    if (n2 != -1674355153) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1850268704: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1895346761: {
                if (bl) {
                    if (n2 != -1750220564) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
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
            case -99743554: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1012357631: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIOnlineTourImportListener)object).indicateToursAvailable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIOnlineTourImportListener)object).responseTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIOnlineTourImportListener)object).indicateTourDownloadFinished(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 3: {
                ((DSIOnlineTourImportListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIOnlineServiceRegistrationListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIOnlineServiceRegistrationListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIOnlineServiceRegistrationListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIOnlineServiceRegistrationListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIOnlineServiceRegistrationListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 9: {
                ((DSIOnlineServiceRegistrationListener)object).getOnlineApplicationListResponse((OSRApplication[])objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIOnlineServiceRegistrationListener)object).getOnlineApplicationResponse((OSRApplication)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIOnlineServiceRegistrationListener)object).activateLicenseResponse((OSRLicense)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIOnlineServiceRegistrationListener)object).setCredentialResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIOnlineServiceRegistrationListener)object).downloadResponse((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 14: {
                ((DSIOnlineServiceRegistrationListener)object).downloadRawResponse((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], (ResourceLocator)objectArray[3], ((Number)objectArray[4]).intValue());
                return null;
            }
            case 15: {
                ((DSIOnlineServiceRegistrationListener)object).validateOwnerResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIOnlineServiceRegistrationListener)object).checkOwnersVerificationResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIOnlineServiceRegistrationListener)object).createUserWithPairingCodeResponse((String)objectArray[0], (OSRUser)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIOnlineServiceRegistrationListener)object).createUserWithUserPasswordResponse((String)objectArray[0], (OSRUser)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSIOnlineServiceRegistrationListener)object).checkPasswordResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIOnlineServiceRegistrationListener)object).checkPairingCodeResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIOnlineServiceRegistrationListener)object).setPrivacyFlagsResponse((OSRUser)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIOnlineServiceRegistrationListener)object).setAutoLoginResponse((OSRUser)objectArray[0], (OSRDevice[])objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 23: {
                ((DSIOnlineServiceRegistrationListener)object).loginResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIOnlineServiceRegistrationListener)object).logoutResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIOnlineServiceRegistrationListener)object).logoutAuthSchemeResult((String)objectArray[0], (OSRUser[])objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 26: {
                ((DSIOnlineServiceRegistrationListener)object).getUsersResponse((OSRUser[])objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIOnlineServiceRegistrationListener)object).removeUserResponse((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIOnlineServiceRegistrationListener)object).performPortalRegistrationResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIOnlineServiceRegistrationListener)object).precheckOnlineServiceServiceIDResponse((String)objectArray[0], (OSRServiceState)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSIOnlineServiceRegistrationListener)object).precheckOnlineServiceSymbolicNameResponse((String)objectArray[0], (OSRServiceState)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSIOnlineServiceRegistrationListener)object).precheckOnlineServiceResponse((String)objectArray[0], (OSRServiceState[])objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIOnlineServiceRegistrationListener)object).getLicenseResponse(((Number)objectArray[0]).intValue(), (OSRLicense)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSIOnlineServiceRegistrationListener)object).getLicensesResponse(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], (Boolean)objectArray[2], (OSRLicense[])objectArray[3]);
                return null;
            }
            case 34: {
                ((DSIOnlineServiceRegistrationListener)object).getProfileFolderResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1], (OSRUser)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 35: {
                ((DSIOnlineServiceRegistrationListener)object).getCredentialsFromHeaderResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (String)objectArray[3], (String)objectArray[4], (String)objectArray[5]);
                return null;
            }
            case 36: {
                ((DSIOnlineServiceRegistrationListener)object).getCredentialsFromAuthSchemeResponse(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], (String)objectArray[3], (String)objectArray[4]);
                return null;
            }
            case 37: {
                ((DSIOnlineServiceRegistrationListener)object).getServiceURLResponse(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 38: {
                ((DSIOnlineServiceRegistrationListener)object).resetToFactorySettingsResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSIOnlineServiceRegistrationListener)object).updateApplicationState((OSRNotifyProperties[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSIOnlineServiceRegistrationListener)object).updateServices((OSRNotifyPropertiesSL[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSIOnlineServiceRegistrationListener)object).updateCoreProfileInfo((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 42: {
                ((DSIOnlineServiceRegistrationListener)object).updateExternalProfileInfo((String)objectArray[0], (OSRUser)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 43: {
                ((DSIOnlineServiceRegistrationListener)object).updateDeviceEnumerator((OSRDevice)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 44: {
                ((DSIOnlineServiceRegistrationListener)object).updateServiceState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSIOnlineServiceRegistrationListener)object).updateServiceList((OSRServiceListEntry[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSIOnlineServiceRegistrationListener)object).updateServiceRegistration((String)objectArray[0], (OSRServiceRegistration)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 47: {
                ((DSIOnlineServiceRegistrationListener)object).setServiceStateResponse((OSRServiceState)objectArray[0]);
                return null;
            }
            case 48: {
                ((DSIOnlineServiceRegistrationListener)object).setDemandStateServiceIDResponse((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSIOnlineServiceRegistrationListener)object).setServiceStateSymbolicNameResponse((OSRServiceState)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIOnlineServiceRegistrationListener)object).setActivePrivacyCategoryMaskResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 51: {
                ((DSIOnlineServiceRegistrationListener)object).submitServiceStateChangesToBackendResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 52: {
                ((DSIOnlineServiceRegistrationListener)object).setGPSUseModeResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 53: {
                ((DSIOnlineServiceRegistrationListener)object).setInventoryFinishedResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 54: {
                ((DSIOnlineServiceRegistrationListener)object).updateSPINRequired((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 55: {
                ((DSIOnlineServiceRegistrationListener)object).setSPINResponse((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 56: {
                ((DSIOnlineServiceRegistrationListener)object).getSPINHashResult((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), (String)objectArray[3], (String)objectArray[4], ((Number)objectArray[5]).intValue());
                return null;
            }
            case 57: {
                ((DSIOnlineServiceRegistrationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

