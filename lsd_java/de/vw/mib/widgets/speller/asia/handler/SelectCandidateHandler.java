/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;

public class SelectCandidateHandler
extends AbstractAsiaStateHandler {
    private String candidate;
    private boolean filtered;
    private boolean immediateSelection;
    private int index;
    private String[] noneFilteredCandidates;

    public SelectCandidateHandler() {
        this(-1, "", false, new String[0], false);
    }

    public SelectCandidateHandler(int n, String string, boolean bl, String[] stringArray, boolean bl2) {
        this.index = n;
        this.candidate = string;
        this.filtered = bl;
        this.noneFilteredCandidates = stringArray;
        this.immediateSelection = bl2;
    }

    public final void setCandidate(String string) {
        this.candidate = string;
    }

    public final void setFiltered(boolean bl) {
        this.filtered = bl;
    }

    public final void setImmediateSelection(boolean bl) {
        this.immediateSelection = bl;
    }

    public final void setIndex(int n) {
        this.index = n;
    }

    public final void setNoneFilteredCandidates(String[] stringArray) {
        this.noneFilteredCandidates = stringArray;
    }

    private int determineToBeSelectedIndex(String[] stringArray, String string) {
        int n = -1;
        if (stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (string == null || !string.equals(stringArray[i2])) continue;
                n = i2;
                break;
            }
        }
        return n;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        int n;
        int n2 = this.immediateSelection ? -1 : (n = this.filtered ? this.determineToBeSelectedIndex(this.noneFilteredCandidates, this.candidate) : this.index);
        if (n >= 0) {
            intObjectMap.put(0, new Integer(n));
        } else if (this.candidate != null && this.candidate.length() > 0) {
            if (!this.immediateSelection && LOGGER.isTraceEnabled(64)) {
                LOGGER.trace(64).append(super.getClass().getName()).append("Unable to determine the candidate index of the selected candidate '").append(this.candidate).append("'!").log();
            }
            intObjectMap.put(100, this.candidate);
        }
        if (!intObjectMap.isEmpty()) {
            asiaStateProxy.getState(32, intObjectMap, this);
        } else {
            this.doGetNextState();
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        this.setCandidate("");
        this.setIndex(-1);
        this.setFiltered(false);
        this.setNoneFilteredCandidates(new String[0]);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        return stringBuilder.append("[index=").append(this.index).append(", candidate='").append(this.candidate).append("']").toString();
    }
}

