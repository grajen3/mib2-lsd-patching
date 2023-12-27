/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.MediaBrowserSearchHandler$MediaSearchElementFetcher;

public interface MediaBrowserSearchHandler {
    default public void onSpellerEnter() {
    }

    default public void onSpellerExit() {
    }

    default public void setCursorPosition(int n) {
    }

    default public void addCharacter(String string, int n, int n2, int n3) {
    }

    default public void deleteCharacter() {
    }

    default public String getEnteredText() {
    }

    default public void onSearchStart() {
    }

    default public void updateSearchSize(int n) {
    }

    default public void updateSearchData(ExtendedListEntry[] extendedListEntryArray, int n) {
    }

    default public void setFetcher(MediaSearchElementFetcher mediaSearchElementFetcher) {
    }
}

