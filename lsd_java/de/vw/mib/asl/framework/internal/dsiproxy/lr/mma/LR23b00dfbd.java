/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;
import org.dsi.ifc.swdllogging.DSISwdlLogging;

public final class LR23b00dfbd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2030672442: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1698305252: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1478755739: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1342147861: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1266338592: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
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
            case -1023501835: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
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
            case -665620683: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -127445235: {
                if (bl) {
                    if (n2 != 1126976480) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -100368518: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 92847750: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 401380566: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 425788087: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1431362721: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1508723674: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1551259602: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1883611529: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1962678635: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
                        n3 = 29;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 30;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 31;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1002384831: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 32;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 33;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 34;
                    break;
                }
                n3 = 32;
                break;
            }
            case -876086270: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 642552384: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1630233596: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1768707983: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1963795155: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
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
            case -1163343897: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1335078319: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISwdlDeviceInfo)object).getModules(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSISwdlDeviceInfo)object).getErrors(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSISwdlDeviceInfo)object).getVersions(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSISwdlDeviceInfo)object).getFileNames(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSISwdlDeviceInfo)object).getAdditionalInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSISwdlDeviceInfo)object).getPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSISwdlDeviceInfo)object).setAccessType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSISwdlDeviceInfo)object).getDevices();
                return null;
            }
            case 8: {
                ((DSISwdlDeviceInfo)object).getLanguages(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSISwdlDeviceInfo)object).isDataModule(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSISwdlDeviceInfo)object).isNoExclusiveBoloUpdate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSISwdlDeviceInfo)object).getTargetVersions(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSISwdlDeviceInfo)object).toggleSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 13: {
                ((DSISwdlDeviceInfo)object).getFileDetails(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue());
                return null;
            }
            case 14: {
                ((DSISwdlDeviceInfo)object).getInfoFilePath(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSISwdlDeviceInfo)object).setDeviceSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSISwdlDeviceInfo)object).getNumberOfPopups();
                return null;
            }
            case 17: {
                ((DSISwdlDeviceInfo)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSISwdlDeviceInfo)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSISwdlDeviceInfo)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSISwdlDeviceInfo)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 21: {
                ((DSISwdlDeviceInfo)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSISwdlDeviceInfo)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSISwdlLogging)object).getHistory();
                return null;
            }
            case 24: {
                ((DSISwdlLogging)object).setUpdate((String)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSISwdlLogging)object).selectSubUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSISwdlLogging)object).getGeneralInformation();
                return null;
            }
            case 27: {
                ((DSISwdlLogging)object).getUnusualEvents();
                return null;
            }
            case 28: {
                ((DSISwdlLogging)object).getUnusualEvent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSISwdlLogging)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 30: {
                ((DSISwdlLogging)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSISwdlLogging)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISwdlLogging)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSISwdlLogging)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSISwdlLogging)object).clearNotification((DSIListener)objectArray[0]);
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

