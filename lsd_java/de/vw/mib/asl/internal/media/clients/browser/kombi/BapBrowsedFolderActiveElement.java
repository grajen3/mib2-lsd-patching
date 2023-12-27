/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.kombi;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector;

public class BapBrowsedFolderActiveElement {
    private static final GenericASLList BROWSED_FOLDER_ACTIVE_ELEMENT = ListManager.getGenericASLList(509348864);
    private final AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector[] mBrowsedFolderActiveElement = (AVDCAudioBapMediaBrowserBrowsedFolderActiveElementCollector[])BROWSED_FOLDER_ACTIVE_ELEMENT.getDSIObjects();

    private void reset() {
        this.mBrowsedFolderActiveElement[0].avdc_audio_bap_mediabrowser_entry_id = -1L;
        this.mBrowsedFolderActiveElement[0].avdc_audio_bap_mediabrowser_content_type = 0;
        this.mBrowsedFolderActiveElement[0].avdc_audio_bap_mediabrowser_abs_pos = -1;
        BROWSED_FOLDER_ACTIVE_ELEMENT.updateList(this.mBrowsedFolderActiveElement);
    }

    public void update(ExtendedListEntry extendedListEntry) {
        if (extendedListEntry == null) {
            this.reset();
            return;
        }
        this.mBrowsedFolderActiveElement[0].avdc_audio_bap_mediabrowser_entry_id = extendedListEntry.getEntryID();
        this.mBrowsedFolderActiveElement[0].avdc_audio_bap_mediabrowser_content_type = this.getBrowsedFolderActiveElementType(extendedListEntry.getContentType());
        this.mBrowsedFolderActiveElement[0].avdc_audio_bap_mediabrowser_abs_pos = extendedListEntry.listIndex;
        BROWSED_FOLDER_ACTIVE_ELEMENT.updateList(this.mBrowsedFolderActiveElement);
    }

    private int getBrowsedFolderActiveElementType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 7: {
                return 7;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 13: {
                return 12;
            }
            case 14: {
                return 13;
            }
            case 15: {
                return 14;
            }
            case 16: {
                return 15;
            }
            case 17: {
                return 16;
            }
            case 18: {
                return 17;
            }
            case 19: {
                return 18;
            }
            case 20: {
                return 19;
            }
        }
        return 0;
    }
}

