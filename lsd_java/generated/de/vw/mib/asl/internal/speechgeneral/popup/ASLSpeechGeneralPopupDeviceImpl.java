/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.speechgeneral.popup;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLSpeechGeneralPopupDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSpeechGeneralPopupDeviceImpl INSTANCE = new ASLSpeechGeneralPopupDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLSpeechGeneralPopupDeviceImpl() {
    }

    public static ASLSpeechGeneralPopupDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SpeechGeneral.Popup";
    }

    @Override
    public int getTargetId() {
        return 14208;
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
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Popup: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Popup: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SpeechGeneral.Popup: ").append(n).toString());
    }
}

