package KNN;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KNN {

	private List<KNNData> KNNDS=null;
	public KNN(List<KNNData> KNNDS)
	{
		this.KNNDS=KNNDS;
	}
	
	//计算两个KNNData之间的距离
	public static double disCal(KNNData ki,KNNData kd)
	{
		return Math.sqrt((ki.c1-kd.c1)*(ki.c1-kd.c1)
				+(ki.c2-kd.c2)*(ki.c2-kd.c2)
				+(ki.c3-kd.c3)*(ki.c3-kd.c3));
	}
	
	//求在KNNData集合中出现次数最多的数据的类型
	public static String getMaxValueKey(int k,List<KNNData> kd)
	{
		//取k个训练集
		while(kd.size()!=k)
		{
			kd.remove(k);
		}
		for(int i=0;i<k;i++)
		  System.out.println(kd.get(i).type);
		
		String sKey=null;
		//创建一个HashMap，String对应训练集的类型，Integer对应该类型出现的次数
		HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
		hashMap.put(kd.get(0).type,1);
		for(int i=1;i<kd.size();i++)
		{
			//第i个训练集的类型
			sKey=kd.get(i).type;	
			if(hashMap.containsKey(sKey))
			{
				//如果map中已经有出现过这种类型（Key）,在该key对应的Integer+1
				hashMap.put(sKey, hashMap.get(sKey)+1);	
			}
			else{
				//如果map中没有出现过这种类型（key），则该key对应的Integer置1
				hashMap.put(sKey,1);
			}
		}
		String mType=null;
		int mValue= 0;
		Set<Map.Entry<String,Integer>> set=hashMap.entrySet();
 		Iterator<Map.Entry<String,Integer>> iter=set.iterator();
		//Iterator<Map.Entry<String,Integer>> iter=hashMap.entrySet().iterator();
 		
 		while(iter.hasNext())
 		{
 			//map.getKey()-String;map.getValue()-Integer
 			Map.Entry<String, Integer> map=iter.next();
 			//取Integer最大时对应的key
 			if(mValue<map.getValue())
 			{
 				mType=map.getKey();
 				mValue=map.getValue();
 			}
 		}			
		return mType;
	}
	
	public static String knnCal(int k,KNNData ki,List<KNNData> kd) {
		// TODO Auto-generated method stub
		//遍历KNNData的list数组
		for(KNNData ks:kd)
		{
			//获取测试点与训练集的每个点的距离
			ks.distance=disCal(ki,ks);
		}
		//将kd按照距离从小到大排列
		Collections.sort(kd);  
		return getMaxValueKey(k,kd);
	}
}
