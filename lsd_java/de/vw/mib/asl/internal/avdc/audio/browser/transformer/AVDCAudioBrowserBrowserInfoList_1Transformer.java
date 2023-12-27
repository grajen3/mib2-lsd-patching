/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.browser.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.avdc.audio.browser.transformer.AbstractAVDCAudioBrowserBrowserInfoList_1Transformer;

public class AVDCAudioBrowserBrowserInfoList_1Transformer
extends AbstractAVDCAudioBrowserBrowserInfoList_1Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 0: {
                return extendedListEntry.isActive;
            }
            case 1: {
                return extendedListEntry.isImportable();
            }
            case 2: {
                return false;
            }
            case 5: {
                return extendedListEntry.showErrorText;
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public int getInt(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 4: {
                return extendedListEntry.getSelectionState();
            }
            case 8: {
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(83) && extendedListEntry.getContentType() == 6 && !extendedListEntry.sourceMedia.isRawModeReadyToUse(true)) {
                    return 0;
                }
                return extendedListEntry.getFileType();
            }
            case 6: {
                return extendedListEntry.getFileState();
            }
            case 10: {
                return extendedListEntry.listIndex + 1;
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 9: {
                if (extendedListEntry.sourceMedia.isCDDA()) {
                    return this.isValidCDDATrackName(extendedListEntry.getTitle()) ? extendedListEntry.getTitle() : "";
                }
                return extendedListEntry.getFilename();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    private boolean isValidCDDATrackName(String string) {
        return !Util.isNullOrEmpty(string) && string.trim().length() > 0 && !string.startsWith("cdda.track");
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

