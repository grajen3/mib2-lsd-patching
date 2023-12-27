/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIDestinationImport;
import org.dsi.ifc.online.DSIOnlineDictation;

public final class LR2bf354c5a
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1880036531: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
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
            case 867065833: {
                if (bl) {
                    if (n2 != -1017431296) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1199989631: {
                if (bl) {
                    if (n2 != -1600866162) break;
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
            case -1840932015: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1316995790: {
                if (bl) {
                    if (n2 != 1305175025) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 16;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 17;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 18;
                    break;
                }
                n3 = 16;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 19;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 20;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 21;
                    break;
                }
                n3 = 19;
                break;
            }
            case -155138326: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 411713473: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1320619410: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1949375521: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
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
            case -1053692388: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -755112765: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIDestinationImport)object).downloadAddressList(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 1: {
                ((DSIDestinationImport)object).stopAction();
                return null;
            }
            case 2: {
                ((DSIDestinationImport)object).setADBImportStatus((long[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIDestinationImport)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIDestinationImport)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIDestinationImport)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIDestinationImport)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIDestinationImport)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIDestinationImport)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIOnlineDictation)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIOnlineDictation)object).stopDictation();
                return null;
            }
            case 11: {
                ((DSIOnlineDictation)object).setFallbackLanguage((String)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIOnlineDictation)object).activateDictation();
                return null;
            }
            case 13: {
                ((DSIOnlineDictation)object).startDictation((String)objectArray[0], (String)objectArray[1], (String)objectArray[2], (String)objectArray[3]);
                return null;
            }
            case 14: {
                ((DSIOnlineDictation)object).finishDictation();
                return null;
            }
            case 15: {
                ((DSIOnlineDictation)object).rawVoiceDataAvailable((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIOnlineDictation)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIOnlineDictation)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIOnlineDictation)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSIOnlineDictation)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 20: {
                ((DSIOnlineDictation)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSIOnlineDictation)object).clearNotification((DSIListener)objectArray[0]);
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

