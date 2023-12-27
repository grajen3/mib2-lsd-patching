/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.reflection.generated.mma;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.internal.car.e_traction.StateBatteryControlAvailable;
import de.vw.mib.asl.internal.car.e_traction.StateBatteryControlNotAvailable;
import de.vw.mib.asl.internal.car.fpa.mlb511.StateWork511;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOff;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOn;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOffroad;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOps;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOpsAuto;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnOpsVps;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOnVps;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupSettings;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateWaitConfirmationToClose;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateWaitConfirmationToShow;
import de.vw.mib.asl.internal.car.viewoption.StateWork;
import de.vw.mib.asl.internal.car.viewoption.StateWorkMLB;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.powermanagement.ClampSignal;

public final class LR2e068383d
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2108523610: {
                if (bl) {
                    if (n2 != -466692679) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -2108523609: {
                if (bl) {
                    if (n2 != 1597232569) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -2108523608: {
                if (bl) {
                    if (n2 != -633875015) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -2108523607: {
                if (bl) {
                    if (n2 != 1430050233) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -2108523606: {
                if (bl) {
                    if (n2 != -801057351) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -2108523605: {
                if (bl) {
                    if (n2 != 1262867897) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -2108523604: {
                if (bl) {
                    if (n2 != -968239687) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -2108523603: {
                if (bl) {
                    if (n2 != 1095685561) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -2108523588: {
                if (bl) {
                    if (n2 != -191968544) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1783070896: {
                if (bl) {
                    if (n2 != -200270971) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1713784335: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -406310224: {
                if (bl) {
                    if (n2 != 342845610) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -321374209: {
                if (bl) {
                    if (n2 != -105458462) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -6721520: {
                if (bl) {
                    if (n2 != 97989933) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -6721519: {
                if (bl) {
                    if (n2 != 97989933) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -6721518: {
                if (bl) {
                    if (n2 != 97989933) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 107140050: {
                if (bl) {
                    if (n2 != 910546598) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 133648150: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 159402851: {
                if (bl) {
                    if (n2 != -808166167) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 382653905: {
                if (bl) {
                    if (n2 != 319559816) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 670387182: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 782193908: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1017935193: {
                if (bl) {
                    if (n2 != 704123126) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1017935194: {
                if (bl) {
                    if (n2 != -1526984458) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1017935195: {
                if (bl) {
                    if (n2 != 520163830) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1017935214: {
                if (bl) {
                    if (n2 != 1079382518) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1017935215: {
                if (bl) {
                    if (n2 != 952534399) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1303170792: {
                if (bl) {
                    if (n2 != 250678428) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1303654919: {
                if (bl) {
                    if (n2 != 760485020) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1630424408: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1948379651: {
                if (bl) {
                    if (n2 != -43508118) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -321374209: {
                if (bl) {
                    if (n2 != -105458462) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1933122064: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1650232154: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1541466129: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1468109815: {
                if (bl) {
                    if (n2 != 187343945) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1083390182: {
                if (bl) {
                    if (n2 != 1157836657) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -69505944: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -66483959: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 506413841: {
                if (bl) {
                    if (n2 != -1021604319) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 698037350: {
                if (bl) {
                    if (n2 != -1965790868) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 866625692: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 901076607: {
                if (bl) {
                    if (n2 != 3540) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 973326866: {
                if (bl) {
                    if (n2 != -866704464) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1579581280: {
                if (bl) {
                    if (n2 != 1298276815) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1814317970: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1917713619: {
                if (bl) {
                    if (n2 != 1094169551) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 2037044767: {
                if (bl) {
                    if (n2 != -854988625) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 2093387969: {
                if (bl) {
                    if (n2 != 1810428024) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1933122064: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1650232154: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1541466129: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1468109815: {
                if (bl) {
                    if (n2 != 187343945) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1083390182: {
                if (bl) {
                    if (n2 != 1157836657) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -69505944: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -66483959: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 506413841: {
                if (bl) {
                    if (n2 != -1021604319) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 698037350: {
                if (bl) {
                    if (n2 != -1965790868) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 866625692: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 870518126: {
                if (bl) {
                    if (n2 != 1278449853) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 901076607: {
                if (bl) {
                    if (n2 != 3540) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 973326866: {
                if (bl) {
                    if (n2 != -866704464) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1579581280: {
                if (bl) {
                    if (n2 != 1298276815) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1814317970: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1917713619: {
                if (bl) {
                    if (n2 != 1094169551) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 2037044767: {
                if (bl) {
                    if (n2 != -854988625) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 2093387969: {
                if (bl) {
                    if (n2 != 1810428024) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1877525100: {
                if (bl) {
                    if (n2 != 272553032) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1698945944: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case -1606400844: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case -1349867042: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1206697402: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case -1162535921: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -912747218: {
                if (bl) {
                    if (n2 != 1348953182) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -901940959: {
                if (bl) {
                    if (n2 != 643841529) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case -857333902: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -816500674: {
                if (bl) {
                    if (n2 != -1047718335) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case -801457162: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -704501901: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case -600562181: {
                if (bl) {
                    if (n2 != 420579393) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -530889831: {
                if (bl) {
                    if (n2 != 1752413482) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -485233924: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -458131801: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case -9743186: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case 378862867: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case 382753428: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case 460444215: {
                if (bl) {
                    if (n2 != -1792927924) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 572759901: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 598363192: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 794128008: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 848935593: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 894713370: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 965078833: {
                if (bl) {
                    if (n2 != -1826765962) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case 1030444604: {
                if (bl) {
                    if (n2 != -1139860805) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 1030570919: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1224997995: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 1307153682: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case 1378366448: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1400832142: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 1515262436: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 1604111637: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 1771838444: {
                if (bl) {
                    if (n2 != 643841529) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case 1772017033: {
                if (bl) {
                    if (n2 != 1348953182) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case 1789386405: {
                if (bl) {
                    if (n2 != -374655301) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case 1800192664: {
                if (bl) {
                    if (n2 != -1079767210) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 1807937008: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case 1811944139: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 1840976556: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 1963623445: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 2089484253: {
                if (bl) {
                    if (n2 != 2067052858) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 2093387969: {
                if (bl) {
                    if (n2 != 1810428024) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case 2136098709: {
                if (bl) {
                    if (n2 != -1079767210) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case 2136277298: {
                if (bl) {
                    if (n2 != -374655301) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
        }
        return n3;
    }

    private int a5(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -635528081: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -599449969: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case 303225184: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case 848935593: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case 880768071: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 894713370: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case 1811944139: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case 1867380184: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 1963623445: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
        }
        return n3;
    }

    private int a6(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
        }
        return n3;
    }

    private int a7(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
        }
        return n3;
    }

    private int a8(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
        }
        return n3;
    }

    private int a9(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1206697402: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
        }
        return n3;
    }

    private int a10(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1206697402: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
        }
        return n3;
    }

    private int a11(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -485714172: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
        }
        return n3;
    }

    private int a12(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 1811944139: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case 1867380184: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 2093387969: {
                if (bl) {
                    if (n2 != 1810428024) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
        }
        return n3;
    }

    private int a13(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case 1811944139: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 1867380184: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
        }
        return n3;
    }

    private int a14(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2134039136: {
                if (bl) {
                    if (n2 != 874778500) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case -1877525100: {
                if (bl) {
                    if (n2 != 272553032) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case -1536037046: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case -1401054410: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case -1389455617: {
                if (bl) {
                    if (n2 != -1514740036) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case -1381028954: {
                if (bl) {
                    if (n2 != 1752413482) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -1331687598: {
                if (bl) {
                    if (n2 != 115110034) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case -1313725250: {
                if (bl) {
                    if (n2 != 309827049) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case -1227635678: {
                if (bl) {
                    if (n2 != 3568538) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -822223540: {
                if (bl) {
                    if (n2 != -924992889) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case -770863411: {
                if (bl) {
                    if (n2 != 1030378054) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
                break;
            }
            case -355836068: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -175072338: {
                if (bl) {
                    if (n2 != -2146781421) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case -49211018: {
                if (bl) {
                    if (n2 != 39962012) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case -28140971: {
                if (bl) {
                    if (n2 != -913457456) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 143527780: {
                if (bl) {
                    if (n2 != -969028795) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 222066001: {
                if (bl) {
                    if (n2 != -1050339275) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case 316975838: {
                if (bl) {
                    if (n2 != 855492426) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 361745044: {
                if (bl) {
                    if (n2 != -560061485) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 463853840: {
                if (bl) {
                    if (n2 != -1931910444) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 543903453: {
                if (bl) {
                    if (n2 != -1153660080) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case 598654537: {
                if (bl) {
                    if (n2 != 1099873457) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 698037350: {
                if (bl) {
                    if (n2 != -1965790868) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case 738128218: {
                if (bl) {
                    if (n2 != 1752413482) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 760477270: {
                if (bl) {
                    if (n2 != 1625381423) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case 769462868: {
                if (bl) {
                    if (n2 != 847543313) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 897831280: {
                if (bl) {
                    if (n2 != 70637142) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case 898026314: {
                if (bl) {
                    if (n2 != -959757330) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case 1050284011: {
                if (bl) {
                    if (n2 != 2138303583) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 1152848410: {
                if (bl) {
                    if (n2 != -51814086) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case 1343332657: {
                if (bl) {
                    if (n2 != -1381904888) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 1787199946: {
                if (bl) {
                    if (n2 != 1951127501) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case 1798911937: {
                if (bl) {
                    if (n2 != -307957125) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case 1818199330: {
                if (bl) {
                    if (n2 != -1362357492) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case 2035165368: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case 2089484253: {
                if (bl) {
                    if (n2 != 2067052858) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case 2093387969: {
                if (bl) {
                    if (n2 != 1810428024) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
        }
        return n3;
    }

    private int a15(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2134039136: {
                if (bl) {
                    if (n2 != 874778500) break;
                    n3 = 184;
                    break;
                }
                n3 = 184;
                break;
            }
            case -1938263454: {
                if (bl) {
                    if (n2 != -603497900) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case -1877525100: {
                if (bl) {
                    if (n2 != 272553032) break;
                    n3 = 178;
                    break;
                }
                n3 = 178;
                break;
            }
            case -1536037046: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 185;
                    break;
                }
                n3 = 185;
                break;
            }
            case -1401054410: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 192;
                    break;
                }
                n3 = 192;
                break;
            }
            case -1389455617: {
                if (bl) {
                    if (n2 != -1514740036) break;
                    n3 = 208;
                    break;
                }
                n3 = 208;
                break;
            }
            case -1381028954: {
                if (bl) {
                    if (n2 != 1752413482) break;
                    n3 = 188;
                    break;
                }
                n3 = 188;
                break;
            }
            case -1331687598: {
                if (bl) {
                    if (n2 != 115110034) break;
                    n3 = 200;
                    break;
                }
                n3 = 200;
                break;
            }
            case -1313725250: {
                if (bl) {
                    if (n2 != 309827049) break;
                    n3 = 196;
                    break;
                }
                n3 = 196;
                break;
            }
            case -1227635678: {
                if (bl) {
                    if (n2 != 3568538) break;
                    n3 = 189;
                    break;
                }
                n3 = 189;
                break;
            }
            case -822223540: {
                if (bl) {
                    if (n2 != -924992889) break;
                    n3 = 177;
                    break;
                }
                n3 = 177;
                break;
            }
            case -770863411: {
                if (bl) {
                    if (n2 != 1030378054) break;
                    n3 = 209;
                    break;
                }
                n3 = 209;
                break;
            }
            case -355836068: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 190;
                    break;
                }
                n3 = 190;
                break;
            }
            case -175072338: {
                if (bl) {
                    if (n2 != -2146781421) break;
                    n3 = 182;
                    break;
                }
                n3 = 182;
                break;
            }
            case -49211018: {
                if (bl) {
                    if (n2 != 39962012) break;
                    n3 = 202;
                    break;
                }
                n3 = 202;
                break;
            }
            case -28140971: {
                if (bl) {
                    if (n2 != -913457456) break;
                    n3 = 181;
                    break;
                }
                n3 = 181;
                break;
            }
            case 143527780: {
                if (bl) {
                    if (n2 != -969028795) break;
                    n3 = 197;
                    break;
                }
                n3 = 197;
                break;
            }
            case 155424227: {
                if (bl) {
                    if (n2 != -982651138) break;
                    n3 = 176;
                    break;
                }
                n3 = 176;
                break;
            }
            case 222066001: {
                if (bl) {
                    if (n2 != -1050339275) break;
                    n3 = 210;
                    break;
                }
                n3 = 210;
                break;
            }
            case 316975838: {
                if (bl) {
                    if (n2 != 855492426) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case 361745044: {
                if (bl) {
                    if (n2 != -560061485) break;
                    n3 = 194;
                    break;
                }
                n3 = 194;
                break;
            }
            case 463853840: {
                if (bl) {
                    if (n2 != -1931910444) break;
                    n3 = 179;
                    break;
                }
                n3 = 179;
                break;
            }
            case 543903453: {
                if (bl) {
                    if (n2 != -1153660080) break;
                    n3 = 211;
                    break;
                }
                n3 = 211;
                break;
            }
            case 598654537: {
                if (bl) {
                    if (n2 != 1099873457) break;
                    n3 = 207;
                    break;
                }
                n3 = 207;
                break;
            }
            case 698037350: {
                if (bl) {
                    if (n2 != -1965790868) break;
                    n3 = 187;
                    break;
                }
                n3 = 187;
                break;
            }
            case 738128218: {
                if (bl) {
                    if (n2 != 1752413482) break;
                    n3 = 212;
                    break;
                }
                n3 = 212;
                break;
            }
            case 760477270: {
                if (bl) {
                    if (n2 != 1625381423) break;
                    n3 = 195;
                    break;
                }
                n3 = 195;
                break;
            }
            case 769462868: {
                if (bl) {
                    if (n2 != 847543313) break;
                    n3 = 204;
                    break;
                }
                n3 = 204;
                break;
            }
            case 897831280: {
                if (bl) {
                    if (n2 != 70637142) break;
                    n3 = 191;
                    break;
                }
                n3 = 191;
                break;
            }
            case 898026314: {
                if (bl) {
                    if (n2 != -959757330) break;
                    n3 = 198;
                    break;
                }
                n3 = 198;
                break;
            }
            case 1050284011: {
                if (bl) {
                    if (n2 != 2138303583) break;
                    n3 = 193;
                    break;
                }
                n3 = 193;
                break;
            }
            case 1152848410: {
                if (bl) {
                    if (n2 != -51814086) break;
                    n3 = 199;
                    break;
                }
                n3 = 199;
                break;
            }
            case 1343332657: {
                if (bl) {
                    if (n2 != -1381904888) break;
                    n3 = 180;
                    break;
                }
                n3 = 180;
                break;
            }
            case 1787199946: {
                if (bl) {
                    if (n2 != 1951127501) break;
                    n3 = 201;
                    break;
                }
                n3 = 201;
                break;
            }
            case 1798911937: {
                if (bl) {
                    if (n2 != -307957125) break;
                    n3 = 206;
                    break;
                }
                n3 = 206;
                break;
            }
            case 1818199330: {
                if (bl) {
                    if (n2 != -1362357492) break;
                    n3 = 203;
                    break;
                }
                n3 = 203;
                break;
            }
            case 2035165368: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 186;
                    break;
                }
                n3 = 186;
                break;
            }
            case 2089484253: {
                if (bl) {
                    if (n2 != 2067052858) break;
                    n3 = 205;
                    break;
                }
                n3 = 205;
                break;
            }
            case 2093387969: {
                if (bl) {
                    if (n2 != 1810428024) break;
                    n3 = 183;
                    break;
                }
                n3 = 183;
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
            case -1700861317: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1331627134: {
                n2 = this.a13(n4, bl, n);
                break;
            }
            case -983898105: {
                n2 = this.a7(n4, bl, n);
                break;
            }
            case -983891378: {
                n2 = this.a10(n4, bl, n);
                break;
            }
            case -935083279: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case 251454770: {
                n2 = this.a14(n4, bl, n);
                break;
            }
            case 433563236: {
                n2 = this.a6(n4, bl, n);
                break;
            }
            case 647427355: {
                n2 = this.a15(n4, bl, n);
                break;
            }
            case 721458286: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 730407126: {
                n2 = this.a8(n4, bl, n);
                break;
            }
            case 829384414: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 1436332917: {
                n2 = this.a5(n4, bl, n);
                break;
            }
            case 1576628451: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case 1654555741: {
                n2 = this.a12(n4, bl, n);
                break;
            }
            case 1824697468: {
                n2 = this.a9(n4, bl, n);
                break;
            }
            case 1871103225: {
                n2 = this.a11(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((StateBatteryControlAvailable)object).dsiCarTimeUnitsLanguageUpdateClockTime((ClockTime)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((StateBatteryControlAvailable)object).dsiCarTimeUnitsLanguageUpdateClockFormat(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((StateBatteryControlAvailable)object).dsiCarTimeUnitsLanguageUpdateClockDate((ClockDate)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlViewOptions((BatteryControlViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateHybridActivePedal((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((StateBatteryControlAvailable)object).dsiCarHybridAcknowledgeBatteryControlSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 6: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponsePowerProviderListRA0((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA0[])objectArray[1]);
                return null;
            }
            case 7: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponsePowerProviderListRA1((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA1[])objectArray[1]);
                return null;
            }
            case 8: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponsePowerProviderListRA2((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRA2[])objectArray[1]);
                return null;
            }
            case 9: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponsePowerProviderListRAE((BatteryControlPowerProviderAH)objectArray[0], (BatteryControlPowerProviderRAE[])objectArray[1]);
                return null;
            }
            case 10: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponsePowerProviderListRAF((BatteryControlPowerProviderAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 11: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA0((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA0[])objectArray[1]);
                return null;
            }
            case 12: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA1((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA1[])objectArray[1]);
                return null;
            }
            case 13: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA2((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA2[])objectArray[1]);
                return null;
            }
            case 14: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA3((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA3[])objectArray[1]);
                return null;
            }
            case 15: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA4((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA4[])objectArray[1]);
                return null;
            }
            case 16: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA5((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA5[])objectArray[1]);
                return null;
            }
            case 17: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA6((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA6[])objectArray[1]);
                return null;
            }
            case 18: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRA7((BatteryControlProfilesAH)objectArray[0], (BatteryControlProfileRA7[])objectArray[1]);
                return null;
            }
            case 19: {
                ((StateBatteryControlAvailable)object).dsiCarHybridResponseProfileListRAF((BatteryControlProfilesAH)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 20: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlChargeState((BatteryControlChargeState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlClimateState((BatteryControlClimateState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlPlug((BatteryControlPlug)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlPowerProviderListUpdateInfo((BatteryControlPowerProviderAH)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 24: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlProfilesListUpdateInfo((BatteryControlProfilesAH)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlTimer1((BatteryControlTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlTimer2((BatteryControlTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlTimer3((BatteryControlTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlTimerState((BatteryControlTimerState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlTotalNumberOfPowerProvider(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((StateBatteryControlAvailable)object).dsiCarHybridUpdateBatteryControlTotalNumberOfProfiles(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((StateBatteryControlNotAvailable)object).dsiCarHybridUpdateBatteryControlViewOptions((BatteryControlViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiPowerManagementUpdateClampSignal((ClampSignal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsUpdateCharismaViewOptions((CharismaViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarVehicleStatesUpdateDynamicVehicleInfoMidFrequent((DynamicVehicleInfoMidFrequent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsRequestCharismaPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 36: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsUpdateCharismaContent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsAcknowledgeCharismaPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 38: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsUpdateCharismaActiveProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsUpdateCharismaListUpdateInfo((CharismaListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsResponseCharismaListWithOptionMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CharismaSetupTableWithOptionMask[])objectArray[3]);
                return null;
            }
            case 41: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).dsiCarDrivingCharacteristicsResponseCharismaListWithoutOptionMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CharismaSetupTableWithoutOptionMask[])objectArray[3]);
                return null;
            }
            case 42: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).requestCharismaListUpdate((CharismaListUpdateInfo)objectArray[0]);
                return null;
            }
            case 43: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).changeActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).changeCharismaSetupTableWithoutOptionMask(((Number)objectArray[0]).intValue(), (CharismaSetupTableWithoutOptionMask[])objectArray[1]);
                return null;
            }
            case 45: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).changeCharismaSetupTableWithOptionMask(((Number)objectArray[0]).intValue(), (CharismaSetupTableWithOptionMask[])objectArray[1]);
                return null;
            }
            case 46: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).updateActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                return ((de.vw.mib.asl.internal.car.fpa.StateWork)object).getAvailableProfiles();
            }
            case 48: {
                ((de.vw.mib.asl.internal.car.fpa.StateWork)object).updateAvailableProfiles((boolean[])objectArray[0]);
                return null;
            }
            case 49: {
                StateWork511.setupInitialCharismaList((ArrayList)objectArray[0]);
                return null;
            }
            case 50: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsUpdateCharismaActiveProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((StateWork511)object).dsiPowerManagementUpdateClampSignal((ClampSignal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsUpdateCharismaViewOptions((CharismaViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((StateWork511)object).dsiCarVehicleStatesUpdateDynamicVehicleInfoMidFrequent((DynamicVehicleInfoMidFrequent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsRequestCharismaPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 55: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsUpdateCharismaContent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsAcknowledgeCharismaPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 57: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsUpdateCharismaListUpdateInfo((CharismaListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsResponseCharismaListWithOptionMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CharismaSetupTableWithOptionMask[])objectArray[3]);
                return null;
            }
            case 59: {
                ((StateWork511)object).dsiCarDrivingCharacteristicsResponseCharismaListWithoutOptionMask(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (CharismaSetupTableWithoutOptionMask[])objectArray[3]);
                return null;
            }
            case 60: {
                ((StateWork511)object).requestCharismaListUpdate((CharismaListUpdateInfo)objectArray[0]);
                return null;
            }
            case 61: {
                ((StateWork511)object).changeActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 62: {
                ((StateWork511)object).changeCharismaSetupTableWithoutOptionMask(((Number)objectArray[0]).intValue(), (CharismaSetupTableWithoutOptionMask[])objectArray[1]);
                return null;
            }
            case 63: {
                ((StateWork511)object).changeCharismaSetupTableWithOptionMask(((Number)objectArray[0]).intValue(), (CharismaSetupTableWithOptionMask[])objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((StateWork511)object).updateActiveProfile(((Number)objectArray[0]).intValue());
                return null;
            }
            case 65: {
                return ((StateWork511)object).getAvailableProfiles();
            }
            case 66: {
                ((StateWork511)object).updateAvailableProfiles((boolean[])objectArray[0]);
                return null;
            }
            case 67: {
                ((StatePopupOff)object).dsiCarDriverAssistanceUpdateSWAViewOptions((SWAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((StatePopupOff)object).dsiPowerManagementUpdateClampSignal((ClampSignal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((StatePopupOff)object).onSuccess((Access)objectArray[0]);
                return null;
            }
            case 70: {
                ((StatePopupOff)object).onError();
                return null;
            }
            case 71: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateParkingSystemViewOptions((ParkingSystemViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((StatePopupOff)object).dsiCarParkingSystemRequestParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 73: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSVideoInfo((VPSVideoInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCInfo((PDCInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((StatePopupOff)object).dsiCarParkingSystemAcknowledgeVpsSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 77: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 80: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCMute((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 81: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCVolumeFront(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 82: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCVolumeRear(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 83: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCFrequenceFront(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 84: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCFrequenceRear(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCOPSAutoActivation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 86: {
                ((StatePopupOff)object).dsiSoundUpdateLoweringEntertainment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 87: {
                ((StatePopupOff)object).dsiCarComfortUpdateBrakeElectricalParking((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((StatePopupOff)object).dsiGeneralVehicleStatesUpdateAcousticParkingSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 89: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCOffroadMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 90: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSColor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 91: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSContrast(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 92: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 93: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCSystemOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 94: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSExtCamConfig(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 95: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCParkboxVisualisation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCSteeringInformation((PDCSteeringInformation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 97: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSExtCamManActivation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 98: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPS3DBirdview(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 99: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCTrailerHitched((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 100: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCStatusLevelFront((PDCStatusLevelFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 101: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCStatusLevelRear((PDCStatusLevelFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 102: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCStatusLevelRight((PDCStatusLevelRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 103: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCStatusLevelLeft((PDCStatusLevelRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 104: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCDistanceValuesFront((PDCDistanceValuesFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 105: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCDistanceValuesRear((PDCDistanceValuesFrontRear)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 106: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCDistanceValuesRight((PDCDistanceValuesRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 107: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCDistanceValuesLeft((PDCDistanceValuesRightLeft)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((StatePopupOff)object).dsiCarDriverAssistanceUpdateSWARCTASensorData((SWARCTASensorData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCManeuverAssistConfig(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 110: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdatePDCManeuverAssist((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 111: {
                ((StatePopupOff)object).dsiCarParkingSystemAcknowledgePdcSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 112: {
                ((StatePopupOff)object).dsiCarParkingSystemUpdateVPSSystemState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((StatePopupOff)object).dsiCarDriverAssistanceUpdateSWAExitAssist((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                ((StatePopupOn)object).updateColor(((Number)objectArray[0]).intValue());
                return null;
            }
            case 115: {
                ((StatePopupOn)object).updateContrast(((Number)objectArray[0]).intValue());
                return null;
            }
            case 116: {
                ((StatePopupOn)object).updateBrightness(((Number)objectArray[0]).intValue());
                return null;
            }
            case 117: {
                ((StatePopupOn)object).dsiCarParkingSystemRequestParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 118: {
                ((StatePopupOn)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 119: {
                ((StatePopupOn)object).dsiCarParkingSystemUpdateVPSColor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                ((StatePopupOn)object).dsiCarParkingSystemUpdateVPSContrast(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                ((StatePopupOn)object).dsiCarParkingSystemUpdateVPSBrightness(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                ((StatePopupOn)object).dsiCarParkingSystemAcknowledgeParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 123: {
                ((StatePopupOn)object).dsiCarParkingSystemResponseLifeMonitoring((Boolean)objectArray[0]);
                return null;
            }
            case 124: {
                ((StatePopupOnOffroad)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 125: {
                ((StatePopupOnOps)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 126: {
                ((StatePopupOnOpsAuto)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 127: {
                ((StatePopupOnOpsVps)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((StatePopupOnOpsVps)object).dsiCarParkingSystemUpdatePDCFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 129: {
                ((StatePopupOnVps)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 130: {
                ((StatePopupOnVps)object).dsiCarParkingSystemUpdatePDCFailure((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 131: {
                ((StatePopupSettings)object).dsiCarParkingSystemUpdateParkingPopupContent((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 132: {
                ((StateWaitConfirmationToClose)object).dsiPowerManagementUpdateClampSignal((ClampSignal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 133: {
                ((StateWaitConfirmationToClose)object).dsiCarParkingSystemRequestParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 134: {
                ((StateWaitConfirmationToClose)object).dsiCarParkingSystemAcknowledgeParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 135: {
                ((StateWaitConfirmationToShow)object).dsiCarParkingSystemRequestParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 136: {
                ((StateWaitConfirmationToShow)object).dsiCarParkingSystemAcknowledgeParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 137: {
                ((StateWork)object).dsiCarDriverAssistanceUpdateTSDViewOptions((TSDViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 138: {
                ((StateWork)object).dsiCarDriverAssistanceUpdateSWAViewOptions((SWAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 139: {
                ((StateWork)object).dsiCarDriverAssistanceUpdateACCViewOptions((ACCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 140: {
                ((StateWork)object).dsiCarDriverAssistanceUpdateAWVViewOptions((AWVViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 141: {
                ((StateWork)object).dsiCarEcoUpdateBCmEViewOptions((BCmEViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 142: {
                ((StateWork)object).dsiCarKombiUpdateBCViewOptions((BCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 143: {
                ((StateWork)object).dsiPowerManagementUpdateClampSignal((ClampSignal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                ((StateWork)object).dsiCarComfortUpdateDoorLockingViewOptions((DoorLockingViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 145: {
                ((StateWork)object).dsiGeneralVehicleStatesUpdateVehicleStandstill((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 146: {
                ((StateWork)object).dsiGeneralVehicleStatesUpdateCarVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 147: {
                ((StateWork)object).dsiCarDrivingCharacteristicsUpdateCharismaViewOptions((CharismaViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 148: {
                ((StateWork)object).onSuccess_funcAdap((Access)objectArray[0]);
                return null;
            }
            case 149: {
                ((StateWork)object).dsiCarLightUpdateIntLightViewOptions((IntLightViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 150: {
                ((StateWork)object).onFactoryResetStateChanged(((Number)objectArray[0]).intValue());
                return null;
            }
            case 151: {
                ((StateWork)object).dsiCarComfortUpdateRDKViewOptions((RDKViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 152: {
                return StateWork.getDeviceManager();
            }
            case 153: {
                ((StateWork)object).dsiCarComfortUpdateRGSViewOptions((RGSViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 154: {
                ((StateWork)object).dsiCarComfortUpdateMirrorViewOptions((MirrorViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 155: {
                ((StateWork)object).dsiCarComfortUpdateUGDOViewOptions((UGDOViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 156: {
                ((StateWork)object).dsiCarComfortUpdateWiperViewOptions((WiperViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 157: {
                ((StateWork)object).dsiCarComfortUpdateBrakeViewOptions((BrakeViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 158: {
                ((StateWork)object).dsiCarDriverAssistanceUpdateLDWHCAViewOptions((LDWHCAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 159: {
                ((StateWork)object).dsiCarDriverAssistanceUpdateMKEViewOptions((MKEViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((StateWork)object).dsiCarDriverAssistanceUpdatePAViewOptions((PAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 161: {
                ((StateWork)object).dsiCarEcoUpdateEAViewOptions((EAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 162: {
                ((StateWork)object).dsiCarEcoUpdateStartStopViewOptions((StartStopViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 163: {
                ((StateWork)object).dsiCarKombiUpdateHUDViewOptions((HUDViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 164: {
                ((StateWork)object).dsiCarKombiUpdateSIAViewOptions((SIAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 165: {
                ((StateWork)object).dsiCarLightUpdateExtLightViewOptions((ExtLightViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 166: {
                ((StateWork)object).dsiCarParkingSystemUpdateParkingSystemViewOptions((ParkingSystemViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 167: {
                ((StateWork)object).dsiCarSeatUpdateSeatViewOptions((SeatViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 168: {
                ((StateWork)object).dsiCarTimeUnitsLanguageUpdateClockViewOptions((ClockViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 169: {
                ((StateWork)object).dsiCarTimeUnitsLanguageUpdateUnitmasterViewOptions((UnitmasterViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 170: {
                ((StateWork)object).dsiCarVehicleStatesUpdateVINViewOption((CarViewOption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 171: {
                ((StateWork)object).dsiCarVehicleStatesUpdateVehicleInfoViewOptions((VehicleInfoViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 172: {
                ((StateWork)object).dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerViewOptions((AuxHeaterCoolerViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 173: {
                ((StateWork)object).onSuccess_coding((Access)objectArray[0]);
                return null;
            }
            case 174: {
                ((StateWorkMLB)object).dsiCarDrivingCharacteristicsUpdateSuspensionControlViewOptions((SuspensionControlViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 175: {
                ((StateWorkMLB)object).dsiCarComfortUpdateWiperViewOptions((WiperViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 176: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdateNVViewOptions((NVViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 177: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdateTSDViewOptions((TSDViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 178: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdateSWAViewOptions((SWAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 179: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdateACCViewOptions((ACCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 180: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdateAWVViewOptions((AWVViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 181: {
                ((StateWorkMLB)object).dsiCarEcoUpdateBCmEViewOptions((BCmEViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 182: {
                ((StateWorkMLB)object).dsiCarKombiUpdateBCViewOptions((BCViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 183: {
                ((StateWorkMLB)object).dsiPowerManagementUpdateClampSignal((ClampSignal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 184: {
                ((StateWorkMLB)object).dsiCarComfortUpdateDoorLockingViewOptions((DoorLockingViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 185: {
                ((StateWorkMLB)object).dsiGeneralVehicleStatesUpdateVehicleStandstill((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 186: {
                ((StateWorkMLB)object).dsiGeneralVehicleStatesUpdateCarVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 187: {
                ((StateWorkMLB)object).dsiCarDrivingCharacteristicsUpdateCharismaViewOptions((CharismaViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 188: {
                ((StateWorkMLB)object).onSuccess_funcAdap((Access)objectArray[0]);
                return null;
            }
            case 189: {
                ((StateWorkMLB)object).dsiCarLightUpdateIntLightViewOptions((IntLightViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 190: {
                ((StateWorkMLB)object).onFactoryResetStateChanged(((Number)objectArray[0]).intValue());
                return null;
            }
            case 191: {
                ((StateWorkMLB)object).dsiCarComfortUpdateRDKViewOptions((RDKViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f6(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 192: {
                return StateWorkMLB.getDeviceManager();
            }
            case 193: {
                ((StateWorkMLB)object).dsiCarComfortUpdateRGSViewOptions((RGSViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 194: {
                ((StateWorkMLB)object).dsiCarComfortUpdateMirrorViewOptions((MirrorViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 195: {
                ((StateWorkMLB)object).dsiCarComfortUpdateUGDOViewOptions((UGDOViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 196: {
                ((StateWorkMLB)object).dsiCarComfortUpdateBrakeViewOptions((BrakeViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 197: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdateLDWHCAViewOptions((LDWHCAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 198: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdateMKEViewOptions((MKEViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 199: {
                ((StateWorkMLB)object).dsiCarDriverAssistanceUpdatePAViewOptions((PAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 200: {
                ((StateWorkMLB)object).dsiCarEcoUpdateEAViewOptions((EAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 201: {
                ((StateWorkMLB)object).dsiCarEcoUpdateStartStopViewOptions((StartStopViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 202: {
                ((StateWorkMLB)object).dsiCarKombiUpdateHUDViewOptions((HUDViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 203: {
                ((StateWorkMLB)object).dsiCarKombiUpdateSIAViewOptions((SIAViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 204: {
                ((StateWorkMLB)object).dsiCarLightUpdateExtLightViewOptions((ExtLightViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 205: {
                ((StateWorkMLB)object).dsiCarParkingSystemUpdateParkingSystemViewOptions((ParkingSystemViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 206: {
                ((StateWorkMLB)object).dsiCarSeatUpdateSeatViewOptions((SeatViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 207: {
                ((StateWorkMLB)object).dsiCarTimeUnitsLanguageUpdateClockViewOptions((ClockViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 208: {
                ((StateWorkMLB)object).dsiCarTimeUnitsLanguageUpdateUnitmasterViewOptions((UnitmasterViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 209: {
                ((StateWorkMLB)object).dsiCarVehicleStatesUpdateVINViewOption((CarViewOption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 210: {
                ((StateWorkMLB)object).dsiCarVehicleStatesUpdateVehicleInfoViewOptions((VehicleInfoViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 211: {
                ((StateWorkMLB)object).dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerViewOptions((AuxHeaterCoolerViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 212: {
                ((StateWorkMLB)object).onSuccess_coding((Access)objectArray[0]);
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
                case 3: {
                    return this.f3(n, object, objectArray);
                }
                case 4: {
                    return this.f4(n, object, objectArray);
                }
                case 5: {
                    return this.f5(n, object, objectArray);
                }
                case 6: {
                    return this.f6(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

