/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.asl.internal.phonetiles.presets;

import de.vw.mib.asl.internal.list.ASLList;
import de.vw.mib.asl.internal.list.ASLListFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.phonetiles.presets.transformer.PhoneTileSPresetsPresetsTransformer;
import de.vw.mib.asl.internal.registry.ASLListRegistry;
import de.vw.mib.asl.internal.registry.impl.ASLDeviceAdapter;
import de.vw.mib.asl.internal.util.ListColumnsUtil;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.ServiceRegister;

public final class ASLPhoneTileSPresetsDeviceImpl
extends ASLDeviceAdapter {
    private static final ASLPhoneTileSPresetsDeviceImpl INSTANCE = new ASLPhoneTileSPresetsDeviceImpl();
    private static final String DEVICE_NAME;
    private final IntObjectOptHashMap listsMap = new IntObjectOptHashMap(1);
    private ASLListFactory listFactory;

    private ASLPhoneTileSPresetsDeviceImpl() {
    }

    public static ASLPhoneTileSPresetsDeviceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "PhoneTileS.Presets";
    }

    @Override
    public int getTargetId() {
        return 17704;
    }

    @Override
    public int getASLDeviceComplianceLevel() {
        return 2;
    }

    @Override
    public void registerASLLists(ASLListRegistry aSLListRegistry) {
        this.listFactory = aSLListRegistry.getASLListFactory();
        aSLListRegistry.registerASLDevice(-94214656, this);
    }

    @Override
    public void registerASLServices(ServiceRegister serviceRegister) {
        serviceRegister.registerService(-398760384, 17704);
        serviceRegister.registerService(-381983168, 17704);
        serviceRegister.registerService(-180656576, 17704);
    }

    @Override
    public synchronized int[] getASLListColumns(int n) {
        int[] nArray;
        switch (n) {
            case 6710010: {
                nArray = ListColumnsUtil.getSimpleIntArray(8);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for device PhoneTileS.Presets: ").append(n).toString());
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
        return ASLPhoneTileSPresetsDeviceImpl.createGenericASLList(aSLListFactory, n);
    }

    public synchronized GenericASLList getGenericASLList(int n) {
        GenericASLList genericASLList = (GenericASLList)this.listsMap.get(n);
        if (null != genericASLList) {
            return genericASLList;
        }
        genericASLList = ASLPhoneTileSPresetsDeviceImpl.createGenericASLList(this.listFactory, n);
        this.listsMap.put(n, genericASLList);
        return genericASLList;
    }

    private static GenericASLList createGenericASLList(ASLListFactory aSLListFactory, int n) {
        GenericASLList genericASLList;
        switch (n) {
            case 6710010: {
                genericASLList = aSLListFactory.createGenericASLList(new PhoneTileSPresetsPresetsTransformer(), n, "PhoneTileS.Presets", "presets");
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid list id for type GenericASLList and device PhoneTileS.Presets: ").append(n).toString());
            }
        }
        return genericASLList;
    }
}

