/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.audiotilel;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.audiotilel.AudioTileLAdapter$1;
import de.vw.mib.appadapter.audiotilel.AudioTileLAdapter$2;
import de.vw.mib.appadapter.audiotilel.AudioTileLEntertainmentButtonCioListener;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerUpdates;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioCreator;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import generated.de.vw.mib.appadapter.audiotilel.EntertainmentButtonsModelApiCallback;

public class AudioTileLAdapter
extends AbstractAppAdapter
implements CioExecutor,
EntertainmentManagerUpdates {
    private static final int REGISTRATION_INDEX_MEDIA;
    private static final int REGISTRATION_INDEX_TUNER;
    private static final int REGISTRATION_INDEX_TV;
    private static final int REGISTER_ENTERTAINMENT_TILE;
    private static final int AUDIO_TILE_HEADER_BUTTON_ACTION;
    private final IntObjectMap showInternalTileCios = new IntObjectOptHashMap();
    private final IntObjectMap internalTileHeaderActionCios = new IntObjectOptHashMap();
    private final IntObjectMap entertainmenButtonCios = new IntObjectOptHashMap();
    private ContentInformationObject currentHeaderCio = null;
    private AudioTileLEntertainmentButtonCioListener entertainmentButtonListener = null;
    private EntertainmentButtonsModelApiCallback callback;
    private static final String APP_NAME;
    private String appInstanceName;
    private int currentContext = -1;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$audiotilel$EntertainmentButtonsModelApiCallback;

    public AudioTileLAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = AudioTileLAdapter.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService, new AudioTileLAdapter$1(this));
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{new AudioTileLAdapter$2(this)};
    }

    @Override
    public void init(int n, String string) {
        this.appInstanceName = string;
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
        this.callback = (EntertainmentButtonsModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$audiotilel$EntertainmentButtonsModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$audiotilel$EntertainmentButtonsModelApiCallback = AudioTileLAdapter.class$("generated.de.vw.mib.appadapter.audiotilel.EntertainmentButtonsModelApiCallback")) : class$generated$de$vw$mib$appadapter$audiotilel$EntertainmentButtonsModelApiCallback);
        CioIntent[] cioIntentArray = this.systemServices.getCioDictionary().getCioIntents("EntertainmentTileSourceVisualization");
        this.storeEntertainmentButtonCios(cioIntentArray);
        this.entertainmentButtonListener = new AudioTileLEntertainmentButtonCioListener(this);
        this.systemServices.getCioDictionary().addCioRegistrationListener("EntertainmentTileSourceVisualization", this.entertainmentButtonListener);
    }

    private void storeEntertainmentButtonCios(CioIntent[] cioIntentArray) {
        if (cioIntentArray == null) {
            return;
        }
        for (int i2 = 0; i2 < cioIntentArray.length; ++i2) {
            CioIntent cioIntent = cioIntentArray[i2];
            int n = this.getButtonIndex(cioIntent);
            if (n == -1) continue;
            this.entertainmenButtonCios.put(n, cioIntent);
            this.entertainmentButtonListener.increaseRegistrationCount(n);
            this.updateModelProperty(cioIntent);
            this.systemServices.createLogger(128).warn(128).append("Added entertainment button visualization cio for usage: ").append(cioIntent.getUsage()).log();
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
                int n2 = cioActionParameters.getInt("EntertainmentContext");
                CioIntent cioIntent = cioActionParameters.getCioIntent("BindHostedApp");
                CioIntent cioIntent2 = cioActionParameters.getCioIntent("TileHeaderButtonAction");
                this.showInternalTileCios.put(n2, cioIntent);
                this.internalTileHeaderActionCios.put(n2, cioIntent2);
                this.updateHeadlineVisualization(n2);
                break;
            }
            case 2: {
                CioIntent cioIntent = (CioIntent)this.internalTileHeaderActionCios.get(this.currentContext);
                if (cioIntent == null) break;
                this.systemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    private void updateHeadlineVisualization(int n) {
        if (this.currentContext == n) {
            this.updateTileHeaderCio(n);
        }
    }

    private void updateTileHeaderCio(int n) {
        CioIntent cioIntent;
        if (this.currentHeaderCio != null) {
            this.currentHeaderCio.unregister();
        }
        if ((cioIntent = (CioIntent)this.internalTileHeaderActionCios.get(n)) != null) {
            CioCreator cioCreator = this.systemServices.getCioFactory().createForwardingCio("AudioTileL", this.appInstanceName, cioIntent);
            this.currentHeaderCio = cioCreator.register("TileHeaderButtonAction", this);
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        String string = contentInformationObject.getCioIntentName();
        if (string.equals("TunerTileHeaderVisualization")) {
            return true;
        }
        return string.equals("MediaTileHeaderVisualization");
    }

    @Override
    public void onUpdateBand(int n) {
    }

    private void showEntertainmentTile(int n) {
        if (this.currentContext == n) {
            return;
        }
        this.currentContext = n;
        CioIntent cioIntent = (CioIntent)this.showInternalTileCios.get(n);
        if (cioIntent == null) {
            this.systemServices.createLogger(128).warn(128).append("Unhandled context: ").append(n).log();
            return;
        }
        if (this.currentHeaderCio != null) {
            this.currentHeaderCio.unregister();
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setString("hostAppName", "AudioTileL");
        cioParametersCreator.setString("hostAppInstanceName", "AudioTileL");
        cioParametersCreator.setString("hostAppScreenArea", "ScreenArea");
        cioParametersCreator.setString("hostedAppLayerLabel", "Main");
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
        this.updateTileHeaderCio(n);
    }

    @Override
    public void onUpdateEntertainmentSource(int n, int n2) {
        this.showEntertainmentTile(n);
    }

    public void updateEntertainmentCio(CioIntent cioIntent, int n) {
        this.systemServices.createLogger(128).warn(128).append("Update entertainment button visualization cio for usage: ").append(cioIntent == null ? "null" : cioIntent.getUsage()).append(" with ID: ").append(cioIntent == null ? -1L : cioIntent.getCioIntentId()).log();
        this.entertainmenButtonCios.put(n, cioIntent);
        if (cioIntent == null) {
            this.clearModelProperty(n);
        } else {
            this.updateModelProperty(cioIntent);
        }
    }

    private void clearModelProperty(int n) {
        switch (n) {
            case 0: {
                this.callback._update_getMediaButtonInformation(-1L);
                break;
            }
            case 1: {
                this.callback._update_getTunerButtonInformation(-1L);
                break;
            }
            case 2: {
                this.callback._update_getTvTunerButtonInformation(-1L);
                break;
            }
        }
    }

    public int getButtonIndex(CioIntent cioIntent) {
        if (cioIntent.getUsage().equals("Media")) {
            return 0;
        }
        if (cioIntent.getUsage().equals("Tuner")) {
            return 1;
        }
        if (cioIntent.getUsage().equals("TvTuner")) {
            return 2;
        }
        return -1;
    }

    private void updateModelProperty(CioIntent cioIntent) {
        int n = this.getButtonIndex(cioIntent);
        switch (n) {
            case 0: {
                this.callback._update_getMediaButtonInformation(cioIntent.getCioIntentId());
                break;
            }
            case 1: {
                this.callback._update_getTunerButtonInformation(cioIntent.getCioIntentId());
                break;
            }
            case 2: {
                this.callback._update_getTvTunerButtonInformation(cioIntent.getCioIntentId());
                break;
            }
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

    static /* synthetic */ IntObjectMap access$000(AudioTileLAdapter audioTileLAdapter) {
        return audioTileLAdapter.entertainmenButtonCios;
    }

    static /* synthetic */ AppAdapterSystemServices access$100(AudioTileLAdapter audioTileLAdapter) {
        return audioTileLAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$200(AudioTileLAdapter audioTileLAdapter) {
        return audioTileLAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$300(AudioTileLAdapter audioTileLAdapter) {
        return audioTileLAdapter.systemServices;
    }
}

