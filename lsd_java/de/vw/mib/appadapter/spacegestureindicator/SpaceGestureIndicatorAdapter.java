/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.spacegestureindicator;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.spacegestureindicator.SpaceGestureIndicatorAdapter$1;
import de.vw.mib.asl.api.sound.ASLSoundFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.input.SpaceGestureListener;
import de.vw.mib.asl.api.system.input.SpaceGestureService;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;
import generated.de.vw.mib.appadapter.spacegestureindicator.InformationModelApiCallback;

public class SpaceGestureIndicatorAdapter
extends AbstractAppAdapter
implements CioExecutor {
    public static final int SPACE_GESTURE_INDICATION_OFF;
    public static final int SPACE_GESTURE_INDICATION_ON;
    public static final int SPACE_GESTURE_RECOGNITION_FEEDBACK_LEFT_TO_RIGHT;
    public static final int SPACE_GESTURE_RECOGNITION_FEEDBACK_RIGHT_TO_LEFT;
    public static final int SPACE_GESTURE_RECOGNITION_FEEDBACK_SOUND;
    private final InformationModelApiCallback callback;
    private final SpaceGestureService spaceGestureService;
    private boolean isGestureViewEntered;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$spacegestureindicator$InformationModelApiCallback;

    public SpaceGestureIndicatorAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.callback = (InformationModelApiCallback)appAdapterSystemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$spacegestureindicator$InformationModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$spacegestureindicator$InformationModelApiCallback = SpaceGestureIndicatorAdapter.class$("generated.de.vw.mib.appadapter.spacegestureindicator.InformationModelApiCallback")) : class$generated$de$vw$mib$appadapter$spacegestureindicator$InformationModelApiCallback);
        this.spaceGestureService = ASLSystemFactory.getSystemApi().getSpaceGestureService();
        this.spaceGestureService.addListener(this.createSpaceGestureServiceListener());
    }

    private SpaceGestureListener createSpaceGestureServiceListener() {
        return new SpaceGestureIndicatorAdapter$1(this);
    }

    void processSpaceGestureActivated() {
        boolean bl = this.spaceGestureService.isCurrentSpaceGestureActivated();
        boolean bl2 = this.spaceGestureService.istCurrentSpaceGestureInformationActivated();
        if (bl && bl2 && this.isGestureViewEntered) {
            this.callback._update_getSpaceGestureInformation(1);
        }
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        switch (contentInformationObject.getActionId()) {
            case 0: {
                this.isGestureViewEntered = true;
                this.processSpaceGestureActivated();
                break;
            }
            case 1: {
                this.isGestureViewEntered = false;
                this.disableSpaceGestureIndicator();
                break;
            }
            case 2: {
                if (!this.spaceGestureService.isCurrentSpaceGestureActivated()) {
                    return;
                }
                boolean bl = cioActionParameters.getBoolean("Success");
                boolean bl2 = this.spaceGestureService.isCurrentSpaceGestureSoundEffectActivated();
                this.processLeftToRightFeedback(bl, bl2);
                break;
            }
            case 3: {
                if (!this.spaceGestureService.isCurrentSpaceGestureActivated()) {
                    return;
                }
                boolean bl = cioActionParameters.getBoolean("Success");
                boolean bl3 = this.spaceGestureService.isCurrentSpaceGestureSoundEffectActivated();
                this.processRightToLeftFeedback(bl, bl3);
                break;
            }
        }
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this;
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return new ModelApiService[0];
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void ready() {
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    void disableSpaceGestureIndicator() {
        this.callback._update_getSpaceGestureInformation(2);
    }

    private void processLeftToRightFeedback(boolean bl, boolean bl2) {
        boolean bl3 = this.spaceGestureService.istCurrentSpaceGestureInformationActivated();
        if (bl3) {
            this.callback._update_getSpaceGestureInformation(bl ? 3 : 5);
        }
        if (bl && bl2) {
            ASLSoundFactory.getSoundApi().getASLSoundServices().createBeep(5);
        }
    }

    private void processRightToLeftFeedback(boolean bl, boolean bl2) {
        boolean bl3 = this.spaceGestureService.istCurrentSpaceGestureInformationActivated();
        if (bl3) {
            this.callback._update_getSpaceGestureInformation(bl ? 4 : 6);
        }
        if (bl && bl2) {
            ASLSoundFactory.getSoundApi().getASLSoundServices().createBeep(5);
        }
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

