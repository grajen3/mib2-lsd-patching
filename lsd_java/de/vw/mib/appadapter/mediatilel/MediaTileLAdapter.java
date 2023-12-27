/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.mediatilel;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.mediatilel.MediaTileLAdapter$1;
import de.vw.mib.appadapter.mediatilel.MediaTileLAdapter$2;
import de.vw.mib.appadapter.mediatilel.MediaTileLAdapter$3;
import de.vw.mib.appadapter.mediatilel.MediaTileLAdapter$4;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.api.media.services.SourceCallback;
import de.vw.mib.asl.api.media.services.player.MediaPlayerService;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceListener;
import de.vw.mib.asl.api.media.services.sources.medialist.MediaListListener;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import generated.de.vw.mib.appadapter.mediatilel.GeneralModelApiCallback;
import java.util.Iterator;
import java.util.List;

public class MediaTileLAdapter
extends AbstractAppAdapter
implements CioExecutor,
CurrentMediaSourceListener,
MediaListListener,
SourceCallback {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private static final int MEDIA_TILE_L_ENTERTAINMENT_BUTTON;
    private static final String MEDIA_TILE_L_BUTTON_AUX;
    private static final String MEDIA_TILE_L_BUTTON_BTA;
    private static final String MEDIA_TILE_L_BUTTON_DVD_CHANGER;
    private static final String MEDIA_TILE_L_BUTTON_CD_INTERNAL;
    private static final String MEDIA_TILE_L_BUTTON_JUKEBOX;
    private static final String MEDIA_TILE_L_BUTTON_SD_CARD;
    private static final String MEDIA_TILE_L_BUTTON_SD_CARD_1;
    private static final String MEDIA_TILE_L_BUTTON_SD_CARD_2;
    private static final String MEDIA_TILE_L_BUTTON_USB;
    private static final String MEDIA_TILE_L_BUTTON_USB_1;
    private static final String MEDIA_TILE_L_BUTTON_USB_2;
    private static final String MEDIA_TILE_L_BUTTON_USB_3;
    private static final String MEDIA_TILE_L_BUTTON_USB_4;
    private static final String MEDIA_TILE_L_BUTTON_WLAN;
    private static final String MEDIA_TILE_L_HEADLINE_AUX;
    private static final String MEDIA_TILE_L_HEADLINE_BTA;
    private static final String MEDIA_TILE_L_HEADLINE_DVD_CHANGER;
    private static final String MEDIA_TILE_L_HEADLINE_CD_INTERNAL;
    private static final String MEDIA_TILE_L_HEADLINE_JUKEBOX;
    private static final String MEDIA_TILE_L_HEADLINE_SD_CARD;
    private static final String MEDIA_TILE_L_HEADLINE_SD_CARD_1;
    private static final String MEDIA_TILE_L_HEADLINE_SD_CARD_2;
    private static final String MEDIA_TILE_L_HEADLINE_USB;
    private static final String MEDIA_TILE_L_HEADLINE_USB_1;
    private static final String MEDIA_TILE_L_HEADLINE_USB_2;
    private static final String MEDIA_TILE_L_HEADLINE_USB_3;
    private static final String MEDIA_TILE_L_HEADLINE_USB_4;
    private static final String MEDIA_TILE_L_HEADLINE_WLAN;
    private CioIntent bindHostedApp;
    private MediaPlayerService mediaPlayerService;
    private final ObjectObjectOptHashMap MEDIA_SOURCE_BUTTON_CIOS = new ObjectObjectOptHashMap(8);
    private final ObjectObjectOptHashMap DELAYED_MEDIA_SOURCE_BUTTON_CIOS = new ObjectObjectOptHashMap(8);
    private final ObjectObjectOptHashMap MEDIA_SOURCE_HEADLINE_CIOS = new ObjectObjectOptHashMap(8);
    private final ObjectObjectOptHashMap DELAYED_MEDIA_SOURCE_HEADLINE_CIOS = new ObjectObjectOptHashMap(8);
    private List mediaSources;
    private Source currentMediaSource;
    private Source currentlyDisplayedNextMediaSource = null;
    private GeneralModelApiCallback callback;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$player$MediaPlayerService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$mediatilel$GeneralModelApiCallback;

    public MediaTileLAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService == null ? (class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService = MediaTileLAdapter.class$("de.vw.mib.asl.api.media.services.sources.medialist.MediaListService")) : class$de$vw$mib$asl$api$media$services$sources$medialist$MediaListService, new MediaTileLAdapter$1(this));
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService == null ? (class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService = MediaTileLAdapter.class$("de.vw.mib.asl.api.media.services.sources.current.CurrentMediaSourceService")) : class$de$vw$mib$asl$api$media$services$sources$current$CurrentMediaSourceService, new MediaTileLAdapter$2(this));
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$media$services$player$MediaPlayerService == null ? (class$de$vw$mib$asl$api$media$services$player$MediaPlayerService = MediaTileLAdapter.class$("de.vw.mib.asl.api.media.services.player.MediaPlayerService")) : class$de$vw$mib$asl$api$media$services$player$MediaPlayerService, new MediaTileLAdapter$3(this));
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{new MediaTileLAdapter$4(this)};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
        this.callback = (GeneralModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$mediatilel$GeneralModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$mediatilel$GeneralModelApiCallback = MediaTileLAdapter.class$("generated.de.vw.mib.appadapter.mediatilel.GeneralModelApiCallback")) : class$generated$de$vw$mib$appadapter$mediatilel$GeneralModelApiCallback);
    }

    private void registerEntertainmentTile(CioIntent cioIntent) {
        CioIntent cioIntent2 = this.systemServices.getCioDictionary().getCioIntent("RegisterEntertainmentTile", "BigTile");
        if (cioIntent2 != null) {
            CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent2);
            cioParametersCreator.setInt("EntertainmentContext", 2);
            cioParametersCreator.setCioIntent("BindHostedApp", this.bindHostedApp);
            cioParametersCreator.setCioIntent("TileHeaderButtonAction", cioIntent);
            CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
            this.systemServices.getCioDispatcher().dispatch(cioIntent2, cioActionParameters);
        }
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_MEDIA");
                this.systemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
            case 2: {
                String string = contentInformationObject.getCioIntentName();
                if ("MediaTileLButton_Aux".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(8, -1), this);
                    break;
                }
                if ("MediaTileLButton_BtAudio".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(10, -1), this);
                    break;
                }
                if ("MediaTileLButton_CdInternal".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(3, -1), this);
                    break;
                }
                if ("MediaTileLButton_DvdChanger".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(6, -1), this);
                    break;
                }
                if ("MediaTileLButton_Jukebox".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(0, -1), this);
                    break;
                }
                if ("MediaTileLButton_SdCard".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(1, -1), this);
                    break;
                }
                if ("MediaTileLButton_SdCard_1".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(1, 0), this);
                    break;
                }
                if ("MediaTileLButton_SdCard_2".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(1, 1), this);
                    break;
                }
                if ("MediaTileLButton_Usb".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(2, -1), this);
                    break;
                }
                if ("MediaTileLButton_Usb_1".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(2, 0), this);
                    break;
                }
                if ("MediaTileLButton_Usb_2".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(2, 1), this);
                    break;
                }
                if ("MediaTileLButton_Usb_3".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(2, 2), this);
                    break;
                }
                if ("MediaTileLButton_Usb_4".equals(string)) {
                    this.mediaPlayerService.activateMediaSource(this.findSourceId(2, 3), this);
                    break;
                }
                if (!"MediaTileLButton_Wlan".equals(string)) break;
                this.mediaPlayerService.activateMediaSource(this.findSourceId(9, -1), this);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if ("BindMediaTileL".equals(contentInformationObject.getCioIntentName())) {
            this.bindHostedApp = (CioIntent)((Object)contentInformationObject);
        } else if ("MediaTileLHeaderButtonAction_Aux".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(8, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_BtAudio".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(10, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_CdInternal".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(3, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_DvdChanger".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(6, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_Jukebox".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(0, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_SdCard".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(1, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_SdCard_1".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(1, 0, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_SdCard_2".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(1, 1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_Usb".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_Usb_1".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 0, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_Usb_2".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_Usb_3".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 2, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_Usb_4".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 3, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLHeaderButtonAction_Wlan".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(9, -1, contentInformationObject, this.MEDIA_SOURCE_HEADLINE_CIOS, this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
        } else if ("MediaTileLButton_Aux".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(8, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_BtAudio".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(10, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_CdInternal".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(3, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_DvdChanger".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(6, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_Jukebox".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(0, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_SdCard".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(1, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_SdCard_1".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(1, 0, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_SdCard_2".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(1, 1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_Usb".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_Usb_1".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 0, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_Usb_2".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_Usb_3".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 2, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_Usb_4".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(2, 3, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        } else if ("MediaTileLButton_Wlan".equals(contentInformationObject.getCioIntentName())) {
            this.handleCioRegistration(9, -1, contentInformationObject, this.MEDIA_SOURCE_BUTTON_CIOS, this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        }
        return true;
    }

    private void handleCioRegistration(int n, int n2, ContentInformationObject contentInformationObject, ObjectObjectOptHashMap objectObjectOptHashMap, ObjectObjectOptHashMap objectObjectOptHashMap2) {
        SourceId sourceId = this.findSourceId(n, n2);
        if (sourceId != null) {
            objectObjectOptHashMap.put(sourceId, contentInformationObject);
        } else if (!objectObjectOptHashMap2.containsKey(contentInformationObject.getCioIntentName())) {
            objectObjectOptHashMap2.put(contentInformationObject.getCioIntentName(), contentInformationObject);
        }
    }

    private SourceId findSourceId(int n, int n2) {
        if (this.mediaSources != null) {
            Iterator iterator = this.mediaSources.iterator();
            while (iterator.hasNext()) {
                Source source = (Source)iterator.next();
                if (source.getSourceId().getDeviceType() != n || n2 != -1 && source.getSourceId().getSlot() != n2) continue;
                return source.getSourceId();
            }
        }
        return null;
    }

    @Override
    public void updateCurrentMediaSource(Source source) {
        this.handleMediaSourceUpdate(source);
        this.currentMediaSource = source;
        this.registerEntertainmentTile(this.getHeadlineVisualizationCio(source));
    }

    private CioIntent getHeadlineVisualizationCio(Source source) {
        if (source != null && this.MEDIA_SOURCE_HEADLINE_CIOS.containsKey(source.getSourceId())) {
            CioIntent cioIntent = (CioIntent)this.MEDIA_SOURCE_HEADLINE_CIOS.get(source.getSourceId());
            return cioIntent;
        }
        return null;
    }

    private void handleMediaSourceUpdate(Source source) {
        Source source2 = this.findNextPlayableSource(source);
        if (source2 != null) {
            ContentInformationObject contentInformationObject;
            boolean bl = this.MEDIA_SOURCE_BUTTON_CIOS.containsKey(source2.getSourceId());
            if (bl && !(contentInformationObject = (ContentInformationObject)this.MEDIA_SOURCE_BUTTON_CIOS.get(source2.getSourceId())).isRegistered()) {
                contentInformationObject.register();
            }
            if (this.currentlyDisplayedNextMediaSource != null && this.MEDIA_SOURCE_BUTTON_CIOS.containsKey(this.currentlyDisplayedNextMediaSource.getSourceId()) && !SourceId.isEqual(this.currentlyDisplayedNextMediaSource.getSourceId(), source2.getSourceId()) && (contentInformationObject = (ContentInformationObject)this.MEDIA_SOURCE_BUTTON_CIOS.get(this.currentlyDisplayedNextMediaSource.getSourceId())).isRegistered()) {
                contentInformationObject.unregister();
            }
            if (bl) {
                this.currentlyDisplayedNextMediaSource = source2;
            }
        }
    }

    private Source findNextPlayableSource(Source source) {
        Object object;
        int n = 0;
        boolean bl = false;
        if (source != null && this.mediaSources != null) {
            object = this.mediaSources.iterator();
            while (object.hasNext() && !bl) {
                Source source2 = (Source)object.next();
                if (SourceId.isEqual(source.getSourceId(), source2.getSourceId())) {
                    bl = true;
                }
                ++n;
            }
        } else {
            n = 0;
        }
        object = this.currentMediaSource;
        if (this.mediaSources != null && (source == null || source.getSourceId().getDeviceType() != -1)) {
            int n2 = n % (this.mediaSources.size() - 1);
            do {
                Source source3;
                if ((source3 = (Source)this.mediaSources.get(n2)).isPlayable()) {
                    object = source3;
                    break;
                }
                ++n2;
            } while ((n2 %= this.mediaSources.size() - 1) != n);
        }
        return object;
    }

    @Override
    public void updateSources(List list) {
        this.mediaSources = list;
        this.updateAvailableSourcesCios(this.DELAYED_MEDIA_SOURCE_BUTTON_CIOS);
        this.handleMediaSourceUpdate(this.currentMediaSource);
        this.updateAvailableSourcesCios(this.DELAYED_MEDIA_SOURCE_HEADLINE_CIOS);
    }

    private void updateAvailableSourcesCios(ObjectObjectOptHashMap objectObjectOptHashMap) {
        Iterator iterator = objectObjectOptHashMap.valueIterator();
        while (iterator.hasNext()) {
            this.onCioIntentRegistration((ContentInformationObject)iterator.next());
        }
        objectObjectOptHashMap.clear();
    }

    @Override
    public void response(ResultCode resultCode, Source source) {
        if (resultCode == ResultCode.NOK) {
            this.systemServices.createLogger(128).warn(128).append("Could not execute MEDIA_TILE_L_ENTERTAINMENT_BUTTON! Source: ").append(source.getSourceId()).log();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ MediaPlayerService access$002(MediaTileLAdapter mediaTileLAdapter, MediaPlayerService mediaPlayerService) {
        mediaTileLAdapter.mediaPlayerService = mediaPlayerService;
        return mediaTileLAdapter.mediaPlayerService;
    }
}

