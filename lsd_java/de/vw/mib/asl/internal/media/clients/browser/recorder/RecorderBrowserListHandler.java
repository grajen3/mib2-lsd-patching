/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.recorder;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.clients.browser.AbstractGenericAslListHandler;
import de.vw.mib.asl.internal.media.clients.browser.SharedFolderPath;
import de.vw.mib.asl.internal.media.clients.browser.SharedListMapper;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.CharacterInfo;

public class RecorderBrowserListHandler
extends AbstractGenericAslListHandler {
    private final SharedListMapper mSharedListMapper;
    private final SharedFolderPath mSharedFolderPath;
    private GenericASLList mConnectedList = null;

    public RecorderBrowserListHandler(SharedListMapper sharedListMapper, SharedFolderPath sharedFolderPath) {
        this.mSharedListMapper = sharedListMapper;
        this.mSharedFolderPath = sharedFolderPath;
    }

    @Override
    public GenericASLList getList() {
        return this.mConnectedList;
    }

    @Override
    public void onFolderPathChanged(MediaBrowserState mediaBrowserState) {
        this.mConnectedList = this.mSharedListMapper.getMatchingList(this, mediaBrowserState);
        this.mSharedFolderPath.update(mediaBrowserState);
        DATA_POOL.valueChangedBoolean(4112, false);
    }

    @Override
    public void updateListData(CharacterInfo[] characterInfoArray) {
        super.updateListData(characterInfoArray);
        DATA_POOL.valueChangedBoolean(4112, this.mConnectedList != null && !Util.isNullOrEmpty(characterInfoArray));
    }

    @Override
    protected boolean updateEntry(ExtendedListEntry extendedListEntry, boolean bl) {
        return false;
    }

    @Override
    protected boolean isEntryActive(ExtendedListEntry extendedListEntry) {
        return false;
    }

    @Override
    protected void onActiveEntryChangedInFolder(ExtendedListEntry extendedListEntry, String string) {
    }

    @Override
    protected void onActiveEntryChangedInCache(ExtendedListEntry extendedListEntry, String string) {
    }

    public void focusEntry(ExtendedListEntry extendedListEntry) {
        GenericASLList genericASLList;
        int n = -1;
        if (extendedListEntry != null) {
            n = extendedListEntry.listIndex + 1;
        }
        if ((genericASLList = this.getList()) != null) {
            genericASLList.setActiveIndex(n);
        }
        DATA_POOL.valueChangedInteger(81, n);
    }
}

