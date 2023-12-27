/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.internal.impl.system.factoryreset.ComponentParticipantsMap;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetExecutionParticipantData;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetServiceImpl$1;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetServiceImpl$2;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetServiceImpl$3;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback;
import de.vw.mib.asl.internal.system.util.AsyncServiceListeners;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class FactoryResetServiceImpl
implements FactoryResetService {
    static final long MAX_EXPECTED_TIMEOUT;
    static final long MIN_VALID_TIMEOUT;
    private static final String COMPONENT_NAME_GLOBAL_PARTICIPANTS;
    private final FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback componentParticipantCallback = this.createComponentParticipantCallback();
    private final ComponentParticipantsMap componentParticipants;
    private LinkedList componentsToReset;
    private int currentTrigger;
    private final FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback globalParticipantCallBack = this.createGlobalParticipantCallback();
    private final HashSet globalParticipants;
    private final AsyncServiceListeners listeners;
    private final Logger logger;
    private final FactoryResetTimeoutManager timeoutManager;

    FactoryResetServiceImpl(AsyncServiceFactory asyncServiceFactory, Logger logger, FactoryResetTimeoutManager factoryResetTimeoutManager) {
        Preconditions.checkArgumentNotNull(asyncServiceFactory);
        Preconditions.checkArgumentNotNull(logger);
        Preconditions.checkArgumentNotNull(factoryResetTimeoutManager);
        this.componentParticipants = new ComponentParticipantsMap();
        this.globalParticipants = new HashSet();
        this.listeners = new AsyncServiceListeners(asyncServiceFactory, logger);
        this.timeoutManager = factoryResetTimeoutManager;
        this.logger = logger;
    }

    @Override
    public void addGlobalParticipant(FactoryResetParticipant factoryResetParticipant) {
        Preconditions.checkArgumentNotNull(factoryResetParticipant);
        this.checkParticipantTimeout(factoryResetParticipant);
        if (!this.globalParticipants.add(factoryResetParticipant)) {
            throw new IllegalArgumentException(new StringBuffer().append("Participant >").append(factoryResetParticipant).append("< already registered.").toString());
        }
    }

    @Override
    public void addListener(FactoryResetListener factoryResetListener) {
        this.listeners.addListener(factoryResetListener);
    }

    @Override
    public void addParticipant(FactoryResetParticipant factoryResetParticipant, FactoryResetComponent factoryResetComponent) {
        Preconditions.checkArgumentNotNull(factoryResetParticipant, "Argument >participant< must not be null!");
        Preconditions.checkArgumentNotNull(factoryResetComponent, "Argument >component< must not be null!");
        this.checkLocalParticipantNotKnown(factoryResetParticipant, factoryResetComponent);
        this.checkParticipantTimeout(factoryResetParticipant);
        this.componentParticipants.put(factoryResetComponent, factoryResetParticipant);
    }

    @Override
    public int getFactoryResetState() {
        return this.componentsToReset == null ? 0 : 1;
    }

    @Override
    public void removeGlobalParticipant(FactoryResetParticipant factoryResetParticipant) {
        this.globalParticipants.remove(factoryResetParticipant);
    }

    @Override
    public void removeListener(FactoryResetListener factoryResetListener) {
        this.listeners.removeListener(factoryResetListener);
    }

    @Override
    public void removeParticipant(FactoryResetParticipant factoryResetParticipant, FactoryResetComponent factoryResetComponent) {
        this.componentParticipants.remove(factoryResetComponent, factoryResetParticipant);
    }

    @Override
    public void reset(FactoryResetComponent factoryResetComponent, int n) {
        Preconditions.checkArgumentNotNull(factoryResetComponent, "Argument >component< must not be null!");
        this.checkTrigger(n);
        Preconditions.checkState(this.isStateNotRunning(), "Another reset is already in progress.");
        Preconditions.checkState(this.timeoutManager.isIdle(), "Internal error. Another component reset is still in progress.");
        this.logInfo(new StringBuffer().append("Starting a reset for component >").append(factoryResetComponent.getName()).append("< with trigger >").append(n).append("<.").toString());
        this.componentsToReset = this.retrieveComponentWithChildrenInPreorderedList(factoryResetComponent);
        this.currentTrigger = n;
        if (!this.hasResetParticipants(this.componentsToReset)) {
            this.componentsToReset = null;
            return;
        }
        this.performListenerNotification(1);
        this.resetNextComponent();
    }

    void performPostResetActions() {
        this.logInfo("Factory reset finished.");
        this.componentsToReset = null;
        this.performListenerNotification(0);
    }

    void resetNextComponent() {
        Preconditions.checkState(!this.isStateNotRunning(), "Unexpeckted callback. No reset in progress.");
        Preconditions.checkState(this.timeoutManager.isIdle(), "Unexpected callback. Another component reset is still in progress.");
        FactoryResetExecutionParticipantData factoryResetExecutionParticipantData = this.findNextComponentWithParticipants();
        if (factoryResetExecutionParticipantData != null) {
            this.timeoutManager.reset(factoryResetExecutionParticipantData, this.componentParticipantCallback);
        } else {
            this.performGlobalParticipantResetNotification();
        }
    }

    private void checkLocalParticipantNotKnown(FactoryResetParticipant factoryResetParticipant, FactoryResetComponent factoryResetComponent) {
        if (this.componentParticipants.containsEntry(factoryResetComponent, factoryResetParticipant)) {
            throw new IllegalArgumentException(new StringBuffer().append("Participant >").append(factoryResetParticipant).append("< already registered for component >").append(factoryResetComponent).append("<.").toString());
        }
    }

    private void checkParticipantTimeout(FactoryResetParticipant factoryResetParticipant) {
        long l = factoryResetParticipant.getTimeout();
        if (l < 1L) {
            throw new IllegalArgumentException("The timeout of your factory reset participant is lower than 1ms.");
        }
        if (l > 0) {
            String string = new StringBuffer().append("Participant >").append(super.getClass().getName()).append("< has a very high reset timeout of >").append(l).append("< set.").toString();
            this.logger.warn(2048, string);
        }
    }

    private void checkTrigger(int n) {
        boolean bl;
        boolean bl2 = n == 1;
        boolean bl3 = bl = n == 0;
        if (!bl2 && !bl) {
            String string = new StringBuffer().append("Argument >trigger< must be FactoryResetParticipant.TRIGGERED_BY_USER or FactoryResetParticipant.TRIGGERED_BY_DIAGNOSIS_REMOTE_CONTROL! Got: ").append(n).toString();
            throw new IllegalArgumentException(string);
        }
    }

    private FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback createComponentParticipantCallback() {
        return new FactoryResetServiceImpl$1(this);
    }

    private FactoryResetTimeoutManager$FactoryResetTimeoutManagerCallback createGlobalParticipantCallback() {
        return new FactoryResetServiceImpl$2(this);
    }

    private FactoryResetExecutionParticipantData findNextComponentWithParticipants() {
        while (!this.componentsToReset.isEmpty()) {
            FactoryResetComponent factoryResetComponent = (FactoryResetComponent)this.componentsToReset.removeFirst();
            FactoryResetParticipant[] factoryResetParticipantArray = this.componentParticipants.get(factoryResetComponent);
            if (factoryResetParticipantArray.length <= 0) continue;
            return new FactoryResetExecutionParticipantData(this.currentTrigger, factoryResetComponent.getName(), factoryResetParticipantArray);
        }
        return null;
    }

    private boolean hasResetParticipants(LinkedList linkedList) {
        if (!this.globalParticipants.isEmpty()) {
            return true;
        }
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            FactoryResetComponent factoryResetComponent = (FactoryResetComponent)iterator.next();
            if (!this.componentParticipants.hasParticipants(factoryResetComponent)) continue;
            return true;
        }
        return false;
    }

    private boolean isStateNotRunning() {
        return this.getFactoryResetState() == 0;
    }

    private void logInfo(String string) {
        this.logger.info(2048, new StringBuffer().append("[FactoryResetServiceImpl] ").append(string).toString());
    }

    private void performGlobalParticipantResetNotification() {
        if (!this.globalParticipants.isEmpty()) {
            FactoryResetParticipant[] factoryResetParticipantArray = (FactoryResetParticipant[])this.globalParticipants.toArray(new FactoryResetParticipant[this.globalParticipants.size()]);
            FactoryResetExecutionParticipantData factoryResetExecutionParticipantData = new FactoryResetExecutionParticipantData(this.currentTrigger, "Global Participants", factoryResetParticipantArray);
            this.timeoutManager.reset(factoryResetExecutionParticipantData, this.globalParticipantCallBack);
        } else {
            this.performPostResetActions();
        }
    }

    private void performListenerNotification(int n) {
        this.listeners.notifyListeners(new FactoryResetServiceImpl$3(this, n));
    }

    private LinkedList retrieveComponentWithChildrenInPreorderedList(FactoryResetComponent factoryResetComponent) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(factoryResetComponent);
        FactoryResetComponent[] factoryResetComponentArray = factoryResetComponent.getChildren();
        for (int i2 = 0; i2 < factoryResetComponentArray.length; ++i2) {
            FactoryResetComponent factoryResetComponent2 = factoryResetComponentArray[i2];
            linkedList.addAll(this.retrieveComponentWithChildrenInPreorderedList(factoryResetComponent2));
        }
        return linkedList;
    }
}

