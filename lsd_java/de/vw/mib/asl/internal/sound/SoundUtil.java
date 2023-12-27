/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.ASLSoundData;
import de.vw.mib.util.Util;
import org.dsi.ifc.audio.AmplifierCapabilities;

public final class SoundUtil {
    private SoundUtil() {
    }

    public static boolean isMediaSource(int n) {
        switch (n) {
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 23: 
            case 24: 
            case 201: 
            case 215: 
            case 216: {
                return true;
            }
        }
        return false;
    }

    public static boolean isRadioEntertainmentSource(int n) {
        switch (n) {
            case 12: 
            case 13: 
            case 26: 
            case 28: 
            case 43: {
                return true;
            }
        }
        return false;
    }

    public static boolean isRadioAnnouncementSource(int n) {
        switch (n) {
            case 15: 
            case 31: 
            case 32: 
            case 33: 
            case 34: {
                return true;
            }
        }
        return false;
    }

    public static boolean isExBoxRadioEntertainmentSource(int n) {
        switch (n) {
            case 214: {
                return true;
            }
        }
        return false;
    }

    public static boolean isExBoxMediaSource(int n) {
        switch (n) {
            case 217: {
                return true;
            }
        }
        return false;
    }

    public static boolean isMirrorlinkEntertainmentSource(int n) {
        switch (n) {
            case 240: {
                return true;
            }
        }
        return false;
    }

    public static boolean isMirrorlinkAnnouncementSource(int n) {
        switch (n) {
            case 241: 
            case 242: 
            case 243: 
            case 244: 
            case 245: 
            case 246: {
                return true;
            }
        }
        return false;
    }

    public static boolean isBaiduAnnouncementSource(int n) {
        switch (n) {
            case 168: 
            case 169: 
            case 170: 
            case 171: {
                return true;
            }
        }
        return false;
    }

    public static boolean isBaiduEntertainmentSource(int n) {
        return 167 == n;
    }

    public static boolean isCarPlayEntertainmentSource(int n) {
        switch (n) {
            case 162: {
                return true;
            }
        }
        return false;
    }

    public static boolean isCarPlayAnnouncementSource(int n) {
        switch (n) {
            case 151: 
            case 152: 
            case 153: 
            case 154: 
            case 155: {
                return true;
            }
        }
        return false;
    }

    public static boolean isAndroidAutoEntertainmentSource(int n) {
        switch (n) {
            case 156: {
                return true;
            }
        }
        return false;
    }

    public static boolean isAndroidAutoAnnouncementSource(int n) {
        switch (n) {
            case 157: 
            case 158: 
            case 159: 
            case 160: 
            case 161: {
                return true;
            }
        }
        return false;
    }

    public static boolean isTVSource(int n) {
        switch (n) {
            case 27: {
                return true;
            }
        }
        return false;
    }

    public static boolean isCarPlaySource(int n) {
        return SoundUtil.isCarPlayEntertainmentSource(n) || SoundUtil.isCarPlayAnnouncementSource(n);
    }

    public static boolean isAndroidAutoSource(int n) {
        return SoundUtil.isAndroidAutoEntertainmentSource(n) || SoundUtil.isAndroidAutoAnnouncementSource(n);
    }

    public static boolean isMirrorlinkSource(int n) {
        return SoundUtil.isMirrorlinkEntertainmentSource(n) || SoundUtil.isMirrorlinkAnnouncementSource(n);
    }

    public static boolean isBaiduSource(int n) {
        return SoundUtil.isBaiduEntertainmentSource(n) || SoundUtil.isBaiduAnnouncementSource(n);
    }

    public static boolean isSmartphoneEntertainmentSource(int n) {
        return SoundUtil.isMirrorlinkEntertainmentSource(n) || SoundUtil.isCarPlayEntertainmentSource(n) || SoundUtil.isAndroidAutoEntertainmentSource(n) || SoundUtil.isBaiduEntertainmentSource(n);
    }

    public static boolean isSmartphoneSource(int n) {
        return SoundUtil.isMirrorlinkSource(n) || SoundUtil.isCarPlaySource(n) || SoundUtil.isAndroidAutoSource(n) || SoundUtil.isBaiduSource(n);
    }

