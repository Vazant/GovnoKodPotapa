public class DeleteExtNewlineCommand implements Command {
    private Plugins plugins;
    FileProcessing fp = new FileProcessing();
    DeleteExtNewlineCommand(Plugins plugins) {
        this.plugins = plugins;
    }

    @Override
    public void execute() {
        plugins.DeleteExtNewline(fp.text);
    }
}
