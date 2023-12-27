/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.state;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.MediumState;
import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSource;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.MediaInfo;

public final class MediaCollector {
    private static final int NO_FLAGS;
    public static final MediaCollector EMPTY;
    public static final MediaCollector UNDEFINED;
    private final DeviceCollector mParentDevice;
    private final Medium medium;
    private boolean mediaActive = false;
    private Capabilities playerCapabilities;
    private boolean mImportedTo = false;

    public long getDeviceID() {
        return this.medium.getCurrentInfo().deviceID;
    }

    public long getMediaID() {
        return this.medium.getCurrentInfo().mediaID;
    }

    public int getMediaType() {
        return this.medium.getCurrentInfo().getMediaType();
    }

    public String getUniqueMediaID() {
        return this.medium.getCurrentInfo().getUniqueMediaID();
    }

    public String getName() {
        return this.medium.getCurrentInfo().getName();
    }

    public int getFlags() {
        return this.medium.getCurrentInfo().getFlags();
    }

    public MediaCapabilities getMediaCaps() {
        return this.medium.getCurrentInfo().getMediaCaps();
    }

    private MediaCollector(DeviceCollector deviceCollector) {
        this.medium = deviceCollector.getDevice().getMainMedium();
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.mountPoint = "EMPTY";
        mediaInfo.flags = 0x8000100;
        mediaInfo.mediaCaps = new MediaCapabilities();
        this.medium.getCurrentState().setInfo(mediaInfo);
        this.medium.getPreviousState().setInfo(mediaInfo);
        this.mParentDevice = deviceCollector;
        deviceCollector.usePartition(this);
        this.medium.tags().put(313463552, this);
        this.mediaActive = true;
    }

    public MediaCollector(Medium medium, DeviceCollector deviceCollector) {
        this.medium = medium;
        medium.tags().put(313463552, this);
        this.mParentDevice = deviceCollector;
    }

    public Medium getMedium() {
        return this.medium;
    }

    public static MediaCollector get(Medium medium) {
        if (medium != null) {
            return (MediaCollector)medium.tags().get(313463552);
        }
        return EMPTY;
    }

    public boolean check() {
        return this != null && this != EMPTY && (this.isDisconnectable() || this.getMedium().getCurrentState().getErrorType() == 0 && this.isMediaPlayable());
    }

    public int getAslDeviceID() {
        return this.mParentDevice.getAslDeviceID();
    }

    public int getObjectId() {
        return this.getAslDeviceID() | this.getSlotNumber() + 1 << 16;
    }

    public DeviceCollector getParentDevice() {
        return this.mParentDevice;
    }

    public boolean isMediaActive() {
        return this.mediaActive;
    }

    void setMediaActive(boolean bl) {
        this.mediaActive = bl;
    }

    public int getSlotNumber() {
        return this.medium.getPartitionIndex();
    }

    public void makeMainPartition() {
        this.getParentDevice().setMainPartition(this);
    }

    public boolean supportsRawMode() {
        if (this.getMediaCaps() != null) {
            return this.getMediaCaps().rawBrowser && !this.isHDD();
        }
        switch (this.mParentDevice.getDeviceType()) {
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 13: {
                return this.isOpticalMedia();
            }
            case 1: 
            case 2: 
            case 9: 
            case 12: {
                return true;
            }
        }
        return false;
    }

    public boolean supportsContentMode() {
        if (this.getMediaCaps() != null) {
            return this.getMediaCaps().contentBrowser;
        }
        switch (this.mParentDevice.getDeviceType()) {
            case 0: 
            case 1: 
            case 12: {
                return true;
            }
            case 2: {
                return !this.isIPod();
            }
        }
        return false;
    }

    public boolean supportsPlaySimilar() {
        return this.supportsContentMode();
    }

    public boolean supportsVideo() {
        return this.getMediaCaps() != null && this.getMediaCaps().videoSupport;
    }

    public boolean supports(int n) {
        switch (n) {
            case 0: {
                return this.supportsRawMode();
            }
            case 1: {
                return this.supportsContentMode();
            }
        }
        return false;
    }

    public boolean supportsBrowsing() {
        return (this.supportsRawMode() || this.supportsContentMode()) && this.isMediaBrowsable();
    }

    public boolean supportsRawAndContentMode() {
        return this.supportsRawMode() && this.supportsContentMode();
    }

    public boolean supportsContentModeOnly() {
        return !this.supportsRawMode() && this.supportsContentMode();
    }

    public boolean supportsRawModeOnly() {
        return this.supportsRawMode() && !this.supportsContentMode();
    }

