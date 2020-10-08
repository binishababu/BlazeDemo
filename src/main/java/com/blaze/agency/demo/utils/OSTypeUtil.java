package com.blaze.agency.demo.utils;

public class OSTypeUtil {

	
	public enum OSType{
		windows, mac, linux,
	}
	
	public static OSType getTestOSType(String osType) {
		
		if (osType.toLowerCase().contains("win")) {
			return OSType.windows;
		} else if (osType.toLowerCase().contains("mac")) {
			return OSType.mac;
		}else if (osType.toLowerCase().contains("linux")) {
			return OSType.linux;
		}  else
			return OSType.windows;
	}
}
