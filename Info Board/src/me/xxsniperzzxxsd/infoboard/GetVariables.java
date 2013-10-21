
package me.xxsniperzzxxsd.infoboard;

import me.xxsniperzzxxsd.infoboard.Variables.EssentialsVariables;
import me.xxsniperzzxxsd.infoboard.Variables.FactionsVariables;
import me.xxsniperzzxxsd.infoboard.Variables.InfectedVariables;
import me.xxsniperzzxxsd.infoboard.Variables.JobsVariables;
import me.xxsniperzzxxsd.infoboard.Variables.LWCVariables;
import me.xxsniperzzxxsd.infoboard.Variables.McTownsVariables;
import me.xxsniperzzxxsd.infoboard.Variables.PlayerVariables;
import me.xxsniperzzxxsd.infoboard.Variables.PlotMeVariables;
import me.xxsniperzzxxsd.infoboard.Variables.ServerVariables;
import me.xxsniperzzxxsd.infoboard.Variables.TownyVariables;
import me.xxsniperzzxxsd.infoboard.Variables.VaultVariables;
import me.xxsniperzzxxsd.infoboard.Variables.mcMMOVariables;
import me.xxsniperzzxxsd.infoboard.Variables.ALTVariables;
import me.xxsniperzzxxsd.infoboard.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class GetVariables {

	public static String replaceVariables(String string, Player player) {
		String newString = "Hi";
		newString = string;

		// Server Variables
		newString = ServerVariables.replaceVariables(newString);

		// Player Variables
		newString = PlayerVariables.replaceVariables(newString, player);

		// Infected Support
		if (Bukkit.getServer().getPluginManager().getPlugin("Infected") != null)
			if (newString.contains("<infected"))
				newString = InfectedVariables.replaceVariables(newString, player);

		// Essentials Support
		if (Bukkit.getServer().getPluginManager().getPlugin("Essentials") != null)
			if (newString.contains("<ess"))
				newString = EssentialsVariables.replaceVariables(newString, player);

		// LWC Support
		if (Bukkit.getServer().getPluginManager().getPlugin("LWC") != null)
			if (newString.contains("<lwc"))
				newString = LWCVariables.replaceVariables(newString, player);

		// McTowns Support
		if (Bukkit.getServer().getPluginManager().getPlugin("MCTowns") != null)
			if (newString.contains("<mctowns"))
				newString = McTownsVariables.replaceVariables(newString, player);

		// Towny Support
		if (Bukkit.getServer().getPluginManager().getPlugin("Towny") != null)
			if (newString.contains("<towny"))
				newString = TownyVariables.replaceVariables(newString, player);

		// Factions Support
		if (Bukkit.getServer().getPluginManager().getPlugin("Factions") != null)
			if (newString.contains("<factions"))
				newString = FactionsVariables.replaceVariables(newString, player);

		// mcMMO Support
		if (Bukkit.getServer().getPluginManager().getPlugin("mcMMO") != null)
			if (newString.contains("<mcmmo"))
				newString = mcMMOVariables.replaceVariables(newString, player);

		// Vault Support
		if (Bukkit.getServer().getPluginManager().getPlugin("Vault") != null)
			if (newString.contains("<vault") || newString.contains("<rank") || newString.contains("<money"))
				newString = VaultVariables.replaceVariables(newString, player);

		// Jobs Support
		if (Bukkit.getServer().getPluginManager().getPlugin("Jobs") != null)
			if (newString.contains("<jobs"))
				newString = JobsVariables.replaceVariables(newString, player);


		// PlotMe Support
		if (Bukkit.getServer().getPluginManager().getPlugin("PlotMe") != null)
			if (newString.contains("<plotme"))
				newString = PlotMeVariables.replaceVariables(newString, player);

		// UTF-8
		newString = ALTVariables.replaceVariables(newString);

		// Custom Variables
		for (String custom : Main.config.getConfigurationSection("Custom Variables").getKeys(true)){
				if(newString.contains("<" + custom + ">"))
						newString = newString.replaceAll("<" + custom + ">", ScoreBoard.getLine(Main.config.getString("Custom Variables." + custom), player));
		}

		return newString;
	}
}