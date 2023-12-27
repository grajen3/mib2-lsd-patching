/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public final class LR29f6592c3
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2073348895: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case -1950822563: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1946777532: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1877821757: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1867015498: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1840253644: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1774939640: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1745583720: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1703200128: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1693624122: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -1690829341: {
                if (bl) {
                    if (n2 != 1619717894) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1675431948: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1663342610: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case -1635566115: {
                if (bl) {
                    if (n2 != 810754752) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -1477115190: {
                if (bl) {
                    if (n2 != 1462124538) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1361826876: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1311217224: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 71;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 72;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 73;
                    break;
                }
                n3 = 71;
                break;
            }
            case -958960189: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -958781600: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 74;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 75;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 76;
                    break;
                }
                n3 = 74;
                break;
            }
            case -681131106: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -679696977: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -514294049: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -510403488: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -491552582: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -320397015: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -292777920: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -289224603: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -206915242: {
                if (bl) {
                    if (n2 != -717270566) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -206915118: {
                if (bl) {
                    if (n2 != -717270566) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -206914746: {
                if (bl) {
                    if (n2 != -717270566) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -206914715: {
                if (bl) {
                    if (n2 != -717270566) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -103543242: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -103298814: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -77527958: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -16936031: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 10542024: {
                if (bl) {
                    if (n2 != 1542724693) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 37619452: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 40298728: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 198541041: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 228263388: {
                if (bl) {
                    if (n2 != 717522593) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 239069647: {
                if (bl) {
                    if (n2 != 717522593) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 312360776: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 331841079: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 342647338: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 362523553: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 507675226: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 518762655: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 598929732: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 622368280: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 677960732: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 966862088: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 974465711: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 1037077339: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1067347239: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1092651172: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 1105067494: {
                if (bl) {
                    if (n2 != 1631368198) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1205301631: {
                if (bl) {
                    if (n2 != 211100058) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1305931611: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1463612343: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1463790932: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1557384187: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 1557721038: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1686386652: {
                if (bl) {
                    if (n2 != 344255931) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 1863333539: {
                if (bl) {
                    if (n2 != -162812016) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1887529175: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1899770387: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1909870305: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1950852418: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case 1988085834: {
                if (bl) {
                    if (n2 != 1471830875) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 2085739902: {
                if (bl) {
                    if (n2 != 717522593) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 2085918491: {
                if (bl) {
                    if (n2 != 717522593) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2091754089: {
                if (bl) {
                    if (n2 != 1589838380) break;
                    n3 = 83;
                    break;
                }
                n3 = 83;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 90;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 91;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 92;
                    break;
                }
                n3 = 90;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 93;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 94;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 95;
                    break;
                }
                n3 = 93;
                break;
            }
            case -643729347: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 78;
                    break;
                }
                n3 = 78;
                break;
            }
            case -577820634: {
                if (bl) {
                    if (n2 != -785441950) break;
                    n3 = 82;
                    break;
                }
                n3 = 82;
                break;
            }
            case 20833921: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 81;
                    break;
                }
                n3 = 81;
                break;
            }
            case 37099940: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 89;
                    break;
                }
                n3 = 89;
                break;
            }
            case 69906338: {
                if (bl) {
                    if (n2 != 531076422) break;
                    n3 = 84;
                    break;
                }
                n3 = 84;
                break;
            }
            case 540496359: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 87;
                    break;
                }
                n3 = 87;
                break;
            }
            case 693934040: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 86;
                    break;
                }
                n3 = 86;
                break;
            }
            case 862988450: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 88;
                    break;
                }
                n3 = 88;
                break;
            }
            case 1048150480: {
                if (bl) {
                    if (n2 != 1915459703) break;
                    n3 = 79;
                    break;
                }
                n3 = 79;
                break;
            }
            case 1438327487: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 85;
                    break;
                }
                n3 = 85;
                break;
            }
            case 1777707422: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 80;
                    break;
                }
                n3 = 80;
                break;
            }
            case 1849707112: {
                if (bl) {
                    if (n2 != -2108627486) break;
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
            case -445954769: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1994691949: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarParkingSystem)object).setHMIStateIsReady((Boolean)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSICarParkingSystem)object).setPDCDefaultParkingMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSICarParkingSystem)object).setPDCMute((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSICarParkingSystem)object).setPDCFrequenceFront(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSICarParkingSystem)object).setPDCFrequenceRear(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSICarParkingSystem)object).setPDCVolumeFront(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSICarParkingSystem)object).setPDCVolumeRear(((Number)objectArray[0]).intValue());
                return null;
            }
            case 7: {
                ((DSICarParkingSystem)object).setPDCAutoActivation((Boolean)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSICarParkingSystem)object).setPDCSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSICarParkingSystem)object).setPDCFrequenceRight(((Number)objectArray[0]).intValue());
                return null;
            }
            case 10: {
                ((DSICarParkingSystem)object).setPDCFrequenceLeft(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSICarParkingSystem)object).setPDCVolumeRight(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSICarParkingSystem)object).setPDCVolumeLeft(((Number)objectArray[0]).intValue());
                return null;
            }
            case 13: {
                ((DSICarParkingSystem)object).setPDCFlankGuard((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSICarParkingSystem)object).setPDCSoundReproduction((PDCSoundReproduction)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSICarParkingSystem)object).setPDCSoundFront((PDCSound)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSICarParkingSystem)object).setPDCSoundRear((PDCSound)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSICarParkingSystem)object).setPDCSoundLeft((PDCSound)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSICarParkingSystem)object).setPDCSoundRight((PDCSound)objectArray[0]);
                return null;
            }
            case 19: {
                ((DSICarParkingSystem)object).setPDCPLAPreSelection(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSICarParkingSystem)object).setPDCPLAParkMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSICarParkingSystem)object).setPDCPLASystemState((PDCPLASystemState)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSICarParkingSystem)object).setPDCOffroadMode((Boolean)objectArray[0]);
                return null;
            }
            case 23: {
                ((DSICarParkingSystem)object).setPDCVisualisationParkbox((Boolean)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSICarParkingSystem)object).setPDCOPSVisualisationPosition(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSICarParkingSystem)object).setVPSFollowUpTime(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSICarParkingSystem)object).setVPSColor(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSICarParkingSystem)object).setVPSContrast(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSICarParkingSystem)object).setVPSBrightness(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSICarParkingSystem)object).setVPSDefaultModeRV((VPSDefaultMode)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSICarParkingSystem)object).setVPSDefaultModeFV((VPSDefaultMode)objectArray[0]);
                return null;
            }
            case 31: {
                ((DSICarParkingSystem)object).setVPSDefaultModeSV((VPSDefaultMode)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarParkingSystem)object).setVPSDefaultModeBV((VPSDefaultMode)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSICarParkingSystem)object).setVPSDefaultView(((Number)objectArray[0]).intValue());
                return null;
            }
            case 34: {
                ((DSICarParkingSystem)object).setVPSOPSOverlay((VPSOPSOverlay)objectArray[0]);
                return null;
            }
            case 35: {
                ((DSICarParkingSystem)object).setVPSDynamicParkingMode((VPSDynParkingMode)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSICarParkingSystem)object).setVPSSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSICarParkingSystem)object).setVPSExtCamConfig(((Number)objectArray[0]).intValue());
                return null;
            }
            case 38: {
                ((DSICarParkingSystem)object).setVPSExtCamManActivation((Boolean)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSICarParkingSystem)object).setVPS3DBirdview(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarParkingSystem)object).setVPSSystemState((Boolean)objectArray[0]);
                return null;
            }
            case 41: {
                ((DSICarParkingSystem)object).showParkingPopup((DisplayContent)objectArray[0]);
                return null;
            }
            case 42: {
                ((DSICarParkingSystem)object).cancelParkingPopup((DisplayContent)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((DSICarParkingSystem)object).requestLifeMonitoring((Boolean)objectArray[0]);
                return null;
            }
            case 44: {
                ((DSICarParkingSystem)object).setPdcSetFactoryDefault();
                return null;
            }
            case 45: {
                ((DSICarParkingSystem)object).setVpsSetFactoryDefault();
                return null;
            }
            case 46: {
                ((DSICarParkingSystem)object).setARATargetTrailerAngle(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                ((DSICarParkingSystem)object).setPDCManeuverAssistConfig(((Number)objectArray[0]).intValue());
                return null;
            }
            case 48: {
                ((DSICarParkingSystem)object).setPDCManeuverAssist((Boolean)objectArray[0]);
                return null;
            }
            case 49: {
                ((DSICarParkingSystem)object).setPDCContinueDrivingAssist(((Number)objectArray[0]).intValue());
                return null;
            }
            case 50: {
                ((DSICarParkingSystem)object).setPDCIpaConfig(((Number)objectArray[0]).intValue());
                return null;
            }
            case 51: {
                ((DSICarParkingSystem)object).setPDCPiloPaSystemState((PDCPiloPaSystemState)objectArray[0]);
                return null;
            }
            case 52: {
                ((DSICarParkingSystem)object).setVPSCameraCleaning((VPSCameraCleaning)objectArray[0]);
                return null;
            }
            case 53: {
                ((DSICarParkingSystem)object).setWCAutoActivation((Boolean)objectArray[0]);
                return null;
            }
            case 54: {
                ((DSICarParkingSystem)object).setWCSystemOnOff((Boolean)objectArray[0]);
                return null;
            }
            case 55: {
                ((DSICarParkingSystem)object).setWCSetFactoryDefault();
                return null;
            }
            case 56: {
                ((DSICarParkingSystem)object).showWCPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 57: {
                ((DSICarParkingSystem)object).cancelWCPopup(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarParkingSystem)object).requestWCPanelList((CarArrayListUpdateInfo)objectArray[0]);
                return null;
            }
            case 59: {
                ((DSICarParkingSystem)object).enterWCPinPuk((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 60: {
                ((DSICarParkingSystem)object).abortWCEnterPinPuk();
                return null;
            }
            case 61: {
                ((DSICarParkingSystem)object).startWCScanning();
                return null;
            }
            case 62: {
                ((DSICarParkingSystem)object).abortWCScanning();
                return null;
            }
            case 63: {
                ((DSICarParkingSystem)object).startWCPairing((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarParkingSystem)object).abortWCPairing();
                return null;
            }
            case 65: {
                ((DSICarParkingSystem)object).startWCSoftwareUpdate((String)objectArray[0]);
                return null;
            }
            case 66: {
                ((DSICarParkingSystem)object).abortWCSoftwareUpdate();
                return null;
            }
            case 67: {
                ((DSICarParkingSystem)object).changeWCPin((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 68: {
                ((DSICarParkingSystem)object).abortWCChangePin();
                return null;
            }
            case 69: {
                ((DSICarParkingSystem)object).changeWCPanelName((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 70: {
                ((DSICarParkingSystem)object).abortWCChangePanelName();
                return null;
            }
            case 71: {
                ((DSICarParkingSystem)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 72: {
                ((DSICarParkingSystem)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 73: {
                ((DSICarParkingSystem)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 74: {
                ((DSICarParkingSystem)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 75: {
                ((DSICarParkingSystem)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 76: {
                ((DSICarParkingSystem)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 77: {
                ((DSICarplay)object).startService((ServiceConfiguration)objectArray[0]);
                return null;
            }
            case 78: {
                ((DSICarplay)object).postButtonEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 79: {
                ((DSICarplay)object).postTouchEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (TouchEvent[])objectArray[2]);
                return null;
            }
            case 80: {
                ((DSICarplay)object).postRotaryEvent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 81: {
                ((DSICarplay)object).requestNightMode((Boolean)objectArray[0]);
                return null;
            }
            case 82: {
                ((DSICarplay)object).postCharacterEvent(((Number)objectArray[0]).intValue(), (String[])objectArray[1]);
                return null;
            }
            case 83: {
                ((DSICarplay)object).requestModeChange((ResourceRequest[])objectArray[0], (AppStateRequest[])objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 84: {
                ((DSICarplay)object).responseUpdateMode((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 85: {
                ((DSICarplay)object).responseBTDeactivation();
                return null;
            }
            case 86: {
                ((DSICarplay)object).requestUI(((Number)objectArray[0]).intValue());
                return null;
            }
            case 87: {
                ((DSICarplay)object).requestSIRIAction(((Number)objectArray[0]).intValue());
                return null;
            }
            case 88: {
                ((DSICarplay)object).responseUpdateMainAudioType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 89: {
                ((DSICarplay)object).requestUI2((String)objectArray[0]);
                return null;
            }
            case 90: {
                ((DSICarplay)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 91: {
                ((DSICarplay)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 92: {
                ((DSICarplay)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 93: {
                ((DSICarplay)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 94: {
                ((DSICarplay)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 95: {
                ((DSICarplay)object).clearNotification((DSIListener)objectArray[0]);
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

