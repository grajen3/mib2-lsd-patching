/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import generated.de.vw.mib.appadapter.car.GesturesModelApiService;
import generated.de.vw.mib.appadapter.car.PersonalizationModelApiService;
import generated.de.vw.mib.appadapter.car.ShowActualViewsModelApiService;

public class CarModelApiServiceProxy
implements ModelApiDownEventHandler {
    private static final int SUB_CLASSIFIER;
    private final GesturesModelApiService gesturesModelApiService;
    private final PersonalizationModelApiService personalizationModelApiService;
    private final ShowActualViewsModelApiService showActualViewsModelApiService;
    private final Logger logger;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$car$GesturesModelApiService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiService;

    public CarModelApiServiceProxy(ModelApiService[] modelApiServiceArray, AppDefinition appDefinition, Logger logger) {
        this.logger = logger;
        this.gesturesModelApiService = (GesturesModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$car$GesturesModelApiService == null ? (class$generated$de$vw$mib$appadapter$car$GesturesModelApiService = CarModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.car.GesturesModelApiService")) : class$generated$de$vw$mib$appadapter$car$GesturesModelApiService, modelApiServiceArray);
        this.personalizationModelApiService = (PersonalizationModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiService == null ? (class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiService = CarModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.car.PersonalizationModelApiService")) : class$generated$de$vw$mib$appadapter$car$PersonalizationModelApiService, modelApiServiceArray);
        this.showActualViewsModelApiService = (ShowActualViewsModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiService == null ? (class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiService = CarModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.car.ShowActualViewsModelApiService")) : class$generated$de$vw$mib$appadapter$car$ShowActualViewsModelApiService, modelApiServiceArray);
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

    public GesturesModelApiService getGesturesModelApiService() {
        return this.gesturesModelApiService;
    }

    public PersonalizationModelApiService getPersonalizationModelApiService() {
        return this.personalizationModelApiService;
    }

    public ShowActualViewsModelApiService getShowActualViewsModelApiService() {
        return this.showActualViewsModelApiService;
    }

    @Override
    public void onModelApiDownEvent(ModelApiDownEvent modelApiDownEvent) {
        int n = modelApiDownEvent.getActionId();
        switch (n) {
            case 2: {
                this.gesturesModelApiService._mda_showSpaceGestureAvailableAnimation(modelApiDownEvent.getInt(0));
                break;
            }
            case 3: {
                this.gesturesModelApiService._mda_showSpaceGestureRegisteredAnimation(modelApiDownEvent.getInt(0), modelApiDownEvent.getBoolean(1));
                break;
            }
            case 4: {
                this.personalizationModelApiService._mda_finishEnterProfileName(modelApiDownEvent.getString(0));
                break;
            }
            case 5: {
                this.showActualViewsModelApiService._mda_reset();
                break;
            }
            case 6: {
                this.showActualViewsModelApiService._mda_showView(modelApiDownEvent.getInt(0));
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

