package quinn.cmdln

class CmdLnParser(args: Array<String>, options: Options)
{
	private var args: Array<String>
	private var options: Options
	
	init
	{
		this.options = options
		this.args = args
	}
	
	/**
	 * Parses raw command line arguments.
	 */
	fun parse(): CmdLn
	{
		val cmdln: CmdLn = CmdLn()
		var cmd: String = ""
		for (str in args) {
			// option or agument?
			if (str.startsWith("-", true)) {
				cmd = str.substring(1)
			}
			
			// if we have a command and currently are looking at an argument add it
			if (cmd != "") {
				val option = optionExists(cmd)
				if (option != false) {
					cmdln.addArg((option as Option).optionLong, str)
				}
				cmd = ""
			}
		}
		return cmdln
	}
	
	/**
	 * Find if there is actually an option set.
	 */
	private fun optionExists(option: String): Any
	{
		for (op in options.options) {
			if (op.option == option || op.optionLong == option) {
				return op
			}
		}
		return false
	}
}