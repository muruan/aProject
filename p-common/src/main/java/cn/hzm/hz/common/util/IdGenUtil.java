
package cn.hzm.hz.common.util;

    /**
     * 双重检测锁  模式的单例 ID工具。
     * 
     * 生成的ID可以按时间排序与Twitter需求大致相同
     * ID最好是64bit的为了索引更小且方便存储在像Redis这样的系统中
     * 按照某种用户标识进行逻辑分片解决方案
     *
	 * 41bits 存储毫秒格式的时间
   	 * 10bits 表示逻辑分片ID 原方案是13bits（最多8192个逻辑分片）,这里为了与基于Twitter的策略保持大致一致，改成了10bits
     * 12bits 存储自增序列值 原方案是10bits（最多1024个序列）,这里为了与基于Twitter的策略保持大致一致，改成了12bits(最多4096个序列)
     * @author A
     *
     */
public class IdGenUtil {

	 /**
	  * 时间戳的位数，实际占41位，最高位保持为0，保证long值为正数
	  */
	 private int timestampBitCount = 42;

	 /**
	  * 逻辑分片位数
	  */
	 private int regionBitCount = 10;

	 /**
	  * 逻辑分片的最大数量
	  */
	 private int regionModelVal = 1 << regionBitCount;

	 /**
	  * 序列位数
	  */
	 private int sequenceBitCount = 12;

	 /**
	  * 总的位数
	  */
	 private int totalBitCount = timestampBitCount + regionBitCount + sequenceBitCount;

	 /**
	  * 当前序列值
	  */
	 private long sequence = 0;

	 /**
	  * 最后一次请求时间戳
	  */
	 private long lastTimestamp = -1L;

	 /**
	  * 序列的位板
	  */
	 private long sequenceMask = -1L ^ (-1L << sequenceBitCount);

	 /**
	  * 最后一次请求用户标识
	  */
	 private long lastTag=1L;

	 private IdGenUtil() {

	 }
	 private static volatile IdGenUtil instance = null;
	 
	 public static IdGenUtil getInstance(){
		 if(instance == null){
			 synchronized (IdGenUtil.class) {
				if(instance == null){
					instance = new IdGenUtil();
				}
			}
		 }
		 return instance;
	 }

	 /*public IdGenUtil(long seq) {
	  if (seq < 0) {
	   seq = 0;
	  }
	  this.sequence = seq;
	 }*/

	 public synchronized long nextId(long tag) {
	  long timestamp = timeGen();


	  if(tag<0){
	   tag=-tag;
	  }

	  if (timestamp < lastTimestamp) {
	  // LOG.error(String.format("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp));
	   throw new RuntimeException(String.format(
	     "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
	  }

	  if (lastTimestamp == timestamp) {
	   sequence = (sequence + 1) & sequenceMask;
	   if (sequence == 0) {
	    timestamp = tilNextMillis(lastTimestamp);
	   }
	  } else {
	   sequence = 0L;
	  }

	  if(tag==lastTag){
	   sequence = (sequence + 1) & sequenceMask;
	   if (sequence == 0) {
	    timestamp = tilNextMillis(lastTimestamp);
	   }
	  }
	  lastTag=tag;

	  lastTimestamp = timestamp;

	  return (timestamp << (totalBitCount - timestampBitCount))
	    | ((tag % regionModelVal) << (totalBitCount - timestampBitCount - regionBitCount)) | sequence;
	 }
	 
	 private long tilNextMillis(final long lastTimestamp) {
	  
		 long timestamp = this.timeGen();
		 while (timestamp <= lastTimestamp) {
		      timestamp = this.timeGen();	 
		 }
		   return timestamp;		 
	}
		
		
	 private long timeGen() {
	  return System.currentTimeMillis();
	}

}