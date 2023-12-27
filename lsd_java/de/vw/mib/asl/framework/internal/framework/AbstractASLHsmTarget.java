/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget$ASLHsmBaseStateActive;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget$ASLHsmBaseStateInactive;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget$ASLHsmBaseStateTop;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.ResourceLocator;

public abstract class AbstractASLHsmTarget
extends TargetHsmImpl {
    protected final HsmState stateTop;
    protected final HsmState stateInactive;
    protected final HsmState stateActive;

    protected abstract HsmState getDefaultState() {
    }

    public HsmState getWorkStateParent() {
        return this.stateActive;
    }

    public AbstractASLHsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents);
        this.stateTop = new AbstractASLHsmTarget$ASLHsmBaseStateTop(this, this.hsm, "Top", null);
        this.stateInactive = new AbstractASLHsmTarget$ASLHsmBaseStateInactive(this, this.hsm, "Inactive", this.stateTop);
        this.stateActive = new AbstractASLHsmTarget$ASLHsmBaseStateActive(this, this.hsm, "Active", this.stateTop);
        this.startHsmAndRegisterTarget(genericEvents, this.getDefaultTargetId(), string, this.stateTop);
    }

    public AbstractASLHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents);
        this.stateTop = new AbstractASLHsmTarget$ASLHsmBaseStateTop(this, this.hsm, "Top", null);
        this.stateInactive = new AbstractASLHsmTarget$ASLHsmBaseStateInactive(this, this.hsm, "Inactive", this.stateTop);
        this.stateActive = new AbstractASLHsmTarget$ASLHsmBaseStateActive(this, this.hsm, "Active", this.stateTop);
        this.startHsmAndRegisterTarget(genericEvents, n, string, this.stateTop);
    }

    public final void sendHMIEvent(int n) {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(n);
    }

    public static final void writeIntegerToDatapool(int n, int n2) {
        ServiceManager.aslPropertyManager.valueChangedInteger(n, n2);
    }

    public static final void writeBooleanToDatapool(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public static final void writeStringToDatapool(int n, String string) {
        ServiceManager.aslPropertyManager.valueChangedString(n, string);
    }

    public static final void writeResourceLocatorToDatapool(int n, ResourceLocator resourceLocator) {
        ServiceManager.aslPropertyManager.valueChangedResourceLocator(n, resourceLocator);
    }

    public static final void writeFlagVectorToDatapool(int n, boolean[] blArray) {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(n, blArray);
    }

    public static final void writeIntegerArrayToDatapool(int n, int[] nArray) {
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(n, nArray);
    }

    public static final void writeSpellerDataToDatapool(int n, SpellerData spellerData) {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(n, spellerData);
    }

    public void sendInternalEvent(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), n, n2);
        try {
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.getTextLogger().error(2).attachThrowable(genericEventException).log();
        }
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    @Override
    public int getSubClassifier() {
        return 2;
    }
}

