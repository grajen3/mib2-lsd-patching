/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.media.persistence.MediaPersistenceService;
import de.vw.mib.asl.media.persistence.PersistedListEntry;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;

public class Selection {
    private boolean mDeprecated = false;
    public static final int SELECTION_SCOPE_RESET;
    public static final int SELECTION_SCOPE_DEFAULT;
    public static final int SELECTION_SCOPE_FOLDER;
    public static final int SELECTION_SCOPE_ENTRY;
    public static final int SELECTION_SCOPE_PLAY_SIMILAR;
    private PlayMode mPlaymode;
    private final String mUniqeMediaId;
    private final int mInstanceId;
    private final boolean mCompositeSelection;
    private final int mSelectionScope;
    private final ListEntry[] mSelectionPath;
    private boolean mRecursive;
    private final boolean mSelected;
    private int mSelectionResult;
    private int mSelectionState;
    private long mSizeAvailable;
    private long mSizeSelected;
    private long mEntriesAvailable;
    private long mEntriesSelected;
    private long mPlaylistsSelected;

    public Selection(PlayMode playMode, int n, String string, ListEntry[] listEntryArray, boolean bl, boolean bl2, boolean bl3, int n2) {
        this.mPlaymode = playMode;
        this.mInstanceId = n;
        this.mUniqeMediaId = string;
        this.mSelectionPath = listEntryArray;
        this.mSelected = bl;
        this.mRecursive = bl2;
        this.mCompositeSelection = bl3;
        this.mSelectionScope = n2;
        this.mSelectionResult = -1;
        this.mSelectionState = -1;
        this.mSizeAvailable = -1L;
        this.mSizeSelected = -1L;
        this.mEntriesAvailable = -1L;
        this.mEntriesSelected = -1L;
    }

    protected void setSelectionResult(int n, int n2, long l, long l2, long l3, long l4, long l5) {
        this.mSelectionResult = n;
        this.mSelectionState = n2;
        this.mSizeAvailable = l;
        this.mSizeSelected = l2;
        this.mEntriesAvailable = l3;
        this.mEntriesSelected = l4;
        this.mPlaylistsSelected = l5;
    }

    public void deprecate() {
        this.mDeprecated = true;
    }

    public boolean isDeprecated() {
        return this.mDeprecated;
    }

    public boolean equalsTo(Selection selection) {
        if (selection == null) {
            return false;
        }
        if (this.mDeprecated || selection.mDeprecated) {
            return false;
        }
        if (this.mInstanceId != selection.mInstanceId) {
            return false;
        }
        if (this.mCompositeSelection || selection.mCompositeSelection) {
            return false;
        }
        if (this.isPlaySimilarSelection() || selection.isPlaySimilarSelection()) {
            return false;
        }
        if (this.mUniqeMediaId == null || !this.mUniqeMediaId.equals(selection.mUniqeMediaId)) {
            return false;
        }
        if (!MediaBrowserHelper.isSameFolder(this.mSelectionPath, selection.mSelectionPath)) {
            return false;
        }
        if (this.mRecursive != selection.mRecursive) {
            return false;
        }
        if (this.mSelected != selection.mSelected) {
            return false;
        }
        return this.mSelectionScope == selection.mSelectionScope;
    }

    public boolean contains(Selection selection) {
        if (selection == null) {
            return false;
        }
        if (this.mCompositeSelection || selection.mCompositeSelection) {
            return false;
        }
        if (this.isPlaySimilarSelection() || selection.isPlaySimilarSelection()) {
            return false;
        }
        if (!this.contains(selection.mUniqeMediaId, selection.mSelectionPath)) {
            return false;
        }
        return this.mSelected == selection.mSelected;
    }

    public boolean contains(MediaCollector mediaCollector, ListEntry[] listEntryArray) {
        if (mediaCollector != null && mediaCollector.getUniqueMediaID() != null) {
            return this.contains(mediaCollector.getUniqueMediaID(), listEntryArray);
        }
        return false;
    }

