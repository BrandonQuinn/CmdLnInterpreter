package quinn.cmdln

class Option(op: String, opShort: String, desc: String, argc: Int)
{
	var optionLong: String = ""
	var option: String = ""
	var description: String = ""
	var argc: Int

	init
	{
		this.option = opShort
		this.optionLong = op
		this.description = desc
		this.argc = argc
	}
}