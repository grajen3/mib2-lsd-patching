/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.api.media.services.browser.MediaEntry;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.controller.I18nStringFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.ListEntry;

public class MediaEntryFactory {
    private static MediaEntry[] createMediaEntryListInternal(ListEntry[] listEntryArray) {
        MediaEntry[] mediaEntryArray = null;
        if (listEntryArray != null) {
            mediaEntryArray = new MediaEntry[listEntryArray.length];
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                mediaEntryArray[i2] = MediaEntryFactory.createMediaEntry(listEntryArray[i2]);
            }
        }
        return mediaEntryArray;
    }

    public static List createMediaEntryList(ListEntry[] listEntryArray) {
        return Collections.unmodifiableList(Arrays.asList(MediaEntryFactory.createMediaEntryListInternal(listEntryArray)));
    }

    private static MediaEntry createMediaEntry(ListEntry listEntry) {
        if (listEntry == null) {
            return null;
        }
        long l = listEntry.entryID;
        int n = listEntry.contentType;
        String string = null;
        if (n == 16) {
            string = listEntry.getFilename();
        }
        String string2 = null;
        if (n == 13) {
            string2 = listEntry.getFilename();
        } else if (listEntry.extInfo != null) {
            string2 = listEntry.extInfo.artist;
        }
        String string3 = null;
        if (n == 14) {
            string3 = listEntry.getFilename();
        } else if (listEntry.extInfo != null) {
            string3 = listEntry.extInfo.album;
        }
        String string4 = null;
        string4 = n != 1 && n != 2 ? listEntry.getFilename() : listEntry.getTitle();
        String string5 = listEntry.getFilename();
        int n2 = ExtendedListEntry.flagsToEnum(listEntry.flags);
        ResourceLocator resourceLocator = listEntry.getExtInfo() != null ? listEntry.getExtInfo().coverArtResource : null;
        return new MediaEntry(l, n, I18nStringFactory.createI18nString(string), I18nStringFactory.createI18nString(string2), I18nStringFactory.createI18nString(string3), I18nStringFactory.createI18nString(string4), I18nStringFactory.createI18nString(string5), resourceLocator, n2);
    }
}

