/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.generated.mma;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSISkeletonTarget;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.osgi.framework.ServiceEvent;

public final class LR2810ebc77
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2129417383: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -2111813431: {
                if (bl) {
                    if (n2 == 1697387916) {
                        n3 = 7;
                        break;
                    }
                    if (n2 != -1745521123) break;
                    n3 = 8;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1652242101: {
                if (bl) {
                    if (n2 != -1379731328) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1427466138: {
                if (bl) {
                    if (n2 == 1697387916) {
                        n3 = 5;
                        break;
                    }
                    if (n2 != -1745521123) break;
                    n3 = 6;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1166104739: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1153741992: {
                if (bl) {
                    if (n2 != 762576925) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1028274906: {
                if (bl) {
                    if (n2 != 641548671) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -193151591: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -22372645: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 534526786: {
                if (bl) {
                    if (n2 != 762576925) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 751198292: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1270910546: {
                if (bl) {
                    if (n2 != 549354028) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1330786889: {
                if (bl) {
                    if (n2 != 641548671) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 2140152622: {
                if (bl) {
                    if (n2 != -1379731328) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2129417383: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -2128128598: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1299566412: {
                if (bl) {
                    if (n2 != -2011293283) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1331701933: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1559811301: {
                if (bl) {
                    if (n2 != 641548671) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1625904732: {
                if (bl) {
                    if (n2 != 1562483276) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1676282914: {
                if (bl) {
                    if (n2 != 641548671) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1937137154: {
                if (bl) {
                    if (n2 != 1885475377) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
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
            case 472532835: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1554791061: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return DSIProxyTarget.createServiceRegisteredEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 1: {
                return DSIProxyTarget.createServiceUnregisteredEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 2: {
                return DSIProxyTarget.createNotificationInvocationEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (Object[])objectArray[3]);
            }
            case 3: {
                return DSIProxyTarget.createResponseInvocationEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (Object[])objectArray[3]);
            }
            case 4: {
                ((DSIProxyTarget)object).startPeer();
                return null;
            }
            case 5: {
                ((DSIProxyTarget)object).addServiceStateListener((DSIServiceStateListener)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIProxyTarget)object).addServiceStateListener(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DSIServiceStateListener)objectArray[2]);
                return null;
            }
            case 7: {
                ((DSIProxyTarget)object).removeServiceStateListener((DSIServiceStateListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIProxyTarget)object).removeServiceStateListener(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DSIServiceStateListener)objectArray[2]);
                return null;
            }
            case 9: {
                ((DSIProxyTarget)object).addServiceInterceptor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DSIProxyInterceptor)objectArray[2]);
                return null;
            }
            case 10: {
                ((DSIProxyTarget)object).removeServiceInterceptor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DSIProxyInterceptor)objectArray[2]);
                return null;
            }
            case 11: {
                ((DSIProxyTarget)object).addResponseListener(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (DSIListener)objectArray[3]);
                return null;
            }
            case 12: {
                ((DSIProxyTarget)object).removeResponseListener(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (DSIListener)objectArray[3]);
                return null;
            }
            case 13: {
                return RuntimeUtil.valueOf(((DSIProxyTarget)object).clearPendingResponses(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 14: {
                return RuntimeUtil.valueOf(((DSIProxyTarget)object).clearWaitingRequests(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]));
            }
            case 15: {
                ((DSIProxyTarget)object).setUnexpectedResponsePassing(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 16: {
                ((DSISkeletonTarget)object).startPeer();
                return null;
            }
            case 17: {
                return ((DSISkeletonTarget)object).getNotificationListener(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 18: {
                ((DSISkeletonTarget)object).serviceInvoke(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (Object[])objectArray[4]);
                return null;
            }
            case 19: {
                ((DSISkeletonTarget)object).serviceChanged((ServiceEvent)objectArray[0]);
                return null;
            }
            case 20: {
                return ((DSISkeletonTarget)object).getListenerInterceptors(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
            }
            case 21: {
                ((DSISkeletonTarget)object).addListenerInterceptor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DSIProxyInterceptor)objectArray[2]);
                return null;
            }
            case 22: {
                ((DSISkeletonTarget)object).removeListenerInterceptor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (DSIProxyInterceptor)objectArray[2]);
                return null;
            }
            case 23: {
                return RuntimeUtil.valueOf(((DSISkeletonTarget)object).getListenerMethodIndex(((Number)objectArray[0]).intValue(), (String)objectArray[1], (Class[])objectArray[2]));
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

