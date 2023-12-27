/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.keypanel;

import org.dsi.ifc.base.DSIBase;

public interface DSIKeyPanel
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETILLUMINATION;
    public static final int RT_SETTMDISPLAYSTATE;
    public static final int RT_SETRECOGNIZERLANGUAGE;
    public static final int RT_SETRECOGNIZERMODE;
    public static final int RT_SETGENERICSETTING;
    public static final int RT_RESETDEVICE;
    public static final int RT_REQUESTGENERICSETTING;
    public static final int RT_REQUESTLASTKEY;
    public static final int RT_SETHAPTICFEEDBACK;
    public static final int RT_SETRECOGNIZERLANGUAGE2;
    public static final int RT_GETVERSIONINFO;
    public static final int RT_SETTOUCHSENSITIVEAREA;
    public static final int RT_CLEARRECOGNIZER;
    public static final int RT_GETPROPERTY;
    public static final int ATTR_DISPLAYTURNMECHSTATUS;
    public static final int ATTR_RECOGNIZERMODE;
    public static final int ATTR_PROXIMITY;
    public static final int ATTR_KEYBOARDTYPE;
    public static final int ATTR_GESTURE2;
    public static final int ATTR_CHARACTEREVENT2;
    public static final int ATTR_RECOGNIZERLANGUAGE2;
    public static final int ATTR_ENCODER2;
    public static final int ATTR_TOUCHSENSITIVEAREA;
    public static final int ATTR_KEY2;
    public static final int ATTR_INPUTPANELREADY;
    public static final int ATTR_ADVANCEDPROXIMITY;
    public static final int RP_GENERICSETTINGRESPONSE;
    public static final int RP_LASTKEY;
    public static final int RP_GETVERSIONINFO;
    public static final int RP_GETPROPERTY;

    default public void setIllumination(int n, int n2, int n3) {
    }

    default public void setHapticFeedback(int n, int n2, int n3) {
    }

    default public void setTMDisplayState(boolean bl) {
    }

    default public void setRecognizerLanguage(int n, String string) {
    }

    default public void setRecognizerLanguage2(int n, String string, int n2) {
    }

    default public void setRecognizerMode(int n, int n2) {
    }

    default public void clearRecognizer(int n) {
    }

    default public void setGenericSetting(int n, int n2, int n3) {
    }

    default public void resetDevice(int n) {
    }

    default public void requestGenericSetting(int n, int n2) {
    }

    default public void requestLastKey(int n) {
    }

    default public void getVersionInfo(int n, int n2) {
    }

    default public void setTouchSensitiveArea(int n, int n2, int n3, int n4, int n5) {
    }

    default public void getProperty(int n, int n2, int n3) {
    }
}

