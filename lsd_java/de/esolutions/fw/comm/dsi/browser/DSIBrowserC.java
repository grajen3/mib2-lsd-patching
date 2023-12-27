/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import org.dsi.ifc.browser.TimePeriod;

public interface DSIBrowserC {
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

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

