/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIBase;

public interface DSIBrowserBoardbook
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_BOARDBOOKSTATUS;
    public static final int RT_STARTBOARDBOOK;
    public static final int RT_OPENPAGE;
    public static final int RT_SEARCH;
    public static final int RT_SETLANGUAGE;
    public static final int IN_INDICATESEARCHRESULTS;

    default public void startBoardbook(int n, String string) {
    }

    default public void setLanguage(String string) {
    }

    default public void openPage(int n) {
    }

    default public void search(String string, int n) {
    }
}

