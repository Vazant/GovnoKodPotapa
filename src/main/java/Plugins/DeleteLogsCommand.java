public class DeleteLogsCommand implements Command {
	private Plugins plugins;
	FileProcessing fp = new FileProcessing();
	DeleteLogsCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() { plugins.DeleteLogs(fp.text);

	}
}
