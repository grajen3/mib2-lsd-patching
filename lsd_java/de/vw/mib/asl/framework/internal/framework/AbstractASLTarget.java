/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractASLTarget
extends AbstractTarget {
    public AbstractASLTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AbstractASLTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    public AbstractASLTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
    }

    public void sendHMIEvent(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 2;
    }

    public static void writeBooleanToDatapool(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public static void writeIntegerToDatapool(int n, int n2) {
        ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
    }

    public static void writeLongToDatapool(int n, long l) {
        ServiceManager.aslPropertyManager.valueChangedLong(n, l);
    }

    public static void writeStringToDatapool(int n, String string) {
        ServiceManager.aslPropertyManager.valueChangedString(n, string);
    }

    public static void writeFlagVectorToDatapool(int n, boolean[] blArray) {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(n, blArray);
    }

    public static void writeIntegerArrayToDatapool(int n, int[] nArray) {
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(n, nArray);
    }

    public static void writeImageToDatapool(int n, ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(n, resourceLocator);
    }

    public static void writeSpellerDataToDatapool(int n, SpellerData spellerData) {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(n, spellerData);
    }
}

