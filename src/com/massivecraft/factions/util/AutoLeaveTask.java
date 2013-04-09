package com.massivecraft.factions.util;

import com.massivecraft.factions.Conf;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Factions;

public class AutoLeaveTask implements Runnable
{
	double rate;

	public AutoLeaveTask()
	{
		this.rate = Conf.autoLeaveRoutineRunsEveryXMinutes;
	}

	public void run()
	{
		FPlayers.i.autoLeaveOnInactivityRoutine();

		// maybe setting has been changed? if so, restart task at new rate
		if (this.rate != Conf.autoLeaveRoutineRunsEveryXMinutes)
			Factions.get().startAutoLeaveTask(true);
	}
}
