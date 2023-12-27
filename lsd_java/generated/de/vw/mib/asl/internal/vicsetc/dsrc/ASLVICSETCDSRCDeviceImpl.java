/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.dsrc;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.asl.internal.vicsetc.dsrc.transformer.VICSETCDSRCButtonInformationTransformer;
import de.vw.mib.asl.internal.vicsetc.dsrc.transformer.VICSETCDSRCMessageImageRLTransformer;
import de.vw.mib.asl.internal.vicsetc.dsrc.transformer.VICSETCDSRCMessageSubImageRLTransformer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLVICSETCDSRCDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCDSRCDeviceImpl INSTANCE = new ASLVICSETCDSRCDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLVICSETCDSRCDeviceImpl() {
    }

    public static ASLVICSETCDSRCDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.DSRC";
    }

    @Override
    public int getTargetId() {
        return 16604;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(2006603008, this);
        aSLListRegistry.registerASLDevice(1889162496, this);
        aSLListRegistry.registerASLDevice(1067078912, this);
        aSLListRegistry.registerASLDevice(1822053632, this);
        aSLListRegistry.registerASLDevice(1838830848, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(57890112, 16604);
        serviceRegister.registerService(1098077504, 16604);
        serviceRegister.registerService(963859776, 16604);
        serviceRegister.registerService(661869888, 16604);
        serviceRegister.registerService(678647104, 16604);
        serviceRegister.registerService(695424320, 16604);
        serviceRegister.registerService(712201536, 16604);
        serviceRegister.registerService(728978752, 16604);
        serviceRegister.registerService(745755968, 16604);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5610103: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 5610096: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610047: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610092: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610093: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.DSRC: ").append(n).toString());
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
        return ASLVICSETCDSRCDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLVICSETCDSRCDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5610103: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCDSRCButtonInformationTransformer(), n, "VICSETC.DSRC", "ButtonInformation");
                break;
            }
            case 5610096: {
                genericASLList = aSLListFactory.createGenericASLList(ASLVICSETCDSRCDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "MessageButtonStates"), n, "VICSETC.DSRC", "MessageButtonStates");
                break;
            }
            case 5610047: {
                genericASLList = aSLListFactory.createGenericASLList(ASLVICSETCDSRCDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "MessageDates"), n, "VICSETC.DSRC", "MessageDates");
                break;
            }
            case 5610092: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCDSRCMessageImageRLTransformer(), n, "VICSETC.DSRC", "MessageImageRL");
                break;
            }
            case 5610093: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCDSRCMessageSubImageRLTransformer(), n, "VICSETC.DSRC", "MessageSubImageRL");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device VICSETC.DSRC: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 5610096: {
                string3 = "de.vw.mib.asl.internal.vicsetc.dsrc.transformer.";
                string2 = "VICSETCDSRCMessageButtonStatesTransformer";
                break;
            }
            case 5610047: {
                string3 = "de.vw.mib.asl.internal.vicsetc.dsrc.transformer.";
                string2 = "VICSETCDSRCMessageDatesTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device VICSETC.DSRC: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "VICSETC.DSRC", string);
    }
}

