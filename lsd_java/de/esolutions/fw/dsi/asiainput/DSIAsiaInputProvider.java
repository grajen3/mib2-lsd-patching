/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.asiainput;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.asiainput.DSIAsiaInputReply;
import de.esolutions.fw.comm.dsi.asiainput.impl.DSIAsiaInputProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.asiainput.DSIAsiaInput;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;
import org.osgi.framework.BundleContext;

public class DSIAsiaInputProvider
extends AbstractProvider
implements DSIAsiaInput {
    private static final int[] attributeIDs = new int[0];
    private DSIAsiaInputProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$DSIAsiaInput;

    public DSIAsiaInputProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$asiainput$DSIAsiaInput == null ? (class$org$dsi$ifc$asiainput$DSIAsiaInput = DSIAsiaInputProvider.class$("org.dsi.ifc.asiainput.DSIAsiaInput")) : class$org$dsi$ifc$asiainput$DSIAsiaInput).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIAsiaInputProxy(this.instance, (DSIAsiaInputReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void initialize(int n) {
        try {
            this.proxy.initialize(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addSymbol(char c2) {
        try {
            this.proxy.addSymbol(c2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addSymbols(String string) {
        try {
            this.proxy.addSymbols(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void removeSymbol() {
        try {
            this.proxy.removeSymbol();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void removeAllSymbols() {
        try {
            this.proxy.removeAllSymbols();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clear() {
        try {
            this.proxy.clear();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void buildCandidates() {
        try {
            this.proxy.buildCandidates();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getSpelling() {
        try {
            this.proxy.getSpelling();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getCandidates(int n) {
        try {
            this.proxy.getCandidates(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void selectCandidate(int n) {
        try {
            this.proxy.selectCandidate(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBooleanParameter(int n, boolean bl) {
        try {
            this.proxy.setBooleanParameter(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntParameter(int n, int n2) {
        try {
            this.proxy.setIntParameter(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getBooleanParameter(int n) {
        try {
            this.proxy.getBooleanParameter(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getIntParameter(int n) {
        try {
            this.proxy.getIntParameter(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getVersionInfo() {
        try {
            this.proxy.getVersionInfo();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setStringParameter(int n, String string) {
        try {
            this.proxy.setStringParameter(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getStringParameter(int n) {
        try {
            this.proxy.getStringParameter(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPredictionContext(String string) {
        try {
            this.proxy.setPredictionContext(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearPredictionContext() {
        try {
            this.proxy.clearPredictionContext();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
        try {
            this.proxy.addUserDefinedEntry(userDefinedEntry);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAdditionalWordDatabases(WordDatabase[] wordDatabaseArray) {
        try {
            this.proxy.setAdditionalWordDatabases(wordDatabaseArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setUserDatabaseState(int n, int n2) {
        try {
            this.proxy.setUserDatabaseState(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetToFactorySettings() {
        try {
            this.proxy.resetToFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getSegmentation(String string) {
        try {
            this.proxy.getSegmentation(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSegmentationForTruffles(String string) {
        try {
            this.proxy.requestSegmentationForTruffles(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
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

