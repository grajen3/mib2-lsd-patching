/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.media;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.media.MediaGestureModelApiService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.media.EnterModelApiCallback;

public class MediaAdapter
extends AbstractAppAdapter
implements CioExecutor {
    private static final int SHOW_BLUETOOTH_MEDIA_DEVICE_SELECTION;
    private EnterModelApiCallback callback;
    private MediaGestureModelApiService mediaGestureModelApiService;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$media$EnterModelApiCallback;

    public MediaAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        ModelApiService[] modelApiServiceArray = new ModelApiService[]{this.getMediaGestureModelApiService()};
        return modelApiServiceArray;
    }

    private MediaGestureModelApiService getMediaGestureModelApiService() {
        if (this.mediaGestureModelApiService == null) {
            this.mediaGestureModelApiService = new MediaGestureModelApiService(this.systemServices);
        }
        return this.mediaGestureModelApiService;
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
        this.callback = (EnterModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$media$EnterModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$media$EnterModelApiCallback = MediaAdapter.class$("generated.de.vw.mib.appadapter.media.EnterModelApiCallback")) : class$generated$de$vw$mib$appadapter$media$EnterModelApiCallback);
    }

    @Override
    public void stop() {
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        int n = contentInformationObject.getActionId();
        switch (n) {
            case 0: {
                this.callback._on_appMediaEnterShowBluetoothMediaDeviceSelection();
                break;
            }
        }
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
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

