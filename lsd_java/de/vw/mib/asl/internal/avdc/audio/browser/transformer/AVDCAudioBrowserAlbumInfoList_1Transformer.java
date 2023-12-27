/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserAlbumInfoList_1Transformer;
import org.dsi.ifc.global.ResourceLocator;

public class AVDCAudioBrowserAlbumInfoList_1Transformer
extends AbstractAVDCAudioBrowserAlbumInfoList_1Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 0: {
                return extendedListEntry.isActive;
            }
            case 2: {
                return false;
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public int getInt(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 3: {
                return extendedListEntry.getSelectionState();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 5: {
                return !Util.isNullOrEmpty(extendedListEntry.getExtInfo().album) ? extendedListEntry.getExtInfo().album : extendedListEntry.getFilename();
            }
            case 1: {
                return !Util.isNullOrEmpty(extendedListEntry.getExtInfo().artist) ? extendedListEntry.getExtInfo().artist : "";
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 4: {
                return extendedListEntry.getExtInfo().coverArtResource;
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public long getLong(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case -2: {
                return extendedListEntry.getEntryID();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }
}

