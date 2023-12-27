/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.audiotiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.audiotiles.AudioTileSAdapter$1;
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

public class AudioTileSAdapter
extends AbstractAppAdapter
implements CioExecutor,
EntertainmentManagerUpdates {
    private static final int REGISTER_ENTERTAINMENT_TILE;
    private static final int AUDIO_TILE_HEADER_BUTTON_ACTION;
    private final IntObjectMap showInteralTileCios = new IntObjectOptHashMap();
    private final IntObjectMap internalTileHeaderActionCios = new IntObjectOptHashMap();
    private ContentInformationObject currentHeaderCio = null;
    private static final String APP_NAME;
    private String appInstanceName;
    private int currentContext = -1;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService;

    public AudioTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService == null ? (class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService = AudioTileSAdapter.class$("de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerService")) : class$de$vw$mib$asl$framework$api$entertainmentmanager$EntertainmentManagerService, new AudioTileSAdapter$1(this));
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[0];
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
                this.showInteralTileCios.put(n2, cioIntent);
                this.internalTileHeaderActionCios.put(n2, cioIntent2);
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
        CioIntent cioIntent = (CioIntent)this.showInteralTileCios.get(n);
        if (cioIntent == null) {
            this.systemServices.createLogger(128).warn(128).append("Unhandled context: ").append(n).log();
            return;
        }
        if (this.currentHeaderCio != null) {
            this.currentHeaderCio.unregister();
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setString("hostAppName", "AudioTileS");
        cioParametersCreator.setString("hostAppInstanceName", "AudioTileS");
        cioParametersCreator.setString("hostAppScreenArea", "ScreenArea");
        cioParametersCreator.setString("hostedAppLayerLabel", "Main");
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
        CioIntent cioIntent2 = (CioIntent)this.internalTileHeaderActionCios.get(n);
        if (cioIntent2 != null) {
            CioCreator cioCreator = this.systemServices.getCioFactory().createForwardingCio("AudioTileS", this.appInstanceName, cioIntent2);
            this.currentHeaderCio = cioCreator.register("TileHeaderButtonAction", this);
        }
    }

    @Override
    public void onUpdateEntertainmentSource(int n, int n2) {
        this.showEntertainmentTile(n);
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

