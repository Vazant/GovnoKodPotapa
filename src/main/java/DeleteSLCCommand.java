public class DeleteSLCCommand implements  Command {
	private Plugins plugins;

	DeleteSLCCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() { plugins.DeleteSLC(FileProcessing.text);	}
}
