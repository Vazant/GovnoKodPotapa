public class 	CastOneLineCommand implements Command {
	private Plugins plugins;
	FileProcessing fp = new FileProcessing();
	public CastOneLineCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() {
		plugins.CastOneLine(fp.text);
	}
}
