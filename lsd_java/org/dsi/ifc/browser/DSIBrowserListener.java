/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public interface DSIBrowserListener
extends DSIListener {
    default public void updateBrowserState(int n, int n2) {
    }

    default public void updatePageTitle(String string, int n) {
    }

    default public void updateActiveUrl(String string, int n) {
    }

    default public void updateZoomFactor(int n, int n2) {
    }

    default public void updateVirtualKeyboardStatus(boolean bl, int n) {
    }

    default public void updateEncryption(boolean bl, int n) {
    }

    default public void updateHasFocus(boolean bl, int n) {
    }

    default public void updateButtonState(int n, int n2, int n3) {
    }

    default public void updateProgress(int n, int n2) {
    }

    default public void updateScrollbarX(int n, int n2, int n3, int n4) {
    }

    default public void updateScrollbarY(int n, int n2, int n3, int n4) {
    }

    default public void getPreferenceResult(int n, int n2, String string) {
    }

    default public void resumeBrowserResult(int n) {
    }

    default public void indicateEfiUrl(String string) {
    }

    default public void indicateUnknownMimeType(String string, String string2) {
    }

    default public void indicateDownloadUrl(String string) {
    }

    default public void indicatePopup(String string) {
    }

    default public void indicateDownloadProgress(String string, String string2, int n) {
    }

    default public void javascriptAlert(String string) {
    }

    default public void javascriptConfirm(String string) {
    }

    default public void javascriptPrompt(String string, String string2) {
    }

    default public void updateSelectionListContent(SelectionEntry[] selectionEntryArray, boolean bl, int n) {
    }

    default public void exportBrowserDataResult(int n) {
    }

    default public void importBrowserDataResult(int n) {
    }

    default public void getHistoryResult(TimePeriod timePeriod, HistoryEntry[] historyEntryArray, int n) {
    }

    default public void updateKeyboardDisplay(boolean bl, KeyboardInfo keyboardInfo, int n) {
    }
}

