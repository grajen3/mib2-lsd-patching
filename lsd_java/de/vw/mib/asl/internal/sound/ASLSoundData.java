/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.diagnosis.config.Coding;
import de.vw.mib.asl.internal.sound.SoundPersistence;
import de.vw.mib.asl.internal.sound.SoundRangeContainer;
import de.vw.mib.asl.internal.sound.SoundUtil;
import edu.emory.mathcs.backport.java.util.Arrays;
import org.dsi.ifc.audio.AmplifierCapabilities;

public final class ASLSoundData {
    static int[] equalizerFrequencies;
    static int[] equalizerValues;
    static long soundset;
    static final int VOLUME_ANNOUNCEMENT_POPUP_MIN;
    static final int VOLUME_ANNOUNCEMENT_POPUP_MAX;
    static int volumeEntertainmentPopupMin;
    static int volumeEntertainmentPopupMax;
    static short dynAudSurrDSI_stereo;
    static short dynAudSurrDSI_small;
    static short dynAudSurrDSI_wide;
    static short dynAudSurrDSI_stereoMax;
    static short dynAudSurrDSI_wideMin;
    static short dynAudSurrDSI_current;
    static boolean surroundOnOff;
    static boolean dynAudProLogicIconVisible;
    static int btGainQuietDSI;
    static int btGainMediumDSI;
    static int btGainLoudDSI;
    static int btGainQuietDSIMax;
    static int btGainLoudDSIMin;
    static int auxIpodAVGainQuietDSI;
    static int auxIpodAVGainMediumDSI;
    static int auxIpodAVGainLoudDSI;
    static int auxIpodAVGainQuietDSIMax;
    static int auxIpodAVGainLoudDSIMin;
    static final int ENT_TMB_BALFAD_UNDEFINED;
    static int initialDynaudioCharacterMode;
    static short entTreble;
    static short entMiddle;
    static short entBass;
    static int initialDynaudioFocusMode;
    static short entBalance;
    static short entFader;
    static final int GAIN_QUIET_ASL;
    static final int GAIN_MEDIUM_ASL;
    static final int GAIN_LOUD_ASL;
    static Coding mCodingData;
    static AmplifierCapabilities amplifierCapabilities;
    static boolean dynaudioPresetPositionAvailable;
    static boolean dynaudioPresetEQAvailable;
    static int presetEQList;
    static int presetPositionList;
    static boolean arkamysAvailable;
    static boolean arkamysDreiDSound;
    static boolean arkamysVirtualSubwoofer;
    static int presetEQ;
    static int iccMin;
    static boolean iCCAvailable;
    static SoundRangeContainer phoneRangeContainer;
    public static SoundPersistence persistence;

    private ASLSoundData() {
        ASLSoundData.initSoundSettings();
    }

    public static void initSoundSettings() {
        initialDynaudioCharacterMode = -1;
        entTreble = (short)-999;
        entMiddle = (short)-999;
        entBass = (short)-999;
        initialDynaudioFocusMode = -1;
        entBalance = (short)-999;
        entFader = (short)-999;
    }

    public static void setDynAudSurrLevDSI(int n, int n2) {
        dynAudSurrDSI_stereo = (short)n;
        dynAudSurrDSI_small = (short)(n + (n2 - n) / 2);
        dynAudSurrDSI_wide = (short)n2;
        dynAudSurrDSI_stereoMax = (short)(dynAudSurrDSI_stereo + (dynAudSurrDSI_wide - dynAudSurrDSI_stereo) / 3);
        dynAudSurrDSI_wideMin = (short)(dynAudSurrDSI_wide - (dynAudSurrDSI_wide - dynAudSurrDSI_stereo) / 3);
    }

    public static short convertDynAudSurrLev_ASL2DSI(int n) {
        switch (n) {
            case 0: {
                return dynAudSurrDSI_stereo;
            }
            case 1: {
                return dynAudSurrDSI_small;
            }
            case 2: {
                return dynAudSurrDSI_wide;
            }
        }
        return dynAudSurrDSI_stereo;
    }

    public static int convertDynAudSurrLev_DSI2ASL(short s) {
        if (s >= dynAudSurrDSI_stereo && s <= dynAudSurrDSI_stereoMax) {
            return 0;
        }
        if (s > dynAudSurrDSI_stereoMax && s < dynAudSurrDSI_wideMin) {
            return 1;
        }
        if (s >= dynAudSurrDSI_wideMin && s <= dynAudSurrDSI_wide) {
            return 2;
        }
        return 0;
    }

