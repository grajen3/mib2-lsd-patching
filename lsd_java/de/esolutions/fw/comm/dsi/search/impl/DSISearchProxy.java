/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearch;
import de.esolutions.fw.comm.dsi.search.DSISearchC;
import de.esolutions.fw.comm.dsi.search.DSISearchReply;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$1;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$2;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$3;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$4;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$5;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$6;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$7;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$8;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchProxy$9;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.search.CarFunction;
import org.dsi.ifc.search.Environment;
import org.dsi.ifc.search.NavPosition;
import org.dsi.ifc.search.RadioStation;
import org.dsi.ifc.search.SearchFilter;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public class DSISearchProxy
implements DSISearch,
DSISearchC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.search.DSISearch");
    private Proxy proxy;

    public DSISearchProxy(int n, DSISearchReply dSISearchReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c469770f-e781-5ef2-b4fe-b3a26ea25678", n, "ccd602ee-e33a-5d8a-a861-5faa95593df6", "dsi.search.DSISearch");
        DSISearchReplyService dSISearchReplyService = new DSISearchReplyService(dSISearchReply);
        this.proxy = new Proxy(serviceInstanceID, dSISearchReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestSupportedCountries() {
        this.proxy.remoteCallMethod((short)10, null);
    }

    @Override
    public void setActiveSearchCountries(String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void search(SearchQuery searchQuery) {
        DSISearchProxy$1 dSISearchProxy$1 = new DSISearchProxy$1(this, searchQuery);
        this.proxy.remoteCallMethod((short)92, dSISearchProxy$1);
    }

    @Override
    public void addToHistory(SearchResult searchResult) {
        DSISearchProxy$2 dSISearchProxy$2 = new DSISearchProxy$2(this, searchResult);
        this.proxy.remoteCallMethod((short)96, dSISearchProxy$2);
    }

    @Override
    public void requestSuggestion(SearchQuery searchQuery) {
        DSISearchProxy$3 dSISearchProxy$3 = new DSISearchProxy$3(this, searchQuery);
        this.proxy.remoteCallMethod((short)91, dSISearchProxy$3);
    }

    @Override
    public void cancelQuery(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void setCurrentPosition(NavPosition navPosition) {
        DSISearchProxy$4 dSISearchProxy$4 = new DSISearchProxy$4(this, navPosition);
        this.proxy.remoteCallMethod((short)42, dSISearchProxy$4);
    }

    @Override
    public void setRoutePoints(NavPosition[] navPositionArray) {
        DSISearchProxy$5 dSISearchProxy$5 = new DSISearchProxy$5(this, navPositionArray);
        this.proxy.remoteCallMethod((short)43, dSISearchProxy$5);
    }

    @Override
    public void setLanguage(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setActiveProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setCarFunctionStates(CarFunction[] carFunctionArray) {
        DSISearchProxy$6 dSISearchProxy$6 = new DSISearchProxy$6(this, carFunctionArray);
        this.proxy.remoteCallMethod((short)18, dSISearchProxy$6);
    }

    @Override
    public void setRadioStations(int n, RadioStation[] radioStationArray) {
        DSISearchProxy$7 dSISearchProxy$7 = new DSISearchProxy$7(this, n, radioStationArray);
        this.proxy.remoteCallMethod((short)59, dSISearchProxy$7);
    }

    @Override
    public void setSearchFilter(int n, SearchFilter searchFilter) {
        DSISearchProxy$8 dSISearchProxy$8 = new DSISearchProxy$8(this, n, searchFilter);
        this.proxy.remoteCallMethod((short)107, dSISearchProxy$8);
    }

    @Override
    public void prepareSources(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    @Override
    public void resetToFactorySettings() {
        this.proxy.remoteCallMethod((short)37, null);
    }

    @Override
    public void removeFromHistory(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)50, genericSerializable);
    }

    @Override
    public void removeAllFromHistory() {
        this.proxy.remoteCallMethod((short)61, null);
    }

    @Override
    public void removeAllFromHistoryBySource(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)93, genericSerializable);
    }

    @Override
    public void resetAutocompletion(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)53, genericSerializable);
    }

    @Override
    public void createBackupFile(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }

    @Override
    public void importBackupFile(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)65, genericSerializable);
    }

    @Override
    public void setEnvironment(Environment environment) {
        DSISearchProxy$9 dSISearchProxy$9 = new DSISearchProxy$9(this, environment);
        this.proxy.remoteCallMethod((short)95, dSISearchProxy$9);
    }

    @Override
    public void profileChange(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)98, genericSerializable);
    }

    @Override
    public void profileCopy(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)101, genericSerializable);
    }

    @Override
    public void profileReset(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)102, genericSerializable);
    }

    @Override
    public void profileResetAll() {
        this.proxy.remoteCallMethod((short)104, null);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)24, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)5, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }
}

