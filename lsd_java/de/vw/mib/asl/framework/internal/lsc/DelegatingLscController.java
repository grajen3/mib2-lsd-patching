/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.framework.internal.lsc.LscListenerItem;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.LscController;
import de.vw.mib.lsctng.LscListener;
import java.util.ArrayList;

public class DelegatingLscController
implements LscController {
    private final Logger logger;
    private LscController delegateLscController;
    private ArrayList lscListenerItems;

    public DelegatingLscController(Logger logger) {
        this.logger = logger;
        this.lscListenerItems = new ArrayList();
    }

    public void setDelegate(LscController lscController) {
        this.delegateLscController = lscController;
        this.addCachedListenersToLscController();
    }

    public boolean isInitialized() {
        return this.delegateLscController != null;
    }

    @Override
    public void addHighPrioListener(LscListener lscListener, int n, String string, int n2, int n3) {
        if (this.isInitialized()) {
            this.delegateLscController.addHighPrioListener(lscListener, n, string, n2, n3);
        } else {
            this.logger.error(64).append("Cannot add high prio listener since framework LSCController is not available yet.").log();
        }
    }

    @Override
    public void addListener(LscListener lscListener, int n, String string, int n2, int n3) {
        if (this.isInitialized()) {
            this.delegateLscController.addListener(lscListener, n, string, n2, n3);
        } else {
            this.logger.error(64).append("Cannot add listener since framework LSCController is not available yet.").log();
        }
    }

    @Override
    public void addAslListener(int n, int n2, String string, int n3, int n4) {
        if (this.isInitialized()) {
            this.delegateLscController.addAslListener(n, n2, string, n3, n4);
        } else {
            this.logger.warn(64).append("Cannot add Aslistener since framework LSCController is not available yet.").log();
            this.lscListenerItems.add(new LscListenerItem(n, n2, string, n3, n4));
        }
    }

    @Override
    public void removeListener(LscListener lscListener) {
        if (this.isInitialized()) {
            this.delegateLscController.removeListener(lscListener);
        } else {
            this.logger.error(64).append("Cannot remove listener since framework LSCController is not available yet.").log();
        }
    }

    @Override
    public void removeAslListener(int n) {
        if (this.isInitialized()) {
            this.delegateLscController.removeAslListener(n);
        } else {
            this.logger.error(64).append("Cannot remove AslListener since framework LSCController is not available yet.").log();
            LscListenerItem lscListenerItem = this.findLscListenerItem(n);
            if (lscListenerItem != null) {
                this.lscListenerItems.remove(lscListenerItem);
            }
        }
    }

    @Override
    public void initialChangeTo(String string, int n, int n2) {
        if (this.isInitialized()) {
            this.delegateLscController.initialChangeTo(string, n, n2);
        } else {
            this.logger.error(64).append("Cannot initialChangeTo since framework LSCController is not available yet.").log();
        }
    }

    @Override
    public void changeTo(String string, int n, int n2) {
        if (this.isInitialized()) {
            this.delegateLscController.changeTo(string, n, n2);
        } else {
            this.logger.error(64).append("Cannot initLanguage since framework LSCController is not available yet.").log();
        }
    }

    ArrayList getLscListenerItems() {
        return this.lscListenerItems;
    }

    private LscListenerItem findLscListenerItem(int n) {
        for (int i2 = 0; i2 < this.lscListenerItems.size(); ++i2) {
            LscListenerItem lscListenerItem = (LscListenerItem)this.lscListenerItems.get(i2);
            if (lscListenerItem.getAslId() != n) continue;
            return lscListenerItem;
        }
        return null;
    }

    private void addCachedListenersToLscController() {
        for (int i2 = 0; i2 < this.lscListenerItems.size(); ++i2) {
            LscListenerItem lscListenerItem = (LscListenerItem)this.lscListenerItems.get(i2);
            this.delegateLscController.addAslListener(lscListenerItem.getAslId(), lscListenerItem.getListenerType(), lscListenerItem.getInitLanguage(), lscListenerItem.getInitSkin(), lscListenerItem.getInitSkinmode());
        }
        this.lscListenerItems.clear();
    }
}

