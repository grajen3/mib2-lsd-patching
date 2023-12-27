/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.DSIExBoxM;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2971c28cf
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1861068976: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1795367085: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1754248912: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1587194288: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1557841376: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1342469844: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 37;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 38;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 39;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1067172274: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 40;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 41;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 42;
                    break;
                }
                n3 = 40;
                break;
            }
            case -891939758: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -697653297: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -593745996: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -342652679: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -340448026: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -338741696: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -268802872: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -205702103: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -185199367: {
                if (bl) {
                    if (n2 != -1949797810) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -166450290: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -75121178: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 180385216: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 194960322: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 212293360: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 270475378: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 350414524: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 444375449: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 883366288: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1074082907: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1124545736: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1153816460: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1167796329: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1178149539: {
                if (bl) {
                    if (n2 != -1019505441) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1389556374: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1422373881: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1510953709: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1654584937: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1706460094: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1950668834: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1984988402: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1719408464: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1430805524: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 51;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 52;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 53;
                    break;
                }
                n3 = 51;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 54;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 55;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 56;
                    break;
                }
                n3 = 54;
                break;
            }
            case -887307080: {
                if (bl) {
                    if (n2 != 2043950673) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 363934080: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 530560710: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 977449129: {
                if (bl) {
                    if (n2 != -330725585) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1400604741: {
                if (bl) {
                    if (n2 != 1061773320) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1711216629: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
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
            case -1567897103: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 417856367: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIDisplayManagement)object).setColor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIDisplayManagement)object).getBrightness(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIDisplayManagement)object).switchDisplayPower(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIDisplayManagement)object).setDisplayBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIDisplayManagement)object).getDisplayBrightness(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIDisplayManagement)object).declareContexts((DisplayContext[])objectArray[0]);
                return null;
            }
            case 6: {
                ((DSIDisplayManagement)object).switchContext(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIDisplayManagement)object).setOpacity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIDisplayManagement)object).fadeToOpacity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 9: {
                ((DSIDisplayManagement)object).setPosition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 10: {
                ((DSIDisplayManagement)object).getExtents(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIDisplayManagement)object).takeScreenshot(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIDisplayManagement)object).lockDisplay(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSIDisplayManagement)object).unlockDisplay(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIDisplayManagement)object).getDisplayPower(((Number)objectArray[0]).intValue());
                return null;
            }
            case 15: {
                ((DSIDisplayManagement)object).setBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIDisplayManagement)object).setContrast(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIDisplayManagement)object).getContrast(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSIDisplayManagement)object).getColor(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIDisplayManagement)object).setTint(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIDisplayManagement)object).getTint(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIDisplayManagement)object).setCropping(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue(), ((Number)objectArray[8]).intValue(), ((Number)objectArray[9]).intValue());
                return null;
            }
            case 22: {
                ((DSIDisplayManagement)object).getDisplayableInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIDisplayManagement)object).setDimension(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 24: {
                ((DSIDisplayManagement)object).setScaleMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((DSIDisplayManagement)object).takeScreenshotOnExternalStorage(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIDisplayManagement)object).setDisplayType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIDisplayManagement)object).getDisplayType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIDisplayManagement)object).setUpdateRate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIDisplayManagement)object).getUpdateRate(((Number)objectArray[0]).intValue());
                return null;
            }
            case 30: {
                ((DSIDisplayManagement)object).startComponent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 31: {
                ((DSIDisplayManagement)object).stopComponent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIDisplayManagement)object).createImageDisplayable((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSIDisplayManagement)object).requestUpdateImageDisplayable((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSIDisplayManagement)object).destroyImageDisplayable(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSIDisplayManagement)object).initAnnotations(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((DSIDisplayManagement)object).setAnnotationData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 37: {
                ((DSIDisplayManagement)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSIDisplayManagement)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSIDisplayManagement)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 40: {
                ((DSIDisplayManagement)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 41: {
                ((DSIDisplayManagement)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 42: {
                ((DSIDisplayManagement)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 43: {
                ((DSIExBoxM)object).displayControl(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSIExBoxM)object).displayCurrentVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSIExBoxM)object).audioRequestRejected(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSIExBoxM)object).displayRequestRejected(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                ((DSIExBoxM)object).volumeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue(), ((Number)objectArray[7]).intValue());
                return null;
            }
            case 48: {
                ((DSIExBoxM)object).resetToFactory();
                return null;
            }
            case 49: {
                ((DSIExBoxM)object).setMobileDeviceLink((MobileDeviceLinkStatus)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIExBoxM)object).requestConnectionControl((ConnectionControl)objectArray[0], (PublicDeviceAddress)objectArray[1]);
                return null;
            }
            case 51: {
                ((DSIExBoxM)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 52: {
                ((DSIExBoxM)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 53: {
                ((DSIExBoxM)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSIExBoxM)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 55: {
                ((DSIExBoxM)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 56: {
                ((DSIExBoxM)object).clearNotification((DSIListener)objectArray[0]);
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