    public static void setBTGainDSI(int n, int n2) {
        btGainQuietDSI = n;
        btGainMediumDSI = n + (n2 - n) / 2;
        btGainLoudDSI = n2;
        btGainQuietDSIMax = btGainQuietDSI + (btGainLoudDSI - btGainQuietDSI) / 3;
        btGainLoudDSIMin = btGainLoudDSI - (btGainLoudDSI - btGainQuietDSI) / 3;
    }

    public static int convertBTGainASL2DSI(int n) {
        switch (n) {
            case 0: {
                return btGainQuietDSI;
            }
            case 1: {
                return btGainMediumDSI;
            }
            case 2: {
                return btGainLoudDSI;
            }
        }
        return btGainQuietDSI;
    }

    public static int convertBTGainDSI2ASL(int n) {
        if (n >= btGainQuietDSI && n <= btGainQuietDSIMax) {
            return 0;
        }
        if (n > btGainQuietDSIMax && n < btGainLoudDSIMin) {
            return 1;
        }
        if (n >= btGainLoudDSIMin && n <= btGainLoudDSI) {
            return 2;
        }
        return 0;
    }

    public static void setAuxIpodAVGainDSI(int n, int n2) {
        auxIpodAVGainQuietDSI = n;
        auxIpodAVGainMediumDSI = n + (n2 - n) / 2;
        auxIpodAVGainLoudDSI = n2;
        auxIpodAVGainQuietDSIMax = auxIpodAVGainQuietDSI + (auxIpodAVGainLoudDSI - auxIpodAVGainQuietDSI) / 3;
        auxIpodAVGainLoudDSIMin = auxIpodAVGainLoudDSI - (auxIpodAVGainLoudDSI - auxIpodAVGainQuietDSI) / 3;
    }

    public static int convertAuxIpodAVGainASL2DSI(int n) {
        switch (n) {
            case 0: {
                return auxIpodAVGainQuietDSI;
            }
            case 1: {
                return auxIpodAVGainMediumDSI;
            }
            case 2: {
                return auxIpodAVGainLoudDSI;
            }
        }
        return auxIpodAVGainQuietDSI;
    }

    public static int convertAuxIpodAVGainDSI2ASL(int n) {
        if (n >= auxIpodAVGainQuietDSI && n <= auxIpodAVGainQuietDSIMax) {
            return 0;
        }
        if (n > auxIpodAVGainQuietDSIMax && n < auxIpodAVGainLoudDSIMin) {
            return 1;
        }
        if (n >= auxIpodAVGainLoudDSIMin && n <= auxIpodAVGainLoudDSI) {
            return 2;
        }
        return 0;
    }

