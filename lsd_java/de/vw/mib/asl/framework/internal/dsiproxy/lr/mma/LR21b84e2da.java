/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.audio.DSISoundListener;
import org.dsi.ifc.bap.DSIBAPListener;

public final class LR21b84e2da
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -645664639: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -597168175: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -558843513: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1064297745: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1585041114: {
                if (bl) {
                    if (n2 != -577675501) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1642243973: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2067924324: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -2037700662: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -2027025361: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1913612839: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1835135928: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1819920384: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1807516970: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1676058291: {
                if (bl) {
                    if (n2 != -1108356720) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1637591056: {
                if (bl) {
                    if (n2 != -664730603) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case -1566692617: {
                if (bl) {
                    if (n2 != 1115116705) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1520022462: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -1122597325: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1027020002: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -975838026: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -913853710: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -887307080: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -859139144: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -731025772: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -606035737: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -597104478: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -466115186: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -406489559: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -402707253: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -369351406: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -366350178: {
                if (bl) {
                    if (n2 != -1238641699) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -296474179: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -265442153: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -245022281: {
                if (bl) {
                    if (n2 != -1238641699) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case -222662326: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -205513408: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -127536855: {
                if (bl) {
                    if (n2 != -331503043) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -90180800: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -13592316: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 241276486: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 549162014: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case 559495079: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 679439775: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 852561683: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1103454517: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1229190856: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1382548678: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 1420581241: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1620189427: {
                if (bl) {
                    if (n2 != -1047718335) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1647777947: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 1845865864: {
                if (bl) {
                    if (n2 != -364613859) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1890728325: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1911064903: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 2049047166: {
                if (bl) {
                    if (n2 != 1481544712) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 2070982681: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 2095980448: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 2129302623: {
                if (bl) {
                    if (n2 != 1043255048) break;
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
            case -1529446429: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -526586372: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIBAPListener)object).bapStateStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIBAPListener)object).indication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 2: {
                ((DSIBAPListener)object).indicationVoid(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIBAPListener)object).indicationByteSequence(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (byte[])objectArray[3]);
                return null;
            }
            case 4: {
                ((DSIBAPListener)object).indicationError(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIBAPListener)object).acknowledge(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIBAPListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSISoundListener)object).profileReset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSISoundListener)object).profileResetAll(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSISoundListener)object).volumeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 10: {
                ((DSISoundListener)object).inputGainOffsetRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 11: {
                ((DSISoundListener)object).menuVolEntRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 12: {
                ((DSISoundListener)object).menuVolumeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 13: {
                ((DSISoundListener)object).updateSurroundOnOff(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 14: {
                ((DSISoundListener)object).updateBalance(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 15: {
                ((DSISoundListener)object).updateBalanceRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSISoundListener)object).updateBass(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 17: {
                ((DSISoundListener)object).updateBassRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSISoundListener)object).createExportFileResult(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSISoundListener)object).updateFader(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 20: {
                ((DSISoundListener)object).updateFaderRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 21: {
                ((DSISoundListener)object).importFileResponse(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 22: {
                ((DSISoundListener)object).updateInputGainOffset(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 23: {
                ((DSISoundListener)object).updateLoweringEntertainment(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 24: {
                ((DSISoundListener)object).updateMutePinState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSISoundListener)object).updateSubwoofer(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 26: {
                ((DSISoundListener)object).updateSubwooferRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 27: {
                ((DSISoundListener)object).updateSurrLevelRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 28: {
                ((DSISoundListener)object).updateSurroundLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 29: {
                ((DSISoundListener)object).updateTreble(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 30: {
                ((DSISoundListener)object).updateTrebleRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 31: {
                ((DSISoundListener)object).updateVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSISoundListener)object).updateVolumeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 33: {
                ((DSISoundListener)object).updateMiddle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 34: {
                ((DSISoundListener)object).updateMiddleRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 35: {
                ((DSISoundListener)object).updateEqualizerRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (int[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 36: {
                ((DSISoundListener)object).updateEqualizer((int[])objectArray[0], (int[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 37: {
                ((DSISoundListener)object).updateOnVolumeLimit(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSISoundListener)object).updateOnVolumeLimitRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 39: {
                ((DSISoundListener)object).updateActiveAmplifierCapabilities((AmplifierCapabilities)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSISoundListener)object).updateMuteTheftProtection((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSISoundListener)object).updateMicGainLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSISoundListener)object).updateVolumeFocus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 43: {
                ((DSISoundListener)object).updateNoiseCompensation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 44: {
                ((DSISoundListener)object).updateNoiseCompensationRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 45: {
                ((DSISoundListener)object).updateThreeDMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 46: {
                ((DSISoundListener)object).updateThreeDModeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 47: {
                ((DSISoundListener)object).updatePresetPosition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 48: {
                ((DSISoundListener)object).updatePresetPositionList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSISoundListener)object).updatePresetEQList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((DSISoundListener)object).updatePresetEQ(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 51: {
                ((DSISoundListener)object).updateSubwooferActivity(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 52: {
                ((DSISoundListener)object).responseWidebandSpeech(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 53: {
                ((DSISoundListener)object).updateSoundShapeActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 54: {
                ((DSISoundListener)object).updateSoundShape((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 55: {
                ((DSISoundListener)object).updateSoundShapeRange(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue());
                return null;
            }
            case 56: {
                ((DSISoundListener)object).updateICCAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 57: {
                ((DSISoundListener)object).updateProfileState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 58: {
                ((DSISoundListener)object).profileChanged(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSISoundListener)object).profileCopied(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 60: {
                ((DSISoundListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

