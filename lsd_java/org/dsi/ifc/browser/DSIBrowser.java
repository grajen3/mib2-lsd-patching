/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.browser.TimePeriod;

public interface DSIBrowser
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_BROWSERSTATE;
    public static final int ATTR_PAGETITLE;
    public static final int ATTR_ACTIVEURL;
    public static final int ATTR_ZOOMFACTOR;
    public static final int ATTR_PROGRESS;
    public static final int ATTR_BUTTONSTATE;
    public static final int ATTR_SCROLLBARX;
    public static final int ATTR_SCROLLBARY;
    public static final int ATTR_HASFOCUS;
    public static final int ATTR_ENCRYPTION;
    public static final int ATTR_VIRTUALKEYBOARDSTATUS;
    public static final int ATTR_SELECTIONLISTCONTENT;
    public static final int ATTR_KEYBOARDDISPLAY;
    public static final int RT_CANCELLOADING;
    public static final int RT_FOLLOWLINK;
    public static final int RT_GETPREFERENCE;
    public static final int RT_GOBACK;
    public static final int RT_GOFORWARD;
    public static final int RT_GOTOHOMEURL;
    public static final int RT_LOADURL;
    public static final int RT_NEXTFOCUS;
    public static final int RT_PREVIOUSFOCUS;
    public static final int RT_SCROLL;
    public static final int RT_RELOADURL;
    public static final int RT_SETPREFERENCE;
    public static final int RT_STOPBROWSER;
    public static final int RT_ZOOM;
    public static final int RT_DELETEHISTORY;
    public static final int RT_SUSPENDBROWSER;
    public static final int RT_RESUMEBROWSER;
    public static final int RT_SETLANGUAGE;
    public static final int RT_DOWNLOADFILE;
    public static final int RT_CLICKONPOSITION;
    public static final int RT_DELETECOOKIES;
    public static final int RT_ENTERIMAGESELECTIONMODE;
    public static final int RT_JAVASCRIPTALERTACK;
    public static final int RT_JAVASCRIPTCONFIRMACK;
    public static final int RT_JAVASCRIPTPROMPTACK;
    public static final int RT_DELETEPASSWORDS;
    public static final int RT_DELETECACHE;
    public static final int RT_BRINGTOFRONT;
    public static final int RT_KEYBOARDINPUT;
    public static final int RT_SETSELECTION;
    public static final int RT_RESETTOFACTORYDEFAULTS;
    public static final int RT_EXPORTBROWSERDATA;
    public static final int RT_IMPORTBROWSERDATA;
    public static final int RT_GETHISTORY;
    public static final int RT_EXECUTEJAVASCRIPT;
    public static final int RT_TOUCHSCROLL;
    public static final int RP_GETPREFERENCERESULT;
    public static final int RP_RESUMEBROWSERRESULT;
    public static final int RP_EXPORTBROWSERDATARESULT;
    public static final int RP_IMPORTBROWSERDATARESULT;
    public static final int RP_GETHISTORYRESULT;
    public static final int IN_JAVASCRIPTALERT;
    public static final int IN_JAVASCRIPTCONFIRM;
    public static final int IN_JAVASCRIPTPROMPT;
    public static final int IN_INDICATEEFIURL;
    public static final int IN_INDICATEDOWNLOADURL;
    public static final int IN_INDICATEUNKNOWNMIMETYPE;
    public static final int IN_INDICATEPOPUP;
    public static final int IN_INDICATEDOWNLOADPROGRESS;

    default public void cancelLoading() {
    }

    default public void followLink(boolean bl) {
    }

    default public void getPreference(int n) {
    }

    default public void goBack() {
    }

    default public void goForward() {
    }

    default public void gotoHomeUrl() {
    }

    default public void loadUrl(String string) {
    }

    default public void nextFocus(int n) {
    }

    default public void previousFocus(int n) {
    }

    default public void scroll(int n, int n2) {
    }

    default public void reloadUrl() {
    }

    default public void setPreference(int n, int n2, String string) {
    }

    default public void stopBrowser() {
    }

    default public void zoom(int n, boolean bl) {
    }

    default public void suspendBrowser() {
    }

    default public void resumeBrowser() {
    }

    default public void setLanguage(String string) {
    }

    default public void deleteCookies() {
    }

    default public void deleteHistory() {
    }

    default public void deletePasswords() {
    }

    default public void deleteCache() {
    }

    default public void downloadFile(String string, String string2) {
    }

    default public void enterImageSelectionMode() {
    }

    default public void clickOnPosition(int n, int n2, boolean bl) {
    }

    default public void javaScriptAlertAck() {
    }

    default public void javaScriptConfirmAck(boolean bl) {
    }

    default public void javaScriptPromptAck(String string, boolean bl) {
    }

    default public void bringToFront() {
    }

    default public void keyboardInput(String string) {
    }

    default public void setSelection(int n, boolean bl) {
    }

    default public void resetToFactoryDefaults() {
    }

    default public void exportBrowserData(String string) {
    }

    default public void importBrowserData(String string) {
    }

    default public void getHistory(TimePeriod timePeriod) {
    }

    default public void executeJavaScript(String string) {
    }

    default public void touchScroll(int n, int n2) {
    }
}

