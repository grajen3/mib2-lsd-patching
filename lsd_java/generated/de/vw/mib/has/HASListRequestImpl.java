/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContextResults;
import de.vw.mib.has.HASListRequest;
import generated.de.vw.mib.has.containers.ListPageDataContainer;

class HASListRequestImpl
implements HASListRequest {
    private final ListPageDataContainer data;
    private final int callId;
    private final int actionId;
    private final HASContextResults results;

    HASListRequestImpl(ListPageDataContainer listPageDataContainer, int n, int n2, HASContextResults hASContextResults) {
        this.data = listPageDataContainer;
        this.callId = n;
        this.actionId = n2;
        this.results = hASContextResults;
    }

    @Override
    public int getOffset() {
        return this.data.getOffset();
    }

    @Override
    public void setOffset(int n) {
        this.data.setOffset(n);
    }

    @Override
    public int getModCount() {
        return this.data.getModCount();
    }

    @Override
    public void setModCount(int n) {
        this.data.setModCount(n);
    }

    @Override
    public HASContainer[] getData() {
        return this.data.getPageData();
    }

    @Override
    public void setData(HASContainer[] hASContainerArray) {
        this.data.setPageData(hASContainerArray);
    }

    @Override
    public void response(int n) {
        this.results.callResult(this.callId, this.actionId, n, 0 == n ? this.data : (HASContainer)null);
    }
}