    public static boolean isExBoxEntertainementSource(int n) {
        return SoundUtil.isExBoxRadioEntertainmentSource(n) || SoundUtil.isExBoxMediaSource(n);
    }

    public static boolean isRadioSource(int n) {
        return SoundUtil.isRadioEntertainmentSource(n) || SoundUtil.isRadioAnnouncementSource(n);
    }

    public static boolean isEntSource(int n) {
        return SoundUtil.isMediaSource(n) || SoundUtil.isRadioEntertainmentSource(n) || SoundUtil.isExBoxEntertainementSource(n) || SoundUtil.isTVSource(n) || SoundUtil.isSmartphoneEntertainmentSource(n) || n == 9;
    }

    public static boolean isOtherSoundSetupAccessibleSource(int n) {
        switch (n) {
            case 8: 
            case 9: 
            case 80: 
            case 83: 
            case 84: 
            case 85: 
            case 86: 
            case 87: 
            case 94: 
            case 120: 
            case 121: 
            case 122: 
            case 154: 
            case 160: 
            case 170: 
            case 200: 
            case 235: 
            case 260: 
            case 261: 
            case 262: {
                return true;
            }
        }
        return false;
    }

    public static boolean isConnectionNeedFadeTo(int n) {
        if ((n == 161 || n == 155) && SoundUtil.isHigh()) {
            return true;
        }
        switch (n) {
            case 1: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 80: 
            case 94: 
            case 100: 
            case 102: 
            case 106: 
            case 113: 
            case 150: 
            case 153: 
            case 155: 
            case 159: 
            case 161: 
            case 163: 
            case 169: 
            case 171: 
            case 200: 
            case 205: 
            case 206: 
            case 210: 
            case 245: 
            case 261: 
            case 500: {
                return false;
            }
        }
        return true;
    }

    public static boolean isConnectionMayLeadToEntVolZero(int n) {
        switch (n) {
            case 5: 
            case 83: 
            case 94: 
            case 116: 
            case 117: 
            case 155: 
            case 161: 
            case 171: 
            case 235: {
                return true;
            }
        }
        return false;
    }

    public static boolean isUnrequestedStartAnnouncementRetriggerCandidate(int n) {
        switch (n) {
            case 99: 
            case 104: 
            case 116: 
            case 117: 
            case 151: {
                return true;
            }
        }
        return false;
    }

