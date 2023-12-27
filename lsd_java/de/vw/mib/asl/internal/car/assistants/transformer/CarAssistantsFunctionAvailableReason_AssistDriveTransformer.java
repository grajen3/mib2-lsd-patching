/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.assistants.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.AbstractCarAssistantsFunctionAvailableReason_AssistDriveTransformer;

public class CarAssistantsFunctionAvailableReason_AssistDriveTransformer
extends AbstractCarAssistantsFunctionAvailableReason_AssistDriveTransformer {
    @Override
    public int getInt(int n, Object object) {
        return ((FunctionState)object).getAvailableReason();
    }
}

