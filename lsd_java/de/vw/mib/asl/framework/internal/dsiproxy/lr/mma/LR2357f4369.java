/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.carlight.DSICarLightListener;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;
import org.dsi.ifc.carlight.ExtLightSensorErrorDetectionState;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightBrightness;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBValues;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carlight.MotorwayBlinkingSettings;
import org.dsi.ifc.carlight.TimeState;
import org.dsi.ifc.global.ResourceLocator;

public final class LR2357f4369
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2091754089: {
                if (bl) {
                    if (n2 != -820350045) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -2047941588: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1817560945: {
                if (bl) {
                    if (n2 != -1214164264) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1717775335: {
                if (bl) {
                    if (n2 != -820350045) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -989177285: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -982786206: {
                if (bl) {
                    if (n2 != -513227954) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -502838206: {
                if (bl) {
                    if (n2 != -1676902285) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -63251488: {
                if (bl) {
                    if (n2 != -2062025617) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -44679130: {
                if (bl) {
                    if (n2 != -1646303317) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 148365439: {
                if (bl) {
                    if (n2 != -1014726651) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1105410480: {
                if (bl) {
                    if (n2 != -1924501671) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1932256706: {
                if (bl) {
                    if (n2 != 3568538) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1858426263: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1843579012: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1843579011: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1843579010: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1843579009: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1843579008: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1843579007: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1843579006: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1843579005: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1729930242: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -1637835599: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -1417280230: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1290733463: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -928870004: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -869238102: {
                if (bl) {
                    if (n2 != 1059640276) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -759120872: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -695687245: {
                if (bl) {
                    if (n2 != -220696856) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -351514759: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -309543247: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -271600753: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -227313282: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -104508308: {
                if (bl) {
                    if (n2 != -695304984) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 4814412: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 4930198: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 64841840: {
                if (bl) {
                    if (n2 != 847543313) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 67625194: {
                if (bl) {
                    if (n2 != -220696856) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 90027464: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 248574750: {
                if (bl) {
                    if (n2 != -1263655781) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 305763696: {
                if (bl) {
                    if (n2 != -856821770) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 351224471: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 732790812: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case 789580573: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 839150243: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 1009211304: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 1060956885: {
                if (bl) {
                    if (n2 != 243880278) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 1296881322: {
                if (bl) {
                    if (n2 != -695304984) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1313989475: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1313989476: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1313989477: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1313989478: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1313989479: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1313989480: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1313989481: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1313989482: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1390569197: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1406500506: {
                if (bl) {
                    if (n2 != -739126954) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 1406500528: {
                if (bl) {
                    if (n2 != -2019903754) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1679883635: {
                if (bl) {
                    if (n2 != 1033789776) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case 1740745323: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case 1820832712: {
                if (bl) {
                    if (n2 != -570599496) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case 2011919670: {
                if (bl) {
                    if (n2 != 313589798) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
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
            case -1183095037: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1797436159: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSICarlifeListener)object).requestModeChange((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 1: {
                ((DSICarlifeListener)object).updateCallState((CallState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSICarlifeListener)object).updateNowPlayingData((TrackData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSICarlifeListener)object).updatePlaybackState((PlaybackInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSICarlifeListener)object).updatePlayposition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSICarlifeListener)object).updateCoverArtUrl((ResourceLocator)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSICarlifeListener)object).responseSetMode((Resource[])objectArray[0], (AppState[])objectArray[1]);
                return null;
            }
            case 7: {
                ((DSICarlifeListener)object).updatePlaymodeState((PlaymodeInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSICarlifeListener)object).updateNavigationNextTurnInfo((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 9: {
                ((DSICarlifeListener)object).updateDeviceInfo((DeviceInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSICarlifeListener)object).updateVideoAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSICarlifeListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSICarLightListener)object).updateIntLightViewOptions((IntLightViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet7(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSICarLightListener)object).updateIntLightIlluminationSet8(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSICarLightListener)object).updateIntLightTemperature((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSICarLightListener)object).updateIntLightColour(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSICarLightListener)object).updateIntLightState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSICarLightListener)object).updateIntLightEnvironment((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSICarLightListener)object).updateIntLightSpeed((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSICarLightListener)object).updateIntLightBrightness((IntLightBrightness)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile1(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile2(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile3(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile4(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile5(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile6(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile7(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSICarLightListener)object).updateIntLightIlluminationProfile8(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSICarLightListener)object).updateIntLightActiveProfile(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSICarLightListener)object).updateIntLightAmbientLightColor((IntLightRGBValues)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSICarLightListener)object).updateIntLightContourLightColor((IntLightRGBValues)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSICarLightListener)object).updateIntLightFollowUpTime(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSICarLightListener)object).updateIntLightDoorContact((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSICarLightListener)object).updateIntLightRGBColorListUpdateInfo((IntLightRGBColorListUpdateInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSICarLightListener)object).updateIntLightRGBColorListTotalNumberOfElements(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSICarLightListener)object).responseIntLightRGBColorListRA0((IntLightRGBColorListUpdateInfo)objectArray[0], (IntLightRGBColorListRA0[])objectArray[1]);
                return null;
            }
            case 43: {
                ((DSICarLightListener)object).responseIntLightRGBColorListRAF((IntLightRGBColorListUpdateInfo)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 44: {
                ((DSICarLightListener)object).updateExtLightComingHome((TimeState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((DSICarLightListener)object).updateExtLightLeavingHome((TimeState)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                ((DSICarLightListener)object).updateExtLightSwitchOnSensitivity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 47: {
                ((DSICarLightListener)object).updateExtLightDaylight((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSICarLightListener)object).updateExtLightTourist((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSICarLightListener)object).updateExtLightAdaptive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSICarLightListener)object).updateExtLightHeadLightSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSICarLightListener)object).updateExtLightGlidingSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSICarLightListener)object).updateExtLightViewOptions((ExtLightViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 53: {
                ((DSICarLightListener)object).updateExtLightMotorwayBlinking((MotorwayBlinkingSettings)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSICarLightListener)object).updateExtLightMaskedHighBeam((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSICarLightListener)object).updateExtLightLampErrorDetection((ExtLightLampErrorDetectionState[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSICarLightListener)object).updateExtLightLampErrorDetectionTrailer((ExtLightLampErrorDetectionStateTrailer[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSICarLightListener)object).updateExtLightSensorErrorDetection((ExtLightSensorErrorDetectionState[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSICarLightListener)object).updateExtLightAutomaticLight((Boolean)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 59: {
                ((DSICarLightListener)object).acknowledgeIntLightSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 60: {
                ((DSICarLightListener)object).acknowledgeExtLightSetFactoryDefault((Boolean)objectArray[0]);
                return null;
            }
            case 61: {
                ((DSICarLightListener)object).updateExtLightLaserLight((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSICarLightListener)object).updateExtLightSignatureLight((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSICarLightListener)object).updateExtLightHeadlightRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSICarLightListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

