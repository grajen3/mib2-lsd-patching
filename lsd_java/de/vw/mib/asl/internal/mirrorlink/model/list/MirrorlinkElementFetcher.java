/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.model.list;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.log4mib.LogMessage;

abstract class MirrorlinkElementFetcher
implements ASLListElementFetcher {
    public static final int WINDOW_SIZE;
    public static final int BROWSER_LISTS_COLUMN_FOR_OBJECT_ID;
    private final String _classname;
    private final MirrorLinkTarget target;

    public MirrorlinkElementFetcher(GenericASLList genericASLList, MirrorLinkTarget mirrorLinkTarget) {
        this._classname = "MirrorlinkElementFetcher";
        this.target = mirrorLinkTarget;
        this.register(genericASLList);
    }

    private void register(GenericASLList genericASLList) {
        if (genericASLList != null) {
            if (genericASLList.isWindowingEnabled()) {
                genericASLList.disableWindowing();
            }
            genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 10, 0);
            genericASLList.setSize(0);
        } else {
            LogMessage logMessage = this.getTarget().warn();
            logMessage.append("MirrorlinkElementFetcher").append(".register() Invalid list.").log();
        }
    }

    protected MirrorLinkTarget getTarget() {
        return this.target;
    }

    abstract void getWindow(int n, int n2) {
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorlinkElementFetcher").append(".fetchItems(").append(n).append(", ").append(n2).append(")").log();
        }
        this.getWindow(n, n2);
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }
}

