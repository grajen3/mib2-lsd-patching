/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioData;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioDataC;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioDataReply;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy$1;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy$2;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy$3;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy$4;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;

public class DSIRadioDataProxy
implements DSIRadioData,
DSIRadioDataC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.radiodata.DSIRadioData");
    private Proxy proxy;

    public DSIRadioDataProxy(int n, DSIRadioDataReply dSIRadioDataReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4ed4ac19-0c6c-5830-a2bc-a1134fa4522a", n, "11df929b-d035-513f-a3d3-7c4eced78564", "dsi.radiodata.DSIRadioData");
        DSIRadioDataReplyService dSIRadioDataReplyService = new DSIRadioDataReplyService(dSIRadioDataReply);
        this.proxy = new Proxy(serviceInstanceID, dSIRadioDataReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestRadioStationData(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        DSIRadioDataProxy$1 dSIRadioDataProxy$1 = new DSIRadioDataProxy$1(this, radioStationDataRequestArray, n);
        this.proxy.remoteCallMethod((short)10, dSIRadioDataProxy$1);
    }

    @Override
    public void requestRadioStationLogos(RadioStationLogoRequest[] radioStationLogoRequestArray, int n) {
        DSIRadioDataProxy$2 dSIRadioDataProxy$2 = new DSIRadioDataProxy$2(this, radioStationLogoRequestArray, n);
        this.proxy.remoteCallMethod((short)11, dSIRadioDataProxy$2);
    }

    @Override
    public void requestDynamicDatabaseAlteration(RadioStationData radioStationData, ResourceLocator resourceLocator, int n, int n2) {
        DSIRadioDataProxy$3 dSIRadioDataProxy$3 = new DSIRadioDataProxy$3(this, radioStationData, resourceLocator, n, n2);
        this.proxy.remoteCallMethod((short)8, dSIRadioDataProxy$3);
    }

    @Override
    public void requestCountryListUpdate(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void requestDatabaseVersionInfo(int n) {
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
    public void requestPersistStationLogos(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        DSIRadioDataProxy$4 dSIRadioDataProxy$4 = new DSIRadioDataProxy$4(this, radioStationDataArray, resourceLocatorArray, n, n2);
        this.proxy.remoteCallMethod((short)9, dSIRadioDataProxy$4);
    }

    @Override
    public void requestCountryRegionData(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void requestCountryRegionTranslationData(int n, String string, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
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
        this.proxy.remoteCallMethod((short)29, genericSerializable);
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
        this.proxy.remoteCallMethod((short)32, genericSerializable);
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
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    @Override
    public void profileResetAll() {
        this.proxy.remoteCallMethod((short)35, null);
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
        this.proxy.remoteCallMethod((short)21, genericSerializable);
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
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)20, null);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }
}