    public static String getDescription() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("SoundData(");
        stringBuffer.append(amplifierCapabilities);
        stringBuffer.append(',');
        stringBuffer.append("ampName");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.getAmpName(ASLSoundData.amplifierCapabilities.amplifier));
        stringBuffer.append(',');
        stringBuffer.append("dynaudioPresetPositionAvailable");
        stringBuffer.append('=');
        stringBuffer.append(dynaudioPresetPositionAvailable);
        stringBuffer.append(',');
        stringBuffer.append("dynaudioPresetEQAvailable");
        stringBuffer.append('=');
        stringBuffer.append(dynaudioPresetEQAvailable);
        stringBuffer.append(',');
        stringBuffer.append("arkamysDreiDSound");
        stringBuffer.append('=');
        stringBuffer.append(arkamysDreiDSound);
        stringBuffer.append(',');
        stringBuffer.append("arkamysVirtualSubwoofer");
        stringBuffer.append('=');
        stringBuffer.append(arkamysVirtualSubwoofer);
        stringBuffer.append(')');
        stringBuffer.append(',');
        stringBuffer.append("presetPositionList");
        stringBuffer.append('=');
        stringBuffer.append(Integer.toHexString(presetPositionList));
        stringBuffer.append(',');
        stringBuffer.append("presetEQList");
        stringBuffer.append('=');
        stringBuffer.append(Integer.toHexString(presetEQList));
        stringBuffer.append(',');
        stringBuffer.append("EqualizerFrequencies");
        stringBuffer.append('=');
        stringBuffer.append(Arrays.toString(equalizerFrequencies));
        return stringBuffer.toString();
    }

    public static String getDescription2() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("SoundData2(");
        stringBuffer.append(amplifierCapabilities);
        stringBuffer.append(',');
        stringBuffer.append("ampName");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.getAmpName(amplifierCapabilities));
        stringBuffer.append(',');
        stringBuffer.append("dynaudioCharacterPresetAvailable");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.isDynaudioCharacterPresetAvailable());
        stringBuffer.append(',');
        stringBuffer.append("dynaudioFocusPresetAvailable");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.isDynaudioFocusPresetAvailable());
        stringBuffer.append(',');
        stringBuffer.append("dynaudioSurroundLevelAvailable");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.isDynaudioSurroundLevelAvailable());
        stringBuffer.append(',');
        stringBuffer.append("cantonSoundPresetAvailable");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.isCantonSoundPresetAvailable());
        stringBuffer.append(',');
        stringBuffer.append("cantonSoundFocusAvailable");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.isCantonSoundFocusAvailable());
        stringBuffer.append(',');
        stringBuffer.append("cantonSurroundAvailable");
        stringBuffer.append('=');
        stringBuffer.append(SoundUtil.isCantonSurroundAvailable());
        stringBuffer.append(',');
        stringBuffer.append("arkamysAvailable");
        stringBuffer.append('=');
        stringBuffer.append(arkamysAvailable);
        stringBuffer.append(',');
        stringBuffer.append("arkamysDreiDSound");
        stringBuffer.append('=');
        stringBuffer.append(arkamysDreiDSound);
        stringBuffer.append(',');
        stringBuffer.append("arkamysVirtualSubwoofer");
        stringBuffer.append('=');
        stringBuffer.append(arkamysVirtualSubwoofer);
        stringBuffer.append(')');
        stringBuffer.append(',');
        stringBuffer.append("presetPositionList");
        stringBuffer.append("=0x");
        stringBuffer.append(Integer.toHexString(presetPositionList));
        stringBuffer.append(',');
        stringBuffer.append("presetEQList");
        stringBuffer.append("=0x");
        stringBuffer.append(Integer.toHexString(presetEQList));
        stringBuffer.append(',');
        stringBuffer.append("EqualizerFrequencies");
        stringBuffer.append('=');
        stringBuffer.append(Arrays.toString(equalizerFrequencies));
        stringBuffer.append(',');
        stringBuffer.append("EntertainmentVolumeRange");
        stringBuffer.append('=');
        stringBuffer.append(volumeEntertainmentPopupMin);
        stringBuffer.append('/');
        stringBuffer.append(volumeEntertainmentPopupMax);
        stringBuffer.append(',');
        stringBuffer.append("iccAvailable");
        stringBuffer.append('=');
        stringBuffer.append(iCCAvailable);
        return stringBuffer.toString();
    }

    static {
        soundset = 0;
        volumeEntertainmentPopupMin = 0;
        volumeEntertainmentPopupMax = 30;
        dynAudSurrDSI_stereo = (short)-13;
        dynAudSurrDSI_small = 0;
        dynAudSurrDSI_wide = (short)13;
        dynAudSurrDSI_stereoMax = (short)(dynAudSurrDSI_stereo + (dynAudSurrDSI_wide - dynAudSurrDSI_stereo) / 3);
        dynAudSurrDSI_wideMin = (short)(dynAudSurrDSI_wide - (dynAudSurrDSI_wide - dynAudSurrDSI_stereo) / 3);
        dynAudSurrDSI_current = dynAudSurrDSI_stereo;
        surroundOnOff = false;
        dynAudProLogicIconVisible = false;
        btGainQuietDSI = 0;
        btGainMediumDSI = 6;
        btGainLoudDSI = 12;
        btGainQuietDSIMax = btGainQuietDSI + (btGainLoudDSI - btGainQuietDSI) / 3;
        btGainLoudDSIMin = btGainLoudDSI - (btGainLoudDSI - btGainQuietDSI) / 3;
        auxIpodAVGainQuietDSI = 0;
        auxIpodAVGainMediumDSI = 6;
        auxIpodAVGainLoudDSI = 12;
        auxIpodAVGainQuietDSIMax = auxIpodAVGainQuietDSI + (auxIpodAVGainLoudDSI - auxIpodAVGainQuietDSI) / 3;
        auxIpodAVGainLoudDSIMin = auxIpodAVGainLoudDSI - (auxIpodAVGainLoudDSI - auxIpodAVGainQuietDSI) / 3;
        initialDynaudioFocusMode = -1;
        entBalance = (short)-999;
        entFader = (short)-999;
        mCodingData = null;
        dynaudioPresetPositionAvailable = false;
        dynaudioPresetEQAvailable = false;
        presetEQList = 0;
        presetPositionList = 0;
        arkamysAvailable = false;
        arkamysDreiDSound = false;
        arkamysVirtualSubwoofer = false;
        presetEQ = 1;
        iccMin = 3;
        iCCAvailable = false;
        phoneRangeContainer = new SoundRangeContainer();
        persistence = SoundPersistence.getInstance();
    }
}

