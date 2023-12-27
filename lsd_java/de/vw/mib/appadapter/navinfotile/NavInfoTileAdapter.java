/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navinfotile;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.navinfotile.ASLNavInfoTileGuidanceListener;
import de.vw.mib.appadapter.navinfotile.ASLNavInfoTilePersistenceListener;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileAPI;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileFactory;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.navinfotile.GeneralModelApiCallback;
import generated.de.vw.mib.appadapter.navinfotile.GeneralModelApiService;

public class NavInfoTileAdapter
extends AbstractAppAdapter
implements GeneralModelApiService,
CioExecutor {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private static final String ENTRY_MODE;
    private static final String NAVIGATION;
    private static final String COMPASS;
    private static final String POSITION;
    private static final String WPM;
    private static final String MANEUVER;
    private static final String PNAV;
    private static String INTENT_PARAM_VALUE;
    private int currentPage = 5;
    private static final String HEADER_BUTTON_CIO_NAME;
    private static final String HEADER_BUTTON_INTENT_COMPASS;
    private static final String HEADER_BUTTON_INTENT_POSITION;
    private static final String HEADER_BUTTON_INTENT_WPM;
    private static final String HEADER_BUTTON_INTENT_MANEUVER;
    private static final String HEADER_BUTTON_INTENT_PNAV;
    private static final String HEADER_BUTTON_INTENT_NAVIGATION;
    private static final int INVALID_PERSISTED_PAGE;
    private ContentInformationObject[] headerButtons = new ContentInformationObject[6];
    private ASLNavInfoTileAPI navinfotileapi;
    private GeneralModelApiCallback getCurrentPage;
    private GeneralModelApiCallback getGuidanceState;
    private ASLNavInfoTilePersistenceListener persistenceListener;
    private ASLNavInfoTileGuidanceListener guidanceListener;
    private Logger logger;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiCallback;

    public NavInfoTileAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    void trace(String string) {
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().info(512, new StringBuffer().append("NavInfoTile-AppAdapter: ").append(string).toString());
        }
    }

    void error(String string) {
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().error(512, new StringBuffer().append("NavInfoTile-AppAdapter: ").append(string).toString());
        }
    }

    private Logger getLogger() {
        if (this.logger == null) {
            this.logger = this.systemServices.createLogger(503349248);
        }
        return this.logger;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{this};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
        this.guidanceListener = new ASLNavInfoTileGuidanceListener(this);
        this.persistenceListener = new ASLNavInfoTilePersistenceListener(this);
        this.getASLNavInfoTileAPI().registerPersistenceListener(this.persistenceListener);
        this.getASLNavInfoTileAPI().registerGuidanceListener(this.guidanceListener);
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void _mda_setCurrentPage(int n) {
        this.trace(new StringBuffer().append("_mda_setCurrentPage: ").append(n).toString());
        this.switchVisualization(n);
        this.currentPage = n;
        this.setPersistedPage(n);
    }

    public void _mda_setActualPage(int n) {
    }

    private void setPersistedPage(int n) {
        this.getASLNavInfoTileAPI().setPersistedPage(n);
    }

    @Override
    public void _mda_switchTo(int n) {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowNavView");
                switch (this.currentPage) {
                    case 0: {
                        INTENT_PARAM_VALUE = "Compass";
                        break;
                    }
                    case 1: {
                        INTENT_PARAM_VALUE = "Position";
                        break;
                    }
                    case 2: {
                        INTENT_PARAM_VALUE = "WPM";
                        break;
                    }
                    case 3: {
                        INTENT_PARAM_VALUE = "Maneuver";
                        break;
                    }
                    case 4: {
                        INTENT_PARAM_VALUE = "PNAV";
                        break;
                    }
                    default: {
                        INTENT_PARAM_VALUE = "Navigation";
                    }
                }
                CioActionParameters cioActionParameters2 = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("EntryMode", INTENT_PARAM_VALUE).finishActionParams();
                this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters2);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if (contentInformationObject.getCioName().equals("NavInfoTileHeaderButtonAction")) {
            int n = 0;
            if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonCompass")) {
                n = 0;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonPosition")) {
                n = 1;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonWPM")) {
                n = 2;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonManeuver")) {
                n = 3;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonPNAV")) {
                n = 4;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonNavigation")) {
                n = 5;
            }
            this.headerButtons[n] = contentInformationObject;
            if (n != this.currentPage) {
                return true;
            }
        }
        return false;
    }

    private void switchVisualization(int n) {
        this.trace(new StringBuffer().append("switching headline to :").append(n).toString());
        for (int i2 = 0; i2 < this.headerButtons.length; ++i2) {
            if (!this.headerButtons[i2].isRegistered()) continue;
            this.headerButtons[i2].unregister();
        }
        this.headerButtons[n].register();
    }

    private void updateModelCurrentPage(int n) {
        if (this.getCurrentPage == null) {
            this.getCurrentPage = (GeneralModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiCallback = NavInfoTileAdapter.class$("generated.de.vw.mib.appadapter.navinfotile.GeneralModelApiCallback")) : class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiCallback);
        }
        this.getCurrentPage._update_getCurrentPage(n);
    }

    private ASLNavInfoTileAPI getASLNavInfoTileAPI() {
        if (this.navinfotileapi == null) {
            this.navinfotileapi = ASLNavInfoTileFactory.getNavInfoTileApi();
        }
        return this.navinfotileapi;
    }

    void updatePageFromPersistence(int n) {
        if (n == 255) {
            this.trace("invalid page from persistence, switching to Navigation headline");
            this.switchVisualization(5);
        } else {
            this.currentPage = n;
            this.switchVisualization(n);
            this.updateModelCurrentPage(n);
        }
    }

    private void updateModelCurrentGuidanceState(int n) {
        if (this.getGuidanceState == null) {
            this.getGuidanceState = (GeneralModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiCallback = NavInfoTileAdapter.class$("generated.de.vw.mib.appadapter.navinfotile.GeneralModelApiCallback")) : class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiCallback);
        }
        this.getGuidanceState._update_getGuidanceState(n);
    }

    void updateGuidanceState(int n) {
        this.trace(new StringBuffer().append("updating guidance state to ").append(n).toString());
        this.updateModelCurrentGuidanceState(n);
    }

    @Override
    public void _mda_navInfoTileEntered() {
        this.trace(new StringBuffer().append("NavInfoTile entered - switching headline to: ").append(this.currentPage).toString());
        this.switchVisualization(this.currentPage);
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
        INTENT_PARAM_VALUE = "";
    }
}

