/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirQuality;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirConditionListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener;
import org.dsi.ifc.global.CarArrayListUpdateInfo;
import org.dsi.ifc.global.CarBCTemperature;

public final class LR23eabf113
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2118048473: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -2068127293: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1927660474: {
                if (bl) {
                    if (n2 != -1581999796) break;
                    n3 = 103;
                    break;
                }
                n3 = 103;
                break;
            }
            case -1910823963: {
                if (bl) {
                    if (n2 != 803180725) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1910823962: {
                if (bl) {
                    if (n2 != 803180725) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1910823961: {
                if (bl) {
                    if (n2 != 803180725) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1910823960: {
                if (bl) {
                    if (n2 != 803180725) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1910823959: {
                if (bl) {
                    if (n2 != 803180725) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1910823958: {
                if (bl) {
                    if (n2 != 803180725) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1897733093: {
                if (bl) {
                    if (n2 != 872775360) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 152;
                    break;
                }
                n3 = 152;
                break;
            }
            case -1620834310: {
                if (bl) {
                    if (n2 != -1481751395) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1516599402: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1484174522: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1483180971: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1440983984: {
                if (bl) {
                    if (n2 != 692930991) break;
                    n3 = 146;
                    break;
                }
                n3 = 146;
                break;
            }
            case -1440983983: {
                if (bl) {
                    if (n2 != 692930991) break;
                    n3 = 147;
                    break;
                }
                n3 = 147;
                break;
            }
            case -1440983982: {
                if (bl) {
                    if (n2 != 692930991) break;
                    n3 = 148;
                    break;
                }
                n3 = 148;
                break;
            }
            case -1440983981: {
                if (bl) {
                    if (n2 != 692930991) break;
                    n3 = 149;
                    break;
                }
                n3 = 149;
                break;
            }
            case -1440983980: {
                if (bl) {
                    if (n2 != 692930991) break;
                    n3 = 150;
                    break;
                }
                n3 = 150;
                break;
            }
            case -1440983979: {
                if (bl) {
                    if (n2 != 692930991) break;
                    n3 = 151;
                    break;
                }
                n3 = 151;
                break;
            }
            case -1279283119: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1229250194: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 99;
                    break;
                }
                n3 = 99;
                break;
            }
            case -1229250193: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 100;
                    break;
                }
                n3 = 100;
                break;
            }
            case -1229250192: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 101;
                    break;
                }
                n3 = 101;
                break;
            }
            case -1201600433: {
                if (bl) {
                    if (n2 != -193670282) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1091989357: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1091989356: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1091989355: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1091989354: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1091989353: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1091989352: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case -1003427870: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -943326447: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -920854070: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -919007177: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -919007176: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -919007175: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -919007174: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -919007173: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -919007172: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -856560563: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 116;
                    break;
                }
                n3 = 116;
                break;
            }
            case -856560562: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 117;
                    break;
                }
                n3 = 117;
                break;
            }
            case -856560561: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 118;
                    break;
                }
                n3 = 118;
                break;
            }
            case -856560560: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 119;
                    break;
                }
                n3 = 119;
                break;
            }
            case -856560559: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 120;
                    break;
                }
                n3 = 120;
                break;
            }
            case -856560558: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 121;
                    break;
                }
                n3 = 121;
                break;
            }
            case -807807751: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 107;
                    break;
                }
                n3 = 107;
                break;
            }
            case -807807750: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 108;
                    break;
                }
                n3 = 108;
                break;
            }
            case -807807749: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 109;
                    break;
                }
                n3 = 109;
                break;
            }
            case -755293811: {
                if (bl) {
                    if (n2 != -1493401699) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -752096534: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -635485557: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -589362373: {
                if (bl) {
                    if (n2 != 1410320357) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -577146026: {
                if (bl) {
                    if (n2 != 1539786968) break;
                    n3 = 128;
                    break;
                }
                n3 = 128;
                break;
            }
            case -577146025: {
                if (bl) {
                    if (n2 != 1539786968) break;
                    n3 = 129;
                    break;
                }
                n3 = 129;
                break;
            }
            case -577146024: {
                if (bl) {
                    if (n2 != 1539786968) break;
                    n3 = 130;
                    break;
                }
                n3 = 130;
                break;
            }
            case -577146023: {
                if (bl) {
                    if (n2 != 1539786968) break;
                    n3 = 131;
                    break;
                }
                n3 = 131;
                break;
            }
            case -577146022: {
                if (bl) {
                    if (n2 != 1539786968) break;
                    n3 = 132;
                    break;
                }
                n3 = 132;
                break;
            }
            case -577146021: {
                if (bl) {
                    if (n2 != 1539786968) break;
                    n3 = 133;
                    break;
                }
                n3 = 133;
                break;
            }
            case -494806380: {
                if (bl) {
                    if (n2 != -2025496174) break;
                    n3 = 105;
                    break;
                }
                n3 = 105;
                break;
            }
            case -488880339: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 110;
                    break;
                }
                n3 = 110;
                break;
            }
            case -488880338: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 111;
                    break;
                }
                n3 = 111;
                break;
            }
            case -488880337: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 112;
                    break;
                }
                n3 = 112;
                break;
            }
            case -488880336: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 113;
                    break;
                }
                n3 = 113;
                break;
            }
            case -488880335: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 114;
                    break;
                }
                n3 = 114;
                break;
            }
            case -488880334: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 115;
                    break;
                }
                n3 = 115;
                break;
            }
            case -278142327: {
                if (bl) {
                    if (n2 != -1274353353) break;
                    n3 = 104;
                    break;
                }
                n3 = 104;
                break;
            }
            case -242261153: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case -242261152: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case -242261151: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
                break;
            }
            case -242261150: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case -242261149: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case -242261148: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 77;
                    break;
                }
                n3 = 77;
                break;
            }
            case -197541139: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -161519625: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 95605080: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 122;
                    break;
                }
                n3 = 122;
                break;
            }
            case 95605081: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 123;
                    break;
                }
                n3 = 123;
                break;
            }
            case 95605082: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 124;
                    break;
                }
                n3 = 124;
                break;
            }
            case 95605083: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 125;
                    break;
                }
                n3 = 125;
                break;
            }
            case 95605084: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 126;
                    break;
                }
                n3 = 126;
                break;
            }
            case 95605085: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 127;
                    break;
                }
                n3 = 127;
                break;
            }
            case 105624835: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 105624836: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 105624837: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 105624838: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 105624839: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 105624840: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 181255288: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 183178409: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 134;
                    break;
                }
                n3 = 134;
                break;
            }
            case 183178410: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 135;
                    break;
                }
                n3 = 135;
                break;
            }
            case 183178411: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 136;
                    break;
                }
                n3 = 136;
                break;
            }
            case 183178412: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 137;
                    break;
                }
                n3 = 137;
                break;
            }
            case 183178413: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 138;
                    break;
                }
                n3 = 138;
                break;
            }
            case 183178414: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 139;
                    break;
                }
                n3 = 139;
                break;
            }
            case 309780217: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case 309780218: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 309780219: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 309780220: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 309780221: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 309780222: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case 424002907: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 90;
                    break;
                }
                n3 = 90;
                break;
            }
            case 424002908: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 91;
                    break;
                }
                n3 = 91;
                break;
            }
            case 424002909: {
                if (bl) {
                    if (n2 != -647458158) break;
                    n3 = 92;
                    break;
                }
                n3 = 92;
                break;
            }
            case 452336828: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 511093213: {
                if (bl) {
                    if (n2 != 1781368757) break;
                    n3 = 93;
                    break;
                }
                n3 = 93;
                break;
            }
            case 511093214: {
                if (bl) {
                    if (n2 != 1781368757) break;
                    n3 = 94;
                    break;
                }
                n3 = 94;
                break;
            }
            case 511093215: {
                if (bl) {
                    if (n2 != 1781368757) break;
                    n3 = 95;
                    break;
                }
                n3 = 95;
                break;
            }
            case 533665606: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 643989785: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 663348883: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 811693276: {
                if (bl) {
                    if (n2 != -1446739516) break;
                    n3 = 96;
                    break;
                }
                n3 = 96;
                break;
            }
            case 811693277: {
                if (bl) {
                    if (n2 != -1446739516) break;
                    n3 = 97;
                    break;
                }
                n3 = 97;
                break;
            }
            case 811693278: {
                if (bl) {
                    if (n2 != -1446739516) break;
                    n3 = 98;
                    break;
                }
                n3 = 98;
                break;
            }
            case 834197451: {
                if (bl) {
                    if (n2 != 1883910039) break;
                    n3 = 106;
                    break;
                }
                n3 = 106;
                break;
            }
            case 943252844: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 943252845: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 943252846: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 988411975: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 995749210: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1001696917: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1010326509: {
                if (bl) {
                    if (n2 != 461167886) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1010326510: {
                if (bl) {
                    if (n2 != 461167886) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1010326511: {
                if (bl) {
                    if (n2 != 461167886) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1010326512: {
                if (bl) {
                    if (n2 != 461167886) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 1010326513: {
                if (bl) {
                    if (n2 != 461167886) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 1010326514: {
                if (bl) {
                    if (n2 != 461167886) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1092349527: {
                if (bl) {
                    if (n2 != -244700824) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 1092349528: {
                if (bl) {
                    if (n2 != -244700824) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 1092349529: {
                if (bl) {
                    if (n2 != -244700824) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1092349530: {
                if (bl) {
                    if (n2 != -244700824) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1092349531: {
                if (bl) {
                    if (n2 != -244700824) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1092349532: {
                if (bl) {
                    if (n2 != -244700824) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case 1330664208: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 102;
                    break;
                }
                n3 = 102;
                break;
            }
            case 1449314087: {
                if (bl) {
                    if (n2 != -1481751395) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1454481284: {
                if (bl) {
                    if (n2 != -1709692612) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1454481285: {
                if (bl) {
                    if (n2 != -1709692612) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 1454481286: {
                if (bl) {
                    if (n2 != -1709692612) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 1553035785: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1553035786: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1553035787: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1553035788: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1553035789: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1553035790: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1587043978: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 1604213331: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 140;
                    break;
                }
                n3 = 140;
                break;
            }
            case 1604213332: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 141;
                    break;
                }
                n3 = 141;
                break;
            }
            case 1604213333: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 142;
                    break;
                }
                n3 = 142;
                break;
            }
            case 1604213334: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 143;
                    break;
                }
                n3 = 143;
                break;
            }
            case 1604213335: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 144;
                    break;
                }
                n3 = 144;
                break;
            }
            case 1604213336: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 145;
                    break;
                }
                n3 = 145;
                break;
            }
            case 1710540973: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1735412303: {
                if (bl) {
                    if (n2 != 1683077606) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1750479419: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 172;
                    break;
                }
                n3 = 172;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 175;
                    break;
                }
                n3 = 175;
                break;
            }
            case -1267945623: {
                if (bl) {
                    if (n2 != -1263655781) break;
                    n3 = 171;
                    break;
                }
                n3 = 171;
                break;
            }
            case -1059085114: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 160;
                    break;
                }
                n3 = 160;
                break;
            }
            case -658417527: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 167;
                    break;
                }
                n3 = 167;
                break;
            }
            case -278665378: {
                if (bl) {
                    if (n2 != -296299949) break;
                    n3 = 154;
                    break;
                }
                n3 = 154;
                break;
            }
            case 124889250: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 162;
                    break;
                }
                n3 = 162;
                break;
            }
            case 320985391: {
                if (bl) {
                    if (n2 != 1196862640) break;
                    n3 = 164;
                    break;
                }
                n3 = 164;
                break;
            }
            case 320985392: {
                if (bl) {
                    if (n2 != 1196862640) break;
                    n3 = 165;
                    break;
                }
                n3 = 165;
                break;
            }
            case 320985393: {
                if (bl) {
                    if (n2 != 1196862640) break;
                    n3 = 166;
                    break;
                }
                n3 = 166;
                break;
            }
            case 806332992: {
                if (bl) {
                    if (n2 != -1153660080) break;
                    n3 = 153;
                    break;
                }
                n3 = 153;
                break;
            }
            case 861324403: {
                if (bl) {
                    if (n2 != -296299949) break;
                    n3 = 155;
                    break;
                }
                n3 = 155;
                break;
            }
            case 946825464: {
                if (bl) {
                    if (n2 != -1263655781) break;
                    n3 = 174;
                    break;
                }
                n3 = 174;
                break;
            }
            case 983760691: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 159;
                    break;
                }
                n3 = 159;
                break;
            }
            case 1003562470: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 163;
                    break;
                }
                n3 = 163;
                break;
            }
            case 1008732010: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 158;
                    break;
                }
                n3 = 158;
                break;
            }
            case 1265740714: {
                if (bl) {
                    if (n2 != 1483909880) break;
                    n3 = 173;
                    break;
                }
                n3 = 173;
                break;
            }
            case 1528081014: {
                if (bl) {
                    if (n2 != -914239326) break;
                    n3 = 169;
                    break;
                }
                n3 = 169;
                break;
            }
            case 1529878167: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 157;
                    break;
                }
                n3 = 157;
                break;
            }
            case 1530863667: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 168;
                    break;
                }
                n3 = 168;
                break;
            }
            case 1533768728: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 156;
                    break;
                }
                n3 = 156;
                break;
            }
            case 1667631623: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 161;
                    break;
                }
                n3 = 161;
                break;
            }
            case 2119586787: {
                if (bl) {
                    if (n2 != -1329496731) break;
                    n3 = 170;
                    break;
                }
                n3 = 170;
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
            case 432218339: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 2106179713: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarAirConditionListener)object).requestAirconPopup((AirconContent)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICarAirConditionListener)object).acknowlegdeAirconPopup((AirconContent)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSICarAirConditionListener)object).updateAirconContent((AirconContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarAirConditionListener)object).updateAirconAirCirculationMan((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarAirConditionListener)object).updateAirconAirCirculationAuto((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarAirConditionListener)object).updateAirconAirCirculationSensitivity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarAirConditionListener)object).updateAirconAirCirculationMiddleExhaustion(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSICarAirConditionListener)object).updateAirconRearWindowHeater((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSICarAirConditionListener)object).updateAirconIndirectVentilation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSICarAirConditionListener)object).updateAirconPopupTime(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarAirConditionListener)object).updateAirconHeater((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarAirConditionListener)object).updateAirconRearAuxHeater((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSICarAirConditionListener)object).updateAirconFrontWindowHeater((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarAirConditionListener)object).updateAirconDefrost((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarAirConditionListener)object).updateAirconMaxDefrost((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarAirConditionListener)object).updateAirconSolar((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSICarAirConditionListener)object).updateAirconAC((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarAirConditionListener)object).updateAirconMaxAC((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSICarAirConditionListener)object).updateAirconEcoAC((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarAirConditionListener)object).updateAirconRearControl((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarAirConditionListener)object).updateAirconRearControlFondPlus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSICarAirConditionListener)object).updateAirconSteeringWheelHeater((AirconSteeringWheelHeater)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarAirConditionListener)object).updateAirconFrontWindowHeaterAuto((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarAirConditionListener)object).updateAirconBlowerCompensation((AirconBlowerCompensation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarAirConditionListener)object).updateAirconSynchronisation((AirconSynchronisation)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarAirConditionListener)object).updateAirconSuppressVisualisation((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSICarAirConditionListener)object).updateAirconResidualHeat((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarAirConditionListener)object).updateAirconSystemOnOffRow1((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSICarAirConditionListener)object).updateAirconSystemOnOffRow2((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSICarAirConditionListener)object).updateAirconSystemOnOffRow3((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSICarAirConditionListener)object).updateAirconTempZone1((AirconTemp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSICarAirConditionListener)object).updateAirconAirVolumeZone1((AirconAirVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarAirConditionListener)object).updateAirconAirDistributionZone1((AirconAirDistribution)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSICarAirConditionListener)object).updateAirconFootwellTempZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 35: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 36: {
                ((DSICarAirConditionListener)object).updateAirconTempZone2((AirconTemp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSICarAirConditionListener)object).updateAirconAirVolumeZone2((AirconAirVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSICarAirConditionListener)object).updateAirconAirDistributionZone2((AirconAirDistribution)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSICarAirConditionListener)object).updateAirconFootwellTempZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 41: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 42: {
                ((DSICarAirConditionListener)object).updateAirconTempZone3((AirconTemp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSICarAirConditionListener)object).updateAirconAirVolumeZone3((AirconAirVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSICarAirConditionListener)object).updateAirconAirDistributionZone3((AirconAirDistribution)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSICarAirConditionListener)object).updateAirconFootwellTempZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 47: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 48: {
                ((DSICarAirConditionListener)object).updateAirconTempZone4((AirconTemp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSICarAirConditionListener)object).updateAirconAirVolumeZone4((AirconAirVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSICarAirConditionListener)object).updateAirconAirDistributionZone4((AirconAirDistribution)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSICarAirConditionListener)object).updateAirconFootwellTempZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 53: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 54: {
                ((DSICarAirConditionListener)object).updateAirconTempZone5((AirconTemp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSICarAirConditionListener)object).updateAirconAirVolumeZone5((AirconAirVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSICarAirConditionListener)object).updateAirconAirDistributionZone5((AirconAirDistribution)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSICarAirConditionListener)object).updateAirconFootwellTempZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 59: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 60: {
                ((DSICarAirConditionListener)object).updateAirconTempZone6((AirconTemp)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSICarAirConditionListener)object).updateAirconAirVolumeZone6((AirconAirVolume)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSICarAirConditionListener)object).updateAirconAirDistributionZone6((AirconAirDistribution)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSICarAirConditionListener)object).updateAirconFootwellTempZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 65: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 66: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterDistributionZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterDistributionZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterDistributionZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterDistributionZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 70: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterDistributionZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSICarAirConditionListener)object).updateAirconSeatHeaterDistributionZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationDistributionZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationDistributionZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationDistributionZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationDistributionZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 76: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationDistributionZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 77: {
                ((DSICarAirConditionListener)object).updateAirconSeatVentilationDistributionZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 78: {
                ((DSICarAirConditionListener)object).updateAirconTempStepZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 79: {
                ((DSICarAirConditionListener)object).updateAirconTempStepZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 80: {
                ((DSICarAirConditionListener)object).updateAirconTempStepZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 81: {
                ((DSICarAirConditionListener)object).updateAirconTempStepZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 82: {
                ((DSICarAirConditionListener)object).updateAirconTempStepZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 83: {
                ((DSICarAirConditionListener)object).updateAirconTempStepZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 84: {
                ((DSICarAirConditionListener)object).updateAirconViewOptionsMaster((AirconMasterViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 85: {
                ((DSICarAirConditionListener)object).updateAirconViewOptionsRow1((AirconRowViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 86: {
                ((DSICarAirConditionListener)object).updateAirconViewOptionsRow2((AirconRowViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 87: {
                ((DSICarAirConditionListener)object).updateAirconViewOptionsRow3((AirconRowViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 88: {
                ((DSICarAirConditionListener)object).acknowledgeAirconSetFactoryDefaultMaster((Boolean)objectArray[0]);
                return null;
            }
            case 89: {
                ((DSICarAirConditionListener)object).acknowledgeAirconSetFactoryDefaultRow(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 90: {
                ((DSICarAirConditionListener)object).acknowledgeAirconNozzleControlRow1((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 91: {
                ((DSICarAirConditionListener)object).acknowledgeAirconNozzleControlRow2((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 92: {
                ((DSICarAirConditionListener)object).acknowledgeAirconNozzleControlRow3((Boolean)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 93: {
                ((DSICarAirConditionListener)object).responseAirconNozzleListRow1((CarArrayListUpdateInfo)objectArray[0], (AirconNozzleListRecord[])objectArray[1]);
                return null;
            }
            case 94: {
                ((DSICarAirConditionListener)object).responseAirconNozzleListRow2((CarArrayListUpdateInfo)objectArray[0], (AirconNozzleListRecord[])objectArray[1]);
                return null;
            }
            case 95: {
                ((DSICarAirConditionListener)object).responseAirconNozzleListRow3((CarArrayListUpdateInfo)objectArray[0], (AirconNozzleListRecord[])objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f3(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 96: {
                ((DSICarAirConditionListener)object).updateAirconNozzleListUpdateInfoRow1((CarArrayListUpdateInfo)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 97: {
                ((DSICarAirConditionListener)object).updateAirconNozzleListUpdateInfoRow2((CarArrayListUpdateInfo)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 98: {
                ((DSICarAirConditionListener)object).updateAirconNozzleListUpdateInfoRow3((CarArrayListUpdateInfo)objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 99: {
                ((DSICarAirConditionListener)object).updateAirconNozzleListTotalNumberOfElementsRow1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 100: {
                ((DSICarAirConditionListener)object).updateAirconNozzleListTotalNumberOfElementsRow2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 101: {
                ((DSICarAirConditionListener)object).updateAirconNozzleListTotalNumberOfElementsRow3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 102: {
                ((DSICarAirConditionListener)object).updateAirconSideWindowDefrost((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 103: {
                ((DSICarAirConditionListener)object).updateAirconPureAir((AirconPureAirSetup)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 104: {
                ((DSICarAirConditionListener)object).updateAirconFreshAirState((AirconFreshAirCartridge)objectArray[0], (AirconFreshAirCartridge)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 105: {
                ((DSICarAirConditionListener)object).updateAirconFreshAirConfig((AirconFreshAirConfiguration)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 106: {
                ((DSICarAirConditionListener)object).updateAirconAirQuality((AirconAirQuality)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 107: {
                ((DSICarAirConditionListener)object).updateAirconNozzleStatusRow1((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 108: {
                ((DSICarAirConditionListener)object).updateAirconNozzleStatusRow2((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 109: {
                ((DSICarAirConditionListener)object).updateAirconNozzleStatusRow3((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 110: {
                ((DSICarAirConditionListener)object).updateAirconClimateStyleZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 111: {
                ((DSICarAirConditionListener)object).updateAirconClimateStyleZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 112: {
                ((DSICarAirConditionListener)object).updateAirconClimateStyleZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 113: {
                ((DSICarAirConditionListener)object).updateAirconClimateStyleZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 114: {
                ((DSICarAirConditionListener)object).updateAirconClimateStyleZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 115: {
                ((DSICarAirConditionListener)object).updateAirconClimateStyleZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 116: {
                ((DSICarAirConditionListener)object).updateAirconClimateStateZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 117: {
                ((DSICarAirConditionListener)object).updateAirconClimateStateZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 118: {
                ((DSICarAirConditionListener)object).updateAirconClimateStateZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 119: {
                ((DSICarAirConditionListener)object).updateAirconClimateStateZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 120: {
                ((DSICarAirConditionListener)object).updateAirconClimateStateZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 121: {
                ((DSICarAirConditionListener)object).updateAirconClimateStateZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 122: {
                ((DSICarAirConditionListener)object).updateAirconSeatNeckHeaterZone1((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 123: {
                ((DSICarAirConditionListener)object).updateAirconSeatNeckHeaterZone2((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 124: {
                ((DSICarAirConditionListener)object).updateAirconSeatNeckHeaterZone3((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 125: {
                ((DSICarAirConditionListener)object).updateAirconSeatNeckHeaterZone4((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 126: {
                ((DSICarAirConditionListener)object).updateAirconSeatNeckHeaterZone5((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 127: {
                ((DSICarAirConditionListener)object).updateAirconSeatNeckHeaterZone6((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f4(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 128: {
                ((DSICarAirConditionListener)object).updateAirconSeatSurfaceHeaterZone1((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 129: {
                ((DSICarAirConditionListener)object).updateAirconSeatSurfaceHeaterZone2((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 130: {
                ((DSICarAirConditionListener)object).updateAirconSeatSurfaceHeaterZone3((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 131: {
                ((DSICarAirConditionListener)object).updateAirconSeatSurfaceHeaterZone4((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 132: {
                ((DSICarAirConditionListener)object).updateAirconSeatSurfaceHeaterZone5((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 133: {
                ((DSICarAirConditionListener)object).updateAirconSeatSurfaceHeaterZone6((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 134: {
                ((DSICarAirConditionListener)object).updateAirconIndividualClimatisationZone1((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 135: {
                ((DSICarAirConditionListener)object).updateAirconIndividualClimatisationZone2((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 136: {
                ((DSICarAirConditionListener)object).updateAirconIndividualClimatisationZone3((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 137: {
                ((DSICarAirConditionListener)object).updateAirconIndividualClimatisationZone4((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 138: {
                ((DSICarAirConditionListener)object).updateAirconIndividualClimatisationZone5((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 139: {
                ((DSICarAirConditionListener)object).updateAirconIndividualClimatisationZone6((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 140: {
                ((DSICarAirConditionListener)object).updateAirconIonisatorZone1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 141: {
                ((DSICarAirConditionListener)object).updateAirconIonisatorZone2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 142: {
                ((DSICarAirConditionListener)object).updateAirconIonisatorZone3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 143: {
                ((DSICarAirConditionListener)object).updateAirconIonisatorZone4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 144: {
                ((DSICarAirConditionListener)object).updateAirconIonisatorZone5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 145: {
                ((DSICarAirConditionListener)object).updateAirconIonisatorZone6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 146: {
                ((DSICarAirConditionListener)object).updateAirconBodyCloseMeasuresZone1((Boolean)objectArray[0], (AirconBCMeasuresConfiguration)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 147: {
                ((DSICarAirConditionListener)object).updateAirconBodyCloseMeasuresZone2((Boolean)objectArray[0], (AirconBCMeasuresConfiguration)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 148: {
                ((DSICarAirConditionListener)object).updateAirconBodyCloseMeasuresZone3((Boolean)objectArray[0], (AirconBCMeasuresConfiguration)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 149: {
                ((DSICarAirConditionListener)object).updateAirconBodyCloseMeasuresZone4((Boolean)objectArray[0], (AirconBCMeasuresConfiguration)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 150: {
                ((DSICarAirConditionListener)object).updateAirconBodyCloseMeasuresZone5((Boolean)objectArray[0], (AirconBCMeasuresConfiguration)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 151: {
                ((DSICarAirConditionListener)object).updateAirconBodyCloseMeasuresZone6((Boolean)objectArray[0], (AirconBCMeasuresConfiguration)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 152: {
                ((DSICarAirConditionListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 153: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerViewOptions((AuxHeaterCoolerViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 154: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerCurrentHeaterState((AuxHeaterCoolerErrorReason)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 155: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerErrorReason((AuxHeaterCoolerErrorReason)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 156: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 157: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerOnOff((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 158: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerRemainingTime((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 159: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerRunningTime((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f5(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 160: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 161: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerDefaultStartMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 162: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerEngineHeater((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 163: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerActiveTimer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 164: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerTimer1((AuxHeaterCoolerTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 165: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerTimer2((AuxHeaterCoolerTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 166: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerTimer3((AuxHeaterCoolerTimer)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 167: {
                ((DSICarAuxHeaterCoolerListener)object).acknowledgeAuxHeaterSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 168: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerPopup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 169: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerMode2((AuxHeaterCoolerMode)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 170: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerExtendedConditioning((AuxHeaterCoolerExtendedConditioning)objectArray[0], (AuxHeaterCoolerExtendedConditioning)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 171: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerWindowHeating((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 172: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerUnlockClimating(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 173: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerTargetTemperature((CarBCTemperature)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 174: {
                ((DSICarAuxHeaterCoolerListener)object).updateAuxHeaterCoolerAirQuality((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 175: {
                ((DSICarAuxHeaterCoolerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

