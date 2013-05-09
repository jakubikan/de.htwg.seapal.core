package de.htwg.seapal.model;

public interface IMark extends IModel {

	String getName();

	void setName(String name);

	double getLatitude();

	void setLatitude(double latitute);

	double getLongitude();

	void setLongitude(double longitude);

	String getNote();

	void setNote(String note);

	int getBTM();

	void setBTM(int btm);

	int getDTM();

	void setDTM(int dtm);

	int getCOG();

	void setCOG(int cog);

	int getSOG();

	void setSOG(int sog);

	long getDate();

	void setDate(long date);

	boolean isRouteMark();

	void setIsRouteMark(boolean isRouteMark);

	void setUser(String user);

	String getUser();

}