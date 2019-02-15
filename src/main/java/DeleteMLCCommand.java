public class DeleteMLCCommand implements Command{
	private Plugins plugins;

	DeleteMLCCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() { plugins.DeleteMLC(FileProcessing.text);
	}
}
