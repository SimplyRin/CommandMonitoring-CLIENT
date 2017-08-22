package net.simplyrin.the5zigapi.commandmonitoring;

import eu.the5zig.mod.The5zigAPI;
import eu.the5zig.mod.event.ChatSendEvent;
import eu.the5zig.mod.event.EventHandler;
import eu.the5zig.mod.plugin.Plugin;

@Plugin(name = "CommandMonitoring", version = "1.0")
public class CommandMonitoring {

	@EventHandler
	public void onChatSend(ChatSendEvent event) {
		String message = event.getMessage();

		if(message.startsWith("/")) {
			CommandMonitoring.sendMessage(CommandMonitoring.getPrefix() + "&b" + The5zigAPI.getAPI().getGameProfile().getName() + ": &7" + message);
		}
	}

	public static String getPrefix() {
		return "§e[§bCM§e] §r";
	}

	public static void sendMessage(String message) {
		message = message.replaceAll("&", "\u00a7");
		message = message.replaceAll("§", "\u00a7");

		The5zigAPI.getAPI().messagePlayer(message);
	}

}

