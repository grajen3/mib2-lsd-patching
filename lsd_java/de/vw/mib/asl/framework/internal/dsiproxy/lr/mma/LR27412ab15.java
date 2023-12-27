/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener;
import org.dsi.ifc.swdllogging.DSISwdlLoggingListener;

public final class LR27412ab15
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1002384831: {
                if (bl) {
                    if (n2 != 815995234) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 642552384: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1630233596: {
                if (bl) {
                    if (n2 != -1833258442) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1768707983: {
                if (bl) {
                    if (n2 != 676618512) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1963795155: {
                if (bl) {
                    if (n2 != 1953786391) break;
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
            case -2030672442: {
                if (bl) {
                    if (n2 != -851603) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1698305252: {
                if (bl) {
                    if (n2 != 1953786391) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1478755739: {
                if (bl) {
                    if (n2 != -53603983) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1342147861: {
                if (bl) {
                    if (n2 != 612495149) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1266338592: {
                if (bl) {
                    if (n2 != 1160087040) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1023501835: {
                if (bl) {
                    if (n2 != 252948384) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -100368518: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 38928332: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 92847750: {
                if (bl) {
                    if (n2 != -1641380352) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 401380566: {
                if (bl) {
                    if (n2 != 2047298816) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 425788087: {
                if (bl) {
                    if (n2 != -1641380352) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1431362721: {
                if (bl) {
                    if (n2 != 252948384) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1508723674: {
                if (bl) {
                    if (n2 != -247758128) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1551259602: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1962678635: {
                if (bl) {
                    if (n2 != -293143216) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
            case -1767612741: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1370424189: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSISwdlLoggingListener)object).getHistory((String[])objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 1: {
                ((DSISwdlLoggingListener)object).setUpdate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSISwdlLoggingListener)object).getGeneralInformation((Boolean)objectArray[0], (String)objectArray[1], (String)objectArray[2], (Boolean)objectArray[3], (String)objectArray[4], (String)objectArray[5], (int[])objectArray[6], (Boolean)objectArray[7], ((Number)objectArray[8]).intValue(), (int[])objectArray[9]);
                return null;
            }
            case 3: {
                ((DSISwdlLoggingListener)object).getUnusualEvents((int[])objectArray[0], (String[])objectArray[1]);
                return null;
            }
            case 4: {
                ((DSISwdlLoggingListener)object).getUnusualEvent(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], (String)objectArray[3], (byte)((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 5: {
                ((DSISwdlLoggingListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSISwdlDeviceInfoListener)object).getModules(((Number)objectArray[0]).intValue(), (String[])objectArray[1], (int[])objectArray[2], (short[])objectArray[3]);
                return null;
            }
            case 7: {
                ((DSISwdlDeviceInfoListener)object).getErrors(((Number)objectArray[0]).intValue(), (int[])objectArray[1], (short[])objectArray[2]);
                return null;
            }
            case 8: {
                ((DSISwdlDeviceInfoListener)object).getVersions(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (long[])objectArray[2]);
                return null;
            }
            case 9: {
                ((DSISwdlDeviceInfoListener)object).getFileNames(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String[])objectArray[2]);
                return null;
            }
            case 10: {
                ((DSISwdlDeviceInfoListener)object).getAdditionalInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (int[])objectArray[2]);
                return null;
            }
            case 11: {
                ((DSISwdlDeviceInfoListener)object).getPopup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), (String)objectArray[6]);
                return null;
            }
            case 12: {
                ((DSISwdlDeviceInfoListener)object).getDevices((String[])objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 13: {
                ((DSISwdlDeviceInfoListener)object).getLanguages(((Number)objectArray[0]).intValue(), (String[])objectArray[1], (short)((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue(), (short)((Number)objectArray[4]).intValue());
                return null;
            }
            case 14: {
                ((DSISwdlDeviceInfoListener)object).isDataModule(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 15: {
                ((DSISwdlDeviceInfoListener)object).isNoExclusiveBoloUpdate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 16: {
                ((DSISwdlDeviceInfoListener)object).getTargetVersions(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (long[])objectArray[2]);
                return null;
            }
            case 17: {
                ((DSISwdlDeviceInfoListener)object).getFileDetails(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).longValue(), ((Number)objectArray[4]).longValue(), ((Number)objectArray[5]).longValue(), (Boolean)objectArray[6], (Boolean)objectArray[7], (String)objectArray[8], (String)objectArray[9]);
                return null;
            }
            case 18: {
                ((DSISwdlDeviceInfoListener)object).getInfoFilePath(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 19: {
                ((DSISwdlDeviceInfoListener)object).getNumberOfPopups(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSISwdlDeviceInfoListener)object).updateSummaryChanged((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSISwdlDeviceInfoListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

