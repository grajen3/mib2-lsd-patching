/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.PredictableModelProperty$ModelUpdater;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;

class MediaPlayerState$4
implements PredictableModelProperty$ModelUpdater {
    private final /* synthetic */ MediaPlayerState this$0;

    MediaPlayerState$4(MediaPlayerState mediaPlayerState) {
        this.this$0 = mediaPlayerState;
    }

    @Override
    public void forward(Object object) {
        if (this.this$0.mListener != null) {
            ListEntry[] listEntryArray = (ListEntry[])MediaPlayerState.access$000(this.this$0).getVisibleProperty();
            EntryInfo entryInfo = (EntryInfo)object;
            ListEntry[] listEntryArray2 = (ListEntry[])MediaPlayerState.access$000(this.this$0).getForwardedProperty();
            EntryInfo entryInfo2 = (EntryInfo)MediaPlayerState.access$100(this.this$0).getForwardedProperty();
            if (!MediaBrowserHelper.isSameFolder(listEntryArray2, listEntryArray) || !MediaBrowserHelper.isSameEntryInfo(entryInfo2, entryInfo)) {
                this.this$0.mListener.onPlaybackEntryChanged(listEntryArray, entryInfo);
                this.this$0.notifyPlaybackEntryListener();
            }
        }
    }
}

