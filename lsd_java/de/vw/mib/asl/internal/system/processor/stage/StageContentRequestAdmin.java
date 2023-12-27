/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.api.system.content.AbstractStageContentRequest;
import de.vw.mib.asl.internal.system.processor.stage.AbstractStageContentRequestPermission;

public interface StageContentRequestAdmin {
    default public void addPermission(AbstractStageContentRequestPermission abstractStageContentRequestPermission) {
    }

    default public void removePermission(AbstractStageContentRequestPermission abstractStageContentRequestPermission) {
    }

    default public boolean isRequestGranted(AbstractStageContentRequest abstractStageContentRequest) {
    }
}

