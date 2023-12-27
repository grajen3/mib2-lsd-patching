/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.vicsetc.fmgraphic;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.ItemTransformer;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.VICSETCFmGraphicButtonInformationTransformer;
import de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.VICSETCFmGraphicMessageImagesRLTransformer;
import de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.VICSETCFmGraphicMessageSubImagesRLTransformer;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLVICSETCFmGraphicDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLVICSETCFmGraphicDeviceImpl INSTANCE = new ASLVICSETCFmGraphicDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;
    private static final String PACKAGE_BASE_IMPL;

    private ASLVICSETCFmGraphicDeviceImpl() {
    }

    public static ASLVICSETCFmGraphicDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "VICSETC.FmGraphic";
    }

    @Override
    public int getTargetId() {
        return 16603;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1989825792, this);
        aSLListRegistry.registerASLDevice(848975104, this);
        aSLListRegistry.registerASLDevice(1922716928, this);
        aSLListRegistry.registerASLDevice(865752320, this);
        aSLListRegistry.registerASLDevice(882529536, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(527652160, 16603);
        serviceRegister.registerService(1081300288, 16603);
        serviceRegister.registerService(544429376, 16603);
        serviceRegister.registerService(561206592, 16603);
        serviceRegister.registerService(577983808, 16603);
        serviceRegister.registerService(594761024, 16603);
        serviceRegister.registerService(611538240, 16603);
        serviceRegister.registerService(628315456, 16603);
        serviceRegister.registerService(645092672, 16603);
        serviceRegister.registerService(41112896, 16603);
        serviceRegister.registerService(947082560, 16603);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5610102: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 5610034: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610098: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610035: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            case 5610036: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device VICSETC.FmGraphic: ").append(n).toString());
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
        return ASLVICSETCFmGraphicDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLVICSETCFmGraphicDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5610102: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCFmGraphicButtonInformationTransformer(), n, "VICSETC.FmGraphic", "ButtonInformation");
                break;
            }
            case 5610034: {
                genericASLList = aSLListFactory.createGenericASLList(ASLVICSETCFmGraphicDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "MessageButtonStates"), n, "VICSETC.FmGraphic", "MessageButtonStates");
                break;
            }
            case 5610098: {
                genericASLList = aSLListFactory.createGenericASLList(ASLVICSETCFmGraphicDeviceImpl.getDeprecatedTransformer(n, aSLListFactory, "MessageButtonNumbers"), n, "VICSETC.FmGraphic", "MessageButtonNumbers");
                break;
            }
            case 5610035: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCFmGraphicMessageImagesRLTransformer(), n, "VICSETC.FmGraphic", "MessageImagesRL");
                break;
            }
            case 5610036: {
                genericASLList = aSLListFactory.createGenericASLList(new VICSETCFmGraphicMessageSubImagesRLTransformer(), n, "VICSETC.FmGraphic", "MessageSubImagesRL");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device VICSETC.FmGraphic: ").append(n).toString());
            }
        }
        return genericASLList;
    }

    private static ItemTransformer getDeprecatedTransformer(int n, ASLListFactory aSLListFactory, String string) {
        String string2;
        String string3;
        switch (n) {
            case 5610034: {
                string3 = "de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.";
                string2 = "VICSETCFmGraphicMessageButtonStatesTransformer";
                break;
            }
            case 5610098: {
                string3 = "de.vw.mib.asl.internal.vicsetc.fmgraphic.transformer.";
                string2 = "VICSETCFmGraphicMessageButtonNumbersTransformer";
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid deprecated list id for device VICSETC.FmGraphic: ").append(n).toString());
            }
        }
        return aSLListFactory.getDeprecatedTransformer(n, string3, string2, "VICSETC.FmGraphic", string);
    }
}

