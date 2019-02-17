public class DeleteMLCCommand implements Command{
	private Plugins plugins;
	FileProcessing fp = new FileProcessing();
	DeleteMLCCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() { plugins.DeleteMLC(fp.text);
	}
}
