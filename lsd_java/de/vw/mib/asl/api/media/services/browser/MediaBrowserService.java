/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.browser;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.browser.MediaEntriesCallback;
import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.api.media.services.browser.SpeakableElementsListener;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import java.util.List;

public interface MediaBrowserService {
    public static final int CATEGORY_ALL;
    public static final int CATEGORY_PLAYLISTS;
    public static final int CATEGORY_GENRES;
    public static final int CATEGORY_ARTISTS;
    public static final int CATEGORY_ALBUMS;
    public static final int CATEGORY_TITLES;
    public static final int CATEGORY_VIDEOS;

    default public void addSpeakableElementsListener(SpeakableElementsListener speakableElementsListener) {
    }

    default public void browseDatabase(SourceId sourceId, int n, Callback callback) {
    }

    default public void browseRaw(SourceId sourceId, Callback callback) {
    }

    default public void requestEntries(List list, int n, MediaEntriesCallback mediaEntriesCallback) {
    }

    default public void playEntry(MediaEntry mediaEntry, Callback callback) {
    }

    default public void playEntry(int n, Callback callback) {
    }
}

