/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.avdc.video.dvd.pml.pin;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLAVDCVideoDVDPMLPINDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLAVDCVideoDVDPMLPINDeviceImpl INSTANCE = new ASLAVDCVideoDVDPMLPINDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLAVDCVideoDVDPMLPINDeviceImpl() {
    }

    public static ASLAVDCVideoDVDPMLPINDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "AVDC.Video.DVD.PML.PIN";
    }

    @Override
    public int getTargetId() {
        return 11801;
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
        serviceRegister.registerService(322243648, 11801);
        serviceRegister.registerService(87362624, 11801);
        serviceRegister.registerService(104139840, 11801);
        serviceRegister.registerService(120917056, 11801);
        serviceRegister.registerService(137694272, 11801);
        serviceRegister.registerService(154471488, 11801);
        serviceRegister.registerService(171248704, 11801);
        serviceRegister.registerService(188025920, 11801);
        serviceRegister.registerService(204803136, 11801);
        serviceRegister.registerService(221580352, 11801);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Video.DVD.PML.PIN: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Video.DVD.PML.PIN: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device AVDC.Video.DVD.PML.PIN: ").append(n).toString());
    }
}

