/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbList
extends DSIBase {
    public static final String VERSION;
    public static final int RT_STARTSPELLER;
    public static final int RT_STOPSPELLER;
    public static final int RT_ADDSPELLERCHARS;
    public static final int RT_REMOVESPELLERCHAR;
    public static final int RT_GETVIEWWINDOW;
    public static final int RT_VALIDATESPELLERCHARS;
    public static final int RT_SETLISTSTYLE;
    public static final int RT_GETSPELLERVIEWWINDOW;
    public static final int RT_GETVALIDHANZICHARSWINDOW;
    public static final int RT_ADDSPELLERSTROKE;
    public static final int ATTR_VIEWSIZE;
    public static final int ATTR_ALPHABETICALINDEX;
    public static final int RP_STOPSPELLERRESULT;
    public static final int RP_SPELLERRESULT;
    public static final int RP_GETVIEWWINDOWRESULT;
    public static final int RP_VALIDATESPELLERCHARSRESULT;
    public static final int RP_SETLISTSTYLERESULT;
    public static final int RP_GETSPELLERVIEWWINDOWRESULT;
    public static final int RP_GETVALIDHANZICHARSWINDOWRESULT;
    public static final int IN_INVALIDDATA;

    default public void startSpeller(int n, int n2, int n3) {
    }

    default public void stopSpeller(int n) {
    }

    default public void addSpellerChars(int n, String string) {
    }

    default public void addSpellerStroke(int n, String string) {
    }

    default public void removeSpellerChar(int n) {
    }

    default public void validateSpellerChars(int n, String string) {
    }

    default public void getViewWindow(long l, int n, int n2, int n3) {
    }

    default public void getSpellerViewWindow(int n, long l, int n2, int n3, int n4) {
    }

    default public void getValidHanziCharsWindow(int n, int n2, int n3) {
    }

    default public void setListStyle(int n, int n2, int n3) {
    }
}

