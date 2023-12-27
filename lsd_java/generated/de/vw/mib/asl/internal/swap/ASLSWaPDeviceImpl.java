/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.swap;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.swap.transformer.SWaPFECLoggingTransformer;
import de.vw.mib.asl.internal.swap.transformer.SWaPInstallSummaryTransformer;
import de.vw.mib.asl.internal.swap.transformer.SWaPInstalledFECTransformer;
import de.vw.mib.asl.internal.swap.transformer.SWaPSupportedFEC_CodeTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.swap.transformer.SWaPFECDetailsCollector;
import generated.de.vw.mib.asl.internal.swap.transformer.SWaPFECDetailsTransformer;

public final class ASLSWaPDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLSWaPDeviceImpl INSTANCE = new ASLSWaPDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLSWaPDeviceImpl() {
    }

    public static ASLSWaPDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "SWaP";
    }

    @Override
    public int getTargetId() {
        return 10110;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(1573, this);
        aSLListRegistry.registerASLDevice(1574, this);
        aSLListRegistry.registerASLDevice(1575, this);
        aSLListRegistry.registerASLDevice(1576, this);
        aSLListRegistry.registerASLDevice(1568, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(755302464, 10110);
        serviceRegister.registerService(772079680, 10110);
        serviceRegister.registerService(788856896, 10110);
        serviceRegister.registerService(805634112, 10110);
        serviceRegister.registerService(822411328, 10110);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1573: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1574: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1575: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1576: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1568: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device SWaP: ").append(n).toString());
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
        return ASLSWaPDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLSWaPDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1573: {
                genericASLList = aSLListFactory.createGenericASLList(new SWaPInstalledFECTransformer(), n, "SWaP", "InstalledFEC");
                break;
            }
            case 1574: {
                genericASLList = aSLListFactory.createGenericASLList(new SWaPInstallSummaryTransformer(), n, "SWaP", "InstallSummary");
                break;
            }
            case 1575: {
                genericASLList = aSLListFactory.createGenericASLList(new SWaPFECDetailsTransformer(), n, "SWaP", "FECDetails");
                genericASLList.updateList(new SWaPFECDetailsCollector[]{new SWaPFECDetailsCollector()});
                break;
            }
            case 1576: {
                genericASLList = aSLListFactory.createGenericASLList(new SWaPFECLoggingTransformer(), n, "SWaP", "FECLogging");
                break;
            }
            case 1568: {
                genericASLList = aSLListFactory.createGenericASLList(new SWaPSupportedFEC_CodeTransformer(), n, "SWaP", "SupportedFEC_Code");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device SWaP: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