    public boolean isMediaBrowsable() {
        return this.isMediaPlayable();
    }

    public boolean hasPlaymodeSupportInBrowser() {
        return !this.isBT() && !this.isIPod() && (!this.isWLAN() || ServiceManager.configManagerDiag.isFeatureFlagSet(378));
    }

    public boolean isRawModeReadyToUse(boolean bl) {
        int n = IMediaConstants.ESO && bl ? 256 : 0;
        return this.isFlagSet(n);
    }

    public boolean isContentModeReadyToUse(boolean bl) {
        int n = bl ? 1024 : 512;
        return this.isFlagSet(n);
    }

    public boolean isPlaySimilarReadyToUse() {
        int n = 2048;
        return this.isFlagSet(2048);
    }

    public boolean isLastPlaySelectionValid() {
        return this.isFlagSet(16384);
    }

    public boolean isFlagSet(int n) {
        return Util.isBitSet(n, this.getMedium().getCurrentInfo().getFlags());
    }

    public boolean isFlagSet(int n, boolean bl) {
        return this.isFlagSet(n) && (!bl || !Util.isBitSet(n, this.getMedium().getPreviousInfo().getFlags()));
    }

    public boolean isFlagNotSet(int n, boolean bl) {
        return !this.isFlagSet(n) && (!bl || Util.isBitSet(n, this.getMedium().getPreviousInfo().getFlags()));
    }

    public boolean hasPlaymodeSupport() {
        if (this.getMediaCaps() != null) {
            return this.getMediaCaps().isPlaybackModes();
        }
        switch (this.mParentDevice.getDeviceType()) {
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 13: {
                return this.getMediaType() == 1 || this.getMediaType() == 5 || this.getMediaType() == 6;
            }
            case 0: 
            case 1: 
            case 2: 
            case 9: 
            case 12: {
                return true;
            }
        }
        return false;
    }

    public boolean isUserAvailable() {
        return this.medium.getCurrentState().isUserAvailable();
    }

    public boolean isMediaPlayable() {
        return this != EMPTY && this.medium.getCurrentState().isPlayable();
    }

    public boolean isDisconnectable() {
        return this.mParentDevice.getDevice().isDisconnectable();
    }

    public boolean isDisconnectableButNotPlayable() {
        return this.isDisconnectable() && !this.isMediaPlayable();
    }

    public boolean isOpticalMediaPlaybackToBeBlocked() {
        return this.isImportRunning() && this.isOpticalMedia() && !this.isCDDA();
    }

    public boolean isImportRunning() {
        return this.isFlagSet(16);
    }

    public boolean isImportPossible() {
        if (this.isMediaBrowsable() && !this.isImportRunning()) {
            return !Util.isAnyBitSet(5121, this.getFlags()) && !this.isDVDVideoAudio() && !this.isIPod() && !this.isMTP();
        }
        return false;
    }

    public boolean isDeleteRunning() {
        return this.isFlagSet(4096);
    }

    public boolean isDeletePossible() {
        return this != EMPTY && this.medium.getCurrentState().isDeletable();
    }

    public String toStringShort() {
        if (this != EMPTY) {
            String string = Device.getDeviceTypeStr(this.mParentDevice.getDeviceType());
            String string2 = MediumState.getMediaTypeStr(this.getMediaType());
            String string3 = this.isMediaActive() ? "*" : "";
            String string4 = this.supportsRawMode() ? "RAW-SUPPORT|" : "";
            String string5 = this.supportsContentMode() ? "DB-SUPPORT|" : "";
            return new StringBuffer().append(string).append("(").append("deviceId: ").append(this.medium.getCurrentInfo().getDeviceID()).append(", mediaId: ").append(this.medium.getCurrentInfo().getMediaID()).append("):").append(string2).append(string3).append(" (").append(string4).append(string5).append(")").toString();
        }
        return "EMPTY MEDIA";
    }

    public String toString() {
        if (this != EMPTY) {
            String string = Device.getDeviceTypeStr(this.mParentDevice.getDeviceType());
            String string2 = MediumState.getMediaTypeStr(this.getMediaType());
            String string3 = MediumState.getMediaFlagsStr(this.getFlags());
            String string4 = this.isMediaActive() ? "*" : "";
            String string5 = this.isUserAvailable() ? "AVAILABLE|" : "";
            String string6 = this.isMediaPlayable() ? "PLAYABLE|" : "";
            String string7 = this.isImportPossible() ? "IMPORTABLE|" : "";
            String string8 = this.isImportPossible() ? "DELETABLE|" : "";
            String string9 = this.supportsRawMode() ? "RAW-SUPPORT|" : "";
            String string10 = this.supportsContentMode() ? "DB-SUPPORT|" : "";
            return new StringBuffer().append(string).append("(").append("deviceId: ").append(this.medium.getCurrentInfo().getDeviceID()).append(", mediaId: ").append(this.medium.getCurrentInfo().getMediaID()).append("):").append(string2).append(string4).append(" (").append(string5).append(string6).append(string7).append(string8).append(string9).append(string10).append(") - [").append(string3).append("]").toString();
        }
        return "EMPTY MEDIA";
    }

