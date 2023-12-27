/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling;

import de.vw.mib.asl.api.devicehandling.DeviceState;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.MediaInfo;

public final class MediumState {
    public static final int ERROR__NO_ERROR;
    public static final int ERROR__NO_CONTENT;
    public static final int ERROR__NO_PLAYABLE_FILES;
    public static final int ERROR__UNSUPPORTED;
    public static final int ERROR__UNREADABLE;
    public static final int ERROR__NAVI_DB;
    public static final int ERROR__SWDL;
    public static final int ERROR__DEVICE_INVALID;
    public static final int ERROR__CORRUPT_PARTITION;
    public static final int ERROR__IPOD_ALREADY_CONNECTED;
    public static final int ERROR__EMPTY;
    public static final int ERROR__IMPORTING;
    public static final MediaInfo EMPTY_MEDIA_INFO;
    private MediaInfo info = EMPTY_MEDIA_INFO;
    DeviceState deviceState;

    MediumState(DeviceState deviceState) {
        this.deviceState = deviceState;
    }

    public MediaInfo getInfo() {
        return this.info;
    }

    public void setInfo(MediaInfo mediaInfo) {
        this.info = mediaInfo;
        if (mediaInfo.getMediaCaps() != null && mediaInfo.getMediaType() == 10) {
            mediaInfo.mediaCaps = new MediaCapabilities();
            mediaInfo.flags = 0;
        }
    }

    public int getErrorType() {
        int n = this.getInfo().getMediaType();
        if (n == 19) {
            return 5;
        }
        if (n == 17) {
            return 6;
        }
        if (n == 15 || Util.isBitSet(0x800000, this.info.flags)) {
            return 3;
        }
        if (n == 11) {
            return 4;
        }
        if (Util.isBitSet(2, this.info.flags)) {
            return 10;
        }
        if (Util.isBitSet(1, this.info.flags)) {
            return 2;
        }
        if (Util.isBitSet(1024, this.info.flags)) {
            return 1;
        }
        if (Util.isBitSet(1, this.info.flags)) {
            return 9;
        }
        if (!this.deviceState.isOperable()) {
            return 8;
        }
        if (!this.isInserted()) {
            return 11;
        }
        if (this.isOpticalMedia() && this.info.getMediaType() != 1 && Util.isBitSet(16, this.info.flags)) {
            return 12;
        }
        return 0;
    }

    public boolean isDatabaseFull() {
        return Util.isBitSet(4, this.info.flags);
    }

    public boolean isInserted() {
        return this.info != EMPTY_MEDIA_INFO && this.info.getMediaType() != 10 && this.info.getMediaType() != 12 && this.info.getMediaType() != 0;
    }

    public boolean isAvailable() {
        int n = this.info.getMediaType();
        if (this.deviceState.isOperable()) {
            return n != 10 && n != 13 && n != 12 && n != 19 && n != 0;
        }
        return false;
    }

    public boolean isUserAvailable() {
        int n = this.info.getMediaType();
        if (this.deviceState.isOperable()) {
            return n != 10 && n != 13 && n != 12 && n != 19 && n != 0 || this.deviceState.isDisconnectable();
        }
        return false;
    }

    public boolean isOpticalRom() {
        switch (this.info.getMediaType()) {
            case 5: 
            case 6: {
                return true;
            }
        }
        return false;
    }

    public boolean isOpticalMedia() {
        switch (this.info.getMediaType()) {
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 6: 
            case 21: {
                return true;
            }
        }
        return false;
    }

    public boolean isPlayable() {
        if (!this.deviceState.isOperable()) {
            return false;
        }
        return this.isPlayableIgnoringVdrop();
    }

    public boolean isPlayableIgnoringVdrop() {
        switch (this.info.getMediaType()) {
            case 0: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 15: 
            case 17: 
            case 19: {
                return false;
            }
        }
        if (Util.isAnyBitSet(25432064, this.info.getFlags())) {
            return false;
        }
        return !Util.isAnyBitSet(16, this.info.getFlags()) || !this.isOpticalRom();
    }

    public boolean isDeletable() {
        if (!this.deviceState.isOperable()) {
            return false;
        }
        switch (this.info.getMediaType()) {
            case 0: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 15: 
            case 17: 
            case 19: {
                return false;
            }
        }
        return !Util.isAnyBitSet(8654848, this.info.getFlags());
    }

    public boolean isMediaInSlot() {
        return this.info != null && this.info.mediaType != 10 && this.info.mediaType != 13 && this.info.mediaType != 12 && this.info.mediaType != 0;
    }

    public boolean isPictureViewerAvailable() {
        return this.isMediaInSlot() && this.info.mediaType != 19 && this.info.mediaType != 1 && this.info.mediaType != 2 && this.info.mediaType != 20 && !Util.isNullOrEmpty(this.info.mountPoint);
    }

    public static String getMediaTypeStr(int n) {
        return new StringBuffer().append(MediumState.getMediaTypeStringOnly(n)).append("(").append(n).append(")").toString();
    }

    private static String getMediaTypeStringOnly(int n) {
        switch (n) {
            case 0: {
                return "UNKNOWN";
            }
            case 1: {
                return "CD_AUDIO";
            }
            case 2: {
                return "DVD_AUDIO";
            }
            case 3: {
                return "DVD_VIDEO";
            }
            case 5: {
                return "CD-ROM";
            }
            case 6: {
                return "DVD_ROM";
            }
            case 7: {
                return "FILESYSTEM";
            }
            case 8: {
                return "RAW";
            }
            case 9: {
                return "RCP";
            }
            case 10: {
                return "EMPTY";
            }
            case 11: {
                return "UNREADABLE";
            }
            case 12: {
                return "LOADING";
            }
            case 13: {
                return "RELOAD";
            }
            case 15: {
                return "UNSUPPORTED";
            }
            case 17: {
                return "SWDL";
            }
            case 18: {
                return "FILEPLAYER";
            }
            case 19: {
                return "NAVI DB";
            }
            case 20: {
                return "IPOD";
            }
        }
        return "!UNKNOWN!";
    }

