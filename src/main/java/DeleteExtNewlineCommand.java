public class DeleteExtNewlineCommand implements Command {
    private Plugins plugins;

    DeleteExtNewlineCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteExtNewline(FileProcessing.text);
    }
}
