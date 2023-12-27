/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.drivingdatatiles;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.appadapter.drivingdatatiles.CarDrivingDataService$1;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListenerAdapter;
import de.vw.mib.asl.api.car.e_traction.EtrakServiceListener;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.drivingdatatiles.CarDrivingDataModelApiCallback;
import generated.de.vw.mib.appadapter.drivingdatatiles.CarDrivingDataModelApiService;
import java.util.ArrayList;

public class CarDrivingDataService
extends BordComputerServiceListenerAdapter
implements EtrakServiceListener,
CarDrivingDataModelApiService,
CioExecutor {
    private static final int TILE_HEADER_BUTTON_ACTION;
    private static final String HEADER_BUTTON_CIO_NAME;
    private static final String HEADER_BUTTON_INTENT_NAME1;
    private static final String HEADER_BUTTON_INTENT_NAME2;
    private static final String HEADER_BUTTON_INTENT_NAME3;
    private static final String HEADER_BUTTON_INTENT_NAME3B;
    private static final String CIO_ACTION_TILE_HEADER_BUTTON_PARAM_CAR_CONTEXT;
    private static final String CAR_DRIVING_DATA_SINCE_START;
    private static final String CAR_DRIVING_DATA_SINCE_LONGTERM;
    private static final String CAR_DRIVING_DATA_SINCE_REFUELING;
    private final ContentInformationObject[] headerButtons = new ContentInformationObject[4];
    private final AppAdapterSystemServices systemServices;
    private CarDrivingDataModelApiCallback carDrivingDataModelApiCallback;
    private int currentPage;
    boolean availableStatus;
    boolean etrakAvailableStatus;
    boolean tripGeneralAvailableStatus;
    boolean tripAbgConsumptionAvailableStatus;
    private int secondaryEngineType = 0;
    private ArrayList bcMenu1;
    private int currentHeaderIndex;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$drivingdatatiles$CarDrivingDataModelApiCallback;

    public CarDrivingDataService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    private boolean isBEV() {
        return this.systemServices.getConfigurationManager().isFeatureFlagSet(55);
    }

    public void start() {
        this.bcMenu1 = ASLCarFactory.getBordComputerAPI().getService().getBCMenu1();
        this.updateBCMenu2(ASLCarFactory.getBordComputerAPI().getService().getBCMenu2());
        this.updateBCMenu3(ASLCarFactory.getBordComputerAPI().getService().getBCMenu3());
        ASLCarFactory.getBordComputerAPI().addServiceListener(this);
        ASLCarFactory.getEtrakApi().addServiceListener(this);
        this.updatePrimaryEngineType(ASLCarFactory.getBordComputerAPI().getService().getPrimaryEngineType());
        this.updateSecondaryEngineType(ASLCarFactory.getBordComputerAPI().getService().getSecondaryEngineType());
        this.availableStatus = ASLCarFactory.getBordComputerAPI().getService().getAvailableStatusRange();
        this.etrakAvailableStatus = ASLCarFactory.getEtrakApi().getService().getEtrakAvailableStatus();
        this.tripGeneralAvailableStatus = ASLCarFactory.getBordComputerAPI().getService().getAvailableStatusTripGeneral();
        this.tripAbgConsumptionAvailableStatus = ASLCarFactory.getBordComputerAPI().getService().getAvailableStatusTripAverageConsumption();
        this.updateAvailableStatusRange(this.availableStatus);
        this.updateEtrakAvailableStatus(this.etrakAvailableStatus);
        this.updateAvailableStatusTripGeneral(this.tripGeneralAvailableStatus);
        this.updateAvailableStatusTripAverageConsumption(this.tripAbgConsumptionAvailableStatus);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(394)) {
            this.getCarDrivingDataModelApiCallback()._update_getMode(true);
        } else if (ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV()) {
            this.getCarDrivingDataModelApiCallback()._update_getMode(true);
        } else if (this.isBEV()) {
            this.getCarDrivingDataModelApiCallback()._update_getMode(false);
        }
        this.systemServices.getConfigurationManager().addFeatureFlagValueChangeReceiver(new CarDrivingDataService$1(this), 55);
    }

    private Logger getLogger() {
        return this.systemServices.createLogger(0xA004000);
    }

    private CarDrivingDataModelApiCallback getCarDrivingDataModelApiCallback() {
        if (this.carDrivingDataModelApiCallback == null) {
            this.carDrivingDataModelApiCallback = (CarDrivingDataModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$drivingdatatiles$CarDrivingDataModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$drivingdatatiles$CarDrivingDataModelApiCallback = CarDrivingDataService.class$("generated.de.vw.mib.appadapter.drivingdatatiles.CarDrivingDataModelApiCallback")) : class$generated$de$vw$mib$appadapter$drivingdatatiles$CarDrivingDataModelApiCallback);
        }
        return this.carDrivingDataModelApiCallback;
    }

    private void showCarView() {
        CioActionParameters cioActionParameters;
        CioIntent cioIntent;
        switch (this.currentPage) {
            case 0: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarDrivingDataSinceStart").finishActionParams();
                break;
            }
            case 1: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarDrivingDataSinceLongterm").finishActionParams();
                break;
            }
            case 2: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarDrivingDataSinceRefueling").finishActionParams();
                break;
            }
            default: {
                cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowCarView");
                cioActionParameters = this.systemServices.getCioFactory().createActionParameters(cioIntent).setString("Context", "CarDrivingDataSinceStart").finishActionParams();
            }
        }
        this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    private int getIntentIndex(int n) {
        if (n == 2 && this.isBEV()) {
            return 3;
        }
        return n;
    }

    @Override
    public void _mda_setCurrentPage(int n) {
        this.switchVisualization(this.getIntentIndex(this.currentPage), this.getIntentIndex(n));
        this.currentPage = n;
    }

    @Override
    public void _mda_setFullScreenDrivingData() {
        this.showCarView();
    }

    @Override
    public void updatePrimaryEngineType(int n) {
        this.getCarDrivingDataModelApiCallback()._update_getPrimaryEngineType(n);
    }

    @Override
    public void updateSecondaryEngineType(int n) {
        this.secondaryEngineType = n;
        this.getCarDrivingDataModelApiCallback()._update_getSecondaryEngineType(this.secondaryEngineType);
        this.updateBCMenu1(this.bcMenu1);
    }

    @Override
    public void updateBCMenu1(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() == 8) {
            int[] nArray = (int[])arrayList.get(0);
            int[] nArray2 = (int[])arrayList.get(1);
            int[] nArray3 = (int[])arrayList.get(6);
            int[] nArray4 = (int[])arrayList.get(2);
            int[] nArray5 = (int[])arrayList.get(this.secondaryEngineType == 0 ? 4 : 7);
            int[][] nArrayArray = new int[3][];
            for (int i2 = 0; i2 < 3; ++i2) {
                nArrayArray[i2] = new int[]{nArray[i2], nArray2[i2], nArray3[i2], nArray4[i2], nArray5[i2]};
            }
            this.getCarDrivingDataModelApiCallback()._update_getBCMenu1(nArrayArray[0], nArrayArray[1], nArrayArray[2]);
        }
    }

    @Override
    public void updateBCMenu2(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() == 8) {
            int[] nArray = (int[])arrayList.get(0);
            int[] nArray2 = (int[])arrayList.get(1);
            int[] nArray3 = (int[])arrayList.get(6);
            int[] nArray4 = (int[])arrayList.get(2);
            int[] nArray5 = (int[])arrayList.get(7);
            int[][] nArrayArray = new int[3][];
            for (int i2 = 0; i2 < 3; ++i2) {
                nArrayArray[i2] = new int[]{nArray[i2], nArray2[i2], nArray3[i2], nArray4[i2], nArray5[i2]};
            }
            this.getCarDrivingDataModelApiCallback()._update_getBCMenu2(nArrayArray[0], nArrayArray[1], nArrayArray[2]);
        }
    }

    @Override
    public void updateBCMenu3(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() == 8) {
            int[] nArray = (int[])arrayList.get(0);
            int[] nArray2 = (int[])arrayList.get(1);
            int[] nArray3 = (int[])arrayList.get(6);
            int[] nArray4 = (int[])arrayList.get(2);
            int[] nArray5 = (int[])arrayList.get(7);
            int[][] nArrayArray = new int[3][];
            for (int i2 = 0; i2 < 3; ++i2) {
                nArrayArray[i2] = new int[]{nArray[i2], nArray2[i2], nArray3[i2], nArray4[i2], nArray5[i2]};
            }
            this.getCarDrivingDataModelApiCallback()._update_getBCMenu3(nArrayArray[0], nArrayArray[1], nArrayArray[2]);
        }
    }

    @Override
    public void updateAvailableStatusRange(boolean bl) {
        this.availableStatus = bl;
        this.getCarDrivingDataModelApiCallback()._update_getFunctionAvailabilities(bl, this.etrakAvailableStatus, this.tripGeneralAvailableStatus, this.tripAbgConsumptionAvailableStatus);
    }

    @Override
    public void updateAvailableStatusTripGeneral(boolean bl) {
        this.tripGeneralAvailableStatus = bl;
        this.getCarDrivingDataModelApiCallback()._update_getFunctionAvailabilities(bl, this.etrakAvailableStatus, this.tripGeneralAvailableStatus, this.tripAbgConsumptionAvailableStatus);
    }

    @Override
    public void updateAvailableStatusTripAverageConsumption(boolean bl) {
        this.tripAbgConsumptionAvailableStatus = bl;
        this.getCarDrivingDataModelApiCallback()._update_getFunctionAvailabilities(bl, this.etrakAvailableStatus, this.tripGeneralAvailableStatus, this.tripAbgConsumptionAvailableStatus);
    }

    @Override
    public void updateEtrakAvailableStatus(boolean bl) {
        this.etrakAvailableStatus = bl;
        this.getCarDrivingDataModelApiCallback()._update_getFunctionAvailabilities(bl, this.etrakAvailableStatus, this.tripGeneralAvailableStatus, this.tripAbgConsumptionAvailableStatus);
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                this.showCarView();
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        if (contentInformationObject.getCioName().equals("DrivingDataTileSHeaderButtonAction")) {
            int n = 0;
            if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonAction1")) {
                n = 0;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonAction2")) {
                n = 1;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonAction3")) {
                n = 2;
            } else if (contentInformationObject.getCioIntentName().equals("TileHeaderButtonAction3b")) {
                n = 3;
            }
            this.headerButtons[n] = contentInformationObject;
            if (n != this.getIntentIndex(this.currentPage)) {
                return true;
            }
        }
        return false;
    }

    private void switchVisualization(int n, int n2) {
        try {
            this.headerButtons[n].unregister();
            this.headerButtons[n2].register();
            this.currentHeaderIndex = n2;
        }
        catch (NullPointerException nullPointerException) {
            this.getLogger().error(0xA004000, new StringBuffer().append("error with switching visualization from ").append(n).append(" to ").append(n2).toString());
        }
    }

    static /* synthetic */ int access$000(CarDrivingDataService carDrivingDataService) {
        return carDrivingDataService.currentPage;
    }

    static /* synthetic */ int access$100(CarDrivingDataService carDrivingDataService) {
        return carDrivingDataService.currentHeaderIndex;
    }

    static /* synthetic */ void access$200(CarDrivingDataService carDrivingDataService, int n, int n2) {
        carDrivingDataService.switchVisualization(n, n2);
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

