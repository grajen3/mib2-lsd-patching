/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model;

import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;

public class OnboardPOICategory {
    public final int size;
    public final long objectId;
    public final String title;

    public OnboardPOICategory() {
        this(-1, "");
    }

    public OnboardPOICategory(ResultItemIdentifier resultItemIdentifier) {
        this(resultItemIdentifier.getObjectId(), resultItemIdentifier.getRecognizedString());
    }

    public OnboardPOICategory(long l, String string) {
        this.size = 0;
        this.objectId = l;
        this.title = string;
    }

    public OnboardPOICategory(int n, String string) {
        this.size = n;
        this.objectId = -1L;
        this.title = string;
    }
}

