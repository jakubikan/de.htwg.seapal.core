package de.htwg.seapal.controller.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.inject.Inject;

import android.location.Location;
import de.htwg.seapal.controller.IWaypointController;
import de.htwg.seapal.database.IWaypointDatabase;
import de.htwg.seapal.model.IWaypoint;
import de.htwg.seapal.model.IWaypoint.ForeSail;
import de.htwg.seapal.model.IWaypoint.MainSail;
import de.htwg.seapal.model.IWaypoint.Maneuver;
import de.htwg.seapal.utils.observer.Observable;
import de.htwg.seapal.utils.logging.ILogger;

public class WaypointController extends Observable implements
		IWaypointController {

	/** 
	 * Controller handling the persistence. 
	 */
	private final IWaypointDatabase db;
	private final ILogger logger;

	/**
	 * Creates an instance with a waypoint. Only for generalized classes.
	 * 
	 * @param p Waypoint
	 *            the waypoint.
	 */
	@Inject
	public WaypointController(IWaypointDatabase db, ILogger logger) {
		this.db = db;
		this.logger = logger;
	}

	@Override
	public final String getName(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return null;
		return waypoint.getName();
	}

	@Override
	public double getLatitude(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return -1;
		return waypoint.getLatitude();
	}

	@Override
	public double getLongitude(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return -1;
		return waypoint.getLongitude();
	}

	@Override
	public final String getNote(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return null;
		return waypoint.getNote();
	}

	@Override
	public final int getBTM(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return -1;
		return waypoint.getBTM();
	}

	@Override
	public final int getDTM(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return -1;
		return waypoint.getDTM();
	}

	@Override
	public final int getCOG(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return -1;
		return waypoint.getCOG();
	}

	@Override
	public final int getSOG(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return -1;
		return waypoint.getSOG();
	}

	@Override
	public final UUID getHeadedFor(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return null;
		return UUID.fromString(waypoint.getHeadedFor());
	}

	@Override
	public final Maneuver getManeuver(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return null;
		return waypoint.getManeuver();
	}

	@Override
	public final ForeSail getForesail(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return null;
		return waypoint.getForesail();
	}

	@Override
	public final MainSail getMainsail(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return null;
		return waypoint.getMainsail();
	}

	@Override
	public final void setForesail(UUID id, final ForeSail foreSail) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setForesail(foreSail);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setName(UUID id, final String name) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setName(name);
		db.save(waypoint);
		notifyObservers();

	}

	@Override
	public void setLatitude(UUID id, double latitude) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setLatitude(latitude);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public void setLongitude(UUID id, double longitude) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setLongitude(longitude);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setNote(UUID id, final String note) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setNote(note);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setBTM(UUID id, final int btm) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setBTM(btm);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setDTM(UUID id, final int dtm) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setDTM(dtm);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setCOG(UUID id, final int cog) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setCOG(cog);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setSOG(UUID id, final int sog) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setSOG(sog);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setHeadedFor(UUID id, final UUID markId) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setHeadedFor(markId);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setManeuver(UUID id, final Maneuver maneuver) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setManeuver(maneuver);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final void setMainsail(UUID id, final MainSail mainSail) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return;
		waypoint.setMainsail(mainSail);
		db.save(waypoint);
		notifyObservers();
	}

	@Override
	public final String getString(UUID id) {
		IWaypoint waypoint = db.get(id);
		if (waypoint == null)
			return null;
		return "Waypoint:" + waypoint.toString();
	}

	@Override
	public final UUID newWaypoint(UUID trip) {
		UUID newWaypoint = db.create();
		IWaypoint waypoint = db.get(newWaypoint);
		waypoint.setTrip(trip.toString());
		db.save(waypoint);
		notifyObservers();
		return newWaypoint;
	}

	@Override
	public final UUID newWaypoint(UUID trip, Location location, long date) {
		UUID newWaypoint = db.create();
		IWaypoint waypoint = db.get(newWaypoint);
		waypoint.setTrip(trip.toString());
		waypoint.setLatitude(location.getLatitude());
		waypoint.setLongitude(location.getLongitude());
		waypoint.setDate(date);
		DateFormat format = SimpleDateFormat.getDateTimeInstance();
		waypoint.setName(format.format(date * 1000));
		db.save(waypoint);
		notifyObservers();
		return newWaypoint;
	}

	@Override
	public final void deleteWaypoint(UUID id) {
		db.delete(id);
		notifyObservers();
	}

	@Override
	public final void closeDB() {
		db.close();
		logger.info("WaypointController", "Database closed");
	}

	@Override
	public final List<UUID> getWaypoints() {
		List<IWaypoint> waypoints = db.getAll();
		List<UUID> waypointIDs = new ArrayList<UUID>();
		for (IWaypoint waypoint : waypoints) {
			waypointIDs.add(UUID.fromString(waypoint.getId()));
		}
		return waypointIDs;
	}

	@Override
	public List<UUID> getWaypoints(UUID tripId) {
		List<IWaypoint> waypoints = db.getAll();
		// TODO: filtering should be moved to database layer.
		List<UUID> waypointIDs = new ArrayList<UUID>();
		for (IWaypoint waypoint : waypoints) {
			if (waypoint.getTrip().equals(tripId.toString()))
				waypointIDs.add(UUID.fromString(waypoint.getId()));
		}
		return waypointIDs;
	}

	@Override
	public List<IWaypoint> getAllWaypoints() {
		return db.getAll();
	}

	@Override
	public List<IWaypoint> getAllWaypoints(UUID tripId) {
		List<IWaypoint> waypoints = db.getAll();
		logger.info("TripController", waypoints.toString());
		// TODO: filtering should be moved to database layer.
		for (int i = waypoints.size() - 1; i >= 0; ++i) {
			if (!waypoints.get(i).getTrip().equals(tripId.toString())) {
				waypoints.remove(i);
			}
		}
		return waypoints;
	}

}