    public String getMediaTypeStr() {
        if (this.info != null) {
            return MediumState.getMediaTypeStr(this.info.getMediaType());
        }
        return "(no info)";
    }

    public static String getMediaFlagsStr(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        if (Util.isBitSet(256, n)) {
            stringBuffer.append("PASS_FILESYSTEM|");
        }
        if (Util.isBitSet(512, n)) {
            stringBuffer.append("PASS_METADATA|");
        }
        if (Util.isBitSet(1024, n)) {
            stringBuffer.append("PASS_COVERART|");
        }
        if (Util.isBitSet(8, n)) {
            stringBuffer.append("PASS_ALL|");
        }
        if (Util.isBitSet(2048, n)) {
            stringBuffer.append("PASS_EXTERNAL_METADATA|");
        }
        if (Util.isBitSet(16384, n)) {
            stringBuffer.append("READY_FOR_RECORDER|");
        }
        if (Util.isBitSet(16, n)) {
            stringBuffer.append("IMPORT_RUNNING|");
        }
        if (Util.isBitSet(4096, n)) {
            stringBuffer.append("DELETION_RUNNING|");
        }
        if (Util.isBitSet(4096, n)) {
            stringBuffer.append("COPY_PROTECTED|");
        }
        if (Util.isBitSet(512, n)) {
            stringBuffer.append("PLAYBACK|");
        }
        if (Util.isBitSet(1024, n)) {
            stringBuffer.append("NO_CONTENT|");
        }
        if (Util.isBitSet(1, n)) {
            stringBuffer.append("NOPLAYABLEFILES|");
        }
        if (Util.isBitSet(16384, n)) {
            stringBuffer.append("LAST_PLAYSELECTION_VALID|");
        }
        if (Util.isBitSet(32, n)) {
            stringBuffer.append("INVALID_REGIONCODE|");
        }
        if (Util.isBitSet(64, n)) {
            stringBuffer.append("PML_BLOCKED|");
        }
        if (Util.isBitSet(128, n)) {
            stringBuffer.append("PML_RESTRICTED|");
        }
        if (Util.isBitSet(8192, n)) {
            stringBuffer.append("READ_ONLY|");
        }
        if (Util.isBitSet(0x800000, n)) {
            stringBuffer.append("FIRMWARE_NOT_SUPPORTED|");
        }
        if (Util.isBitSet(128, n)) {
            stringBuffer.append("READY_FOR_ALBUMBROWSER|");
        }
        if (Util.isBitSet(32768, n)) {
            stringBuffer.append("INTERNATIONALIZABLE|");
        }
        if (Util.isBitSet(1, n)) {
            stringBuffer.append("CORRUPTED_PARTITION|");
        }
        if (Util.isBitSet(2, n)) {
            stringBuffer.append("CHARGING|");
        }
        if (stringBuffer.length() == 0) {
            return "no flags";
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static String getCriticalMediaFlagsStr(int n) {
        String string = "";
        if (Util.isBitSet(1, n)) {
            string = new StringBuffer().append(string).append("|NOPLAYABLEFILES").toString();
        }
        if (Util.isBitSet(32, n)) {
            string = new StringBuffer().append(string).append("|INVALID_REGIONCODE").toString();
        }
        if (Util.isBitSet(64, n)) {
            string = new StringBuffer().append(string).append("|PML_BLOCKED").toString();
        }
        if (Util.isBitSet(128, n)) {
            string = new StringBuffer().append(string).append("|PML_RESTRICTED").toString();
        }
        if (Util.isBitSet(1024, n)) {
            string = new StringBuffer().append(string).append("|NO_CONTENT").toString();
        }
        if (Util.isBitSet(0x800000, n)) {
            string = new StringBuffer().append(string).append("|FIRMWARE_NOT_SUPPORTED").toString();
        }
        if (Util.isBitSet(16384, n)) {
            string = new StringBuffer().append(string).append("|LAST_PLAYSELECTION_VALID").toString();
        }
        if (string.length() == 0) {
            return "no critical flags";
        }
        return string.substring(1);
    }

    public String toString() {
        return new StringBuffer().append("MediumState(").append(this.info.deviceID).append("/").append(this.info.mediaID).append("), type(").append(this.getMediaTypeStr()).append("), flags(").append(MediumState.getMediaFlagsStr(this.info.flags)).append(")").toString();
    }

    public boolean isReadOnly() {
        return Util.isBitSet(8192, this.getInfo().getFlags());
    }

    public boolean isWritable() {
        return this.isMediaInSlot() && this.getInfo().getMountPoint() != null && !this.isReadOnly();
    }

    public boolean isDVDVideoAudio() {
        return this.deviceState.isVersatile() && (this.info.mediaType == 2 || this.info.mediaType == 3);
    }

    public int getObservedStatus() {
        if (this.getInfo().getMediaType() == 12) {
            return 12;
        }
        switch (this.getErrorType()) {
            case 11: {
                return 10;
            }
            case 8: {
                return 0;
            }
            case 1: 
            case 2: {
                return 14;
            }
            case 0: {
                return 7;
            }
            case 6: {
                return 17;
            }
            case 5: {
                return 19;
            }
        }
        return 11;
    }

    static {
        EMPTY_MEDIA_INFO = new MediaInfo();
    }
}

