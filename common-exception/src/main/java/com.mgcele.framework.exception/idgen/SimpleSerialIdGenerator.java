package com.mgcele.framework.exception.idgen;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author mgcele on 2017/4/29.
 */
public class SimpleSerialIdGenerator implements IdentifierGenerator<Long>{

    private long maxValue;
    private Object seed = new Object();
    private final Map<Object, AtomicLong> valueMap = new HashMap();

    public SimpleSerialIdGenerator(long maxValue)
    {
        this.maxValue = maxValue;
    }

    public long getMaxValue()
    {
        return this.maxValue;
    }

    private Long getSerialId(Object seed)
    {
        AtomicLong value;
        synchronized (this.valueMap)
        {
            value = this.valueMap.get(seed);
            if (value == null)
            {
                value = new AtomicLong(0L);
                this.valueMap.put(seed, value);
            }
        }
        synchronized (value)
        {
            long l = value.addAndGet(1L);
            if (l >= this.maxValue) {
                value.set(0L);
            }
            return l;
        }
    }

    public void clear(Object seed)
    {
        synchronized (this.valueMap)
        {
            AtomicLong value = (AtomicLong)this.valueMap.get(seed);
            if ((value == null) || (value.get() == 0L)) {
                return;
            }
            this.valueMap.put(seed, new AtomicLong(0L));
        }
    }

    public void clearAll()
    {
        synchronized (this.valueMap)
        {
            this.valueMap.clear();
        }
    }

    public Long generate()
    {
        return getSerialId(this.seed);
    }

}
