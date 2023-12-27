/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import generated.de.vw.mib.appadapter.nav.HomeAddressInputModelApiService;
import generated.de.vw.mib.appadapter.nav.ShowNavViewModelApiService;

public class NavModelApiServiceProxy
implements ModelApiDownEventHandler {
    private static final int SUB_CLASSIFIER;
    private final HomeAddressInputModelApiService homeAddressInputModelApiService;
    private final ShowNavViewModelApiService showNavViewModelApiService;
    private final Logger logger;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiService;

    public NavModelApiServiceProxy(ModelApiService[] modelApiServiceArray, AppDefinition appDefinition, Logger logger) {
        this.logger = logger;
        this.homeAddressInputModelApiService = (HomeAddressInputModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiService == null ? (class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiService = NavModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.nav.HomeAddressInputModelApiService")) : class$generated$de$vw$mib$appadapter$nav$HomeAddressInputModelApiService, modelApiServiceArray);
        this.showNavViewModelApiService = (ShowNavViewModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiService == null ? (class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiService = NavModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.nav.ShowNavViewModelApiService")) : class$generated$de$vw$mib$appadapter$nav$ShowNavViewModelApiService, modelApiServiceArray);
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

    public HomeAddressInputModelApiService getHomeAddressInputModelApiService() {
        return this.homeAddressInputModelApiService;
    }

    public ShowNavViewModelApiService getShowNavViewModelApiService() {
        return this.showNavViewModelApiService;
    }

    @Override
    public void onModelApiDownEvent(ModelApiDownEvent modelApiDownEvent) {
        int n = modelApiDownEvent.getActionId();
        switch (n) {
            case 15: {
                this.homeAddressInputModelApiService._mda_returnToSetupWizard(modelApiDownEvent.getInt(0));
                break;
            }
            case 16: {
                this.showNavViewModelApiService._mda_setNavView(modelApiDownEvent.getBoolean(0));
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

