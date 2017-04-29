package com.mgcele.framework.exception.utils;

import com.mgcele.framework.exception.idgen.SimpleSerialIdGenerator;
import com.mgcele.framework.system.SystemProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;

/**
 * @author mgcele on 2017/4/29.
 */
public class ExceptionTraceIdGenerator {

    private static final int ROLLSEED = 4095;
    private static final Object IDKEY = new Object();
    private SimpleSerialIdGenerator serialIdGenerator;
    private static ExceptionTraceIdGenerator traceIdGenerator;

    private ExceptionTraceIdGenerator()
    {
        this.serialIdGenerator = new SimpleSerialIdGenerator(4095L);
    }

    public static ExceptionTraceIdGenerator getInstance()
    {
        if (traceIdGenerator != null) {
            return traceIdGenerator;
        }
        synchronized (IDKEY)
        {
            traceIdGenerator = new ExceptionTraceIdGenerator();
        }
        return traceIdGenerator;
    }

    public String getTraceId()
    {
        StringBuilder sb = new StringBuilder();

        String stname = SystemProperty.getInstance().getSysName();
        String machineid = SystemProperty.getInstance().getMachineID();

        String unknowndefault = "n/a";

        sb.append((stname == null ? unknowndefault : stname) + "-" + (machineid == null ? unknowndefault : machineid) + "-");
        synchronized (IDKEY)
        {
            Calendar current = Calendar.getInstance();
            int curDate = current.get(6);

            int curHour = current.get(11);
            int _curHourLength = 5;

            int curMin = current.get(12);
            int _curMinLength = 6;

            curDate <<= _curHourLength + _curMinLength;
            curHour <<= _curMinLength;

            int curStamp = curDate + curHour + curMin;

            String curStampHEX = Integer.toHexString(curStamp);
            curStampHEX = StringUtils.leftPad(curStampHEX, 5, "0");

            int result = this.serialIdGenerator.generate().intValue();
            String strSerial = Integer.toHexString(result);
            strSerial = StringUtils.leftPad(strSerial, 3, "0");

            sb.append(curStampHEX + "-" + strSerial);
        }
        return sb.toString().toUpperCase();
    }

}
