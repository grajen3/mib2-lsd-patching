/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phone.setup.settings;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phone.setup.settings.transformer.PhoneSetupSettingsInternalRingtonesTransformer;
import de.vw.mib.asl.internal.phone.setup.settings.transformer.PhoneSetupSettingsPhoneAudioModesTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneSetupSettingsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneSetupSettingsDeviceImpl INSTANCE = new ASLPhoneSetupSettingsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(2);
    private ASLListFactory listFactory;

    private ASLPhoneSetupSettingsDeviceImpl() {
    }

    public static ASLPhoneSetupSettingsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Phone.Setup.Settings";
    }

    @Override
    public int getTargetId() {
        return 10098;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1244, this);
        aSLListRegistry.registerASLDevice(1245, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(520355904, 10098);
        serviceRegister.registerService(0x20040040, 10098);
        serviceRegister.registerService(-363064000, 10098);
        serviceRegister.registerService(553910336, 10098);
        serviceRegister.registerService(0x22040040, 10098);
        serviceRegister.registerService(587464768, 10098);
        serviceRegister.registerService(0x24040040, 10098);
        serviceRegister.registerService(621019200, 10098);
        serviceRegister.registerService(822804544, 10098);
        serviceRegister.registerService(637796416, 10098);
        serviceRegister.registerService(654573632, 10098);
        serviceRegister.registerService(671350848, 10098);
        serviceRegister.registerService(688128064, 10098);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1244: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 1245: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Phone.Setup.Settings: ").append(n).toString());
            }
        }
        return nArray;
    }

    @Override
    public ASLList getASLList(int n) {
        return this.getGenericASLList(n);
    }

    @Override
    public ASLList createASLList(ASLListFactory aSLListFactory, int n) {
        return ASLPhoneSetupSettingsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneSetupSettingsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1244: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneSetupSettingsInternalRingtonesTransformer(), n, "Phone.Setup.Settings", "internalRingtones");
                break;
            }
            case 1245: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneSetupSettingsPhoneAudioModesTransformer(), n, "Phone.Setup.Settings", "phoneAudioModes");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Phone.Setup.Settings: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

