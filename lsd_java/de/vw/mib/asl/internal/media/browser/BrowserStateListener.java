/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import org.dsi.ifc.media.ListEntry;

public interface BrowserStateListener {
    default public void onBrowseMediaChanged(MediaCollector mediaCollector, int n) {
    }

    default public void onBrowseModeChanged(int n, int n2) {
    }

    default public void onBrowseFolderPathChanged(ListEntry[] listEntryArray, int n) {
    }

    default public void onFocusedEntryChanged(ExtendedListEntry extendedListEntry, int n) {
    }

    default public void onStateChanged(int n, int n2, boolean bl, int n3) {
    }

    default public void onModeSwitchingStateChanged(int n, int n2) {
    }

    default public void notifyChangingPlayerSource(MediaCollector mediaCollector, int n) {
    }

    default public void onBrowseMediaEjected(int n) {
    }

    default public void onPlaymodeCapabilityChanged(int n) {
    }

    default public void onDeviceUpdated() {
    }

    default public void onSelectionChanged(Selection selection, int n) {
    }
}

