/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.features.complex;

import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.model.Command;

public interface ComplexCommandFeature
extends GenericTargetFeature {
    default public void setCommandsToLoad(Command[] commandArray) {
    }

    default public void setCommandsToUnload(Command[] commandArray) {
    }
}

