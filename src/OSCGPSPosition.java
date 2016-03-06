import java.util.List;
import com.illposed.osc.OSCMessage;

//=============================================================================
public class OSCGPSPosition extends ConvertibleGPSPosition
{
/*
/pos hhsfffifffffffsiifff 1456227925005 1457265094441 "20160223" 134525.500000 7.636898 46.907036 2 -1.000000 754.400024 0.054428 0.280000 0.230000 0.780000 0.400000 "D" 7 3 2.360000 1.330000 1.950000
*/

//========================================================================
	public OSCMessage getValuesAsOSCMessage()
	{
		return new OSCMessage("/pos",getValuesAsVector());
	}

//========================================================================
	public void setValuesFromOSCMessage(OSCMessage msg)
	{
		String path=msg.getAddress();
		java.util.List<Object> args=msg.getArguments();
		int argsSize=args.size();

		if(path.equals("/pos") && argsSize==TOKEN_COUNT)
		{
			try
			{
				this.millis_utc=	(Long)		args.get(0);
				this.millis_utc_sys=	(Long)		args.get(1);
				this.date=		(String)	args.get(2);
				this.time=		(Float)		args.get(3);
				this.lon=		(Float)		args.get(4);
				this.lat=		(Float)		args.get(5);
				this.quality=		(Integer)	args.get(6);
				this.direction=		(Float)		args.get(7);
				this.altitude=		(Float)		args.get(8);
				this.velocity=		(Float)		args.get(9);
				this.lat_err=		(Float)		args.get(10);
				this.lon_err=		(Float)		args.get(11);
				this.alt_err=		(Float)		args.get(12);
				this.dgps_age=		(Float)		args.get(13);
				this.mode=		(String)	args.get(14);
				this.sat_in_use=	(Integer)	args.get(15);
				this.fix_type=		(Integer)	args.get(16);
				this.PDOP=		(Float)		args.get(17);
				this.HDOP=		(Float)		args.get(18);
				this.VDOP=		(Float)		args.get(19);
			}
                        catch(Exception e){e.printStackTrace();}
		}//end msg path /pos
	}//end setValuesFromOSCMessage
}//end class OSCGPSPosition
//EOF
