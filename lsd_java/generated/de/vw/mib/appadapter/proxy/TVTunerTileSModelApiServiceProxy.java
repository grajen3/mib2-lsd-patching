/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiService;

public class TVTunerTileSModelApiServiceProxy
implements ModelApiDownEventHandler {
    private static final int SUB_CLASSIFIER;
    private final TVTunerModelApiService tvtunerModelApiService;
    private final Logger logger;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiService;

    public TVTunerTileSModelApiServiceProxy(ModelApiService[] modelApiServiceArray, AppDefinition appDefinition, Logger logger) {
        this.logger = logger;
        this.tvtunerModelApiService = (TVTunerModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiService == null ? (class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiService = TVTunerTileSModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.tvtunertiles.TVTunerModelApiService")) : class$generated$de$vw$mib$appadapter$tvtunertiles$TVTunerModelApiService, modelApiServiceArray);
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

    public TVTunerModelApiService getTvtunerModelApiService() {
        return this.tvtunerModelApiService;
    }

    @Override
    public void onModelApiDownEvent(ModelApiDownEvent modelApiDownEvent) {
        int n = modelApiDownEvent.getActionId();
        switch (n) {
            case 35: {
                this.tvtunerModelApiService._mda_setNextStation();
                break;
            }
            case 36: {
                this.tvtunerModelApiService._mda_setPreviousStation();
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