    private boolean contains(String string, ListEntry[] listEntryArray) {
        if (this.mUniqeMediaId == null || !this.mUniqeMediaId.equals(string)) {
            return false;
        }
        return MediaBrowserHelper.isSameFolder(this.mSelectionPath, listEntryArray) || this.mRecursive && MediaBrowserHelper.isSubFolder(this.mSelectionPath, listEntryArray) && !MediaBrowserHelper.isPlaylistFolder(listEntryArray);
    }

    public boolean isComposite() {
        return this.mCompositeSelection;
    }

    public boolean isPlaySimilarSelection() {
        return this.mSelectionScope == 4;
    }

    public String getUniqueMediaId() {
        return this.mUniqeMediaId;
    }

    public ListEntry[] getSelectionPath() {
        return this.mSelectionPath;
    }

    public boolean isRecursive() {
        return this.mRecursive;
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public int getInstanceID() {
        return this.mInstanceId;
    }

    public long getSelectionResult() {
        return this.mSelectionResult;
    }

    public int getSelectionState() {
        return this.mSelectionState;
    }

    public long getSizeAvailable() {
        return this.mSizeAvailable;
    }

    public long getSizeSelected() {
        return this.mSizeSelected;
    }

    public long getEntriesAvailable() {
        return this.mEntriesAvailable;
    }

    public long getEntriesSelected() {
        return this.mEntriesSelected;
    }

    public long getPlaylistsSelected() {
        return this.mPlaylistsSelected;
    }

    public String toString() {
        String string = new StringBuffer().append("SCOPE=").append(this.getSelectionScopeStr(this.mSelectionScope)).toString();
        String string2 = this.mCompositeSelection ? " (composite)" : "";
        String string3 = new StringBuffer().append("ID=").append(MediaBrowserHelper.getInstanceIdStr(this.mInstanceId)).toString();
        String string4 = new StringBuffer().append("PATH=").append(MediaBrowserHelper.getReducedPathString(this.mSelectionPath)).toString();
        String string5 = this.mRecursive ? " (recursive)" : "";
        String string6 = "RESULT=";
        string6 = this.mSelectionResult != -1 ? new StringBuffer().append(string6).append(MediaBrowserHelper.getSelectionResultStr(this.mSelectionResult)).append(" (").append(this.mEntriesSelected).append(" entries)").toString() : new StringBuffer().append(string6).append("not executed yet").toString();
        string = new StringBuffer().append(string).append(string2).append(", ").append(string3).append(", ").append(string4).append(string5).append(", ").append(string6).toString();
        return string;
    }

    private String getSelectionScopeStr(int n) {
        switch (n) {
            case -1: {
                return "RESET";
            }
            case 1: {
                return "MEDIA";
            }
            case 2: {
                return "FOLDER";
            }
            case 3: {
                return "ENTRY";
            }
            case 4: {
                return "PLAY_SIMILAR";
            }
        }
        return "null";
    }

    public void setRecursive(boolean bl) {
        this.mSelectionResult = -1;
        this.mSelectionState = -1;
        this.mSizeAvailable = -1L;
        this.mSizeSelected = -1L;
        this.mEntriesAvailable = -1L;
        this.mEntriesSelected = -1L;
        this.mRecursive = true;
    }

    public static Selection copyFromPersi2(MediaPlaybackModes mediaPlaybackModes, PersistedSelection persistedSelection) {
        return new Selection(mediaPlaybackModes, persistedSelection);
    }

    private Selection(MediaPlaybackModes mediaPlaybackModes, PersistedSelection persistedSelection) {
        this.mPlaymode = mediaPlaybackModes != null ? mediaPlaybackModes.getPlayModeByASLConstant(persistedSelection.getPlaymode()) : PlayMode.UNKNOWN;
        this.mInstanceId = persistedSelection.getInstanceId();
        this.mSelectionScope = persistedSelection.getSelectionScope();
        this.mCompositeSelection = persistedSelection.isCompositeSelection();
        this.mUniqeMediaId = persistedSelection.getUniqeMediaId();
        this.mSelectionPath = new ListEntry[persistedSelection.getSelectionPath().size()];
        for (int i2 = 0; i2 < persistedSelection.getSelectionPath().size(); ++i2) {
            PersistedListEntry persistedListEntry = (PersistedListEntry)persistedSelection.getSelectionPath().get(i2);
            this.mSelectionPath[i2] = new ListEntry(persistedListEntry.getEntryID(), persistedListEntry.getFilename(), "", persistedListEntry.getContentType(), 0, 0, null);
        }
        this.mRecursive = persistedSelection.isRecursive();
        this.mSelected = persistedSelection.isSelected();
        this.mSelectionResult = persistedSelection.getSelectionResult();
        this.mSelectionState = persistedSelection.getSelectionState();
        this.mSizeAvailable = persistedSelection.getSizeAvailable();
        this.mSizeSelected = persistedSelection.getSizeSelected();
        this.mEntriesAvailable = persistedSelection.getEntriesAvailable();
        this.mEntriesSelected = persistedSelection.getEntriesSelected();
    }

    public PersistedSelection createPersistedSelection(MediaPersistenceService mediaPersistenceService) {
        PersistedSelection persistedSelection = mediaPersistenceService.createPersistedSelection();
        persistedSelection.setPlaymode(this.mPlaymode.getAslPlaymodeID());
        persistedSelection.setInstanceId(this.mInstanceId);
        persistedSelection.setSelectionScope(this.mSelectionScope);
        persistedSelection.setCompositeSelection(this.mCompositeSelection);
        persistedSelection.setUniqeMediaId(this.mUniqeMediaId);
        persistedSelection.getSelectionPath().clear();
        if (this.mSelectionPath != null) {
            for (int i2 = 0; i2 < this.mSelectionPath.length; ++i2) {
                PersistedListEntry persistedListEntry = mediaPersistenceService.createPersistedListEntry();
                persistedListEntry.setEntryID(this.mSelectionPath[i2].getEntryID());
                persistedListEntry.setFilename(this.mSelectionPath[i2].getFilename());
                persistedListEntry.setContentType(this.mSelectionPath[i2].getContentType());
                persistedSelection.getSelectionPath().add(persistedListEntry);
            }
        }
        persistedSelection.setRecursive(this.mRecursive);
        persistedSelection.setSelected(this.mSelected);
        persistedSelection.setSelectionResult(this.mSelectionResult);
        persistedSelection.setSelectionState(this.mSelectionState);
        persistedSelection.setSizeAvailable(this.mSizeAvailable);
        persistedSelection.setSizeSelected(this.mSizeSelected);
        persistedSelection.setEntriesAvailable(this.mEntriesAvailable);
        persistedSelection.setEntriesSelected(this.mEntriesSelected);
        return persistedSelection;
    }

    public boolean isDefault() {
        return this.mSelectionScope == 1;
    }

    public boolean isValid() {
        boolean bl = !Util.isNullOrEmpty(this.mUniqeMediaId);
        boolean bl2 = this.mInstanceId > -1;
        boolean bl3 = !Util.isNullOrEmpty(this.mSelectionPath);
        switch (this.mSelectionScope) {
            case -1: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return bl2 && bl && bl3;
            }
        }
        return false;
    }

    public boolean isDBLSelection() {
        return MediaBrowserHelper.isDBLFolder(this.getSelectionPath());
    }

    public boolean isRAWSelection() {
        return MediaBrowserHelper.isRAWFolder(this.getSelectionPath());
    }

    public PlayMode getPlaymode() {
        return this.mPlaymode;
    }

    public void setPlaymode(PlayMode playMode) {
        this.mPlaymode = playMode;
    }
}

