/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.assistants.transformer;

import de.vw.mib.asl.internal.car.model.FunctionState;
import generated.de.vw.mib.asl.internal.car.assistants.transformer.AbstractCarAssistantsFunctionExistence_DriveAssistTransformer;

public class CarAssistantsFunctionExistence_DriveAssistTransformer
extends AbstractCarAssistantsFunctionExistence_DriveAssistTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        return ((FunctionState)object).isExistence();
    }
}

