package de.htwg.seapal.database.mock;

import com.google.common.collect.ImmutableList;
import de.htwg.seapal.database.IBoatDatabase;
import de.htwg.seapal.model.IBoat;
import de.htwg.seapal.model.impl.Boat;

import java.util.*;

public class BoatDatabase implements IBoatDatabase {

	Map<UUID, IBoat> db = new HashMap<UUID, IBoat>();
	private IBoat newBoat;

	public BoatDatabase() {
		open();
	}

	@Override
	public boolean open() {
		// create test data
		UUID id = createNewBoatInDatabase();
		newBoat = get(id);
		newBoat.setBoatName("Boat-NEW");
		save(newBoat);
		for (int i = 1; i < 10; i++) {
			id = createNewBoatInDatabase();
			IBoat boat = get(id);
			boat.setBoatName("Boat-" + i);
			save(boat);
		}
		return true;
	}

	@Override
	public boolean close() {
		return true;
	}
    @Override
    public List<? extends IBoat> queryViews(final String viewName, final String key) {
        return null;
    }

    @Override
	public UUID create() {
		return newBoat.getUUID();
	}

    private UUID createNewBoatInDatabase() {
		IBoat boat = new Boat();
		boat.setRegisterNr("AB7737");
		boat.setType("Yacht");
		UUID id = boat.getUUID();
		db.put(id, boat);
		return id;
	}

	@Override
	public boolean save(IBoat boat) {
		return true;
	}

	@Override
	public void delete(UUID id) {
	}

	@Override
	public IBoat get(UUID id) {
		return new Boat(db.get(id));
	}

	@Override
	public List<IBoat> loadAll() {
		return ImmutableList.copyOf(db.values());
	}
}
