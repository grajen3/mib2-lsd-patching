/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.util;

import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;

public class HostedAppBinder {
    private final CioDictionary cioDictionary;
    private final CioDispatcher cioDispatcher;
    private final CioFactory cioFactory;

    public HostedAppBinder(CioDictionary cioDictionary, CioDispatcher cioDispatcher, CioFactory cioFactory) {
        this.cioDictionary = cioDictionary;
        this.cioDispatcher = cioDispatcher;
        this.cioFactory = cioFactory;
    }

    public void bindHostedApp(CioIntent cioIntent, Tile tile) {
        this.createApp(cioIntent);
        this.bindApp(cioIntent, tile);
    }

    public void disposeHostedApp(CioIntent cioIntent) {
        if (cioIntent != null) {
            CioIntent cioIntent2 = this.cioDictionary.getCioIntent("DisposeHostedApp", cioIntent);
            this.cioDispatcher.dispatch(cioIntent2);
        }
    }

    private void createApp(CioIntent cioIntent) {
        this.cioDispatcher.dispatch(cioIntent);
    }

    private void bindApp(CioIntent cioIntent, Tile tile) {
        CioIntent cioIntent2 = this.cioDictionary.getCioIntent("BindHostedApp", cioIntent);
        CioParametersCreator cioParametersCreator = this.cioFactory.createActionParameters(cioIntent2);
        cioParametersCreator.setString("hostAppName", "HomeScreen");
        cioParametersCreator.setString("hostAppInstanceName", "HomeScreen");
        cioParametersCreator.setString("hostAppScreenArea", tile.getScreenArea());
        cioParametersCreator.setString("hostedAppLayerLabel", "Main");
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.cioDispatcher.dispatch(cioIntent2, cioActionParameters);
    }
}

