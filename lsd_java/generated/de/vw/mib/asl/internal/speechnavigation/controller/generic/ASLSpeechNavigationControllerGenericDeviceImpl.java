/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.generic;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerGenericDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerGenericDeviceImpl INSTANCE = new ASLSpeechNavigationControllerGenericDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechNavigationControllerGenericDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerGenericDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.Generic";
    }

    @Override
    public int getTargetId() {
        return 14403;
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
        serviceRegister.registerService(1088500544, 14403);
        serviceRegister.registerService(1105277760, 14403);
        serviceRegister.registerService(1122054976, 14403);
        serviceRegister.registerService(-18795712, 14403);
        serviceRegister.registerService(1491153728, 14403);
        serviceRegister.registerService(1390490432, 14403);
        serviceRegister.registerService(1507930944, 14403);
        serviceRegister.registerService(1424044864, 14403);
        serviceRegister.registerService(1440822080, 14403);
        serviceRegister.registerService(1457599296, 14403);
        serviceRegister.registerService(1474376512, 14403);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Generic: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Generic: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Generic: ").append(n).toString());
    }
}

