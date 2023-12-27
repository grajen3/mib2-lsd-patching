/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.features.complex;

import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.model.DynamicString;

public interface ComplexTeleprompterDataFeature
extends GenericTargetFeature {
    default public void setTeleprompterType(int n) {
    }

    default public void setCommandExamples(DynamicString[] dynamicStringArray) {
    }

    default public void setHeadline(DynamicString dynamicString) {
    }
}

