/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.sm.internal.journal.SmJournalEx;

public class SmJournalExChain
extends SmJournalEx {
    SmJournalEx[] chainLinks = new SmJournalEx[0];

    SmJournalExChain(SmJournalEx[] smJournalExArray) {
        this.chainLinks = smJournalExArray;
    }

    @Override
    public void managerStarted() {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].managerStarted();
        }
    }

    @Override
    public void managerFinished() {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].managerFinished();
        }
    }

    @Override
    public void eventProcessing(int n, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].eventProcessing(n, s);
        }
    }

    @Override
    public void eventProcessed(int n, boolean bl) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].eventProcessed(n, bl);
        }
    }

    @Override
    public void eventSkipped(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].eventSkipped(n);
        }
    }

    @Override
    public void eventForwardingToStatemachine(int n, int n2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].eventForwardingToStatemachine(n, n2);
        }
    }

    @Override
    public void checkpoint(char c2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].checkpoint(c2);
        }
    }

    @Override
    public void fatalError(int n, int n2, short s, RuntimeException runtimeException) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].fatalError(n, n2, s, runtimeException);
        }
    }

    @Override
    public void activatorChecking(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].activatorChecking(n);
        }
    }

    @Override
    public void activatorChecked(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].activatorChecked(n);
        }
    }

    @Override
    public void deactivatorChecking(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].deactivatorChecking(n);
        }
    }

    @Override
    public void deactivatorChecked(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].deactivatorChecked(n);
        }
    }

    @Override
    public void statemachineActivating(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].statemachineActivating(n);
        }
    }

    @Override
    public void statemachineActivated(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].statemachineActivated(n);
        }
    }

    @Override
    public void statemachineDeactivating(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].statemachineDeactivating(n);
        }
    }

    @Override
    public void statemachineDeactivated(int n) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].statemachineDeactivated(n);
        }
    }

    @Override
    public void internalTransitionPerforming(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].internalTransitionPerforming(n, n2, s, s2);
        }
    }

    @Override
    public void internalTransitionActing(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].internalTransitionActing(n, n2, s, s2);
        }
    }

    @Override
    public void internalTransitionActed(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].internalTransitionActed(n, n2, s, s2);
        }
    }

    @Override
    public void internalTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].internalTransitionPerformed(n, n2, s, s2, bl);
        }
    }

    @Override
    public void triggeredTransitionPerforming(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].triggeredTransitionPerforming(n, n2, s, s2);
        }
    }

    @Override
    public void triggeredTransitionActing(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].triggeredTransitionActing(n, n2, s, s2);
        }
    }

    @Override
    public void triggeredTransitionActed(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].triggeredTransitionActed(n, n2, s, s2);
        }
    }

    @Override
    public void triggeredTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].triggeredTransitionPerformed(n, n2, s, s2, bl);
        }
    }

    @Override
    public void untriggeredTransitionPerforming(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].untriggeredTransitionPerforming(n, n2, s, s2);
        }
    }

    @Override
    public void untriggeredTransitionActing(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].untriggeredTransitionActing(n, n2, s, s2);
        }
    }

    @Override
    public void untriggeredTransitionActed(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].untriggeredTransitionActed(n, n2, s, s2);
        }
    }

    @Override
    public void untriggeredTransitionPerformed(int n, int n2, short s, short s2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].untriggeredTransitionPerformed(n, n2, s, s2);
        }
    }

    @Override
    public void subStatemachineActivating(int n, int n2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].subStatemachineActivating(n, n2);
        }
    }

    @Override
    public void subStatemachineActivated(int n, int n2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].subStatemachineActivated(n, n2);
        }
    }

    @Override
    public void subStatemachineDeactivating(int n, int n2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].subStatemachineDeactivating(n, n2);
        }
    }

    @Override
    public void subStatemachineDeactivated(int n, int n2) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].subStatemachineDeactivated(n, n2);
        }
    }

    @Override
    public void stateEntryActing(int n, int n2, short s, boolean bl) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateEntryActing(n, n2, s, bl);
        }
    }

    @Override
    public void stateEntryActed(int n, int n2, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateEntryActed(n, n2, s);
        }
    }

    @Override
    public void stateExitActing(int n, int n2, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateExitActing(n, n2, s);
        }
    }

    @Override
    public void stateExitActed(int n, int n2, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateExitActed(n, n2, s);
        }
    }

    @Override
    public void stateFocusGainedActing(int n, int n2, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateFocusGainedActing(n, n2, s);
        }
    }

    @Override
    public void stateFocusGainedActed(int n, int n2, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateFocusGainedActed(n, n2, s);
        }
    }

    @Override
    public void stateFocusLostActing(int n, int n2, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateFocusLostActing(n, n2, s);
        }
    }

    @Override
    public void stateFocusLostActed(int n, int n2, short s) {
        for (int i2 = 0; i2 < this.chainLinks.length; ++i2) {
            this.chainLinks[i2].stateFocusLostActed(n, n2, s);
        }
    }
}

