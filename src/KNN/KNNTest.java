package KNN;

import java.util.ArrayList;
import java.util.List;

public class KNNTest {
	
	public static void main(String[] args)
	{
		List<KNNData> kd=new ArrayList<KNNData>();
		//训练集
        kd.add(new KNNData(1.2,1.1,0.1,"A"));
        kd.add(new KNNData(1.2,1.1,0.1,"A"));
        kd.add(new KNNData(7,1.5,0.1,"B"));
        kd.add(new KNNData(6,1.2,0.1,"B"));
        kd.add(new KNNData(2,2.6,0.1,"C"));
        kd.add(new KNNData(2,2.6,0.1,"C"));
        kd.add(new KNNData(2,2.6,0.1,"C"));
        kd.add(new KNNData(100,1.1,0.1,"D"));
     
        System.out.println("结果为："+KNN.knnCal(3,new KNNData(1.1,1.1,0.1,"N/A"),kd));
	}	
}