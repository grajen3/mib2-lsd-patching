/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sfa.DSISFA;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;

public final class LR2d14fc085
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1581470123: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1492897934: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 4;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 5;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 6;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1024450765: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 7;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 8;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 9;
                    break;
                }
                n3 = 7;
                break;
            }
            case 274169991: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 14;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 15;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 16;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1060421173: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 17;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 18;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 19;
                    break;
                }
                n3 = 17;
                break;
            }
            case -854924249: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -432855969: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1371241184: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
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
            case -1406362385: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1409801839: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISmartphoneIntegration)object).requestFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSISmartphoneIntegration)object).connectDevice(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSISmartphoneIntegration)object).disconnectDevice(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSISmartphoneIntegration)object).requestAppConnectContextActive((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSISmartphoneIntegration)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSISmartphoneIntegration)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSISmartphoneIntegration)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSISmartphoneIntegration)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSISmartphoneIntegration)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSISmartphoneIntegration)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSISFA)object).audioRequestResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSISFA)object).displayRequestResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSISFA)object).requestKeyTouchEvaluation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSISFA)object).requestDisplayNotVisible();
                return null;
            }
            case 14: {
                ((DSISFA)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSISFA)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSISFA)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSISFA)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSISFA)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSISFA)object).clearNotification((DSIListener)objectArray[0]);
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

