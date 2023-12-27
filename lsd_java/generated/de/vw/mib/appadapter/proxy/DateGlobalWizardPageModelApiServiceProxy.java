/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy;

import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import generated.de.vw.mib.appadapter.dateglobalwizardpage.InformationModelApiService;

public class DateGlobalWizardPageModelApiServiceProxy
implements ModelApiDownEventHandler {
    private static final int SUB_CLASSIFIER;
    private final InformationModelApiService informationModelApiService;
    private final Logger logger;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$dateglobalwizardpage$InformationModelApiService;

    public DateGlobalWizardPageModelApiServiceProxy(ModelApiService[] modelApiServiceArray, AppDefinition appDefinition, Logger logger) {
        this.logger = logger;
        this.informationModelApiService = (InformationModelApiService)this.getServiceOf(class$generated$de$vw$mib$appadapter$dateglobalwizardpage$InformationModelApiService == null ? (class$generated$de$vw$mib$appadapter$dateglobalwizardpage$InformationModelApiService = DateGlobalWizardPageModelApiServiceProxy.class$("generated.de.vw.mib.appadapter.dateglobalwizardpage.InformationModelApiService")) : class$generated$de$vw$mib$appadapter$dateglobalwizardpage$InformationModelApiService, modelApiServiceArray);
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

    public InformationModelApiService getInformationModelApiService() {
        return this.informationModelApiService;
    }

    @Override
    public void onModelApiDownEvent(ModelApiDownEvent modelApiDownEvent) {
        int n = modelApiDownEvent.getActionId();
        switch (n) {
            case 10: {
                this.missingAction(n, "Information", "setHeadlineText(int)");
                break;
            }
            case 11: {
                this.informationModelApiService._mda_setupPageReady();
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

