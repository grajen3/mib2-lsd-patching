/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserNotPlayableInfoListTransformer;

public class AVDCAudioBrowserNotPlayableInfoListTransformer
extends AbstractAVDCAudioBrowserNotPlayableInfoListTransformer {
    @Override
    public int getInt(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 1: {
                return extendedListEntry.getSelectionState();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 0: {
                return extendedListEntry.getFilename();
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

