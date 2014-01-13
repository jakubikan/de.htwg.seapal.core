package de.htwg.seapal.model;

import java.util.List;
import java.util.UUID;

public interface IRoute extends IModel {

	String getName();

	void setName(String name);

	Long getDate();

	void setDate(Long date);

	List<Double> getMarks();

	void addMark(UUID mark);

	void deleteMark(UUID mark);

	UUID getRouteEntryPoint();

	void setRouteEntryPoint(UUID mark);

	Double getDistance();

	void setDistance(Double distance);

    void setMarks(List<Double> marks);

    void setRouteEntryPoint(String routeEntryPoint);
}
