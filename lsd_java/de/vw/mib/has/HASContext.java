/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASContextProperties;
import de.vw.mib.has.HASContextResults;
import de.vw.mib.has.HASContextServices;
import de.vw.mib.has.HASContextStates;

public final class HASContext {
    private final String contextName;
    private final HASContextStates contextStates;
    private final HASContextProperties propertiesImpl;
    private final HASContextResults resultsImpl;
    private final HASContextServices defaultServicesImpl;
    private HASContextServices servicesImpl;

    public HASContext(String string, HASContextStates hASContextStates, HASContextProperties hASContextProperties, HASContextResults hASContextResults, HASContextServices hASContextServices) {
        this.contextName = string;
        this.contextStates = hASContextStates;
        this.propertiesImpl = hASContextProperties;
        this.resultsImpl = hASContextResults;
        this.defaultServicesImpl = hASContextServices;
        this.servicesImpl = hASContextServices;
    }

    public String getContextName() {
        return this.contextName;
    }

    public int getContextState() {
        return this.contextStates.getContextState(this.contextName);
    }

    public void setContextState(int n) {
        this.contextStates.updateContextState(this.contextName, n);
    }

    public HASContextProperties getPropertiesImpl() {
        return this.propertiesImpl;
    }

    public HASContextResults getResultsImpl() {
        return this.resultsImpl;
    }

    public HASContextServices getServicesImpl() {
        return this.servicesImpl;
    }

    public void setServicesImpl(HASContextServices hASContextServices) {
        HASContextServices hASContextServices2 = this.servicesImpl = null != hASContextServices ? hASContextServices : this.defaultServicesImpl;
        if (0 == this.contextStates.getContextState(this.contextName)) {
            this.contextStates.updateContextState(this.contextName, 2);
        }
    }

    public boolean isContextReady() {
        return this.servicesImpl != this.defaultServicesImpl && 2 == this.contextStates.getContextState(this.contextName);
    }
}

