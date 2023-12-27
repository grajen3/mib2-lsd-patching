/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.AbstractHomeScreenTarget;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.genericevents.EventGeneric;

public class HomeScreenSpaceGesturesTarget
extends AbstractHomeScreenTarget {
    private final HomeScreenServices homeScreenServices;

    public HomeScreenSpaceGesturesTarget(HomeScreenServices homeScreenServices) {
        super(homeScreenServices.getGenericEvents(), homeScreenServices.getLogger(), -1206445568);
        this.homeScreenServices = homeScreenServices;
        this.addSpaceGestureListener();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1078641829: {
                this.showSpaceGestureAvailableAnimation("On");
                break;
            }
            case 1078641832: {
                this.showSpaceGestureAvailableAnimation("Off");
                break;
            }
            case 1078641830: {
                this.showSpaceGestureRegisteredAnimation(eventGeneric);
                break;
            }
        }
    }

    private void addSpaceGestureListener() {
        this.homeScreenServices.getServiceRegister().addObserver(-1513862592, this.getTargetId());
        this.homeScreenServices.getServiceRegister().addObserver(-1497085376, this.getTargetId());
        this.homeScreenServices.getServiceRegister().addObserver(-1463530944, this.getTargetId());
    }

    private void showSpaceGestureRegisteredAnimation(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        String string = this.getDirectionUsage(n);
        boolean bl = eventGeneric.getBoolean(1);
        CioIntent cioIntent = this.homeScreenServices.getCioDictionary().getCioIntent("ShowSpaceGestureRecognitionFeedback", string);
        CioActionParameters cioActionParameters = this.createActionParameters(bl, cioIntent);
        this.homeScreenServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
    }

    private CioActionParameters createActionParameters(boolean bl, CioIntent cioIntent) {
        CioParametersCreator cioParametersCreator = this.homeScreenServices.getCioFactory().createActionParameters(cioIntent);
        cioParametersCreator.setBoolean("Success", bl);
        CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
        return cioActionParameters;
    }

    private String getDirectionUsage(int n) {
        if (n == 0) {
            return "LeftToRight";
        }
        if (n == 1) {
            return "RightToLeft";
        }
        return null;
    }

    private void showSpaceGestureAvailableAnimation(String string) {
        CioIntent cioIntent = this.homeScreenServices.getCioDictionary().getCioIntent("ShowSpaceGestureIndication", string);
        if (cioIntent != null) {
            this.homeScreenServices.getCioDispatcher().dispatch(cioIntent);
        }
    }
}

