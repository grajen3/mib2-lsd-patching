/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechnavigation.controller.application;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechNavigationControllerApplicationDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechNavigationControllerApplicationDeviceImpl INSTANCE = new ASLSpeechNavigationControllerApplicationDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechNavigationControllerApplicationDeviceImpl() {
    }

    public static ASLSpeechNavigationControllerApplicationDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechNavigation.Controller.Application";
    }

    @Override
    public int getTargetId() {
        return 14404;
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
        serviceRegister.registerService(1138832192, 14404);
        serviceRegister.registerService(-1612631232, 14404);
        serviceRegister.registerService(-186567872, 14404);
        serviceRegister.registerService(-2018496, 14404);
        serviceRegister.registerService(1893806912, 14404);
        serviceRegister.registerService(1910584128, 14404);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Application: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Application: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechNavigation.Controller.Application: ").append(n).toString());
    }
}

