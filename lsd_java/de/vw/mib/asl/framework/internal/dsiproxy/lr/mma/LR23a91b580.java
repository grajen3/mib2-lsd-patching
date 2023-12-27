/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DSIAdbSds;
import org.dsi.ifc.organizer.DSIAdbSetup;

public final class LR23a91b580
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 2;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 3;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 4;
                    break;
                }
                n3 = 2;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 5;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 6;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 7;
                    break;
                }
                n3 = 5;
                break;
            }
            case -236819083: {
                if (bl) {
                    if (n2 != 3523) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1701716149: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -1162471198: {
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
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 20;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 21;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 22;
                    break;
                }
                n3 = 20;
                break;
            }
            case 154364189: {
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
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 421553637: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 653522520: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 688213542: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 772377827: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 891069167: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1512614019: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
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
            case -1353925304: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -461742963: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIAdbSds)object).getAllVoiceTags();
                return null;
            }
            case 1: {
                ((DSIAdbSds)object).deleteVoiceTags((int[])objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIAdbSds)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 3: {
                ((DSIAdbSds)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIAdbSds)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIAdbSds)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIAdbSds)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIAdbSds)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIAdbSetup)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIAdbSetup)object).resetToFactorySettings();
                return null;
            }
            case 10: {
                ((DSIAdbSetup)object).setSortOrder(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIAdbSetup)object).setPublicProfileVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIAdbSetup)object).resetTopDestination();
                return null;
            }
            case 13: {
                ((DSIAdbSetup)object).createBackupFile((String)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIAdbSetup)object).importBackupFile((String)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIAdbSetup)object).setPictureVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIAdbSetup)object).setContextSpecificVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIAdbSetup)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIAdbSetup)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIAdbSetup)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIAdbSetup)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIAdbSetup)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSIAdbSetup)object).clearNotification((DSIListener)objectArray[0]);
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

