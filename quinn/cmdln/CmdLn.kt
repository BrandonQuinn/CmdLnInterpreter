package quinn.cmdln

class CmdLn
{
	/**
	 * First string is the option full length name and the second
	 * is a list of arguments.
	 */
	private var map: MutableMap<String, MutableList<String>> = mutableMapOf()
	
	fun options(): MutableSet<String>
	{
		return map.keys
	}
	
	fun args(optionName: String): MutableList<String>?
	{
		return map.get(optionName)
	}
	
	fun addArg(option: String, arg: String)
	{
		var list: MutableList<String>? = map.get(option)
		if (list == null) map.put(option, mutableListOf(arg))
		else list.add(arg)
	}
}