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
	
	//��������KNNData֮��ľ���
	public static double disCal(KNNData ki,KNNData kd)
	{
		return Math.sqrt((ki.c1-kd.c1)*(ki.c1-kd.c1)
				+(ki.c2-kd.c2)*(ki.c2-kd.c2)
				+(ki.c3-kd.c3)*(ki.c3-kd.c3));
	}
	
	//����KNNData�����г��ִ����������ݵ�����
	public static String getMaxValueKey(int k,List<KNNData> kd)
	{
		//ȡk��ѵ����
		while(kd.size()!=k)
		{
			kd.remove(k);
		}
		for(int i=0;i<k;i++)
		  System.out.println(kd.get(i).type);
		
		String sKey=null;
		//����һ��HashMap��String��Ӧѵ���������ͣ�Integer��Ӧ�����ͳ��ֵĴ���
		HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
		hashMap.put(kd.get(0).type,1);
		for(int i=1;i<kd.size();i++)
		{
			//��i��ѵ����������
			sKey=kd.get(i).type;	
			if(hashMap.containsKey(sKey))
			{
				//���map���Ѿ��г��ֹ��������ͣ�Key��,�ڸ�key��Ӧ��Integer+1
				hashMap.put(sKey, hashMap.get(sKey)+1);	
			}
			else{
				//���map��û�г��ֹ��������ͣ�key�������key��Ӧ��Integer��1
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
 			//ȡInteger���ʱ��Ӧ��key
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
		//����KNNData��list����
		for(KNNData ks:kd)
		{
			//��ȡ���Ե���ѵ������ÿ����ľ���
			ks.distance=disCal(ki,ks);
		}
		//��kd���վ����С��������
		Collections.sort(kd);  
		return getMaxValueKey(k,kd);
	}
}
