/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaPath_Status;

public final class MediaPath
extends Function
implements Property,
ASLAudioSDConstants,
MediaServiceListener {
    protected static final int[] MEDIA_LISTENER_IDS = new int[]{8, 3831};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaPath_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        return this.computeMediaPathStatus();
    }

    protected MediaPath_Status dequeueBAPEntity() {
        return (MediaPath_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaPath_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaPath_Status = MediaPath.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaPath_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaPath_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 37;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeMediaPathStatus(), this);
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

    private MediaPath_Status computeMediaPathStatus() {
        MediaPath_Status mediaPath_Status = this.dequeueBAPEntity();
        String string = this.getMediaService().getCurrentlyBrowsedFolder().getBrowsedFolderName();
        boolean bl = string.startsWith("filterCriteria.");
        mediaPath_Status.folder_Type = this.getBapFolderType(bl, string);
        mediaPath_Status.path.setContent(this.getBapMediaPathFolder(bl, string));
        return mediaPath_Status;
    }

    private String getBapMediaPathFolder(boolean bl, String string) {
        MediaService mediaService = this.getMediaService();
        boolean bl2 = !bl && mediaService.getCurrentlyBrowsedFolder().getBrowsedFolderLevel() == 0 && mediaService.getCurrentAudioSource() == 5;
        return bl || bl2 ? "" : string;
    }

    private int getBapFolderType(boolean bl, String string) {
        int n;
        if (bl && string.startsWith("filterCriteria.all")) {
            n = 42;
        } else if (bl && string.startsWith("filterCriteria.dynPlaylist")) {
            n = MediaPath.getBapFolderTypeForDynamicPlaylistFilterCriteria(string);
        } else {
            boolean bl2;
            boolean bl3 = bl2 = bl ? string.startsWith("filterCriteria.unknown") : false;
            boolean bl4 = bl ? !string.endsWith("s") : false;
            n = this.getBapFolderType(bl2, bl4);
        }
        return n;
    }

    private static int getBapFolderTypeForDynamicPlaylistFilterCriteria(String string) {
        int n;
        if (string.endsWith(".dynPlaylistLastPlayed")) {
            n = 52;
        } else if (string.endsWith(".dynPlaylistMostPlayed")) {
            n = 51;
        } else if (string.startsWith("filterCriteria.dynPlaylistStars")) {
            switch (string.charAt(string.length() - 1)) {
                case '0': {
                    n = 45;
                    break;
                }
                case '1': {
                    n = 46;
                    break;
                }
                case '2': {
                    n = 47;
                    break;
                }
                case '3': {
                    n = 48;
                    break;
                }
                case '4': {
                    n = 49;
                    break;
                }
                case '5': {
                    n = 50;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 0;
        }
        return n;
    }

    private int getBapFolderType(boolean bl, boolean bl2) {
        int n;
        switch (this.getMediaService().getCurrentlyBrowsedFolder().getBrowsedFolderContentType()) {
            case 1: {
                n = 1;
                break;
            }
            case 2: 
            case 3: {
                n = 4;
                break;
            }
            case 4: {
                n = 12;
                break;
            }
            case 5: {
                n = 13;
                break;
            }
            case 6: {
                n = 14;
                break;
            }
            case 7: {
                n = 54;
                break;
            }
            case 8: {
                if (bl2) {
                    n = bl ? 61 : 43;
                    break;
                }
                n = bl ? 62 : 44;
                break;
            }
            case 9: {
                if (bl2) {
                    n = bl ? 22 : 20;
                    break;
                }
                n = bl ? 23 : 21;
                break;
            }
            case 10: {
                if (bl2) {
                    n = bl ? 34 : 32;
                    break;
                }
                n = bl ? 35 : 33;
                break;
            }
            case 11: {
                if (bl2) {
                    n = bl ? 38 : 36;
                    break;
                }
                n = bl ? 39 : 37;
                break;
            }
            case 12: {
                if (bl2) {
                    n = bl ? 18 : 16;
                    break;
                }
                n = bl ? 19 : 17;
                break;
            }
            case 13: {
                if (bl2) {
                    n = bl ? 26 : 24;
                    break;
                }
                n = bl ? 27 : 25;
                break;
            }
            case 14: {
                if (bl2) {
                    n = bl ? 81 : 40;
                    break;
                }
                n = bl ? 82 : 41;
                break;
            }
            case 16: {
                n = 60;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateMediaData(MediaService mediaService, int n) {
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
}

