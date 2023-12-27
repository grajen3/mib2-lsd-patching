/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.globalsetupwizard;

import de.vw.mib.asl.internal.globalsetupwizard.transformer.GlobalSetupWizardProgressListTransformer;
import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLGlobalSetupWizardDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLGlobalSetupWizardDeviceImpl INSTANCE = new ASLGlobalSetupWizardDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLGlobalSetupWizardDeviceImpl() {
    }

    public static ASLGlobalSetupWizardDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "GlobalSetupWizard";
    }

    @Override
    public int getTargetId() {
        return 16201;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-1820373248, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-2141696192, 16201);
        serviceRegister.registerService(-2124918976, 16201);
        serviceRegister.registerService(-2108141760, 16201);
        serviceRegister.registerService(-2091364544, 16201);
        serviceRegister.registerService(-2074587328, 16201);
        serviceRegister.registerService(-2057810112, 16201);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 5210003: {
                nArray = ListColumnsUtil.getSimpleIntArray(2);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device GlobalSetupWizard: ").append(n).toString());
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
        return ASLGlobalSetupWizardDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLGlobalSetupWizardDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 5210003: {
                genericASLList = aSLListFactory.createGenericASLList(new GlobalSetupWizardProgressListTransformer(), n, "GlobalSetupWizard", "ProgressList");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device GlobalSetupWizard: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

