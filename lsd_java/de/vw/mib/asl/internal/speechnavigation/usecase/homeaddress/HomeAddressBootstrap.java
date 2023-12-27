/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.BootstraperBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress.HomeAddressController;
import de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress.HomeAddressHelpController;

public class HomeAddressBootstrap
extends BootstraperBase {
    public HomeAddressBootstrap(ResultHandler resultHandler) {
        super(resultHandler);
    }

    @Override
    public void initialize() {
        ResultControllerRouter resultControllerRouter = this.resultHandler.getResultControllerRegistry();
        try {
            RecognizedEventConsumer recognizedEventConsumer = new HomeAddressController();
            resultControllerRouter.register(recognizedEventConsumer, 1222718272);
            recognizedEventConsumer = new HomeAddressHelpController();
            resultControllerRouter.register(recognizedEventConsumer, 1776366400);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error creating the routing table: ").append(navigationServiceException.getMessage()).toString());
        }
    }
}

