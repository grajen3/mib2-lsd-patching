/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.sfa.DSISFAListener;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener;
import org.dsi.ifc.smartphoneintegration.Device;

public final class LR2e73e73fd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1601297599: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 426898505: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 722569761: {
                if (bl) {
                    if (n2 != -2094431464) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1059524783: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1149281862: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1278425923: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1462191177: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1153950539: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 691360786: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1088874251: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
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
            case -408507453: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 115895619: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISmartphoneIntegrationListener)object).updateDiscoveredDevices((Device[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSISmartphoneIntegrationListener)object).responseFactorySettings(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSISmartphoneIntegrationListener)object).updateSWaPStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSISmartphoneIntegrationListener)object).updateDeviceConnectionState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 4: {
                ((DSISmartphoneIntegrationListener)object).updateUSBResetActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSISmartphoneIntegrationListener)object).updateAppConnectContextRequested((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSISmartphoneIntegrationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSISFAListener)object).updateAudioRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSISFAListener)object).updateDisplayRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSISFAListener)object).responseKeyTouchEvaluation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSISFAListener)object).responseDisplayNotVisible(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSISFAListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

