/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristicsC;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristicsReply;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy$1;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy$2;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy$3;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsProxy$4;
import de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl.DSICarDrivingCharacteristicsReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.cardrivingcharacteristics.CharismaListUpdateInfo;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProgButton;
import org.dsi.ifc.cardrivingcharacteristics.CharismaSetupTableWithoutOptionMask;
import org.dsi.ifc.cardrivingcharacteristics.TADMaxMinAngleReset;

public class DSICarDrivingCharacteristicsProxy
implements DSICarDrivingCharacteristics,
DSICarDrivingCharacteristicsC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.cardrivingcharacteristics.DSICarDrivingCharacteristics");
    private Proxy proxy;

    public DSICarDrivingCharacteristicsProxy(int n, DSICarDrivingCharacteristicsReply dSICarDrivingCharacteristicsReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("010d0ce4-24cd-5a82-a7ce-9fcd09b9535a", n, "a9f7d85f-e2d5-532b-814b-4bb78e91dd17", "dsi.cardrivingcharacteristics.DSICarDrivingCharacteristics");
        DSICarDrivingCharacteristicsReplyService dSICarDrivingCharacteristicsReplyService = new DSICarDrivingCharacteristicsReplyService(dSICarDrivingCharacteristicsReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarDrivingCharacteristicsReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setSuspensionControlLiftMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void setSuspensionControlCarJackMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void setSuspensionControlTrailerMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void setSuspensionControlLoadingMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void setSuspensionControlActiveProfile(int n) {
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
    public void setSuspensionControlSnowChainMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)82, genericSerializable);
    }

    @Override
    public void setSuspensionControlActiveMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)103, genericSerializable);
    }

    @Override
    public void seteABCEasyEntry(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)104, genericSerializable);
    }

    @Override
    public void seteABCPitchControl(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)105, genericSerializable);
    }

    @Override
    public void seteABCSpecialPosition(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)107, genericSerializable);
    }

    @Override
    public void seteABCPreview(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)106, genericSerializable);
    }

    @Override
    public void setCharismaActiveProfile(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void setCharismaActiveOperationMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)64, genericSerializable);
    }

    @Override
    public void setCharismaTrailerSetting(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void setCharismaProgButton(CharismaProgButton charismaProgButton) {
        DSICarDrivingCharacteristicsProxy$1 dSICarDrivingCharacteristicsProxy$1 = new DSICarDrivingCharacteristicsProxy$1(this, charismaProgButton);
        this.proxy.remoteCallMethod((short)19, dSICarDrivingCharacteristicsProxy$1);
    }

    @Override
    public void requestCharismaProfileFunction(int n, CharismaSetupTableWithoutOptionMask[] charismaSetupTableWithoutOptionMaskArray) {
        DSICarDrivingCharacteristicsProxy$2 dSICarDrivingCharacteristicsProxy$2 = new DSICarDrivingCharacteristicsProxy$2(this, n, charismaSetupTableWithoutOptionMaskArray);
        this.proxy.remoteCallMethod((short)95, dSICarDrivingCharacteristicsProxy$2);
    }

    @Override
    public void requestCharismaList(CharismaListUpdateInfo charismaListUpdateInfo) {
        DSICarDrivingCharacteristicsProxy$3 dSICarDrivingCharacteristicsProxy$3 = new DSICarDrivingCharacteristicsProxy$3(this, charismaListUpdateInfo);
        this.proxy.remoteCallMethod((short)12, dSICarDrivingCharacteristicsProxy$3);
    }

    @Override
    public void showCharismaPopup(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)75, genericSerializable);
    }

    @Override
    public void cancelCharismaPopup(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setCharismaSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)20, null);
    }

    @Override
    public void setCharismaSound(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)98, genericSerializable);
    }

    @Override
    public void showTADPopup(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)76, genericSerializable);
    }

    @Override
    public void cancelTADPopup(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setTADSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)32, null);
    }

    @Override
    public void setTADMaxMinAngleReset(TADMaxMinAngleReset tADMaxMinAngleReset) {
        DSICarDrivingCharacteristicsProxy$4 dSICarDrivingCharacteristicsProxy$4 = new DSICarDrivingCharacteristicsProxy$4(this, tADMaxMinAngleReset);
        this.proxy.remoteCallMethod((short)31, dSICarDrivingCharacteristicsProxy$4);
    }

    @Override
    public void setHMIIsReady(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)68, genericSerializable);
    }

    @Override
    public void setSpoilerSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)80, null);
    }

    @Override
    public void setSpoilerPositionSelection(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)79, genericSerializable);
    }

    @Override
    public void setSpoilerActuation(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)78, genericSerializable);
    }

    @Override
    public void setSpoilerSystemOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)81, genericSerializable);
    }

    @Override
    public void setSoundSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)100, null);
    }

    @Override
    public void setSoundStyle(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)101, genericSerializable);
    }

    @Override
    public void setSoundSystemOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)102, genericSerializable);
    }

    @Override
    public void setSoundOnOff(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)99, genericSerializable);
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
        this.proxy.remoteCallMethod((short)24, genericSerializable);
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
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)23, null);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)9, null);
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
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }
}

