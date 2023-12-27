/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.carseat.DSICarSeatListener;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.RestSeatStatus;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;
import org.dsi.ifc.carstopwatch.DSICarStopWatchListener;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public final class LR2d7f7c1af
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -1622058773: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1599804464: {
                if (bl) {
                    if (n2 != 25685098) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1456039072: {
                if (bl) {
                    if (n2 != -307957125) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1426537584: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1426537578: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1389908464: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1139972227: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1139972221: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1139971266: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1139971260: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1001682964: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1001682958: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1001682003: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1001681997: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -956525106: {
                if (bl) {
                    if (n2 != -1710398211) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -939517811: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -846764382: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -846764376: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -846763421: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -846763415: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -807949238: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -612204118: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -610498464: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -610498458: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -610497503: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -610497497: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -609392480: {
                if (bl) {
                    if (n2 != 761872838) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -497488388: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -221014654: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -220410084: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -220410078: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -129509389: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -77111516: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -77111510: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -19428853: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 296034092: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 306770894: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 450354569: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 450354575: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 473452109: {
                if (bl) {
                    if (n2 != 773523142) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 515168041: {
                if (bl) {
                    if (n2 != -1234605052) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 561221187: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 675148694: {
                if (bl) {
                    if (n2 != 37335402) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 767837685: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 767837691: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 922388651: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 952565012: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 952565018: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 952565973: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 952565979: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1029417044: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1029417050: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1029418005: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1029418011: {
                if (bl) {
                    if (n2 != -1393824524) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1138760928: {
                if (bl) {
                    if (n2 != 773523142) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1153242268: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1154616521: {
                if (bl) {
                    if (n2 != 37335402) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1158645246: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 1273636545: {
                if (bl) {
                    if (n2 != -1234605052) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1390655592: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1398343312: {
                if (bl) {
                    if (n2 != -1044876681) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 1553593122: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1583876805: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1583876811: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1583877766: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1583877772: {
                if (bl) {
                    if (n2 != -1224039854) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1602246329: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1602246335: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1602247290: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1602247296: {
                if (bl) {
                    if (n2 != 1317957025) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1689158724: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1774870435: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 2124015685: {
                if (bl) {
                    if (n2 != -1577990491) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 2124015691: {
                if (bl) {
                    if (n2 != -1577990491) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 2124016646: {
                if (bl) {
                    if (n2 != -1577990491) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 2124016652: {
                if (bl) {
                    if (n2 != -1577990491) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2106177016: {
                if (bl) {
                    if (n2 != 1061947932) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case -1267812092: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 320173634: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 396071106: {
                if (bl) {
                    if (n2 != 178093581) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 852002883: {
                if (bl) {
                    if (n2 != 1061947932) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 981472226: {
                if (bl) {
                    if (n2 != 1061947932) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 2054546666: {
                if (bl) {
                    if (n2 != -272796491) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
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
            case -1389756467: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -790246525: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarSeatListener)object).updateSeatViewOptions((SeatViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSICarSeatListener)object).updateSeatRadioKeyAutomatic((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICarSeatListener)object).updateSeatSpecialPosition((SeatSpecialPosition)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarSeatListener)object).updateSeatSpecialPositionRearCoDriver((SeatSpecialPosition)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarSeatListener)object).updateSeatFrontLeftStopButton((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarSeatListener)object).updateSeatFrontRightStopButton((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarSeatListener)object).updateSeatRearLeftStopButton((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICarSeatListener)object).updateSeatRearRightStopButton((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSICarSeatListener)object).updateSeatCodriverSettingsFromDriver((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSICarSeatListener)object).updateSeatCodriverSettingsFromRear((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarSeatListener)object).updateSeatMassageData1RL((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarSeatListener)object).updateSeatMassageData1RR((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSICarSeatListener)object).updateSeatMassageData2RL((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarSeatListener)object).updateSeatMassageData2RR((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataUp1RL((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataDown1RL((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataForward1RL((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataBack1RL((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataUp1RR((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataDown1RR((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataForward1RR((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataBack1RR((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataUp2RL((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataDown2RL((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataForward2RL((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataBack2RL((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataUp2RR((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataDown2RR((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataForward2RR((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSICarSeatListener)object).updateSeatSwitcherDataBack2RR((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSICarSeatListener)object).updateSeatContent((SeatContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSICarSeatListener)object).updateSeatEasyEntryFrontLeft((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarSeatListener)object).updateSeatEasyEntryFrontRight((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSICarSeatListener)object).updateSeatEasyEntryRearLeft((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSICarSeatListener)object).updateSeatEasyEntryRearRight((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSICarSeatListener)object).requestSeatPopup((SeatContent)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSICarSeatListener)object).acknowledgeSeatPopup((SeatContent)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSICarSeatListener)object).updateSeatPneumaticViewOptions((SeatPneumaticViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSICarSeatListener)object).updateSeatPneumaticCodriverSettingsFromDriver((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSICarSeatListener)object).updateSeatPneumaticMassageData1RL((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarSeatListener)object).updateSeatPneumaticMassageData1RR((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataUp1RL((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataDown1RL((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataForward1RL((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataBack1RL((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataUp1RR((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataDown1RR((SwitcherDataUpDown)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataForward1RR((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSICarSeatListener)object).updateSeatPneumaticSwitcherDataBack1RR((SwitcherDataBackForward)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSICarSeatListener)object).updateSeatPneumaticContent((SeatPneumaticContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSICarSeatListener)object).requestSeatPneumaticPopup((SeatPneumaticContent)objectArray[0]);
                return null;
            }
            case 51: {
                ((DSICarSeatListener)object).acknowledgeSeatPneumaticPopup((SeatPneumaticContent)objectArray[0]);
                return null;
            }
            case 52: {
                ((DSICarSeatListener)object).acknowledgeSeatSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 53: {
                ((DSICarSeatListener)object).acknowledgeSeatPneumaticSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSICarSeatListener)object).acknowledgeSeatDeleteSpecialPosition((Boolean)objectArray[0]);
                return null;
            }
            case 55: {
                ((DSICarSeatListener)object).acknowledgeSeatMoveRearSeatDisplay((Boolean)objectArray[0]);
                return null;
            }
            case 56: {
                ((DSICarSeatListener)object).updateSeatAdjustment1RL((SeatAdjustment)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSICarSeatListener)object).updateSeatAdjustment1RR((SeatAdjustment)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarSeatListener)object).updateSeatAdjustment2RL((SeatAdjustment)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSICarSeatListener)object).updateSeatAdjustment2RR((SeatAdjustment)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSICarSeatListener)object).updateSeatCoDriverSettingsFromRearActivation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSICarSeatListener)object).updateSeatRestSeatStatus((RestSeatStatus)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSICarSeatListener)object).updateSeatFoldHeadRestRearDriver((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSICarSeatListener)object).updateSeatFoldHeadRestRearCoDriver((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageData1RL((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageData1RR((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageData2RL((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageData2RR((MassageData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageSwitcher1RL((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageSwitcher1RR((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 70: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageSwitcher2RL((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSICarSeatListener)object).updateSeatPremiumMassageSwitcher2RR((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSICarSeatListener)object).updateSeatMassageSwitcher1RL((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSICarSeatListener)object).updateSeatMassageSwitcher1RR((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSICarSeatListener)object).updateSeatMassageSwitcher2RL((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSICarSeatListener)object).updateSeatMassageSwitcher2RR((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSICarSeatListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 77: {
                ((DSICarStopWatchListener)object).updateStopWatchViewOptions((StopWatchViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((DSICarStopWatchListener)object).updateStopWatchState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSICarStopWatchListener)object).updateStopWatchCurrentLapNumber(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 80: {
                ((DSICarStopWatchListener)object).updateStopWatchTotalTime((StopWatchTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 81: {
                ((DSICarStopWatchListener)object).updateStopWatchLastSplitTime(((Number)objectArray[0]).intValue(), (StopWatchTime)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 82: {
                ((DSICarStopWatchListener)object).updateStopWatchCurrentLapTime((StopWatchTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((DSICarStopWatchListener)object).updateStopWatchLastLapTime((StopWatchTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((DSICarStopWatchListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
                case 2: {
                    return this.f2(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

