/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.appconnecttiles.component;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.collections.ints.IntObjectMap;

public class AppConnectTileBigCioHandler {
    public static final int INSTANCE_MEDIA;
    public static final int INSTANCE_NATIVE;
    private AppAdapterSystemServices systemServices;
    private int instanceId;
    private ContentInformationObject bindAppConnectTileCio;

    public AppConnectTileBigCioHandler(AppAdapterSystemServices appAdapterSystemServices, int n) {
        this.systemServices = appAdapterSystemServices;
        this.instanceId = n;
    }

    public void updateRegisterEntertainmentTile(IntObjectMap intObjectMap) {
        this.registerEntertainmentBigTileCio((CioIntent)intObjectMap.get(0), 8);
        this.registerEntertainmentBigTileCio((CioIntent)intObjectMap.get(0), 7);
        this.registerEntertainmentBigTileCio((CioIntent)intObjectMap.get(0), 9);
        this.registerEntertainmentBigTileCio((CioIntent)intObjectMap.get(0), 10);
    }

    private void registerEntertainmentBigTileCio(CioIntent cioIntent, int n) {
        CioIntent cioIntent2 = this.systemServices.getCioDictionary().getCioIntent("RegisterEntertainmentTile", "BigTile");
        if (cioIntent2 == null) {
            return;
        }
        CioParametersCreator cioParametersCreator = this.systemServices.getCioFactory().createActionParameters(cioIntent2);
        cioParametersCreator.setInt("EntertainmentContext", n);
        cioParametersCreator.setCioIntent("BindHostedApp", (CioIntent)((Object)this.bindAppConnectTileCio));
        cioParametersCreator.setCioIntent("TileHeaderButtonAction", cioIntent);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        this.systemServices.getCioDispatcher().dispatch(cioIntent2, cioActionParameters);
    }

    public boolean handleCioIntentRegistration(ContentInformationObject contentInformationObject) {
        String string = contentInformationObject.getCioIntentName();
        if (string.equals("BindAppConnectTile")) {
            this.bindAppConnectTileCio = contentInformationObject;
            return this.instanceId != 1;
        }
        return true;
    }
}

