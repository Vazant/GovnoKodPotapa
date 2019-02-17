public class DeleteSLCCommand implements  Command {
	private Plugins plugins;
	FileProcessing fp = new FileProcessing();
	DeleteSLCCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() { plugins.DeleteSLC(fp.text);	}
}
