/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navservicesapi.ADBPersonalData;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.DSINavServicesAPI;
import org.dsi.ifc.navservicesapi.ProfileInfo;
import org.dsi.ifc.navservicesapi.TryMatchLocationData;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfiguration;

public final class LR2425bab6b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2142279539: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1412760053: {
                if (bl) {
                    if (n2 != 1126093071) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1366611724: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 21;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 22;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 23;
                    break;
                }
                n3 = 21;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 24;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 25;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 26;
                    break;
                }
                n3 = 24;
                break;
            }
            case -764059821: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -616517838: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -356878232: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 188170093: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 263108664: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 275213501: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 357914801: {
                if (bl) {
                    if (n2 != 234686070) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 613874690: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1360709270: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1538273441: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1549035280: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1565443572: {
                if (bl) {
                    if (n2 != 1916861332) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1862662721: {
                if (bl) {
                    if (n2 != -1837390224) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 2034300897: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 2039077128: {
                if (bl) {
                    if (n2 != 474416683) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 2060329642: {
                if (bl) {
                    if (n2 != -688707244) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 2124842294: {
                if (bl) {
                    if (n2 != -645498553) break;
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
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 35;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 36;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 37;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1102398408: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 38;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 39;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 40;
                    break;
                }
                n3 = 38;
                break;
            }
            case -899577902: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -867211846: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -368680620: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -61129869: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 37799192: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 92330834: {
                if (bl) {
                    if (n2 != 1168751579) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1330360303: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case 1096138041: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1509506523: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSINavServicesAPI)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSINavServicesAPI)object).resetToFactorySettings();
                return null;
            }
            case 2: {
                ((DSINavServicesAPI)object).createExportFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSINavServicesAPI)object).importFile((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSINavServicesAPI)object).setDistanceUnit(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSINavServicesAPI)object).liTryMatchLocation((TryMatchLocationData)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSINavServicesAPI)object).startRouteGuidance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (ResourceLocator)objectArray[2]);
                return null;
            }
            case 7: {
                ((DSINavServicesAPI)object).setProfileInfo((ProfileInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSINavServicesAPI)object).navigateTo((String)objectArray[0], ((Number)objectArray[1]).intValue(), (ADBPersonalData)objectArray[2], (Boolean)objectArray[3], (AddressData[])objectArray[4]);
                return null;
            }
            case 9: {
                ((DSINavServicesAPI)object).initiatePhoneCallToADBEntryResult((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSINavServicesAPI)object).deleteProfileData(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSINavServicesAPI)object).audioStart();
                return null;
            }
            case 12: {
                ((DSINavServicesAPI)object).audioStop();
                return null;
            }
            case 13: {
                ((DSINavServicesAPI)object).setEngineeringMenuState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSINavServicesAPI)object).deleteCustomerData();
                return null;
            }
            case 15: {
                ((DSINavServicesAPI)object).efiLinkSelected((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSINavServicesAPI)object).selectRemoteSearchLocation();
                return null;
            }
            case 17: {
                ((DSINavServicesAPI)object).tts2AnnouncementFinished(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSINavServicesAPI)object).checkLicenseResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).longValue());
                return null;
            }
            case 19: {
                ((DSINavServicesAPI)object).checkDataConnectionResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSINavServicesAPI)object).requestRrdForLocationData(((Number)objectArray[0]).intValue(), (TryMatchLocationData[])objectArray[1]);
                return null;
            }
            case 21: {
                ((DSINavServicesAPI)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSINavServicesAPI)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSINavServicesAPI)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSINavServicesAPI)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSINavServicesAPI)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSINavServicesAPI)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIDataConfiguration)object).setDataProfile((CDataProfile)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIDataConfiguration)object).automaticProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSIDataConfiguration)object).setRoamingState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSIDataConfiguration)object).setConnectionMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSIDataConfiguration)object).setRequestSetting(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIDataConfiguration)object).acceptDataRequest(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSIDataConfiguration)object).resetPacketCounter();
                return null;
            }
            case 34: {
                ((DSIDataConfiguration)object).restoreFactorySettings();
                return null;
            }
            case 35: {
                ((DSIDataConfiguration)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 36: {
                ((DSIDataConfiguration)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 37: {
                ((DSIDataConfiguration)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 38: {
                ((DSIDataConfiguration)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSIDataConfiguration)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 40: {
                ((DSIDataConfiguration)object).clearNotification((DSIListener)objectArray[0]);
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

