/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.DSICarlife;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;
import org.dsi.ifc.carlight.DSICarLight;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;

public final class LR2fcb79c81
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2092914586: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1922033385: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1881732288: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1817792592: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1687714292: {
                if (bl) {
                    if (n2 != 1045440080) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1570202673: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1565362294: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1501125489: {
                if (bl) {
                    if (n2 != 325305637) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1462592335: {
                if (bl) {
                    if (n2 != -209046552) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1424593046: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1420828941: {
                if (bl) {
                    if (n2 != -683654680) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1344806925: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1315504029: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1178993058: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 30;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 31;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 32;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1017390078: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 33;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 34;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 35;
                    break;
                }
                n3 = 33;
                break;
            }
            case -854526977: {
                if (bl) {
                    if (n2 != -845171466) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -229174481: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -199127448: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -19439311: {
                if (bl) {
                    if (n2 != -683654680) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 86234892: {
                if (bl) {
                    if (n2 != -209046552) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 89096842: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 321048055: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 447733670: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 554608855: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 690658327: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1403147091: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1403262877: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1641823077: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1873417823: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 2005628895: {
                if (bl) {
                    if (n2 != -1653679357) break;
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
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 44;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 45;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 46;
                    break;
                }
                n3 = 44;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 47;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 48;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 49;
                    break;
                }
                n3 = 47;
                break;
            }
            case -643729347: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -577820634: {
                if (bl) {
                    if (n2 != -785441950) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 20833921: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 1048150480: {
                if (bl) {
                    if (n2 != 1247205152) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1305053385: {
                if (bl) {
                    if (n2 != -820350045) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1777707422: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1849707112: {
                if (bl) {
                    if (n2 != -1160141618) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1984785306: {
                if (bl) {
                    if (n2 != -820350045) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
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
            case -1756258261: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -418342865: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarLight)object).requestIntLightRGBColorList((IntLightRGBColorListUpdateInfo)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICarLight)object).setExtLightComingHome((TimeState)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSICarLight)object).setExtLightLeavingHome((TimeState)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSICarLight)object).setExtLightSwitchOnSensitivity(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSICarLight)object).setExtLightDayLight((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSICarLight)object).setExtLightHeadLightSystem((Boolean)objectArray[0]);
                return null;
            }
            case 6: {
                ((DSICarLight)object).setExtLightGlidingLightSystem((Boolean)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSICarLight)object).setExtLightAdaptive((Boolean)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSICarLight)object).setExtLightTourist((Boolean)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSICarLight)object).setExtLightMotorwayBlinking((MotorwayBlinkingSettings)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSICarLight)object).setExtLightMaskedHighBeam((Boolean)objectArray[0]);
                return null;
            }
            case 11: {
                ((DSICarLight)object).setExtLightAutomaticLight((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSICarLight)object).setExtLightSetFactoryDefault();
                return null;
            }
            case 13: {
                ((DSICarLight)object).setExtLightLaserLight((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSICarLight)object).setExtLightSignatureLight((Boolean)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSICarLight)object).setExtLightHeadlightRange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSICarLight)object).setIntLightIlluminationSet(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarLight)object).setIntLightColour(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSICarLight)object).setIntLightState(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSICarLight)object).setIntLightEnvironment((Boolean)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSICarLight)object).setIntLightSpeed((Boolean)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSICarLight)object).setIntLightTemperature((Boolean)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSICarLight)object).setIntLightBrightness((IntLightBrightness)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSICarLight)object).setIntLightSetFactoryDefault();
                return null;
            }
            case 24: {
                ((DSICarLight)object).setIntLightIlluminationProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarLight)object).setIntLightActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSICarLight)object).setIntLightAmbientLightColor((IntLightRGBValues)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSICarLight)object).setIntLightContourLightColor((IntLightRGBValues)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSICarLight)object).setIntLightFollowUpTime(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSICarLight)object).setIntLightDoorContact((Boolean)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSICarLight)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSICarLight)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarLight)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSICarLight)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSICarLight)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSICarLight)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSICarlife)object).startService((ServiceConfiguration)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSICarlife)object).postButtonEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSICarlife)object).postTouchEvent(((Number)objectArray[0]).intValue(), (TouchEvent[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 39: {
                ((DSICarlife)object).postRotaryEvent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 40: {
                ((DSICarlife)object).setMode((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 41: {
                ((DSICarlife)object).responseModeChange((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 42: {
                ((DSICarlife)object).requestNightMode((Boolean)objectArray[0]);
                return null;
            }
            case 43: {
                ((DSICarlife)object).postCharacterEvent(((Number)objectArray[0]).intValue(), (String[])objectArray[1]);
                return null;
            }
            case 44: {
                ((DSICarlife)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 45: {
                ((DSICarlife)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 46: {
                ((DSICarlife)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSICarlife)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 48: {
                ((DSICarlife)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 49: {
                ((DSICarlife)object).clearNotification((DSIListener)objectArray[0]);
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

