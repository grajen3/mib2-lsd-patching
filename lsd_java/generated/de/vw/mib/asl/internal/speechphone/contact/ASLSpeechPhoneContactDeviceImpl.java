/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechphone.contact;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechPhoneContactDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechPhoneContactDeviceImpl INSTANCE = new ASLSpeechPhoneContactDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechPhoneContactDeviceImpl() {
    }

    public static ASLSpeechPhoneContactDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechPhone.Contact";
    }

    @Override
    public int getTargetId() {
        return 14911;
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
        serviceRegister.registerService(-1836958912, 14911);
        serviceRegister.registerService(-1820181696, 14911);
        serviceRegister.registerService(-1803404480, 14911);
        serviceRegister.registerService(-1786627264, 14911);
        serviceRegister.registerService(-1769850048, 14911);
        serviceRegister.registerService(-1753072832, 14911);
        serviceRegister.registerService(-1719518400, 14911);
        serviceRegister.registerService(-1618855104, 14911);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Contact: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Contact: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechPhone.Contact: ").append(n).toString());
    }
}

