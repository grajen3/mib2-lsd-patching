/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizonListener;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;
import org.dsi.ifc.modelapi.DSIModelAPIListener;
import org.dsi.ifc.modelapi.ListRowData;

public final class LR27a187f7
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2056714290: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -2055377522: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -2054893395: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1981759805: {
                if (bl) {
                    if (n2 != -1505881088) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1979325759: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1917321692: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1911118274: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1802418927: {
                if (bl) {
                    if (n2 != -706988078) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1670837399: {
                if (bl) {
                    if (n2 != -2126142728) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1670382656: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1587194288: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1347572053: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1196738477: {
                if (bl) {
                    if (n2 != -2018418629) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -1122887087: {
                if (bl) {
                    if (n2 != -1869217024) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1114074222: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -965116634: {
                if (bl) {
                    if (n2 != -1013660959) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -960481697: {
                if (bl) {
                    if (n2 != -1621617783) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -858661254: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -854557659: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -791990485: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -769853215: {
                if (bl) {
                    if (n2 != -341107143) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -655176911: {
                if (bl) {
                    if (n2 != 1644012935) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -636711364: {
                if (bl) {
                    if (n2 != -1505881088) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -369362263: {
                if (bl) {
                    if (n2 != 1644012935) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -307544835: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -132466809: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -87787711: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 179199061: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 210805788: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 247673979: {
                if (bl) {
                    if (n2 != 2140055448) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 262259053: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 278880405: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 447732434: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 507954208: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 639521921: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 644638067: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 694969750: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 761346060: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 761623141: {
                if (bl) {
                    if (n2 != -995993593) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 767399998: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 788498383: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 896035944: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1073762241: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1305894147: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1397441063: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1586341737: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1896229903: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1927289602: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 1984984868: {
                if (bl) {
                    if (n2 != 1383775559) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2079828144: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -1193687048: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -413241089: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 8327946: {
                if (bl) {
                    if (n2 != 527915725) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1480116541: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 1493464750: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case 1948196781: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
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
            case -1153763613: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -132392035: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIModelAPIListener)object).setSelected(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 1: {
                ((DSIModelAPIListener)object).setText(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 2: {
                ((DSIModelAPIListener)object).switchContext(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIModelAPIListener)object).fillListBufferAtStart(((Number)objectArray[0]).intValue(), (long[])objectArray[1], (ListRowData[])objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 4: {
                ((DSIModelAPIListener)object).fillListBufferAtEnd(((Number)objectArray[0]).intValue(), (long[])objectArray[1], (ListRowData[])objectArray[2], (Boolean)objectArray[3]);
                return null;
            }
            case 5: {
                ((DSIModelAPIListener)object).showScreen(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIModelAPIListener)object).showInfoScreen(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIModelAPIListener)object).showTrafficScreen(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIModelAPIListener)object).showPopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSIModelAPIListener)object).removePopup();
                return null;
            }
            case 10: {
                ((DSIModelAPIListener)object).removeSinglePopup(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIModelAPIListener)object).setVisible(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIModelAPIListener)object).setLabel(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIModelAPIListener)object).setModelEnabled(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIModelAPIListener)object).setChoiceValue(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIModelAPIListener)object).setTextfield(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIModelAPIListener)object).setRangeLimits(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 17: {
                ((DSIModelAPIListener)object).setRangeValue(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIModelAPIListener)object).setMatchSpellerData(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2], (String)objectArray[3], (Boolean)objectArray[4], ((Number)objectArray[5]).intValue(), (Boolean)objectArray[6], ((Number)objectArray[7]).intValue());
                return null;
            }
            case 19: {
                ((DSIModelAPIListener)object).setMatchCount(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIModelAPIListener)object).setMetricsInvalid(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIModelAPIListener)object).setMetricsValue(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 22: {
                ((DSIModelAPIListener)object).setListData(((Number)objectArray[0]).intValue(), (ListRowData[])objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIModelAPIListener)object).setSubListData(((Number)objectArray[0]).intValue(), (ListRowData[])objectArray[1], ((Number)objectArray[2]).longValue());
                return null;
            }
            case 24: {
                ((DSIModelAPIListener)object).setSlidingListData(((Number)objectArray[0]).intValue(), (long[])objectArray[1], (ListRowData[])objectArray[2], (Boolean)objectArray[3], (Boolean)objectArray[4], ((Number)objectArray[5]).intValue());
                return null;
            }
            case 25: {
                ((DSIModelAPIListener)object).setSlidingListDataWithInitialCursorPos(((Number)objectArray[0]).intValue(), (long[])objectArray[1], (ListRowData[])objectArray[2], (Boolean)objectArray[3], (Boolean)objectArray[4], ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).longValue());
                return null;
            }
            case 26: {
                ((DSIModelAPIListener)object).setSlidingSubListData(((Number)objectArray[0]).intValue(), (long[])objectArray[1], (ListRowData[])objectArray[2], (Boolean)objectArray[3], (Boolean)objectArray[4], ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).longValue());
                return null;
            }
            case 27: {
                ((DSIModelAPIListener)object).setRGIData(((Number)objectArray[0]).intValue(), (short[])objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIModelAPIListener)object).fillSlidingListRow(((Number)objectArray[0]).intValue(), (ListRowData)objectArray[1], ((Number)objectArray[2]).longValue());
                return null;
            }
            case 29: {
                ((DSIModelAPIListener)object).setSlidingListSize(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIModelAPIListener)object).validateCharactersResult(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String)objectArray[2]);
                return null;
            }
            case 31: {
                ((DSIModelAPIListener)object).setModelPressed(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIModelAPIListener)object).showSetupScreen(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 33: {
                ((DSIModelAPIListener)object).showInfoSetupScreen(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 34: {
                ((DSIModelAPIListener)object).setFmtTime(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 35: {
                ((DSIModelAPIListener)object).setFmtDate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 36: {
                ((DSIModelAPIListener)object).setFmtRTT(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 37: {
                ((DSIModelAPIListener)object).setFmtDistance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIModelAPIListener)object).setFmtAltitude(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSIModelAPIListener)object).setFmtRadioFrequency(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSIModelAPIListener)object).setFmtOrientation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSIModelAPIListener)object).setFmtGeoCoordinatesLongitude(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 42: {
                ((DSIModelAPIListener)object).setFmtGeoCoordinatesLatitude(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 43: {
                ((DSIModelAPIListener)object).triggerSDComponent(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSIModelAPIListener)object).setDynamicImage(((Number)objectArray[0]).intValue(), (ResourceLocator)objectArray[1]);
                return null;
            }
            case 45: {
                ((DSIModelAPIListener)object).setSDSDynamicValue(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 46: {
                ((DSIModelAPIListener)object).setSDSDynamicObjectID(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 47: {
                ((DSIModelAPIListener)object).getValidHanziCharsWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 48: {
                ((DSIModelAPIListener)object).requestStateMachineControl();
                return null;
            }
            case 49: {
                ((DSIModelAPIListener)object).ddsHandled((Boolean)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIModelAPIListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 51: {
                ((DSIMobilityHorizonListener)object).updateLocations((MobilityHorizonLocation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSIMobilityHorizonListener)object).updateConsideredLocationTypes((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSIMobilityHorizonListener)object).updateDriveTrainMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSIMobilityHorizonListener)object).updateMobilityHorizonStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSIMobilityHorizonListener)object).requestLocationRangeLevelResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSIMobilityHorizonListener)object).locationRangeLevelChanged(((Number)objectArray[0]).intValue());
                return null;
            }
            case 57: {
                ((DSIMobilityHorizonListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

