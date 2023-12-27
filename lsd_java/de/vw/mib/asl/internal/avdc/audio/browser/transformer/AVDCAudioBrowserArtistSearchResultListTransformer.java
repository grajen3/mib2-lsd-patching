/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserArtistSearchResultListTransformer;

public class AVDCAudioBrowserArtistSearchResultListTransformer
extends AbstractAVDCAudioBrowserArtistSearchResultListTransformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 0: {
                return extendedListEntry.isActive;
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 1: {
                return !Util.isNullOrEmpty(extendedListEntry.getExtInfo().artist) ? extendedListEntry.getExtInfo().artist : extendedListEntry.getFilename();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }
}

