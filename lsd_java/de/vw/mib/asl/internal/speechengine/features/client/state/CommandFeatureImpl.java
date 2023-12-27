/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.complex.ComplexCommandFeature;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.CommandStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class CommandFeatureImpl
extends AbstractGenericFeature
implements CommandStateFeature,
ComplexCommandFeature {
    private Command[] commandsToLoad;
    private Command[] commandsToUnload;

    public CommandFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    @Override
    public void setCommandsToLoad(Command[] commandArray) {
        this.commandsToLoad = commandArray;
    }

    @Override
    public void setCommandsToUnload(Command[] commandArray) {
        this.commandsToUnload = commandArray;
    }

    @Override
    public boolean isCommandsToLoadValid() {
        return this.commandsToLoad != null && this.commandsToLoad.length != 0;
    }

    @Override
    public boolean isCommandsToUnloadValid() {
        return this.commandsToUnload != null && this.commandsToUnload.length != 0;
    }

    @Override
    public Command[] getCommandsToLoad() {
        return this.commandsToLoad;
    }

    @Override
    public Command[] getCommandsToUnload() {
        return this.commandsToUnload;
    }

    @Override
    public int getFeatureType() {
        return 302;
    }
}

