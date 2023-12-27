/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;
import org.dsi.ifc.online.DSIOnlineTourImport;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;

public final class LR27d2d6bac
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1630153138: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 3;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 4;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 5;
                    break;
                }
                n3 = 3;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 6;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 7;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 8;
                    break;
                }
                n3 = 6;
                break;
            }
            case -826455777: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1092638455: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -2083869941: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -2022521627: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1988167491: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1921177055: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1895757830: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1840549125: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1681099741: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1603646017: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1408727341: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1342553027: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1237657880: {
                if (bl) {
                    if (n2 != -937887090) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1211151115: {
                if (bl) {
                    if (n2 != 150862110) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 58;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 59;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 60;
                    break;
                }
                n3 = 58;
                break;
            }
            case -1137704880: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -1111979219: {
                if (bl) {
                    if (n2 != -733368144) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1097328641: {
                if (bl) {
                    if (n2 != -1185929098) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1011304393: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1005921281: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 61;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 62;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 63;
                    break;
                }
                n3 = 61;
                break;
            }
            case -858664968: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -845534798: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -663323080: {
                if (bl) {
                    if (n2 != 1924175970) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -497394247: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -360030942: {
                if (bl) {
                    if (n2 != 1924175970) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -207032114: {
                if (bl) {
                    if (n2 != -937887090) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -109266911: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -101215786: {
                if (bl) {
                    if (n2 != -1734349525) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 71282322: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 103150046: {
                if (bl) {
                    if (n2 != -1185929098) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 193093308: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 263108664: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 715349224: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 787681339: {
                if (bl) {
                    if (n2 != 1197881598) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 852860690: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1098610916: {
                if (bl) {
                    if (n2 != -1185929098) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1203618432: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1397567756: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1427819261: {
                if (bl) {
                    if (n2 != 150862110) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1636733997: {
                if (bl) {
                    if (n2 != 11096598) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1742908982: {
                if (bl) {
                    if (n2 != -964352318) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1768186435: {
                if (bl) {
                    if (n2 != -1645927889) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1884839894: {
                if (bl) {
                    if (n2 != -1197579402) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1918349839: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1967404743: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1984933401: {
                if (bl) {
                    if (n2 != -937887090) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 2119452594: {
                if (bl) {
                    if (n2 != -785441950) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
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
            case -1088600277: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -571333398: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIOnlineTourImport)object).startTourDownload(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIOnlineTourImport)object).dismissTourDownload();
                return null;
            }
            case 2: {
                ((DSIOnlineTourImport)object).acknowledgeTourImport(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIOnlineTourImport)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIOnlineTourImport)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIOnlineTourImport)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIOnlineTourImport)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIOnlineTourImport)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIOnlineTourImport)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIOnlineServiceRegistration)object).download((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue());
                return null;
            }
            case 10: {
                ((DSIOnlineServiceRegistration)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSIOnlineServiceRegistration)object).getLicenses((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIOnlineServiceRegistration)object).resetToFactorySettings((String)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIOnlineServiceRegistration)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIOnlineServiceRegistration)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIOnlineServiceRegistration)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIOnlineServiceRegistration)object).profileResetAll();
                return null;
            }
            case 17: {
                ((DSIOnlineServiceRegistration)object).getOnlineApplicationList();
                return null;
            }
            case 18: {
                ((DSIOnlineServiceRegistration)object).getOnlineApplication((String)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSIOnlineServiceRegistration)object).setOnlineApplicationState((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIOnlineServiceRegistration)object).activateLicense((OSRLicense)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIOnlineServiceRegistration)object).setDemandState((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIOnlineServiceRegistration)object).setDemandStateServiceID((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIOnlineServiceRegistration)object).setApplicationProperties((String)objectArray[0], (OSRApplicationProperties[])objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIOnlineServiceRegistration)object).addOrUpdateApplicationProperty((String)objectArray[0], (OSRApplicationProperties)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIOnlineServiceRegistration)object).setCredential((String)objectArray[0], (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 26: {
                ((DSIOnlineServiceRegistration)object).downloadRaw((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue());
                return null;
            }
            case 27: {
                ((DSIOnlineServiceRegistration)object).validateOwner((String)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIOnlineServiceRegistration)object).validateOwnerForce((Boolean)objectArray[0]);
                return null;
            }
            case 29: {
                ((DSIOnlineServiceRegistration)object).checkOwnersVerification();
                return null;
            }
            case 30: {
                ((DSIOnlineServiceRegistration)object).createUserWithPairingCode((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSIOnlineServiceRegistration)object).createUserWithUserPassword((String)objectArray[0], (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIOnlineServiceRegistration)object).checkPassword((OSRUser)objectArray[0], (String)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 33: {
                ((DSIOnlineServiceRegistration)object).checkPairingCode((OSRUser)objectArray[0], (String)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 34: {
                ((DSIOnlineServiceRegistration)object).setPrivacyFlags((OSRUser)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSIOnlineServiceRegistration)object).setAutoLogin((OSRUser)objectArray[0], (OSRDevice[])objectArray[1]);
                return null;
            }
            case 36: {
                ((DSIOnlineServiceRegistration)object).login((OSRUser)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIOnlineServiceRegistration)object).logout((OSRUser)objectArray[0]);
                return null;
            }
            case 38: {
                ((DSIOnlineServiceRegistration)object).logoutAuthScheme((String)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSIOnlineServiceRegistration)object).getUsers((String)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSIOnlineServiceRegistration)object).removeUser((OSRUser)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSIOnlineServiceRegistration)object).performPortalRegistration((String)objectArray[0]);
                return null;
            }
            case 42: {
                ((DSIOnlineServiceRegistration)object).getLicense((String)objectArray[0]);
                return null;
            }
            case 43: {
                ((DSIOnlineServiceRegistration)object).precheckOnlineServiceServiceID((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 44: {
                ((DSIOnlineServiceRegistration)object).precheckOnlineServiceSymbolicName((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 45: {
                ((DSIOnlineServiceRegistration)object).precheckOnlineService((String)objectArray[0]);
                return null;
            }
            case 46: {
                ((DSIOnlineServiceRegistration)object).getProfileFolder((OSRUser)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 47: {
                ((DSIOnlineServiceRegistration)object).getCredentialsFromHeader(((Number)objectArray[0]).intValue(), (String[])objectArray[1]);
                return null;
            }
            case 48: {
                ((DSIOnlineServiceRegistration)object).getCredentialsFromAuthScheme(((Number)objectArray[0]).intValue());
                return null;
            }
            case 49: {
                ((DSIOnlineServiceRegistration)object).getServiceURL((String)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIOnlineServiceRegistration)object).setServiceState((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSIOnlineServiceRegistration)object).setServiceStateSymbolicName((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSIOnlineServiceRegistration)object).setActivePrivacyCategoryMask(((Number)objectArray[0]).intValue());
                return null;
            }
            case 53: {
                ((DSIOnlineServiceRegistration)object).submitServiceStateChangesToBackend();
                return null;
            }
            case 54: {
                ((DSIOnlineServiceRegistration)object).setGPSUseMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 55: {
                ((DSIOnlineServiceRegistration)object).setInventoryFinished((Boolean)objectArray[0]);
                return null;
            }
            case 56: {
                ((DSIOnlineServiceRegistration)object).setSPIN((String)objectArray[0], (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 57: {
                ((DSIOnlineServiceRegistration)object).getSPINHash((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), (String)objectArray[3]);
                return null;
            }
            case 58: {
                ((DSIOnlineServiceRegistration)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 59: {
                ((DSIOnlineServiceRegistration)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 60: {
                ((DSIOnlineServiceRegistration)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 61: {
                ((DSIOnlineServiceRegistration)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 62: {
                ((DSIOnlineServiceRegistration)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 63: {
                ((DSIOnlineServiceRegistration)object).clearNotification((DSIListener)objectArray[0]);
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

