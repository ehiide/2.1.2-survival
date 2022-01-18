package mc.server.survival.files;

import mc.server.survival.utils.ColorUtil;

public class Configuration 
{
	/*
		Prefixes.
	 */

	public static final String SERVER_FULL_PREFIX = ColorUtil.formatHEX("#f83044[Survival] #8c8c8c");
	public static final String SERVER_LOGGING_PREFIX = ColorUtil.formatHEX("#f83044[Autoryzacja] #8c8c8c");
	public static final String CONSOLE_FULL_PREFIX = ColorUtil.formatHEX("&7[Survival] ");

	/*
		Plug-in configuration.
	 */

	public static boolean SERVER_BLOCK_THE_END = false;
	public static boolean SERVER_BLOCK_NETHER = false;
	public static boolean SERVER_TERRAIN_PROTECTION = true;
	public static final int SERVER_SPAWN_PROTECTION = 256;

	public static final int SERVER_TELEPORT_REQUEST_TIME = 60;
	public static final int SERVER_MARRY_REQUEST_TIME = 30;
	public static final int SERVER_GANG_REQUEST_TIME = 30;
}