    public static boolean isVirtualConnection(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 80: 
            case 94: 
            case 96: 
            case 100: 
            case 102: 
            case 106: 
            case 113: 
            case 137: 
            case 169: 
            case 200: 
            case 210: 
            case 245: 
            case 261: {
                return true;
            }
        }
        return false;
    }

    public static boolean isAmpInternal(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return true;
        }
        return SoundUtil.isAmpInternal(amplifierCapabilities.amplifier);
    }

    public static boolean isAmpInternal(int n) {
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 24: 
            case 25: {
                return true;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 26: 
            case 27: 
            case 28: 
            case 30: {
                return false;
            }
        }
        return true;
    }

    public static String getAmpName(int n) {
        switch (n) {
            case 1: {
                return "internal 2 channel";
            }
            case 2: {
                return "internal 4 channel";
            }
            case 3: {
                return "internal 6 channel";
            }
            case 24: {
                return "internal Arkamys SKODA";
            }
            case 27: {
                return "external BAP Fender";
            }
            case 25: {
                return "external BAP SKODA";
            }
            case 6: {
                return "external ALPINE SKODA";
            }
            case 10: {
                return "external Fender";
            }
            case 7: {
                return "external Dynaudio 1";
            }
            case 8: {
                return "external Dynaudio 2";
            }
            case 9: {
                return "external Dynaudio 3";
            }
            case 26: {
                return "external BAP Dynaudio";
            }
            case 28: {
                return "external Beats SEAT";
            }
            case 30: {
                return "external BAP Seat";
            }
        }
        return "Unknown";
    }

    public static String getAmpName(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return "unknown";
        }
        return SoundUtil.getAmpName(amplifierCapabilities.amplifier);
    }

    public static boolean isAmpDynaudio(int n) {
        switch (n) {
            case 7: 
            case 8: 
            case 9: 
            case 26: {
                return true;
            }
        }
        return false;
    }

    public static boolean isAmpDynaudio(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return false;
        }
        return SoundUtil.isAmpDynaudio(amplifierCapabilities.amplifier);
    }

    public static boolean isAmpSkodaCanton(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return false;
        }
        switch (amplifierCapabilities.amplifier) {
            case 6: {
                return true;
            }
        }
        return false;
    }

    public static boolean isAmpSkodaBAP(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return false;
        }
        switch (amplifierCapabilities.amplifier) {
            case 25: {
                return true;
            }
        }
        return false;
    }

    public static boolean isAmpSeatBeats(AmplifierCapabilities amplifierCapabilities) {
        if (null == amplifierCapabilities) {
            return false;
        }
        return SoundUtil.isAmpSeatBeats(amplifierCapabilities.amplifier);
    }

    public static boolean isAmpSeatBeats(int n) {
        return 28 == n;
    }

    public static boolean isAmpSeatBAP(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return false;
        }
        return SoundUtil.isAmpSeatBAP(amplifierCapabilities.amplifier);
    }

    public static boolean isAmpSeatBAP(int n) {
        return n == 30;
    }

    public static boolean isHigh() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(378);
    }

    public static boolean isSeat() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(353);
    }

    public static boolean isSkoda() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(360);
    }

    public static boolean isVW() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(432);
    }

    public static boolean isICCAvailable() {
        return ASLSoundData.iCCAvailable;
    }

    public static int getActiveAudioComponent(int n) {
        int n2 = 1;
        switch (n) {
            case 15: 
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: {
                n2 = 2;
                break;
            }
            case 95: 
            case 98: 
            case 99: 
            case 103: 
            case 104: 
            case 106: 
            case 151: 
            case 157: 
            case 165: 
            case 210: 
            case 212: 
            case 218: 
            case 225: 
            case 226: 
            case 227: 
            case 228: 
            case 241: 
            case 246: {
                n2 = 4;
                break;
            }
            case 116: 
            case 117: 
            case 220: 
            case 221: 
            case 242: {
                n2 = 3;
                break;
            }
            case 112: 
            case 113: 
            case 114: 
            case 115: 
            case 118: 
            case 119: 
            case 126: 
            case 127: 
            case 152: 
            case 155: 
            case 158: 
            case 161: 
            case 168: 
            case 171: 
            case 219: 
            case 243: 
            case 244: {
                n2 = 5;
                break;
            }
        }
        return n2;
    }

    public static int getActiveAudioComponentASL(int n) {
        int n2 = SoundUtil.getActiveAudioComponent(n);
        int n3 = 1;
        switch (n2) {
            case 2: {
                n3 = 2;
                break;
            }
            case 3: {
                n3 = 3;
                break;
            }
            case 4: {
                n3 = 4;
                break;
            }
            case 5: {
                n3 = 5;
                break;
            }
        }
        return n3;
    }

    public static boolean hasValidSurroundRange() {
        return ASLSoundData.dynAudSurrDSI_stereo != ASLSoundData.dynAudSurrDSI_wide;
    }

    public static boolean isTMBAvailable(int[] nArray) {
        return Util.isNullOrEmpty(nArray) || Util.isBitSet(nArray[1], 0) && Util.isBitSet(nArray[3], 0);
    }

    public static boolean isManEQAvailable(int[] nArray) {
        return !SoundUtil.isTMBAvailable(nArray);
    }

    public static boolean isDynaudioCharacterPresetAvailable() {
        boolean bl = false;
        int n = 15;
        bl = SoundUtil.isVW() && SoundUtil.isAmpDynaudio(ASLSoundData.amplifierCapabilities) && Util.isBitSet(n, ASLSoundData.presetEQList);
        return bl;
    }

    public static boolean isDynaudioFocusPresetAvailable() {
        return SoundUtil.isDynaudioFocusPresetAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.presetPositionList);
    }

    public static boolean isDynaudioFocusPresetAvailable(AmplifierCapabilities amplifierCapabilities, int n) {
        boolean bl = false;
        int n2 = 15;
        bl = SoundUtil.isVW() && SoundUtil.isAmpDynaudio(amplifierCapabilities) && Util.isBitSet(n2, n);
        return bl;
    }

    public static boolean isDynaudioSurroundLevelAvailable() {
        boolean bl = SoundUtil.isVW() && SoundUtil.isAmpDynaudio(ASLSoundData.amplifierCapabilities) && SoundUtil.hasValidSurroundRange();
        return bl;
    }

    public static boolean isDynaudioPrologicActivated() {
        return ASLSoundData.dynAudSurrDSI_current > ASLSoundData.dynAudSurrDSI_small;
    }

    public static short getToggledDynAudSurrLev() {
        return SoundUtil.isDynaudioPrologicActivated() ? ASLSoundData.dynAudSurrDSI_stereo : ASLSoundData.dynAudSurrDSI_wide;
    }

    public static boolean isCantonSoundPresetAvailable() {
        boolean bl = false;
        int n = 15;
        bl = SoundUtil.isSkoda() && SoundUtil.isAmpSkodaCanton(ASLSoundData.amplifierCapabilities) && Util.isBitSet(n, ASLSoundData.presetEQList);
        return bl;
    }

    public static boolean isCantonSoundFocusAvailable() {
        int n = 7;
        boolean bl = SoundUtil.isSkoda() && SoundUtil.isAmpSkodaCanton(ASLSoundData.amplifierCapabilities) && Util.isBitSet(n, ASLSoundData.presetPositionList);
        return bl;
    }

    public static boolean isCantonSurroundAvailable() {
        boolean bl = SoundUtil.isSkoda() && SoundUtil.isAmpSkodaCanton(ASLSoundData.amplifierCapabilities) && SoundUtil.hasValidSurroundRange();
        return bl;
    }

    public static boolean isSoundCharactersAvailable() {
        int n = 143;
        boolean bl = SoundUtil.isSkoda() && SoundUtil.isAmpSkodaBAP(ASLSoundData.amplifierCapabilities) && Util.isBitSet(n, ASLSoundData.presetEQList);
        return bl;
    }

    public static boolean isSurroundAvailable() {
        int n = 50;
        boolean bl = SoundUtil.isSkoda() && SoundUtil.isAmpSkodaBAP(ASLSoundData.amplifierCapabilities) && Util.isBitSet(n, ASLSoundData.presetPositionList);
        return bl;
    }

    public static boolean isSeatSoundFocusAvailable(AmplifierCapabilities amplifierCapabilities, int n) {
        int n2 = 3;
        boolean bl = SoundUtil.isSeat() && Util.isBitSet(n2, n);
        return bl && !SoundUtil.isBeatsFocusPresetAvailable(amplifierCapabilities, n);
    }

    public static boolean isSeatSoundFocusAvailable() {
        return SoundUtil.isSeatSoundFocusAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.presetPositionList);
    }

    public static boolean isSkodaStandardSoundFocusFrontAvailable(int n) {
        int n2 = 3;
        boolean bl = SoundUtil.isSkoda() && Util.isBitSet(n2, n);
        return bl;
    }

    public static boolean isSkodaStandardSoundFocusDriverAvailable(int n) {
        int n2 = 9;
        boolean bl = SoundUtil.isSkoda() && Util.isBitSet(n2, n);
        return bl;
    }

    public static boolean isSkodaStandardSoundFocusAvailable(AmplifierCapabilities amplifierCapabilities, boolean bl, int n) {
        return SoundUtil.isAmpInternal(amplifierCapabilities) && !SoundUtil.isAmpSkodaBAP(amplifierCapabilities) && !bl && (SoundUtil.isSkodaStandardSoundFocusFrontAvailable(n) || SoundUtil.isSkodaStandardSoundFocusDriverAvailable(n));
    }

    public static boolean isSkodaStandardSoundFocusAvailable() {
        return SoundUtil.isSkodaStandardSoundFocusAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.arkamysAvailable, ASLSoundData.presetPositionList);
    }

    public static boolean isBeatsFocusPresetAvailable(AmplifierCapabilities amplifierCapabilities, int n) {
        int n2 = 15;
        boolean bl = SoundUtil.isSeat() && SoundUtil.isAmpSeatBeats(amplifierCapabilities) && Util.isBitSet(n2, n);
        return bl;
    }

    public static boolean isBeatsFocusPresetAvailable() {
        return SoundUtil.isBeatsFocusPresetAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.presetPositionList);
    }

    public static boolean isTMBMainAvailable(int[] nArray) {
        boolean bl = SoundUtil.isTMBAvailable(ASLSoundData.equalizerFrequencies) && !SoundUtil.isDynaudioCharacterPresetAvailable() && !SoundUtil.isCantonSoundPresetAvailable();
        return bl;
    }

    public static boolean isManEQMainAvailable() {
        boolean bl = SoundUtil.isManEQAvailable(ASLSoundData.equalizerFrequencies) && !SoundUtil.isDynaudioCharacterPresetAvailable() && !SoundUtil.isCantonSoundPresetAvailable();
        return bl;
    }

    public static boolean isBalanceAvailable() {
        return SoundUtil.isBalanceAvailable(ASLSoundData.amplifierCapabilities);
    }

    public static boolean isFaderAvailable() {
        return SoundUtil.isFaderAvailable(ASLSoundData.amplifierCapabilities);
    }

    public static boolean isBalanceAvailable(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return false;
        }
        return amplifierCapabilities.isBalance();
    }

    public static boolean isFaderAvailable(AmplifierCapabilities amplifierCapabilities) {
        if (amplifierCapabilities == null) {
            return false;
        }
        return amplifierCapabilities.isFader();
    }

    public static boolean isBalanceFaderMainAvailable() {
        return SoundUtil.isBalanceFaderMainAvailable(ASLSoundData.amplifierCapabilities, ASLSoundData.presetPositionList);
    }

    public static boolean isBalanceFaderMainAvailable(AmplifierCapabilities amplifierCapabilities, int n) {
        return SoundUtil.isBalanceAvailable(amplifierCapabilities) && SoundUtil.isFaderAvailable(amplifierCapabilities) && !SoundUtil.isDynaudioFocusPresetAvailable(amplifierCapabilities, n) && !SoundUtil.isBeatsFocusPresetAvailable(amplifierCapabilities, n);
    }

    public static boolean isBalanceMainAvailable() {
        return SoundUtil.isBalanceAvailable() && !SoundUtil.isFaderAvailable() && !SoundUtil.isDynaudioFocusPresetAvailable();
    }

    public static int getConnectionCarPlayRingtone() {
        return SoundUtil.isHigh() ? 165 : 151;
    }

    public static int getAuro3dASL(int n) {
        switch (n) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 8: {
                return 3;
            }
        }
        return 0;
    }

    public static int getAuro3dDSI(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 8;
            }
        }
        return 1;
    }

    public static int getRequiredPresetPositionsForExtendedAudio() {
        if (SoundUtil.isVW()) {
            return 15;
        }
        if (SoundUtil.isSkoda()) {
            return 7;
        }
        if (SoundUtil.isSeat()) {
            return 15;
        }
        return 0;
    }

    public static int getRequiredPresetEQForExtendedAudio() {
        if (SoundUtil.isVW() || SoundUtil.isSkoda()) {
            return 15;
        }
        return 0;
    }

    public static boolean isExtendedAudioAvailable(AmplifierCapabilities amplifierCapabilities, int n, int n2) {
        if (null == amplifierCapabilities) {
            return false;
        }
        int n3 = SoundUtil.getRequiredPresetEQForExtendedAudio();
        int n4 = SoundUtil.getRequiredPresetPositionsForExtendedAudio();
        boolean bl = (SoundUtil.isVW() && SoundUtil.isAmpDynaudio(amplifierCapabilities.amplifier) || SoundUtil.isSkoda() && !SoundUtil.isAmpInternal(amplifierCapabilities.amplifier) || SoundUtil.isSeat() && !SoundUtil.isAmpInternal(amplifierCapabilities.amplifier)) && Util.isBitSet(n4, n) && Util.isBitSet(n3, n2);
        return bl;
    }
}

