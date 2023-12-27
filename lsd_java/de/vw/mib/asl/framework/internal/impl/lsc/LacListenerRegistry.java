/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.ListenerTools;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.LscController;

public class LacListenerRegistry {
    private final IntSet registeredTargetTypes = new IntOptHashSet();
    private final LscController lscController;
    private final Logger log;
    private static final int SUBCLASSIFIER;

    public LacListenerRegistry(LscController lscController, Logger logger) {
        if (lscController == null) {
            throw new IllegalArgumentException("Parameter >lscController< must not be null!");
        }
        if (logger == null) {
            throw new IllegalArgumentException("Parameter >logger< must not be null!");
        }
        this.lscController = lscController;
        this.log = logger;
    }

    public boolean addAslListener(int n, int n2, String string, int n3, int n4) {
        int n5 = ListenerTools.combine(n, n2);
        boolean bl = this.registeredTargetTypes.add(n5);
        if (bl) {
            this.trace("Registering ASL LAC: ", n);
            this.lscController.addAslListener(n5, n2, string, n3, n4);
        } else {
            this.logInfo("One ASL tried to register as LAC twice: ", n);
        }
        return bl;
    }

    public boolean removeAslListener(int n, int n2) {
        int n3 = ListenerTools.combine(n, n2);
        boolean bl = this.registeredTargetTypes.remove(n3);
        if (bl) {
            this.trace("Removing ASL LAC: ", n);
            this.lscController.removeAslListener(n3);
        } else {
            this.logInfo("One ASL-LAC tried to unregister but was not registered: ", n);
        }
        return bl;
    }

    private void logInfo(String string, int n) {
        this.log.info(64).append("[AslTargetLscTNGBullhorn]").append(string).append(n).log();
    }

    private void trace(String string, int n) {
        if (this.log.isTraceEnabled(64)) {
            this.log.trace(64).append(string).append(n).log();
        }
    }
}

