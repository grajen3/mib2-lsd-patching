/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asia.internal;

import de.vw.mib.asia.ASLAsiaInput;
import de.vw.mib.asia.AsiaInput;
import de.vw.mib.asia.AsiaInputListener;
import de.vw.mib.asia.AsiaListener;
import de.vw.mib.asia.internal.AsiaInputListenerFw;
import de.vw.mib.threads.AsyncServiceFactory;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

final class AsiaInputFw
implements AsiaInput {
    private final ASLAsiaInput asl_asiaInput;
    private final AsiaInputListenerFw fw_asiaInputListener;

    AsiaInputFw(ASLAsiaInput aSLAsiaInput, AsiaInputListenerFw asiaInputListenerFw, AsyncServiceFactory asyncServiceFactory) {
        this.asl_asiaInput = aSLAsiaInput;
        this.fw_asiaInputListener = asiaInputListenerFw;
        aSLAsiaInput.addAsiaInputListener((AsiaInputListener)asyncServiceFactory.create(this.fw_asiaInputListener));
    }

    @Override
    public void addAsiaListener(AsiaListener asiaListener) {
        this.fw_asiaInputListener.addAsiaListener(asiaListener);
    }

    @Override
    public void addSymbol(char c2) {
        this.asl_asiaInput.requestAddSymbol(c2);
    }

    @Override
    public void addSymbols(String string) {
        this.asl_asiaInput.requestAddSymbols(string);
    }

    @Override
    public void addUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
        this.asl_asiaInput.requestAddUserDefinedEntry(userDefinedEntry);
    }

    @Override
    public void buildCandidates() {
        this.asl_asiaInput.requestBuildCandidates();
    }

    @Override
    public void clear() {
        this.asl_asiaInput.requestClear();
    }

    @Override
    public void clearPredictionContext() {
        this.asl_asiaInput.requestClearPredictionContext();
    }

    @Override
    public void getBooleanParameter(int n) {
        this.asl_asiaInput.requestGetBooleanParameter(n);
    }

    @Override
    public void getCandidates(int n) {
        this.asl_asiaInput.requestGetCandidates(n);
    }

    @Override
    public void getIntParameter(int n) {
        this.asl_asiaInput.requestGetIntParameter(n);
    }

    @Override
    public void getSegmentation(String string) {
        this.asl_asiaInput.requestGetSegmentation(string);
    }

    @Override
    public void getSpelling() {
        this.asl_asiaInput.requestGetSpelling();
    }

    @Override
    public void getStringParameter(int n) {
        this.asl_asiaInput.requestGetStringParameter(n);
    }

    @Override
    public void initialize(int n) {
        this.asl_asiaInput.requestInitialize(n);
    }

    @Override
    public void removeAllSymbols() {
        this.asl_asiaInput.requestRemoveAllSymbols();
    }

    @Override
    public void removeAsiaListener(AsiaListener asiaListener) {
        this.fw_asiaInputListener.removeAsiaListener(asiaListener);
    }

    @Override
    public void removeSymbol() {
        this.asl_asiaInput.requestRemoveSymbol();
    }

    @Override
    public void selectCandidate(int n) {
        this.asl_asiaInput.requestSelectCandidate(n);
    }

    @Override
    public void setAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
        this.asl_asiaInput.requestSetAdditionalWordDatabases(wordDatabaseArray);
    }

    @Override
    public void setBooleanParameter(int n, boolean bl) {
        this.asl_asiaInput.requestSetBooleanParameter(n, bl);
    }

    @Override
    public void setIntParameter(int n, int n2) {
        this.asl_asiaInput.requestSetIntParameter(n, n2);
    }

    @Override
    public void setPredictionContext(String string) {
        this.asl_asiaInput.requestSetPredictionContext(string);
    }

    @Override
    public void setStringParameter(int n, String string) {
        this.asl_asiaInput.requestSetStringParameter(n, string);
    }

    @Override
    public void setUserDatabaseState(int n, int n2) {
        this.asl_asiaInput.requestSetUserDatabaseState(n, n2);
    }
}

