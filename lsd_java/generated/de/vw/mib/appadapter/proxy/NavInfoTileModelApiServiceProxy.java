/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import generated.de.vw.mib.appadapter.navinfotile.GeneralModelApiService;

public class NavInfoTileModelApiServiceProxy
implements ModelApiDownEventHandler {
    private static final int SUB_CLASSIFIER;
    private final GeneralModelApiService generalModelApiService;
    private final Logger logger;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiService;

    public NavInfoTileModelApiServiceProxy(ModelApiService[] modelApiServiceArray, AppDefinition appDefinition, Logger logger) {
        this.logger = logger;
        this.generalModelApiService = (GeneralModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiService == null ? (class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiService = NavInfoTileModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.navinfotile.GeneralModelApiService")) : class$generated$de$vw$mib$appadapter$navinfotile$GeneralModelApiService, modelApiServiceArray);
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

    public GeneralModelApiService getGeneralModelApiService() {
        return this.generalModelApiService;
    }

    @Override
    public void onModelApiDownEvent(ModelApiDownEvent modelApiDownEvent) {
        int n = modelApiDownEvent.getActionId();
        switch (n) {
            case 19: {
                this.missingAction(n, "General", "enterWaitstate()");
                break;
            }
            case 20: {
                this.generalModelApiService._mda_setCurrentPage(modelApiDownEvent.getInt(0));
                break;
            }
            default: {
                this.unknownAction(n);
            }
        }
    }

    private void missingAction(int n, String string, String string2) {
        if (this.logger.isTraceEnabled(512)) {
            this.logger.trace(512).append("App {ExternalCommunication} proxy - ").append("service ").append(string).append(" not defines action ").append(string2).log();
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

