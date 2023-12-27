/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.ListEntryExt;
import org.dsi.ifc.media.SearchListEntryExt;

public class ExtendedListEntry
extends ListEntry {
    public final MediaCollector sourceMedia;
    public final int listIndex;
    public boolean isActive = false;
    public boolean showErrorText = false;
    public ResourceLocator coverBrowserImage = null;

    public ResourceLocator getOriginalCover() {
        return this.extInfo != null ? this.extInfo.coverArtResource : null;
    }

    public ResourceLocator getVisibleCover() {
        return this.coverBrowserImage;
    }

    public ExtendedListEntry() {
        this.sourceMedia = MediaCollector.EMPTY;
        this.listIndex = 0;
        this.setEntryID(-1L);
        this.setFilename("");
        this.setTitle("");
        this.setContentType(-1);
        this.setSecLength(-1);
        this.setFlags(-1);
        this.extInfo = new ListEntryExt();
        this.extInfo.album = "";
        this.extInfo.artist = "";
        this.extInfo.coverArtResource = null;
        this.extInfo.titleID = -1L;
        this.coverBrowserImage = null;
    }

    public ExtendedListEntry(MediaCollector mediaCollector, ListEntry listEntry, int n) {
        this.sourceMedia = mediaCollector;
        this.listIndex = n;
        this.setEntryID(listEntry.getEntryID());
        this.setFilename(listEntry.getFilename());
        this.setTitle(listEntry.getTitle());
        this.setContentType(listEntry.getContentType());
        this.setSecLength(listEntry.getSecLength());
        this.setFlags(listEntry.getFlags());
        this.extInfo = listEntry.extInfo;
        if (this.extInfo == null) {
            this.extInfo = new ListEntryExt();
        }
        this.coverBrowserImage = this.extInfo.coverArtResource;
    }

    public ExtendedListEntry(MediaCollector mediaCollector, SearchListEntryExt searchListEntryExt, int n) {
        this.sourceMedia = mediaCollector;
        this.listIndex = n;
        this.setEntryID(searchListEntryExt.entryID);
        this.setFilename(searchListEntryExt.description);
        this.setTitle(searchListEntryExt.description);
        this.setContentType(this.getContentType(searchListEntryExt.tagType));
        this.setSecLength(-1);
        this.setFlags(searchListEntryExt.flags);
        this.setExtInfo(new ListEntryExt(searchListEntryExt.getAlbum(), searchListEntryExt.getAlbumID(), searchListEntryExt.getArtist(), searchListEntryExt.getArtistID(), searchListEntryExt.getCoverArtResource(), -1L, -1, -1, -1));
        this.coverBrowserImage = this.getExtInfo().getCoverArtResource();
    }

    private int getContentType(int n) {
        switch (n) {
            case 1: {
                return 14;
            }
            case 2: {
                return 16;
            }
            case 3: {
                return 13;
            }
            case 4: {
                return 1;
            }
            case 5: {
                return 2;
            }
            case 7: {
                return 4;
            }
        }
        throw new IllegalStateException("Search not permitted when not in artists, album or title root!");
    }

    public int getFileState() {
        return ExtendedListEntry.flagsToEnum(this.getFlags());
    }

    public static int flagsToEnum(int n) {
        int n2 = 0;
        if (Util.isBitSet(2, n)) {
            n2 = 4;
        } else if (Util.isBitSet(8, n)) {
            n2 = 1;
        } else if (Util.isBitSet(256, n)) {
            n2 = 6;
        } else if (Util.isBitSet(128, n)) {
            n2 = 5;
        } else if (Util.isBitSet(2048, n)) {
            n2 = 0;
        } else if (Util.isBitSet(4, n)) {
            n2 = 2;
        } else if (Util.isBitSet(512, n)) {
            n2 = 2;
        }
        return n2;
    }

    public int getFileType() {
        int n = 0;
        switch (this.getContentType()) {
            case 0: 
            case 1: 
            case 2: {
                n = 1;
                break;
            }
            case 4: 
            case 7: 
            case 8: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: {
                n = 2;
                break;
            }
            case 5: 
            case 6: 
            case 10: {
                n = 3;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    public int getRootFolderType() {
        int n = 0;
        switch (this.getContentType()) {
            case 16: {
                n = 0;
                break;
            }
            case 13: {
                n = 1;
                break;
            }
            case 14: {
                n = 2;
                break;
            }
            case 15: {
                n = 3;
                break;
            }
            case 6: {
                n = 4;
                break;
            }
            case 8: {
                n = 5;
                break;
            }
            case 19: {
                n = 6;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    public int getSelectionState() {
        int n = 0;
        if (Util.isAnyBitSet(1056, this.getFlags())) {
            n = 1;
        } else if (Util.isBitSet(64, this.getFlags())) {
            n = 2;
        }
        return n;
    }

    protected boolean isImportable() {
        return !Util.isAnyBitSet(1039, this.getFlags());
    }

    public boolean hasExtendedInfo() {
        if (this.extInfo != null) {
            String string = this.extInfo.getAlbum();
            String string2 = this.extInfo.getArtist();
            return string2 != null && string2.trim().length() > 0 && string != null && string.trim().length() > 0;
        }
        return false;
    }

    public EntryInfo toEntryInfo() {
        String string = this.extInfo != null && this.extInfo.album != null ? this.extInfo.album : "";
        String string2 = this.extInfo != null && this.extInfo.artist != null ? this.extInfo.artist : "";
        return new EntryInfo(this.getEntryID(), this.getFilename(), this.getContentType(), this.getTitle(), 0L, 0L, 0L, 0L, 0L, string, string2, "", "", "", 0L, 0L, 0, 0, null);
    }

    public void setVisibleCover(ResourceLocator resourceLocator) {
        this.coverBrowserImage = resourceLocator;
    }

    public void setOriginalCover(ResourceLocator resourceLocator) {
        if (this.extInfo != null) {
            this.extInfo.coverArtResource = resourceLocator;
        }
    }

    public boolean isOriginalCoverVisible() {
        return MediaBrowserHelper.isSameResourceLocator(this.getOriginalCover(), this.getVisibleCover());
    }

    public void setEntryID(long l) {
        this.entryID = l;
    }

    public void setContentType(int n) {
        this.contentType = n;
    }

    public void setExtInfo(ListEntryExt listEntryExt) {
        this.extInfo = listEntryExt;
    }

    public void setSecLength(int n) {
        this.secLength = n;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public void setFilename(String string) {
        this.filename = string;
    }

    public void setFlags(int n) {
        this.flags = n;
    }

    public long getEntryId() {
        return this.entryID;
    }
}

