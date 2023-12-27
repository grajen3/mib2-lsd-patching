/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mediacontrol.adapter.ModelAPIImpl$1;
import de.vw.mib.asl.internal.mediacontrol.adapter.common.AbstractModelDomain;
import de.vw.mib.asl.internal.mediacontrol.adapter.common.ModelView;
import de.vw.mib.genericevents.GenericEvents;

public class ModelAPIImpl
extends AbstractModelDomain {
    public static final int MAX_DEVICES;
    private MediaControlAPI mMediaControlAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI;

    public ModelAPIImpl(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 369236736;
    }

    @Override
    public int getClassifier() {
        return 8;
    }

    @Override
    public int getSubClassifier() {
        return 8;
    }

    @Override
    protected void startupDomain() {
        ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
        aSLComponentRegistry.requestAPI(class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI == null ? (class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI = ModelAPIImpl.class$("de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI")) : class$de$vw$mib$asl$api$mediacontrol$services$MediaControlAPI, new ModelAPIImpl$1(this));
    }

    @Override
    protected void shutdownDomain() {
        ServiceManager.aslPropertyManager.valueChangedInteger(1681, 0);
        this.removeAllViews();
        this.mMediaControlAPI = null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ MediaControlAPI access$002(ModelAPIImpl modelAPIImpl, MediaControlAPI mediaControlAPI) {
        modelAPIImpl.mMediaControlAPI = mediaControlAPI;
        return modelAPIImpl.mMediaControlAPI;
    }

    static /* synthetic */ MediaControlAPI access$000(ModelAPIImpl modelAPIImpl) {
        return modelAPIImpl.mMediaControlAPI;
    }

    static /* synthetic */ void access$100(ModelAPIImpl modelAPIImpl, ModelView modelView) {
        modelAPIImpl.addView(modelView);
    }

    static /* synthetic */ void access$200(ModelAPIImpl modelAPIImpl, ModelView modelView) {
        modelAPIImpl.addView(modelView);
    }

    static /* synthetic */ void access$300(ModelAPIImpl modelAPIImpl, ModelView modelView) {
        modelAPIImpl.addView(modelView);
    }
}

