/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer$AbstractSharedDrawable;
import de.vw.mib.graphics.internal.mesh.AbstractGeometryBuffer;
import de.vw.mib.graphics.internal.mesh.MeshHeap;
import de.vw.mib.graphics.internal.mesh.MeshHeap$MeshHeapListener;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.internal.texture.TextureAtlas$SubTexture;
import de.vw.mib.graphics.internal.texture.TextureAtlas$TextureAtlasListener;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractSharedDrawableRenderer
extends AbstractPooledDrawableRenderer
implements GraphicsListener,
TextureAtlas$TextureAtlasListener,
MeshHeap$MeshHeapListener {
    public static final float TEXEL_CENTER_OFFSET;
    public static final boolean LOCKING;
    protected final HashCodeBuilder hcb = new HashCodeBuilder();
    private final TextureAtlas textureAtlas;
    private static final int SUBTEXTURE_SUBMESH_MAP_INITIAL_CAPACITY;
    private static final int SUBMESH_MAP_INITIAL_CAPACITY;
    private LongObjectMap subTextureToSubMeshIndex;
    private MeshHeap meshHeap;
    private static final int SUBMESH_DRAWABLE_MAP_INITIAL_CAPACITY;
    private static final int DRAWABLE_LIST_INITIAL_CAPACITY;
    private LongObjectMap subMeshToDrawableIndex;
    private static final int LOCK_LISTS;
    private static final int SUBMESH_LOCKS_MAP_INITIAL_CAPACITY;
    private static final int SUBTEXTURE_LOCKS_MAP_INITIAL_CAPACITY;
    private LongObjectMap[] subMeshLocks;
    private LongObjectMap[] subTextureLocks;
    private int currentLocksIndex;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$internal$drawable$renderer$AbstractSharedDrawableRenderer;

    public AbstractSharedDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n) {
        this(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, 0);
    }

    public AbstractSharedDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics);
        this.textureAtlas = textureAtlas;
        if (this.textureAtlas != null) {
            this.subTextureToSubMeshIndex = new LongObjectOptHashMap(50);
            this.textureAtlas.addTextureAtlasListener(this);
        }
        VertexFormat vertexFormat = this.getVertexFormat();
        this.meshHeap = n2 > 0 ? new MeshHeap(graphics3D, logger, vertexFormat, n, this.getIndexFormat(), n2) : new MeshHeap(graphics3D, logger, vertexFormat, n);
        this.meshHeap.addMeshHeapListener(this);
        this.subMeshToDrawableIndex = new LongObjectOptHashMap(50);
        if (LOCKING) {
            graphics3D.addListener(this);
            this.initLocks();
        }
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append("Initialized renderer ");
            logMessage.append(super.getClass().getName());
            logMessage.append(" textureatlas ").append(textureAtlas != null ? "yes" : "no");
            logMessage.append(" maxSharedVertexCount ").append(n);
            logMessage.append(" (").append(n * vertexFormat.getVertexSize()).append(" bytes)");
            if (n2 > 0) {
                logMessage.append(" maxSharedIndexCount ").append(n2);
                logMessage.append(" (").append(n2 * AbstractGeometryBuffer.getIndexSize(this.getIndexFormat())).append(" bytes)");
            }
            logMessage.log();
        }
    }

    @Override
    public void dispose() {
        if (LOCKING) {
            Graphics3D graphics3D = this.getGraphics3D();
            graphics3D.removeListener(this);
        }
        this.textureAtlas.dispose();
        this.meshHeap.dispose();
        super.dispose();
    }

    protected abstract VertexFormat getVertexFormat() {
    }

    protected abstract int getIndexFormat() {
    }

    public final TextureAtlas getTextureAtlas() {
        return this.textureAtlas;
    }

    public final MeshHeap getMeshHeap() {
        return this.meshHeap;
    }

    @Override
    public final void beginFrame(Graphics3D graphics3D) {
        if (LOCKING) {
            this.swapLocks();
        }
    }

    @Override
    public final void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
    }

    @Override
    public final void endFrame(Graphics3D graphics3D) {
        Logger logger;
        if (LOCKING && (logger = this.getLogger()).isTraceEnabled(512) && logger.isTraceEnabled(64)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".endFrame(): subMeshLocks ").append(this.subMeshLocks[this.currentLocksIndex].size());
            logMessage.append(" subTextureLocks ").append(this.subTextureLocks[this.currentLocksIndex].size());
            logMessage.log();
        }
    }

    private void initLocks() {
        int n;
        this.subMeshLocks = new LongObjectMap[2];
        for (n = 0; n < this.subMeshLocks.length; ++n) {
            this.subMeshLocks[n] = new LongObjectOptHashMap(250);
        }
        this.subTextureLocks = new LongObjectMap[2];
        for (n = 0; n < this.subTextureLocks.length; ++n) {
            this.subTextureLocks[n] = new LongObjectOptHashMap(250);
        }
        this.currentLocksIndex = 0;
    }

    protected final void waitLocks() {
        if (LOCKING) {
            int n;
            Graphics3D graphics3D = this.getGraphics3D();
            graphics3D.flush();
            for (n = 0; n < this.subMeshLocks.length; ++n) {
                this.subMeshLocks[n].clear();
            }
            this.meshHeap.unlockAllSubMeshes();
            for (n = 0; n < this.subTextureLocks.length; ++n) {
                this.subTextureLocks[n].clear();
            }
            this.textureAtlas.unlockAllSubTextures();
        }
    }

    private void swapLocks() {
        Object object;
        LongObjectMap longObjectMap = this.subMeshLocks[this.currentLocksIndex];
        LongObjectMap longObjectMap2 = this.subTextureLocks[this.currentLocksIndex];
        ++this.currentLocksIndex;
        this.currentLocksIndex %= 2;
        LongObjectMap longObjectMap3 = this.subMeshLocks[this.currentLocksIndex];
        Iterator iterator = longObjectMap3.valueIterator();
        while (iterator.hasNext()) {
            object = (MeshHeap$SubMesh)iterator.next();
            if (longObjectMap.containsKey(((MeshHeap$SubMesh)object).getId())) continue;
            this.meshHeap.unlockSubMesh((MeshHeap$SubMesh)object);
        }
        longObjectMap3.clear();
        object = this.subTextureLocks[this.currentLocksIndex];
        Iterator iterator2 = object.valueIterator();
        while (iterator2.hasNext()) {
            TextureAtlas$SubTexture textureAtlas$SubTexture = (TextureAtlas$SubTexture)iterator2.next();
            if (longObjectMap2.containsKey(textureAtlas$SubTexture.getId())) continue;
            this.textureAtlas.unlockSubTexture(textureAtlas$SubTexture);
        }
        object.clear();
    }

    protected final void lockSubMesh(MeshHeap$SubMesh meshHeap$SubMesh) {
        LongObjectMap longObjectMap = this.subMeshLocks[this.currentLocksIndex];
        if (longObjectMap.put(meshHeap$SubMesh.getId(), meshHeap$SubMesh) == null) {
            this.meshHeap.lockSubMesh(meshHeap$SubMesh);
        }
    }

    protected final boolean isSubMeshLocked(MeshHeap$SubMesh meshHeap$SubMesh) {
        for (int i2 = 0; i2 < 2; ++i2) {
            if (!this.subMeshLocks[i2].containsKey(meshHeap$SubMesh.getId())) continue;
            return true;
        }
        return false;
    }

    protected final void lockSubTextures(List list) {
        LongObjectMap longObjectMap = this.subTextureLocks[this.currentLocksIndex];
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            TextureAtlas$SubTexture textureAtlas$SubTexture = (TextureAtlas$SubTexture)list.get(i2);
            if (textureAtlas$SubTexture == null || longObjectMap.put(textureAtlas$SubTexture.getId(), textureAtlas$SubTexture) != null) continue;
            this.textureAtlas.lockSubTexture(textureAtlas$SubTexture);
        }
    }

    protected final void addMapping(List list, MeshHeap$SubMesh meshHeap$SubMesh) {
        for (int i2 = list.size() - 1; i2 >= 0; --i2) {
            TextureAtlas$SubTexture textureAtlas$SubTexture = (TextureAtlas$SubTexture)list.get(i2);
            if (textureAtlas$SubTexture == null) continue;
            LongObjectMap longObjectMap = (LongObjectMap)this.subTextureToSubMeshIndex.get(textureAtlas$SubTexture.getId());
            if (longObjectMap == null) {
                longObjectMap = new LongObjectOptHashMap(25);
                this.subTextureToSubMeshIndex.put(textureAtlas$SubTexture.getId(), longObjectMap);
            }
            MeshHeap$SubMesh meshHeap$SubMesh2 = (MeshHeap$SubMesh)longObjectMap.put(meshHeap$SubMesh.getId(), meshHeap$SubMesh);
        }
    }

    protected final void removeMapping(MeshHeap$SubMesh meshHeap$SubMesh) {
        Object[] objectArray = this.subTextureToSubMeshIndex.valuesToArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            LongObjectMap longObjectMap = (LongObjectMap)objectArray[i2];
            longObjectMap.remove(meshHeap$SubMesh.getId());
        }
    }

    @Override
    public final void subTextureRemoved(TextureAtlas$SubTexture textureAtlas$SubTexture) {
        LongObjectMap longObjectMap = (LongObjectMap)this.subTextureToSubMeshIndex.get(textureAtlas$SubTexture.getId());
        Logger logger = this.getLogger();
        if (longObjectMap != null) {
            Object[] objectArray = longObjectMap.valuesToArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                MeshHeap$SubMesh meshHeap$SubMesh = (MeshHeap$SubMesh)objectArray[i2];
                if (this.meshHeap.removeSubMesh(meshHeap$SubMesh) || !logger.isTraceEnabled(512)) continue;
                LogMessage logMessage = logger.trace(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".removeMapping(): Cannot remove locked submesh ").append(meshHeap$SubMesh).append(" for subtexture ").append(textureAtlas$SubTexture);
                logMessage.log();
            }
            longObjectMap.clear();
            this.subTextureToSubMeshIndex.remove(textureAtlas$SubTexture.getId());
            if (logger.isTraceEnabled(512) && logger.isTraceEnabled(64)) {
                LogMessage logMessage = logger.trace(512);
                logMessage.append(super.getClass().getName());
                logMessage.append(".subTextureToSubMeshIndex.size() = ").append(this.subTextureToSubMeshIndex.size());
                logMessage.log();
            }
        } else if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".removeMapping(): No mapping for subtexture - ignoring ").append(textureAtlas$SubTexture);
            logMessage.log();
        }
    }

    @Override
    public final void subMeshRemoved(MeshHeap$SubMesh meshHeap$SubMesh) {
        Logger logger = this.getLogger();
        List list = (List)this.subMeshToDrawableIndex.get(meshHeap$SubMesh.getId());
        if (list != null) {
            for (int i2 = list.size() - 1; i2 >= 0; --i2) {
                AbstractSharedDrawableRenderer$AbstractSharedDrawable abstractSharedDrawableRenderer$AbstractSharedDrawable = (AbstractSharedDrawableRenderer$AbstractSharedDrawable)list.get(i2);
                if (abstractSharedDrawableRenderer$AbstractSharedDrawable != null) {
                    if (logger.isTraceEnabled(512)) {
                        LogMessage logMessage = logger.trace(512);
                        logMessage.append(super.getClass().getName());
                        logMessage.append(".subMeshRemoved(): Removed submesh ").append(meshHeap$SubMesh).append(" from drawable ").append(abstractSharedDrawableRenderer$AbstractSharedDrawable);
                        logMessage.log();
                    }
                    abstractSharedDrawableRenderer$AbstractSharedDrawable.invalidateGeometry();
                    continue;
                }
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
            }
            list.clear();
            this.subMeshToDrawableIndex.remove(meshHeap$SubMesh.getId());
        }
        if (this.textureAtlas != null) {
            this.removeMapping(meshHeap$SubMesh);
        }
    }

    public final void addSubMeshReference(MeshHeap$SubMesh meshHeap$SubMesh, AbstractSharedDrawableRenderer$AbstractSharedDrawable abstractSharedDrawableRenderer$AbstractSharedDrawable) {
        List list = (List)this.subMeshToDrawableIndex.get(meshHeap$SubMesh.getId());
        if (list == null) {
            list = new ArrayList(10);
            this.subMeshToDrawableIndex.put(meshHeap$SubMesh.getId(), list);
        }
        list.add(abstractSharedDrawableRenderer$AbstractSharedDrawable);
    }

    public final void removeSubMeshReference(MeshHeap$SubMesh meshHeap$SubMesh, AbstractSharedDrawableRenderer$AbstractSharedDrawable abstractSharedDrawableRenderer$AbstractSharedDrawable) {
        Logger logger = this.getLogger();
        List list = (List)this.subMeshToDrawableIndex.get(meshHeap$SubMesh.getId());
        if (list != null) {
            if (!list.remove(abstractSharedDrawableRenderer$AbstractSharedDrawable) && !$assertionsDisabled) {
                throw new AssertionError();
            }
            if (list.isEmpty()) {
                this.subMeshToDrawableIndex.remove(meshHeap$SubMesh.getId());
            }
        } else if (!$assertionsDisabled) {
            throw new AssertionError();
        }
        if (logger.isTraceEnabled(512) && logger.isTraceEnabled(64)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".drawableIndex.size() = ").append(this.subMeshToDrawableIndex.size());
            logMessage.log();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$internal$drawable$renderer$AbstractSharedDrawableRenderer == null ? (class$de$vw$mib$graphics$internal$drawable$renderer$AbstractSharedDrawableRenderer = AbstractSharedDrawableRenderer.class$("de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer")) : class$de$vw$mib$graphics$internal$drawable$renderer$AbstractSharedDrawableRenderer).desiredAssertionStatus();
        TEXEL_CENTER_OFFSET = System.getProperty("de.vw.mib.graphics.renderer.adjusttexcoords") != null ? 63 : (int)0.0f;
        LOCKING = System.getProperty("de.vw.mib.graphics.renderer.locks") != null;
    }
}

