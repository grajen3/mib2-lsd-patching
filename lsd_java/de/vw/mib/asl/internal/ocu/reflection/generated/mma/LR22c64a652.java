/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.reflection.generated.mma;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceListener;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListener;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationResult;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationStatus;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener$OperationType;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState;
import de.vw.mib.asl.api.ocu.voiceservices10.VoiceServiceListener;
import de.vw.mib.asl.internal.ocu.common.api.modelocu.ModelOcuServiceProvider;
import de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.OnlineUpdateServiceProvider;
import de.vw.mib.asl.internal.ocu.common.api.onlinev10.OnlineNetworkServiceProvider;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.common.api.voiceservices10.VoiceServiceProvider;
import de.vw.mib.asl.internal.ocu.ecall.target.ECallTarget;
import de.vw.mib.asl.internal.ocu.eni.target.ENITarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;

public final class LR22c64a652
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1858362663: {
                if (bl) {
                    if (n2 != 1909900206) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1816417618: {
                if (bl) {
                    if (n2 != -313293062) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1342536471: {
                if (bl) {
                    if (n2 != -409703252) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1333021264: {
                if (bl) {
                    if (n2 != -1571292076) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -690212584: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 65492399: {
                if (bl) {
                    if (n2 != 1756618851) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 105948298: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 614643850: {
                if (bl) {
                    if (n2 != 257620476) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 903375069: {
                if (bl) {
                    if (n2 != 882874409) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 906370268: {
                if (bl) {
                    if (n2 != 1977914987) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1087711433: {
                if (bl) {
                    if (n2 != 917247699) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1698743798: {
                if (bl) {
                    if (n2 != -1571292076) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1989373338: {
                if (bl) {
                    if (n2 != -1326642018) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1916937896: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1034532775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -910560651: {
                if (bl) {
                    if (n2 != -1917504959) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1973856191: {
                if (bl) {
                    if (n2 != -1326642018) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1367098522: {
                if (bl) {
                    if (n2 != -862307413) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1264449339: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1034532775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -910560651: {
                if (bl) {
                    if (n2 != -1917504959) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 326837663: {
                if (bl) {
                    if (n2 != -862307413) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1526026081: {
                if (bl) {
                    if (n2 != -1468629729) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1034532775: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -910560651: {
                if (bl) {
                    if (n2 != -1917504959) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -639126002: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -189980858: {
                if (bl) {
                    if (n2 != -1468629729) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1949860573: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1099711208: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1088809961: {
                if (bl) {
                    if (n2 != 431709920) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -920936170: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -649084049: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -12445505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 264475372: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 721365567: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1199514809: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 2063526163: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 2077898333: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1949860573: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -1099711208: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1088809961: {
                if (bl) {
                    if (n2 != 431709920) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -920936170: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -649084049: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -12445505: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 264475372: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 721365567: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1199514809: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 2063526163: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 2077898333: {
                if (bl) {
                    if (n2 != 314663853) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
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
            case -1148157415: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case -1076608551: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 898410869: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1131775581: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 1312418945: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 2101325410: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((ModelOcuServiceProvider)object).register();
                return null;
            }
            case 1: {
                ((ModelOcuServiceProvider)object).updateOnlineNetworkServiceList((OnlineNetworkService)objectArray[0], (OnlineNetworkList)objectArray[1]);
                return null;
            }
            case 2: {
                ((ModelOcuServiceProvider)object).updateOnlineNetworkServiceStatus((OnlineNetworkService)objectArray[0], (OnlineNetworkServiceStatus)objectArray[1]);
                return null;
            }
            case 3: {
                ((ModelOcuServiceProvider)object).updateOnlineNetworkSupportedServices((OnlineNetworkService)objectArray[0], (OnlineNetworkSupportedServices)objectArray[1]);
                return null;
            }
            case 4: {
                ((ModelOcuServiceProvider)object).updateOnlineNetworkUserList((OnlineNetworkService)objectArray[0], (OnlineNetworkList)objectArray[1]);
                return null;
            }
            case 5: {
                ((ModelOcuServiceProvider)object).updatePrivacyModeActive((OnlineNetworkService)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 6: {
                ((ModelOcuServiceProvider)object).updateServiceListSynchronisationState((OnlineNetworkService)objectArray[0], (ServiceListSynchronisationState)objectArray[1]);
                return null;
            }
            case 7: {
                ((ModelOcuServiceProvider)object).updateOnlineNetworkTrackingServices((OnlineNetworkService)objectArray[0], (OnlineNetworkTrackingServices)objectArray[1]);
                return null;
            }
            case 8: {
                ((ModelOcuServiceProvider)object).updateOnlineNetworkServiceSetBlocking((OnlineNetworkService)objectArray[0], (OnlineNetworkServiceListEntry)objectArray[1]);
                return null;
            }
            case 9: {
                ((ModelOcuServiceProvider)object).operationStatus((OnlineNetworkService)objectArray[0], (OnlineNetworkServiceResponseListener$OperationStatus)objectArray[1]);
                return null;
            }
            case 10: {
                ((ModelOcuServiceProvider)object).operationResult((OnlineNetworkService)objectArray[0], (OnlineNetworkServiceResponseListener$OperationType)objectArray[1], (OnlineNetworkServiceResponseListener$OperationResult)objectArray[2]);
                return null;
            }
            case 11: {
                ((ModelOcuServiceProvider)object).navServiceStateChanged();
                return null;
            }
            case 12: {
                return ((OnlineUpdateServiceProvider)object).getIterator();
            }
            case 13: {
                return ((OnlineUpdateServiceProvider)object).getOnlineUpdateService();
            }
            case 14: {
                ((OnlineUpdateServiceProvider)object).registerOnlineUpdateServiceListener((OnlineUpdateServiceListener)objectArray[0]);
                return null;
            }
            case 15: {
                ((OnlineUpdateServiceProvider)object).unRegisterOnlineUpdateServiceListener((OnlineUpdateServiceListener)objectArray[0]);
                return null;
            }
            case 16: {
                ((OnlineUpdateServiceProvider)object).notifyServiceListener((Class)objectArray[0], (ServiceNotifier)objectArray[1]);
                return null;
            }
            case 17: {
                return ((OnlineNetworkServiceProvider)object).getIterator();
            }
            case 18: {
                return ((OnlineNetworkServiceProvider)object).getOnlineNetworkService();
            }
            case 19: {
                ((OnlineNetworkServiceProvider)object).registerOnlineNetworkServiceListener((OnlineNetworkServiceListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((OnlineNetworkServiceProvider)object).notifyServiceListener((Class)objectArray[0], (ServiceNotifier)objectArray[1]);
                return null;
            }
            case 21: {
                ((OnlineNetworkServiceProvider)object).unRegisterOnlineNetworkServiceListener((OnlineNetworkServiceListener)objectArray[0]);
                return null;
            }
            case 22: {
                return ((VoiceServiceProvider)object).getIterator();
            }
            case 23: {
                ((VoiceServiceProvider)object).notifyServiceListener((Class)objectArray[0], (ServiceNotifier)objectArray[1]);
                return null;
            }
            case 24: {
                return ((VoiceServiceProvider)object).getVoiceService();
            }
            case 25: {
                ((VoiceServiceProvider)object).registerVoiceServiceLister((VoiceServiceListener)objectArray[0]);
                return null;
            }
            case 26: {
                ((VoiceServiceProvider)object).unregisterVoiceServiceLister((VoiceServiceListener)objectArray[0]);
                return null;
            }
            case 27: {
                return ((ECallTarget)object).getLogger();
            }
            case 28: {
                return ((ECallTarget)object).getLogicalControlUnit();
            }
            case 29: {
                return ((ECallTarget)object).getOCUServiceProxy();
            }
            case 30: {
                return ((ECallTarget)object).getOCUService();
            }
            case 31: {
                ((ECallTarget)object).registerObservers();
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((ECallTarget)object).registerServiceReceiver(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 33: {
                ((ECallTarget)object).unregisterServiceReceiver(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 34: {
                ((ECallTarget)object).registerServiceProvider(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 35: {
                ((ECallTarget)object).unRegisterServiceProvider(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 36: {
                ((ECallTarget)object).registerServiceProviderListener(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 37: {
                ((ECallTarget)object).unRegisterServiceProviderListener(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 38: {
                return ((ECallTarget)object).getRegisteredServiceListeners((Class)objectArray[0]);
            }
            case 39: {
                return ((ENITarget)object).getLogger();
            }
            case 40: {
                return ((ENITarget)object).getLogicalControlUnit();
            }
            case 41: {
                return ((ENITarget)object).getOCUServiceProxy();
            }
            case 42: {
                return ((ENITarget)object).getOCUService();
            }
            case 43: {
                ((ENITarget)object).registerObservers();
                return null;
            }
            case 44: {
                ((ENITarget)object).registerServiceReceiver(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 45: {
                ((ENITarget)object).unregisterServiceReceiver(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 46: {
                ((ENITarget)object).registerServiceProvider(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 47: {
                ((ENITarget)object).unRegisterServiceProvider(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 48: {
                ((ENITarget)object).registerServiceProviderListener(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 49: {
                ((ENITarget)object).unRegisterServiceProviderListener(objectArray[0], (Class)objectArray[1], (int[])objectArray[2]);
                return null;
            }
            case 50: {
                return ((ENITarget)object).getRegisteredServiceListeners((Class)objectArray[0]);
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

