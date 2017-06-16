package KNN;

public class KNNData implements Comparable<KNNData>{
	double c1;
	double c2;
	double c3;
	double distance;
	String type;
	
	public KNNData(double c1,double c2,double c3,String type)
	{
		this.c1=c1;
		this.c2=c2;
		this.c3=c3;
		this.type=type;
	}

	public int compareTo(KNNData arg0) {
		// TODO Auto-generated method stub
		return Double.valueOf(this.distance)
				.compareTo(Double.valueOf(arg0.distance));
	}
}
