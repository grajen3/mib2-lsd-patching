/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.application;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationErrorHandlerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;

public class ApplicationHelpController
extends ApplicationErrorHandlerBase
implements RecognizedEventConsumer {
    public static final int CMD_HELP_NAV;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$application$ApplicationHelpController;

    @Override
    public void onRecognizedEvent(int n) {
        switch (n) {
            case 1077141872: {
                this.onApplicationHelp();
                break;
            }
            default: {
                AppLogger.warn(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$application$ApplicationHelpController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$application$ApplicationHelpController = ApplicationHelpController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationHelpController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$application$ApplicationHelpController).getName()).append(" unhandle event: ").append(n).toString());
            }
        }
    }

    protected void onApplicationHelp() {
        try {
            this.checkNaviServiceAvailable();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.info(new StringBuffer().append((class$de$vw$mib$asl$internal$speechnavigation$usecase$application$ApplicationHelpController == null ? (class$de$vw$mib$asl$internal$speechnavigation$usecase$application$ApplicationHelpController = ApplicationHelpController.class$("de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationHelpController")) : class$de$vw$mib$asl$internal$speechnavigation$usecase$application$ApplicationHelpController).getName()).append(navigationServiceException.getMessage()).toString());
            return;
        }
        Framework.fireUIEvent(-1744292864);
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-1358416896);
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

