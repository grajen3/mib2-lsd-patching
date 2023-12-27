/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.media.ASLMediaFactory;
import de.vw.mib.asl.api.media.AlphabeticalScrollBarInfo;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler$MediaListElementFetcher;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;

public abstract class AbstractGenericAslListHandler
implements MediaBrowserListHandler,
ASLListElementFetcher {
    protected static final ASLPropertyManager DATA_POOL = ServiceManager.aslPropertyManager;
    private MediaBrowserListHandler$MediaListElementFetcher mConnectedFetcher = null;
    private boolean mFolderPathChanged;

    protected void registerList(GenericASLList genericASLList, boolean bl) {
        int n = 0;
        if (bl) {
            genericASLList.enableModCount();
            n |= 8;
        }
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 10, n);
        genericASLList.setColumn4ObjectId(-2);
    }

    public abstract GenericASLList getList() {
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.mConnectedFetcher != null) {
            this.mConnectedFetcher.fetchItems(n, n2);
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (this.mConnectedFetcher != null) {
            this.mConnectedFetcher.fetchItems(n, n2);
        }
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (this.mConnectedFetcher != null) {
            this.mConnectedFetcher.fetchItems(n, n2);
        }
    }

    @Override
    public void setFetcher(MediaBrowserListHandler$MediaListElementFetcher mediaBrowserListHandler$MediaListElementFetcher) {
        this.mConnectedFetcher = mediaBrowserListHandler$MediaListElementFetcher;
    }

    @Override
    public void updateFolderPath(MediaBrowserState mediaBrowserState) {
        this.onActiveEntryChangedInFolder(null, "clear activeEntry on changeFolder");
        this.onActiveEntryChangedInCache(null, "clear activeEntry on changeFolder");
        this.mFolderPathChanged = true;
        this.onFolderPathChanged(mediaBrowserState);
    }

    protected abstract void onFolderPathChanged(MediaBrowserState mediaBrowserState) {
    }

    @Override
    public void refetch() {
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null) {
            this.refresh(this.getList().getSize());
        }
    }

    @Override
    public void refresh(int n) {
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null) {
            genericASLList.setSizeClearCache(n);
        }
    }

    @Override
    public void updateListSize(int n) {
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null) {
            if (this.mFolderPathChanged || n == 0) {
                genericASLList.setSize(n);
            } else {
                this.refresh(n);
            }
        }
        this.mFolderPathChanged = false;
    }

    protected void updateListCache() {
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null) {
            ExtendedListEntry extendedListEntry = null;
            boolean bl = false;
            for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                Object object = genericASLList.getRowItemCacheOnly(i2);
                if (!genericASLList.isValidItem(object)) continue;
                ExtendedListEntry extendedListEntry2 = (ExtendedListEntry)object;
                boolean bl2 = this.isEntryActive(extendedListEntry2);
                if (bl2) {
                    if (extendedListEntry == null) {
                        extendedListEntry = extendedListEntry2;
                    } else {
                        bl = true;
                        ServiceManager.logger.warn(1024, "Result from title string matching discarded due to >1 match!");
                        if (this.updateEntry(extendedListEntry, false)) {
                            genericASLList.updateListItem(extendedListEntry.listIndex, extendedListEntry);
                        }
                    }
                }
                if (bl && bl2 || !this.updateEntry(extendedListEntry2, bl2)) continue;
                genericASLList.updateListItem(i2, extendedListEntry2);
            }
            if (extendedListEntry != null && !bl) {
                this.onActiveEntryChangedInFolder(extendedListEntry, "activeEntry found in list cache");
            }
            this.onActiveEntryChangedInCache(extendedListEntry, "activeEntry found in list cache");
        }
    }

    protected abstract void onActiveEntryChangedInCache(ExtendedListEntry extendedListEntry, String string) {
    }

    protected abstract void onActiveEntryChangedInFolder(ExtendedListEntry extendedListEntry, String string) {
    }

    @Override
    public void updateListData(ExtendedListEntry[] extendedListEntryArray, int n) {
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null && !Util.isNullOrEmpty(extendedListEntryArray)) {
            ExtendedListEntry extendedListEntry = null;
            boolean bl = false;
            for (int i2 = 0; i2 < extendedListEntryArray.length; ++i2) {
                boolean bl2 = this.isEntryActive(extendedListEntryArray[i2]);
                if (!bl2) continue;
                if (extendedListEntry == null) {
                    extendedListEntry = extendedListEntryArray[i2];
                    this.updateEntry(extendedListEntry, true);
                    continue;
                }
                bl = true;
                ServiceManager.logger.warn(1024, "Result from title string matching discarded due to >1 match!");
                this.updateEntry(extendedListEntry, false);
            }
            genericASLList.updateListItems(n, extendedListEntryArray);
            if (extendedListEntry != null && !bl) {
                this.onActiveEntryChangedInFolder(extendedListEntry, "activeEntry found in list data");
                this.onActiveEntryChangedInCache(extendedListEntry, "activeEntry found in list data");
            }
        }
    }

    protected abstract boolean updateEntry(ExtendedListEntry extendedListEntry, boolean bl) {
    }

    protected abstract boolean isEntryActive(ExtendedListEntry extendedListEntry) {
    }

    @Override
    public void updateListData(CharacterInfo[] characterInfoArray) {
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null) {
            AlphabeticalScrollBarInfo alphabeticalScrollBarInfo = ASLMediaFactory.getMediaApi().convertCharacterInfo(characterInfoArray);
            genericASLList.updateStringIndex(alphabeticalScrollBarInfo.getIndices(), alphabeticalScrollBarInfo.getCharacters());
        }
    }

    @Override
    public ExtendedListEntry getListEntryById(long l, int n) {
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null) {
            for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                ExtendedListEntry extendedListEntry;
                Object object = genericASLList.getRowItemCacheOnly(i2);
                ExtendedListEntry extendedListEntry2 = extendedListEntry = genericASLList.isValidItem(object) ? (ExtendedListEntry)object : null;
                if (extendedListEntry == null || extendedListEntry.getEntryID() != l || extendedListEntry.getContentType() != n) continue;
                return extendedListEntry;
            }
        }
        return null;
    }

    @Override
    public ExtendedListEntry getListEntryByTitle(String string) {
        GenericASLList genericASLList = this.getList();
        ExtendedListEntry extendedListEntry = null;
        if (genericASLList != null) {
            for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                ExtendedListEntry extendedListEntry2;
                Object object = genericASLList.getRowItemCacheOnly(i2);
                ExtendedListEntry extendedListEntry3 = extendedListEntry2 = genericASLList.isValidItem(object) ? (ExtendedListEntry)object : null;
                if (extendedListEntry2 == null || !extendedListEntry2.getTitle().equals(string)) continue;
                if (extendedListEntry != null) {
                    ServiceManager.logger.warn(1024, "Result from title string matching discarded due to >1 match!");
                    return null;
                }
                extendedListEntry = extendedListEntry2;
            }
        }
        return extendedListEntry;
    }

    @Override
    public ExtendedListEntry getListEntryByIndex(int n) {
        Object object;
        GenericASLList genericASLList = this.getList();
        ExtendedListEntry extendedListEntry = null;
        if (genericASLList != null && genericASLList.isValidItem(object = genericASLList.getRowItemCacheOnly(n))) {
            extendedListEntry = (ExtendedListEntry)object;
        }
        return extendedListEntry;
    }

    @Override
    public void showErrorInformation(ListEntry listEntry) {
    }
}

