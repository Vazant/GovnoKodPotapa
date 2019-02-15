public class 	CastOneLineCommand implements Command {
	private Plugins plugins;

	public CastOneLineCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() {
		plugins.CastOneLine(FileProcessing.text);
	}
}
