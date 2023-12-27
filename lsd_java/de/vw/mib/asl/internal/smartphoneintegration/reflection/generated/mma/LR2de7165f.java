/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.reflection.generated.mma;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationAppConnectAppAdapter;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.smartphoneintegration.Device;

public final class LR2de7165f
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1933800482: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1897184014: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1730501989: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1121075884: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1080382696: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -988271202: {
                if (bl) {
                    if (n2 != 815475609) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -830485477: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -822571516: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -759502449: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -207497765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 208559945: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 297094560: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1409637565: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1989775532: {
                if (bl) {
                    if (n2 != -2094431464) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1993567786: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
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
            case 233248351: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((HsmTarget)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                return ((HsmTarget)object).getDSISmartphoneIntegration();
            }
            case 2: {
                ((HsmTarget)object).startup();
                return null;
            }
            case 3: {
                ((HsmTarget)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                return ((HsmTarget)object).getASLHandler();
            }
            case 5: {
                return ((HsmTarget)object).getDSIHandler();
            }
            case 6: {
                return ((HsmTarget)object).getAppConnectRequestHandler();
            }
            case 7: {
                return ((HsmTarget)object).getPersistence();
            }
            case 8: {
                return ((HsmTarget)object).getAslEventhandler();
            }
            case 9: {
                return ((HsmTarget)object).getAppAdapterInterface();
            }
            case 10: {
                ((HsmTarget)object).setAppAdapterInterface((ASLSmartphoneIntegrationAppConnectAppAdapter)objectArray[0]);
                return null;
            }
            case 11: {
                ((HsmTarget)object).dsiSmartphoneIntegrationUpdateDiscoveredDevices((Device[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((HsmTarget)object).dsiSmartphoneIntegrationUpdateDeviceConnectionState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 13: {
                ((HsmTarget)object).dsiSmartphoneIntegrationAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((HsmTarget)object).dsiSmartphoneIntegrationUpdateSWaPStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((HsmTarget)object).dsiSmartphoneIntegrationUpdateUSBResetActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((HsmTarget)object).dsiSmartphoneIntegrationUpdateAppConnectContextRequested((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
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

