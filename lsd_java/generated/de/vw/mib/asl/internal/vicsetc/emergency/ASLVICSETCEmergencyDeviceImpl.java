/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.emergency;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.asl.internal.vicsetc.emergency.transformer.VICSETCEmergencyButtonInformationTransformer;
import de.vw.mib.asl.internal.vicsetc.emergency.transformer.VICSETCEmergencyMessageImageRLTransformer;
import de.vw.mib.asl.internal.vicsetc.emergency.transformer.VICSETCEmergencyMessageSubImageRLTransformer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLVICSETCEmergencyDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCEmergencyDeviceImpl INSTANCE = new ASLVICSETCEmergencyDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLVICSETCEmergencyDeviceImpl() {
    }

    public static ASLVICSETCEmergencyDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.Emergency";
    }

    @Override
    public int getTargetId() {
        return 16606;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1973048576, this);
        aSLListRegistry.registerASLDevice(1905939712, this);
        aSLListRegistry.registerASLDevice(1201296640, this);
        aSLListRegistry.registerASLDevice(1855608064, this);
        aSLListRegistry.registerASLDevice(1872385280, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(91444544, 16606);
        serviceRegister.registerService(1131631936, 16606);
        serviceRegister.registerService(997414208, 16606);
        serviceRegister.registerService(762533184, 16606);
        serviceRegister.registerService(779310400, 16606);
        serviceRegister.registerService(796087616, 16606);
        serviceRegister.registerService(812864832, 16606);
        serviceRegister.registerService(829642048, 16606);
        serviceRegister.registerService(846419264, 16606);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5610101: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 5610097: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610055: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610094: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610095: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.Emergency: ").append(n).toString());
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
        return ASLVICSETCEmergencyDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLVICSETCEmergencyDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5610101: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCEmergencyButtonInformationTransformer(), n, "VICSETC.Emergency", "ButtonInformation");
                break;
            }
            case 5610097: {
                genericASLList = aSLListFactory.createGenericASLList(ASLVICSETCEmergencyDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "MessageButtonStates"), n, "VICSETC.Emergency", "MessageButtonStates");
                break;
            }
            case 5610055: {
                genericASLList = aSLListFactory.createGenericASLList(ASLVICSETCEmergencyDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "MessageDates"), n, "VICSETC.Emergency", "MessageDates");
                break;
            }
            case 5610094: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCEmergencyMessageImageRLTransformer(), n, "VICSETC.Emergency", "MessageImageRL");
                break;
            }
            case 5610095: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCEmergencyMessageSubImageRLTransformer(), n, "VICSETC.Emergency", "MessageSubImageRL");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device VICSETC.Emergency: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 5610097: {
                string3 = "de.vw.mib.asl.internal.vicsetc.emergency.transformer.";
                string2 = "VICSETCEmergencyMessageButtonStatesTransformer";
                break;
            }
            case 5610055: {
                string3 = "de.vw.mib.asl.internal.vicsetc.emergency.transformer.";
                string2 = "VICSETCEmergencyMessageDatesTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device VICSETC.Emergency: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "VICSETC.Emergency", string);
    }
}

