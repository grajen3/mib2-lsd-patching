/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.testmode.GEMExchange;
import de.vw.mib.asl.internal.testmode.HsmTestmode$1;
import de.vw.mib.asl.internal.testmode.HsmTestmode$2;
import de.vw.mib.asl.internal.testmode.HsmTestmode$3;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.Dictionary;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class HsmTestmode
extends AbstractASLHsmTarget {
    private static final String LOGGING_DELIM;
    private ServiceRegistration mHmiGemExchangeRef = null;
    private Dictionary serviceProperties = null;
    static final int ACTIVATED;
    private static final int INSTANCE_ID_HMI_GEM_EXCHANGE;
    private static final String DEVICE_NAME_HMI_GEM_EXCHANGE;
    protected final HsmState stateWork = new HsmTestmode$1(this, this.hsm, "stateWork", this.getWorkStateParent());
    protected final HsmState stateTestmodeInactive = new HsmTestmode$2(this, this.hsm, "stateTestmodeInactive", this.stateWork);
    protected final HsmState stateTestmodeActive = new HsmTestmode$3(this, this.hsm, "stateTestmodeActive", this.stateWork);
    static /* synthetic */ Class class$org$dsi$ifc$persistence$DSIPersistence;

    public HsmTestmode(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public HsmTestmode(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 64;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    void registerGEMService() {
        if (this.mHmiGemExchangeRef == null) {
            GEMExchange gEMExchange = new GEMExchange();
            if (this.serviceProperties == null) {
                this.serviceProperties = new Hashtable();
                this.serviceProperties.put("DEVICE_NAME", "GEM_HMI_Exchange");
                this.serviceProperties.put("DEVICE_INSTANCE", new Integer(7));
            }
            this.mHmiGemExchangeRef = ServiceManager.bundleContext.registerService((class$org$dsi$ifc$persistence$DSIPersistence == null ? (class$org$dsi$ifc$persistence$DSIPersistence = HsmTestmode.class$("org.dsi.ifc.persistence.DSIPersistence")) : class$org$dsi$ifc$persistence$DSIPersistence).getName(), (Object)gEMExchange, this.serviceProperties);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -254733056;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

