/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

import org.dsi.ifc.base.DSIBase;

public interface DSISound
extends DSIBase {
    public static final String VERSION;
    public static final int RT_GETVOLUME;
    public static final int RT_SETVOLUME;
    public static final int RT_DECREASEVOLUME;
    public static final int RT_INCREASEVOLUME;
    public static final int RT_GETBALANCE;
    public static final int RT_SETBALANCE;
    public static final int RT_DECREASEBALANCE;
    public static final int RT_INCREASEBALANCE;
    public static final int RT_GETBASS;
    public static final int RT_SETBASS;
    public static final int RT_DECREASEBASS;
    public static final int RT_INCREASEBASS;
    public static final int RT_GETTREBLE;
    public static final int RT_SETTREBLE;
    public static final int RT_DECREASETREBLE;
    public static final int RT_INCREASETREBLE;
    public static final int RT_GETFADER;
    public static final int RT_SETFADER;
    public static final int RT_DECREASEFADER;
    public static final int RT_INCREASEFADER;
    public static final int RT_GETSUBWOOFER;
    public static final int RT_SETSUBWOOFER;
    public static final int RT_GETINPUTGAINOFFSET;
    public static final int RT_SETINPUTGAINOFFSET;
    public static final int RT_GETINPUTGAINOFFSETRANGE;
    public static final int RT_GETLOWERINGENTERTAINMENT;
    public static final int RT_SETLOWERINGENTERTAINMENT;
    public static final int RT_GETMENUVOLENTRANGE;
    public static final int RT_GETMENUVOLUMERANGE;
    public static final int RT_GETSURROUNDLEVEL;
    public static final int RT_SETSURROUNDLEVEL;
    public static final int RT_SETSURROUNDONOFF;
    public static final int RT_REVERTTOFACTORYSETTINGS;
    public static final int RT_CREATEEXPORTFILE;
    public static final int RT_IMPORTFILE;
    public static final int RT_GETMIDDLE;
    public static final int RT_SETMIDDLE;
    public static final int RT_DECREASEMIDDLE;
    public static final int RT_INCREASEMIDDLE;
    public static final int RT_SETMICGAINLEVEL;
    public static final int RT_DECREASEMICGAINLEVEL;
    public static final int RT_INCREASEMICGAINLEVEL;
    public static final int RT_SETEQUALIZER;
    public static final int RT_INCREASEEQUALIZER;
    public static final int RT_DECREASEEQUALIZER;
    public static final int RT_GETEQUALIZER;
    public static final int RT_SETONVOLUMELIMIT;
    public static final int RT_INCREASEONVOLUMELIMIT;
    public static final int RT_DECREASEONVOLUMELIMIT;
    public static final int RT_DECREASEINPUTGAINOFFSET;
    public static final int RT_INCREASEINPUTGAINOFFSET;
    public static final int RT_DECREASESUBWOOFER;
    public static final int RT_INCREASESUBWOOFER;
    public static final int RT_DECREASESURROUNDLEVEL;
    public static final int RT_INCREASESURROUNDLEVEL;
    public static final int RT_DECREASELOWERINGENTERTAINMENT;
    public static final int RT_INCREASELOWERINGENTERTAINMENT;
    public static final int RT_GETNOISECOMPENSATION;
    public static final int RT_SETNOISECOMPENSATION;
    public static final int RT_INCREASENOISECOMPENSATION;
    public static final int RT_DECREASENOISECOMPENSATION;
    public static final int RT_GETPRESETPOSITION;
    public static final int RT_SETPRESETPOSITION;
    public static final int RT_GETPRESETEQ;
    public static final int RT_SETPRESETEQ;
    public static final int RT_SETSUBWOOFERACTIVITY;
    public static final int RT_GET3DMODE;
    public static final int RT_SET3DMODE;
    public static final int RT_SETWIDEBANDSPEECH;
    public static final int RT_SETDURATION;
    public static final int RT_GETVOLUMERANGE;
    public static final int RT_GETSOUNDSHAPEACTIVE;
    public static final int RT_SETSOUNDSHAPEACTIVE;
    public static final int RT_GETSOUNDSHAPE;
    public static final int RT_SETSOUNDSHAPE;
    public static final int RT_PROFILECHANGE;
    public static final int RT_PROFILECOPY;
    public static final int RT_PROFILERESET;
    public static final int RT_PROFILERESETALL;
    public static final int ATTR_BALANCE;
    public static final int ATTR_BALANCERANGE;
    public static final int ATTR_BASS;
    public static final int ATTR_BASSRANGE;
    public static final int ATTR_FADER;
    public static final int ATTR_FADERRANGE;
    public static final int ATTR_INPUTGAINOFFSET;
    public static final int ATTR_LOWERINGENTERTAINMENT;
    public static final int ATTR_MUTEPINSTATE;
    public static final int ATTR_SUBWOOFER;
    public static final int ATTR_SUBWOOFERRANGE;
    public static final int ATTR_SURRLEVELRANGE;
    public static final int ATTR_SURROUNDLEVEL;
    public static final int ATTR_TREBLE;
    public static final int ATTR_TREBLERANGE;
    public static final int ATTR_VOLUME;
    public static final int ATTR_VOLUMERANGE;
    public static final int ATTR_MIDDLE;
    public static final int ATTR_MIDDLERANGE;
    public static final int ATTR_EQUALIZERRANGE;
    public static final int ATTR_EQUALIZER;
    public static final int ATTR_ONVOLUMELIMIT;
    public static final int ATTR_ONVOLUMELIMITRANGE;
    public static final int ATTR_ACTIVEAMPLIFIERCAPABILITIES;
    public static final int ATTR_MUTETHEFTPROTECTION;
    public static final int ATTR_MICGAINLEVEL;
    public static final int ATTR_VOLUMEFOCUS;
    public static final int ATTR_NOISECOMPENSATION;
    public static final int ATTR_PRESETPOSITION;
    public static final int ATTR_PRESETEQ;
    public static final int ATTR_PRESETPOSITIONLIST;
    public static final int ATTR_PRESETEQLIST;
    public static final int ATTR_NOISECOMPENSATIONRANGE;
    public static final int ATTR_SUBWOOFERACTIVITY;
    public static final int ATTR_SURROUNDONOFF;
    public static final int ATTR_THREEDMODE;
    public static final int ATTR_THREEDMODERANGE;
    public static final int ATTR_SOUNDSHAPEACTIVE;
    public static final int ATTR_SOUNDSHAPE;
    public static final int ATTR_SOUNDSHAPERANGE;
    public static final int ATTR_ICCAVAILABLE;
    public static final int ATTR_PROFILESTATE;
    public static final int RP_INPUTGAINOFFSETRANGE;
    public static final int RP_MENUVOLENTRANGE;
    public static final int RP_MENUVOLUMERANGE;
    public static final int RP_CREATEEXPORTFILERESULT;
    public static final int RP_IMPORTFILERESPONSE;
    public static final int RP_RESPONSEWIDEBANDSPEECH;
    public static final int RP_VOLUMERANGE;
    public static final int RP_PROFILECHANGED;
    public static final int RP_PROFILECOPIED;
    public static final int RP_PROFILERESET;
    public static final int RP_PROFILERESETALL;

    default public void getVolume(int n, int n2) {
    }

    default public void setVolume(int n, int n2, short s) {
    }

    default public void decreaseVolume(int n, int n2, short s) {
    }

    default public void increaseVolume(int n, int n2, short s) {
    }

    default public void getBalance(int n, int n2) {
    }

    default public void setBalance(int n, int n2, short s) {
    }

    default public void decreaseBalance(int n, int n2, short s) {
    }

    default public void increaseBalance(int n, int n2, short s) {
    }

    default public void getBass(int n, int n2) {
    }

    default public void setBass(int n, int n2, short s) {
    }

    default public void decreaseBass(int n, int n2, short s) {
    }

    default public void increaseBass(int n, int n2, short s) {
    }

    default public void getTreble(int n, int n2) {
    }

    default public void setTreble(int n, int n2, short s) {
    }

    default public void decreaseTreble(int n, int n2, short s) {
    }

    default public void increaseTreble(int n, int n2, short s) {
    }

    default public void getFader(int n, int n2) {
    }

    default public void setFader(int n, int n2, short s) {
    }

    default public void decreaseFader(int n, int n2, short s) {
    }

    default public void increaseFader(int n, int n2, short s) {
    }

    default public void getSubwoofer(int n, int n2) {
    }

    default public void setSubwoofer(int n, int n2, short s) {
    }

    default public void getInputGainOffset(int n, int n2) {
    }

    default public void setInputGainOffset(int n, int n2, short s) {
    }

    default public void getInputGainOffsetRange(int n, int n2) {
    }

    default public void getLoweringEntertainment(int n, int n2, int n3) {
    }

    default public void setLoweringEntertainment(int n, int n2, int n3, short s) {
    }

    default public void getMenuVolEntRange(int n) {
    }

    default public void getMenuVolumeRange(int n, int n2) {
    }

    default public void getVolumeRange(int n, int n2) {
    }

    default public void getSurroundLevel(int n, int n2) {
    }

    default public void setSurroundLevel(int n, int n2, short s) {
    }

    default public void setSurroundOnOff(int n, int n2, boolean bl) {
    }

    default public void revertToFactorySettings(int n, int n2) {
    }

    default public void createExportFile(String string, int n) {
    }

    default public void importFile(String string, int n) {
    }

    default public void getMiddle(int n, int n2) {
    }

    default public void setMiddle(int n, int n2, short s) {
    }

    default public void decreaseMiddle(int n, int n2, short s) {
    }

    default public void increaseMiddle(int n, int n2, short s) {
    }

    default public void setEqualizer(int n, int n2, int n3, int n4) {
    }

    default public void increaseEqualizer(int n, int n2, int n3, short s) {
    }

    default public void decreaseEqualizer(int n, int n2, int n3, short s) {
    }

    default public void getEqualizer(int n, int n2) {
    }

    default public void setOnVolumeLimit(int n) {
    }

    default public void increaseOnVolumeLimit(short s) {
    }

    default public void decreaseOnVolumeLimit(short s) {
    }

    default public void decreaseSubwoofer(int n, int n2, short s) {
    }

    default public void increaseSubwoofer(int n, int n2, short s) {
    }

    default public void decreaseInputGainOffset(int n, int n2, short s) {
    }

    default public void increaseInputGainOffset(int n, int n2, short s) {
    }

    default public void decreaseLoweringEntertainment(int n, int n2, int n3, short s) {
    }

    default public void increaseLoweringEntertainment(int n, int n2, int n3, short s) {
    }

    default public void decreaseSurroundLevel(int n, int n2, short s) {
    }

    default public void increaseSurroundLevel(int n, int n2, short s) {
    }

    default public void setMicGainLevel(int n) {
    }

    default public void decreaseMicGainLevel(short s) {
    }

    default public void increaseMicGainLevel(short s) {
    }

    default public void getNoiseCompensation(int n, int n2) {
    }

    default public void setNoiseCompensation(int n, int n2, short s) {
    }

    default public void increaseNoiseCompensation(int n, int n2, short s) {
    }

    default public void decreaseNoiseCompensation(int n, int n2, short s) {
    }

    default public void getPresetEQ(int n, int n2) {
    }

    default public void setPresetEQ(int n, int n2, int n3) {
    }

    default public void getPresetPosition(int n, int n2) {
    }

    default public void setPresetPosition(int n, int n2, int n3) {
    }

    default public void get3DMode(int n, int n2) {
    }

    default public void set3DMode(int n, int n2, int n3) {
    }

    default public void setSubwooferActivity(int n, int n2, boolean bl) {
    }

    default public void setWidebandSpeech(int n, boolean bl) {
    }

    default public void setDuration(int n, int n2) {
    }

    default public void getSoundShapeActive() {
    }

    default public void setSoundShapeActive(boolean bl) {
    }

    default public void getSoundShape() {
    }

    default public void setSoundShape(short s, short s2, short s3) {
    }

    default public void profileChange(int n) {
    }

    default public void profileCopy(int n, int n2) {
    }

    default public void profileReset(int n) {
    }

    default public void profileResetAll() {
    }
}

