package de.htwg.seapal.database.mock;

import com.google.common.collect.ImmutableList;
import de.htwg.seapal.database.IMarkDatabase;
import de.htwg.seapal.model.IMark;
import de.htwg.seapal.model.impl.Mark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MarkDatabase implements IMarkDatabase {
	Map<UUID, IMark> db = new HashMap<UUID, IMark>();
	private IMark newMark;

	public MarkDatabase() {
		open();
	}

	@Override
	public boolean open() {
		// create test data
		UUID id = createNewMarkInDatabase();
		newMark = get(id);
		newMark.setName("Mark-NEW");
		save(newMark);
		for (int i = 1; i < 10; i++) {
			id = createNewMarkInDatabase();
			IMark mark = get(id);
			mark.setName("Mark-" + i);
			save(mark);
		}
		return true;
	}

	@Override
	public boolean close() {
		return true;
	}
    @Override
    public List<? extends IMark> queryViews(final String viewName, final String key) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
	public UUID create() {
		return newMark.getUUID();
	}

	private UUID createNewMarkInDatabase() {
		IMark mark = new Mark();
		UUID id = mark.getUUID();
		db.put(id, mark);
		return id;
	}

	@Override
	public boolean save(IMark mark) {
		return true;
	}

	@Override
	public void delete(UUID id) {

	}

	@Override
	public IMark get(UUID id) {
		return new Mark(db.get(id));
	}

	@Override
	public List<IMark> loadAll() {
		return ImmutableList.copyOf(db.values());
	}
}
