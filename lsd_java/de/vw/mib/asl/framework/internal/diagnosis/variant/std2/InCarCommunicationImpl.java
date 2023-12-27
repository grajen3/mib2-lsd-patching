/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.std2;

import de.vw.mib.asl.framework.api.diagnosis.config.InCarCommunication;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class InCarCommunicationImpl
extends AccessImpl
implements InCarCommunication {
    public InCarCommunicationImpl(byte[] byArray) {
        super(byArray, new int[]{254}, 906042371, 0);
        this.mConfiguration = new int[]{30029, 2000, 0, 0, -1, -1, 20051, 8, 250, 0, 0, -1, 20051, 8, 251, 0, 0, -1, 20051, 8, 252, 0, 0, -1, 20051, 8, 253, 0, 0, -1, 14, 128, 128, 1150, 6, 1152, 18, 128, 128, 1149, 0, 1151, 12, 1153, 24, 30};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

