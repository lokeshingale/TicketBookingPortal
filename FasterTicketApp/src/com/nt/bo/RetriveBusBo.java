package com.nt.bo;

public class RetriveBusBo {
private String fstation;
private String tstation;
private String Adate;
private String Atime;
private String Ddate;
private String Dtime;

public String getFstation() {
	return fstation;
}

public void setFstation(String fstation) {
	this.fstation = fstation;
}

public String getTstation() {
	return tstation;
}

public void setTstation(String tstation) {
	this.tstation = tstation;
}

public String getAdate() {
	return Adate;
}

public void setAdate(String adate) {
	Adate = adate;
}

public String getAtime() {
	return Atime;
}

public void setAtime(String atime) {
	Atime = atime;
}

public String getDdate() {
	return Ddate;
}

public void setDdate(String ddate) {
	Ddate = ddate;
}

public String getDtime() {
	return Dtime;
}

public void setDtime(String dtime) {
	Dtime = dtime;
}

@Override
public String toString() {
	return "RetriveBusBo [fstation=" + fstation + ", tstation=" + tstation + ", Adate=" + Adate + ", Atime=" + Atime
			+ ", Ddate=" + Ddate + ", Dtime=" + Dtime + "]";
}

}
