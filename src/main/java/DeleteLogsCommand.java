public class DeleteLogsCommand implements Command {
	private Plugins plugins;

	DeleteLogsCommand(Plugins plugins) {
		this.plugins = plugins;
	}

	@Override
	public void execute() { plugins.DeleteLogs(FileProcessing.text);

	}
}
