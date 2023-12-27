/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.pin;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhonePINDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhonePINDeviceImpl INSTANCE = new ASLPhonePINDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhonePINDeviceImpl() {
    }

    public static ASLPhonePINDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.PIN";
    }

    @Override
    public int getTargetId() {
        return 10085;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-788332480, 10085);
        serviceRegister.registerService(-771555264, 10085);
        serviceRegister.registerService(-754778048, 10085);
        serviceRegister.registerService(-738000832, 10085);
        serviceRegister.registerService(-715385536, 10085);
        serviceRegister.registerService(-704446400, 10085);
        serviceRegister.registerService(336199744, 10085);
        serviceRegister.registerService(352976960, 10085);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.PIN: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.PIN: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.PIN: ").append(n).toString());
    }
}

