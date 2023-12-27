/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.avdc.audio.bap.mediabrowser.transformer.AbstractAVDCAudioBapMediaBrowserFileBrowserTransformer;

public class AVDCAudioBapMediaBrowserFileBrowserTransformer
extends AbstractAVDCAudioBapMediaBrowserFileBrowserTransformer {
    @Override
    public int getInt(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 5: {
                return this.getBapContentType(extendedListEntry.getContentType());
            }
            case 6: {
                int n2 = extendedListEntry.getFlags();
                if (extendedListEntry.getContentType() == 5 && !extendedListEntry.sourceMedia.isRawModeReadyToUse(true)) {
                    n2 |= 0x80;
                }
                return n2;
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        ExtendedListEntry extendedListEntry = (ExtendedListEntry)object;
        switch (n) {
            case 3: {
                return extendedListEntry.getExtInfo() != null ? extendedListEntry.getExtInfo().album : "";
            }
            case 4: {
                return extendedListEntry.getExtInfo() != null ? extendedListEntry.getExtInfo().artist : "";
            }
            case 1: {
                return extendedListEntry.getFilename();
            }
            case 2: {
                if (extendedListEntry.sourceMedia.isCDDA() && !this.isValidCDDATrackName(extendedListEntry.getTitle())) {
                    return new StringBuffer().append("cdda.track").append(extendedListEntry.listIndex + 1).toString();
                }
                return extendedListEntry.getTitle();
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
            case 0: {
                return extendedListEntry.getEntryID();
            }
            case -2: {
                return extendedListEntry.getEntryID();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    private int getBapContentType(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            case 9: {
                n2 = 9;
                break;
            }
            case 10: {
                n2 = 10;
                break;
            }
            case 11: {
                n2 = 11;
                break;
            }
            case 12: {
                n2 = 12;
                break;
            }
            case 13: {
                n2 = 13;
                break;
            }
            case 14: {
                n2 = 14;
                break;
            }
            case 15: {
                n2 = 15;
                break;
            }
            case 16: {
                n2 = 16;
                break;
            }
            case 17: {
                n2 = 17;
                break;
            }
            case 18: {
                n2 = 18;
                break;
            }
            case 19: {
                n2 = 19;
                break;
            }
            case 20: {
                n2 = 20;
                break;
            }
        }
        return n2;
    }
}

