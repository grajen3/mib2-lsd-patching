/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOI;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer.AbstractSpeechNavigationControllerOnboardPOIsSelectedOnboardPOITransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechNavigationControllerOnboardPOIsSelectedOnboardPOITransformer
extends AbstractSpeechNavigationControllerOnboardPOIsSelectedOnboardPOITransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        OnboardPOI onboardPOI = (OnboardPOI)object;
        switch (n) {
            case 5: {
                return true;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public int getInt(int n, Object object) {
        OnboardPOI onboardPOI = (OnboardPOI)object;
        switch (n) {
            case 4: {
                return onboardPOI.getArrowIndex();
            }
            case 3: {
                return onboardPOI.getDistance();
            }
            case 6: {
                return onboardPOI.getInternalIndex();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        OnboardPOI onboardPOI = (OnboardPOI)object;
        switch (n) {
            case 0: {
                return onboardPOI.getIndex();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        OnboardPOI onboardPOI = (OnboardPOI)object;
        switch (n) {
            case 1: {
                return onboardPOI.getIcon();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        OnboardPOI onboardPOI = (OnboardPOI)object;
        switch (n) {
            case 2: {
                return onboardPOI.getName();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

