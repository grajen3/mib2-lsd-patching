/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.testmode.servicemode;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.testmode.servicemode.transformer.TestmodeServicemodeFECLoggingTransformer;
import de.vw.mib.asl.internal.testmode.servicemode.transformer.TestmodeServicemodeInstallSummaryTransformer;
import de.vw.mib.asl.internal.testmode.servicemode.transformer.TestmodeServicemodeInstalledFECTransformer;
import de.vw.mib.asl.internal.testmode.servicemode.transformer.TestmodeServicemodeSupportedFEC_CodeTransformer;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;
import generated.de.vw.mib.asl.internal.testmode.servicemode.transformer.TestmodeServicemodeFECDetailsCollector;
import generated.de.vw.mib.asl.internal.testmode.servicemode.transformer.TestmodeServicemodeFECDetailsTransformer;

public final class ASLTestmodeServicemodeDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLTestmodeServicemodeDeviceImpl INSTANCE = new ASLTestmodeServicemodeDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(5);
    private ASLListFactory listFactory;

    private ASLTestmodeServicemodeDeviceImpl() {
    }

    public static ASLTestmodeServicemodeDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "Testmode.Servicemode";
    }

    @Override
    public int getTargetId() {
        return 10113;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1240000000, this);
        aSLListRegistry.registerASLDevice(-1223222784, this);
        aSLListRegistry.registerASLDevice(-1206445568, this);
        aSLListRegistry.registerASLDevice(-1189668352, this);
        aSLListRegistry.registerASLDevice(-1323886080, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(839254080, 10113);
        serviceRegister.registerService(856031296, 10113);
        serviceRegister.registerService(-1594877632, 10113);
        serviceRegister.registerService(-1578100416, 10113);
        serviceRegister.registerService(-1561323200, 10113);
        serviceRegister.registerService(-1544545984, 10113);
        serviceRegister.registerService(-1527768768, 10113);
        serviceRegister.registerService(-1510991552, 10113);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 1710006: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1710007: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            case 1710008: {
                nArray = ListColumnsUtil.getSimpleIntArray(5);
                break;
            }
            case 1710009: {
                nArray = ListColumnsUtil.getSimpleIntArray(3);
                break;
            }
            case 1710001: {
                nArray = ListColumnsUtil.getSimpleIntArray(1);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device Testmode.Servicemode: ").append(n).toString());
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
        return ASLTestmodeServicemodeDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLTestmodeServicemodeDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 1710006: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeServicemodeInstalledFECTransformer(), n, "Testmode.Servicemode", "InstalledFEC");
                break;
            }
            case 1710007: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeServicemodeInstallSummaryTransformer(), n, "Testmode.Servicemode", "InstallSummary");
                break;
            }
            case 1710008: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeServicemodeFECDetailsTransformer(), n, "Testmode.Servicemode", "FECDetails");
                genericASLList.updateList(new TestmodeServicemodeFECDetailsCollector[]{new TestmodeServicemodeFECDetailsCollector()});
                break;
            }
            case 1710009: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeServicemodeFECLoggingTransformer(), n, "Testmode.Servicemode", "FECLogging");
                break;
            }
            case 1710001: {
                genericASLList = aSLListFactory.createGenericASLList(new TestmodeServicemodeSupportedFEC_CodeTransformer(), n, "Testmode.Servicemode", "SupportedFEC_Code");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device Testmode.Servicemode: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

