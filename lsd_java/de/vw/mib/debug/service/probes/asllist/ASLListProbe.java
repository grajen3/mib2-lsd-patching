/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.asllist;

import de.vw.mib.collections.ints.IntObjectMap$Entry;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.debug.common.probes.asllist.ASLListProbeConfiguration;
import de.vw.mib.debug.service.probes.asllist.DynamicListDataListenerImpl;
import de.vw.mib.debugmanager.probes.AbstractDebugProbe;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.list.DynamicListData;
import de.vw.mib.list.DynamicListManager;
import java.util.Arrays;
import java.util.Iterator;

public final class ASLListProbe
extends AbstractDebugProbe {
    private IntObjectOptHashMap dynamicListDataListeners;
    private DynamicListManager dynamicListManager;
    static /* synthetic */ Class class$de$vw$mib$list$DynamicListManager;

    public ASLListProbe(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    @Override
    protected boolean initProbe() {
        this.dynamicListDataListeners = new IntObjectOptHashMap();
        this.dynamicListManager = (DynamicListManager)this.probeSystemServices.getService((class$de$vw$mib$list$DynamicListManager == null ? (class$de$vw$mib$list$DynamicListManager = ASLListProbe.class$("de.vw.mib.list.DynamicListManager")) : class$de$vw$mib$list$DynamicListManager).getName());
        return true;
    }

    @Override
    protected boolean activateProbe() {
        return true;
    }

    @Override
    protected boolean deactivateProbe() {
        if (this.dynamicListDataListeners.isEmpty()) {
            return true;
        }
        Iterator iterator = this.dynamicListDataListeners.entrySet().iterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            try {
                DynamicListData dynamicListData = this.dynamicListManager.getDynamicList(n);
                dynamicListData.removeDynamicListDataListener((DynamicListDataListenerImpl)intObjectMap$Entry.getValue());
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logger.error(4).append("Try to deactivate observation of an unknown dynamic list (listId: ").append(n).append(")!").log();
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                this.logger.error(4).append("Try to deactivate observation of an unknown dynamic list (listId: ").append(n).append(")!").log();
            }
        }
        this.dynamicListDataListeners.clear();
        return true;
    }

    @Override
    protected boolean configureProbe() {
        ASLListProbeConfiguration aSLListProbeConfiguration = (ASLListProbeConfiguration)this.probeSystemServices.getConfiguration();
        int[] nArray = aSLListProbeConfiguration.getAslListIds();
        if (nArray == null) {
            this.deactivateAllButListed(new int[0]);
            return true;
        }
        this.deactivateAllButListed(nArray);
        this.activate(nArray);
        return true;
    }

    private void activate(int[] nArray) {
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n = nArray[i2];
            try {
                if (!this.dynamicListDataListeners.containsKey(n)) {
                    DynamicListData dynamicListData = this.dynamicListManager.getDynamicList(n);
                    DynamicListDataListenerImpl dynamicListDataListenerImpl = new DynamicListDataListenerImpl(dynamicListData, n, this.logger, this.probeSystemServices);
                    this.dynamicListDataListeners.put(n, dynamicListDataListenerImpl);
                    dynamicListData.addDynamicListDataListener(dynamicListDataListenerImpl);
                }
                intOptHashSet.add(n);
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logger.error(4).append("Try to activate observation of an unknown dynamic list (listId: ").append(n).append(")!").log();
                continue;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                this.logger.error(4).append("Try to deactivate observation of an unknown dynamic list (listId: ").append(n).append(")!").log();
            }
        }
        ASLListProbeConfiguration aSLListProbeConfiguration = (ASLListProbeConfiguration)this.probeSystemServices.getConfiguration();
        aSLListProbeConfiguration.setAslListIds(intOptHashSet.toArray(new int[intOptHashSet.size()]));
    }

    private void deactivateAllButListed(int[] nArray) {
        if (this.dynamicListDataListeners.isEmpty()) {
            return;
        }
        Arrays.sort(nArray);
        Iterator iterator = this.dynamicListDataListeners.entrySet().iterator();
        while (iterator.hasNext()) {
            IntObjectMap$Entry intObjectMap$Entry = (IntObjectMap$Entry)iterator.next();
            int n = intObjectMap$Entry.getKey();
            try {
                DynamicListData dynamicListData = this.dynamicListManager.getDynamicList(n);
                if (Arrays.binarySearch(nArray, n) >= 0) continue;
                dynamicListData.removeDynamicListDataListener((DynamicListDataListenerImpl)intObjectMap$Entry.getValue());
                iterator.remove();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.logger.error(4).append("Try to deactivate observation of an unknown dynamic list (listId: ").append(n).append(")!").log();
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                this.logger.error(4).append("Try to deactivate observation of an unknown dynamic list (listId: ").append(n).append(")!").log();
            }
        }
    }

    @Override
    protected boolean cleanUpProbe() {
        return true;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

