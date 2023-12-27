/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phoneglobalwizardpage;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneGlobalWizardPageDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneGlobalWizardPageDeviceImpl INSTANCE = new ASLPhoneGlobalWizardPageDeviceImpl();
    private static final String DEVICE_NAME;

    private ASLPhoneGlobalWizardPageDeviceImpl() {
    }

    public static ASLPhoneGlobalWizardPageDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "PhoneGlobalWizardPage";
    }

    @Override
    public int getTargetId() {
        return 17401;
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
        serviceRegister.registerService(11034944, 17401);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneGlobalWizardPage: ").append(n).toString());
    }

    @Override
    public ASLList getASLList(int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneGlobalWizardPage: ").append(n).toString());
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneGlobalWizardPage: ").append(n).toString());
    }
}

