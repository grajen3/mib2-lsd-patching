/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.search;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearchReply;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;
import org.osgi.framework.BundleContext;

public class DSISearchProvider
extends AbstractProvider
implements DSISearch {
    private static final int[] attributeIDs = new int[]{1, 2, 3};
    private DSISearchProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$search$DSISearch;

    public DSISearchProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$search$DSISearch == null ? (class$org$dsi$ifc$search$DSISearch = DSISearchProvider.class$("org.dsi.ifc.search.DSISearch")) : class$org$dsi$ifc$search$DSISearch).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISearchProxy(this.instance, (DSISearchReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestSupportedCountries() {
        try {
            this.proxy.requestSupportedCountries();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setActiveSearchCountries(String[] stringArray) {
        try {
            this.proxy.setActiveSearchCountries(stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void search(SearchQuery searchQuery) {
        try {
            this.proxy.search(searchQuery);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addToHistory(SearchResult searchResult) {
        try {
            this.proxy.addToHistory(searchResult);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSuggestion(SearchQuery searchQuery) {
        try {
            this.proxy.requestSuggestion(searchQuery);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelQuery(int n) {
        try {
            this.proxy.cancelQuery(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCurrentPosition(NavPosition navPosition) {
        try {
            this.proxy.setCurrentPosition(navPosition);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRoutePoints(NavPosition[] navPositionArray) {
        try {
            this.proxy.setRoutePoints(navPositionArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setActiveProfile(int n) {
        try {
            this.proxy.setActiveProfile(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCarFunctionStates(CarFunction[] carFunctionArray) {
        try {
            this.proxy.setCarFunctionStates(carFunctionArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRadioStations(int n, RadioStation[] radioStationArray) {
        try {
            this.proxy.setRadioStations(n, radioStationArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSearchFilter(int n, SearchFilter searchFilter) {
        try {
            this.proxy.setSearchFilter(n, searchFilter);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void prepareSources(int[] nArray) {
        try {
            this.proxy.prepareSources(nArray);
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
    public void removeFromHistory(long l) {
        try {
            this.proxy.removeFromHistory(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void removeAllFromHistory() {
        try {
            this.proxy.removeAllFromHistory();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void removeAllFromHistoryBySource(int n) {
        try {
            this.proxy.removeAllFromHistoryBySource(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetAutocompletion(int n) {
        try {
            this.proxy.resetAutocompletion(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createBackupFile(String string) {
        try {
            this.proxy.createBackupFile(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importBackupFile(String string) {
        try {
            this.proxy.importBackupFile(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEnvironment(Environment environment) {
        try {
            this.proxy.setEnvironment(environment);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileChange(int n) {
        try {
            this.proxy.profileChange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileCopy(int n, int n2) {
        try {
            this.proxy.profileCopy(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileReset(int n) {
        try {
            this.proxy.profileReset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileResetAll() {
        try {
            this.proxy.profileResetAll();
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

