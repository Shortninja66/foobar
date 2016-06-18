package net.shortninja.staffplus;

import net.shortninja.staffplus.command.managers.Permission;
import net.shortninja.staffplus.data.DataManager;
import net.shortninja.staffplus.data.config.Messages;
import net.shortninja.staffplus.data.config.Options;
import net.shortninja.staffplus.data.file.ChangelogFile;
import net.shortninja.staffplus.data.file.LanguageFile;
import net.shortninja.staffplus.util.Message;

import org.bukkit.plugin.java.JavaPlugin;

//TODO: NodeUser (easy user to string saving)
//TODO: hasPermission().sendMessage
//TODO: Change file class

public class StaffPlus extends JavaPlugin
{
	private static StaffPlus plugin;
	
	public Options options;
	public DataManager dataManager;
	public Permission permission;
	public Message message;
    public LanguageFile languageFile;
	public Messages messages;
	
	@Override
	public void onEnable()
	{
		plugin = this;
		message = new Message();
		start(System.currentTimeMillis());
	}
	
	@Override
	public void onDisable()
	{
		plugin = null;
	}
	
	public static StaffPlus get()
	{
		return plugin;
	}
	
	private void start(long start)
	{
		message = new Message();
		options = new Options();
		dataManager = new DataManager();
		permission = new Permission();
		new ChangelogFile();
		languageFile = new LanguageFile();
		languageFile.setup();
		
		message.sendConsoleMessage("Staff+ has been enabled! Initialization took " + (System.currentTimeMillis() - start) + "ms.", false);
		message.sendConsoleMessage("Plugin created by Shortninja.", false);
	}
	
	private void stop()
	{
		
	}
}