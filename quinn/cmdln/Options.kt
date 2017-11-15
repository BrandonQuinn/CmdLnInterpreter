package quinn.cmdln

class Options
{
	val options: MutableList<Option> = mutableListOf()
			
	fun addOption(option: Option)
	{
		options.add(option)
	}
	
	fun printHelp()
	{
		for (op in options) {
			println("-" + op.option + "(" + op.optionLong + "): "
				+ op.argc + "\n\t" + op.description)
		}
	}
}