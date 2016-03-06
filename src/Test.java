class Test
{
	public static void main(String[] args)
	{
		NMEA n = new NMEA();
		GPSPosition pos;

		pos=n.parseLine("$GNGLL,4646.13762,N,00737.21678,E,140759.75,A,D*76");
		pos=n.parseLine("$GNGST,140759.75,6.1,,,,0.46,0.29,0.64*57");
		pos=n.parseLine("$GNZDA,140759.75,23,02,2016,00,00*72");
		pos=n.parseLine("$GNRMC,140800.00,A,4646.13684,N,00737.21786,E,15.370,136.28,230216,,,D*43");

		if(pos!=null)
		{
			System.out.println(pos.getCSVHeader());
			System.out.println(pos);
		}
	}
}
