/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserTitleSearchResultList_1Transformer;

public class AVDCAudioBrowserTitleSearchResultList_1Transformer
extends AbstractAVDCAudioBrowserTitleSearchResultList_1Transformer
implements ItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 0: {
                return extendedListEntry.isActive;
            }
            case 2: {
                return extendedListEntry.showErrorText;
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public int getInt(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 3: {
                return extendedListEntry.getFileState();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 1: {
                return !Util.isNullOrEmpty(extendedListEntry.getTitle()) ? extendedListEntry.getTitle() : extendedListEntry.getFilename();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }
}

