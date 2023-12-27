/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.kombi;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserBrowsedFolderCollector;
import org.dsi.ifc.media.ListEntry;

public class BapBrowsedFolder {
    private static final GenericASLList BROWSED_FOLDER = ListManager.getGenericASLList(3831);
    private static AVDCAudioBapMediaBrowserBrowsedFolderCollector[] mBrowsedFolder = (AVDCAudioBapMediaBrowserBrowsedFolderCollector[])BROWSED_FOLDER.getDSIObjects();

    public static void update(MediaBrowserState mediaBrowserState) {
        BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_entry_id = -1L;
        BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_content_type = 0;
        BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_folder_name = "";
        BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_folder_level = -1;
        MediaCollector mediaCollector = null;
        ListEntry[] listEntryArray = null;
        if (mediaBrowserState != null) {
            mediaCollector = mediaBrowserState.getBrowseMedia();
            listEntryArray = mediaBrowserState.getBrowseFolder();
        }
        if (mediaCollector != null && listEntryArray != null && listEntryArray.length > 0) {
            String string;
            ListEntry listEntry = listEntryArray[listEntryArray.length - 1];
            BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_entry_id = listEntry.getEntryID();
            BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_content_type = BapBrowsedFolder.getBrowsedFolderType(listEntry.getContentType());
            String string2 = string = listEntryArray.length == 1 ? mediaCollector.getName() : listEntry.getFilename();
            if (string != null) {
                BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_folder_name = string;
            }
            BapBrowsedFolder.mBrowsedFolder[0].avdc_audio_bap_mediabrowser_folder_level = listEntryArray.length - 1;
        }
        BROWSED_FOLDER.updateList(mBrowsedFolder);
    }

    public static int getBrowsedFolderType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 5: {
                return 2;
            }
            case 6: {
                return 3;
            }
            case 7: {
                return 4;
            }
            case 8: {
                return 5;
            }
            case 9: {
                return 6;
            }
            case 10: {
                return 7;
            }
            case 11: {
                return 8;
            }
            case 13: {
                return 9;
            }
            case 14: {
                return 10;
            }
            case 15: {
                return 11;
            }
            case 16: {
                return 12;
            }
            case 17: {
                return 13;
            }
            case 18: {
                return 14;
            }
            case 19: {
                return 15;
            }
            case 20: {
                return 16;
            }
        }
        return 0;
    }
}

