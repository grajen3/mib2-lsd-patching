/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.handler;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.handler.AbstractAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import org.dsi.ifc.asiainput.UserDefinedEntry;

public class HiraganaAddUserDefinedEntryHandler
extends AbstractAsiaStateHandler {
    String preCandidateSelectionSpelling = "";
    String selectedCandidate = "";
    AsiaSpellerModel speller;

    public void setPreCandidateSelectionSpelling(String string) {
        this.preCandidateSelectionSpelling = string;
    }

    public void setSelectedCandidate(String string) {
        this.selectedCandidate = string;
    }

    public void setSpeller(AsiaSpellerModel asiaSpellerModel) {
        this.speller = asiaSpellerModel;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, IntObjectMap intObjectMap, AsiaDatabase asiaDatabase) {
        if (this.preCandidateSelectionSpelling.length() > 0 && this.speller != null) {
            UserDefinedEntry userDefinedEntry;
            String string = this.speller.getSpelling();
            if (string.length() > 0) {
                String string2 = this.determineReplacedSpelling(string);
                userDefinedEntry = new UserDefinedEntry(this.selectedCandidate, string2);
            } else {
                userDefinedEntry = new UserDefinedEntry(this.selectedCandidate, this.preCandidateSelectionSpelling);
            }
            intObjectMap.put(0, userDefinedEntry);
            asiaStateProxy.getState(128, intObjectMap, this);
        } else {
            this.doGetNextState();
        }
        this.cleanInternalState();
    }

    private String determineReplacedSpelling(String string) {
        int n = this.preCandidateSelectionSpelling.indexOf(string);
        String string2 = this.preCandidateSelectionSpelling.substring(0, n);
        return string2;
    }

    private void cleanInternalState() {
        this.preCandidateSelectionSpelling = "";
        this.selectedCandidate = "";
        this.speller = null;
    }
}

