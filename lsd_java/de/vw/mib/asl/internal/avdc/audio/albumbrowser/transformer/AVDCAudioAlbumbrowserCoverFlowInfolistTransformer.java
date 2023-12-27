/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.albumbrowser.transformer;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import generated.de.vw.mib.asl.internal.avdc.audio.albumbrowser.transformer.AbstractAVDCAudioAlbumbrowserCoverFlowInfolistTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class AVDCAudioAlbumbrowserCoverFlowInfolistTransformer
extends AbstractAVDCAudioAlbumbrowserCoverFlowInfolistTransformer {
    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 0: {
                if (extendedListEntry != null && extendedListEntry.getExtInfo() != null && extendedListEntry.getExtInfo().album != null) {
                    return extendedListEntry.getExtInfo().album;
                }
                return "";
            }
            case 2: {
                if (extendedListEntry != null && extendedListEntry.getExtInfo() != null && extendedListEntry.getExtInfo().artist != null) {
                    return extendedListEntry.getExtInfo().artist;
                }
                return "";
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 1: {
                return extendedListEntry.coverBrowserImage;
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