    public boolean isOpticalMedia() {
        return this.medium.getCurrentState().isOpticalMedia();
    }

    public boolean isCDDA() {
        return this.mParentDevice.getDevice().isOptical() && this.getMediaType() == 1;
    }

    public boolean isDVDAudio() {
        return this.mParentDevice.getDevice().getCurrentState().isVersatile() && this.getMediaType() == 2;
    }

    public boolean isDVDVideo() {
        return this.mParentDevice.getDevice().getCurrentState().isVersatile() && this.getMediaType() == 3;
    }

    public boolean isDVDVideoAudio() {
        return this.getMedium().getCurrentState().isDVDVideoAudio();
    }

    public boolean isDVDChanger() {
        int n = this.getParentDevice().getDeviceType();
        return n == 6;
    }

    public boolean isHDD() {
        return this.mParentDevice.getDeviceType() == 0 && this.getMediaType() == 7;
    }

    public boolean isBT() {
        return this.mParentDevice.getDeviceType() == 10;
    }

    public boolean isIPod() {
        return this.mParentDevice.getDeviceType() == 2 && this.getMediaType() == 20;
    }

    public boolean isMTP() {
        return this.mParentDevice.getDeviceType() == 2 && this.getMediaType() == 9;
    }

    public boolean isUSB() {
        return this.mParentDevice.getDeviceType() == 2 && this.getMediaType() == 7;
    }

    public boolean isAUX() {
        return this.getParentDevice().getDeviceType() == 8;
    }

    public boolean isWLAN() {
        return this.getParentDevice().getDeviceType() == 9;
    }

    public boolean storesOwnPlaybackState() {
        return this.isBT() || this.isIPod();
    }

    public boolean isDatabaseFullReported() {
        return SourceHandlingPersistence.getInstance().getDatabaseFullReported(this.getObjectId());
    }

    public void setDatabaseFullReported(boolean bl) {
        SourceHandlingPersistence.getInstance().setDatabaseFullReported(this.getObjectId(), bl);
    }

    public boolean isVirgin() {
        return SourceHandlingPersistence.getInstance().isVirgin(this);
    }

    public void clearVirginity() {
        SourceHandlingPersistence.getInstance().markDeflowered(this);
    }

    public Capabilities getPlayerCapabilities() {
        return this.playerCapabilities;
    }

    public void setPlayerCapabilities(Capabilities capabilities) {
        this.playerCapabilities = capabilities;
    }

    public static Source createSourceState(Medium medium) {
        return MediaCollector.createSourceState(medium, medium.getCurrentState());
    }

    public static Source createSourceState(Medium medium, MediumState mediumState) {
        int n;
        int n2;
        int n3 = mediumState.getObservedStatus();
        boolean bl = (mediumState.getInfo().flags & 0x200) != 0;
        boolean bl2 = mediumState.isPlayable();
        MediaCollector mediaCollector = MediaCollector.get(medium);
        int n4 = mediaCollector.supportsContentMode() ? (mediaCollector.isContentModeReadyToUse(false) ? 3 : 2) : (n2 = 1);
        int n5 = mediaCollector.supportsRawMode() ? (mediaCollector.isRawModeReadyToUse(true) ? 3 : 2) : (n = 1);
        int n6 = mediaCollector.supportsPlaySimilar() ? (mediaCollector.isPlaySimilarReadyToUse() ? 3 : 2) : 1;
        return new CurrentMediaSource(medium.getParent().getSourceId(), mediumState.getInfo().getMountPoint(), n3, bl, mediumState.isMediaInSlot(), n2, n, n6, mediaCollector.isUserAvailable(), bl2);
    }

    public void setImportedTo(boolean bl) {
        if (this.isHDD()) {
            this.mImportedTo = bl;
        }
    }

    public boolean isImportedTo() {
        return this.mImportedTo;
    }

    static {
        UNDEFINED = EMPTY = new MediaCollector(DeviceCollector.EMPTY);
    }
}

