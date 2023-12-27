/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.debug.service.probes.dsimethodcall;

import de.vw.mib.debug.service.probes.dsimethodcall.DsiObjectCodec;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.dsi.trace.DSITraceService;
import de.vw.mib.log4mib.BinaryMessage;
import java.lang.reflect.Array;

public final class DsiMethodCallCodec
extends AbstractProbeCodec {
    private final DsiObjectCodec objectWriter;
    static /* synthetic */ Class class$de$vw$mib$dsi$trace$DSITraceService;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Short;

    public DsiMethodCallCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
        this.objectWriter = new DsiObjectCodec((DSITraceService)probeSystemServices.getService((class$de$vw$mib$dsi$trace$DSITraceService == null ? (class$de$vw$mib$dsi$trace$DSITraceService = DsiMethodCallCodec.class$("de.vw.mib.dsi.trace.DSITraceService")) : class$de$vw$mib$dsi$trace$DSITraceService).getName()));
    }

    public void encodeListenerMethodAdapterInvoke(String string, int n, Object[] objectArray) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(560271616);
        binaryMessage.append(string);
        binaryMessage.append(n);
        this.encodeArgs(binaryMessage, objectArray);
        binaryMessage.send();
    }

    public void encodeNotificationListenerInvoke(int n, int n2, int n3, Object[] objectArray) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(560271616);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        this.encodeArgs(binaryMessage, objectArray);
        binaryMessage.send();
    }

    public void encodeResponseListenerInvoke(int n, int n2, int n3, Object[] objectArray) {
        BinaryMessage binaryMessage = this.createMessage((byte)5);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(560271616);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        this.encodeArgs(binaryMessage, objectArray);
        binaryMessage.send();
    }

    public void encodeServiceInvoke(int n, int n2, int n3, int n4, Object[] objectArray) {
        BinaryMessage binaryMessage = this.createMessage((byte)4);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        this.encodeArgs(binaryMessage, objectArray);
        binaryMessage.send();
    }

    private BinaryMessage encodeArgs(BinaryMessage binaryMessage, Object[] objectArray) {
        int n = objectArray.length;
        binaryMessage.append(n);
        for (int i2 = 0; i2 < n; ++i2) {
            Object object = objectArray[i2];
            if (object == null) {
                binaryMessage.append((byte)0);
                continue;
            }
            if ((class$java$lang$Integer == null ? DsiMethodCallCodec.class$("java.lang.Integer") : class$java$lang$Integer).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)1);
                binaryMessage.append((Integer)object);
                continue;
            }
            if ((class$java$lang$Boolean == null ? DsiMethodCallCodec.class$("java.lang.Boolean") : class$java$lang$Boolean).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)2);
                binaryMessage.append((Boolean)object);
                continue;
            }
            if ((class$java$lang$Float == null ? DsiMethodCallCodec.class$("java.lang.Float") : class$java$lang$Float).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)3);
                binaryMessage.append(((Float)object).floatValue());
                continue;
            }
            if ((class$java$lang$Double == null ? DsiMethodCallCodec.class$("java.lang.Double") : class$java$lang$Double).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)4);
                binaryMessage.append((Double)object);
                continue;
            }
            if ((class$java$lang$String == null ? DsiMethodCallCodec.class$("java.lang.String") : class$java$lang$String).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)5);
                binaryMessage.append((String)object);
                continue;
            }
            if ((class$java$lang$Byte == null ? DsiMethodCallCodec.class$("java.lang.Byte") : class$java$lang$Byte).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)6);
                binaryMessage.append((Byte)object);
                continue;
            }
            if ((class$java$lang$Character == null ? DsiMethodCallCodec.class$("java.lang.Character") : class$java$lang$Character).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)7);
                binaryMessage.append(((Character)object).charValue());
                continue;
            }
            if ((class$java$lang$Long == null ? DsiMethodCallCodec.class$("java.lang.Long") : class$java$lang$Long).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)8);
                binaryMessage.append((Long)object);
                continue;
            }
            if ((class$java$lang$Short == null ? DsiMethodCallCodec.class$("java.lang.Short") : class$java$lang$Short).isAssignableFrom(object.getClass())) {
                binaryMessage.append((byte)9);
                binaryMessage.append((Short)object);
                continue;
            }
            if (object.getClass().isArray()) {
                Class clazz = object.getClass().getComponentType();
                if (clazz.isPrimitive()) {
                    binaryMessage.append((byte)10);
                    binaryMessage.append(this.arrayToString(object));
                    continue;
                }
                binaryMessage.append((byte)12);
                int n2 = Array.getLength(object);
                binaryMessage.append(n2);
                if (n2 == 0) continue;
                for (int i3 = 0; i3 < n2; ++i3) {
                    Object object2 = Array.get(object, i3);
                    this.encodeObject(binaryMessage, object2);
                }
                continue;
            }
            this.encodeObject(binaryMessage, object);
        }
        return binaryMessage;
    }

    private BinaryMessage encodeObject(BinaryMessage binaryMessage, Object object) {
        binaryMessage.mark();
        try {
            this.objectWriter.write(binaryMessage, object);
        }
        catch (Exception exception) {
            binaryMessage.rollback();
            binaryMessage.append((byte)5);
            if (object == null) {
                binaryMessage.append("null");
            }
            binaryMessage.append(object.toString());
        }
        return binaryMessage;
    }

    @Override
    protected byte getCodecVersion() {
        return -7;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 52;
    }

    @Override
    protected short getMessageType() {
        return 272;
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

