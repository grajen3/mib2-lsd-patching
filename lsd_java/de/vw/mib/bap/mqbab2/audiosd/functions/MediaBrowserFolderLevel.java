/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowser;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaBrowsedFolder;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectId;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_FolderLevel_Status;

public class MediaBrowserFolderLevel
extends Function
implements Property,
ASLAudioSDConstants,
SoundServiceListener,
MediaServiceListener {
    private static final int BAP_MEDIA_BROWSER_UNKNOWN_PARENT_FOLDER_ABS_POS;
    private static final int BAP_MEDIA_BROWSER_UNKNOWN_PARENT_FOLDER_REF_POS;
    private static final int BAP_MEDIA_BROWSER_UNKNOWN_FOLDER_LEVEL;
    private FsgArrayListWindowed currentMediaBrowserList;
    private boolean _mediaBrowserActiveComponent;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] MEDIA_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_FolderLevel_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        return this.computeMediaBrowserFolderLevelStatus();
    }

    protected MediaBrowser_FolderLevel_Status dequeueBAPEntity() {
        return (MediaBrowser_FolderLevel_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_FolderLevel_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_FolderLevel_Status = MediaBrowserFolderLevel.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_FolderLevel_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaBrowser_FolderLevel_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 36: {
                this.setCurrentMediaBrowserArrayList((FsgArrayListWindowed)object);
                break;
            }
            case 38: {
                this.setMediaBrowserActiveComponent((Boolean)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 35;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeMediaBrowserFolderLevelStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    private boolean isMediaBrowserActive() {
        return this.getSoundService().getCurrentAudioComponent() == 2 || this.getMediaBrowserActiveComponent();
    }

    private MediaBrowser_FolderLevel_Status computeMediaBrowserFolderLevelStatus() {
        MediaBrowser_FolderLevel_Status mediaBrowser_FolderLevel_Status = this.dequeueBAPEntity();
        if (this.isMediaBrowserActive()) {
            mediaBrowser_FolderLevel_Status.folderLevel = this.getBapMediaBrowserFolderLevel();
            mediaBrowser_FolderLevel_Status.ref_MediaBrowser = this.getBapMediaBrowserParentFolderRefId();
            mediaBrowser_FolderLevel_Status.ref_MediaBrowser_absolutePosition = this.getBapMediaBrowserParentFolderAbsolutePos();
        } else {
            mediaBrowser_FolderLevel_Status.folderLevel = 0;
            mediaBrowser_FolderLevel_Status.ref_MediaBrowser = 0;
            mediaBrowser_FolderLevel_Status.ref_MediaBrowser_absolutePosition = 0;
        }
        return mediaBrowser_FolderLevel_Status;
    }

    private int getBapMediaBrowserFolderLevel() {
        int n = this.getMediaService().getCurrentlyBrowsedFolder().getBrowsedFolderLevel();
        return n != -1 ? n : 0;
    }

    private int getBapMediaBrowserParentFolderAbsolutePos() {
        return 0;
    }

    private int getBapMediaBrowserParentFolderRefId() {
        int n;
        if (this.currentMediaBrowserList != null) {
            MediaService mediaService = this.getMediaService();
            MediaBrowsedFolder mediaBrowsedFolder = mediaService.getCurrentlyBrowsedFolder();
            FsgArrayObjectId fsgArrayObjectId = MediaBrowser.createObjectID(mediaBrowsedFolder.getBrowsedFolderEntryId(), mediaService.getBapContentTypeForBrowsedFolder(mediaBrowsedFolder.getBrowsedFolderContentType()));
            n = this.currentMediaBrowserList.getBapPosIdOrGenerate(fsgArrayObjectId);
            if (n == 0) {
                n = 0;
            }
        } else {
            n = 0;
        }
        return n;
    }

    protected void setCurrentMediaBrowserArrayList(FsgArrayListWindowed fsgArrayListWindowed) {
        this.currentMediaBrowserList = fsgArrayListWindowed;
        this.process(-1);
    }

    protected void setMediaBrowserActiveComponent(Boolean bl) {
        boolean bl2 = bl;
        if (this._mediaBrowserActiveComponent != bl2) {
            this._mediaBrowserActiveComponent = bl2;
            this.process(-1);
        }
    }

    private boolean getMediaBrowserActiveComponent() {
        return this._mediaBrowserActiveComponent;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateMediaData(MediaService mediaService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SOUND_LISTENER_IDS = new int[]{1470};
        MEDIA_LISTENER_IDS = new int[]{3831};
    }
}

