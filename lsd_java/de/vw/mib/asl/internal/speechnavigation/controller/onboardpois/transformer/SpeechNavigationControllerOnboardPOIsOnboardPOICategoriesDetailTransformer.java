/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer;

import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOICategory;
import generated.de.vw.mib.asl.internal.speechnavigation.controller.onboardpois.transformer.AbstractSpeechNavigationControllerOnboardPOIsOnboardPOICategoriesDetailTransformer;

public class SpeechNavigationControllerOnboardPOIsOnboardPOICategoriesDetailTransformer
extends AbstractSpeechNavigationControllerOnboardPOIsOnboardPOICategoriesDetailTransformer {
    @Override
    public long getLong(int n, Object object) {
        OnboardPOICategory onboardPOICategory = (OnboardPOICategory)object;
        switch (n) {
            case 2: {
                return onboardPOICategory.objectId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        OnboardPOICategory onboardPOICategory = (OnboardPOICategory)object;
        switch (n) {
            case 3: {
                return onboardPOICategory.title;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

