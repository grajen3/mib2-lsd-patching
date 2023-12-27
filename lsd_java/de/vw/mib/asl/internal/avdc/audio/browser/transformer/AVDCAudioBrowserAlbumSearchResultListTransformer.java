/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserAlbumSearchResultListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class AVDCAudioBrowserAlbumSearchResultListTransformer
extends AbstractAVDCAudioBrowserAlbumSearchResultListTransformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 0: {
                return extendedListEntry.isActive;
            }
        }
        throw new IllegalArgumentException("The given columnId is not handled");
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 2: {
                return extendedListEntry.getExtInfo().coverArtResource;
            }
        }
        throw new IllegalArgumentException("The given columnId is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 3: {
                return !Util.isNullOrEmpty(extendedListEntry.getExtInfo().album) ? extendedListEntry.getExtInfo().album : extendedListEntry.getFilename();
            }
            case 1: {
                return !Util.isNullOrEmpty(extendedListEntry.getExtInfo().artist) ? extendedListEntry.getExtInfo().artist : "";
            }
        }
        throw new IllegalArgumentException("The given columnId is not handled");
    }
}

