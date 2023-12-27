/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.pictureviewertiles;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.pictureviewertiles.PictureViewerTileSAdapter$1;
import de.vw.mib.appadapter.pictureviewertiles.PictureViewerTileSAdapter$2;
import de.vw.mib.appadapter.pictureviewertiles.PictureViewerTileSAdapter$3;
import de.vw.mib.asl.api.pictureviewer.services.PictureViewerControlService;
import de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureService;
import de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureUpdate;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.pictureviewertiles.MainModelApiCallback;
import org.dsi.ifc.global.ResourceLocator;

public final class PictureViewerTileSAdapter
extends AbstractAppAdapter
implements CioExecutor,
PictureViewerCurrentPictureUpdate {
    private static final int TILE_HEADER_BUTTON_ACTION;
    PictureViewerControlService pictureViewerControlService = null;
    PictureViewerCurrentPictureService pictureViewerCurrentPictureService = null;
    private MainModelApiCallback modelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$pictureviewertiles$MainModelApiCallback;
    static /* synthetic */ Class class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService;

    public PictureViewerTileSAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.modelApiCallback = (MainModelApiCallback)appAdapterSystemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$pictureviewertiles$MainModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$pictureviewertiles$MainModelApiCallback = PictureViewerTileSAdapter.class$("generated.de.vw.mib.appadapter.pictureviewertiles.MainModelApiCallback")) : class$generated$de$vw$mib$appadapter$pictureviewertiles$MainModelApiCallback);
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService == null ? (class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService = PictureViewerTileSAdapter.class$("de.vw.mib.asl.api.pictureviewer.services.PictureViewerControlService")) : class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerControlService, new PictureViewerTileSAdapter$1(this));
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().requestAPI(class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService == null ? (class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService = PictureViewerTileSAdapter.class$("de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureService")) : class$de$vw$mib$asl$api$pictureviewer$services$PictureViewerCurrentPictureService, new PictureViewerTileSAdapter$2(this));
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[]{new PictureViewerTileSAdapter$3(this)};
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 1: {
                CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_PICTUREVIEWER");
                this.systemServices.getCioDispatcher().dispatch(cioIntent);
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void onCurrentPictureChanged(ResourceLocator resourceLocator) {
        this.modelApiCallback._update_getCurrentImage(resourceLocator);
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

