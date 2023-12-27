/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.tunertilel;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.AppAdapterTunerTileLCallback;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;

public class TunerTileLAdapter
extends AbstractAppAdapter
implements CioExecutor,
AppAdapterTunerTileLCallback {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private static final int TUNER_TILE_L_ENTERTAINMENT_BUTTON_ACTION_ID;
    private CioIntent bindHostedApp;
    private CioIntent tileHeaderAction;
    private ContentInformationObject buttonAm;
    private ContentInformationObject buttonFm;
    private ContentInformationObject buttonDab;
    private ContentInformationObject buttonUnifiedRadio;
    private ContentInformationObject buttonWebRadio;
    private static final String INTENT_NAME_TUNER_TILE_L_BUTTON_AM;
    private static final String INTENT_NAME_TUNER_TILE_L_BUTTON_FM;
    private static final String INTENT_NAME_TUNER_TILE_L_BUTTON_DAB;
    private static final String INTENT_NAME_TUNER_TILE_L_BUTTON_UNIFIED_RADIO;
    private static final String INTENT_NAME_TUNER_TILE_L_BUTTON_WEB_RADIO;
    private ASLRadioAPI aslRadioApi = ASLRadioFactory.getRadioApi();
    private static final int RADIO_WAVEBAND_AM;
    private static final int RADIO_WAVEBAND_FM;
    private static final int RADIO_WAVEBAND_DAB;
    private static final int RADIO_WAVEBAND_UNIFIED_RADIO;
    private static final int RADIO_WAVEBAND_WEB_RADIO;

    public TunerTileLAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        if (null != this.aslRadioApi) {
            this.aslRadioApi.setAppAdapterTunerTileLCallbackInstance(this);
        }
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
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("RegisterEntertainmentTile", "BigTile");
        if (cioIntent == null) {
            return;
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setInt("EntertainmentContext", 1);
        cioParametersCreator.setCioIntent("BindHostedApp", this.bindHostedApp);
        cioParametersCreator.setCioIntent("TileHeaderButtonAction", this.tileHeaderAction);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_RADIO");
                this.systemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
            case 2: {
                String string = contentInformationObject.getCioIntentName();
                if (null == this.aslRadioApi || null == string) break;
                if ("TunerTileLButton_AM".equals(string)) {
                    this.aslRadioApi.activateWaveband(0);
                    break;
                }
                if ("TunerTileLButton_FM".equals(string)) {
                    this.aslRadioApi.activateWaveband(1);
                    break;
                }
                if ("TunerTileLButton_DAB".equals(string)) {
                    this.aslRadioApi.activateWaveband(2);
                    break;
                }
                if ("TunerTileLButton_UNIFIED_RADIO".equals(string)) {
                    this.aslRadioApi.activateWaveband(4);
                    break;
                }
                if (!"TunerTileLButton_WEB_RADIO".equals(string)) break;
                this.aslRadioApi.activateWaveband(5);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if ("BindTunerTileL".equals(contentInformationObject.getCioIntentName())) {
            this.bindHostedApp = (CioIntent)((Object)contentInformationObject);
        } else if ("TunerTileLHeaderButtonAction".equals(contentInformationObject.getCioIntentName())) {
            this.tileHeaderAction = (CioIntent)((Object)contentInformationObject);
        } else if ("TunerTileLButton_AM".equals(contentInformationObject.getCioIntentName())) {
            this.buttonAm = contentInformationObject;
        } else if ("TunerTileLButton_FM".equals(contentInformationObject.getCioIntentName())) {
            this.buttonFm = contentInformationObject;
        } else if ("TunerTileLButton_DAB".equals(contentInformationObject.getCioIntentName())) {
            this.buttonDab = contentInformationObject;
        } else if ("TunerTileLButton_UNIFIED_RADIO".equals(contentInformationObject.getCioIntentName())) {
            this.buttonUnifiedRadio = contentInformationObject;
        } else if ("TunerTileLButton_WEB_RADIO".equals(contentInformationObject.getCioIntentName())) {
            this.buttonWebRadio = contentInformationObject;
        }
        return true;
    }

    @Override
    public void setNextWaveband(int n) {
        if (null != this.buttonAm && this.buttonAm.isRegistered()) {
            this.buttonAm.unregister();
        }
        if (null != this.buttonFm && this.buttonFm.isRegistered()) {
            this.buttonFm.unregister();
        }
        if (null != this.buttonDab && this.buttonDab.isRegistered()) {
            this.buttonDab.unregister();
        }
        if (null != this.buttonUnifiedRadio && this.buttonUnifiedRadio.isRegistered()) {
            this.buttonUnifiedRadio.unregister();
        }
        if (null != this.buttonWebRadio && this.buttonWebRadio.isRegistered()) {
            this.buttonWebRadio.unregister();
        }
        switch (n) {
            case 0: {
                if (null == this.buttonAm || this.buttonAm.isRegistered()) break;
                this.buttonAm.register();
                break;
            }
            case 1: {
                if (null == this.buttonFm || this.buttonFm.isRegistered()) break;
                this.buttonFm.register();
                break;
            }
            case 2: {
                if (null == this.buttonDab || this.buttonDab.isRegistered()) break;
                this.buttonDab.register();
                break;
            }
            case 4: {
                if (null == this.buttonUnifiedRadio || this.buttonUnifiedRadio.isRegistered()) break;
                this.buttonUnifiedRadio.register();
                break;
            }
            case 5: {
                if (null == this.buttonWebRadio || this.buttonWebRadio.isRegistered()) break;
                this.buttonWebRadio.register();
                break;
            }
        }
    }
}

