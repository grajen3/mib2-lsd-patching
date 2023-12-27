/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusMainModelApiService;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusOilModelApiService;
import generated.de.vw.mib.appadapter.carstatustiles.CarStatusTiresModelApiService;
import generated.de.vw.mib.appadapter.carstatustiles.GeneralModelApiService;

public class CarStatusTileSModelApiServiceProxy
implements ModelApiDownEventHandler {
    private static final int SUB_CLASSIFIER;
    private final CarStatusMainModelApiService carStatusMainModelApiService;
    private final CarStatusOilModelApiService carStatusOilModelApiService;
    private final CarStatusTiresModelApiService carStatusTiresModelApiService;
    private final GeneralModelApiService generalModelApiService;
    private final Logger logger;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$carstatustiles$GeneralModelApiService;

    public CarStatusTileSModelApiServiceProxy(ModelApiService[] modelApiServiceArray, AppDefinition appDefinition, Logger logger) {
        this.logger = logger;
        this.carStatusMainModelApiService = (CarStatusMainModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiService == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiService = CarStatusTileSModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.carstatustiles.CarStatusMainModelApiService")) : class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusMainModelApiService, modelApiServiceArray);
        this.carStatusOilModelApiService = (CarStatusOilModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiService == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiService = CarStatusTileSModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.carstatustiles.CarStatusOilModelApiService")) : class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusOilModelApiService, modelApiServiceArray);
        this.carStatusTiresModelApiService = (CarStatusTiresModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiService == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiService = CarStatusTileSModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.carstatustiles.CarStatusTiresModelApiService")) : class$generated$de$vw$mib$appadapter$carstatustiles$CarStatusTiresModelApiService, modelApiServiceArray);
        this.generalModelApiService = (GeneralModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$carstatustiles$GeneralModelApiService == null ? (class$generated$de$vw$mib$appadapter$carstatustiles$GeneralModelApiService = CarStatusTileSModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.carstatustiles.GeneralModelApiService")) : class$generated$de$vw$mib$appadapter$carstatustiles$GeneralModelApiService, modelApiServiceArray);
    }

    private ModelApiService getServiceOf(Class clazz, ModelApiService[] modelApiServiceArray) {
        for (int i2 = 0; i2 < modelApiServiceArray.length; ++i2) {
            if (!clazz.isAssignableFrom(super.getClass())) continue;
            return modelApiServiceArray[i2];
        }
        String string = new StringBuffer().append("Instantiating of ").append(super.getClass().getName()).append(" failed. Required model API service ").append(clazz.getName()).append(" not registered.").toString();
        this.logger.error(512, string);
        throw new IllegalArgumentException(string);
    }

    public CarStatusMainModelApiService getCarStatusMainModelApiService() {
        return this.carStatusMainModelApiService;
    }

    public CarStatusOilModelApiService getCarStatusOilModelApiService() {
        return this.carStatusOilModelApiService;
    }

    public CarStatusTiresModelApiService getCarStatusTiresModelApiService() {
        return this.carStatusTiresModelApiService;
    }

    public GeneralModelApiService getGeneralModelApiService() {
        return this.generalModelApiService;
    }

    @Override
    public void onModelApiDownEvent(ModelApiDownEvent modelApiDownEvent) {
        int n = modelApiDownEvent.getActionId();
        switch (n) {
            case 7: {
                this.generalModelApiService._mda_setCurrentPageByIndex(modelApiDownEvent.getInt(0));
                break;
            }
            default: {
                this.unknownAction(n);
            }
        }
    }

    private void unknownAction(int n) {
        this.logger.trace(512).append("App {ExternalCommunication} proxy - ").append("unknown action ID ").append(n).log();
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

